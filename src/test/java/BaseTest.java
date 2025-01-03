import com.company.base.BaseAction;
import com.company.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    BaseAction baseAction;

    @BeforeMethod
    public void setUp() throws IOException {
        baseAction = new BaseAction();
        driver = baseAction.getDriver();
        driver.get(baseAction.getUrl());
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
