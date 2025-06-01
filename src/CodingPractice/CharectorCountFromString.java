package CodingPractice;

public class CharectorCountFromString {
	
	public static void main(String[] args) {
		String originalString = "This is a String Nikhil";
		char[] charArray = originalString.toCharArray();
		int count = 0;
		for(int i =0; i<charArray.length; i++) {
			if(charArray[i] == ' ') {
				continue;
			}
			count++;
		}
		System.out.println(count);
	}
}
