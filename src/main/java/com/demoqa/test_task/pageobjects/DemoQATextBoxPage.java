package com.demoqa.test_task.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQATextBoxPage {

    private final WebDriver driver;
    private final By mainHeader = By.className("main-header");

    private final By fullNameInput = By.xpath(".//input[@placeholder='Full Name']");
    private final By emailInput = By.xpath(".//input[@placeholder='name@example.com']");

    private final By currentAddressTextArea = By.xpath(".//textarea[@placeholder='Current Address']");

    private final By permanentAddressTextArea = By.xpath(".//textarea[@id='permanentAddress']");
    private final By submitButton = By.xpath(".//button[@id='submit']");

    private final By savedFullName = By.xpath(".//p[@id='name' and @class='mb-1']");
    private final By savedEmail = By.xpath(".//p[@id='email' and @class='mb-1']");

    private final By savedCurrentAddress = By.xpath(".//p[@id='currentAddress' and @class='mb-1']");
    private final By savedPermanentAddress = By.xpath(".//p[@id='permanentAddress' and @class='mb-1']");
    private final By buttonsButton = By.xpath(".//div[@class='element-list collapse show']/ul/li[5]");
    public DemoQATextBoxPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForLoadingTextBoxPage() {
        new WebDriverWait(driver,8)
                .until(ExpectedConditions.visibilityOfElementLocated(mainHeader));
    }

    public void fillInTextBoxData(String fullName, String email, String currentAddress, String permanentAddress){
        driver.findElement(fullNameInput).clear();
        driver.findElement(fullNameInput).sendKeys(fullName);
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(currentAddressTextArea).clear();
        driver.findElement(currentAddressTextArea).sendKeys(currentAddress);
        driver.findElement(permanentAddressTextArea).clear();
        driver.findElement(permanentAddressTextArea).sendKeys(permanentAddress);
    }

    public void performClickOnSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public void performClickOnButtonsButton(){ driver.findElement(buttonsButton).click();}

    public String getFullNameValue() {return driver.findElement(savedFullName).getText();}
    public String getEmailValue() {return driver.findElement(savedEmail).getText();}

    public String getCurrentAddressValue() {return driver.findElement(savedCurrentAddress).getText();}
    public String getPermanentAddressValue() {return driver.findElement(savedPermanentAddress).getText();}

}
