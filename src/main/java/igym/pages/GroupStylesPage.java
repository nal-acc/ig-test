package igym.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GroupStylesPage {
    public final String relativeUrlPath = "group-styles";
    private final SelenideElement title = $x("//*[@id='app']/div/header/div/h1[contains(text(), 'Group Styles')]");
    private final SelenideElement titleColumn = $("table tbody tr td:nth-child(2)");
    private final SelenideElement createButton = $("main button[type='button']");
    public GroupStylesPage() {
        title.shouldBe(Condition.exist);
    }

    @Step("Get title column text")
    public String getTitleColumnText() {
        return titleColumn.text();
    }

    @Step("Click create button")
    public CreateGroupStylesPage clickCreateButton() {
        createButton.shouldBe(Condition.enabled).click();
        return new CreateGroupStylesPage();
    }
}
