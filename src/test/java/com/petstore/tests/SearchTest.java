package com.petstore.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.petstore.pages.*;

public class SearchTest extends BaseTest {

    @DataProvider(name = "productData")
    public Object[][] getData() {
        return new Object[][] {
                {"DOGS", "K9-BD-01"},
                {"DOGS", "K9-PO-02"},
                {"DOGS", "K9-DL-01"},
                {"DOGS", "K9-RT-01"},
                {"DOGS", "K9-RT-02"},
                {"DOGS", "K9-CW-01"},
                {"FISH", "FI-SW-01"},
                {"FISH", "FI-SW-02"},
                {"FISH", "FI-FW-01"},
                {"FISH", "FI-FW-02"},
                {"CATS", "FL-DSH-01"},
                {"CATS", "FL-DLH-02"},
                {"REPTILES", "RP-SN-01"},
                {"REPTILES", "RP-LI-02"},
                {"BIRDS", "AV-CB-01"},
                {"BIRDS", "AV-SB-02"}

        };
    }

    @Test(dataProvider = "productData")
    public void verifyProductAddToCart(String category, String productId) throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        login.loginToApplication("j2ee", "j2ee");

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.returnTrueIfLoggedIn(), "Login failed");
        SearchPage search = new SearchPage(driver);
        search.openCategory(category);
        search.selectProductById(productId);
        search.addToCart();

        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isItemAddedToCart(), "Item NOT added to cart");
    }
}
