import configuration.Driver;
import pages.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;

/**
 * Created by mrybalkin on 7/28/17.
 */
public class BaseTest {
    DomainsPage domainsPage;
    MainPage mainPage;
    ConfigurationPage configurationPage;
    SoftAssert softAssert;
    InformationPage informationPage;
    AcknowledgementsPage acknowledgementsPage;

    @BeforeSuite
    public void beforeSuite() throws MalformedURLException {
        Driver.startServer();
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        mainPage = new MainPage(Driver.getDriver());
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
}
