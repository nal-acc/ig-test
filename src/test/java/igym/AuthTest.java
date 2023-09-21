package igym;

import com.codeborne.selenide.WebDriverRunner;
import igym.data.UserData;
import igym.entity.User;
import igym.pages.AdminUserPage;
import igym.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest {
    @Test
    public void loginAsAdminTest() {
        User user = UserData.admin();
        openLoginPage();
        AdminUserPage adminUserPage = new LoginPage()
                .setUserEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginButton();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String[] urlParts = currentUrl.split("/");
        Assert.assertEquals(urlParts[urlParts.length -1], adminUserPage.relativeUrlPath);
    }

    @Test
    public void loginInvalidDataTest() {
        openLoginPage();
        LoginPage loginPage = new LoginPage()
                .setUserEmail("fake@email.com")
                .setPassword("12344567")
                .clickLoginButtonAndReturnLoginPage();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String[] urlParts = currentUrl.split("/");
        Assert.assertEquals(urlParts[urlParts.length -1], loginPage.relativeUrlPath);
        Assert.assertEquals(loginPage.getAlertMessageText(), loginPage.alertMessageText);
    }
}
