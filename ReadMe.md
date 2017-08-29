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
> Before run tests make sure Xcode is installed on your machine. Also get the list of available simulators on your machine to run tests.
To get the list of simulators and uuids on your machine - run following command:
```ssh
instruments -s devices
```
Here is how test class looks like
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
By default tests run on **iPhone 6s** device. To run tests on different device - open "app.properties" and change 'deviceName' and 'uuid'. 

Appium server and simulator will be started automatically before test run.

See Driver.startServer():
```java
private static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
```
```java
public static void startServer() {
    if (!service.isRunning()){
        service.start();
    } else {
        log.info("[Driver] Appium server is already started");
    }
}
```

Apiium server and simulator will be stopped automatically after test run.

See Driver.storServer():
```java
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
```

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
