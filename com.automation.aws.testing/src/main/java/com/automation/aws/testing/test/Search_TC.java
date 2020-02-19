package com.automation.aws.testing.test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class Search_TC {
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

  @Test
  public void testCase1() throws Exception {
    driver.get(baseUrl + "/bangalore");
    System.out.println("Title of the Page :- " +driver.getTitle());
    driver.findElement(By.xpath("//*[@id='keywords_input']")).sendKeys("Fried Rice");
   Thread.sleep(3000);
   System.out.println("Search for Fried Rice");
   driver.findElement(By.id("search_button")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(3000);
    System.out.println("Message:- "+driver.getTitle());
    driver.findElement(By.xpath("//*[@class='link_hover']/span")).click();
    System.out.println("Searching High Rating Restaurant");
    System.out.println("Highest Rated Restaurant in Benguluru :- "+driver.findElement(By.xpath("//*[contains(@class,'result-title')]")).getText());
  }

  @AfterMethod
  public void close() {
	  driver.close();
  }
  
}
