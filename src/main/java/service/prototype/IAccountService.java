package service.prototype;

import java.util.List;

import entity.Account;
import util.MiniPager;
import util.Pager;

/*
 * Account业务接口
 * 
 * 
 * */
public interface IAccountService {
	//转账
    void transfer(Account from,Account to,double money) ;
    //查询账号功能
    Account searchAccount(int id);
    //--分页查询账号信息
   
    Pager<Account> findPaged(int pageNo,int PageSize);
    List<Account> listPaged(int pageNo,int PageSize);
}
