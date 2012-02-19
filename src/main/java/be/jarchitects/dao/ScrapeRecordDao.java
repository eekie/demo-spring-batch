
package be.jarchitects.dao;

import java.util.List;

import be.jarchitects.springbatch.model.ScrapeRecord;

public interface ScrapeRecordDao {
	void saveScrapeRecords(final List<? extends ScrapeRecord> records);
}
