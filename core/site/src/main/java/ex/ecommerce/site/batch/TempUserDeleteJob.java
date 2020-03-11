package ex.ecommerce.site.batch;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ex.ecommerce.common.util.DateUtil;
import ex.ecommerce.common.util.LoggerUtil;

@Component
public class TempUserDeleteJob {

	private SqlSession sqlSession;
	
	@Autowired
	public TempUserDeleteJob(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void work() throws SQLException {

		LoggerUtil.log.info("***** TempUserDeleteJob 실행 *****");

		LocalDateTime localDateTime = DateUtil.getLocalDateTime().minusHours(1);
		
		String date = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		int result = deleteByDate(date);
		
		LoggerUtil.log.info("***** TempUserDeleteJob 실행 결과 :: " + result + " 개 삭제 *****");
		
	}
	
	private int deleteByDate(final String date) throws SQLException {
		return sqlSession.delete("memberJoinMapper.delete", date);
	}

}