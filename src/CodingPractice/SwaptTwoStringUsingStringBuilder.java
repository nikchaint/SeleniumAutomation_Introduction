package CodingPractice;

public class SwaptTwoStringUsingStringBuilder {
	public static void main(String[] args) {
		String string1 = "Nikhil";
		String string2 = "Chaudhari";
		
		StringBuilder result = new StringBuilder();
		
		result.append(string1).append(string2);
		
		int i = string1.length();
		
		string1 = result.substring(i, result.length());
		string2 = result.substring(0, result.length() - string1.length());
		System.out.println(string1);
		System.out.println(string2);
	}
}
