package igym.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ClientsPage {
    public final String relativeUrlPath = "clients";
    private final SelenideElement headerTitle = $x("//*[@id='app']/div/header/div/h1[contains(text(), 'Clients')]");
    private final SelenideElement cardNumberColumn = $("table tbody tr td:nth-child(3)");
    private final SelenideElement firstNameColumn = $("table tbody tr td:nth-child(4)");
    private final SelenideElement lastNameColumn = $("table tbody tr td:nth-child(5)");
    private final SelenideElement emilColumn = $("table tbody tr td:nth-child(6)");
    private final SelenideElement phoneColumn = $("table tbody tr td:nth-child(7)");
    private final SelenideElement dateOfBirthdayColumn = $("table tbody tr td:nth-child(9)");
    private final SelenideElement createButton = $("main button[type='button']");

    public ClientsPage() {
        headerTitle.shouldBe(Condition.exist);
    }

    @Step("Get card number column text")
    public String getCardNumberColumnText() {
        return cardNumberColumn.text();
    }

    @Step("Get first name column text")
    public String getFirstNameColumnText() {
        return firstNameColumn.text();
    }

    @Step("Get last name column text")
    public String getLastNameColumnText() {
        return lastNameColumn.text();
    }

    @Step("Get email column text")
    public String geEmailColumnText() {
        return emilColumn.text();
    }

    @Step("Get phone column text")
        public String gePhoneColumnText() {
        return phoneColumn.text();
    }

    @Step("Get date of birthday column text")
    public String getDateOfBirthdayColumnText() {
        return dateOfBirthdayColumn.text();
    }

    @Step("Click create button")
    public CreateClientPage clickCreateButton() {
        createButton.shouldBe(Condition.enabled).click();
        return new CreateClientPage();
    }
}
