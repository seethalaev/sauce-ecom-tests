package com.saucedemo.automation.tests;

import com.saucedemo.automation.pages.LoginPage;
import com.saucedemo.automation.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    
    @Test
    public void verifySuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        
        // Use the standard_user, which is the valid user for Saucedemo
        loginPage.login("standard_user", "secret_sauce");
        
        // Assertion 1: Verify URL changed to the inventory page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), 
                          "Login failed or navigated to the wrong URL. Current URL: " + currentUrl);
    }

    @Test
    public void verifyInvalidLoginShowsErrorMessage() {
        LoginPage loginPage = new LoginPage(driver);
        
        // Use invalid credentials
        loginPage.login("invalid_user", "wrong_password");
        
        // Assertion 2: Verify error message is displayed and correct
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message was not displayed for invalid login.");
        
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedError, "Incorrect error message displayed.");
    }
}