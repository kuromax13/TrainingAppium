package pages.ios;

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
public class InformationPageIOS extends BasePageIOS {

    @iOSFindBy(id = "Acknowledgements")
    private IOSElement acknowledgementsButton;

    @iOSFindBy(id = "Review on App Store")
    private IOSElement reviewOnAppStoreLink;

    @iOSFindBy(id = "1.0")
    private IOSElement versionText;

    public InformationPageIOS(IOSDriver driver) {
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
    public AcknowledgementsPageIOS tapAcknowledgementsButton(){
        tap(acknowledgementsButton);

        return (AcknowledgementsPageIOS) transitionToPage(AcknowledgementsPageIOS.class);
    }
}
