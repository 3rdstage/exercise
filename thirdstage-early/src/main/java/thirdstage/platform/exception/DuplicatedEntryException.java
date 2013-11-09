
package thirdstage.platform.exception;


/**
 * Thrown when trying to add or insert an entry into the system where the entry
 * should be unique and the same entry already exist.
 *
 * @author Sang-Moon Oh
 * @version 1.0
 * @since 2002/04/26
 */
public class DuplicatedEntryException extends Exception {
	
	/**
	 * Constructs an object specifying an exception message.
	 *
	 * @param message
	 */
	public DuplicatedEntryException(String message) {
		super(message);
	}
	
	/**
	 * Construncts an object.
	 */
	public DuplicatedEntryException() {
		super();
	}
}
