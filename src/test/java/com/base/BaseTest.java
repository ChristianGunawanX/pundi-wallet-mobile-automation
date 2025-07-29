package com.base;

import com.pages.LoginPage;
import com.pages.PundiAiNetwork;
import org.testng.Assert;
import utils.TestDataUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static AndroidDriver driver;

    @BeforeSuite
    public void setUp() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader("config.properties"));

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(props.getProperty("platformName"))
                .setAutomationName(props.getProperty("automationName"))
                .setUdid(props.getProperty("udid"))
                .setApp(props.getProperty("app"));

        URL url = new URL(props.getProperty("appiumServerUrl"));
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeTest(alwaysRun = true)
    public void performLogin() throws InterruptedException {
            String recoveryPhrase = TestDataUtils.getTestData("recovery_phrase");
            String password = TestDataUtils.getTestData("password");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickContinueAnotherWay();
            loginPage.clickImportWalletButton();
            loginPage.clickAgreeTnC();
            loginPage.clickConfirm();
            loginPage.fillmnemonicLabel(recoveryPhrase);
            loginPage.clickConfirm();
            Thread.sleep(2000);
            loginPage.enterPassword(password);
            loginPage.enterConfirmPassword(password);
            loginPage.clickImportWalletBtn();
            loginPage.clickSkipBtn();
            loginPage.clickDontAllowBtn();
        }

    @BeforeTest(alwaysRun = true)
    public void changeToPundiiAINetwork() throws InterruptedException {
        PundiAiNetwork pundiAiNetwork = new PundiAiNetwork(driver);
        pundiAiNetwork.clickNetwork();
        pundiAiNetwork.clickPundiAiAddress();
        pundiAiNetwork.clickPundiAiWallet();
        String actualSymbolText = pundiAiNetwork.getSymbolText();
        String expectedSymbolText = "PUNDIAI";
        Assert.assertEquals(actualSymbolText, expectedSymbolText);
    }
    }
