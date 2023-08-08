package my.edu.utar;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PhotoCalculationTest {

	//BVA for passport calculation without add on
	@Test
	@Parameters({ "1, 1.2", "4,4.8", "5, 4.75", "10, 9.5", "11, 9.35", "20, 17", "21, 15.75", "50, 37.5" })
	public void testPassportCalculationWithoutAddOnBVA(double quantity, double ER) {
		Photo p = new Photo(2, 2);
		double AR = p.passportCalculation(quantity);
		assertEquals(ER, AR, 0);
	}

	//EP for passport calculation without add on
	@Test
	@Parameters({ "2, 2.4", "7,6.65", "15, 12.75", "35, 26.25" })
	public void testPassportCalculationWithoutAddOnEP(double quantity, double ER) {
		Photo p = new Photo(2, 2);
		double AR = p.passportCalculation(quantity);
		assertEquals(ER, AR, 0.1);
	}

	//passport calculation with add on
	@Test
	@Parameters(method = "passportCalculationAddOnTestParam")
	public void passportCalculationAddOnTest(int quantity, double charge, double er) {

		Photo photoMock = mock(Photo.class);
		order Order = new order(2, quantity);
		when(photoMock.passportCalculation(quantity)).thenReturn(charge);
		when(photoMock.addOnHighQuality(quantity)).thenReturn(charge);
		when(photoMock.addOnDesignEffect(quantity)).thenReturn(charge);
		charge = charge * quantity;
		Order.getTotalCharge();
		assertEquals(charge,er,0);
	}
	
	private Object[] passportCalculationAddOnTestParam() {
		return new Object[] {
				new Object[] {4,1.0,4.0},
				new Object[] {10,1.2,12},
				new Object[] {15,1.1,16.5},
				new Object[] {40,1,40},
		};
	}

	//invalid test for passport calculation
	@Test(expected = IllegalArgumentException.class)
	@Parameters({ "-1", "51" })
	public void passportCalculationExeptionTest(double quantity) {
		Photo p = new Photo(2, 2);
		p.passportCalculation(quantity);
	}
	
	//invalid test for 4R calculation
	@Test(expected = IllegalArgumentException.class)
	@Parameters({ "-1", "51", "-25", "75" })
	public void fourRCalculationExceptionTest(int quantity) {
		Photo photo = new Photo(2, quantity);
		photo.fourRCalculation(quantity);
	}

	//BVA for 4R calculation without add on
	@Test
	@Parameters(method = "fourRCalculationTestBVAParam")
	public void fourRCalculationTestBVA(int quantity, double charge, double er) {
		Photo photo = new Photo(2, quantity);
		charge = charge * quantity;
		System.out.println("Total Charge : " + charge);
		assertEquals(charge, er, 0);
	}

	private Object[] fourRCalculationTestBVAParam() {
		return new Object[] { 
				new Object[] { 4, 1.0, 4.0 }, 
				new Object[] { 5, 0.9, 4.5 }, 
				new Object[] { 10, 0.9, 9 },
				new Object[] { 11, 0.75, 8.25 }, 
				new Object[] { 20, 0.75, 15.0 }, 
				new Object[] { 21, 0.5, 10.5 },
				new Object[] { 50, 0.5, 25 } };
	}

	//EP for 4R calculation without add on
	@Test
	@Parameters(method = "fourRCalculationTestEPParam")
	public void fourRCalculationTestEP(int quantity, double charge, double er) {

		Photo photo = new Photo(2, quantity);
		charge = charge * quantity;
		System.out.println("Total Charge : " + charge);
		assertEquals(charge, er, 0);
	}

	private Object[] fourRCalculationTestEPParam() {
		return new Object[] { 
				new Object[] { 2, 1.0, 2.0 }, 
				new Object[] { 7, 0.9, 6.3 },
				new Object[] { 15, 0.75, 11.25 }, 
				new Object[] { 35, 0.5, 17.5 } };
	}

	//4R calculation with add on
	@Test
	@Parameters(method = "fourRCalculationAddOnTestParam")
	public void fourRCalculationAddOnTest(int quantity, double charge, double er) {

		Photo photoMock = mock(Photo.class);
		order Order = new order(2, quantity);
		when(photoMock.fourRCalculation(quantity)).thenReturn(charge);
		when(photoMock.addOnHighQuality(quantity)).thenReturn(charge);
		when(photoMock.addOnDesignEffect(quantity)).thenReturn(charge);
		charge = charge * quantity;
		Order.getTotalCharge();
		assertEquals(charge, er, 0);
	}

	private Object[] fourRCalculationAddOnTestParam() {
		return new Object[] {
				new Object[] { 2, 1.0, 2.0 },
				new Object[] { 7, 0.9, 6.3 },
				new Object[] { 15, 0.75, 11.25 },
				new Object[] { 35, 0.5, 17.5 }, };

	}
}
