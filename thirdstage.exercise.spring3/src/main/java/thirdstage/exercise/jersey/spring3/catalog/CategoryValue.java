package thirdstage.exercise.jersey.spring3.catalog;

import javax.annotation.Nonnull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryValue {
	
	private String id;
	
	private String name;
	
	public CategoryValue(){
		
	}
	
	public CategoryValue(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public String getId(){ return this.id; }
	
	public CategoryValue setId(String id){
		this.id = id;
		return this;
	}
	
	public String getName(){ return this.name; }
	
	public CategoryValue setName(String name){
		this.name = name;
		return this;
	}
	
	@Override
	public String toString(){
		
		return new StringBuilder().append("ID : ").append(this.id)
				.append(", Name : ").append(this.name).toString();
	}

}
