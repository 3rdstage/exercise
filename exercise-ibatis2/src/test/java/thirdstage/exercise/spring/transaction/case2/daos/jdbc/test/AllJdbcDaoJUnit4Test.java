package thirdstage.exercise.spring.transaction.case2.daos.jdbc.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	CompanyJdbcDaoJUnit4Test.class,
	BuildingJdbcDaoJUnit4Test.class,
	FactoryJdbcDaoJUnit4Test.class
	})
public class AllJdbcDaoJUnit4Test{

}
