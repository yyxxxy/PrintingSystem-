package my.edu.utar;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;



public class order {
	protected double charges;
	protected int quantity;
	protected double totalCharge;
	ArrayList<order> orderRecords = new ArrayList<order>();
	ArrayList<order> selectedRecords = new ArrayList<order>();
	protected int printingType;
	
	public int getPrintingType() {
		return printingType;
	}

	public void setPrintingType(int printingType) {
		this.printingType = printingType;
	}

	public order(){
		
	}
	
	public order(double charges, int quantity) {
		this.charges = charges;
		this.quantity = quantity;
	}
		
	public double getCharges() {
		return charges;
	}


	public void setCharges(double charges) {
		this.charges = charges;
	}


	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public ArrayList<order> getOrderRecords() {
		return orderRecords;
	}

	public void setOrderRecords(ArrayList<order> orderRecords) {
		this.orderRecords = orderRecords;
	}

	public ArrayList<order> getSelectedRecords() {
		return selectedRecords;
	}

	public void setSelectedRecords(ArrayList<order> selectedRecords) {
		this.selectedRecords = selectedRecords;
	}

	//to read demo.txt for test
	public String[] readStringsFromFile(String fileName) {
		
		ArrayList<String> stringsRead = new ArrayList<>();

		File fileToRead = new File(fileName);
		Scanner inputStream = null;
		
		try {
			inputStream = new Scanner(fileToRead);
		}
		
		catch(FileNotFoundException e)
		{
			throw new IllegalArgumentException("File does not exist : " + fileName);
		}
		
		String lineRead = null;
		while (inputStream.hasNextLine())
		{
			lineRead = inputStream.nextLine();
			stringsRead.add(lineRead);
		}
		inputStream.close();
		
		String[] arrayToReturn = new String[stringsRead.size()];
		arrayToReturn = stringsRead.toArray(arrayToReturn);
		return arrayToReturn;
	}

		public void initializeRecordsFromFile(String fileName) {

		String[] stringsRead = null; 
		String[] items;
		stringsRead = readStringsFromFile(fileName);
		
		double totalCharge = 0.00;
		DecimalFormat df = new DecimalFormat("0.00");

		for (String line : stringsRead) {

			items = line.split(",");
			order Order = new order(Double.parseDouble(items[0]),Integer.parseInt(items[1]));
			orderRecords.add(Order);	
		}
	}
		public double getTotalCharge() {
			return totalCharge;
		}

		public void setTotalCharge(double totalCharge) {
			this.totalCharge = totalCharge;
		}

}
