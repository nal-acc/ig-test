package igym.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateGroupAgesPage extends BasePage {
    public final String relativeUrlPath = "group-ages/create";
    private final SelenideElement title = $x("//*[@id='app']/div/header/div/h1[contains(text(), 'Group Ages')]");
    private final SelenideElement titleInput = $("form input[name ='name']");
    private final SelenideElement ageFromInput = $("form input[name ='age_from']");
    private final SelenideElement ageToInput = $("form input[name ='age_to']");
    private final SelenideElement ageFromMinusInput = $("form input[name ='age_from_minus']");
    private final SelenideElement ageToPlusInput = $("form input[name ='age_to_plus']");
    private final SelenideElement createButton = $("main button[type='button']");

    public CreateGroupAgesPage() {
        title.shouldBe(Condition.exist);
    }

    @Step("Fill Title")
    public CreateGroupAgesPage setTitle (String value) {
        setValue(titleInput, value);
        return this;
    }

    @Step("Fill Age from")
    public CreateGroupAgesPage setAgeFrom (String value) {
        setValue(ageFromInput, value);
        return this;
    }

    @Step("Fill Age to")
    public CreateGroupAgesPage setAgeTo (String value) {
        setValue(ageToInput, value);
        return this;
    }

    @Step("Fill Age from Minus")
    public CreateGroupAgesPage setAgeFromMinus (String value) {
        setValue(ageFromMinusInput, value);
        return this;
    }

    @Step("Fill Age to Plus")
    public CreateGroupAgesPage setAgeToPlus (String value) {
        setValue(ageToPlusInput, value);
        return this;
    }

    @Step("Click create button")
    public GroupAgesPage clickCreateButton() {
        createButton.shouldBe(Condition.enabled).click();
        return new GroupAgesPage();
    }
}
