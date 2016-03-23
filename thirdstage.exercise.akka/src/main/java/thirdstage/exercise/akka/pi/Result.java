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
public class Result {

	private final double value;

	public Result(double value){
		this.value = value;
	}

	public double getValue(){
		return this.value;
	}

}
