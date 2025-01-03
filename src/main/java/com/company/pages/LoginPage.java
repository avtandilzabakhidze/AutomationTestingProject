package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//h3[@data-test ='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String userNameText) {
        enterText(username, userNameText);
    }

    public void enterPassword(String passwordText) {
        enterText(password, passwordText);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public boolean checkCurrentUrl(String expectedUrl) {
        return getCurrentUrl(expectedUrl);
    }

    public boolean checkRequiredParams(){
        return errorMessageIsDisplayed(errorMessage);
    }
}
