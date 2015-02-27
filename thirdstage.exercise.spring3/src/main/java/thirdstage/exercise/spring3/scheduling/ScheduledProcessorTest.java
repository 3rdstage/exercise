package thirdstage.exercise.spring3.scheduling;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScheduledProcessorTest {

	public static void main(String[] args){
		new ClassPathXmlApplicationContext("thirdstage/exercise/spring3/scheduling/spring.xml");

		assertTrue(true);
	}

}
