/**
 * 
 */
package thirdstage.exercise.freemarker.case2;

import java.util.Date;

import javax.validation.constraints.Size;

/**
 * @author 3rdstage
 *
 */
public class CreativeWork {
	
	public String name;
	
	public String author;
	
	@Size(min=2, max=3)
	public String lang;
	
	public Date createdAt;
	
	public CreativeWork(String name, String author, String lang, Date createdAt){
		this.name = name;
		this.author = author;
		this.lang = lang;
		this.dateCreated = createdAt;
	}
	
}
