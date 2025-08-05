package com.example.tests;

import com.example.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

/**
 * Test class for Login functionality.
 * Contains tests for successful and failed login scenarios.
 */
public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    /**
     * This method runs before each test.
     * It sets up the WebDriver, opens the browser, and navigates to the local login page.
     */
    @BeforeMethod
    public void setUp() {
        // Automatically downloads and sets up the ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Optional: Run in headless mode (without opening a visible browser window)
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        // driver = new ChromeDriver(options);
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);

        // Get the absolute path to the local HTML file
        // This makes the test runnable on any machine without changing paths
        String filePath = Paths.get("src/test/resources/login.html").toUri().toString();
        driver.get(filePath);
    }

    /**
     * Test Case 1: Successful Login
     * Verifies that a user can log in with valid credentials.
     */
    @Test(priority = 1, description = "Verify successful login with valid credentials.")
    public void testSuccessfulLogin() {
        // Perform login action using the Page Object
        loginPage.performLogin("testuser", "password123");

        // Get the success message
        String successMessage = loginPage.getSuccessMessageText();

        // Assert that the success message is correct
        Assert.assertEquals(successMessage, "Login successful! Welcome back.", "Success message did not match.");
    }

    /**
     * Test Case 2: Failed Login (Invalid Password)
     * Verifies that an error message is shown for invalid credentials.
     */
    @Test(priority = 2, description = "Verify failed login with an invalid password.")
    public void testFailedLoginWithInvalidPassword() {
        // Perform login with incorrect password
        loginPage.performLogin("testuser", "wrongpassword");

        // Get the error message
        String errorMessage = loginPage.getErrorMessageText();

        // Assert that the error message is correct
        Assert.assertEquals(errorMessage, "Invalid username or password!", "Error message did not match.");
    }

    /**
     * Test Case 3: Failed Login (Empty Credentials)
     * Verifies that an error message is shown when credentials are not entered.
     */
    @Test(priority = 3, description = "Verify failed login with empty credentials.")
    public void testFailedLoginWithEmptyCredentials() {
        // Click login button without entering credentials
        loginPage.clickLoginButton();

        // Get the error message
        String errorMessage = loginPage.getErrorMessageText();

        // Assert that the error message is correct
        Assert.assertEquals(errorMessage, "Invalid username or password!", "Error message for empty credentials did not match.");
    }

    /**
     * This method runs after each test.
     * It closes the browser to clean up the session.
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
