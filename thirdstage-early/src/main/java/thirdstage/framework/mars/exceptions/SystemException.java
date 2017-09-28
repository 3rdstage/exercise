
package thirdstage.framework.mars.exceptions;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005년 10월 23일 (일)
 * @since 2005년 10월 23일 (일)
 */
public class SystemException extends thirdstage.platform.exception.NestableException{
	
	/** Creates a new instance of SystemException */
	public SystemException() {
	}
	
	public SystemException(String msg) {
		super(msg);
	}
	
	public SystemException(String msg, Throwable ex){
		super(msg, ex);
	}
	
}
