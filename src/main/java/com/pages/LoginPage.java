package com.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    @AndroidFindBy(id = "com.pundix.functionx:id/rlMore")
    private WebElement continueAnotherWayButton;

    @AndroidFindBy(id = "com.pundix.functionx:id/rlImport")
    private WebElement importWalletButton;

    @AndroidFindBy(id = "com.pundix.functionx:id/cb_term")
    private WebElement btn_AgreeTnC;

    @AndroidFindBy(id = "com.pundix.functionx:id/btn_confirm")
    private WebElement btn_Confirm;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement labelViewMnemonics;

    private static final String PASSWORD_INPUT_XPATH_PATTERN =
            "(//android.widget.EditText[@resource-id='com.pundix.functionx:id/ed_input_text'])[%d]";

    @AndroidFindBy(id = "com.pundix.functionx:id/btn_create")
    private WebElement btn_importWallet;

    @AndroidFindBy(id = "com.pundix.functionx:id/tv_neutral")
    private WebElement btn_Skip;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement btn_Dont_Allow;

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickContinueAnotherWay() {
        waitForElementToBeClickable(continueAnotherWayButton);
        continueAnotherWayButton.click();
    }

    public void clickImportWalletButton() {
        waitForElementToBeClickable(importWalletButton);
        importWalletButton.click();
    }

    public void clickAgreeTnC() {
        waitForElementToBeClickable(btn_AgreeTnC);
        btn_AgreeTnC.click();
    }

    public void clickConfirm() {
        waitForElementToBeClickable(btn_Confirm);
        btn_Confirm.click();
    }

    public void fillmnemonicLabel(String recoveryPhase) {
        waitForElementToBeVisible(labelViewMnemonics);
        labelViewMnemonics.sendKeys(recoveryPhase);
    }

    private void enterTextIntoIndexedField(String text, int fieldIndex) {
        String dynamicXpath = String.format(PASSWORD_INPUT_XPATH_PATTERN, fieldIndex);
        WebElement inputField = driver.findElement(By.xpath(dynamicXpath));
        inputField.sendKeys(text);
    }

    public void enterPassword(String password) {
        enterTextIntoIndexedField(password, 1);
    }

    public void enterConfirmPassword(String password) {
        enterTextIntoIndexedField(password, 2);
    }

    public void clickImportWalletBtn() {
        waitForElementToBeClickable(btn_importWallet);
        btn_importWallet.click();
    }

    public void clickSkipBtn() {
        waitForElementToBeClickable(btn_Skip);
        btn_Skip.click();
    }

    public void clickDontAllowBtn() {
        waitForElementToBeClickable(btn_Dont_Allow);
        btn_Dont_Allow.click();
    }


}
