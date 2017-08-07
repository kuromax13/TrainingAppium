package pages;

import configuration.Driver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by mrybalkin on 7/12/17.
 *
 * Class represents Information page.
 * Contains methods to work with elements on the page
 */
public class InformationPage extends BasePage {

    @iOSFindBy(id = "Acknowledgements")
    private IOSElement acknowledgementsButton;

    @iOSFindBy(id = "Review on App Store")
    private IOSElement reviewOnAppStoreLink;

    @iOSFindBy(id = "1.0")
    private IOSElement versionText;

    public InformationPage(IOSDriver driver) {
        super(driver);
    }

    public IOSElement getAcknowledgementsButton() {
        return acknowledgementsButton;
    }

    public IOSElement getReviewOnAppStoreLink() {
        return reviewOnAppStoreLink;
    }

    public IOSElement getVersionText() {
        return versionText;
    }

    @Step("Tap acknowledgementsButton button and navigate to Acknowledgements page")
    public AcknowledgementsPage tapAcknowledgementsButton(){
        tap(acknowledgementsButton);

        return new AcknowledgementsPage(Driver.getDriver());
    }
}
