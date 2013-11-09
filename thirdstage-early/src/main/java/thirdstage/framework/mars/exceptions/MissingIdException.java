package thirdstage.framework.mars.exceptions;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005년 10월 23일 (일), 3rdstage
 * @since 2005년 10월 23일 (일)
 */
public class MissingIdException extends BusinessException{
	
	/**
	 * Creates a new instance of <code>MissingIdException</code> without detail message.
	 */
	public MissingIdException() {
	}
	
	
	/**
	 * Constructs an instance of <code>MissingIdException</code> with the specified detail message.
	 * @param msg the detail message.
	 */
	public MissingIdException(String msg) {
		super(msg);
	}
}
