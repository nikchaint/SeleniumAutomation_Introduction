import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
public class Handling_RelativeLocators {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Goal: Find the label above the input box with name="name" and print its text.
		//Keyword Used: above()
		WebElement nameEditBox = driver.findElement(By.name("name"));
		String abc = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		System.out.println(abc);
		
		//Goal: Find the input element below the "Date of Birth" label and click it.
		//Keyword Used: below()
		WebElement dateOfBirthLabel = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirthLabel)).click();
		
		//Goal: Find the checkbox input to the left of the label "Check me out" and click it.
		//Keyword Used: toLeftOf()
		WebElement checkBoxLabel = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxLabel)).click();
		
		//Goal: Find the label text to the right of the second radio button and print it.
		//Keyword Used: toRightOf()
		WebElement radiobutton = driver.findElement(By.cssSelector("#inlineRadio2"));
		String abcd = driver.findElement(with(By.tagName("label")).toRightOf(radiobutton)).getText();
		System.out.println(abcd);
		
//Handling the Tabs and Windows 
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childID = it.next();
		
		driver.switchTo().window(childID);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String titleOfchildWindow = driver.getTitle();
		
		driver.switchTo().window(parentID);
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(titleOfchildWindow);
		
//Taking the partial/WebElement screenshot
		WebElement element = driver.findElement(By.cssSelector("input[name='name']"));
		File file = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("E:\\SELENIUM WEBDRIVER TUTORIALS\\sceenshots\\nameTestBox.png"));
		
//Taking Dimentions of WebElement
		WebElement ele = driver.findElement(By.cssSelector("input[name='name']"));
		System.out.println(ele.getRect().getDimension().getHeight());
		System.out.println(ele.getRect().getDimension().getWidth());
	}

}
