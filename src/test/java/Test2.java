import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Test2{

/*    Maybe you should go for TouchActions:
            driver.performTouchAction(new IOSTouchAction(driver).press(elem)
.moveTo(0, elem.getLocation().getY())
            .release());*/

    private AppiumDriver driver;


    URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
    public Test2() throws MalformedURLException {


    }

    @BeforeSuite
    public void Setup(){

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3.1");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Andrew's IPhone");
        capabilities.setCapability(MobileCapabilityType.UDID, "*****");

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.APP, "*****");

        capabilities.setCapability("showXcodeLog", "true");
       // capabilities.setCapability("autoAcceptAlerts", "true");

        driver = new IOSDriver(serverUrl,capabilities);

    }



    @Test(priority = 1)
    public void UITest(){

        System.out.println("Check Title");
        driver.findElement(By.name("Sign in with Keepsolid ID"));
        driver.findElement(By.name("KeepsolidIDLogo"));
        System.out.println("KS loga has been checked");
        driver.findElement(By.name("AuthKSEmail"));
        System.out.println("Email field has been checked");
        driver.findElement(By.name("AuthKSPass"));
        System.out.println("Pass field has been checked");
        driver.findElement(By.name("AuthKSSignIn"));
        System.out.println("SignIn button has been checked");
        driver.findElement(By.name("Remember password"));
        System.out.println("Remember password field has been checked");
        driver.findElement(By.name("Forgot your password?"));
        System.out.println("Forgot pass field has been checked");
        driver.findElement(By.name("Create a new KeepSolid ID"));
        System.out.println("Create new KS ID field has been checked");
        driver.findElement(By.name("By signing in, you agree to our"));
        System.out.println("By signing in, you agree to our - has been checked");
        driver.findElement(By.name("Terms & Conditions"));
        System.out.println("Terms and Conditions field has bee checked");

        //driver.runAppInBackground(3);

    }

    @Test
    public void RemembePass(){

        WebDriverWait wait = new WebDriverWait(driver, 30);


        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("AuthKSEmail")));
        driver.findElement(By.name("AuthKSEmail")).click();
        driver.findElement(By.name("AuthKSEmail")).sendKeys("wse1@mailinator.com");

        driver.findElement(By.name("AuthKSPass")).sendKeys("qwerty");
        driver.findElement(By.name("KeepsolidIDLogo")).click();
        driver.findElement(By.name("AuthKSSignIn")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("MenuIcon")));
        driver.findElement(By.name("MenuIcon")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Synced")));
        driver.runAppInBackground(3);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("wse1@mailinator.com")));
        driver.findElement(By.name("AuthKSPass")).click();
        driver.findElement(By.name("AuthKSPass")).sendKeys("qwerty");
        driver.findElement(By.name("KeepsolidIDLogo")).click();
        driver.findElement(By.name("Remember password")).click();
        driver.findElement(By.name("AuthKSSignIn")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("MenuIcon")));
        driver.findElement(By.name("MenuIcon")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Synced")));
        driver.runAppInBackground(3);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("MenuIcon")));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Synced")));
        driver.findElement(By.name("Logout")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Are you sure you want to log out?")));
        driver.findElement(By.name("Logout")).click();

    }

    @Test(priority = 3)
    public void FailToSignIn(){


        WebDriverWait wait = new WebDriverWait(driver, 5000);

        driver.findElement(By.name("AuthKSEmail")).sendKeys("test@test.com");
        driver.findElement(By.name("AuthKSPass")).sendKeys("qwerty1");
        driver.findElement(By.name("Done")).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("1C2O3N")));
        driver.findElement(By.name("1C2O3N")).click();

        try {
            Thread.sleep(2222);
        } catch (InterruptedException e) {
            driver.findElement(By.name("KeepSolid Sign Feedback message"));
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("KeepSolid Sign Feedback message")));
        driver.findElement(By.name("KeepSolid Sign Feedback message"));
        System.out.println("Title has been checked");
        driver.findElement(By.name("subjectField"));
        System.out.println("subjectField has been checked");
        driver.findElement(By.name("Message body")).sendKeys("Test");
        System.out.println("Message body has been added");
        driver.findElement(By.name("Send")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("AuthKSEmail")));
        driver.findElement(By.name("AuthKSEmail")).click();
        driver.findElement(By.name("Clear text")).click();
        driver.findElement(By.name("AuthKSEmail")).sendKeys("wse11@binka.me");
        driver.findElement(By.name("AuthKSPass")).sendKeys("qwerty");
        driver.findElement(By.name("Done")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("1C2O3N")));
        driver.findElement(By.name("1C2O3N")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Cancel")));
        driver.findElement(By.name("Cancel")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Delete Draft")));
        driver.findElement(By.name("Delete Draft")).click();

    }


    @Test(priority = 4)
    public void AuthTest1(){

        WebDriverWait wait = new WebDriverWait(driver, 30);


        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("AuthKSEmail")));
        driver.findElement(By.name("AuthKSEmail")).click();
        driver.findElement(By.name("Clear text")).click();
        driver.findElement(By.name("AuthKSEmail")).sendKeys("wse12@binka.me");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("AuthKSPass")));
        driver.findElement(By.name("AuthKSPass")).sendKeys("qwerty");
        driver.findElement(By.name("KeepsolidIDLogo")).click();
        driver.findElement(By.name("AuthKSSignIn")).click();

    }


    @Test(priority = 2)
    public void ForgotPass() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver,1500);

        driver.findElement(By.name("Forgot your password?")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Password Recovery")));
        driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeOther[4]/XCUIElementTypeTextField")).sendKeys("wse1@mailinator.com");
        driver.findElement(By.name("SEND")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Recovery details sent to")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("wse1@mailinator.com")));

        driver.findElement(By.name("URL")).sendKeys("mailinator.com");
        driver.findElement(By.name("Go")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Free Public Email")));
        driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Mailinator\"]/XCUIElementTypeTextField")).sendKeys("wse1");
        driver.findElement(By.name("GO!")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("KeepSolid Inc")));
        System.out.println("Forgot password letter has been located");

    //    driver.swipe(400, 500, 100, 200, 200);

        driver.findElement(By.name("Return to KeepSolid Sign")).click();

    }


    /*    @After
    public void TearDown(){
        driver.quit();
    }*/


}
