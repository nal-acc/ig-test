package igym;


import com.codeborne.selenide.WebDriverRunner;
import igym.pages.AdminUserPage;
import igym.pages.CreateGroupStylesPage;
import igym.pages.GroupStylesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupStylesTest  extends BaseTest {

    @Test
    public void createGroupStyle() {
        AdminUserPage adminUserPage = loginAsAdmin();
        GroupStylesPage groupStylesPage = adminUserPage.clickGroupStylesMenuItem();
        CreateGroupStylesPage createGroupStylesPage = groupStylesPage.clickCreateButton();
        String styleName = "Classic gymnastics";
        createGroupStylesPage.setTitle(styleName).clickCreateButton();

        sleep(1000);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String[] urlParts = currentUrl.split("/");
        Assert.assertEquals(urlParts[urlParts.length -1], groupStylesPage.relativeUrlPath);
        Assert.assertEquals(groupStylesPage.getTitleColumnText(), styleName);
    }
}
