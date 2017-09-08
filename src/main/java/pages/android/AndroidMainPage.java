package pages.android;

import configuration.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by mrybalkin on 9/6/17.
 */
public class AndroidMainPage extends BasePageAndroid {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"INTERMEDIATE\"]")
    private AndroidElement intermediateButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"UPPER INTERMEDIATE\"]")
    private AndroidElement upperIntermediateButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"CHOOSE A LEVEL\"]")
    private AndroidElement chooseLevelTitle;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"ENGLISH PHRASAL VERBS \"]")
    private AndroidElement englishPhrasalVerbsButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"CHAT WITH ENGLISH LEARNERS\"]")
    private AndroidElement chatWithEnglishLearnersButton;

    public AndroidMainPage(AndroidDriver driver) {
        super(driver);
    }

    public AndroidElement getIntermediateButton() {
        return intermediateButton;
    }

    public AndroidElement getUpperIntermediateButton() {
        return upperIntermediateButton;
    }

    public AndroidElement getChooseLevelTitle() {
        return chooseLevelTitle;
    }

    public AndroidElement getEnglishPhrasalVerbsButton() {
        return englishPhrasalVerbsButton;
    }

    public AndroidElement getChatWithEnglishLearnersButton() {
        return chatWithEnglishLearnersButton;
    }

    public IntermediatePageAndroid clickIntermediateButton() {
        tap(intermediateButton);

        return (IntermediatePageAndroid) transitionToPage(IntermediatePageAndroid.class);
    }
}
