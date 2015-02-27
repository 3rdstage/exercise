
package thirdstage.platform.exception;

import java.io.*;

/**
 * Thrown when exception occurs in basic operations such as handling application
 * objects, configuration object, logger or connection.
 *
 * @author Sang-Moon Oh
 * @version 1.0
 * @since 2002/04/08
 */
public class NestableException extends Exception {
	private Throwable mNestedException = null;
	
	/**
	 * Constructs an object specifying the exception message and nested exception.
	 *
	 * @param message
	 * @param ex
	 */
	public NestableException(String message, Throwable ex) {
		super(message);
		this.mNestedException = ex;
	}
	
	/**
	 * Constructs an object specifying the exception message.
	 *
	 * @param message
	 */
	public NestableException(String message) {
		super(message);
	}
	
	/**
	 * default constructor
	 */
	public NestableException() {
		super();
	}
	
	
	/**
	 * @return java.lang.String
	 */
	public String getMessage() {
		if(mNestedException == null) return super.getMessage();
		else return (super.getMessage() + "; nested exception is : \n\t" + mNestedException.toString());
	}
	
	/**
	 * Prints a stack trace for this <code>Throwable</code> object on the standard
	 * error output stream which is identical to <code>System.err</code>.
	 */
	public void printStackTrace() {
		this.printStackTrace(System.err);
	}
	
	/**
	 * Prints this <code>Throwable</code> and its backtrace to the specified print
	 * stream.
	 *
	 *
	 * @param ps
	 */
	public void printStackTrace(PrintStream ps) {
		if(mNestedException == null) super.printStackTrace(ps);
		else{
			synchronized(ps){
				ps.println(this);
				mNestedException.printStackTrace(ps);
			}
		}
		// end of printStackTrace(PrintStream) method
	}
	
	/**
	 * Prints this <code>Throwable</code> and its backtrace to the specified print
	 * writer.
	 *
	 * @param pw
	 */
	public void printStackTrace(PrintWriter pw) {
		if(mNestedException == null) super.printStackTrace(pw);
		else{
			synchronized(pw){
				pw.println(this);
				mNestedException.printStackTrace(pw);
			}
		}
		// end of printStackTrace(PrintWriter) method
	}
	
	
	public Throwable getNestedException(){
		return this.mNestedException;
	}
}
