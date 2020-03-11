package ex.ecommerce.site.batch;

import java.sql.SQLException;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import ex.ecommerce.common.util.LoggerUtil;

public class TempUserDeleteJobBean extends QuartzJobBean {

	private TempUserDeleteJob tempUserDeleteJob;
	
	@Autowired
	public TempUserDeleteJobBean (TempUserDeleteJob tempUserDeleteJob) {
		this.tempUserDeleteJob = tempUserDeleteJob;
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		try {
			
			tempUserDeleteJob.work();
		
		} catch (SQLException e) {
			LoggerUtil.log.debug(e.getMessage());
		}
		
	}
	
}