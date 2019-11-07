package daoTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import dao.prototype.IAccountDao;
import entity.Account;
import util.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class TestAccountDao {
	
     @Autowired
	private IAccountDao actDao;
     
     @Test
     public void testFind() {
    	Account act=actDao.find(1);
    	System.out.println(act);
     }
     
     @Test
     public void testfind() {
    	 Pager<Account> pager=actDao.findPaged(2, 10);
    	System.out.println(pager.getData());
     }
     
     @Test
     public void TestsaveOrUpdate() {
    	 actDao.saveOrUpdate(new Account("csk",6000,7));
     }
     
     
     
}
