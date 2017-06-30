package AppiumDriver;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class AppSetup {


    public AppiumDriver driver;
    public WebDriverWait wait;


    URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
    public AppSetup() throws MalformedURLException {
    }

    public void Setup(){

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3.1");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Andrew's IPhone");
        capabilities.setCapability(MobileCapabilityType.UDID, "*******");

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.APP, "******");

        capabilities.setCapability("showXcodeLog", "true");
        // capabilities.setCapability("autoAcceptAlerts", "true");
        driver = new IOSDriver(serverUrl,capabilities);

        if (driver != null) {
            System.out.println("driver is not null");
        }
    }

}
