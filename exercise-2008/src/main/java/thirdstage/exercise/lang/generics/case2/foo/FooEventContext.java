/**
 *
 */
package thirdstage.exercise.lang.generics.case2.foo;

import javax.annotation.Nonnegative;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import thirdstage.exercise.lang.generics.case2.EventContext;

/**
 * @author 3rdstage
 *
 */
public class FooEventContext implements EventContext {

	@NotBlank
	private String deviceId;

	private String fileId;

	@Nonnegative
	private long frameNo;

	private String str;

	public FooEventContext(@NotBlank String devId, String fileId,
			@Nonnegative long frmNo){
		this.deviceId = devId;
		this.fileId = fileId;
		this.frameNo = frmNo;
	}

	public String getDeviceId(){ return this.deviceId; }

	public String getFileId(){ return this.fileId; }

	public long getFrameNo(){ return this.frameNo; }

	@Override
	public String toString(){
		if(this.str == null){
			this.str = new StringBuilder().append("{Device ID: ").append(this.deviceId)
						.append(", File ID: ").append(this.fileId)
						.append(", Frame No: ").append(this.frameNo)
						.append("}").toString();
		}
		return this.str;
	}

}
