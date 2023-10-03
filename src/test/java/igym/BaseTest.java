package igym;

import com.codeborne.selenide.Selenide;
import igym.api.DatabaseApi;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

public class BaseTest {
    @BeforeClass
    public void beforeClass()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod()
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
        DatabaseApi.cleanDb();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot)
    {
        return screenShot;
    }

    protected void sleep(long millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}
