package my.edu.utar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrintingKiosk {
	int printingType;
	int differentDocSize;
	int docOption;
	int quantity = 0;
	int differentPhotoSize;
	int photoOption;
	int addonOption;
	char addOn;
	double charge = 0;
	double totalCharge = 0;
	double total = 0;
	ArrayList<Integer> doc = new ArrayList<Integer>(100);
	ArrayList<Integer> photo = new ArrayList<Integer>(100);
	Document document = new Document(printingType, quantity);
	order Order = new order(printingType, quantity);
	Photo photoClass = new Photo(printingType, quantity);
	Scanner s = new Scanner(System.in);

	// main program
	public static void main(String args[]) {
		int printingType = 0;
		menu();
		Scanner s = new Scanner(System.in);
		try {
			printingType = s.nextInt();
			PrintingKiosk pk = new PrintingKiosk();
			if (printingType == 1) {
				pk.CreateDoc();
			} else if (printingType == 2) {
				pk.CreatePhoto();
			} else if (printingType == 3) {
				pk.exit();
			} else {
				throw new IllegalArgumentException("must enter an integer within the available options!!");
			}
		} catch (InputMismatchException exception) {
			System.out.print("must enter an integer!! \n");
		}
		s.close();
	}

	// create document
	public void CreateDoc() {
		try {
			System.out.println("Please enter how many different document you want to print:");
			// get user input for array size
			differentDocSize = s.nextInt();
			doc = new ArrayList<>(differentDocSize);
		} catch (InputMismatchException exception) {
			System.out.print("must enter an integer!! \n");
		}
		try {
			if (differentDocSize > 50)
				document.docSizeException();
		} catch (IllegalArgumentException e) {
			System.out.println("Only can print 50 different sets of documents in one single order!");
		}
		if (differentDocSize <= 50) {
			// for loop according to user's size
			for (int i = 0; i < differentDocSize; i++) {
				try {
					System.out.println("New order\nPlease choose document option : (1 = black&white,2 = colour)");
					docOption = s.nextInt();
					// black and white
					if (docOption == 1) {
						try {
							blackAndWhiteDoc();
						} catch (InputMismatchException exception) {
							System.out.print("must enter an integer!! \n");
							break;
						}
					}
					// colour
					else if (docOption == 2) {
						try {
							colourDoc();
						} catch (InputMismatchException exception) {
							System.out.print("must enter an integer!! \n");
							break;
						}
					} else {
						System.out.println("enter an integer within the available options!!");
						break;
					}
					// compute total charge
					totalCharge += charge;
				} catch (InputMismatchException exception) {
					System.out.print("must enter an integer!! \n");
					break;
				}
			}
			Order.setTotalCharge(totalCharge);
			System.out.printf("Total printing charge of document = RM%.2f", Order.getTotalCharge());
			exit();
			s.close();
		}
	}

	// create photo
	public void CreatePhoto() {
		try {
			System.out.println("Please enter how many different photo you want to print:");
			// get user input for array size
			differentPhotoSize = s.nextInt();
			photo = new ArrayList<>(differentPhotoSize);
		} catch (InputMismatchException exception) {
			System.out.print("must enter an integer!! \n");
		}
		try {
			if (differentPhotoSize > 50)
				photoClass.photoSizeException();
		} catch (IllegalArgumentException e) {
			System.out.println("Only can print 50 different sets of photo in one single order!");
		}
		if (differentPhotoSize <= 50) {
			// for loop according to user's size
			for (int i = 0; i < differentPhotoSize; i++) {
				System.out.println("New order\nPlease choose photo option : (1 = 4R ,2 = Passport)");
				photoOption = s.nextInt();
				try {
					// 4R
					if (photoOption == 1) {
						try {
							fourRPhoto();
						} catch (IllegalArgumentException exception) {
							System.out.print("Enter the quantity between 1 and 50!! \n");
							break;
						}
						System.out.println("Do you want any additional option? (Y for yes only)");
						addOn = s.next().charAt(0);
						if (addOn == 'Y' || addOn == 'y') {
							addOn();
							System.out.println("Add On suceessfully!");
						} else {
							System.out.println("No add on choosen.");
						}
					}
					// Passport
					else if (photoOption == 2) {
						try {
							passportPhoto();
						} catch (IllegalArgumentException exception) {
							System.out.print("Enter the quantity between 1 and 50!! \n");
							break;
						}
						System.out.println("Do you want any additional option? (Y for yes only)");
						addOn = s.next().charAt(0);
						if (addOn == 'Y' || addOn == 'y') {
							addOn();
							System.out.println("Add On suceessfully!");
						} else {
							System.out.println("No add on choosen.");
						}
					} else {
						System.out.println("enter an integer within the available options!!");
						break;
					}

				} catch (InputMismatchException exception) {
					System.out.print("must enter an integer!! \n");
				}
				// compute total charge
				totalCharge += charge;
			}
			Order.setTotalCharge(totalCharge);
			System.out.printf("Total printing charge of photo = RM%.2f", Order.getTotalCharge());
			exit();
			s.close();
		}
	}

	// create black and white document
	public void blackAndWhiteDoc() {
		System.out.println("Please enter printing quantity:");
		quantity = s.nextInt();
		charge = document.BWRCalculation(quantity);
	}

	// create coloured document
	public void colourDoc() {
		System.out.println("Please enter printing quantity:");
		quantity = s.nextInt();
		charge = document.colourRCalculation(quantity);
	}

	// create 4R photo
	public void fourRPhoto() {
		System.out.println("Please enter printing quantity:");
		quantity = s.nextInt();
		charge = photoClass.fourRCalculation(quantity);
	}

	// create passport photo
	public void passportPhoto() {
		System.out.println("Please enter printing quantity:");
		quantity = s.nextInt();
		charge = photoClass.passportCalculation(quantity);
	}

	// create add on for photo
	public void addOn() {
		System.out.println("Choose your add on (1 = high quality, 2 = design effect)");
		addonOption = s.nextInt();
		// add on high quality
		if (addonOption == 1) {
			charge += photoClass.addOnHighQuality(quantity);
		}
		// add on design effect
		else if (addonOption == 2) {
			charge += photoClass.addOnDesignEffect(quantity);
		}

	}

	public void exit() {
		System.out.println(
				"\n\n=========================================================================================");
		System.out.println(" /$$$$$$$$ /$$                           /$$             /$$     /$$                 ");
		System.out.println("|__  $$__/| $$                          | $$            |  $$   /$$/                 ");
		System.out.println("   | $$   | $$$$$$$   /$$$$$$  /$$$$$$$ | $$   /$$       \\  $$ /$$//$$$$$$  /$$   /$$");
		System.out.println("   | $$   | $$__  $$ |____  $$| $$__  $$| $$  /$$/        \\  $$$$//$$__  $$| $$  | $$");
		System.out.println("   | $$   | $$  \\ $$  /$$$$$$$| $$  \\ $$| $$$$$$/          \\  $$/| $$  \\ $$| $$  | $$");
		System.out.println("   | $$   | $$  | $$ /$$__  $$| $$  | $$| $$_  $$           | $$ | $$  | $$| $$  | $$");
		System.out.println("   | $$   | $$  | $$|  $$$$$$$| $$  | $$| $$ \\  $$          | $$ |  $$$$$$/|  $$$$$$/");
		System.out.println("   |__/   |__/  |__/ \\_______/|__/  |__/|__/  \\__/          |__/  \\______/  \\______/ ");
		System.out.println("=========================================================================================");
	}

	public static void menu() {
		System.out.println("========================================================");
		System.out.println("     		Welcome to Printing Kiosk			  	    ");
		System.out.println("========================================================");
		System.out.println("\nPlease choose your printing type\n1 = document \n2 = photo \n3 = exit");
	}
}
