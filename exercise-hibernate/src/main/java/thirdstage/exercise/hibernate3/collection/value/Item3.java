package thirdstage.exercise.hibernate3.collection.value;

import java.util.ArrayList;
import java.util.List;

/**
 * This entity has a list of images in value type.
 *
 * Java Persistence 1.0 doesn't support value/component collection,
 * so you should define XML based mapping for this class.
 *
 * @author 3rdstage
 *
 */
public class Item3{

	private long id;

	private String name;

	private List<String> images = new ArrayList<String>();

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

	public List<String> getImages(){
		return this.images;
	}

	public void setImages(List<String> images){
		this.images = images;
	}

}
