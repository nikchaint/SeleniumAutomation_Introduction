package CodingPractice;

import java.util.Arrays;

public class ReverseTheString {
	
	public static void main(String[] args) {
		String name = "Nikhil";
		char[] chars = name.toCharArray();
		for (int i = chars.length - 1; i>=0; i-- ) {
			System.out.print(chars[i]);
		}
		
		System.out.println();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		for(int i = name.length()-1; i>=0; i--) {
			System.out.print(name.charAt(i));
		}
		
		System.out.println();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		String reverseString = new StringBuilder(name).reverse().toString();
		System.out.println(reverseString);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	
		//reduce(initial_value, (accumulator, current_value))
		//initial_value
//		This is the starting point for your result.
//		Example: If you’re building a string, it might be "".
//		✅ (accumulator, current_value)
//		This is a function (called a BinaryOperator) that takes:
//		accumulator: what you've built so far.
//		current_value: the current element from the stream.
//		It returns the new value of the accumulator after combining it with the current item.
		String revString = Arrays.stream(name.split("")).reduce("",(a,b)-> b+a);
		System.out.println(revString);
		
	}

}
