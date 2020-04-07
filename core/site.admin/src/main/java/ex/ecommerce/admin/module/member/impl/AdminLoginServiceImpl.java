package ex.ecommerce.admin.module.member.impl;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import ex.ecommerce.admin.module.member.Admin;
import ex.ecommerce.admin.module.member.AdminLoginDTO;
import ex.ecommerce.admin.module.member.AdminSessionDTO;
import ex.ecommerce.common.module.result.CodeEnum;
import ex.ecommerce.common.module.result.Result;
import ex.ecommerce.common.module.result.enumImpl.AdminError;
import ex.ecommerce.common.util.BCryptCheckUtil;

@Service
public class AdminLoginServiceImpl {

	private AdminDAOImpl adminDAO;
	 
	public AdminLoginServiceImpl(AdminDAOImpl adminDAO) {
		this.adminDAO = adminDAO;
	}
	
	
	
	public Result select(final AdminLoginDTO loginDTO) throws SQLException {
	
		final Result result = new Result();
	
		final String dbPwd = adminDAO.selectPwd(loginDTO.getId());
		
		if( adminDAO.selectId(loginDTO.getId()) == null ) {
			
			result.setCode(CodeEnum.ERROR.getCode());
			result.setMessage(AdminError.ID_NULL.getDescription());

		} else if(dbPwd == null) {
			
			result.setCode(CodeEnum.ERROR.getCode());
			result.setMessage(AdminError.PWD_NOT_MATCH.getDescription());
			
		} else {
			
			boolean pwdCheck = BCryptCheckUtil.check(loginDTO.getPwd(), dbPwd);

			if(pwdCheck == false) {

				result.setCode(CodeEnum.ERROR.getCode());
				result.setMessage(AdminError.PWD_NOT_MATCH.getDescription());
				
			} else {
				
				adminDAO.updateLogin(loginDTO);
				
				final AdminSessionDTO adminSession = this.getAdminSession(loginDTO.getId());

				result.setCode(CodeEnum.SUCCESS.getCode());
				result.setMessage(CodeEnum.SUCCESS.getDescription());
				result.setResult(adminSession);
				
			}
			
		}
		
		return result;
	}
	
	private AdminSessionDTO getAdminSession(final String id) throws SQLException {

		final Admin admin = adminDAO.select(id);

		final AdminSessionDTO adminSession = new AdminSessionDTO();
		
		adminSession.setId(admin.getId());
		adminSession.setLevel(admin.getLevel());
		adminSession.setClientIp(admin.getClientIp());
		adminSession.setState(admin.isState());

		return adminSession;
	}
	
}