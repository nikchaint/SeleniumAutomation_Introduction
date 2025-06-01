package CodingPractice;
import java.util.HashMap;

public class CountTheAppearanceOfEachCharactersInGivenString {
	
	public static void main(String[] args) {
		String orignalString = "Nikhil Chaudhari";
		
		HashMap<Character, Integer> hash_map = new HashMap<Character, Integer>();
		
		char[] list = orignalString.toCharArray();
		
		for( Character c : list) { 
			if(hash_map.containsKey(c)) {
				hash_map.put(c, hash_map.get(c) + 1);
			}else {
				hash_map.put(c, 1);
			}
		}
		
		System.out.println(hash_map);

	}
}
