package com.saucedemo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static com.saucedemo.LoginTest.loginPage;
import static com.saucedemo.LoginTest.profilePage;

public class UITests extends BaseTest {

    @Test
    public void loginTest() {

        loginPage.inputLogin(ConfProperties.getProperty("login"));

        loginPage.clickLoginBtn();

        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();


    }



//    @Test
//    public void productPageTest(){
//
//    }

    @Test
    public void orderProductTest() throws InterruptedException {
        mainPage.clickAddToCart();
        mainPage.clickCartBtn();
        cartPage.clickCheckoutBtn();
        checkoutPage.inputFirstName(ConfProperties.getProperty("firstName"));
        checkoutPage.inputLastName(ConfProperties.getProperty("lastName"));
        checkoutPage.inputCode(ConfProperties.getProperty("code"));
        checkoutPage.clickContinueBtn();
        checkoutOverviewPage.clickFinishBtn();
        checkoutOverviewPage.clickHomeBtn();

    }

    @Test
    public void productListSortTest() {
        mainPage.clickSortMenu();
        mainPage.clickLohiSort();
        mainPage.clickHiloSort();
        mainPage.clickZaSort();
        mainPage.clickAzSort();

    }

}
