import configuration.TestListenerClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ios.DomainsPageIOS;
import pages.ios.MainPageIOS;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

import java.net.MalformedURLException;

/**
 * Created by mrybalkin on 7/25/17.
 */
@Title("Domain Page")
@Description("Set of tests to verify functionality on Domain page")
@Listeners({ TestListenerClass.class })
public class DomainsTest extends BaseTest {
    MainPageIOS mainPage;

    @Test
    @TestCaseId("TC06")
    @Title("Add New Domain")
    public void addNewDomain() throws MalformedURLException {
        DomainsPageIOS domainsPage = getMainPage()
                .switchOnDemandToggle()
                .tapDomainsButton()
                .inputTextIntoField("Test");

        Assert.assertTrue(domainsPage.getSaveButton().isEnabled(), "'Save' button is not enabled");

        mainPage = domainsPage.tapSaveButton();
        Assert.assertTrue(mainPage.getVpnOnTitle().isDisplayed(), "'Main page' is not displayed");
        Assert.assertEquals(mainPage.getCreatedDomainsNumber(), "1 Domains", "Incorrect number of domains is displayed");
    }

    @Test
    @TestCaseId("TC07")
    @Title("Update Existing Domain")
    public void updateExistingDomain() throws MalformedURLException {
        mainPage = getMainPage()
                .switchOnDemandToggle()
                .tapDomainsButton()
                .inputTextIntoField("Test")
                .tapSaveButton()
                .tapDomainsButton()
                .inputTextIntoField( "New ")
                .tapSaveButton();

        Assert.assertEquals(mainPage.getCreatedDomainsNumber(), "2 Domains", "Incorrect number of domains is displayed");
    }

    //failed due to https://github.com/facebook/WebDriverAgent/issues/606
//    @Test
    @TestCaseId("TC08")
    @Title("Delete Existing Domain")
    public void deleteExistingDomain() throws MalformedURLException {

        mainPage = getMainPage()
                .switchOnDemandToggle()
                .tapDomainsButton()
                .inputTextIntoField("Test")
                .tapSaveButton()
                .tapDomainsButton()
                .makeFocusOnInputField()
                .clearInputField()
                .tapSaveButton();

        Assert.assertEquals(mainPage.getCreatedDomainsNumber(), "0 Domains", "Incorrect number of domains is displayed");
    }
}
