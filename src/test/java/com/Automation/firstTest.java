package com.Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class firstTest {
	
@Test
public void setup() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\renug\\seleniumDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
    String baseUrl = "https://letcode.in/elements";
    driver.get(baseUrl);
    List<WebElement> li=(List<WebElement>) driver.findElements(By.tagName("li"));
    for(WebElement l:li)
    {
    	System.out.println(l.getText());
    }
    Thread.sleep(5000);
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Renuga");
    driver.findElement(By.id("search")).click();
    Thread.sleep(5000);
    Assert.assertTrue(driver.findElement(By.xpath("//img[@class='is-rounded']")).isDisplayed());
}

}
