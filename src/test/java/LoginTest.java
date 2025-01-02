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
    }

    public void baseLogin() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @DataProvider(name = "loginCredentials")
    public Object[][] loginCredentials() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
//                {"locked_out_user", "secret_sauce"}, Add negative case
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }
}
