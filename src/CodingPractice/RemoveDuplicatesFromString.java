package CodingPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromString {
	
	public static void main(String[] args) {
		String originalString = "hahkerearthe";
		
		//Using Stream and distict menthod
//		List<String> outputString = Arrays.stream(originalString.split("")).distinct().collect(Collectors.toList());
//		outputString.stream().forEach(s -> System.out.println(s));
		
		//Using loops and Sets
		
		char[] charecters = originalString.toCharArray();
		Set<Character> uniqueCharacter = new LinkedHashSet<>();
		
		for(Character charecter : charecters) {
			if(!uniqueCharacter.contains(charecter)) {
				uniqueCharacter.add(charecter);
			}
		}
		
		uniqueCharacter.stream().forEach(s->System.out.println(s));
		
		
		
	}
}
