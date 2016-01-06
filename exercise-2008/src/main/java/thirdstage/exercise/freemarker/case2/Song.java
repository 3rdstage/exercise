/**
 * 
 */
package thirdstage.exercise.freemarker.case2;

import java.util.Date;

/**
 * @author 3rdstage
 *
 */
public class Song extends CreativeWork{
	
	public int length; //time duration in seconds;
	
	public Song(String name, String author, String lang, Date createdAt, int len){
		super(name, author, lang, createdAt);
		this.length = len;
	}
	
}
