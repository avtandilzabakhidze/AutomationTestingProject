import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginCredentials")
    public void testLogin(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkCurrentUrl("https://www.saucedemo.com/inventory.html"), "\n Expected URL is not correct \n");
        Assert.assertTrue(loginPage.logoIsDisplayed(), "\n Logo is not displayed \n");
    }

    @DataProvider(name = "loginCredentials")
    public Object[][] loginCredentials() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    @Test
    public void testEmptyCredentials() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkRequiredParams(), "\n Error message was not display \n");
    }

    @Test
    public void testEmptyPassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkRequiredParams(), "\n Error message was not display \n");
    }

    @Test
    public void testEmptyUsername() {
        loginPage.enterUsername("");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkRequiredParams(), "\n Error message was not display \n");
    }

    @Test
    public void testLockedOutUser() {
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkRequiredParams(), "\n Error message was not display \n");
    }

    @Test
    public void testWrongUsername() {
        loginPage.enterUsername("123");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkRequiredParams(), "\n Error message was not display \n");
    }

    @Test
    public void testWrongPassword() {
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("123");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkRequiredParams(), "\n Error message was not display \n");
    }
}
