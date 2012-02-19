package be.jarchitects.springbatch.model;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class ScrapeRecordFieldSetMapper implements FieldSetMapper<ScrapeRecord> {

	@Override
	public ScrapeRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		ScrapeRecord scrapeRecord = new ScrapeRecord();
		scrapeRecord.setCustomerId(fieldSet.readString("customer_id"));
		scrapeRecord.setCompanyName(fieldSet.readString("company_name"));
		scrapeRecord.setAddress(fieldSet.readString("address"));
		scrapeRecord.setOpeningHours(fieldSet.readString("address"));
		scrapeRecord.setCategories(fieldSet.readString("categories"));
		scrapeRecord.setTelephone(fieldSet.readString("telephone"));
		scrapeRecord.setCategories(fieldSet.readString("categories"));
		scrapeRecord.setUrl(fieldSet.readString("url"));
		return scrapeRecord;
	}

}