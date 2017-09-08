package pages.ios;

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
public class DomainsPageIOS extends BasePageIOS {

    @iOSFindBy(id = "Save")
    private IOSElement saveButton;

    @iOSFindBy(id = "DOMAINS RELIES ON VPN")
    private IOSElement inputFieldTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeTextView")
    private IOSElement inputField;

    public DomainsPageIOS(IOSDriver driver) {
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
    public MainPageIOS tapSaveButton() throws MalformedURLException {
        tap(saveButton);

        return new MainPageIOS(Driver.getDriver());
    }

    @Step("Clear inputField")
    public DomainsPageIOS clearInputField() {
        inputField.clear();

        return this;
    }

    @Step("Tap to make focus on input field")
    public DomainsPageIOS makeFocusOnInputField(){
        tap(inputField);

        return this;
    }

    @Step("Fill in input text with {0}")
    public DomainsPageIOS inputTextIntoField(String text){
        inputText(inputField, text);

        return this;
    }
}
