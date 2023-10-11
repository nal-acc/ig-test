package igym.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GroupAgesPage {
    public final String relativeUrlPath = "group-ages";
    private final SelenideElement title = $x("//*[@id='app']/div/header/div/h1[contains(text(), 'Group Ages')]");
    private final SelenideElement titleColumn = $("table tbody tr td:nth-child(2)");
    private final SelenideElement ageFromColumn = $("table tbody tr td:nth-child(3)");
    private final SelenideElement ageToColumn = $("table tbody tr td:nth-child(4)");
    private final SelenideElement plusMinusColumn = $("table tbody tr td:nth-child(5)");
    private final SelenideElement createButton = $("main button[type='button']");

    public GroupAgesPage() {
        title.shouldBe(Condition.exist);
    }


    @Step("Get title column text")
    public String getTitleColumnText() {
        return titleColumn.text();
    }

    @Step("Get age from column text")
    public String getAgeFromColumnText() {
        return ageFromColumn.text();
    }

    @Step("Get age to column text")
    public String getAgeToColumnText() {
        return ageToColumn.text();
    }

    @Step("Get +/- column text")
    public String gePlusMinusColumnText() {
        return plusMinusColumn.text();
    }


    @Step("Click create button")
    public CreateGroupAgesPage clickCreateButton() {
        createButton.shouldBe(Condition.enabled).click();
        return new CreateGroupAgesPage();
    }
}
