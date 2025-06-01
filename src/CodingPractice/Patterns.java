package CodingPractice;
public class Patterns {
	//Reverse the string using reverse function
	public static String reverseStringWithoutReverseFunction(String str) {
		String reversed = "";
		
		for (int i = str.length() -1; i>=0; i--) {
			reversed = reversed + str.charAt(i);
		}
		return reversed;	
	}
	
	public static String reverseStringWithReverseFunction(String abc) {
		String reverse = new StringBuilder(abc).reverse().toString();
		return reverse;
	}
	
	public static boolean Palindromecheck(String str) {
		String palindrome = new StringBuilder(str).reverse().toString();
		return palindrome.equalsIgnoreCase(str);
		
	}
	
	public static void main (String[] args) {
		//Reverse the string without using Reverse function
		System.out.println("Reverse the string using own function"+ reverseStringWithoutReverseFunction("Code")); 
		
		//Reverse the string with using Reverse function
		System.out.println(reverseStringWithReverseFunction("Selenium"));
		
		//Palindrome (aba == aba)
		boolean a = Palindromecheck("aba");
		if(a == true) {
			System.out.println(Palindromecheck("aba")+" provied string is palindrome");
		} else {
			System.out.println(Palindromecheck("aba")+" provied string is not palindrome");
		}
		
		System.out.println("======================================");
		int[] arr = {0,1,2,3,4};
	    System.out.println(arr[0]+ " is first number of the array");
	    System.out.println(arr[arr.length - 1] + " is last number of the array"); 
	        
	    for(int i = arr.length - 1; i>=0; i--){
	    	System.out.println(arr[i]);
	    }
	        
	    System.out.println("Total number in array "+ arr.length);
	        
	    System.out.println("======================================");
	    
	    /* 
	     Print the below Pattern
	     1 
		 2 3 
		 4 5 6 
		 7 8 9 10
	     */
		
	    int num = 0;
		for(int i = 1; i<=4; i++) {
			for (int j = 1; j <= i; j++){
				num = num + 1;
				System.out.print(num+ " ");
			}
		
		System.out.println();
		}
		System.out.println("======================================");
		/* 
	     Print the below Pattern
	     1 2 3 4 
		 5 6 7 
		 8 9 
		 10
	     */
		int x = 0;
		for (int i = 1; i<=4; i++)
		{
			for (int j = i; j<=4; j++)
			{
				x = x + 1;
				System.out.print(x+ " ");
			}
			System.out.println();
		}
		
		System.out.println("======================================");
		/* 
	     Print the below Pattern
	     1  
		 1 2  
		 1 2 3  
		 1 2 3 4
	     */
		
		for (int i = 1; i<=4; i++)
		{
			int z = 0;
			for(int j = 1; j<=i; j++)
			{
				z++;
				System.out.print(z+ " ");
			}
			System.out.println();
		}
		System.out.println("======================================");
		/* 
	     Print the below Pattern
    	1
       2 3
      4 5 6
     7 8 9 10
	     */
		int num1 = 0;
		int n = 4;
		for (int i = 1; i<=4; i++ ) {
			for(int j = i; j<n; j++) {
				System.out.print(" ");
			}
			for(int j =1; j<=i; j++) {
				num1++;
				System.out.print(num1+ " ");
			}
			System.out.println();
		}
		System.out.println("======================================");
		/* 
	     Print the below Pattern
    1 2 3 4
     5 6 7
      8 9
       10
	     */
		int n1 = 4;
		int num2 = 0;
		for(int i = 1; i<=n1; i++) {
			for (int j = i; j<=n1; j ++) {
				num2 ++;
				System.out.print(num2+ " ");
			}
			System.out.println();
			
			for (int j = 1;j <= i; j++ ) {
				System.out.print(" ");
			}
		}
		System.out.println("======================================");
		/* 
	     Print the below Pattern
	     1    
		 1 2 1 
		 1 2 3 2 1
		 1 2 3 4 3 2 1
	     */
		for (int i = 1; i<=4; i++) {
			for (int j = 1; j<=i; j++) {
				System.out.print(j+ " ");
			}
			for (int j = i-1;j>=1; j--) {
				System.out.print(j+ " ");
			}
			System.out.println();
			
		}
		
		
	}
}