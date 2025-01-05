package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {
    private final By addToCartButton = By.xpath("//button[text() ='Add to cart']");
    private final By removeToCartButton = By.xpath("//button[text() ='Remove']");
    private final By price = By.xpath("//div[@class ='inventory_item_price']");
    private final By productName = By.xpath("//div[@class ='inventory_item_name ']");
    private final By cart = By.xpath("//a[@class ='shopping_cart_link']");
    private final By cartProductNumber = By.xpath("//span[@class ='shopping_cart_badge']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        click(addToCartButton);
    }

    public void removeToCart() {
        click(removeToCartButton);
    }

    public void addAllProducts() {
        List<WebElement> allProducts = findElements(addToCartButton);
        for (WebElement allProduct : allProducts) {
            allProduct.click();
        }
    }

    public void removeAllProductsFromCart() {
        List<WebElement> removeProducts = findElements(removeToCartButton);
        for (WebElement removeProduct : removeProducts) {
            removeProduct.click();
        }
    }

    public int getProductNumber() {
        return Integer.parseInt(getText(cartProductNumber));
    }

    public boolean checkProductNumber() {
        return elementIsDisplayed(cartProductNumber);
    }
}
