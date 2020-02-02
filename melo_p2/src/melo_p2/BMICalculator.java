/*Create a BMI calculator that reads the user’s weight and height (providing an option for the user to select which
 *formula to use), and then calculates and displays the user’s body mass index. Also, display the BMI categories and
 *their values from the National Heart Lung and Blood Institute: 
 *http://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmicalc.htm (Links to an external site.) so the user can 
 *evaluate his/her BMI.*/

package melo_p2;
import java.util.Scanner;
import java.lang.Math;

public class BMICalculator {
	//Declaring global variables accessible to all methods 
	private double weight, height, BMI;
	private String BMIcategory;
	Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
	    BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}

	private void readUserData() {
		
		int unit = readUnitType();
		readMeasurementData(unit);
		
		
	}

	private int readUnitType() {
		
		System.out.print("Enter 1 for metric or 2 for imperial units of measuement: ");
		int unit = in.nextInt();
		return unit;
	}
	
	private void readMeasurementData(int unit) {
		int i=0;
		while(i<=0) {
			switch (unit){
			case 1:
				readMetricData();
				i+=1;
				break;
			case 2:
				readImperialData();
				i+=1;
				break;
			default:
				System.out.println("IVALID ENTRY");
			}
		}
	}
	
	private void readMetricData() {
		System.out.print("Please enter your weight in Kilograms (Ex: 57.7): ");
		weight = in.nextFloat();
		if(weight<0) {
			System.exit(0); 
		}
		System.out.print("Please enter your height in Meters (Ex: 1.79): ");
		height = in.nextFloat();
		if(height<0) {
			System.exit(0); 
		}
	}
	
	private void readImperialData() {
		System.out.print("Please enter your weight in Pounds (Ex: 135.22): ");
		weight = in.nextFloat();
		if(weight<0) {
			System.exit(0); 
		}
		/*I decided to calculate the top part of the equation from inside this method so I don't have to
		 * create a global varibale for the formulaPick variable or pass it to a different method*/
		weight *= 703; 
		System.out.print("Please enter your height in inches (Ex: 70.8): ");
		height = in.nextFloat();
		if(height<0) {
			System.exit(0); 
		}
	}


	public void calculateBmi() {
		/*This calculation works for both kg and lbs given that I have already calculated the final weight
		 * in the previous method*/
		BMI = weight/(Math.pow(height, 2));
		BMIcategory=calculateBmiCategory(BMI);
	}
	
	private String calculateBmiCategory(double bmi) {
		String category = null;
		if(bmi<=18.5) {
			category="Underweight";
		}else if (bmi>18.5&&bmi<=24.9) {
			category ="Normal Weight";
		}else if(bmi>=25&&bmi<=29.9) {
			category="Overweight";
		}else if(bmi>30) {
			category = "Obesity";
		}
		return category;
	}

	public void displayBmi() {
		System.out.println("");
		System.out.printf("Your BMI is: %.2f\r\n", BMI);
		System.out.printf("Your BMI category is: "+	BMIcategory);
		System.out.println("");
		System.out.println("+--------------------------------+");
		System.out.println("|         BMI CATEGORIES         |");
		System.out.println("+--------------------------------+");
		System.out.println("|       Underweight = <18.5      |");
		System.out.println("|    Normal weight = 18.5–24.9   |");
		System.out.println("|       Overweight = 25–29.9     |");
		System.out.println("| Obesity = BMI of 30 or greater |");
		System.out.println("+--------------------------------+");
	}
	
}
