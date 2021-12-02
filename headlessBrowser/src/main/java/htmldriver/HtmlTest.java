package htmldriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class HtmlTest {
	
	public static void main(String[] args) {
		//creating a new instance of the HTML unit driver
		
		WebDriver driver = new HtmlUnitDriver();
		
		//navigate to Google
		driver.get("http://www.google.com");
		
		//locate the searchbox using its name
		WebElement element = driver.findElement(By.name("q"));
		
		//Enter a search query
		element.sendKeys("Amazon");
		
		//submit the query. Webdriver searches for the form using the text input
		//element automatically
		//No need to locate/find the submit button
		element.submit();
		
		//this code will print the page title
		System.out.println("Page title is: " + driver.getTitle());
		
		driver.quit();
		
	}
}
