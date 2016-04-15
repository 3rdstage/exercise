package thirdstage.exercise.spring.case13;

import java.util.HashMap;
import java.util.Map;

public class Language {
	
	private String language; 
	public static Map<String, Language> map = new HashMap<String, Language>();
	
	
	public static Language create(String language){
	
		synchronized(map){
			if(map.containsKey(language)) { return map.get(language); }
			else{
				Language lang = new Language(language);
				map.put(language, lang);
				return lang;
			}
		}
	}
	
	
	private Language(String lang){
		this.language = lang;
	}
	
	public String recommendBookTitle(){
		return "TestBook";
	}

}
