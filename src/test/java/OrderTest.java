import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest{
    @Test
    public void testCheckoutWithValidDetails() {
        baseLogin();
        productPage.addAllProducts();
        productPage.enterCart();
        orderPage.clickCheckoutButton();
        orderPage.enterFirstName("one");
        orderPage.enterLastName("two");
        orderPage.enterPostalCode("1221");
        orderPage.clickContinueButton();
        orderPage.clickFinishButton();
        Assert.assertTrue(orderPage.isOrderComplete(), "\n Order was not completed successfully \n");
    }

    @Test
    public void testCheckoutWithMissingDetails() {
        baseLogin();
        productPage.addAllProducts();
        productPage.enterCart();
        orderPage.clickCheckoutButton();
        orderPage.enterFirstName("");
        orderPage.enterLastName("");
        orderPage.enterPostalCode("");
        orderPage.clickContinueButton();

        Assert.assertTrue(orderPage.isErrorMessageRequiredFields(), "\n error message is not display \n");
    }

    @Test
    public void testOrderSummaryTotalPrice() {
        baseLogin();
        productPage.addAllProducts();
        productPage.enterCart();
        orderPage.clickCheckoutButton();
        orderPage.enterFirstName("one");
        orderPage.enterLastName("two");
        orderPage.enterPostalCode("132");
        orderPage.clickContinueButton();
        double totalPrice = orderPage.getTotalPrice();
        double totalPriceWithoutTax = orderPage.getTotalPriceWithoutTax();
        double taxPrice = orderPage.getTaxPrice();

        Assert.assertEquals(totalPrice, 140.34, "Total price is incorrect");
        Assert.assertEquals(totalPriceWithoutTax, 129.94, "Item total is incorrect");
        Assert.assertEquals(taxPrice, 10.40, "Tax price is incorrect");
    }

    @Test
    public void testBackToHomeAfterOrderComplete() {
        baseLogin();
        productPage.addAllProducts();
        productPage.enterCart();
        orderPage.clickCheckoutButton();
        orderPage.enterFirstName("one");
        orderPage.enterLastName("two");
        orderPage.enterPostalCode("1223");
        orderPage.clickContinueButton();
        orderPage.clickFinishButton();
        Assert.assertTrue(orderPage.isOrderComplete(), "Order was not completed successfully");
        orderPage.clickBackToHome();
    }

    @Test
    public void testTotalPriceCalculation() {
        baseLogin();
        productPage.addAllProducts();
        productPage.enterCart();
        orderPage.clickCheckoutButton();
        orderPage.enterFirstName("one");
        orderPage.enterLastName("two");
        orderPage.enterPostalCode("1231");
        orderPage.clickContinueButton();
        double totalPrice = orderPage.getTotalPrice();

        Assert.assertEquals(totalPrice, 140.34, "Total price calculation is incorrect");
    }

    @Test
    public void cancelOrder() {
        baseLogin();
        productPage.addAllProducts();
        productPage.enterCart();
        orderPage.clickCheckoutButton();
        orderPage.enterFirstName("one");
        orderPage.enterLastName("two");
        orderPage.enterPostalCode("1223");
        orderPage.clickContinueButton();
        orderPage.cancelOrderLastStep();

        Assert.assertTrue(loginPage.checkCurrentUrl("https://www.saucedemo.com/inventory.html"), "\n Expected URL is not correct \n");
        Assert.assertTrue(loginPage.logoIsDisplayed(), "\n Logo is not displayed \n");
    }
}
