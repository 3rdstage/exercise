/**
 *
 */
package thirdstage.exercise.red5.case1;

/**
 * Stands for RTMP commands from the client to the server
 *
 * @author 3rdstage
 * @see <a href="http://wwwimages.adobe.com/content/dam/Adobe/en/devnet/rtmp/pdf/rtmp_specification_1.0.pdf">RTMP Specification 1.0</a>
 *
 */
public enum RtmpClientCommand {

	CONNECT("connect"),
	CREATE_STREAM("createStream"),
	PLAY("play"),
	PLAY2("play2");


	private final String name;

	private RtmpClientCommand(String name){
		this.name = name;
	}

	public String getName(){ return this.name; }

}
