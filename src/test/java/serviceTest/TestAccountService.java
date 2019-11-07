package serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import config.TestConfig;
import entity.Account;
import service.prototype.IAccountService;
import util.Pager;

/*
 * 
 * AccountService
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class TestAccountService {
   
	@Autowired
	private IAccountService actService;
	
	@Test
	private void test() {
		System.out.println(actService.searchAccount(1));
	}
	
	@Test
	public void testIAccountService() {
	   Pager<Account> pager=(Pager<Account>) actService.listPaged(1, 5);
		for (Account act : pager.getData()) {
			System.out.println(act);
		}
		System.out.println(pager.getTotal());
	}
	

}
