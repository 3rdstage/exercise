package thirdstage.exercise.akka.pi;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorSystem;



/**
 * @author Sangmoon Oh
 * @see <a href="http://doc.akka.io/docs/akka/2.0.2/intro/getting-started-first-java.html">Getting Started Tutorial (Java): First Chapter</a>
 */
public class Pi {


	public void calculate(final int workers, final int elements, final int messages){
		ActorSystem system = ActorSystem.create("PiSystem");



	}

}
