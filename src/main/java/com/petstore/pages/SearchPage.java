package com.petstore.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	WebDriver driver;
	WebDriverWait wait;
	//constructor
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//Actions
	//dynamic category selection
	public void openCategory(String categoryId) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'categoryId="+categoryId+"')]"))).click();
	}
	
	
	//dynamic product selection using id
	public void selectProductById(String productId) {
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(productId))).click();
	}
	
	
	
	//click add to cart button
	public void addToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Add to Cart')]"))).click();
	}
}
