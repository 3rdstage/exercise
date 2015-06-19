/**
 *
 */
package thirdstage.exercise.lang.generics.case2.bar;

import javax.annotation.Nonnegative;
import javax.annotation.concurrent.Immutable;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import thirdstage.exercise.lang.generics.case2.EventContext;

/**
 * @author 3rdstage
 *
 */
@Immutable
public class BarEventContext implements EventContext {

	@Nonnegative
	private int deviceId;

	private String fileName;

	@Pattern(regexp="[1-9][0-9]{13}")
	private String time;

	private String str;

	public BarEventContext(@Nonnegative int devId, String fileName,
			@Pattern(regexp="[1-9][0-9]{13}") String time){
		this.deviceId = devId;
		this.fileName = fileName;
		this.time = time;
	}

	public int getDeviceId(){ return this.deviceId; }

	public String getFileName(){ return this.fileName; }

	public String getTime(){ return this.time; }

	@Override
	public String toString(){
		if(this.str == null){
			this.str = new StringBuilder().append("{Device ID: ").append(this.deviceId)
						.append(", Time: ").append(this.time).append("}").toString();
		}
		return this.str;
	}
}
