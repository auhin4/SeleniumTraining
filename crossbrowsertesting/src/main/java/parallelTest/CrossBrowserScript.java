package parallelTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript {
	
	WebDriver driver;
	
	/**
	 * This function will execute before each Test tag in testng.xml
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")) {
			//create firefox instance
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")) {
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\austi\\OneDrive\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		//check if parameter passed as 'Edge'
		else if(browser.equalsIgnoreCase("Edge")) {
			//set path to Edge.exe
			System.setProperty("webdriver.edge.driver", "C:\\Users\\IEDriverServer.exe");
			//create Edge instance
			driver = new EdgeDriver();
		}
		else {
			//if no browser passed, throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testParameterWithXML() throws InterruptedException{
		driver.get("https://www.google.com/");
		
		WebElement title = driver.findElement(By.name("q"));
		
		title.sendKeys("amazon");
	}
}