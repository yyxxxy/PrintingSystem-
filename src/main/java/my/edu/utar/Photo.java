package my.edu.utar;

//abstract class from order
public class Photo extends order {
	double charge;

	// super class
	public Photo(int printingType, int quantity) {
		super(printingType, quantity);
	}

	// 4R Calculation
	public double fourRCalculation(double quantity) {
		if(quantity <= 0 || quantity > 50)
			throw new IllegalArgumentException();
		else if (quantity < 5)
			charge = 1.00;
		else if (quantity >= 5 && quantity <= 10)
			charge = 0.90;
		else if (quantity >= 11 && quantity <= 20)
			charge = 0.75;
		else if (quantity >= 21 && quantity <= 50)
			charge = 0.50;
		return charge = charge * quantity;
	}

	// passport calculation
	public double passportCalculation(double quantity) {
		if(quantity <= 0 || quantity > 50)
			throw new IllegalArgumentException();
		if (quantity < 5)
			charge = 1.20;
		else if (quantity >= 5 && quantity <= 10)
			charge = 0.95;
		else if (quantity >= 11 && quantity <= 20)
			charge = 0.85;
		else if (quantity >= 21 && quantity <= 50)
			charge = 0.75;
		return charge = charge * quantity;
	}

	// add on - High Quality calculation
	public double addOnHighQuality(double quantity) {
		charge = 0.10;
		return charge = charge * quantity;
	}

	// add on - Design Effect calculation
	public double addOnDesignEffect(double quantity) {
		charge = 0.15;
		return charge = charge * quantity;
	}

	public String photoSizeException() {
		throw new IllegalArgumentException("Only can print 50 different sets of photos in one single order!");

	}
}
