package com.saucedemo;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest  {

    public WebDriver driver;
    public LoginTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    public static LoginPage loginPage;
    public static MainPage mainPage;




    @Step("Login with valid credentials")
    public void loginWithValidCredentials(){


        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
    }
}
