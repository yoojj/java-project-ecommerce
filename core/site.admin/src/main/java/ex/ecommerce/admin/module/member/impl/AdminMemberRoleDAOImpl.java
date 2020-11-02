package ex.ecommerce.admin.module.member.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ex.ecommerce.admin.module.member.AdminRole;

@Repository
public class AdminMemberRoleDAOImpl {

	private SqlSession sqlSession;

	public AdminMemberRoleDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	
	public int insert(final AdminRole adminRole) throws SQLException {
		return sqlSession.insert("AdminMemberRoleMapper.insert", adminRole);
	}
	
	public List<AdminRole> selectList() throws SQLException {
		return sqlSession.selectList("AdminMemberRoleMapper.selectList");
	}
	
	public int update(final AdminRole adminRole) throws SQLException {
		return sqlSession.insert("AdminMemberRoleMapper.insert", adminRole);
	}
	
	public int delete(final int no) throws SQLException {
		return sqlSession.delete("AdminMemberRoleMapper.delete", no);
	}
	
}
