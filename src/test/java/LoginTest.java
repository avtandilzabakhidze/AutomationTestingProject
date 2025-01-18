import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginCredentials", description = "Test login with valid credentials")
    public void testLogin(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkCurrentUrl("https://www.saucedemo.com/inventory.html"), "\n The URL after login is incorrect \n");
        Assert.assertTrue(loginPage.logoIsDisplayed(), "\n The logo is not displayed on the inventory page after login \n");
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

    @Test(description = "Test login with empty credentials")
    public void testEmptyCredentials() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkRequiredParams(), "\n Error message was not displayed \n");
    }

    @Test(description = "Test login with empty password")
    public void testEmptyPassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkRequiredParams(), "\n Error message was not displayed \n");
    }

    @Test(description = "Test login with empty username")
    public void testEmptyUsername() {
        loginPage.enterUsername("");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkRequiredParams(), "\n Error message was not displayed \n");
    }

    @Test(description = "Test login with locked out user")
    public void testLockedOutUser() {
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkRequiredParams(), "\n Error message was not displayed \n");
    }

    @Test(description = "Test login with wrong username")
    public void testWrongUsername() {
        loginPage.enterUsername("123");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkRequiredParams(), "\n Error message was not displayed \n");
    }

    @Test(description = "Test login with wrong password")
    public void testWrongPassword() {
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("123");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.checkRequiredParams(), "\n Error message was not displayed \n");
    }
}
