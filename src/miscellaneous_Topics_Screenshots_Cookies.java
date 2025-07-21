import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class miscellaneous_Topics_Screenshots_Cookies {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//Handling HTTPS Certification
		// Create ChromeOptions object
		ChromeOptions obj = new ChromeOptions();
		 // Allow insecure/expired certs
		obj.setAcceptInsecureCerts(true);
		// Pass options to ChromeDriver
		WebDriver driver = new ChromeDriver(obj); // remove obj before running any test this just for Handling HTTPS Certification
		// Open a site with an expired SSL cert
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

//Handling Proxy Settings
		// Create ChromeOptions object
		ChromeOptions obj1 = new ChromeOptions();
		// Allow insecure/expired certs
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("http://ip_add:port_number");
		//proxy.setSslProxy("ip_address:port_number"); // For HTTPS
		obj1.setCapability("proxy", proxy);
		// Attach proxy to options // ofor above step ChatGPT suggest to use this
        //options.setProxy(proxy);
		WebDriver driver1 = new ChromeDriver(obj1);
		
//Handling the extensions
		// Create ChromeOptions object
		ChromeOptions obj2 = new ChromeOptions();
		obj2.addEncodedExtensions("path_to_exntension_file");
		
//Deleting Cookies
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionKey");
		driver.manage().getCookies();

//Taking Screenshots
		driver.get("https://google.com");
		//1. Generate a timestamp (to avoid overwriting old screenshots)
        	String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());	
        	// 2. Capture the screenshot and store it as a temporary File object
        	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        	// 3. Define destination file path (change this path as per your need)
        	File dest = new File("E:\\SELENIUM WEBDRIVER TUTORIALS\\screenshots\\google_HomePage" + "_" + timestamp + ".png");
		// 4. Copy screenshot from temp location to the destination
        	FileUtils.copyFile(src, dest);
		//  5. Print confirmation message
        	System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
		
//Take Screenshot of a Particular Element in Selenium
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        	driver.manage().window().maximize();

        	// 1. Locate the specific element (e.g., logo)
        	WebElement logo = driver.findElement(By.cssSelector(".logoClass"));
        	// 2. Take screenshot of only that element
        	File src = logo.getScreenshotAs(OutputType.FILE);
		// Save it to your desired location
        	File dest = new File("E:\\SELENIUM WEBDRIVER TUTORIALS\\screenshots\\logo.png");
        	FileUtils.copyFile(src, dest);
		System.out.println("Element screenshot saved at: " + dest.getAbsolutePath());
		driver.close();
		
//Handling Broken Links
		//Soft Assertions
		SoftAssert a = new SoftAssert();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Finds all anchor (<a>) tags inside elements having class .gf-li. 
		//This collects all footer links (as WebElements) into a list.
		List<WebElement> links = driver.findElements(By.cssSelector(".gf-li a"));
		//Loop Through Each Link and Check for Broken Links
		for (WebElement link : links) {
			String url = link.getDomAttribute("href");
			System.out.println(url);

			//Opens an HTTP connection to the URL.
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			// Uses HEAD request (only fetches headers, not the full page → faster).
			conn.setRequestMethod("HEAD");
			conn.connect();
			//Gets the HTTP response status code (e.g., 200 = OK, 404 = Not Found, 500 = Server Error).
			int statusCode = conn.getResponseCode();
			//using soft assertions
			a.assertTrue(statusCode < 400, "This link " + url + " is Broken with statuscode" + statusCode);
		}
		a.assertAll();
	}
}
