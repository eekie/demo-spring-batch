package be.jarchitects.springbatch.reader;

import java.text.MessageFormat;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.database.JdbcCursorItemReader;

import be.jarchitects.springbatch.model.ScrapeRecord;


public class JdbcScrapeDataReader extends JdbcCursorItemReader<ScrapeRecord> implements StepExecutionListener {

	private String jobId;
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		this.jobId = stepExecution.getJobParameters().getString("jobid");
		log.info(String.format("beforeStep: %s", jobId));
		MessageFormat messageFormat = new MessageFormat(this.getSql());
		String formattedSql = messageFormat.format(new Object[]{jobId});
		log.info(String.format("formatted sql statement: %s", formattedSql));
		this.setSql(formattedSql);
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		return null;
	}
	
}

