package Documents.DocumentView;


import com.gargoylesoftware.htmlunit.DefaultPageCreator;
import findElementMethod.FindUI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.Documents.DocumentViewFields;
import uipages.MySign.MySignatureFields;

import javax.print.Doc;
import java.net.MalformedURLException;

public class AddAnnotations extends FindUI{


    public AddAnnotations() throws MalformedURLException {
    }

    public String userEmail = "wse1@mailinator.com";
    public String userPass = "qwerty";
    public String signerFirstName = "wse";
    public String signerLastName = "3";
    public String signerEmail = "wse3@mailinator.com";
    public static final String ANSI_RED = "\u001B[31m";




    @Test(priority = 1)
    public void addSignerToContactList() {

        findByName(DocumentViewFields.docViewAddAnnotationButton()).click();
        findByName(DocumentViewFields.docViewSignatureAnnotation()).click();
        findByName(DocumentViewFields.docViewAddSignersButton()).click();

        try{
            findByName(DocumentViewFields.userwse3mailinator()).isDisplayed();
        }catch(NoSuchElementException f){
            findByName(DocumentViewFields.contactInviteButton()).click();
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

    @Test(priority = 2)
    public void addSignerToTheDoc(){

        findByName(DocumentViewFields.userwse3mailinator()).click();
        findByName(DocumentViewFields.contactInviteButtonOnBottomPanel()).click();
        findByName(DocumentViewFields.contactInviteAsSigner()).click();
        waitByName(DocumentViewFields.signerWse3());

        driver.swipe(0,225,172,29,111);

    }

    @Test(priority = 3)
    public void addAnnotations(){

        findByName(DocumentViewFields.docViewAddAnnotationButton()).click();


    }

}
