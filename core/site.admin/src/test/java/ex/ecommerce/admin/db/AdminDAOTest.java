package ex.ecommerce.admin.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ex.ecommerce.admin.module.AdminDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/root-context.xml", 
		"classpath*:config/app/*.xml"})
@WebAppConfiguration
public class AdminDAOTest {

	@Autowired
	private AdminDAOImpl adminDAO;
	
	@Test
	public void test() {
		
	}
	
}