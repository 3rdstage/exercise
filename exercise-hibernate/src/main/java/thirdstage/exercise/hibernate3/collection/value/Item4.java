package thirdstage.exercise.hibernate3.collection.value;

import java.util.HashMap;
import java.util.Map;

/**
 * This class has a map of images in value type
 *
 * Java Persistence 1.0 doesn't support value/component collection,
 * so you should define XML based mapping for this class.
 *
 * @author 3rdstage
 *
 */
public class Item4{

	private long id;

	private String name;

	private Map<String, String> images = new HashMap<String, String>();

	public long getId(){
		return this.id;
	}

	public void setId(long id){
		this.id = id;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Map<String, String> getImages(){
		return this.images;
	}

	public void setImages(Map<String, String> images){
		this.images = images;
	}

}
