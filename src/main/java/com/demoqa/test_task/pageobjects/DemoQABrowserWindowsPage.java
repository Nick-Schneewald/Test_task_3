package com.demoqa.test_task.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQABrowserWindowsPage {
    private final WebDriver driver;
    private final By mainHeader = By.className("main-header");
    private final By newTabButton = By.id("tabButton");

    private final By newWindowButton = By.id("windowButton");
    private final By newTabHeading = By.xpath(".//h1[@id='sampleHeading']");
    private final By newWindowHeading = By.xpath(".//h1[@id='sampleHeading']");



    public DemoQABrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadingBrowserWindowsPage(){
        new WebDriverWait(driver,8)
                .until(ExpectedConditions.visibilityOfElementLocated(mainHeader));
        /*new WebDriverWait(driver,8)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));*/
    }
    @Step("16.\tНажать на кнопку «New Tab»")
    public void performClickOnNewTabButton(){
        driver.findElement(newTabButton).click();
    }
    @Step("17.\tЗакрыть новую вкладку")
    public void closeNewTab(){
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
    }
    @Step("18.\tНажать на кнопку «New window»")
    public void performClickOnNewWindowButton() { driver.findElement(newWindowButton).click(); }
    @Step("19.\tЗакрыть новое окно")
    public void closeNewWindow(){
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
    }


}
