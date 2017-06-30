/*
package AppiumDriver;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppDriv {

    public AppiumDriver getAppiumDriver(String platform, URL serverUrl){
        return platform.equals("IOS") ? getIOSDriver(serverUrl) : getAndroidDriver(serverUrl);
    }

    public AppiumDriver getIOSDriver(URL serverUrl) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Andrew's IPhone");
        capabilities.setCapability(MobileCapabilityType.UDID, "*****");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.APP, "&&&");

        capabilities.setCapability("showXcodeLog", "true");
        capabilities.setCapability("autoAcceptAlerts", "true");

        return new IOSDriver(serverUrl, capabilities);
    }


    public AppiumDriver getAndroidDriver (URL serverUrl) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");

        return new IOSDriver(serverUrl, capabilities);
    }
}
*/
