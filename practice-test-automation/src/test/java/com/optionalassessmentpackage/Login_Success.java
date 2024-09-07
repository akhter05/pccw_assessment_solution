package com.optionalassessmentpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test case to verify that a user can log in with valid credentials.
 * 
 * Steps:
 * 1. Navigate to the Login Page: https://practicetestautomation.com/practice-test-login
 * 2. Enter valid username and password.
 * 3. Click the login button.
 * 4. Verify that the user is redirected to the homepage.
 * 
 * Expected result:
 * The user should be successfully logged in and see the homepage.
 */


public class Login_Success {
	
	private WebDriver driver;
	
	 @BeforeMethod
	    public void setUp() {
	        // Setup WebDriverManager to automatically manage the  binary
		 WebDriverManager.firefoxdriver().setup();
	                
	        // Initialize the  WebDriver
		 driver = new FirefoxDriver();
	        
	        // Open the web application
	     driver.get("https://practicetestautomation.com/practice-test-login"); 

	    }
	 
	 @Test(description = "Verify that a user can log in with valid credentials.")
	    public void testLogin() {
		// Maximize the browser window
	        driver.manage().window().maximize();
	          
	            // Enter valid username
	            WebElement usernameField = driver.findElement(By.id("username"));
	            usernameField.sendKeys("student");

	            // Enter valid password
	            WebElement passwordField = driver.findElement(By.id("password"));
	            passwordField.sendKeys("Password123");
	            
	            // Click the login button
	            WebElement loginButton = driver.findElement(By.id("submit"));
	            loginButton.click();

	            // Wait for the page to load and verify login success
	            // Locate the element that contains the success message
	            WebElement successMessageElement = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/p[1]/strong")); 
	            
	            // Get the text from the web element
	            String actualText = successMessageElement.getText();
	            String expectedText = "Congratulations student. You successfully logged in!";

	            // Assert that the actual text matches the expected text
	            Assert.assertEquals(actualText, expectedText, "Login success- home page message matches expected message.");

	            
	        } 
	 
	 @AfterMethod
	    public void tearDown() {
	            // Close the browser
	            if (driver != null) {
	            driver.quit();
	        }
	    }
}
