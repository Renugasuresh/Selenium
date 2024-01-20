package com.Automation;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webStaurantSearch {
	
	@Test
	public void search() throws InterruptedException
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.webstaurantstore.com/");
		driver.findElement(By.xpath("//input[@id='searchval']")).sendKeys("stainless work table"+Keys.ENTER);
		List<WebElement> al=driver.findElements(By.xpath("//*[@id=\"ProductBoxContainer\"]/div[1]/a/span"));
		for(WebElement w:al)
		{
			String s=w.getText();
			Assert.assertTrue(s.contains("Table"));
		}
		driver.findElement(By.xpath("//a[contains(text(),'9')]")).click();
		WebElement con=driver.findElement(By.xpath("//div[@data-testid='productBoxContainer'][last()]"));
		driver.findElement(By.xpath("//input[@data-testid='itemAddCart'][last()]")).click();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//span[@id='cartItemCountSpan']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),'Empty')]")).click();
		Thread.sleep(3000); 
		Actions act=new Actions(driver);
		WebElement empty=driver.findElement(By.xpath("//button[contains(text(),'Empty')]"));
		act.moveToElement(empty).doubleClick();
		driver.quit();
		
	}

}
