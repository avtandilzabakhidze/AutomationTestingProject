package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {
    private final By BurgerButton = By.xpath("//div[@class=\"bm-burger-button\"]");
    private final By logoutButton = By.linkText("Logout");
    private final By username = By.id("user-name");
    private final By password = By.id("password");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void openBurgerManu() {
        click(BurgerButton);
    }

    public void clickLogoutButton() {
        click(logoutButton);
    }

    public boolean isUsernameButtonPresent() {
        return elementIsDisplayed(username);
    }

    public boolean isPasswordButtonPresent() {
        return elementIsDisplayed(password);
    }
}
