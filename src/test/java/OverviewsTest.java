import configuration.TestListenerClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;

import java.net.MalformedURLException;

/**
 * Created by mrybalkin on 6/27/17.
 */
@Title("Overview")
@Description("Set of tests to verify pages contains correct elements")
@Listeners({ TestListenerClass.class })
public class OverviewsTest extends BaseTest {

    @Test
    @TestCaseId("TC01")
    @Title("Main page overview")
    public void mainPageOverview() throws MalformedURLException {
        softAssert.assertTrue(mainPage.getVpnOnTitle().isDisplayed(), "'VPN On' title is not displayed");
        softAssert.assertTrue(mainPage.getRefreshButton().isDisplayed(), "Refresh button is not displayed");
        softAssert.assertTrue(mainPage.getRefreshButton().isDisplayed(), "Refresh button is not disabled");
        softAssert.assertTrue(mainPage.getAcknowledgementsButton().isDisplayed(), "Acknowledgements button is not displayed");
        softAssert.assertTrue(mainPage.getNotConnected().isDisplayed(), "Not connect is not displayed");
        softAssert.assertTrue(mainPage.getOnDemand().isDisplayed(), "On Demand is not displayed");
        softAssert.assertTrue(mainPage.getAddVpnConfiguration().isDisplayed(), "Add VPN Connection is not displayed");

        softAssert.assertAll();
    }

    @Test
    @TestCaseId("TC02")
    @Title("Information page overview")
    public void informationPageOverview() throws MalformedURLException {
        informationPage = mainPage.tapInformationPage();

        softAssert.assertTrue(informationPage.getVpnOnTitle().isDisplayed(), "Title is not displayed");
        softAssert.assertEquals(informationPage.getVpnOnTitle().getText(), "VPN On", "Title text is not correct");
        softAssert.assertTrue(informationPage.getBackButton().isDisplayed(), "Title text is not correct");
        softAssert.assertTrue(informationPage.getAcknowledgementsButton().isDisplayed(), "Acknowledgements is not displayed");
        softAssert.assertEquals(informationPage.getAcknowledgementsButton().getText(), "Acknowledgements", "Acknowledgements button text is not correct");
        softAssert.assertTrue(informationPage.getReviewOnAppStoreLink().isDisplayed(), "'Reviews on App Store' link is not displayed");
        softAssert.assertEquals(informationPage.getVersionText().getText(), "1.0", "Acknowledgements button text is not correct");

        softAssert.assertAll();
    }

    @Test
    @TestCaseId("TC03")
    @Title("Acknowledgments page overview")
    public void acknowledgmentsPageOverview() throws MalformedURLException {
        acknowledgementsPage = mainPage.tapInformationPage().tapAcknowledgementsButton();

        softAssert.assertTrue(acknowledgementsPage.getAcknowledgementsTitle().isDisplayed(), "Acknowledgements title is not displayed");
        softAssert.assertEquals(acknowledgementsPage.getAcknowledgementsTitle().getText(), "Acknowledgements", "Acknowledgements text is not correct");
        softAssert.assertTrue(acknowledgementsPage.getBackButton().isDisplayed(), "Acknowledgements text is not correct");
        softAssert.assertEquals(acknowledgementsPage.getNumberOfInfoBlocks(), 4, "Info blocks number is not correct");

        softAssert.assertAll();
    }

    @Test
    @TestCaseId("TC04")
    @Title("Domains page overview")
    public void domainsPageOverview() throws MalformedURLException {
        mainPage.switchOnDemandToggle();

        softAssert.assertTrue(mainPage.getOnDemand().isDisplayed(), "'Add new configuration' button is not displayed");
        softAssert.assertEquals(mainPage.getDefaultDomainsButton().getText(), "0 Domains");

        domainsPage = mainPage.tapDomainsButton();

        softAssert.assertTrue(domainsPage.getBackButton().isDisplayed(), "Back button is not displayed");
        softAssert.assertTrue(domainsPage.getVpnOnTitle().isDisplayed(), "Title is not displayed");
        softAssert.assertTrue(domainsPage.getSaveButton().isDisplayed(), "Save button is not displayed");
        softAssert.assertTrue(domainsPage.getSaveButton().isEnabled(), "Save button is not enabled");
        softAssert.assertTrue(domainsPage.getInputFieldTitle().isDisplayed(), "Input field title is not displayed");
        softAssert.assertTrue(domainsPage.getInputField().isDisplayed(), "Input field is not enabled");

        softAssert.assertAll();
    }

    @Test
    @TestCaseId("TC05")
    @Title("configuration page overview")
    public void configurationPageOverview() throws MalformedURLException {
        configurationPage = mainPage.tapAddNewConfigurationButton();

        softAssert.assertTrue(configurationPage.getBackButton().isDisplayed(), "Back button is not displayed");
        softAssert.assertTrue(configurationPage.getConfigurationTitle().isDisplayed(), "configuration title is not displayed");
        softAssert.assertTrue(configurationPage.getSaveButton().isDisplayed(), "'Save' button is not displayed");
        softAssert.assertFalse(configurationPage.getSaveButton().isEnabled(), "'Save' button is enabled");
        softAssert.assertTrue(configurationPage.getCiscoButton().isDisplayed(), "'Cisco' button is not displayed");
        softAssert.assertTrue(configurationPage.isButtonEnabled("cisco"), "'Cisco' button is enabled");
        softAssert.assertTrue(configurationPage.getIkeButton().isDisplayed(), "'IKEv2' button is not displayed");
        softAssert.assertFalse(configurationPage.isButtonEnabled("ikev2"), "'IKEv2' button is enabled");
        softAssert.assertTrue(configurationPage.getDescription().isDisplayed(), "Description Input Field is not displayed");
        softAssert.assertTrue(configurationPage.getServer().isDisplayed(), "Server Input Field is not displayed");
        softAssert.assertTrue(configurationPage.getAccount().isDisplayed(), "Account Input Field is not displayed");
        softAssert.assertTrue(configurationPage.getPassword().isDisplayed(), "Password Input Field is not displayed");
        softAssert.assertTrue(configurationPage.getSecret().isDisplayed(), "Secret Input Field is not displayed");
        softAssert.assertTrue(configurationPage.getGroup().isDisplayed(), "Group Input Field is not displayed");
        softAssert.assertTrue(configurationPage.getRemoteId().isDisplayed(), "Remote ID Input Field is not displayed");
        softAssert.assertTrue(configurationPage.getAlwaysOnToggle().isDisplayed(), "'Always On' toggle is not displayed");
        softAssert.assertTrue(configurationPage.isButtonEnabled("always on"), "'Always On' toggle is not enabled");

        softAssert.assertAll();
    }
}
