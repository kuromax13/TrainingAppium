package pages;

import configuration.Driver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.net.MalformedURLException;

/**
 * Created by mrybalkin on 7/12/17.
 *
 * Class represents Main page.
 * Contains methods to work with elements on the page
 */
public class MainPage extends BasePage {

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

    @iOSFindBy(id = "Add VPN configuration...")
    private IOSElement addVpnConfiguration;

    @iOSFindBy(id = "⌥")
    private IOSElement acknowledgementsButton;

    @iOSFindBy(id = "Refresh")
    private IOSElement refreshButton;

    @iOSFindBy(id = "More Info")
    private IOSElement moreInfoButton;

    @iOSFindBy(id = "VPN CONFIGURATIONS")
    private IOSElement vpnConfigurationHeader;

    public MainPage(IOSDriver<IOSElement> driver) throws MalformedURLException {
        super(driver);
    }

    @Step("Get notConnectedText element")
    public IOSElement getNotConnected() {
        return notConnectedText;
    }

    @Step("Get onDemandText element")
    public IOSElement getOnDemand() {
        return onDemandText;
    }

    @Step("Get addVpnConfiguration element")
    public IOSElement getAddVpnConfiguration() {
        return addVpnConfiguration;
    }

    @Step("Get acknowledgementsButton element")
    public IOSElement getAcknowledgementsButton() {
        return acknowledgementsButton;
    }

    @Step("Get refreshButton element")
    public IOSElement getRefreshButton() {
        return refreshButton;
    }

    @Step("Get defaultDomainsButton element")
    public IOSElement getDefaultDomainsButton() {
        return defaultDomainsButton;
    }

    @Step("Get vpnConfigurationHeader element")
    public IOSElement getVpnConfigurationHeader() {
        return vpnConfigurationHeader;
    }

    @Step("Get moreInfoButton element")
    public IOSElement getMoreInfoButton() {
        return moreInfoButton;
    }

    @Step("Switch onDemandToggle on")
    public MainPage switchOnDemandToggle() {
        switchToggleOn(onDemandToggle);

        return this;
    }

    @Step("Tap acknowledgementsButton")
    public InformationPage tapInformationPage() {
        tap(acknowledgementsButton);

        return new InformationPage(Driver.getDriver());
    }

    @Step("Tap addVpnConfiguration and navigate to ConfigurationPage")
    public ConfigurationPage tapAddNewConfigurationButton(){
        tap(addVpnConfiguration);

        return new ConfigurationPage(Driver.getDriver());
    }

    @Step("Tap domainsText and navigate to DomainsPage")
    public DomainsPage tapDomainsButton(){
        tap(domainsText);
        return new DomainsPage(Driver.getDriver());
    }

    @Step("Get number of created domains")
    public String getCreatedDomainsNumber() {
        return Driver.getDriver().findElement((By.xpath("//XCUIElementTypeStaticText[@name=\"Domains relies on VPN \"]/following::XCUIElementTypeStaticText"))).getText();
    }

    @Step("Get created configuration name number {0}")
    public String getNewConfigurationName(int configurationNumber) {
        String xpath = "//XCUIElementTypeStaticText[@name=\"VPN CONFIGURATIONS\"]" +
                "/following::XCUIElementTypeCell[" + configurationNumber + "]/XCUIElementTypeStaticText";
        return Driver.getDriver().findElement(By.xpath(xpath)).getText();
    }

    @Step("Tap moreInfoButton and navigate to ConfigurationPage")
    public ConfigurationPage tapMoreButton() {
        tap(moreInfoButton);
        return new ConfigurationPage(Driver.getDriver());
    }

    @Step("Get number of created configurations")
    public int getNewConfigurationNumber() {
        return Driver.getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"VPN CONFIGURATIONS\"]/following::XCUIElementTypeCell")).size();
    }
}
