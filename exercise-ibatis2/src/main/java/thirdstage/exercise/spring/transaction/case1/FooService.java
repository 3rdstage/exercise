package thirdstage.exercise.spring.transaction.case1;

public interface FooService{

	Foo getFoo(String name);
	Foo getFoo(String fooName, String barName);
	
	void insertFoo(Foo foo);
	void updateFoo(Foo foo);
}
