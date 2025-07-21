import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class windowScrolling_and_working_with_Tables {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//Scrolling window and specific component 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Downward scroll
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		js.executeAsyncScript("document.querySelector('.tableFixHead').scrollTop = 500;");
		//Use negative value for upward scroll:
		js.executeScript("window.scrollBy(0,-600)", "");
		
//Scroll to the Bottom of the Page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

//Scroll to a Specific Element
		WebElement element = driver.findElement(By.id("footer")); //footer locator is just for example
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		//The scrollIntoView() method has a Boolean parameter:
		//true (default) → Scrolls the page so that the element is aligned at the top of the viewport.
		//false → Scrolls the page so that the element is aligned at the bottom of the viewport.
		
	}

}
