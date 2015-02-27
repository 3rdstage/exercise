/*
 * FrameworkException.java
 *
 * Created on 2005?? 5?? 14?? (??), ???? 12:41
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package thirdstage.platform.exception;

/**
 *
 * @author 3rdstage
 */
public class FrameworkException extends NestableException{
	
	/**
	 * Creates a new instance of <code>FrameworkException</code> without detail message.
	 */
	public FrameworkException() {
	}
	
	
	/**
	 * Constructs an instance of <code>FrameworkException</code> with the specified detail message.
	 * @param msg the detail message.
	 */
	public FrameworkException(String msg) {
		super(msg);
	}
}
