package com.saucedemo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    public ChromeDriver driver;
    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:\\LEARNING\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
        System.out.println("Start");
    }

    @BeforeTest
    public void waitTest(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void close(){
        driver.quit();
        System.out.println("Close");
    }
}
