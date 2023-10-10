package com.demoqa.test_task;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class GivenScenarioTest{
    private static final String DEMO_QA_BASE_URL = "https://demoqa.com/";
    private WebDriver driver;
    private DemoQAMainPage mainPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void performGivenTestScenario(){
        driver.get(DEMO_QA_BASE_URL);
        mainPage = new DemoQAMainPage(driver);
    }
    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}


