package igym.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AdminUserPage {
    public final String relativeUrlPath = "admin-users";
    private final SelenideElement title = $x("//*[@id='app']/div/header/div/h1[contains(text(), 'Admin Users')]");
    private final SelenideElement groupStylesMenuItem = $(By.linkText("Group Styles"));
    private final SelenideElement groupAgesMenuItem = $(By.linkText("Group Ages"));
    private final SelenideElement clientsMenuItem = $(By.linkText("Clients"));

    public AdminUserPage() {
        title.shouldBe(Condition.exist);
    }

    @Step("Click Group styles menu")
    public GroupStylesPage clickGroupStylesMenuItem() {
        groupStylesMenuItem.click();
        return new GroupStylesPage();
    }

    @Step("Click Group Ages menu")
    public GroupAgesPage clickGroupAgesMenuItem() {
        groupAgesMenuItem.click();
        return new GroupAgesPage();
    }

    @Step("Click Clients menu")
    public ClientsPage clickClientsMenuItem() {
        clientsMenuItem.click();
        return new ClientsPage();
    }
}
