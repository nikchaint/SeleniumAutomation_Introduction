import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LogIn_Flow_Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM WEBDRIVER TUTORIALS\\chromedriver-win64\\chromedriver.exe");
		
		String name = "rahulshettyacademy";
		
		WebDriver driver = new ChromeDriver();
		
		//Implementing Implicit wait mechanism
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("Passward");
		driver.findElement(By.className("signInBtn")).click();
		String invalidUsernamePassword = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(invalidUsernamePassword);
		
		//LogIn_Flow getPass = new LogIn_Flow(); //we call the getPassword menthod bt creating the object of the class
		//String validPassword = getPass.getPassword(driver, name);
		
		//or we can call by making the method getPassword as static,
		String validPassword = getPassword(driver, name);
		
		driver.findElement(By.cssSelector("form div button:nth-child(1)")).click(); //traversing from parent to child using xpath
		
		driver.findElement(By.cssSelector("input[placeholder*='User']")).sendKeys(name); // Regular expression
		driver.findElement(By.xpath("//input[contains(@placeholder,'Pass')]")).sendKeys(validPassword); // Regular expressions
		Thread.sleep(2000); // this we have added because sign button is not clickable
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click(); // find element by text which is only possible in xpath
		
		
		//driver.quit();
		
	}
	
	public static String getPassword(WebDriver driver, String name) {
		
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("abc@gmail.com");
		driver.findElement(By.cssSelector("form input:nth-child(3)")).clear();
		driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("1234567890");
		driver.findElement(By.xpath("//form/div/button[2]")).click(); //traversing from parent to child using css
		String resetPassword = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		System.out.println(resetPassword);
		String[] password = resetPassword.split(" '");
//		for(String str: password) {
//			System.out.println(str);
//		}
		
		String[] tempPassword = password[1].split("'");
//		for(String str: tempPassword) {
//			System.out.println(str);
//		}
		String temporaryPassword = tempPassword[0];
		return temporaryPassword;
	}

}
