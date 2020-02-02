/*A company that wants to send data over the Internet has asked you to write a program that will encrypt it so that
 *it may be transmitted more securely. All the data is transmitted as four-digit integers. Your application should
 *read a four-digit integer entered by the user and encrypt it as follows: Replace each digit with the result of
 *adding 7 to the digit and getting the remainder after dividing the new value by 10. Then swap the first digit with
 *the third, and swap the second digit with the fourth. Then print the encrypted integer. Your application should
 *also allow the user to enter an encrypted four-digit integer and then decrypt it (by reversing the encryption 
 *scheme) to form the original number.*/

package melo_p1;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		//Declare scanner and variable used to store int which will be encrypted and decrypted
		int num;
		String en_num, de_num;
		Scanner in = new Scanner(System.in);
		
		//Read user input
		System.out.print("Please enter an integer you would like to encrypt: ");
		num = in.nextInt();
		//Pass it on to the encrypter class
		Encrypter Encrypter = new Encrypter();
		en_num = Encrypter.encrypt(num);
		//Display returned value
		System.out.println("Your encrypted number is: "+en_num);
		
		//Read user input
		System.out.print("Please enter an integer you would like to decrypt: ");
		num = in.nextInt();
		//Pass it on to the encrypter class
		Decrypter Decrypter = new Decrypter();
		de_num = Decrypter.decrypt(num);
		//Display returned value
		System.out.println("Your decrypted number is: "+ de_num);
		
		in.close();
	}

}
