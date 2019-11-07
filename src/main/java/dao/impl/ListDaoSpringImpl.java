package dao.impl;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IUserDao;
import entity.User;

@Repository
public class ListDaoSpringImpl implements IUserDao{
    @Autowired
	private JdbcTemplate jt;
	@Override
	public List<User> find(int offset, int pageSize) {
		// TODO Auto-generated method stub
		return jt.query("select * from user limit ?,?", new Object[] {offset,pageSize},new BeanPropertyRowMapper<User>(User.class) {
			
		
		});
	}

}
