import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Handling_StaticDynamic_Dropdown_Checkboxes_Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//Handling static dropdown using select tag
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement element = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));

		Select staticDropdown = new Select(element);
		staticDropdown.selectByIndex(1);
		staticDropdown.selectByVisibleText("USD");
		staticDropdown.selectByValue("AED"); // using value attribute
		// to print the selected value
		System.out.println(staticDropdown.getFirstSelectedOption().getText());

//Handling Updated DropDown
		driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();

		Thread.sleep(2000L);
		// selecting Adult option multiple times to keep updating the drop down
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.xpath("//div/span[@id='hrefIncAdt']")).click();
		}

		driver.findElement(By.cssSelector("div[class*=\"ad-row\"] input[id*='btnclose']")).click();
		// driver.close();

//Handling Dynamic Dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("(//a[@value='AMD'])[2]")).click();
		// selecting option from dropdown without using index as we used in above step
		// we are using parent child relationship using css or xpath here we used css
		// driver.findElement(By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR']
		// a[value='AMD']")).click();

//Selecting current date from the calender
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

//Handling AutoSuggestive Dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		Thread.sleep(2000L);
		// find all the WebElements comes under dropdown and store in the list
		List<WebElement> options = driver.findElements(By.cssSelector("li[class*='ui-menu-item'] a"));
		// traverse through the list and check for required option
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
//Handling Checkboxes
		// check if checkbox is selected or not
		boolean selected = driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected();
		assertFalse(selected);
		driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
		boolean selected1 = driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected();
		assertTrue(selected1);
		// check the number of checkboxes on the page
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());

//Check if the field is enable or not
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_0")).click();
		// below step should print the false but it return true because selenium unable
		// to check if it is enable or disable becuase of element behaviour
		// System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());

		// to mitigate above issue we can check by using another way by get the
		// attribute and check the value
		String element1 = driver.findElement(By.id("Div1")).getDomAttribute("style");
		if (element1.contains("0.5")) {
			assertTrue(true);
			System.out.println("It is disable");
		} else {
			assertTrue(false);
		}
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).isEnabled());

//Handling Alerts
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("rahul");
		driver.findElement(By.xpath("//fieldset[@class='pull-right']/input[@value='Alert']")).click();
		// get the text in the alert
		driver.switchTo().alert().getText();
		// accepting alert
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		// reject or cancel the alert
		driver.switchTo().alert().dismiss();
		
		// we can handle by below way also
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		//alert.dismiss();
		//alert.getText();
		
//Handling Calender
		 String day = "30";
		 String month = "7";
		 String year = "2027";
		 String[] expectedList = {month,day,year};
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		 driver.findElement(By.cssSelector("div[class*='react-date-picker__inputGroup']")).click();
		 driver.findElement(By.cssSelector("button[class*='react-calendar__navigation__label']")).click();
		 driver.findElement(By.cssSelector("button[class*='react-calendar__navigation__label']")).click();
		 
		 //Find and click the desired year (2027).
		 List<WebElement> years = driver.findElements(By.cssSelector("button[class*='react-calendar__tile react-calendar__decade-view__years__year']"));
		 
		 for(WebElement year1 : years) {
			 if(year1.getText().equals(year)) {
				 year1.click();
				 break;
			 }
		 }
		 
		 //Find and click the correct month (July, which is index 6 = 7 - 1).
		 List<WebElement> months = driver.findElements(By.cssSelector("button[class*='react-calendar__tile react-calendar__year-view__months__month']"));
		 int targetMonth = Integer.parseInt(month) - 1;
		 months.get(targetMonth).click();
		 
		 List<WebElement> days = driver.findElements(By.cssSelector("button[class*='react-calendar__tile react-calendar__month-view__days__day']"));
		 for(WebElement dayElement : days) {
		     String classes = dayElement.getDomAttribute("class");
		     WebElement abbr = dayElement.findElement(By.tagName("abbr"));
		     
		     // Check if it's in the current month (i.e., no 'react-calendar__tile--neighboringMonth' in class)
		     //Ignores dates from previous or next months (those have the class --neighboringMonth).
		     //Clicks the day only if it belongs to the selected month and matches the desired day.
		     if(classes != null && !classes.contains("react-calendar__month-view__days__day--neighboringMonth")) {
		         if(abbr.getText().equals(day)) {
		             dayElement.click();
		             break;
		         }
		     }
		 }
		 
		  List<WebElement> dateOutput = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
	     
		  for(int i =0; i<dateOutput.size();i++) {
			  String actualValue = dateOutput.get(i).getDomAttribute("value");
			  Assert.assertEquals(actualValue, expectedList[i]);
		  }
	}

}
