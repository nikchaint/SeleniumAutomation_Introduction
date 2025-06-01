import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Handling_MouseKeyBoardActions_Windows_Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		driver.get("https://www.flipkart.com/");
//		
////To Handle mouse and Keyboard actions selenium provides the Actions class
//		Actions a = new Actions(driver);
//		
//		//mouse Hover 
//		a.moveToElement(driver.findElement(By.cssSelector("div[class*=\"H6-NpN\"] img[alt*='Dropdown with more help links']"))).build().perform();
//		
//		//keyBoard actions
//		a.moveToElement(driver.findElement(By.cssSelector("input.Pke_EE"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
//		
//		//double click
//		a.moveToElement(driver.findElement(By.cssSelector("input.Pke_EE"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().perform();
//		
//		//for closing current windows
//		//driver.close();
////Handling Windows
//		
//		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
//		
//		driver.findElement(By.cssSelector(".blinkingText")).click();
//		Set<String> windows = driver.getWindowHandles(); //Collects the IDs (handles) of all open browser windows/tabs into a Set.
//		//Creates an iterator and extracts
//		//parentID → ID of the original window
//		//childID → ID of the new window/tab
//		Iterator<String> it = windows.iterator();
//		String parentID = it.next(); //.next to iterate in the Set of windows ID
//		String childID = it.next();
//		//Switches focus from the main window to the new child window, so Selenium can now interact with it.
//		driver.switchTo().window(childID);
//		
//		//System.out.println(driver.findElement(By.linkText("mentor@rahulshettyacademy.com")).getText());
//		String wholeString = driver.findElement(By.cssSelector(".im-para.red")).getText();
//		String emailID = wholeString.split("at")[1].trim().split(" ")[0];
//		System.out.println(emailID);
//		
//		driver.switchTo().window(parentID);
//		driver.findElement(By.id("username")).sendKeys(emailID);
		
//Handling Frames
		driver.get("http://jqueryui.com/droppable/");
		//Switches Selenium’s focus inside the <iframe> where the draggable and droppable elements are located.
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		//Locates the draggable box (source) and the drop target box (destination).
		WebElement source = driver.findElement(By.cssSelector("div[id='draggable']"));
		WebElement destination = driver.findElement(By.cssSelector("div[id='droppable']"));
		
		//Uses the Actions class to simulate drag-and-drop from source to destination.
		Actions a = new Actions(driver);
		a.dragAndDrop(source, destination).build().perform();
		
		//Switches back to the main HTML page (outside the iframe) after the action is complete.
		driver.switchTo().defaultContent();
		
		
		
	}

}
