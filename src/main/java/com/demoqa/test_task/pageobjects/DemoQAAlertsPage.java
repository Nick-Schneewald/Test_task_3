package com.demoqa.test_task.pageobjects;

import io.qameta.allure.Step;
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
    @Step("21.\tНажать на кнопку «Click me»  рядом с Click Button to see alert")
    public void performClickOnAlertButton(){
        driver.findElement(alertButton).click();
    }
    @Step("23.\tНажать на кнопку «Click me»  рядом с On button click, alert will appear after 5 seconds")
    public void performClickOnTimerAlertButton(){
        driver.findElement(timerAlertButton).click();
    }
    @Step("22.\tЗакрыть уведомление")
    public void closeAlert(){
        alert = driver.switchTo().alert();
        alert.accept();
    }
    @Step("24.\tЗакрыть уведомление")
    public void closeTimerAlert(){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.accept();
    }
    @Step("25.\tНажать на кнопку «Click me»  рядом с On button click, confirm box will appear")
    public void performClickOnConfirmAlertButton(){
        driver.findElement(confirmAlertButton).click();
    }
    @Step("28.\tНажать на кнопку «Click me»  рядом с On button click, prompt box will appear")
    public void performClickOnPromptAlertButton(){
        driver.findElement(promptAlertButton).click();
    }
    @Step("26.\tНажать на кнопку «Да» в уведомление")
    public void closeConfirmAlert(){
        alert = driver.switchTo().alert();
        alert.accept();
    }
    @Step("29.\tЗаполнить поле в уведомление данными: Test name")
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
