/**
 * 
 */
package thirdstage.exercise.meta.service.case1;

/**
 * @author 3rdstage
 *
 */
public interface DataMetaMeta{
	
	
	FieldType[] getTypes();
	
	FieldFacet<?>[] getFacets();
	
	FieldFacet<?>[] getFacetsByType(FieldType type);

}
