package igym;


import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import igym.pages.AdminUserPage;
import igym.pages.ClientsPage;
import igym.pages.CreateClientPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientsTest extends BaseTest {

    @Test
    public void createClient() {
        AdminUserPage adminUserPage = loginAsAdmin();
        ClientsPage clientsPage = adminUserPage.clickClientsMenuItem();
        CreateClientPage createClientPage = clientsPage.clickCreateButton();

        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String cardNumber = faker.number().digits(10);
        String birthday = "2018-01-01";
        String parentName = faker.name().firstName();
        String phone = "37012312345";

        createClientPage
                .setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setParentName(parentName)
                .setPhone(phone)
                .setCardNumber(cardNumber)
                .setDateOgBirthday(birthday)
                .clickCreateButton();

        sleep(1000);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String[] urlParts = currentUrl.split("/");
        Assert.assertEquals(urlParts[urlParts.length -1], clientsPage.relativeUrlPath);
        Assert.assertEquals(clientsPage.getCardNumberColumnText(), cardNumber);
        Assert.assertEquals(clientsPage.getFirstNameColumnText(), firstName);
        Assert.assertEquals(clientsPage.getLastNameColumnText(), lastName);
        Assert.assertEquals(clientsPage.geEmailColumnText(), email);
        Assert.assertTrue(clientsPage.getDateOfBirthdayColumnText().contains(birthday));
        Assert.assertTrue(clientsPage.getPhoneColumnText().contains(phone));
    }
}
