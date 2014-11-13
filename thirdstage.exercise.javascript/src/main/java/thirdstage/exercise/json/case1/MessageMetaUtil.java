package thirdstage.exercise.json.case1;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageMetaUtil {
	
	
	public static MessageMeta parseMessageMetaFromJson(String jsonString) throws Exception{
		
		//ObjectMapper is conditionally thread-safe. In other words, is is NOT thead-safe.
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		MessageMeta meta = mapper.readValue(jsonString, MessageMeta.class);
		return meta;
	}

	public static MessageMeta parseMessageMetaFromJson(File f) throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		return mapper.readValue(f, MessageMeta.class);
	}
	
}
