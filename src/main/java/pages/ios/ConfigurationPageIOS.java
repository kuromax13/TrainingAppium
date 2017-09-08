package pages.ios;

import configuration.Driver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.net.MalformedURLException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by mrybalkin on 7/12/17.
 *
 * Class represents configuration page.
 * Contains methods to work with elements on the page
 */
public class ConfigurationPageIOS extends BasePageIOS {

    @iOSFindBy(id = "Configuration")
    private IOSElement configurationTitle;

    @iOSFindBy(id = "Save")
    private IOSElement saveButton;

    @iOSFindBy(id = "Cisco IPSec")
    private IOSElement ciscoButton;

    @iOSFindBy(id = "IKEv2")
    private IOSElement ikeButton;

    @iOSFindBy(id = "Description")
    private IOSElement description;

    @iOSFindBy(id = "Server")
    private IOSElement server;

    @iOSFindBy(id = "Account")
    private IOSElement account;

    @iOSFindBy(id = "Password")
    private IOSElement password;

    @iOSFindBy(id = "Secret")
    private IOSElement secret;

    @iOSFindBy(id = "Group")
    private IOSElement group;

    @iOSFindBy(id = "Remote ID")
    private IOSElement remoteId;

    @iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Always On\"]")
    private IOSElement alwaysOnToggle;

    @iOSFindBy(id = "Duplicate")
    private IOSElement duplicateButton;

    @iOSFindBy(id = "Delete VPN")
    private IOSElement deleteVpnButton;

    @iOSFindBy(xpath = "//XCUIElementTypeTextField")
    private List<IOSElement> inputFields;

    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField")
    private List<IOSElement> inputSecretFields;

    @iOSFindBy(id = "Delete")
    private IOSElement confirmDeleteButton;

    @iOSFindBy(id = "Cancel")
    private IOSElement cancelDeleteButton;

    public ConfigurationPageIOS(IOSDriver driver) {
        super(driver);
    }

    public IOSElement getConfigurationTitle() {
        return configurationTitle;
    }

    public IOSElement getSaveButton() {
        return saveButton;
    }

    public IOSElement getCiscoButton() {
        return ciscoButton;
    }

    public IOSElement getIkeButton() {
        return ikeButton;
    }

    public IOSElement getDescription() {
        return description;
    }

    public IOSElement getServer() {
        return server;
    }

    public IOSElement getAccount() {
        return account;
    }

    public IOSElement getPassword() {
        return password;
    }

    public IOSElement getSecret() {
        return secret;
    }

    public IOSElement getGroup() {
        return group;
    }

    public IOSElement getRemoteId() {
        return remoteId;
    }

    public IOSElement getAlwaysOnToggle() {
        return alwaysOnToggle;
    }

    public IOSElement getDuplicateButton() {
        return duplicateButton;
    }

    public IOSElement getDeleteVpnButton() {
        return deleteVpnButton;
    }

    @Step("Get enable state of \"{0}\" button" )
    public boolean isButtonEnabled(String buttonName) {
        if (buttonName.equals("cisco")){
            try {
                return ciscoButton.getAttribute("value").equals("true");
            } catch (NullPointerException ex){
                return false;
            }
        } else if (buttonName.equals("ikev2")){
            try {
                return ikeButton.getAttribute("value").equals("true");
            } catch (NullPointerException ex){
                return false;
            }
        } else if(buttonName.equals("always on")){
            try {
                return alwaysOnToggle.getAttribute("value").equals("true");
            } catch (NullPointerException ex){
                return false;
            }
        }
        return false;
    }

    @Step("Tap saveButton button")
    public MainPageIOS tapSaveButton() throws MalformedURLException {
        tap(saveButton);

        return (MainPageIOS) transitionToPage(MainPageIOS.class);
    }

    @Step("Enter \"{1}\" into \"{0}\" input field")
    public ConfigurationPageIOS inputTextIntoField(String inputField, String inputText) throws NoSuchElementException {
        if (inputField.equals("Description")){
            inputFields.get(0).clear();
            inputFields.get(0).sendKeys(inputText);
        } else if (inputField.equals("Server")){
            inputFields.get(1).clear();
            inputFields.get(1).sendKeys(inputText);
        } else if (inputField.equals("Account")){
            inputFields.get(2).clear();
            inputFields.get(2).sendKeys(inputText);
        } else if (inputField.equals("Password")){
            inputSecretFields.get(0).clear();
            inputSecretFields.get(0).sendKeys(inputText);
        } else if (inputField.equals("Secret")){
            inputSecretFields.get(1).clear();
            inputSecretFields.get(1).sendKeys(inputText);
        } else if (inputField.equals("Group")){
            inputFields.get(3).clear();
            inputFields.get(3).sendKeys(inputText);
        } else if (inputField.equals("Remote ID")){
            inputFields.get(4).clear();
            inputFields.get(4).sendKeys(inputText);
        } else {
            throw new NoSuchElementException("Unknown input field");
        }
        return this;
    }

    @Step("Tap ikeButton button")
    public ConfigurationPageIOS selectIkev() {
        tap(ikeButton);
        return this;
    }

    @Step("Tap duplicateButton button and navigate to Main page")
    public MainPageIOS tapDuplicateButton() throws MalformedURLException {
        tap(duplicateButton);
        return (MainPageIOS) transitionToPage(MainPageIOS.class);
    }

    @Step("Tap deleteVpnButton button")
    public ConfigurationPageIOS tapDeleteButton() {
        tap(deleteVpnButton);
        return this;
    }

    @Step("Tap confirmDeleteButton button, wait confirmation pop-up disappears and navigate to Main Page")
    public MainPageIOS confirmDeleteConfiguration() throws MalformedURLException {
        tap(confirmDeleteButton);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.invisibilityOf(deleteVpnButton));
        return (MainPageIOS) transitionToPage(MainPageIOS.class);
    }

    @Step("Tap cancelDeleteButton button")
    public ConfigurationPageIOS cancelDeleteConfiguration() {
        tap(cancelDeleteButton);

        return this;
    }
}
