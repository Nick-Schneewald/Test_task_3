package com.demoqa.test_task.pageobjects;

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

    private final By alertsButton = By.xpath(".//div[@class='element-list collapse show']/ul/li[2]");

    public DemoQABrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadingBrowserWindowsPage(){
        new WebDriverWait(driver,8)
                .until(ExpectedConditions.visibilityOfElementLocated(mainHeader));
        /*new WebDriverWait(driver,8)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));*/
    }

    public void performClickOnNewTabButton(){
        driver.findElement(newTabButton).click();
    }

    public void closeNewTab(){
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
    }

    /*
    public void waitForLoadingNewTabContent(){
        driver.switchTo().defaultContent();
        new WebDriverWait(driver,8)
                .until(ExpectedConditions.visibilityOfElementLocated(newTabHeading));
    }
    */
    public void performClickOnNewWindowButton() { driver.findElement(newWindowButton).click(); }

    public void closeNewWindow(){
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
    }

    public void performClickOnAlertsButton(){
        driver.findElement(alertsButton).click();
    }
}
