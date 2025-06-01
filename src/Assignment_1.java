import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

// Add Selenium WebDriver dependency to pom.xml:
// <dependency>
//     <groupId>org.seleniumhq.selenium</groupId>
//     <artifactId>selenium-java</artifactId>
//     <version>4.18.1</version>
// </dependency>

public class Assignment_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#password")).sendKeys("learning");
		driver.findElement(By.xpath("//label[@class='customradio'][2]/span[@class='checkmark']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		driver.findElement(By.xpath("//select[@class='form-control']")).click();
		WebElement element = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select = new Select(element);
		select.selectByValue("teach");
		driver.findElement(By.cssSelector("input[id='terms']")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4.card-title a")));
		
		//String[] products = {"iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry"};
		//List<String> prodcutNames = Arrays.asList(products);
		List<WebElement> elements = driver.findElements(By.xpath("//div/button[@class='btn btn-info']"));
		
		for (WebElement element1 : elements) {
			element1.click();
		}
		
		driver.findElement(By.cssSelector("a[class*='nav-link btn btn-primary']")).click();
		
	}

}
