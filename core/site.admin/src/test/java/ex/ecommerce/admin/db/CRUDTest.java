package ex.ecommerce.admin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
	private ResultSet rs;
	
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
	
	@Test @Ignore
	public void CreateTableTest() throws SQLException {
		
		StringBuilder sb = new StringBuilder();
		String sql = sb.append("create table test(")
			.append("id varchar2,")
			.append("pwd varchar2")
			.append(");").toString();
			
		ps = connection.prepareStatement(sql);
		
		ps.execute();
	
	}
	
	@Test @Ignore
	public void insertTest() throws SQLException {

		try {
			
			String sql = "INSERT INTO test VALUES (?, ?)";
			
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, "id-test");
			ps.setString(2, "pwd-test");
			
			ps.addBatch();
			ps.clearParameters();

		} finally {
			ps.executeBatch();
			ps.clearBatch();
		}
	}

	@Test @Ignore
	public void readTest() throws SQLException {

		try {
			
			String sql = "SELECT * FROM test";
			
			ps = connection.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			List<String[]> list = new ArrayList<>();

			while(rs.next()) {
				
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				
				list.add(new String[] {id, pwd});
				
			}

			for(String[] value : list) 
				System.out.println(Arrays.toString(value));
			
		} finally {
			ps.clearParameters();
			rs.close();
		}

	}
	
	@Test @Ignore
	public void modifyTest() throws SQLException {

		try {
			
			String sql = "UPDATE test SET pwd=? WHERE id=?";
			
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, "pwd-000000");
			ps.setString(2, "id-test");

			int result = ps.executeUpdate();
			System.out.println(result);

		} finally {
			ps.clearParameters();
		}

	}
	
	@Test
	public void deleteTest() throws SQLException {

		try {
			
			String sql = "DELETE test WHERE id=? AND pwd=?";
			
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, "id-test");
			ps.setString(2, "pwd-000000");

			int result = ps.executeUpdate();
			System.out.println(result);

		} finally {
			ps.clearParameters();
		}

	}
	
}