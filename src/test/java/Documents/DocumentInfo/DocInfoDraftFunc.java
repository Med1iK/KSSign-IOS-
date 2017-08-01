package Documents.DocumentInfo;

import findElementMethod.FindUI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.Documents.DocumentInfoFields;
import uipages.Documents.DocumentViewFields;
import uipages.MainButtons.AppMainButtons;
import uipages.MySign.MySignatureFields;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.OffsetDateTime;

import static info.userInfo.*;

public class DocInfoDraftFunc extends FindUI{
    public DocInfoDraftFunc() throws MalformedURLException {
    }

    @BeforeClass
    public void start(){
        Setup();
        wait = new WebDriverWait(driver, 1500);
    }

    @Test//(priority = 1)
            (enabled = false)
    public void authLock(){

        try {
            findByName(MySignatureFields.mySignTermsConditions());

            waitByName(MySignatureFields.mySignAuthEmail()).click();
            findByName(MySignatureFields.mySignAuthEmail()).sendKeys(userEmail);
            findByName(MySignatureFields.mySignAuthPass()).sendKeys(userPass);
            findByName(MySignatureFields.mySignAuthLogo()).click();
            findByName(MySignatureFields.mySignAuthSignInButton()).click();

        }catch (NoSuchElementException e){

            waitByName(MySignatureFields.mySignAuthPass()).click();
            waitByName(MySignatureFields.mySignAuthPass()).sendKeys(userPass);
            waitByName(MySignatureFields.mySignAuthLogo()).click();
            waitByName(MySignatureFields.mySignAuthSignInButton()).click();
        }
    }


    @Test(priority = 2)
    public void checkAvailabilityOfTheDoc(){

        waitByName(AppMainButtons.menuIcon()).click();
        waitByName(AppMainButtons.syncedStatus());
        findByName(AppMainButtons.menuIcon()).click();

        try{
            findByName(DocumentViewFields.docViewNoDocumenttsPlaceholderIcon()).isDisplayed();
            findByName(DocumentViewFields.docAddDocPlusButton()).click();
            findByXpath(DocumentViewFields.cameraButton()).click();
            waitByName(DocumentViewFields.cameraGetPhoto()).click();
            findByName(DocumentViewFields.cameraNavigationOkButton()).click();
            waitByName(DocumentViewFields.cameraNavigationOkButton()).click();
            waitByName(DocumentViewFields.cameraNavigationOkButton()).click();
            //  waitByName(DocumentViewFields.docInfoNextButton()).click();

        }catch (NoSuchElementException f) {

            findByName(DocumentViewFields.docUnnamedTitle()).click();
            //  waitByName(DocumentViewFields.docInfoNextButton()).click();
        }
    }

    @Test//(priority = 3)
            (enabled = false)
    public void enterMessage(){

        waitByName(DocumentInfoFields.enterAMessage()).click();
        waitByName(DocumentInfoFields.enterMessageView()).sendKeys(enterMessageText);
        findByName(AppMainButtons.navigationCloseButton()).click();
        waitByName(DocumentInfoFields.enterAMessage()).click();

        MobileElement messageView = (MobileElement) findByName(DocumentInfoFields.enterMessageView());
        Assert.assertEquals(messageView.getAttribute("value"),null);

        waitByName(DocumentInfoFields.enterMessageView()).sendKeys(enterMessageText);
        waitByName(AppMainButtons.navigationOkButton()).click();


        waitByName(DocumentInfoFields.enterAMessage()).click();
        Assert.assertEquals(messageView.getAttribute("value"), enterMessageText);
        findByName(AppMainButtons.navigationCloseButton()).click();
    }

    @Test//(priority = 4)
            (enabled = false)
    public void checkKeyboardOfEnterMessage(){

        findByName(DocumentInfoFields.enterAMessage()).click();
        runAppInBAckground();
        waitByName(DocumentInfoFields.editMessageTitile());

        MobileElement checkKeyboard = (MobileElement) findByName(DocumentInfoFields.keyboard());
        Assert.assertEquals(checkKeyboard.getAttribute("enabled"), true);

        findByName(AppMainButtons.navigationCloseButton()).click();
    }

    @Test//(priority = 5)
            (enabled = false)
    public void addSigners(){

        findByName(DocumentInfoFields.addParticipantButton()).click();
        waitByName(DocumentInfoFields.loadingWheel()).isDisplayed();

        findByName(DocumentInfoFields.fef1()).click();
        findByName(DocumentInfoFields.fef2()).click();

        findByName(DocumentInfoFields.inviteButton()).click();
        waitByName(DocumentInfoFields.inviteAsSigner()).click();
    }

    @Test//(priority = 6)
            (enabled = false)
    public void addObservers(){

        findByName(DocumentInfoFields.addParticipantButton()).click();
        waitByName(DocumentInfoFields.loadingWheel()).isDisplayed();

        findByName(DocumentInfoFields.fef87()).click();
        findByName(DocumentInfoFields.fef88()).click();

        findByName(DocumentInfoFields.inviteButton()).click();
        waitByName(DocumentInfoFields.inviteAsObserver()).click();
    }

    @Test(priority = 7)
    public void checkSignOrderFunctiona(){

        waitByName(DocumentInfoFields.enterAMessage());         //Don't forget to remove

        TouchAction action = new TouchAction(driver);

        MobileElement signOrderSwitch = (MobileElement) findByName(DocumentInfoFields.signOrderSwitch());

      //  Assert.assertEquals(signOrderSwitch.getAttribute("value"),true);
        //Assert.assertEquals(signOrderSwitch.getCssValue("value"),1);

        findByName(DocumentInfoFields.fef1NameWithSignOrder());
        findByName(DocumentInfoFields.fef2NameWithSignOrder());

        signOrderSwitch.click();

        findByName(DocumentInfoFields.fef1NameWithoutSignOrder());
        findByName(DocumentInfoFields.fef2NameWithoutSignOrder());

        signOrderSwitch.click();

        findByName(DocumentInfoFields.editButtonForSigner()).click();

      //  waitByName(DocumentInfoFields.reorderFef2WithSignOrder1());

        MobileElement reorder1OfFef1 = (MobileElement) findByName(DocumentInfoFields.reorderFef1WithSignOrder1());
       // MobileElement reorder2OfFef1 = (MobileElement) findByName(DocumentInfoFields.reorderFef1WithSignOrder2());
       // MobileElement reorder1OfFef2 = (MobileElement) findByName(DocumentInfoFields.reorderFef2WithSignOrder1());
        MobileElement reorder2OfFef2 = (MobileElement) findByName(DocumentInfoFields.reorderFef2WithSignOrder2());

        action
                .press(reorder1OfFef1)
                .waitAction(111)
                .moveTo(reorder2OfFef2)
                .release()
                .perform();

    }
}
