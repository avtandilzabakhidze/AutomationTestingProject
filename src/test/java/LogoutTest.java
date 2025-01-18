import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout() {
        baseLogin();
        logoutPage.openBurgerManu();
        logoutPage.clickLogoutButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(logoutPage.isUsernameButtonPresent(), "\n Username input is not present \n");
        softAssert.assertTrue(logoutPage.isPasswordButtonPresent(), "\n Password input is not present \n");
        softAssert.assertAll();
    }
}
