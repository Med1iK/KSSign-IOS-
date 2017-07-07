package MySignature;


import findElementMethod.FindUI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.MySignatureFields;

import java.net.MalformedURLException;

public class Signature extends FindUI{


    public Signature() throws MalformedURLException {
    }


    @BeforeClass
    public void start() {
        Setup();
        wait = new WebDriverWait(driver, 1500);
    }


    @Test
    public void sign(){

    TouchAction action = new TouchAction(driver);
    TouchAction action2 = new TouchAction(driver);


    waitByName(MySignatureFields.signMenuButton()).click();
    findByName(MySignatureFields.signMySignMenuButton()).click();
    waitByName(MySignatureFields.signAddSignPlaceHolderIcon()).click();
    //waitByName(MySignatureFields.signSignAdded()).click();
    waitByXpath(MySignatureFields.signDrawSignWindow());

    MobileElement sign1 = (MobileElement) findByXpath(MySignatureFields.signDrawSignWindow());

    int signWidth = sign1.getSize().getWidth();
    int signHeight = sign1.getSize().getHeight();
    System.out.println("Width"+signWidth);
    System.out.println("Heigh"+signHeight);


    action
            .press(sign1,1,1)
            .waitAction(111)
            .moveTo(sign1, signWidth, signHeight)
            .release().perform();

    action2
            .press(sign1,1,signHeight-1)
            .waitAction(111)
            .moveTo(sign1,signWidth-1,1)
            .release().perform();


    String a = action.press(sign1,0,0).toString();
        System.out.println("ddd"+a);

        waitByName(MySignatureFields.signBlackColor()).click();
        findByName(MySignatureFields.signRedColor()).click();

        String b = action.press(sign1,0,0).toString();
        System.out.println("ddd"+b);

}

}
