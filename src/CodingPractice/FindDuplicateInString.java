package CodingPractice;

import java.util.ArrayList;
import java.util.List;

// Find duplicate char from string. Write a program to find duplicate characters in a given String.
//Input: hackerearth
//Output: h a e r

public class FindDuplicateInString {
	
	public static void main(String[] args) {
		String originalString = "hahkerearthe";
		for (int i = 0; i<originalString.length(); i++) {
			
			boolean isDuplicate = false;
			//First Inner Loop: Check if the character has been seen before
			//This loop checks characters before the current character (from index 0 to i-1).
			//If ch has already appeared, set isDuplicate = true.
			//This avoids printing the same duplicate multiple times.
			for (int k = 0; k < i; k++) {
                if (originalString.charAt(k) == originalString.charAt(i)) {
                    isDuplicate = true;
                    break;
                }
            }
			
			//Skip already-processed duplicates
			//If this character was already seen earlier, skip the rest of the loop and move to the next character.
            if (isDuplicate) {
                continue;
            }
            
            //Second Inner Loop: Check for duplicates ahead
            //This loop checks the characters after the current character.
            //If any of them match ch, then it's a duplicate — print it and break.
			for(int j = i + 1; j<originalString.length(); j++) {
				if(originalString.charAt(i) == originalString.charAt(j)) {
					System.out.println(originalString.charAt(i));
					break;
				}	
			}
			
		}
	}
}
