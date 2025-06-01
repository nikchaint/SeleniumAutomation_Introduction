package CodingPractice;

public class FebonacciSeries {
	//0, 1, 1, 2, 3, 5, 8, 13
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 1;
		int temp;
		
		System.out.print(num1);
		System.out.print(", "+ num2);
		
		for(int i = 2; i<10; i++) {
			temp = num1+num2;
			System.out.print(", "+ temp);
			num1 = num2;
			num2 = temp;
		}
		
	}
}
