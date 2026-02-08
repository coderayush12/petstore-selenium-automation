package com.petstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;
	
	//constructor
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	By cartTable=By.xpath("//table//tr/td/a");
	By emptyCartMsg=By.xpath("//*[contains(text(),'Your cart is empty')]");
	public boolean isItemAddedToCart() {
		if(driver.findElements(emptyCartMsg).size()>0) {
			return false;
		}
		return driver.findElements(cartTable).size()>0;
	}
}
