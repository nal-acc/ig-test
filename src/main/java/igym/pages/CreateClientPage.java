package igym.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateClientPage extends BasePage {
    private final SelenideElement headerTitle = $x("//*[@id='app']/div/header/div/h1[contains(text(), 'Clients')]");
    private final SelenideElement emailInput = $("form input[name ='email']");
    private final SelenideElement firstNameInput = $("form input[name ='first_name']");
    private final SelenideElement lastNameInput = $("form input[name ='last_name']");
    private final SelenideElement cardNumberInput = $("form input[name ='card_number']");
    private final SelenideElement dateOgBirthdayInput = $("form input[type ='tel'][placeholder='yyyy-mm-dd']");
    private final SelenideElement parentNameInput = $("form input[name ='parent_name']");
    private final SelenideElement phoneInput = $("form input[name ='phone']");
    private final SelenideElement createButton = $("main button[type='button']");

    public CreateClientPage() {
        headerTitle.shouldBe(Condition.exist);
    }

    @Step("Fill email")
    public CreateClientPage setEmail (String value) {
        setValue(emailInput, value);
        return this;
    }

    @Step("Fill first name")
    public CreateClientPage setFirstName (String value) {
        setValue(firstNameInput, value);
        return this;
    }

    @Step("Fill last name")
    public CreateClientPage setLastName (String value) {
        setValue(lastNameInput, value);
        return this;
    }

    @Step("Fill card number")
    public CreateClientPage setCardNumber (String value) {
        setValue(cardNumberInput, value);
        return this;
    }

    @Step("Fill date of birthday")
    public CreateClientPage setDateOgBirthday (String value) {
        setValue(dateOgBirthdayInput, value);
        return this;
    }

    @Step("Fill parent name")
    public CreateClientPage setParentName (String value) {
        setValue(parentNameInput, value);
        return this;
    }

    @Step("Fill phone")
    public CreateClientPage setPhone (String value) {
        setValue(phoneInput, value);
        return this;
    }

    @Step("Click create button")
    public ClientsPage clickCreateButton() {
        createButton.shouldBe(Condition.enabled).click();
        return new ClientsPage();
    }
}
