package CodingPractice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwapTheTwoString {
	
	public static void main(String[] args) {
		String originalString = "Hello Nikhil";
		List<String> string = Arrays.asList(originalString.split(" "));
		//System.out.println(string.get(1)+" "+string.get(0));
		
		Collections.swap(string, 0, 1);
		System.out.println(string);
		
		String string1 = "abcd";
		String string2 = "edfg";
		
		string1 = string1 + string2;
		System.out.println(string1);
		string2 = string1.substring(0, string1.length() - string2.length());
		string1 = string1.substring(string2.length());
		
		System.out.println(string1);
		System.out.println(string2);
		
	
	}
}
