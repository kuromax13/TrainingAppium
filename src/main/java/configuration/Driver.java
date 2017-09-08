package configuration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.ios.BasePageIOS;

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
    private static AppiumDriver driver;
    private static final Logger log = LogManager.getLogger(BasePageIOS.class);
    private static DriverConfiguration config = new DriverConfiguration();
    private static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    public static AppiumDriver getDriver(){
        if (driver == null){
            if (config.getPlatformName().equals("iOS")) {
                try {
                    driver = new IOSDriver<IOSElement>(new URL(config.getUrl()), getDesiredCapabilities());
                    log.info("[Driver] Creating new instance of driver");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    driver = new AndroidDriver<AndroidElement>(new URL(config.getUrl()), getDesiredCapabilities());
                    log.info("[Driver] Creating new instance of driver");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        return driver;
    }

    public static DesiredCapabilities getDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        File file = new File(config.getAppPath());
        File filePath = new File(file, config.getAppName());

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getDeviceName());
        capabilities.setCapability(MobileCapabilityType.APP, filePath.getAbsoluteFile());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, config.getPlatformName());
        capabilities.setCapability("fullReset","false");
        capabilities.setCapability("sendKeyStrategy", "setValue");

        if (config.getPlatformName().equals("iOS")){
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability("udid", config.getUdid());

        } else {
            capabilities.setCapability("appPackage",config.getAppPackage());
            capabilities.setCapability("appActivity", config.getAppActivity());
            capabilities.setCapability("device", "Android");
            capabilities.setCapability("avd", config.getDeviceName());
        }

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
