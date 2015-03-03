/**
 * 
 */
package thirdstage.exercise.dto.case2;

/**
 * @author 3rdstage
 *
 */
public class AlreadyExistingFieldException extends RuntimeException {

	public AlreadyExistingFieldException(){}
	
	public AlreadyExistingFieldException(String msg){
		super(msg);
	}
	
	public AlreadyExistingFieldException(String msg, Throwable cause){
		super(msg, cause);
	}

	public AlreadyExistingFieldException(Throwable cause){
		super(cause);
	}
	
}
