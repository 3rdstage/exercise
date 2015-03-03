package thirdstage.exercise.ejb3.simple;

import java.util.Locale;

public interface GreetingsService {
	
	String sayHello();
	
	String sayGreetings(Locale locale);
	
	String sayGoodBye(Locale locale);

}
