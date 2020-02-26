package ex.ecommerce.admin.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/root-context.xml", 
		"classpath*:config/app/*.xml"})
@WebAppConfiguration
public class DBConnectTest {

	@Test
	public void test() throws SQLException {

		final HikariConfig config = new HikariConfig();	
		
		config.setDriverClassName("org.h2.Driver");
		config.setJdbcUrl("jdbc:h2:tcp://localhost/~/test");
		config.setUsername("sa");
		
		final HikariDataSource ds = new HikariDataSource(config);
		
		try {
			
			final Connection connection = ds.getConnection();
			
			connection.close();
				
		} finally {
			ds.close();
		}
		
	}
}
