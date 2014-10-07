/**
 * 
 */
package thirdstage.exercise.dto.case6;

/**
 * @author 3rdstage
 *
 */
public class FieldMetaFactory {
	
	private final static FieldMetaFactory singleton = new FieldMetaFactory();
	
	private FieldMetaFactory(){

	}
	
	public static FieldMetaFactory getInstance(){
		
		return singleton;
	}

}
