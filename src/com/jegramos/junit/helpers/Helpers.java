package com.jegramos.junit.helpers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helpers {
	WebDriver driver;
	
	public Helpers(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(String type, String locator) {
		if(type.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locator));
		} else if(type.equalsIgnoreCase("xpath")){
			return driver.findElement(By.xpath(locator));
		} else if(type.equalsIgnoreCase("name")){
			return driver.findElement(By.name(locator));
		} else if(type.equalsIgnoreCase("class")) {
			return driver.findElement(By.className(locator));
		} else if(type.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locator));
		} else if(type.equalsIgnoreCase("link")){
			return driver.findElement(By.linkText(locator));
		} else if(type.equalsIgnoreCase("partialLink")){
			return driver.findElement(By.partialLinkText(locator));
		} else if(type.equalsIgnoreCase("tag")) {
			return driver.findElement(By.tagName(locator));
		} else {
			System.out.println("The type of the selector is invalid");
			return null;
		}
	}
	
	public List<WebElement> getElementList(String type, String locator) {
		List<WebElement> elementList = new ArrayList<WebElement>();
		if(type.equalsIgnoreCase("id")) {
			elementList = driver.findElements(By.id(locator));
		} else if(type.equalsIgnoreCase("xpath")){
			elementList = driver.findElements(By.xpath(locator));
		} else if(type.equalsIgnoreCase("name")){
			elementList = driver.findElements(By.name(locator));
		} else if(type.equalsIgnoreCase("class")) {
			elementList = driver.findElements(By.className(locator));
		} else if(type.equalsIgnoreCase("css")) {
			elementList = driver.findElements(By.cssSelector(locator));
		} else if(type.equalsIgnoreCase("link")){
			elementList = driver.findElements(By.linkText(locator));
		} else if(type.equalsIgnoreCase("partialLink")){
			elementList = driver.findElements(By.partialLinkText(locator));
		} else if(type.equalsIgnoreCase("tag")) {
			elementList = driver.findElements(By.tagName(locator));
		} else {
			System.out.println("Selector type not supported");
			return null;
		} 
		
		if(elementList.isEmpty()) {
			System.out.println("The elementList has no value!");
			return null;
		} else { return elementList;} 
		
	}
	
	public void goBack() {
		driver.navigate().back();
	}

	public boolean elementIsPresent(String type, String locator) {
		List<WebElement> elementList = getElementList(type, locator);
		int size = elementList.size();
		if (size > 0) {
			return true;
		} else {return false;}
	}
}
