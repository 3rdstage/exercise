/**
 * 
 */
package thirdstage.exercise.findbugs.case1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import checkers.igj.quals.Mutable;

/**
 * @author 3rdstage
 *
 */
public class AnnotationTest{
	
	Map<String, User> users = new HashMap<String, User>();
	
	public void printUsers(){
		for(Map.Entry<String, User> entry : users.entrySet()){
			System.out.println(entry.getValue().toString());
		}
	}

	public void printUsersInefficient(){
		for(String key : users.keySet()){
			System.out.println(users.get(key).toString());
		}
	}
	
	/* FindBugs will find CFS_CONFUSING_FUNCTION_SEMANTICS(Method returns modified parameter
	 * on this method.
	 */
	public List<?> clearList(List<?> list){
		if(list == null) return null;
		else{
			list.clear();
			return list;
		}
	}
	
	
	public User setUserAddress(@Mutable User user, String address){
		
		user.setAddress(address);
		return user;
	}
	

}


class User{
	
	private String id;
	
	private String name;
	
	private String address;
	
	public String getId(){ return this.id; }
	
	public void setId(String id){ this.id = id; }
	
	public String getName(){ return this.name; }
	
	public void setName(String name){ this.name = name; }
	
	public String getAddress(){ return this.address; }
	
	public void setAddress(String address){ this.address = address; }
}
