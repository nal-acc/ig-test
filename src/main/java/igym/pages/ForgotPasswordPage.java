package igym.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ForgotPasswordPage extends BasePage {
    public final String errorAlertText = "We can't find a user with that email address.";
    public final String successAlertText = "We have emailed your password reset link!";
    private final SelenideElement alertMessage = $(".MuiAlert-message");
    private final SelenideElement title = $x("//h1[contains(text(), 'Forgot password')]");
    private final SelenideElement emailInput = $("form input[name='email']");
    private final SelenideElement sendButton = $("form button[type='submit']");


    public ForgotPasswordPage() {
        title.shouldBe(Condition.exist);
    }

    @Step("Fill email")
    public ForgotPasswordPage setUserEmail(String email) {
        setValue(emailInput, email);
        return this;
    }

    @Step("Clicking SendButton")
    public ForgotPasswordPage clickSendButton() {
        sendButton.shouldBe(Condition.enabled).click();
        return this;
    }

    @Step("GetAlertMessageText")
    public String getAlertMessageText() {
        return alertMessage.text();
    }
}
