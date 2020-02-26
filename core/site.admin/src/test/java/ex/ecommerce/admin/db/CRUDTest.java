package ex.ecommerce.admin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
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
public class CRUDTest {

	private static HikariConfig config;
	private static HikariDataSource ds;
	private static Connection connection;
	private static PreparedStatement ps;
	
	@BeforeClass
	public static void connection() throws SQLException {
		
		config = new HikariConfig();	
		
		config.setDriverClassName("org.h2.Driver");
		config.setJdbcUrl("jdbc:h2:tcp://localhost/~/test");
		config.setUsername("sa");
		
		ds = new HikariDataSource(config);
		
		connection = ds.getConnection();
		
	}
	
	@AfterClass
	public static void close() throws SQLException {
		
		if( ps != null ) ps.close();
		if( connection != null ) connection.close();
		ds.close();
		
	}
	
	@Test
	public void CreateTableTest() throws SQLException {
		
		StringBuilder sb = new StringBuilder();
		String sql = sb.append("create table test(")
			.append("id varchar2,")
			.append("pwd varchar2")
			.append(");").toString();
			
		ps = connection.prepareStatement(sql);
		
		ps.execute();
	
	}

}