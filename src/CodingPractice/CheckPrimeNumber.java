package CodingPractice;

import java.util.ArrayList;
import java.util.List;

public class CheckPrimeNumber {
	
	public static void main(String[] args) {
		int[] arrayInt = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> primeNumberArray = new ArrayList();
		for (int i = 0; i<arrayInt.length; i++) {
			if(arrayInt[i]%2 == 0) {
				primeNumberArray.add(arrayInt[i]);
			}
		}
		
		primeNumberArray.stream().forEach(s-> System.out.println(s));
		
	}
}
