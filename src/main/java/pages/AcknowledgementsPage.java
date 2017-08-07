package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by mrybalkin on 7/12/17.
 *
 * Class represents Acknowledgements page.
 * Contains methods to work with elements on the page
 */
public class AcknowledgementsPage extends BasePage {

    @iOSFindBy(id = "Acknowledgements")
    private IOSElement acknowledgementsTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeCell")
    private List<IOSElement> infoBlocks;

    public AcknowledgementsPage(IOSDriver<IOSElement> driver) {
        super(driver);
    }

    @Step("Get acknowledgementsTitle element")
    public IOSElement getAcknowledgementsTitle() {
        return acknowledgementsTitle;
    }

    @Step("Get number of information blocks")
    public int getNumberOfInfoBlocks(){
        return infoBlocks.size();
    }
}
