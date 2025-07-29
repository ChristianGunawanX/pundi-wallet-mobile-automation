package com.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AndroidDriver driver;
    protected static final int DEFAULT_TIMEOUT_SECONDS = 10;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected void waitForElementToBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.err.println("Element not visible after " + DEFAULT_TIMEOUT_SECONDS + " seconds: " + element);
            throw e;
        }
    }

    protected WebElement waitForElementLocated(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.err.println("Element not present after " + DEFAULT_TIMEOUT_SECONDS + " seconds: " + locator);
            throw e;
        }
    }

    protected WebElement waitForElementToBeClickable(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.err.println("Element not clickable after " + DEFAULT_TIMEOUT_SECONDS + " seconds: " + element);
            throw e;
        }
    }

}
