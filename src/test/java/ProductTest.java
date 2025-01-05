import org.testng.Assert;
import org.testng.annotations.Test;

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
}
