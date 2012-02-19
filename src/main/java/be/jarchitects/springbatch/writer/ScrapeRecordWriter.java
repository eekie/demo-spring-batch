package be.jarchitects.springbatch.writer;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemStreamSupport;
import org.springframework.batch.item.ItemWriter;

import be.jarchitects.dao.ScrapeRecordDao;
import be.jarchitects.springbatch.model.ScrapeRecord;

public class ScrapeRecordWriter extends ItemStreamSupport implements ItemWriter<ScrapeRecord> {

	private static Log log = LogFactory.getLog(ScrapeRecordWriter.class);
	private ScrapeRecordDao dao;

	public void write(List<? extends ScrapeRecord> records) {
		log.info(String.format("writing another batch of %s records ", records.size()));
		dao.saveScrapeRecords(records);
	}

	public void setDao(ScrapeRecordDao dao) {
		this.dao = dao;
	}

}