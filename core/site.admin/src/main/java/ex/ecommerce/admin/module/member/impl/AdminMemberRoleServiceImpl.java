package ex.ecommerce.admin.module.member.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import ex.ecommerce.admin.module.member.AdminRole;
import ex.ecommerce.common.module.result.CodeEnum;
import ex.ecommerce.common.module.result.DBCodeEnum;
import ex.ecommerce.common.module.result.Result;
import ex.ecommerce.common.module.result.enumImpl.DBError;

@Service
public class AdminMemberRoleServiceImpl {

	private AdminMemberRoleDAOImpl adminRoleDAO;
	 
	public AdminMemberRoleServiceImpl(AdminMemberRoleDAOImpl adminRoleDAO) {
		this.adminRoleDAO = adminRoleDAO;
	}
	
	
	public Result insert(final AdminRole adminRole) throws SQLException {
		
		final Result result = new Result();
		
		if(adminRoleDAO.insert(adminRole) == DBCodeEnum.SUCCESS.getCode()) {
			
			result.setCode(CodeEnum.SUCCESS.getCode());
			result.setMessage(CodeEnum.SUCCESS.getDescription());
			
		} else {
			
			result.setCode(DBError.INSERT_ERROR.getCode());
			result.setMessage(DBError.INSERT_ERROR.getDescription());
			
		}
	
		return result;
	}
	
	public List<AdminRole> selectList() throws SQLException {
		return adminRoleDAO.selectList();
	}
	
	public Result update(final AdminRole adminRole) throws SQLException {
		return null;
	}
	
	public Result delete(final int no) throws SQLException {
		return null;
	}
	
}