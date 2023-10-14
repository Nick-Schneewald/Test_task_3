package com.demoqa.test_task.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQAElementsPage {
    private final WebDriver driver;
    private final By mainHeader = By.className("main-header");

    public DemoQAElementsPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForLoadingElementsPage(){
        new WebDriverWait(driver,8)
                .until(ExpectedConditions.visibilityOfElementLocated(mainHeader));
    }


}
