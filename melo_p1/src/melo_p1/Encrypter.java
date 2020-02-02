package melo_p1;

public class Encrypter {

	public String encrypt(int num) {
		
		//Separate the int into individual digits by using the mod operator
		int di_1 = num/1000;
		int di_2 = (num%1000)/100;
		int di_3 = (num% 100)/10;
		int di_4 = num%10;
		
		//Encryption part of each digit
		di_1 = (di_1+7)%10;
		di_2 = (di_2+7)%10;
		di_3 = (di_3+7)%10;
		di_4 = (di_4+7)%10;

		/*I return my new integer as a string to avoid losing
		digits like "0" by addition*/
		String newNum = "" + di_3 + di_4 + di_1 + di_2;
		
		
		return newNum;
	}

}
