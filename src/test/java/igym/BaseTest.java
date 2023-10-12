package igym;

import com.codeborne.selenide.Selenide;
import igym.api.DatabaseApi;
import igym.data.UserData;
import igym.entity.User;
import igym.pages.AdminUserPage;
import igym.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

public class BaseTest {
    @BeforeClass
    public void beforeClass()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void beforeTest()
    {
        DatabaseApi.prepareDb();
    }

    protected void openLoginPage()
    {
        open("http://admin.igym.test/login");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result)
    {
        if (result.getStatus() != ITestResult.SUCCESS) {
            saveScreenshot(screenshot(OutputType.BYTES));
        }
        Selenide.closeWebDriver();
    }

    @AfterTest(alwaysRun = true)
    public void afterTEst()
    {
        DatabaseApi.cleanDb();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot)
    {
        return screenShot;
    }

    protected AdminUserPage loginAsAdmin()
    {
        User user = UserData.admin();
        openLoginPage();
        return new LoginPage()
                .setUserEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButton();
    }

    protected void sleep(long millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}
