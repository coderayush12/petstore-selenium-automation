package com.petstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	//Locators
	By loggedin=By.linkText("Sign Out");
	
	//Check if Sign Out option is displayed
	public boolean returnTrueIfLoggedIn() {
		try {
			return driver.findElement(loggedin).isDisplayed();
		} catch(Exception e) {
			return false;
		}
	}
}
