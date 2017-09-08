import configuration.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.android.AndroidMainPage;
import pages.ios.MainPageIOS;

import java.net.MalformedURLException;

/**
 * Created by mrybalkin on 7/28/17.
 */
public class BaseTest {
    SoftAssert softAssert;

    @BeforeSuite
    public void beforeSuite() throws MalformedURLException {
        Driver.startServer();
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        Driver.getDriver().launchApp();
    }

    @AfterMethod
    public void afterMethod(){
        Driver.getDriver().closeApp();
    }

    @AfterSuite
    public void afterSuite(){
        Driver.stopServer();
    }

    public MainPageIOS getMainPage() throws MalformedURLException {
        return new MainPageIOS(Driver.getDriver());
    }

    public AndroidMainPage getAndroidMainPage(){
        return new AndroidMainPage((AndroidDriver) Driver.getDriver());
    }

}
