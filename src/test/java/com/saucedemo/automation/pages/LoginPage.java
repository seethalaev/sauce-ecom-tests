package com.saucedemo.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    // 1. Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorContainer = By.xpath("//div[@class='error-message-container error']");

    // 2. Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Simple verification that we are on the correct page (optional but good practice)
        if (!driver.getTitle().equals("Swag Labs")) {
            throw new IllegalStateException("This is not the Login Page. Current page title: " + driver.getTitle());
        }
    }

    // 3. Page Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Combines actions for successful login and returns the next page object (not implemented here yet)
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        // In a real project, this would return an InventoryPage object
    }
    
    // 4. Verification Methods
    public boolean isErrorDisplayed() {
        return driver.findElement(errorContainer).isDisplayed();
    }
    
    public String getErrorMessage() {
        return driver.findElement(errorContainer).getText();
    }
}