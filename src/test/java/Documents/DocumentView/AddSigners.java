package Documents.DocumentView;


import com.gargoylesoftware.htmlunit.DefaultPageCreator;
import findElementMethod.FindUI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.Documents.DocumentViewFields;
import uipages.MySign.MySignatureFields;

import javax.print.Doc;
import java.net.MalformedURLException;

public class AddSigners extends FindUI{

    public AddSigners() throws MalformedURLException {
    }

    @BeforeClass
    public void start() {
        Setup();
        wait = new WebDriverWait(driver, 1500);
    }

    public String userEmail = "wse1@mailinator.com";
    public String userPass = "qwerty";
    public String signerFirstName = "wse";
    public String signerLastName = "3";
    public String signerEmail = "wse3@mailinator.com";
    public static final String ANSI_RED = "\u001B[31m";

    @Test(priority = 1)
    //   (enabled = false)
    public void checkAvailabilityOfTheDoc(){

        try{
            findByName(DocumentViewFields.docViewNoDocumenttsPlaceholderIcon()).isDisplayed();
            findByName(DocumentViewFields.docAddDocPlusButton()).click();
            findByXpath(DocumentViewFields.cameraButton()).click();
            waitByName(DocumentViewFields.cameraGetPhoto()).click();
            findByName(DocumentViewFields.cameraNavigationOkButton()).click();
            waitByName(DocumentViewFields.cameraNavigationOkButton()).click();
            waitByName(DocumentViewFields.cameraNavigationOkButton()).click();
            waitByName(DocumentViewFields.docInfoNextButton()).click();

        }catch (NoSuchElementException f) {

            findByName(DocumentViewFields.docUnnamedTitle()).click();
            waitByName(DocumentViewFields.docInfoNextButton()).click();
        }
    }

    @Test(priority = 2)
    public void addSignerToContactList() {

        waitByName(DocumentViewFields.docViewAddAnnotationButton()).click();
        findByName(DocumentViewFields.docViewSignatureAnnotation()).click();
        findByName(DocumentViewFields.docViewAddSignersButton()).click();

        try{
            waitByName(DocumentViewFields.userwse3mailinator()).isDisplayed();

        }catch(NoSuchElementException f){

            waitByName(DocumentViewFields.contactInviteButton()).click();
            waitByName(DocumentViewFields.contactAddByEmail()).click();
            waitByName(DocumentViewFields.contactAddANewContact());
            findByName(DocumentViewFields.contactAddContactFirstName()).sendKeys(signerFirstName);
            findByName(DocumentViewFields.contactAddContactLastName()).click();
            findByName(DocumentViewFields.contactAddContactLastName()).sendKeys(signerLastName);
            findByName(DocumentViewFields.contactAddContactEmail()).click();
            findByName(DocumentViewFields.contactAddContactEmail()).sendKeys(signerEmail);
            findByName(DocumentViewFields.contactAddContactAddButton()).click();
        }
    }

    @Test(priority = 3)
    public void addSignerToTheDoc(){
        TouchAction action = new TouchAction(driver);

        findByName(DocumentViewFields.userwse3mailinator()).click();
        findByName(DocumentViewFields.contactInviteButtonOnBottomPanel()).click();
        findByName(DocumentViewFields.contactInviteAsSigner()).click();
        waitByName(DocumentViewFields.signerWse3());

        MobileElement swipe = (MobileElement) findByName(DocumentViewFields.docViewMenuSwipeCloseIcon());
        MobileElement signerWindow = (MobileElement) findByXpath(DocumentViewFields.selectSignerWindow());
        Dimension size = signerWindow.getSize();

        action
                .press(swipe)
                .waitAction(111)
                .moveTo(signerWindow, size.width/2, size.height/100)
                .release()
                .perform();
     //   driver.swipe(1,235,172,29,111);
    }

    @Test//(priority = 3)
            (enabled = false)
    public void addAnnotations(){

        findByName(DocumentViewFields.docViewAddAnnotationButton()).click();
    }

}
