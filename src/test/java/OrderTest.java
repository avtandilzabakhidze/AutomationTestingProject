import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {
    @Test(description = "Test checkout with valid details")
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

    @Test(description = "Test checkout with missing details")
    public void testCheckoutWithMissingDetails() {
        baseLogin();
        productPage.addAllProducts();
        productPage.enterCart();
        orderPage.clickCheckoutButton();
        orderPage.enterFirstName("");
        orderPage.enterLastName("");
        orderPage.enterPostalCode("");
        orderPage.clickContinueButton();

        Assert.assertTrue(orderPage.isErrorMessageRequiredFields(), "\n Error message was not displayed \n");
    }

    @Test(description = "Test order summary total price")
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

    @Test(description = "Test back to home after order completion")
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
        Assert.assertTrue(orderPage.isOrderComplete(), "\n Order was not completed successfully \n");
        orderPage.clickBackToHome();
        Assert.assertTrue(loginPage.logoIsDisplayed(), "\n The logo is not displayed on the inventory page after login \n");
    }

    @Test(description = "Test total price calculation")
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

    @Test(description = "Test order cancellation")
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
        Assert.assertTrue(loginPage.logoIsDisplayed(), "\n logo is not displayed after cancelling the order \n");
    }
}
