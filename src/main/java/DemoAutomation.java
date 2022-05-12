import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAutomation {

	public static String brower = "firefox";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (brower.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (brower.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else if (brower.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get("http://www.saucedemo.com");

		// first testing Selinium
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();

		// testing with locators

		// locate by id
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		// locate by name
		driver.findElement(By.name("user-name")).sendKeys("standard_user");

		// locate by class name
		driver.findElement(By.className("user-name")).sendKeys("standard_user");

		// locate by link text
		driver.findElement(By.linkText("user-name")).sendKeys("standard_user");

		// locate by partial link text
		driver.findElement(By.partialLinkText("user-name")).sendKeys("standard_user");

		// locate by tag name
		driver.findElement(By.tagName("user-name")).sendKeys("standard_user");

		// locate by css selector
		driver.findElement(By.cssSelector("user-name")).sendKeys("standard_user");

		// locate by xpath
		driver.findElement(By.xpath("user-name")).sendKeys("standard_user");

	
		// driver.close();

	}
}
