package CodingPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmstrongNumberCheck {
	
	//Example of 3-digit Armstrong Number:
	//153
	//Number of digits = 3
	//1*3 + 5*3+ 3*3 = 1 + 125 + 27 = 153 ✅ So, 153 is an Armstrong number.

	public static void main(String[] args) {
		int inputNumber = 153;
		int originalNumber = inputNumber;
		int sum = 0;
		// Count digits
		int digits = String.valueOf(originalNumber).length();
		
		// Calculate sum of powered digits
		while(inputNumber > 0) {
			int digit = inputNumber%10; // get the last digit
			sum = sum + (int) Math.pow(digit, digits);
			inputNumber = inputNumber/10; //remove the last digit
		}
		
		// Check result
		if(originalNumber == sum) {
			System.out.println("Given Number "+originalNumber+" is Amstrong Number");
		} else {
			System.out.println("Given Number"+originalNumber+"is not a Amstrong Number");
		}
	}
}
