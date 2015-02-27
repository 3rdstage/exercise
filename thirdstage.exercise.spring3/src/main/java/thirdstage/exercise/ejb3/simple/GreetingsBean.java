package thirdstage.exercise.ejb3.simple;

import java.util.Locale;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name="GreetingsService")
@Local(thirdstage.exercise.ejb3.simple.GreetingsService.class)
public class GreetingsBean implements GreetingsService {

	@Override
	public String sayHello() {
		return "Hello";
	}

	@Override
	public String sayGreetings(Locale locale) {
		
		if(Locale.KOREAN.equals(locale)){
			return "안녕하세요.";
		}else if(Locale.US.equals(locale)){
			return "Hi";
		}else{
			return "Hi";
		}
		
	}

	@Override
	public String sayGoodBye(Locale locale) {

		return "Goodbye";
		
	}

}
