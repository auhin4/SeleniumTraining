package userInteractionsAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AdvancedUserInteraction_DragAndDrop {
	
	public static void main(String[] args) throws InterruptedException {
		//TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\austi\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/laptops-store");
		//Find the slider element for minimum price (left-most one)
		WebElement leftSlider = driver.findElement(By.className("_3aQU3C"));
		//Instantiate Actions
		Actions builder = new Actions(driver);
		//Drag the slider to its right by some offset (30 pixels)
		builder.dragAndDropBy(leftSlider, 60, 0).build().perform();
		//Wait for 5 seconds
		Thread.sleep(5000);
		//Find the slider element for maximum price (right-most one)
		WebElement rightSlider = driver.findElement(By.className("_3aQU3C"));
		//Drag the slider to its left by some offset (20 pixels)
		builder.dragAndDropBy(rightSlider, -30, 0)
		.build().perform();
		//Wait for 5 seconds
		Thread.sleep(5000);
		//Find the Logo element (source to drag) and Search box element (target)
		WebElement source = driver.findElement(By.xpath("//img[@alt='Flipkart']"));
		WebElement target = driver.findElement(By.className("LM6RPg"));
		//Drag logo over search box
		builder.dragAndDrop(source, target).build().perform();
	}
}