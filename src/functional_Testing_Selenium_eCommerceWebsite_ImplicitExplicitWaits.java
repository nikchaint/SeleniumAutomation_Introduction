import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class functional_Testing_Selenium_eCommerceWebsite_ImplicitExplicitWaits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM WEBDRIVER
		// TUTORIALS\\chromedriver-win64\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		// Listing the products for multiple selection from the available product
		String[] names = { "Cucumber", "Brocolli", "Mango" };
		int j = 0;

		WebDriver driver = new ChromeDriver();
		
//Configuring the Implicit Wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//Configuring the Explicit wait mechanism
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//navigating to site
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		// collecting all the webElements for the products available on the screen, so
		// we can traverse and select on which we want (using findElements)
		List<WebElement> options = driver.findElements(By.cssSelector("h4[class='product-name']"));

		// convert the static Array to List
		List<String> itemListTobeAdded = Arrays.asList(names);

		// using normal for loop
		for (int i = 0; i < options.size(); i++) {
			//extracting the string from the webElement and trim it as we are looking for specific vegitable name
			String productName = options.get(i).getText().split("-")[0].trim();
			
			if (itemListTobeAdded.contains(productName)) {
				// Below Step - doesn't guarantee you're clicking the right one related to the
				// productName — especially if the DOM structure has extra elements (like hidden
				// or grouped buttons), or if the indexing of options and buttons don't
				// perfectly match.
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				
				// We can use below step to click on exact relative button (Traverse from the
				// product name element to its corresponding 'Add to Cart' button)
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				j++;
				// here we are checking how many times the if block executed and according
				// increment the value of j, so we can eliminate the excessive loop execution
				// and break the look
				if (j == 0) {
					break;
				}
			}
		}

		// alternatively using enhance for loop
//		for(WebElement option :options) {
//			for(String name : names) {
//				if (option.getText().contains(name)){
//					option.findElement(By.xpath("following-sibling::div/button[text()='ADD TO CART']")).click();
//				break;
//				}
//				
//			}
//		}
		
		driver.findElement(By.xpath("//a[@class='cart-icon']/img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[text()='PROCEED TO CHECKOUT']")).click();
		//applying the explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder*='Enter promo code']")));
		driver.findElement(By.cssSelector("input[placeholder*='Enter promo code']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("div[class*='promoWrapper'] button[class*='promoBtn']")).click();
		//applying the explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='promoWrapper'] span[class*='promoInfo']")));
		System.out.println(driver.findElement(By.cssSelector("div[class*='promoWrapper'] span[class*='promoInfo']")).getText());

	}

}
