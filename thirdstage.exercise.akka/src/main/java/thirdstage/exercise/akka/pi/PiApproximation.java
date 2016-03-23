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

import scala.concurrent.duration.Duration;

@Immutable
public class PiApproximation {

	private final double pi;

	private final Duration duration;


	public PiApproximation(double pi, Duration duration){
		this.pi = pi;
		this.duration = duration;
	}

	public double getPi(){ return this.pi; }

	public Duration getDuration(){ return this.duration; }

}
