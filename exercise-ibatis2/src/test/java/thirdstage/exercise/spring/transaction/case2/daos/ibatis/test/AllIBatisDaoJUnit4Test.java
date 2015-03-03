package thirdstage.exercise.spring.transaction.case2.daos.ibatis.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CompanyIBatisDaoJUnit4Test.class,
	BuildingIBatisDaoJUnit4Test.class,
	FactoryIBatisDaoJUnit4Test.class
})
public class AllIBatisDaoJUnit4Test{



}
