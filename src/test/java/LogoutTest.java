import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout() {
        baseLogin();
        logoutPage.openBurgerManu();
        logoutPage.clickLogoutButton();

        Assert.assertTrue(logoutPage.isUsernameButtonPresent(),"\n Username input is not present \n");
        Assert.assertTrue(logoutPage.isPasswordButtonPresent(),"\n Password input is not present \n");
    }
}
