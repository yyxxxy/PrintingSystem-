package my.edu.utar;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class QuantityTest {

	//valid test of document quantity
	@Test
	@Parameters(method="testDocQuantityParam")
	public void testDocQuantity(int quantity) {
		Document doc = new Document(1,quantity);
		doc.BWRCalculation(quantity);
		doc.colourRCalculation(quantity);
	}
	
	private Object[] testDocQuantityParam() {
		return new Object[] { 
				new Object[] {4},
				new Object[] {5},
				new Object[] {10},
				new Object[] {11},
				new Object[] {20},
				new Object[] {21},
				new Object[] {50}
				};
	}
	
	//invalid test of document quantity
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="InvalidTestDocQuantityParam")
	public void InvalidTestDocQuantity(int quantity) {
		Document doc = new Document(1,quantity);
		doc.BWRCalculation(quantity);
		doc.colourRCalculation(quantity);
	}
	
	private Object[] InvalidTestDocQuantityParam() {
		return new Object[] { 
				new Object[] {-1},
				new Object[] {0},
				new Object[] {55}
				};
	}
	
	//invalid test of photo quantity
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method="InvalidTestPhotoQuantityParam")
	public void InvalidTestPhotoQuantity(int quantity) {
		Photo photo = new Photo(2,quantity);
		photo.fourRCalculation(quantity);
		photo.passportCalculation(quantity);
	}
	
	private Object[] InvalidTestPhotoQuantityParam() {
		return new Object[] { 
				new Object[] {-1},
				new Object[] {0},
				new Object[] {55}
				};
	}
	
	//valid test of photo quantity
	@Test
	@Parameters(method="testPhotoQuantityParam")
	public void testPhotoQuantity(int quantity) {
		Photo photo = new Photo(2,quantity);
		photo.fourRCalculation(quantity);
		photo.passportCalculation(quantity);
	}
		
	private Object[] testPhotoQuantityParam() {
		return new Object[] { 
				new Object[] {4},
				new Object[] {5},
				new Object[] {10},
				new Object[] {11},
				new Object[] {20},
				new Object[] {21},
				new Object[] {50}
				};
		}

}
