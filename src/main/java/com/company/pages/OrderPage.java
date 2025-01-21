package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {
    private final By CheckoutButton = By.id("checkout");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By PostalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By totalPrice = By.xpath("//div[@class='summary_total_label']");
    private final By totalPriceWithoutTax = By.xpath("//div[@class='summary_subtotal_label']");
    private final By taxPrice = By.xpath("//div[@class='summary_tax_label']");
    private final By completeHeader = By.xpath("//h2[@class='complete-header']");
    private final By errorMessageRequiredFields = By.xpath("//h3[@data-test=\"error\"]");
    private final By backHome = By.id("back-to-products");
    private final By cancel= By.id("cancel");

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton() {
        click(CheckoutButton);
    }

    public void enterFirstName(String name) {
        enterText(firstName, name);
    }

    public void enterLastName(String name) {
        enterText(lastName, name);
    }

    public void enterPostalCode(String code) {
        enterText(PostalCode, code);
    }

    public void clickContinueButton() {
        click(continueButton);
    }

    public void clickFinishButton() {
        click(finishButton);
    }

    public double getTotalPrice() {
        String totalPriceText = getText(totalPrice).replaceAll("[^\\d.]", "");
        return Double.parseDouble(totalPriceText);
    }

    public double getTotalPriceWithoutTax() {
        String totalPriceText = getText(totalPriceWithoutTax).replaceAll("[^\\d.]", "");
        return Double.parseDouble(totalPriceText);
    }

    public double getTaxPrice() {
        String taxPriceText = getText(taxPrice).replaceAll("[^\\d.]", "");
        return Double.parseDouble(taxPriceText);
    }

    public boolean isOrderComplete() {
        return elementIsDisplayed(completeHeader);
    }

    public void clickBackToHome() {
        click(backHome);
    }

    public void cancelOrderLastStep() {
        click(cancel);
    }

    public boolean isErrorMessageRequiredFields() {
        return elementIsDisplayed(errorMessageRequiredFields);
    }
}
