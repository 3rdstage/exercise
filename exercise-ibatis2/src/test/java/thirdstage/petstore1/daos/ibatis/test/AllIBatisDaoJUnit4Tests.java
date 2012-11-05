package thirdstage.petstore1.daos.ibatis.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AccountIBatisDaoJUnit4Test.class,
	CategoryIBatisDaoJUnit4Test.class,
	ItemIBatisDaoJUnit4Test.class,
	OrderIBatisDaoJUnit4Test.class,
	ProductIBatisDaoJUnit4Test.class,
	SequenceIBatisDaoJUnit4Test.class})

public class AllIBatisDaoJUnit4Tests{
}
