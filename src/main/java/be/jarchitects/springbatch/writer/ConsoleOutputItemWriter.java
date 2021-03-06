package be.jarchitects.springbatch.writer;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;


/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
public class ConsoleOutputItemWriter implements ItemWriter<Object> {

	private static final Log log = LogFactory.getLog(ConsoleOutputItemWriter.class);
	
	/**
	 * @see ItemWriter#write(Object)
	 */
	public void write(List<? extends Object> data) throws Exception {
		log.info(data);
	}

}
