package my.edu.utar;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class DocumentCalculationTest {

	//BVA for Black&White Calculation
	@Test
	@Parameters({"1,0.50","4,2.00","5,2.00","10,4.00","11,3.30","20,6.00","21,4.20","50,10.00"})
	public void testBWRCalculationBVA(int quantity,double exCharge) {
		Document doc=new Document(1,quantity);
		assertEquals(doc.BWRCalculation(quantity),exCharge,1);
	}

	//EP for Black&White Calculation
	@Test
	@Parameters({"2,1.00","8,3.20","16,4.80","36,7.20"})
	public void testBWRCalculationEPValidInput(int quantity,double exCharge) {
		Document doc=new Document(1,quantity);
		assertEquals(doc.BWRCalculation(quantity),exCharge,0);
	}
	
	//invalid test for Black&White Calculation
	@Test(expected=IllegalArgumentException.class)
	@Parameters({"0","51"})
	public void testBWRCalculationInValidValues(int quantity) {
		Document doc=new Document(1,quantity);
		doc.BWRCalculation(quantity);
	}
	
	//BVA for colour calculation
	@Test
	@Parameters({"1,1.00","4,4.00","5,4.50","10,9.00","11,8.80","20,16.00","21,14.70","50,35.00"})
	public void testColourRCalculationValidInputBVA(int quantity,double exCharge) {
		Document doc=new Document(1,quantity);
		assertEquals(doc.colourRCalculation(quantity),exCharge,1);
	}
	
	//EP for colour calculation
	@Test
	@Parameters({"2,2.00","8,7.20","16,12.80","36,25.20"})
	public void testColourRCalculationValidInputEP(int quantity,double exCharge) {
		Document doc=new Document(1,quantity);
		assertEquals(doc.colourRCalculation(quantity),exCharge,0);
	}
	
	//Invalid test for colour calculation
	@Test(expected=IllegalArgumentException.class)
	@Parameters({"0","51"})
	public void testColourRCalculationInValidInput(int quantity) {
		Document doc=new Document(1,quantity);
		doc.colourRCalculation(quantity);
	}
}
