package my.edu.utar;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PrintingTypeTest {

	//Test if the printing type is working properly
	@Test
	@Parameters(method = "printTypeTestParam")
	public void printTypeTest(int printingType, int er) {
		order orderMock = mock(order.class);
		when(orderMock.getPrintingType()).thenReturn(printingType);
		if (printingType == 1) {
			System.out.println("\nGoing to create document"); 
		} else if (printingType == 2) {
			System.out.println("\nGoing to create photo");
		} else if (printingType == 3) {
			System.out.println("\nYou have chose to exit"); 
		}
		printingType = orderMock.getPrintingType();
		assertEquals(printingType, er);

	}

	private Object[] printTypeTestParam() {
		return new Object[] { 
				new Object[] {1,1}, 
				new Object[] {2,2}, 
				new Object[] {3,3}
				};

	}
	
	//Invalid test for printing type
	@Test(expected=IllegalArgumentException.class)
	@Parameters(method = "InvalidPrintTypeTestParam")
	public void InvalidPrintTypeTest(int printingType) {
		order orderMock = mock(order.class);
		when(orderMock.getPrintingType()).thenReturn(printingType);
		if (printingType == 1) {
			System.out.println("\nGoing to create document"); 
		} else if (printingType == 2) {
			System.out.println("\nGoing to create photo");
		} else if (printingType == 3) {
			System.out.println("\nyou have chose to exit"); 
		} else
		{
			throw new IllegalArgumentException("\nInvalid input! Please enter 1-3 only!");
		}
		printingType = orderMock.getPrintingType();

	}

	private Object[] InvalidPrintTypeTestParam() {
		return new Object[] { 
				new Object[] {4},
				new Object[] {-1},
				new Object[] {8},
				new Object[] {10},
				new Object[] {-8}
				};

	}
}
