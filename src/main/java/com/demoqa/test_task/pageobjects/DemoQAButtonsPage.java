package com.demoqa.test_task.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQAButtonsPage {
    private final WebDriver driver;
    private final By mainHeader = By.className("main-header");
    private final By doubleClickButton = By.id("doubleClickBtn");
    private final By rightClickButton = By.id("rightClickBtn");
    private final By clickMeButton = By.xpath(".//button[text()='Click Me']");

    private final By dynamicClickMessage = By.id("dynamicClickMessage");

    private final By rightClickMessage = By.id("rightClickMessage");
    private final By doubleClickMessage = By.id("doubleClickMessage");

    private final By alertsFramesWindowsButton = By.xpath(".//div[text()='Alerts, Frame & Windows']");

    private final By browserWindowsButton = By.xpath(".//span[text()='Browser Windows']/ancestor::li[@class='btn btn-light ' and @id='item-0']");
    //(".//span[text()='Browser Windows']/ancestor::li");
    //(".//div[@class='element-list collapse show']/ul/li[1]");
    public DemoQAButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadingButtonsPage(){
        new WebDriverWait(driver,8)
                .until(ExpectedConditions.visibilityOfElementLocated(mainHeader));
    }

    public void performClickOnClickMeButton(){
        driver.findElement(clickMeButton).click();
    }

    public void performClickOnDoubleClickMeButton(){
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(doubleClickButton)).perform();
    }

    public void performClickOnRightClickButton(){
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(rightClickButton)).perform();
    }

    public String getDynamicClickResultMessage(){return driver.findElement(dynamicClickMessage).getText();}

    public String getRightClickResultMessage(){return driver.findElement(rightClickMessage).getText();}

    public String getDoubleClickResultMessage(){return driver.findElement(doubleClickMessage).getText();}

    public void performClickOnAlertsFrameWindowsButton(){
        WebElement element = driver.findElement(alertsFramesWindowsButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void performClickOnBrowserWindowsTab(){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOfElementLocated(browserWindowsButton));
        driver.findElement(browserWindowsButton).click(); }
}
