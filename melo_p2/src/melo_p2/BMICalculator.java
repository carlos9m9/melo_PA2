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
	
	public static void main(String[] args) {
	    BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}

	private void readUserData() {
		Scanner in = new Scanner(System.in);
		int formulaPick;
		
		System.out.print("Enter 1 for metric or 2 for imperial units of measuement: ");
		formulaPick = in.nextInt();
		
		/*the variable formulaPick is used in this switch case statement to determine the units
		 * of measurement picked by the user*/
		switch (formulaPick){
		case 1:
			System.out.print("Please enter your weight in Kilograms (Ex: 57.7): ");
			weight = in.nextFloat();
			System.out.print("Please enter your height in Meters (Ex: 1.79): ");
			height = in.nextFloat();
			break;
		case 2:
			System.out.print("Please enter your weight in Pounds (Ex: 135.22): ");
			weight = in.nextFloat();
			/*I decided to calculate the top part of the equation from inside this method so I don't have to
			 * create a global varibale for the formulaPick variable or pass it to a different method*/
			weight *= 703; 
			System.out.print("Please enter your height in inches (Ex: 70.8): ");
			height = in.nextFloat();
			break;
		default:
			System.out.println("IVALID ENTRY");
		}
		in.close();
	}

	private void calculateBmi() {
		/*This calculation works for both kg and lbs given that I have already calculated the final weight
		 * in the previous method*/
		BMI = weight/(Math.pow(height, 2));
	}
	
	private void displayBmi() {
		System.out.println("");
		System.out.printf("Your BMI is: %.2f\r\n", BMI);
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
