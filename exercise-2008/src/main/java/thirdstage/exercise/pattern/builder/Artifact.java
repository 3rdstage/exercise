/**
 *
 */
package thirdstage.exercise.pattern.builder;

import javax.annotation.concurrent.Immutable;

/**
 * @author 3rdstage
 *
 */
@Immutable
public interface Artifact<T> {


	public Builder<T> getBuilder();

}
