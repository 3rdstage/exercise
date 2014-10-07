/**
 * 
 */
package thirdstage.exercise.concurrency.case4;

import java.util.concurrent.Callable;

/**
 * @author 3rdstage
 *
 */
public interface Worker<V, A extends Action<V>> extends Callable<V> {

}
