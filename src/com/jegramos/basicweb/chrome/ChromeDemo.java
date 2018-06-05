package com.jegramos.basicweb.chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/com/jegramos/browser/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		String baseURL = "http://www.google.com";
		driver.get(baseURL);
		
		driver.findElement(By.id("lst-ib")).sendKeys("Spaghetti");
		driver.findElement(By.xpath("//form[@id='tsf']//input[@name='btnK']")).click();
	}

}
