package be.jarchitects.springbatch.processor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;

import be.jarchitects.springbatch.model.ScrapeRecord;

public class SplitAddressProcessor implements
		ItemProcessor<ScrapeRecord, ScrapeRecord> {
	
	private static final Log log = LogFactory.getLog(SplitAddressProcessor.class);
	Pattern p = Pattern.compile("(.*?)( [0-9\\-]{1,7}/{0,1}[a-zA-Z]{0,1}){0,1},( \\d{4}){0,1}(.*?),(.*?)");
	
	@Override
	public ScrapeRecord process(ScrapeRecord item) throws Exception {
		//log.info(String.format("processing address: %s", item.getAddress()));
		Matcher m = p.matcher(item.getAddress());
		if (m.find()) {
			item.setStreet(m.group(1));
			item.setHouseNumber(m.group(2));
			item.setPostalCode(m.group(3));
			item.setCity(m.group(4));
			log.info(String.format("match: %s", m.group(3)));
		}
		return item;
	}

}
