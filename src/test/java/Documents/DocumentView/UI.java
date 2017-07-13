package Documents.DocumentView;

import findElementMethod.FindUI;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.Documents.DocumentViewFields;
import uipages.MySign.MySignatureFields;

import java.net.MalformedURLException;


public class UI extends FindUI {

    public UI() throws MalformedURLException {
    }

    public String userEmail = "wse1@mailinator.com";
    public String userPass = "qwerty";
    public String signerFirstName = "wse";
    public String signerLastName = "3";
    public String signerEmail = "wse3@mailinator.com";
    public static final String ANSI_RED = "\u001B[31m";


    @BeforeClass
    public void start() {
        Setup();
        wait = new WebDriverWait(driver, 1500);
    }

    @Test(priority = 1)
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

        waitByName(DocumentViewFields.docViewMenuIcon()).click();
        waitByName(DocumentViewFields.docViewSynced());
        findByName(DocumentViewFields.docViewMenuIcon()).click();

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

    @Test(priority = 3)
    public void checkUIOfDocView(){

        waitByName(DocumentViewFields.docUnnamedTitle());
        System.out.println("Doc view Title has been checked");

        findByName(DocumentViewFields.docViewNavigationBackButton());
        System.out.println("Navigation Back button has been checked");

        findByName(DocumentViewFields.docViewNavigationSendButton());
        System.out.println("Send button has been checked");

        findByName(DocumentViewFields.docViewAddAnnotationButton());
        System.out.println("Add annotation button has been checked");

        findByName(DocumentViewFields.docViewUndoActionButton());
        System.out.println("Undo button has been checked");

        findByName(DocumentViewFields.docViewRedoActionButton());
        System.out.println("Redo button has been checked");

        findByName(DocumentViewFields.docViewAllPageButton());
        System.out.println("All page button has been checked");

        findByName(DocumentViewFields.docViewExportButton());
        System.out.println("Export button has been checked");
    }

    @Test(priority = 4)
    public void checkUIOFSelectAnnotationPopup(){

        findByName(DocumentViewFields.docViewAddAnnotationButton()).click();

        findByName(DocumentViewFields.docViewSelectAnnotationNumberOfAction());
        findByName(DocumentViewFields.docViewSelectAnnotationAction());
        System.out.println("Select Annotation title has been checked");

        findByName(DocumentViewFields.docViewSignatureAnnotation());
        findByName(DocumentViewFields.docViewPutASignature());
        System.out.println("Signature annotation has been checked");

        findByName(DocumentViewFields.docViewInitialsAnnotation());
        findByName(DocumentViewFields.docViewPutInitials());
        System.out.println("Initials annotation has been checked");

        findByName(DocumentViewFields.docViewDateAnnotation());
        findByName(DocumentViewFields.docViewPutADate());
        System.out.println("Date annotation has been checked");

        findByName(DocumentViewFields.docViewCheckmarkAnnotatin());
        findByName(DocumentViewFields.docViewPutACheckmark());
        System.out.println("Checkmark annotation has been checked");

        findByName(DocumentViewFields.docViewTextAnnotation());
        findByName(DocumentViewFields.docViewPutAText());
        System.out.println("Text annotation has been checked");

        findByName(DocumentViewFields.docViewMenuSwipeCloseIcon());
        System.out.println("Swipe icon has been checked");
    }

    @Test(priority = 5)
    public void checkUIOfSelectSignerScreen(){

        findByName(DocumentViewFields.docViewSignatureAnnotation()).click();

        findByName(DocumentViewFields.docViewSelectSignerAction());
        findByName(DocumentViewFields.docViewSelectSignerNumberOfAction());
        System.out.println("Select signer title has been checked");

        findByName(DocumentViewFields.docViewMeAsSigner());
        findByName(DocumentViewFields.docViewAppointYourselfAsSigner());
        System.out.println("Select Me as Signer has been checked");

        findByName(DocumentViewFields.docViewPublicAnnotation());
        findByName(DocumentViewFields.docViewAnybodyCanCompAnnotation());
        System.out.println("Publick annotation has been checked");

        findByName(DocumentViewFields.docViewAddSignersButton());
        System.out.println("Add Signer button has been checked");

        findByName(DocumentViewFields.docViewMenuSwipeCloseIcon());
        System.out.println("Swipe icon has been checked");

        driver.swipe(0,225,172,29,111);
    }
}
