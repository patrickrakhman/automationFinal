package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static CartPage cartPage;
    public static CheckoutPage checkoutPage;
    public static CheckoutOverviewPage checkoutOverviewPage;
    public static ProductPage productPage;
    public static WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:\\LEARNING\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
        System.out.println("Start");
    }



    @BeforeMethod
    public void beforeTest() {
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
    }

    @AfterMethod
    public void afterMethod() {}

    @AfterClass
    public void close(){
        driver.quit();
        System.out.println("Close");
    }
}
