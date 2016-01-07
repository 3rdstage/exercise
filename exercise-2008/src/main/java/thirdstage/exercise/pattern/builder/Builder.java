/**
 *
 */
package thirdstage.exercise.pattern.builder;

import javax.annotation.concurrent.ThreadSafe;

/**
 * @author 3rdstage
 *
 */
@ThreadSafe
public interface Builder<T> {

	public T build();

}
