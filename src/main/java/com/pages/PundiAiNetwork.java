package com.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import com.pages.BasePage;

public class PundiAiNetwork extends BasePage{
    @AndroidFindBy(id = "com.pundix.functionx:id/llChainChain")
    private WebElement networkButton;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[@resource-id='com.pundix.functionx:id/chainView'])[2]")
    private WebElement pundiAiWallet;

    @AndroidFindBy(id = "com.pundix.functionx:id/rlAddress")
    private WebElement pundiAiAddress;

    @AndroidFindBy(id = "com.pundix.functionx:id/tvSymbol")
    private WebElement symbolTextView;

    @AndroidFindBy(id = "com.pundix.functionx:id/tvSend")
    private WebElement sendButton;

    @AndroidFindBy(id = "com.pundix.functionx:id/edInputText")
    private WebElement sendToInputText;

    @AndroidFindBy(id = "com.pundix.functionx:id/editSet")
    private WebElement editInputText;

    @AndroidFindBy(id = "com.pundix.functionx:id/ibBack")
    private WebElement backButton;

    public PundiAiNetwork(AndroidDriver driver) {
        super(driver);
    }

    public void clickNetwork() {
        waitForElementToBeClickable(networkButton);
        networkButton.click();
    }

    public void clickPundiAiWallet() {
        waitForElementToBeClickable(pundiAiWallet);
        pundiAiWallet.click();
    }

    public void clickPundiAiAddress() {
        waitForElementToBeClickable(pundiAiAddress);
        pundiAiAddress.click();
    }

    public void clickPundiAiToken() {
        waitForElementToBeClickable(symbolTextView);
        symbolTextView.click();
    }

    public String getSymbolText() {
        waitForElementToBeVisible(symbolTextView);
        return symbolTextView.getText();
    }

    public void clickSendButton() {
        waitForElementToBeClickable(sendButton);
        sendButton.click();
    }

    public void enterSendToAddress(String address) {
        waitForElementToBeVisible(sendToInputText);
        sendToInputText.click();
        waitForElementToBeVisible(editInputText);
        editInputText.clear();
        editInputText.sendKeys(address);
        backButton.click();
    }
}

