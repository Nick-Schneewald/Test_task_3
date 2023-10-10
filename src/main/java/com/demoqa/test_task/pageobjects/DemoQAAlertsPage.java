package com.demoqa.test_task.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQAAlertsPage {
    private final WebDriver driver;
    private final By mainHeader = By.xpath(".//div[@class='main-header']");

    private final By alertButton = By.id("alertButton");
    private final By timerAlertButton = By.id("timerAlertButton");

    private final By confirmAlertButton = By.id("confirmButton");

    private final By promptAlertButton = By.id("promtButton");

    private final By confirmResult = By.xpath(".//span[@id='confirmResult']");

    private final By promptResult = By.xpath(".//span[@id='promptResult']");
    private Alert alert;

    public DemoQAAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitingForLoadAlertsPage(){
        new WebDriverWait(driver,8)
                .until(ExpectedConditions.visibilityOfElementLocated(mainHeader));
    }

    public void performClickOnAlertButton(){
        driver.findElement(alertButton).click();
    }

    public void performClickOnTimerAlertButton(){
        driver.findElement(timerAlertButton).click();
    }

    public void closeAlert(){
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void closeTimerAlert(){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void performClickOnConfirmAlertButton(){
        driver.findElement(confirmAlertButton).click();
    }
    public void performClickOnPromptAlertButton(){
        driver.findElement(promptAlertButton).click();
    }

    public void closeConfirmAlert(){
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void closePromptAlert(){
        alert = driver.switchTo().alert();
        alert.sendKeys("Test name");
        alert.accept();
    }

    public String getConfirmAlertMessageText(){
        return driver.findElement(confirmResult).getText();
    }

    public String getPromptAlertMessageText(){
        return driver.findElement(promptResult).getText();
    }
}
