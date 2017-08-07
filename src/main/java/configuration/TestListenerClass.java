package configuration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * Created by mrybalkin on 7/31/17.
 */
public class TestListenerClass  extends TestListenerAdapter {


    @Attachment(type = "image/png")
    public byte[] captureScreenshot() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        captureScreenshot();
    }
}
