package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object for the Login Page.
 * Contains all the elements and actions that can be performed on the page.
 */
public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators for the web elements on the page
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-btn");
    private final By successMessage = By.id("success-message");
    private final By errorMessage = By.id("error-message");

    /**
     * Constructor to initialize the WebDriver and WebDriverWait.
     * @param driver The WebDriver instance.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Wait for a maximum of 10 seconds for elements to appear
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // --- Page Actions ---

    /**
     * Enters the given username into the username field.
     * @param username The username to enter.
     */
    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    /**
     * Enters the given password into the password field.
     * @param password The password to enter.
     */
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    /**
     * A convenience method to perform a full login.
     * @param username The username.
     * @param password The password.
     */
    public void performLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    /**
     * Gets the text from the success message element.
     * It waits until the element is visible before retrieving the text.
     * @return The success message text.
     */
    public String getSuccessMessageText() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return messageElement.getText();
    }

    /**
     * Gets the text from the error message element.
     * It waits until the element is visible before retrieving the text.
     * @return The error message text.
     */
    public String getErrorMessageText() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return messageElement.getText();
    }
}
