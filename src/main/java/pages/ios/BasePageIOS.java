package pages.ios;

import configuration.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by mrybalkin on 6/15/17.
 *
 * Class represents Base page.
 * Contains methods to work with elements on the page.
 * Contains common element for several pages
 */
public class BasePageIOS {
    private static final Logger log = LogManager.getLogger(BasePageIOS.class);

    @iOSFindBy(id = "VPN On")
    private IOSElement vpnOnTitle;

    @iOSFindBy(id = "Back")
    private IOSElement backButton;

    public BasePageIOS(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        log.info("Navigating to [{}]...", new Object[]{this.getClass().getSimpleName()});
    }

    public IOSElement getVpnOnTitle() {
        return vpnOnTitle;
    }

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
    public BasePageIOS inputText(IOSElement inputField, String inputText){
        inputField.sendKeys(inputText);

        return this;
    }

    public BasePageIOS transitionToPage(Class<? extends BasePageIOS> pageClass) {
        Constructor cons = null;
        BasePageIOS page = null;

        try {
            cons = pageClass.getConstructor(Driver.getDriver().getClass());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            page = (BasePageIOS) cons.newInstance(Driver.getDriver());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return page;
    }
}
