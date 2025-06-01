package CodingPractice;

//1. It is divisible by 4  ✅
//2. Except years divisible by 100 ❌
//3. Unless they are also divisible by 400 ✅

public class LeapYear {
	public static void main(String[] args) {
		int year = 2016;
		
		if(year%4 == 0) {
			if((year%100 != 0) || (year%100 == 0 && year%400 == 0)) {
				System.out.println(year+ " is leap year");
			}
		}else {
			System.out.println(year+ " is not leap year");
		}
	}
}
