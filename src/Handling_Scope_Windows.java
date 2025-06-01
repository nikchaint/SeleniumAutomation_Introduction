import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Handling_Scope_Windows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//This script shows how to narrow down your search area for elements using WebElement scoping — going from entire page ➝ footer ➝ footer column.
		//Counts and prints all <a> (anchor) tags (i.e., links) on the entire page.
		Integer allLinksCount = driver.findElements(By.tagName("a")).size();
		System.out.println(allLinksCount);
		
		//Narrows the scope to just the footer section (using its ID gf-BIG) and counts only the links inside it
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		Integer footerLinksCount = footer.findElements(By.tagName("a")).size();
		System.out.println(footerLinksCount);
		
		//Further scopes into the first column of the footer table and counts only the links inside that specific column.
		WebElement footerTable = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		Integer footerTableCount = footerTable.findElements(By.tagName("a")).size();
		System.out.println(footerTableCount);

//Click on eachLink from footerTable and get the title of each page open.
		
		for(int i=1; i<footerTableCount;i++) {
			String openLinkInTabs = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerTable.findElements(By.tagName("a")).get(i).sendKeys(openLinkInTabs);
			Thread.sleep(2000);
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> i = windows.iterator();
		while(i.hasNext()) {
			String tab = i.next();
			driver.switchTo().window(tab);
			String pageTitle  = driver.getTitle();
			System.out.println(pageTitle);
		}
	
		
		

	}


}
