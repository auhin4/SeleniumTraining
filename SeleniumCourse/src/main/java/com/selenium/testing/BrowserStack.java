package com.selenium.testing;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.browserstack.local.Local;

public class BrowserStack {
	
	public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
	public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static void main(String[] args) throws Exception{
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "chrome");
		caps.setCapability("browser_version", "96.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("build", "browserstack-build-1");
		caps.setCapability("name", "alchemytraining1's First Test");
		caps.setCapability("browserstack.local", "true");
		
		// Creates an instance of Local
		Local bsLocal = new Local();
		  
		// You can also set an environment variable - "BROWSERSTACK_ACCESS_KEY".
		HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
		//bsLocalArgs.put("BROWSERSTACK_USERNAME", USERNAME);
		bsLocalArgs.put("BROWSERSTACK_ACCESS_KEY", AUTOMATE_KEY );
		//bsLocalArgs.put("URL", URL);
		  
		// Starts the Local instance with the required arguments
		bsLocal.start(bsLocalArgs);
		   
		// Check if BrowserStack local instance is running
		System.out.println(bsLocal.isRunning());
		  
		// Your test code goes here, from creating the driver instance till the end, i.e. driver.quit
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL),caps );
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		
		element.sendKeys("BrowserStack");
		element.submit();
		
		System.out.println(driver.getTitle());
		driver.quit();
		// Stop the Local instance after your test run is completed, i.e after driver.quit
		bsLocal.stop();
		
		
	}
}