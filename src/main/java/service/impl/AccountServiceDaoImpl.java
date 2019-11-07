package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IAccountDao;
import entity.Account;
import service.prototype.IAccountService;
import util.Pager;


@Service("accountServiceDaoImpl")
public class AccountServiceDaoImpl implements IAccountService{
    
	@Autowired
	private IAccountDao actDao;
	
	@Override  //设计到事务Spring声明的transaction处理(AOP动态代理模式应用)
	public void transfer(Account from, Account to, double money) {
		
		
	}

	@Override
	public Account searchAccount(int id) {
		
		return actDao.find(id);
	}



	@Override
	public Pager<Account> findPaged(int pageNo, int PageSize) {
		int totalItems=actDao.totalItems();
		int pageNum=(totalItems+PageSize-1)/PageSize;
		if(pageNo>pageNum) {
			pageNo=pageNum;
		}
	    Pager<Account> pager=actDao.findPaged((pageNo-1)*PageSize, PageSize);
		pager.setTotal(pageNum);
		return pager;
	}

	@Override
	public List<Account> listPaged(int pageNo, int PageSize) {
		
		return actDao.find((pageNo-1)*PageSize, PageSize);
	}

}
