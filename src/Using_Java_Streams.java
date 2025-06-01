import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Using_Java_Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		ArrayList<String> list = new ArrayList<String>();

		list.add("Amaan");
		list.add("Akshay");
		list.add("Nikhil");
		list.add("Vineet");
		list.add("Alok");
		list.add("Ram");

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).startsWith("A")) {
				count++;
			}
		}

		System.out.println(count);

		System.out.println("===========================================================");

//working with Streams
		// Filter with starting with "A"
		Long c = list.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		// format if we have more than one line of code
		Long d = Stream.of("Amaan", "Akshay", "Nikhil", "Vineet", "Alok", "Ram", "Ashish").filter(s -> {
			return s.startsWith("A");
		}).count();
		System.out.println(d);

		System.out.println("===========================================================");

		// sorting and print in output
		Stream.of("Amaan", "Akshay", "Nikhil", "Vineet", "Alok", "Ram", "Ashish").sorted()
				.forEach(s -> System.out.println(s));

		System.out.println("===========================================================");

		// filter steam with end with "s", manupuate the filtered stream to Uppercase
		// and Print the stream
		Stream.of("Amaan", "Akshay", "Nikhil", "Vineetn", "Alok", "Ram", "Ashish").filter(s -> s.endsWith("n"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

		System.out.println("===========================================================");

		// Limit the Stream
		Stream.of("Amaan", "Akshay", "Nikhil", "Vineetn", "Alok", "Ram", "Ashish").filter(s -> s.startsWith("A"))
				.limit(2).forEach(s -> System.out.println(s));

		System.out.println("===========================================================");

		// Converting Array to List
		List<String> abc = Arrays.asList("Amaan", "Akshay", "Nikhil", "Vineetn", "Alok", "Ram", "Ashish");
		abc.forEach(s -> System.out.println(s));

		System.out.println("===========================================================");

		// Concatinating the two Lists
		List<String> list1 = Arrays.asList("Mayur", "Priya", "Shiv");
		List<String> list2 = Arrays.asList("Nilesh", "Leena", "Sarthak", "Tisha");

		Stream<String> finalStream = Stream.concat(list1.stream(), list2.stream());
		finalStream.forEach(s -> System.out.println(s));

		System.out.println("===========================================================");

		// Collect the Stream in to the List
		List<String> list4 = Stream.of("Amaan", "Akshay", "Nikhil", "Vineet", "Alok", "Ram", "Ashish").sorted()
				.collect(Collectors.toList());
		System.out.println(list.get(2));

		System.out.println("===========================================================");

		// finds if exact value available using Stream
		boolean flag = Stream.of("Amaan", "Akshay", "Nikhil", "Vineetn", "Alok", "Ram", "Ashish")
				.anyMatch(s -> s.equalsIgnoreCase("Nikhil"));
		System.out.println(flag);

		System.out.println("===========================================================");

		// Find the unique values using Steam
		List<Integer> a = Arrays.asList(1, 2, 2, 4, 5, 5, 6, 7, 8, 9, 0, 0);
		a.stream().distinct().sorted().forEach(s -> System.out.println(s));

		System.out.println("=============================Selenium==============================");

//Using Streams in Selenium
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th")).click();
		
		//Clicks table header to sort column.
		//Captures veg names before and after sorting to check if sorting works correctly.
//		List<WebElement> webElements = driver.findElements(By.xpath("//tr/td[1]"));
//		
//		List<String> originalList = webElements.stream().map(s->s.getText()).collect(Collectors.toList());
//		
//		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
//		
//		Assert.assertTrue(originalList.equals(sortedList));

		System.out.println("=============================Selenium==============================");
		//Loop through pages until "Rice" is found in the first column.
		//For matching row(s), extract the price using GetValueOfVeggies() method.
		List<String> valueofElement;
		do {
			List<WebElement> webElements = driver.findElements(By.xpath("//tr/td[1]"));
			valueofElement = webElements.stream().filter(s -> s.getText().contains("Rice"))
					.map(s -> GetValueOfVeggies(s)).collect(Collectors.toList());

			valueofElement.forEach(s -> System.out.println(s));

			if (valueofElement.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		} while (valueofElement.size() < 1);
		
		//Clicks "First" page, then uses search box to filter “Rice”.
		driver.findElement(By.cssSelector("a[aria-label='First']")).click();
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> webElements1 = driver.findElements(By.xpath("//tr/td[1]"));
		//Ensures all visible rows contain the text “Rice”.
		List<WebElement> results = webElements1.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(webElements1, results);

	}
	
	//From the row where "Rice" is found, fetches the price by selecting the next column (td).	
	private static String GetValueOfVeggies(WebElement s) {
		// TODO Auto-generated method stub
		String value = s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();
		return value;
	}

}
