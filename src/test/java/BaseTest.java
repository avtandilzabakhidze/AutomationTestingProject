import com.company.base.BaseAction;
import com.company.pages.LoginPage;
import com.company.pages.LogoutPage;
import com.company.pages.OrderPage;
import com.company.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    BaseAction baseAction;
    ProductPage productPage;
    LogoutPage logoutPage;
    OrderPage orderPage;

    @BeforeMethod
    public void setUp() throws IOException {
        baseAction = new BaseAction();
        driver = baseAction.getDriver();
        driver.get(baseAction.getUrl());
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        logoutPage = new LogoutPage(driver);
        orderPage = new OrderPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void baseLogin() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }
}
