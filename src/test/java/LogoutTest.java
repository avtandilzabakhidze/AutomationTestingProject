import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout() {
        baseLogin();
        logoutPage.openBurgerManu();
        logoutPage.clickLogoutButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(logoutPage.isUsernameButtonPresent(), "\n Username input field is not present on the login page after logout \n");
        softAssert.assertTrue(logoutPage.isPasswordButtonPresent(), "\n Password input field is not present on the login page after logout \n");
        softAssert.assertAll();
    }
}
