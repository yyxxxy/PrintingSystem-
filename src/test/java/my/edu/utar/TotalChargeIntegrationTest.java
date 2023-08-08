
package my.edu.utar;

import static org.junit.Assert.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class TotalChargeIntegrationTest {
	int printingType;
	int quantity;
	order Order = new order();

	// Set order cases to test
	//Document
	//BWRCalculation
	order o1 = new order(0.5, 4);
	order o2 = new order(0.4, 5);
	order o3 = new order(0.4, 10);
	order o4 = new order(0.3, 11);
	order o5 = new order(0.3, 20);
	order o6 = new order(0.2, 21);
	order o7 = new order(0.2, 50);
	
	//colourRCalculation
	order o8 = new order(1.0, 4);
	order o9 = new order(0.9, 5);
	order o10 = new order(0.9, 10);
	order o11 = new order(0.8, 11);
	order o12 = new order(0.8, 20);
	order o13 = new order(0.7, 21);
	order o14 = new order(0.7, 50);
	
	//Photo
	//fourRCalculation
	order o15 = new order(1.0, 4);
	order o16 = new order(0.9, 5);
	order o17 = new order(0.9, 10);
	order o18 = new order(0.75, 11);
	order o19 = new order(0.75, 20);
	order o20 = new order(0.5, 21);
	order o21 = new order(0.5, 50);
	
	//passportCalculation
	order o22 = new order(1.2, 4);
	order o23 = new order(0.95, 5);
	order o24 = new order(0.95, 10);
	order o25 = new order(0.85, 11);
	order o26 = new order(0.85, 20);
	order o27 = new order(0.75, 21);
	order o28 = new order(0.75, 50);

	ArrayList<order> orderRecords = new ArrayList<order>();

	@Test
	public void getDocTotalChargeTest() {

		double totalInputArray = 0.0;
		double totalorderArray = 0.0;
		// Set decimal places to 2 d.p
		DecimalFormat df = new DecimalFormat("0.00");
		order[] inputArray = new order[] { o1, o2 };

		// selected the records
		ArrayList<order> selectedRecords = new ArrayList<>(Arrays.asList(inputArray));
		Order.setSelectedRecords(selectedRecords);
		Order.initializeRecordsFromFile("demo.txt");
		// records from text file
		ArrayList<order> orderRecords = Order.getOrderRecords();
		order[] orderArray = new order[orderRecords.size()];
		orderArray = orderRecords.toArray(orderArray);

		// Use to calculate the total
		for (int i = 0; i < inputArray.length; i++) {
			totalInputArray += inputArray[i].getCharges() * inputArray[i].getQuantity();
			totalorderArray += orderArray[i].getCharges() * orderArray[i].getQuantity();
		}
		
		// Compare the total
		assertEquals(df.format(totalInputArray), df.format(totalorderArray));

	}
}
