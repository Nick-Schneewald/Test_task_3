package com.demoqa.test_task.pageobjects;

import io.qameta.allure.Step;
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

    public DemoQAButtonsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadingButtonsPage(){
        new WebDriverWait(driver,8)
                .until(ExpectedConditions.visibilityOfElementLocated(mainHeader));
    }

    @Step("8.\tНажать на кнопку «Click me»")
    public void performClickOnClickMeButton(){
        driver.findElement(clickMeButton).click();
    }
    @Step("12.\tНажать на кнопку «Double Click me»")
    public void performClickOnDoubleClickMeButton(){
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(doubleClickButton)).perform();
    }
    @Step("10.\tНажать на кнопку «Right Click me»")
    public void performClickOnRightClickButton(){
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(rightClickButton)).perform();
    }

    public String getDynamicClickResultMessage(){return driver.findElement(dynamicClickMessage).getText();}

    public String getRightClickResultMessage(){return driver.findElement(rightClickMessage).getText();}

    public String getDoubleClickResultMessage(){return driver.findElement(doubleClickMessage).getText();}
}
