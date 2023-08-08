package my.edu.utar;

//abstract class from order
public class Document extends order {
	double charge;

	// super class
	public Document(int printingType, int quantity) {
		super(printingType, quantity);
	}

	// black and white calculation
	public double BWRCalculation(double quantity) {
		if(quantity <= 0 || quantity > 50)
			throw new IllegalArgumentException();
		if (quantity < 5)
			charge = 0.50;
		else if (quantity >= 5 && quantity <= 10)
			charge = 0.40;
		else if (quantity >= 11 && quantity <= 20)
			charge = 0.30;
		else if (quantity >= 21 && quantity <= 50)
			charge = 0.20;
		return charge = charge * quantity;
	}

	// colour calculation
	public double colourRCalculation(double quantity) {
		if(quantity <= 0 || quantity > 50)
			throw new IllegalArgumentException();
		if (quantity < 5)
			charge = 1.00;
		else if (quantity >= 5 && quantity <= 10)
			charge = 0.90;
		else if (quantity >= 11 && quantity <= 20)
			charge = 0.80;
		else if (quantity >= 21 && quantity <= 50)
			charge = 0.70;
		return charge = charge * quantity;

	}
	
	public String docSizeException()
	{
		throw new IllegalArgumentException("Only can print 50 different sets of documents in one single order!");
		
	}
	


}
