import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


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
		// locate by id (best to use)
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		// locate by name
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		// locate by class name (gets the first one if many)
		driver.findElement(By.className("form-input")).sendKeys("standard_user");
		// locate by link text title for a anchor tag
		driver.findElement(By.linkText("Quick-tour")).click();
		// locate by partial link text (same like above but can use partial text)
		driver.findElement(By.partialLinkText("Quick")).click();
		// locate by tag name
		driver.findElement(By.tagName("user-name")).sendKeys("standard_user");
		// locate by css selector
		driver.findElement(By.cssSelector("user-name")).sendKeys("standard_user");
		// locate by xpath
		driver.findElement(By.xpath("user-name")).sendKeys("standard_user");

		//relative locators
		//above
		By emailLocator = RelativeLocator.with(By.tagName("input")).above(By.id("password"));
		//or
		WebElement password = driver.findElement(By.id("password"));
		WebElement email = driver.findElement(with(By.tagName("input")).above(password));
		email.click();
		
		//Below
		By passwordLocator = RelativeLocator.with(By.tagName("input")).below(By.id("email"));
		//Left of
		By cancelLocator = RelativeLocator.with(By.tagName("button")).toLeftOf(By.id("submit"));
		//Right of 
		By submitLocator = RelativeLocator.with(By.tagName("button")).toRightOf(By.id("cancel"));
		//Near
		By emailLocator2 = RelativeLocator.with(By.tagName("input")).near(By.id("lbl-email"));
		//Chaining relative locators
		By submitLocator2 = RelativeLocator.with(By.tagName("button")).below(By.id("email")).toRightOf(By.id("cancel"));
		
		// driver.close();
		
	}
}
