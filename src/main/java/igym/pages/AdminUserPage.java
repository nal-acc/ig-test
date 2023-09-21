package igym.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AdminUserPage {
    public final String relativeUrlPath = "admin-users";
    private final SelenideElement title = $x("//*[@id='app']/div/header/div/h1[contains(text(), 'Admin Users')]");

    public AdminUserPage() {
        title.shouldBe(Condition.exist);
    }
}