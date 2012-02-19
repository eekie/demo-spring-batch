package be.jarchitects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

import be.jarchitects.springbatch.model.ScrapeRecord;

public class JdbcScrapeRecordDao implements ScrapeRecordDao {

    private static final String INSERT_SCRAPE_RECORD = "INSERT INTO SCRAPE_DATA (id, customer_id, company_name, address, opening_hours, telephone, categories, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    private DataFieldMaxValueIncrementer incrementer;
    
    @Override
	public void saveScrapeRecords(List<? extends ScrapeRecord> records) {
    	
    	List<Object[]> paramList = new ArrayList<Object[]>();
		for (ScrapeRecord r: records) {
			Long id = incrementer.nextLongValue();
			Object[] args = new Object[]{id, r.getCustomerId(), r.getCompanyName(), r.getAddress(), r.getOpeningHours(), r.getTelephone(), r.getCategories(), r.getUrl()};
			paramList.add(args);
		}
      simpleJdbcTemplate.batchUpdate(INSERT_SCRAPE_RECORD, paramList);
    }
    
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
    
    public void setIncrementer(DataFieldMaxValueIncrementer incrementer) {
        this.incrementer = incrementer;
    }
    
}
