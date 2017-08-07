import configuration.TestListenerClass;
import pages.ConfigurationPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

import java.net.MalformedURLException;
import java.util.NoSuchElementException;

/**
 * Created by mrybalkin on 7/25/17.
 */
@Title("configuration page")
@Description("Set of tests to verify functionality on configuration page")
@Listeners({ TestListenerClass.class })
public class ConfigurationTest extends BaseTest {
    String description = "Test ";
    String server = "127.0.0.1";
    String account = "Account";

    @Test
    @TestCaseId("TC09")
    @Title("Add new configuration")
    public void addNewConfiguration() throws NoSuchElementException, MalformedURLException {
        configurationPage = mainPage.tapAddNewConfigurationButton();

        Assert.assertFalse(configurationPage.getSaveButton().isEnabled(), "'Save' button is enabled");
        Assert.assertFalse(configurationPage.isButtonEnabled("ikev2"), "'ikev2' button is enabled");

        configurationPage.inputTextIntoField("Description", description);
        configurationPage.inputTextIntoField("Server", server);
        configurationPage.inputTextIntoField("Account", account);

        Assert.assertTrue(configurationPage.getSaveButton().isEnabled(), "'Save' button is disabled");

        mainPage = configurationPage.tapSaveButton();

        Assert.assertTrue(mainPage.getVpnConfigurationHeader().isDisplayed(), "VPN configuration header is not displayed.");
        Assert.assertTrue(mainPage.getNewConfigurationName(1).contains(description), "Incorrect configuration name is displayed");
        Assert.assertTrue(mainPage.getMoreInfoButton().isDisplayed(), "More (i) button is not displayed");
        Assert.assertTrue(mainPage.getRefreshButton().isEnabled(), "refresh button is not enabled");
    }

    @Test
    @TestCaseId("TC10")
    @Title("Update existing configuration")
    public void updateConfiguration() throws NoSuchElementException, MalformedURLException {
        mainPage = populateRequiredData().tapSaveButton();
        configurationPage = mainPage.tapMoreButton();
        configurationPage.selectIkev();
        configurationPage.inputTextIntoField("Description", "1234567890");
        configurationPage.inputTextIntoField("Server", "10.255.255.1");
        configurationPage.inputTextIntoField("Account", "qwerty");
        configurationPage.inputTextIntoField("Password", "password");
        configurationPage.inputTextIntoField("Secret", "secret");
        configurationPage.inputTextIntoField("Group", "Group");
        configurationPage.inputTextIntoField("Remote ID", "13");

        mainPage = configurationPage.tapSaveButton();

        Assert.assertTrue(mainPage.getVpnConfigurationHeader().isDisplayed(), "VPN configuration header is not displayed.");
        Assert.assertTrue(mainPage.getNewConfigurationName(1).contains("1234567890"), "Incorrect configuration name is displayed");
    }

    @Test
    @TestCaseId("TC11")
    @Title("Duplicate existing configuration")
    public void duplicateConfiguration() throws NoSuchElementException, MalformedURLException {
        mainPage = populateRequiredData().tapSaveButton();
        configurationPage = mainPage.tapMoreButton();
        mainPage = configurationPage.tapDuplicateButton();

        Assert.assertTrue(mainPage.getNewConfigurationName(2).contains("Test  1"), "Incorrect configuration name is displayed");
        Assert.assertEquals(mainPage.getNewConfigurationNumber(), 3, "Incorrect configurations number displayed"); //3 - b.c. of app structure. One extra element presents
    }

    @Test
    @TestCaseId("TC12")
    @Title("Cancel deleting existing configuration")
    public void cancelDeletingConfiguration() throws NoSuchElementException, MalformedURLException {
        mainPage = populateRequiredData().tapSaveButton();
        configurationPage = mainPage.tapMoreButton();
        configurationPage.tapDeleteButton().cancelDeleteConfiguration();

        Assert.assertEquals(configurationPage.getConfigurationTitle().getText(), "configuration", "Incorrect title is displayed");
    }

    @Test
    @TestCaseId("TC13")
    @Title("Delete existing configuration")
    public void deleteConfiguration() throws NoSuchElementException, MalformedURLException {
        mainPage = populateRequiredData().tapSaveButton();
        configurationPage = mainPage.tapMoreButton();
        mainPage = configurationPage.tapDeleteButton().confirmDeleteConfiguration();

        Assert.assertEquals(mainPage.getVpnOnTitle().getText(), "VPN On", "Incorrect title is displayed");
    }

    private ConfigurationPage populateRequiredData() throws NoSuchElementException, MalformedURLException {
        configurationPage = mainPage.tapAddNewConfigurationButton();
        configurationPage.inputTextIntoField("Description", description);
        configurationPage.inputTextIntoField("Server", server);
        configurationPage.inputTextIntoField("Account", account);

        return configurationPage;
    }
}
