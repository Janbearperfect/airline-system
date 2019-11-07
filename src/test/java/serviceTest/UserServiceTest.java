package serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import entity.User;
import service.prototype.IUserService;
import util.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class UserServiceTest {
     
	@Autowired
	private IUserService userService;
	
	@Test
	public void test() {
	Pager<User> pager=	(Pager<User>) userService.listUsers(1, 3);

	}
	
}
