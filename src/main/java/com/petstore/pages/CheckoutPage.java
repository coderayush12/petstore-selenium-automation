package com.petstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;
	
	//constructor
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//locators
	By proceedToCheckoutBtn=By.linkText("Proceed to Checkout");
	By confirmOrderBtn=By.name("newOrder");
	By lastConfirm=By.linkText("Confirm");
	By orderSuccessMsg=By.xpath("//*[contains(text(),'Thank you')]");
	By returnToMainMenu=By.linkText("Return to Main Menu");
	
	//Actions
	public void clickProceedToCheckout() {
		driver.findElement(proceedToCheckoutBtn).click();
	}
	public void clickConfirmOrder() {
		driver.findElement(confirmOrderBtn).click();
	}
	public void clickConfirm() {
		driver.findElement(lastConfirm).click();
	}
	//validation
	public boolean isOrderPlacedSuccessfully() {
		return driver.findElements(orderSuccessMsg).size()>0;
	}
	public void clickReturnToMainMenu() {
		driver.findElement(returnToMainMenu).click();
	}
}
