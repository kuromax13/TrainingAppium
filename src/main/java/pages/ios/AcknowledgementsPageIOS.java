package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.List;

/**
 * Created by mrybalkin on 7/12/17.
 *
 * Class represents Acknowledgements page.
 * Contains methods to work with elements on the page
 */
public class AcknowledgementsPageIOS extends BasePageIOS {

    @iOSFindBy(id = "Acknowledgements")
    private IOSElement acknowledgementsTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeCell")
    private List<IOSElement> infoBlocks;

    public AcknowledgementsPageIOS(IOSDriver<IOSElement> driver) {
        super(driver);
    }

    public IOSElement getAcknowledgementsTitle() {
        return acknowledgementsTitle;
    }

    public int getNumberOfInfoBlocks(){
        return infoBlocks.size();
    }
}
