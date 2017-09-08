package pages.ios;

import configuration.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by mrybalkin on 7/12/17.
 *
 * Class represents Main page.
 * Contains methods to work with elements on the page
 */
public class MainPageIOS extends BasePageIOS {

    @iOSFindBy(id = "Not Connected")
    private IOSElement notConnectedText;

    @iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Not Connected\"]")
    private IOSElement notConnectedToggle;

    @iOSFindBy(id = "On Demand")
    private IOSElement onDemandText;

    @iOSFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"On Demand\"]")
    private IOSElement onDemandToggle;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Domains relies on VPN \"]")
    private IOSElement domainsText;

    @iOSFindBy(id = "0 Domains")
    private IOSElement defaultDomainsButton;

    @iOSFindBy(id = "Add VPN Configuration...")
    private IOSElement addVpnConfiguration;

    @iOSFindBy(id = "⌥")
    private IOSElement acknowledgementsButton;

    @iOSFindBy(id = "Refresh")
    private IOSElement refreshButton;

    @iOSFindBy(id = "More Info")
    private IOSElement moreInfoButton;

    @iOSFindBy(id = "VPN CONFIGURATIONS")
    private IOSElement vpnConfigurationHeader;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Domains relies on VPN \"]/following::XCUIElementTypeStaticText")
    private IOSElement createdDomainsNumber;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VPN CONFIGURATIONS\"]/following::XCUIElementTypeCell")
    private List<IOSElement> newConfigurationNumber;

    public MainPageIOS(AppiumDriver driver) throws MalformedURLException {
        super(driver);
    }

    public IOSElement getNotConnected() {
        return notConnectedText;
    }

    public IOSElement getOnDemand() {
        return onDemandText;
    }

    public IOSElement getAddVpnConfiguration() {
        return addVpnConfiguration;
    }

    public IOSElement getAcknowledgementsButton() {
        return acknowledgementsButton;
    }

    public IOSElement getRefreshButton() {
        return refreshButton;
    }

    public IOSElement getDefaultDomainsButton() {
        return defaultDomainsButton;
    }

    public IOSElement getVpnConfigurationHeader() {
        return vpnConfigurationHeader;
    }

    public IOSElement getMoreInfoButton() {
        return moreInfoButton;
    }

    @Step("Switch onDemandToggle on")
    public MainPageIOS switchOnDemandToggle() {
        switchToggleOn(onDemandToggle);

        return this;
    }

    @Step("Tap acknowledgementsButton")
    public InformationPageIOS tapInformationPage() {
        tap(acknowledgementsButton);

        return (InformationPageIOS) transitionToPage(InformationPageIOS.class);
    }

    @Step("Tap addVpnConfiguration and navigate to ConfigurationPageIOS")
    public ConfigurationPageIOS tapAddNewConfigurationButton() {
        tap(addVpnConfiguration);

        return (ConfigurationPageIOS) transitionToPage(ConfigurationPageIOS.class);
    }

    @Step("Tap domainsText and navigate to DomainsPageIOS")
    public DomainsPageIOS tapDomainsButton(){
        tap(domainsText);
        return (DomainsPageIOS) transitionToPage(DomainsPageIOS.class);
    }

    @Step("Get number of created domains")
    public String getCreatedDomainsNumber() {
        return createdDomainsNumber.getText();
    }

    @Step("Get created configuration name number {0}")
    public String getNewConfigurationName(int configurationNumber) {
        return Driver.getDriver().findElement(By.xpath(newConfigurationNameXpath(configurationNumber))).getText();
    }

    @Step("Tap moreInfoButton and navigate to ConfigurationPageIOS")
    public ConfigurationPageIOS tapMoreButton() {
        tap(moreInfoButton);
        return (ConfigurationPageIOS) transitionToPage(ConfigurationPageIOS.class);
    }

    @Step("Get number of created configurations")
    public int getNewConfigurationNumber() {
        return newConfigurationNumber.size();
    }

   private String newConfigurationNameXpath(int configurationNumber){
        return "//XCUIElementTypeStaticText[@name=\"VPN CONFIGURATIONS\"]" +
                "/following::XCUIElementTypeCell[" + configurationNumber + "]/XCUIElementTypeStaticText";
    }
}
