package com.petstore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.petstore.pages.HomePage;
import com.petstore.pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void validLoginTest() {
		LoginPage login=new LoginPage(driver);
		login.loginToApplication("j2ee", "j2ee");
		HomePage home=new HomePage(driver);
		Boolean welcome=home.returnTrueIfLoggedIn();
		Assert.assertTrue(welcome,"Login Failed");
	}
}
