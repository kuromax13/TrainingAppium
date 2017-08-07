package pages;

import configuration.Driver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by mrybalkin on 6/15/17.
 *
 * Class represents Base page.
 * Contains methods to work with elements on the page.
 * Contains common element for several pages
 */
public class BasePage {
    private final IOSDriver<IOSElement> driver;
    private static final Logger log = LogManager.getLogger(BasePage.class);

    @FindBy(id = "VPN On")
    private IOSElement vpnOnTitle;

    @FindBy(id = "Back")
    private IOSElement backButton;

    public BasePage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        log.info("Navigating to [{}]...", new Object[]{this.getClass().getSimpleName()});
    }

    @Step("Get vpnOnTitle element")
    public IOSElement getVpnOnTitle() {
        return vpnOnTitle;
    }

    @Step("Get backButton element")
    public IOSElement getBackButton() {
        return backButton;
    }

    public void tap(IOSElement element){
        new TouchAction((MobileDriver) Driver.getDriver()).tap(element).perform();
    }

    public void switchToggleOn(IOSElement element){
        Point point = element.getLocation();

        //toggle on
        new TouchAction((MobileDriver) Driver.getDriver()).tap(point.x + 20, point.y + 30).perform();
    }

    public void switchToggleOff(IOSElement element){
        Point point = element.getLocation();

        //toggle off
        new TouchAction((MobileDriver) Driver.getDriver()).tap(point.x + 100, point.y + 30).perform();
    }

    @Step("Enter \"{1}\" text")
    public void inputText(WebElement inputField, String inputText){
        inputField.sendKeys(inputText);
    }
}
