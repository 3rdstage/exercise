package thirdstage.exercise.hibernate3.collection.value;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

/**
 * This entity has set of images in value type.
 *
 * Java Persistence 1.0 doesn't support value/component collection,
 * so you should define XML based mapping for this class.
 *
 * @author 3rdstage
 *
 */
public class Item1{

	private long id;

	private String name;

	@org.hibernate.annotations.CollectionOfElements(
			targetElement = java.lang.String.class)
	@JoinTable(
			name = "Item1Image",
			joinColumns = @JoinColumn(name = "itemId"))
	private Set<String> images = new HashSet<String>();



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

	public Set<String> getImages(){
		return this.images;
	}

	public void setImages(Set<String> images){
		this.images = images;
	}

}
