package thirdstage.exercise.hibernate3.collection.component;

import java.awt.Image;
import java.util.HashSet;
import java.util.Set;

/**
 * This class has a set of image components
 *
 * @author 3rdstage
 *
 */
public class Item{

	private long id;

	private String name;

	private String description;

	private Set<Image> images = new HashSet<Image>();

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

	public String getDescription(){
		return this.description;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public Set<Image> getImages(){
		return this.images;
	}

	public void setImages(Set<Image> images){
		this.images = images;
	}

}
