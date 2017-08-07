package configuration;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mrybalkin on 7/21/17.
 *
 * Class contains desired capabilities, creates driver.
 */
public class Driver {
    private static IOSDriver<IOSElement> driver;
    private static final Logger log = LogManager.getLogger(BasePage.class);
    private static DriverConfiguration config = new DriverConfiguration();
    private static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();


    public static IOSDriver<IOSElement> getDriver(){
        if (driver == null){
            try {
                driver = new IOSDriver<IOSElement>(new URL(config.getUrl()), getDesiredCapabilities());
                log.info("[Driver] Creating new instance of driver");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static DesiredCapabilities getDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        File file = new File(config.getAppPath());
        File filePath = new File(file, config.getAppName());

        capabilities.setCapability("udid", config.getUdid());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getDeviceName());
        capabilities.setCapability(MobileCapabilityType.APP, filePath.getAbsoluteFile());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, config.getPlatformName());
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability("sendKeyStrategy", "setValue");

        //only for iOS 10.2+
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

        return capabilities;
    }

    public static void startServer() {
        if (!service.isRunning()){
            service.start();
        } else {
            log.info("[Driver] Appium server is already started");
        }
    }

    public static void stopServer() {
        if (service.isRunning()){
            String kill[] = {"killall","Simulator"};
            try {
                Runtime.getRuntime().exec(kill);
            } catch (IOException e) {
                e.printStackTrace();
            }
            service.stop();
        } else {
            log.info("[Driver] Appium server is already stoped");
        }
    }
}
