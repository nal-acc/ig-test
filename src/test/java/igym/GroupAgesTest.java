package igym;

import com.codeborne.selenide.WebDriverRunner;
import igym.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupAgesTest extends BaseTest {
    @Test
    public void createGroupStyle() {
        AdminUserPage adminUserPage = loginAsAdmin();
        GroupAgesPage groupAgesPage = adminUserPage.clickGroupAgesMenuItem();
        CreateGroupAgesPage createGroupAgesPage = groupAgesPage.clickCreateButton();
        String ageValue = "3-6m";
        String ageFrom = "3";
        String ageTo = "6";
        createGroupAgesPage
                .setTitle(ageValue)
                .setAgeFrom(ageFrom)
                .setAgeTo(ageTo)
                .setAgeFromMinus("0")
                .setAgeToPlus("0")
                .clickCreateButton();

        sleep(1000);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String[] urlParts = currentUrl.split("/");
        Assert.assertEquals(urlParts[urlParts.length -1], groupAgesPage.relativeUrlPath);
        Assert.assertEquals(groupAgesPage.getTitleColumnText(), ageValue);
        Assert.assertEquals(groupAgesPage.getAgeFromColumnText(), ageFrom);
        Assert.assertEquals(groupAgesPage.getAgeToColumnText(), ageTo);
        Assert.assertEquals(groupAgesPage.gePlusMinusColumnText(), "0/0");

    }
}
