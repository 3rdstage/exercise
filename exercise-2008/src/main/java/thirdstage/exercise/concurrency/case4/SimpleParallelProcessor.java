/**
 * 
 */
package thirdstage.exercise.concurrency.case4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Stateful or not ?
 * 
 * @author 3rdstage
 *
 */
public class SimpleParallelProcessor<V, A extends Action<V>> implements ParallelProcessor<V, A>{
	
	private List<PreProcessor> preProcessors = null;;
	
	private List<PostProcessor> postProcessors = null;

	private Partitioner<A> partitionser = null;
	
	private Context context = null;
	
	private List<A> actions = null;
	
	private List<Worker<V, A>> tasks = null; 
	
	private List<Future<V>> futures = null;
	
	private ExecutorService service = Executors.newCachedThreadPool();
	
	public SimpleParallelProcessor(){
		
	}
	
	@Override
	public void setup(List<PreProcessor> pres, List<PostProcessor> posts, Partitioner<A> prt, Context cntx){
		this.preProcessors = pres;
		this.postProcessors = posts;
		this.partitionser = prt;
		this.context = cntx;
	}
	
	/* (non-Javadoc)
	 * @see thirdstage.exercise.concurrency.case4.ParallelProcessor#process(java.util.List, thirdstage.exercise.concurrency.case4.Context)
	 */
	@Override
	public void process() throws Exception {
		
		this.actions = this.partitionser.partition();
		
		if(actions == null || actions.isEmpty()){
			//@todo log something
			return;
		}
		
		for(PreProcessor pre : this.preProcessors){
			pre.execute(this.context);
		}
		
		this.tasks = new ArrayList<Worker<V, A>>(actions.size());
		for(Action<V> action : actions){
			tasks.add(new DefaultWorker(action, this.context));
		}
		
		this.futures = this.service.invokeAll(this.tasks);
		
		for(PostProcessor post : this.postProcessors){
			post.execute(this.context);
		}
		
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.concurrency.case4.ParallelProcessor#getAllPreProcessors()
	 */
	@Override
	public List<PreProcessor> getAllPreProcessors() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.concurrency.case4.ParallelProcessor#enablePreProcessor(int)
	 */
	@Override
	public void enablePreProcessor(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.concurrency.case4.ParallelProcessor#disablePreProcessor(int)
	 */
	@Override
	public void disablePreProcessor(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.concurrency.case4.ParallelProcessor#getAllPostProcessors()
	 */
	@Override
	public List<PostProcessor> getAllPostProcessors() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.concurrency.case4.ParallelProcessor#enablePostProcessor(int)
	 */
	@Override
	public void enablePostProcessor(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see thirdstage.exercise.concurrency.case4.ParallelProcessor#disablePostProcessor(int)
	 */
	@Override
	public void disablePostProcessor(int index)
			throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

}
