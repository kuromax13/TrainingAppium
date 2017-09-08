package configuration;

import com.google.common.io.Closeables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import pages.ios.BasePageIOS;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by mrybalkin on 8/1/17.
 *
 * Class to read properties from property file
 */
public class DriverConfiguration {
    private static Properties p = new Properties();
    private static final Logger log = LogManager.getLogger(BasePageIOS.class);

    public DriverConfiguration() {
        ClassPathResource resource = new ClassPathResource("app.properties");
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            p.load( inputStream );
        } catch ( IOException e ) {
            log.error( e.getMessage(), e );
        } finally {
            Closeables.closeQuietly(inputStream);
        }
    }

    public String getUdid() {
        return p.getProperty("udid");
    }

    public String getDeviceName() {
        return p.getProperty("deviceName");
    }

    public String getPlatformName() {
        return p.getProperty("platformName");
    }

    public String getAppName() {
        return p.getProperty("appName");
    }

    public String getAppPath() {
        return p.getProperty("appPath");
    }

    public String getUrl() {
        return p.getProperty("generalUrl");
    }

    public String getAppPackage() {
        return p.getProperty("appPackage");
    }

    public String getAppActivity() {
        return p.getProperty("appActivity");
    }
}
