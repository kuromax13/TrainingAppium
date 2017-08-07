package pages;

import configuration.Driver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.net.MalformedURLException;

/**
 * Created by mrybalkin on 7/12/17.
 *
 * Class represents Domains page.
 * Contains methods to work with elements on the page
 */
public class DomainsPage extends BasePage {

    @iOSFindBy(id = "Save")
    private IOSElement saveButton;

    @iOSFindBy(id = "DOMAINS RELIES ON VPN")
    private IOSElement inputFieldTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeTextView")
    private IOSElement inputField;

    public DomainsPage(IOSDriver driver) {
        super(driver);
    }

    public IOSElement getSaveButton() {
        return saveButton;
    }

    public IOSElement getInputFieldTitle() {
        return inputFieldTitle;
    }

    public IOSElement getInputField() {
        return inputField;
    }

    @Step("Tap saveButton button")
    public MainPage tapSaveButton() throws MalformedURLException {
        tap(saveButton);

        return new MainPage(Driver.getDriver());
    }

    @Step("Clear inputField")
    public void clearInputField() {
        inputField.clear();
    }
}
