package com.demoqa.test_task.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQALeftPanel {

    private final WebDriver driver;
    private final By textBoxTab = By.xpath(".//div[@class='element-list collapse show']/ul/li[1]");
    private final By buttonsButton = By.xpath(".//div[@class='element-list collapse show']/ul/li[5]");
    private final By alertsFramesWindowsButton = By.xpath(".//div[text()='Alerts, Frame & Windows']");
    private final By alertsButton = By.xpath(".//div[@class='element-list collapse show']/ul/li[2]");
    private final By browserWindowsButton = By.xpath(".//span[text()='Browser Windows']/ancestor::li[@class='btn btn-light ' and @id='item-0']");
    public DemoQALeftPanel(WebDriver driver) {
        this.driver = driver;
    }

    @Step("3.\tНажать на «Text box»")
    public void performClickOnTextBoxTab(){
        driver.findElement(textBoxTab).click();
    }
    @Step("7.\tНажать на «Buttons»")
    public void performClickOnButtonsButton(){ driver.findElement(buttonsButton).click();}

    @Step("14.\tНажать на «Alerts, Frame & Windows»")
    public void performClickOnAlertsFrameWindowsButton(){
        WebElement element = driver.findElement(alertsFramesWindowsButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    @Step("15.\tНажать на «Browser Windows»")
    public void performClickOnBrowserWindowsTab(){
        new WebDriverWait(driver,12)
                .until(ExpectedConditions.visibilityOfElementLocated(browserWindowsButton));
        driver.findElement(browserWindowsButton).click(); }
    @Step("20.\tНажать на «Alerts»")
    public void performClickOnAlertsButton(){
        driver.findElement(alertsButton).click();
    }
}
