package melo_p1;

public class Decrypter {

	public String decrypt (int num) {

		//Separate the int into individual digits by using the mod operator
		int di_1 = num/1000;
		int di_2 = (num%1000)/100;
		int di_3 = (num%100)/10;
		int di_4 = num%10;
		
		//Encryption part of each digit
		di_1 = (di_1+3)%10;
		di_2 = (di_2+3)%10;
		di_3 = (di_3+3)%10;
		di_4 = (di_4+3)%10;
		
		/*I return my new integer as a string to avoid losing
		digits like "0" by addition*/
		String newNum = "" + di_3 + di_4 + di_1 + di_2;
		
		return newNum;
	}

}
