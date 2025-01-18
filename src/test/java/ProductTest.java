import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductTest extends BaseTest {
    @Test(description = "Test adding the first product to the cart")
    public void addFirstProduct() {
        baseLogin();
        productPage.addToCart();

        Assert.assertEquals(productPage.getProductNumber(), 1, "\n Product number after adding the first product is incorrect \n");
    }

    @Test(description = "Test adding the first product and removing it from the cart")
    public void addFirstProductAndRemove() {
        baseLogin();
        productPage.addToCart();
        productPage.removeToCart();

        Assert.assertFalse(productPage.checkProductNumber(), "\n Product number should be 0 after removing the product \n");
    }

    @Test(description = "Test adding all products to the cart")
    public void addAllProduct() {
        baseLogin();
        productPage.addAllProducts();

        Assert.assertEquals(productPage.getProductNumber(), 6, "\n Product number after adding all products is incorrect \n");
    }

    @Test(description = "Test removing all products from the cart")
    public void removeAllProduct() {
        baseLogin();
        productPage.addAllProducts();
        productPage.removeAllProductsFromCart();

        Assert.assertFalse(productPage.checkProductNumber(), "\n Product number should be 0 after removing all products \n");
    }

    @Test(description = "Test verifying product details")
    public void verifyProductDetails() {
        baseLogin();
        String productPrice = productPage.getProductPrice();
        String productName = productPage.getProductName();

        Assert.assertEquals(productPrice, "$29.99", "\n Product price is incorrect \n");
        Assert.assertEquals(productName, "Sauce Labs Backpack", "\n Product name is incorrect \n");
    }

    @Test(description = "Test sorting products by name A to Z")
    public void testSortByNameAToZ() {
        baseLogin();
        productPage.sortByNameAsc();

        List<String> productNames = productPage.getProductNames();
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);

        Assert.assertEquals(sortedProductNames, productNames, "\n Sorting products from A to Z did not work correctly \n");
    }

    @Test(description = "Test sorting products by name Z to A")
    public void testSortByNameZToA() {
        baseLogin();
        productPage.sortByNameDesc();

        List<String> productNames = productPage.getProductNames();
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames, Collections.reverseOrder());

        Assert.assertEquals(sortedProductNames, productNames, "\n Sorting products from Z to A did not work correctly \n");
    }

    @Test(description = "Test sorting products by price from low to high")
    public void testSortByPriceLowToHigh() {
        baseLogin();
        productPage.sortByPriceToHigh();

        List<Double> productPrices = productPage.getProductPrices();
        List<Double> sortedProductPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedProductPrices);

        Assert.assertEquals(sortedProductPrices, productPrices, "\n Sorting products by price from low to high did not work correctly \n");
    }

    @Test(description = "Test sorting products by price from high to low")
    public void testSortByPriceHighToLow() {
        baseLogin();
        productPage.sortByPriceHighToLow();

        List<Double> productPrices = productPage.getProductPrices();
        List<Double> sortedProductPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedProductPrices, Collections.reverseOrder());

        Assert.assertEquals(sortedProductPrices, productPrices, "\n Sorting products by price from high to low did not work correctly \n");
    }

    @Test(description = "Test adding one product to the cart")
    public void testAddOneProductInCart() {
        baseLogin();
        productPage.addToCart();
        productPage.enterCart();
        int productNum = productPage.CartProductNumber();

        Assert.assertEquals(productNum, 1, "\n Product number in the cart is incorrect after adding one product \n");
    }

    @Test(description = "Test adding all products to the cart")
    public void testAddAllProductsInCart() {
        baseLogin();
        productPage.addAllProducts();
        productPage.enterCart();
        int productNum = productPage.CartProductNumber();

        Assert.assertEquals(productNum, 6, "\n Product number in the cart is incorrect after adding all products \n");
    }
}
