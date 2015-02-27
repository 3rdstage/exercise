package thirdstage.exercise.hibernate3.collection.value;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This entity has a collection(bag) of images in value type.
 *
 * Java Persistence 1.0 doesn't support value/component collection,
 * so you should define XML based mapping for this class.
 *
 * @author 3rdstage
 *
 */
public class Item2{

	private long id;

	private String name;

	private Collection<String> images = new ArrayList<String>();



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

	public Collection<String> getImages(){
		return this.images;
	}

	public void setImages(Collection<String> images){
		this.images = images;
	}

}
