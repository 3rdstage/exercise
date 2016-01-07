/**
 * 
 */
package thirdstage.exercise.freemarker.case2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 3rdstage
 *
 */
public class MusicAlbum extends CreativeWork{
	
	public enum Genre {
		
		BLUES, COUNTRY, ELECTRONIC, FOLK, JAZZ, POP, ROCK, RNB, OTHER;
		
	}
	
	public Genre genre;
	
	public Date publishedAt;
	
	public List<Song> songs = new ArrayList<Song>();
	
	public MusicAlbum(String name, String author, String lang, Date createdAt, Genre g, Date publishedAt){
		super(name, author, lang, createdAt);
		this.genre = g;
		this.publishedAt = publishedAt;
		
	}
	
	public void addSong(Song song){
		this.songs.add(song);
	}
	
}
