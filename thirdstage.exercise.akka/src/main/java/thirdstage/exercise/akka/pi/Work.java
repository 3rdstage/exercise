package thirdstage.exercise.akka.pi;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Immutable
public class Work {

	private final int start;

	private final int numOfElements;

	public Work(int start, int elements){
		this.start = start;
		this.numOfElements = elements;
	}

	public int getStart(){ return this.start; }

	public int getNumOfElements(){ return this.numOfElements; }


}
