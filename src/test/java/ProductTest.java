import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductTest extends BaseTest {
    @Test
    public void addFirstProduct() {
        baseLogin();
        productPage.addToCart();

        Assert.assertEquals(productPage.getProductNumber(), 1, "\n product number is not correct \n");
    }

    @Test
    public void addFirstProductAndRemove() {
        baseLogin();
        productPage.addToCart();
        productPage.removeToCart();

        Assert.assertFalse(productPage.checkProductNumber(), "\n product number is not correct \n");
    }

    @Test
    public void addAllProduct() {
        baseLogin();
        productPage.addAllProducts();

        Assert.assertEquals(productPage.getProductNumber(), 6, "\n product number is not correct \n");
    }


    @Test
    public void removeAllProduct() {
        baseLogin();
        productPage.addAllProducts();
        productPage.removeAllProductsFromCart();

        Assert.assertFalse(productPage.checkProductNumber(), "\n product number is not correct \n");
    }

    @Test
    public void verifyProductDetails() {
        baseLogin();
        String productPrice = productPage.getProductPrice();
        String productName = productPage.getProductName();

        Assert.assertEquals(productPrice, "$29.99", "\n product price is not correct \n");
        Assert.assertEquals(productName, "Sauce Labs Backpack", "\n product name is not correct \n");
    }

    @Test
    public void testSortByNameAToZ() {
        baseLogin();
        productPage.sortByNameAsc();

        List<String> productNames = productPage.getProductNames();
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);

        Assert.assertEquals(sortedProductNames, productNames, "\n Sort A ro Z don't work \n");
    }

    @Test
    public void testSortByPriceLowToHigh() {
        baseLogin();
        productPage.sortByPriceToHigh();

        List<Double> productPrices = productPage.getProductPrices();
        List<Double> sortedProductPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedProductPrices);

        Assert.assertEquals(sortedProductPrices, productPrices, "\n Sort Low to High don't work \n");
    }

    @Test
    public void testAddOneProductInCart() {
        baseLogin();
        productPage.addToCart();
        productPage.enterCart();
        int productNum = productPage.CartProductNumber();

        Assert.assertEquals(productNum, 1, "\n product number is not correct \n");
    }

    @Test
    public void testAddAllProductsInCart() {
        baseLogin();
        productPage.addAllProducts();
        productPage.enterCart();
        int productNum = productPage.CartProductNumber();

        Assert.assertEquals(productNum, 6, "\n product number is not correct \n");
    }
}
