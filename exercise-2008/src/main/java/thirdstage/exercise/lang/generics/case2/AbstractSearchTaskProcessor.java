/**
 *
 */
package thirdstage.exercise.lang.generics.case2;

/**
 * @author 3rdstage
 *
 */
public abstract class AbstractSearchTaskProcessor<SC extends SearchCriteria,
	E extends Event, EC extends EventContext> implements
		SearchTaskProcessor<SC, E, EC> {

	private SearchTaskStatus status;

	protected void setStatus(SearchTaskStatus status){
		this.status = status;
	}

	@Override
	public SearchTaskStatus getStatus(){ return this.status; }


}
