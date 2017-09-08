import org.testng.Assert;
import org.testng.annotations.Test;
import pages.android.AndroidMainPage;
import pages.android.IntermediatePageAndroid;
import ru.yandex.qatools.allure.annotations.Title;

import java.net.MalformedURLException;

/**
 * Created by mrybalkin on 9/1/17.
 */
public class AndroidTest extends BaseTest{

    @Test
    @Title("Overview main page")
    public void overviewTest() throws MalformedURLException {
        AndroidMainPage page =  getAndroidMainPage();

        Assert.assertTrue(page.getIntermediateButton().isDisplayed(), "Intermediate button is not displayed");
        Assert.assertTrue(page.getUpperIntermediateButton().isDisplayed(), "Upper Intermediate button is not displayed");
        Assert.assertTrue(page.getChooseLevelTitle().isDisplayed(), "Choose level title is not displayed");
        Assert.assertTrue(page.getEnglishPhrasalVerbsButton().isDisplayed(), "English Phrasal Verbs Button is not displayed");
        Assert.assertTrue(page.getChatWithEnglishLearnersButton().isDisplayed(), "Chat With English Learners Button is not displayed");
    }

    @Test
    @Title("Navigate to Intermediate page")
    public void navigateTest() throws MalformedURLException {
        IntermediatePageAndroid page = getAndroidMainPage().clickIntermediateButton();

        Assert.assertTrue(page.getMixedTestsTab().isDisplayed(), "Incorrect found words number");
    }
}
