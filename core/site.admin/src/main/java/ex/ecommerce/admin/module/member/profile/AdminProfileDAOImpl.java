package ex.ecommerce.admin.module.member.profile;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminProfileDAOImpl {

	private SqlSession sqlSession;
	
	@Autowired
	public AdminProfileDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	
	public AdminProfileDTO select(final String id) throws SQLException {
		return sqlSession.selectOne("AdminProfileMapper.select", id);
	}
	
	public int update(AdminProfileDTO profileDTO) throws SQLException {
		return sqlSession.update("AdminProfileMapper.update", profileDTO);
	}
	
	public int delete(final String id) throws SQLException {
		return sqlSession.delete("AdminProfileMapper.delete", id);
	}
	
}