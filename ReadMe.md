### About
TrainingAppium Project is Java based project for testing iOs native application "VPN On".
Framework based on: Java, Appium, TestNG, Maven, Allure

### Structure
Current training framework consist of several main packages:
1. "configuration" - contains configuration classes such as test listener, driver configuration etc. (details is in "Driver" section)
2. "pages" - contains java classes with page objects
3. "resources" - contains application under test, allure properties, file with desired capabilities
4. "test" - contains tests

### Maven
Project has dependencies on third-party applications. Such as appium, allure, selenium etc.

### Driver
Tests use **IOSDriver<IOSElement> driver**. 

### Page Object
**Pages** 
Each page (screen) in the app is implemented like java object. Java object consists of elements of the page (buttons, labels, links etc.) and methids to work with this elements (steps).
```java
    @iOSFindBy(id = "configuration")
    private IOSElement configurationTitle;
```
 
**Steps**
Steps (actions like 'click button', enter text into input field etc.) are located in the page class where these steps need to be done and marked with allure annotation '@Step'.

_Example_:
```java
@Step("Tap deleteVpnButton button")
public ConfigurationPage tapDeleteButton() {
    tap(deleteVpnButton);
    return this;
}
```


### Test Run

```java
    @Test
    @TestCaseId("TC12")
    @Title("Cancel deleting existing configuration")
    public void cancelDeletingConfiguration() throws NoSuchElementException, MalformedURLException {
        mainPage = populateRequiredData().tapSaveButton();
        configurationPage = mainPage.tapMoreButton();
        configurationPage.tapDeleteButton().cancelDeleteConfiguration();

        Assert.assertEquals(configurationPage.getConfigurationTitle().getText(), "configuration", "Incorrect title is displayed");
    }
```

 - From IDE:
Use standart way to run TestNG tests. Right click on test class and select 'run test class'

 - From console:
Run command
```sh
mvn clean install
```
By default tests run on iPhone 6s device. To run tests on different device - open "app.properties" and change 'deviceName' and 'uuid'. 

 - From AWS:
Currently framework contains all necessary dependencies to run tess on AWS.

### Allure
As reporting tool framework use - Allure. Tests, pages and steps are marked with Allure annotations. If test fails - screenshot is taken.
To see allure report - after tests are ran run command
```sh
 allure serve build/allure-results
```
More details can be found here - http://allure.qatools.ru/

### What can be improved
Framework implemented with basic logging, so it would be better to put more logging steps.
Another part to improve - allure annotations. Need to investigate and find out best allure's annotation to use in framework.