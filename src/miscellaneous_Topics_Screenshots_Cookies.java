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

////Handling Proxy Settings
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
		
////Handling the extensions
		// Create ChromeOptions object
		ChromeOptions obj2 = new ChromeOptions();
		obj2.addEncodedExtensions("path_to_exntension_file");
		
////Deleting Cookies
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionKey");
		driver.manage().getCookies();

////Taking Screenshots
		driver.get("https://google.com");
		 //Casts the WebDriver to TakesScreenshot interface.
		 //Takes a screenshot of the current browser window.
		 //Saves it as a temporary File object (src).
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//Uses Apache Commons IO’s FileUtils to copy the screenshot from temp (src)
		//To your local system path (screenshot.png).
		FileUtils.copyFile(src, new File("E:\\SELENIUM WEBDRIVER TUTORIALS\\sceenshots\\screenshot.png"));
		
		
//Handling Broken Links
		//Soft Assertions
		SoftAssert a = new SoftAssert();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.cssSelector(".gf-li a"));
		for (WebElement link : links) {
			String url = link.getDomAttribute("href");
			System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int statusCode = conn.getResponseCode();
			//using soft assertions
			a.assertTrue(statusCode < 400, "This link " + url + " is Broken with statuscode" + statusCode);
		}
		a.assertAll();
	}

}
