package com.demoqa.test_task;

import com.demoqa.test_task.pageobjects.*;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class GivenScenarioTest{
    private static final String DEMO_QA_BASE_URL = "https://demoqa.com/";
    private WebDriver driver;
    private DemoQAMainPage mainPage;

    private DemoQAElementsPage elementsPage;

    private DemoQATextBoxPage textBoxPage;

    private DemoQAButtonsPage buttonsPage;

    private DemoQABrowserWindowsPage browserWindowsPage;

    private DemoQAAlertsPage alertsPage;

    private DemoQALeftPanel leftPanel;

    @Before
    public void setUp() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String browser=System.getProperty("browser");
        switch(browser) {
            case "chrome":{
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
        }
        driver.manage().window().maximize();
    }

    @Test
    public void performGivenTestScenario(){
        loadMainTestingURL();
        mainPage = new DemoQAMainPage(driver);

        mainPage.waitForLoadingMainPage();
        mainPage.performClickOnElements();

        elementsPage = new DemoQAElementsPage(driver);
        elementsPage.waitForLoadingElementsPage();
        leftPanel = new DemoQALeftPanel(driver);
        leftPanel.performClickOnTextBoxTab();

        textBoxPage = new DemoQATextBoxPage(driver);
        textBoxPage.waitForLoadingTextBoxPage();

        textBoxPage.fillInTextBoxData("Иванов Иван", "iivanov@yandex.ru", "ul. Lenina 12-4-1", "ul. Rogdestvenskaya 17-4-6");
        textBoxPage.performClickOnSubmitButton();

        checkForInputResults();
        //Move to Buttons Tab
        leftPanel.performClickOnButtonsButton();
        //Performing test actions with single-, double- and right- clicks and check for status messages
        buttonsPage = new DemoQAButtonsPage(driver);
        buttonsPage.waitForLoadingButtonsPage();
        buttonsPage.performClickOnClickMeButton();
        checkResultsForClickMeButton();

        buttonsPage.performClickOnRightClickButton();
        checkResultsForRightClickButton();

        buttonsPage.performClickOnDoubleClickMeButton();
        checkResultsForDoubleClickButton();

        leftPanel.performClickOnAlertsFrameWindowsButton();
        leftPanel.performClickOnBrowserWindowsTab();

        browserWindowsPage = new DemoQABrowserWindowsPage(driver);
        browserWindowsPage.waitForLoadingBrowserWindowsPage();

        browserWindowsPage.performClickOnNewTabButton();
        browserWindowsPage.closeNewTab();

        browserWindowsPage.performClickOnNewWindowButton();
        browserWindowsPage.closeNewWindow();

        leftPanel.performClickOnAlertsButton();

        alertsPage = new DemoQAAlertsPage(driver);
        alertsPage.performClickOnAlertButton();
        alertsPage.closeAlert();

        alertsPage.performClickOnTimerAlertButton();
        alertsPage.closeTimerAlert();

        alertsPage.performClickOnConfirmAlertButton();
        alertsPage.closeConfirmAlert();
        checkResultsForConfirmAlert();

        alertsPage.performClickOnPromptAlertButton();
        alertsPage.closePromptAlert();
        checkResultsForPromptAlert();
    }
    @Step("1.\tПерейти на https://demoqa.com/")
    public void loadMainTestingURL(){
        driver.get(DEMO_QA_BASE_URL);
    }
    @Step("6.\tПроверить, что данные в блоке сохранены корректно")
    public void checkForInputResults(){
        Assert.assertEquals("Иванов Иван",textBoxPage.getFullNameValue().substring(5));
        Assert.assertEquals("iivanov@yandex.ru",textBoxPage.getEmailValue().substring(6));
        Assert.assertEquals("ul. Lenina 12-4-1",textBoxPage.getCurrentAddressValue().substring(17));
        Assert.assertEquals("ul. Rogdestvenskaya 17-4-6", textBoxPage.getPermanentAddressValue().substring(20));
    }

    @Step("9.\tПроверить, что появился текст «You have done a dynamic click»")
    public void checkResultsForClickMeButton(){
        Assert.assertEquals("You have done a dynamic click",buttonsPage.getDynamicClickResultMessage());
    }

    @Step("11.\tПроверить, что появился текст «You have done a right click»")
    public void checkResultsForRightClickButton(){
        Assert.assertEquals("You have done a right click",buttonsPage.getRightClickResultMessage());
    }
    @Step("13.\tПроверить, что появился текст «You have done a double click»")
    public void checkResultsForDoubleClickButton(){
        Assert.assertEquals("You have done a double click", buttonsPage.getDoubleClickResultMessage());
    }

    @Step("27.\tПроверить, что появился текст You selected Ok")
    public void checkResultsForConfirmAlert(){
        Assert.assertEquals("You selected Ok",alertsPage.getConfirmAlertMessageText());
    }

    @Step("30.\tПроверить, что появился текст You entered Test name")
    public void checkResultsForPromptAlert(){
        Assert.assertEquals("You entered Test name",alertsPage.getPromptAlertMessageText());
    }
    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}


