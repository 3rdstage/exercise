
package thirdstage.framework.mars.exceptions;

/**
 * 
 * @author 3rdstage
 * @version 1.0, 2005년 10월 23일 (일)
 * @since 2005년 10월 23일 (일)
 * 
 */
public class BusinessException extends thirdstage.platform.exception.NestableException {
	
	/** Creates a new instance of BusinessException */
	public BusinessException() {
	}
	
	public BusinessException(String msg) {
		super(msg);
	}
}
