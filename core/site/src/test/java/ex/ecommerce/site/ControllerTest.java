package ex.ecommerce.site;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ex.ecommerce.site.web.SiteMainController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/common-context.xml", 
		"classpath*:config/db-context.xml", "classpath*:config/mail-context.xml",
		"classpath*:config/app/servlet-context.xml"})
@WebAppConfiguration
public class ControllerTest {

	@Autowired
	private SiteMainController controller;
	
	private MockMvc mockMvc;
	    
	@Before
	public void init() {
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
	}

	@Test
	public void login() throws Exception {
		
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
		
	}
	
}