/**
 *
 */
package thirdstage.exercise.jackson.databind.case4;

/**
 *
 *
 * @author Sangmoon Oh
 *
 */
public class Image {

	private String location;

	private String path;

	private int width;

	private int height;

	private byte[] bytes;

	public Image(){}

	public String getLocation(){
		return this.location;
	}

	public Image setLocation(String loc){
		this.location = loc;
		return this;
	}

	public String getPath(){
		return this.path;
	}

	public Image setPath(String path){
		this.path = path;
		return this;
	}

	public int getWidth(){ return this.width; }

	public Image setWidth(int w){
		this.width = w;
		return this;
	}

	public int getHeight(){ return this.height; }

	public Image setHeight(int h){
		this.height = h;
		return this;
	}

	public byte[] getBytes(){ return this.bytes; }

	public Image setBytes(byte[] bytes){
		this.bytes = bytes;
		return this;
	}

}
