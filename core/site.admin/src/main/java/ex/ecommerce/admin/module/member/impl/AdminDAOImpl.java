package ex.ecommerce.admin.module.member.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ex.ecommerce.admin.module.member.Admin;
import ex.ecommerce.admin.module.member.AdminLoginDTO;
import ex.ecommerce.admin.module.member.AdminModifyDTO;
import ex.ecommerce.admin.module.member.AdminRegDTO;

@Repository
public class AdminDAOImpl {

	private SqlSession sqlSession;

	public AdminDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	
	public int insert(final AdminRegDTO adminRegDTO) throws SQLException {
		return sqlSession.insert("AdminMapper.insert", adminRegDTO);
	}

	public String selectId(final String id) throws SQLException {
		return sqlSession.selectOne("AdminMapper.selectId", id);
	}

	public String selectPwd(final String id) throws SQLException {
		return sqlSession.selectOne("AdminMapper.selectPwd", id);
	}
	
	public Admin select(final String id) throws SQLException {
		return sqlSession.selectOne("AdminMapper.select", id);
	}
	
	public List<Admin> selectList() throws SQLException {
		return sqlSession.selectList("AdminMapper.selectList");
	}

	public int updateLogin(final AdminLoginDTO adminLoginDTO) throws SQLException {
		return sqlSession.update("AdminMapper.updateLogin", adminLoginDTO);
	}
	
	public int update(final AdminModifyDTO adminModifyDTO) throws SQLException {
		return sqlSession.update("AdminMapper.update", adminModifyDTO);
	}
	
	public int delete(final String id) throws SQLException {
		return sqlSession.delete("AdminMapper.delete", id);
	}

	public int realDelete(final String id) throws SQLException {
		return sqlSession.delete("AdminMapper.realDelete", id);
	}

}