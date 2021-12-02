package webdrivertestsample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	private WebDriver driver;
	@Test
	public void testEasy() {
		driver.get("https://www.google.com/");
		String title = driver.getTitle();
		AssertJUnit.assertTrue(title.contains("google"));
	}
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}