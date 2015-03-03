/**
 * 
 */
package thirdstage.exercise.concurrency.case4;

/**
 * @author 3rdstage
 *
 */
public class DefaultWorker<V, A extends Action<V>> implements Worker<V, A> {
	
	private Action<V> action = null; 
	private Context context = null;
	
	public DefaultWorker(Action<V> action, Context cntx){
		this.action = action;
		this.context = cntx;
	}
	
	
	public V call() throws Exception{
		return this.action.process(this.context);
	}
	
	

}
