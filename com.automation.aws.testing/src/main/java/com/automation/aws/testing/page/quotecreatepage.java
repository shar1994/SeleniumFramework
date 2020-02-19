package com.automation.aws.testing.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
/* Think and Implement
 * This is quote create page for Menu Selection on Zomato.com
 * Here we will Decide what we can eat with a Fixed Budget
 * */
public class quotecreatepage {
	private WebDriver driver;
	private String baseUrl;
	@BeforeMethod
	  public void setUp() throws Exception {
		  //System.setProperty("webdriver.chrome.driver","*/chromedriver.exe");
	     WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	   
	    baseUrl = "https://www.zomato.com";
	    System.out.println("Navigated to :- "+baseUrl);
	    // Maximize the browser
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }



@AfterMethod
public void close() {
	  driver.close();
}
}