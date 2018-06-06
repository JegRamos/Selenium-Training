package com.jegramos.junit.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
	private WebDriver driver;
	
	public WaitTypes(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitAndGetElement(By locator, int waitTime) {
		WebElement el = null;
		WebDriverWait wait = new WebDriverWait(this.driver, waitTime);
		
		el= wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return el;
	}
	
	public void clickWhenReady(By locator, int waitTime) {
		WebElement el = null;
		WebDriverWait wait = new WebDriverWait(this.driver, waitTime);
		
		el = wait.until(ExpectedConditions.elementToBeClickable(locator));
		el.click();
	}

}
