package com.demoqa.test_task.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQAMainPage {
    private final WebDriver driver;
    private final By toolsQALogo = By.xpath(".//img[@src='/images/Toolsqa.jpg']");
    private final By elementsButton = By.xpath(".//h5[text()='Elements']/ancestor::div[@class='card mt-4 top-card']");

    public DemoQAMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForLoadingMainPage(){
        new WebDriverWait(driver,8)
                .until(ExpectedConditions.visibilityOfElementLocated(toolsQALogo));
    }

    public void performClickOnElements(){
        driver.findElement(elementsButton).click();
    }

}
