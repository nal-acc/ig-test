package igym;

import igym.data.UserData;
import igym.entity.User;
import igym.pages.ForgotPasswordPage;
import igym.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {
    @Test
    public void sendSuccessForgotPasswordLink() {
        User user = UserData.admin();
        openLoginPage();
        ForgotPasswordPage forgotPasswordPage = new LoginPage().clickForgotPasswordButton();
        forgotPasswordPage.setUserEmail(user.getEmail()).clickSendButton();
        Assert.assertEquals(forgotPasswordPage.getAlertMessageText(), forgotPasswordPage.successAlertText);
    }


    @Test
    public void sendNegativeForgotPasswordLink() {
        openLoginPage();
        ForgotPasswordPage forgotPasswordPage = new LoginPage().clickForgotPasswordButton();
        forgotPasswordPage.setUserEmail("test@test.com").clickSendButton();
        Assert.assertEquals(forgotPasswordPage.getAlertMessageText(), forgotPasswordPage.errorAlertText);

    }

}
