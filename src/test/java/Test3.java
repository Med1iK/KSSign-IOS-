import findElementMethod.FindUI;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.Documents.DocumentListFields;
import uipages.AuthReg.UpdateInfoFields;

import java.net.MalformedURLException;

public class Test3 extends FindUI {


    public Test3() throws MalformedURLException {
    }

    @BeforeClass
    public void start(){
        Setup();
        wait = new WebDriverWait(driver,1500);
    }


    @Test(priority = 1)
    public void auth(){

        waitByName(UpdateInfoFields.updateInfoEmail());
        findByName(UpdateInfoFields.updateInfoEmail()).click();
        findByName(UpdateInfoFields.updateInfoEmail()).sendKeys("wse1@mailinator.com");
        findByName(UpdateInfoFields.updateInfoPass()).sendKeys("qwerty");
        findByName(UpdateInfoFields.updateKSIDLogo()).click();
        findByName(UpdateInfoFields.updateInfoSignInButton()).click();
    }

    @Test(priority = 2)
    public void longTap(){

        TouchAction longPress = new TouchAction(driver);

        waitByName(UpdateInfoFields.updateMenuIcon());
        waitByName(DocumentListFields.documentPreview());
        System.out.println("Checked1");
        findByName(DocumentListFields.documentPreview());
        System.out.println("Checked2");
        longPress.longPress(findByName(DocumentListFields.documentPreview())).perform();

        longPress.longPress(findByName(DocumentListFields.documentMenuSearchButton())).waitAction(111).moveTo(findByName(DocumentListFields.documentMenuSearchButton())).perform().release();

    }

}
