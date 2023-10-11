package igym.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateGroupStylesPage extends BasePage {
    public final String relativeUrlPath = "group-styles/create";
    private final SelenideElement title = $x("//*[@id='app']/div/header/div/h1[contains(text(), 'Group Styles')]");
    private final SelenideElement titleInput = $("form input[name ='name']");
    private final SelenideElement createButton = $("main button[type='button']");

    public CreateGroupStylesPage() {
        title.shouldBe(Condition.exist);
    }

    @Step("Fill Title")
    public CreateGroupStylesPage setTitle (String value) {
        setValue(titleInput, value);
        return this;
    }

    @Step("Click create button")
    public GroupStylesPage clickCreateButton() {
        createButton.shouldBe(Condition.enabled).click();
        return new GroupStylesPage();
    }
}
