package com.demo.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Important for CI/CD environments
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() throws InterruptedException {
        // Navigate to the TLU login page
        driver.get("https://sinhvien1.tlu.edu.vn/#/login");

        // Wait for the login form elements to appear
        Thread.sleep(3000); // Wait for Angular to load the view

        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Page URL: " + driver.getCurrentUrl());

        // Verify we are on the login page
        Assert.assertTrue(driver.getTitle().contains("Education"));

        // Enter Username
        driver.findElement(By.id("username")).sendKeys("2351067115");

        // Enter Password
        driver.findElement(By.id("password")).sendKeys("Thien@16082004");

        // Click Login button
        driver.findElement(By.cssSelector("button[data-ng-click='vm.login()']")).click();
        
        // Brief wait after login
        Thread.sleep(2000);
        
        System.out.println("Login button clicked successfully.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
