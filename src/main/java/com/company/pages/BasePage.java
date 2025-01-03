package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void getText(By locator) {
        findElement(locator).click();
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public void enterText(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public boolean getCurrentUrl(String url) {
        return wait.until(ExpectedConditions.urlToBe(url));
    }

    public boolean errorMessageIsDisplayed(By locator) {
        return wait.until(ExpectedConditions.visibilityOf(findElement(locator))).isDisplayed();
    }
}
