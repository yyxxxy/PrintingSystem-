package my.edu.utar;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = { DocumentCalculationTest.class, PhotoCalculationTest.class,PrintingTypeTest.class,QuantityTest.class,SizeExceptionTest.class,TotalChargeIntegrationTest.class })
public class TestSuite {


}
