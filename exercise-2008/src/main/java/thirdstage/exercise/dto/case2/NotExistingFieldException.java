/**
 * 
 */
package thirdstage.exercise.dto.case2;

/**
 * @author 3rdstage
 *
 */
public class NotExistingFieldException extends RuntimeException {
	
	public NotExistingFieldException(){}
	
	public NotExistingFieldException(String msg){
		super(msg);
	}
	
	public NotExistingFieldException(String msg, Throwable cause){
		super(msg, cause);
	}

	public NotExistingFieldException(Throwable cause){
		super(cause);
	}
}
