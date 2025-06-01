package CodingPractice;

public class SwapTwoNumbersUsingTempVariable {
	
	public static void main(String[] args) {
		String string1 = "Nikhil";
		String string2 = "Chaudhari";
		String temp;
		
		temp = string2;
		string2 = string1;
		string1 = temp;
		
		System.out.println(string1+" "+string2);
		
	}
}
