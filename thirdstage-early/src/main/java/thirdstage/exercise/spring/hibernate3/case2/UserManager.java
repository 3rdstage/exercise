
package thirdstage.exercise.spring.hibernate3.case2;

/**
 *
 * @author 3rdstage
 * @version 1.1, 2006-07-11, 3rdstage, adds getAllUsers2 whose return type is generic
 * @version 1.0, 2006-07-08, 3rdstage
 * @since 2006-07-08
 */
public interface UserManager {

	public User createUser(User user) throws Exception;
	
	public User[] getAllUsers() throws Exception;
	
	public java.util.List<User> getAllUsers2() throws Exception;
	
}
