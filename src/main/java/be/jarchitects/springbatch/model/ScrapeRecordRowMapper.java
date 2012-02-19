package be.jarchitects.springbatch.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class ScrapeRecordRowMapper implements RowMapper {
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        if (rs == null) { return null; }
        ScrapeRecord scrapeRecord = new ScrapeRecord();
        scrapeRecord.setCustomerId(rs.getString("customer_id"));
        scrapeRecord.setCompanyName(rs.getString("company_name"));
        scrapeRecord.setAddress(rs.getString("address"));
        scrapeRecord.setOpeningHours(rs.getString("opening_hours"));
        scrapeRecord.setTelephone(rs.getString("telephone"));
        scrapeRecord.setUrl(rs.getString("url"));
        scrapeRecord.setCategories(rs.getString("categories"));
        return scrapeRecord;
	}
}
