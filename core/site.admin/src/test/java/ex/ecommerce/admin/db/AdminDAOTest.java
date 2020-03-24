package ex.ecommerce.admin.db;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ex.ecommerce.admin.module.member.AdminRegDTO;
import ex.ecommerce.admin.module.member.impl.AdminDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/common-context.xml", 
		"classpath*:config/db-context.xml", "classpath*:config/mail-context.xml",
		"classpath*:config/app/servlet-context.xml"})
@WebAppConfiguration
public class AdminDAOTest {

	@Autowired
	private AdminDAOImpl adminDAO;
	
	@Test @Ignore
	public void insertTeset() throws SQLException {
		
		final AdminRegDTO adminRegDTO = new AdminRegDTO();
		
		adminRegDTO.setId("test-id");
		adminRegDTO.setPwd("test-pwd");
		adminRegDTO.setLevel("1");
		adminRegDTO.setRegAdmin("test");
		adminRegDTO.setRegMsg("test insert");
		adminRegDTO.setState(true);

		int result = adminDAO.insert(adminRegDTO);
		
		assertEquals(result, 1);
		
	}
	
	@Test @Ignore
	public void deleteTest() throws SQLException {

		int result = adminDAO.realDelete("test-id");

		assertEquals(result, 1);

	}
	
}