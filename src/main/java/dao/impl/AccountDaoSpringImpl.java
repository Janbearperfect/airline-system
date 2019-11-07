package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IAccountDao;
import entity.Account;
import util.Pager;

/*
 * AccountDao实现类
 * */

@Repository
public class AccountDaoSpringImpl implements IAccountDao{
     
	@Autowired
	private JdbcTemplate  jdbcTemplate;
	@Override
	public Account find(int id) {
		
		return jdbcTemplate.queryForObject("select * from account where id=?", 
				new Object[] {id},//参数
				new BeanPropertyRowMapper<Account>(Account.class));//转化规则
	}

	@Override
	public void saveOrUpdate(Account act) {
		  if(act.getId()==0) {
		    	jdbcTemplate.update("insert into account(name,balance) values(?,?)",
		    			new Object[] {act.getName(),act.getBalance()});
		    }else {
		    	jdbcTemplate.update("update account set name=?,balance=? where id=?",
		    			new Object[] {act.getName(),act.getBalance(),act.getId()});
		    }
		
	}

	@Override
	public List<Account> findAll() {
		return find(0,Integer.MAX_VALUE);
		
		
	}

	
	@Override
	public List<Account> find(int offset, int pageSize) {
		
		return jdbcTemplate.query("select * from account limit ?,?",
				new Object[] {offset,pageSize},new BeanPropertyRowMapper(Account.class));
	}

	@Override
	public Pager<Account> findPaged(int offset, int pageSize) {
		   Pager<Account> pager=new Pager<Account>();
		    pager.setData(find(offset,pageSize));
			return pager;
	}

	@Override
	public int totalItems() {
	
		return jdbcTemplate.queryForObject("select count(*) from account",
				new java.lang.Object[] {},Integer.class);
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update("delete from account where id=?", new Object[] {id});
		
	}

}
