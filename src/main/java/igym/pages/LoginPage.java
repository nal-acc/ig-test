package igym.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.java.Log;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    public final String relativeUrlPath = "login";
    public final String alertMessageText = "These credentials do not match our records.";
    private final SelenideElement title = $x("//h1[contains(text(), 'Sign In')]");
    private final SelenideElement emailInput = $("form input[name ='email']");
    private final SelenideElement passwordInput = $("form input[name='password']");
    private final SelenideElement loginButton = $("form button[type='submit']");
    private final SelenideElement alertMessage = $(".MuiAlert-message");

    public LoginPage() {
        title.shouldBe(Condition.exist);
    }

    @Step("Fill email")
    public LoginPage setUserEmail(String email) {
        setValue(emailInput, email);
        return this;
    }

    @Step("Fill password")
    public LoginPage setPassword(String password) {
        setValue(passwordInput, password);
        return this;
    }

    @Step("Click login button")
    public AdminUserPage clickLoginButton() {
        loginButton.shouldBe(Condition.enabled).click();
        return new AdminUserPage();
    }

    @Step("Click login button and return login page")
    public LoginPage clickLoginButtonAndReturnLoginPage() {
        loginButton.shouldBe(Condition.enabled).click();
        return this;
    }

    @Step("Get alert message text")
    public String getAlertMessageText() {
        return alertMessage.text();
    }
}