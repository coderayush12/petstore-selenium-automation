package com.petstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Locators
    By enterStore = By.linkText("Enter the Store");
    By signInLink = By.linkText("Sign In");
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.name("signon");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Single clean login action
    public void loginToApplication(String user, String pass) {

        driver.findElement(enterStore).click();
        driver.findElement(signInLink).click();

        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginBtn).click();
    }
}
