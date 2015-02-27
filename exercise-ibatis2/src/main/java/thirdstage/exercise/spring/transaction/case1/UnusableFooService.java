package thirdstage.exercise.spring.transaction.case1;

public class UnusableFooService implements FooService{

	public Foo getFoo(String name){
		throw new UnsupportedOperationException();
	}

	public Foo getFoo(String fooName, String barName){
		throw new UnsupportedOperationException();
	}

	public void insertFoo(Foo foo){
		throw new UnsupportedOperationException();
	}

	public void updateFoo(Foo foo){
		throw new UnsupportedOperationException();
	}

	
	
}
