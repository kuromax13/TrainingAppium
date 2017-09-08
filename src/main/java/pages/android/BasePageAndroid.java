package pages.android;

import configuration.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by mrybalkin on 9/6/17.
 */
public class BasePageAndroid {
    private static final Logger log = LogManager.getLogger(BasePageAndroid.class);

    public BasePageAndroid(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        log.info("Navigating to [{}]...", new Object[]{this.getClass().getSimpleName()});
    }

    public BasePageAndroid transitionToPage(Class<? extends BasePageAndroid> pageClass) {
        Constructor cons = null;
        BasePageAndroid page = null;

        try {
            cons = pageClass.getConstructor(Driver.getDriver().getClass());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            page = (BasePageAndroid) cons.newInstance(Driver.getDriver());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return page;
    }

    public void tap(AndroidElement element){
        new TouchAction((MobileDriver) Driver.getDriver()).tap(element).perform();
    }
}
