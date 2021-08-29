package com.saucedemo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static com.saucedemo.LoginTest.loginPage;
import static com.saucedemo.LoginTest.mainPage;

public class UITests extends BaseTest {

//    @Test
//    public void loginTest() {
//
//        loginPage.inputLogin(ConfProperties.getProperty("login"));
//                loginPage.inputPasswd(ConfProperties.getProperty("password"));
//        loginPage.clickLoginBtn();
//
//
//    }



//    @Test
//    public void productPageTest(){
//
//    }

    @Test
    public void orderProductTest() throws InterruptedException {
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

    @Test
    public void emptyFieldsErrorTest(){
        mainPage.clickAddToCart();
        mainPage.clickCartBtn();
        cartPage.clickCheckoutBtn();
        checkoutPage.clickContinueBtn();
        Assert.assertTrue(checkoutPage.errorMessage().equals("Error: First Name is required"));

    }

    @Test
    public void deleteFromCart(){
        mainPage.clickAddToCart();
        mainPage.clickCartBtn();
        cartPage.clickRemoveFromCartBtn();
        Assert.assertTrue(cartPage.cartIsEmpty());


    }

}
