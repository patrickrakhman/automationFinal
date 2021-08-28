package com.saucedemo;

import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTest extends WebDriverSettings {


    @Test
    public void firstTest() {



        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Swag Labs"));
        System.out.println(title);

    }
    @Test
    public void firstTest1() {

        driver.get("https://www.saucedemo.com/");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Swag Labs"));
        System.out.println(title);

    }


}
