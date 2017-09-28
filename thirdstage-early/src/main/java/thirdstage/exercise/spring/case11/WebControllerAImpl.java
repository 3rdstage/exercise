package thirdstage.exercise.spring.case11;

public class WebControllerAImpl implements WebControllerA {

	private ServiceA serviceA = null;
	
	public WebControllerAImpl(ServiceA a){
		this.serviceA = a;
		
	}
}
