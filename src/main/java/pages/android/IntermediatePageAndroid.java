package pages.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by mrybalkin on 9/7/17.
 */
public class IntermediatePageAndroid extends BasePageAndroid {

    @AndroidFindBy(id = "MIXED TESTS ")
    private AndroidElement mixedTestsTab;

    public AndroidElement getMixedTestsTab() {
        return mixedTestsTab;
    }

    public IntermediatePageAndroid(AndroidDriver driver) {
        super(driver);
    }
}
