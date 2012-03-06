package be.jarchitects.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

import be.jarchitects.springbatch.model.ScrapeRecord;

public class JdbcScrapeRecordDao implements ScrapeRecordDao {

    private static final String INSERT_SCRAPE_RECORD = "INSERT INTO SCRAPE_DATA (id, customer_id, company_name, address, opening_hours, telephone, categories, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SCRAPE_RECORD = "UPDATE SCRAPE_DATA SET POSTAL_CODE = :postalCode WHERE id = :id";
    
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
		simpleJdbcTemplate.batchUpdate(INSERT_SCRAPE_RECORD,  paramList);
      
    }
    
    @Override
	public void updateScrapeRecords(List<? extends ScrapeRecord> records) {
    	List<Map<String, Object>> args = new ArrayList<Map<String, Object>>();
    	for (ScrapeRecord r: records) {
    		Map<String, Object> argMap = new HashMap<String, Object>();
    		argMap.put("postalCode", r.getPostalCode());
    		argMap.put("id", r.getId());
    		args.add(argMap);
    	}
    	Map<String, Object>[] argsArray =  args.toArray(new Map[1]);
    	simpleJdbcTemplate.batchUpdate(UPDATE_SCRAPE_RECORD, argsArray);
    }
    
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
    
    public void setIncrementer(DataFieldMaxValueIncrementer incrementer) {
        this.incrementer = incrementer;
    }
    
}
