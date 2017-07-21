package Documents.AddDocuments;


import findElementMethod.FindUI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.Documents.AddDocumentFields;
import uipages.Documents.DocumentListFields;
import uipages.MainButtons.AppMainButtons;
import uipages.MySign.MySignatureFields;

import java.net.MalformedURLException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class AddDoc extends FindUI {

    public AddDoc() throws MalformedURLException {}

    @BeforeClass
    public void start() {
        Setup();
        wait = new WebDriverWait(driver, 1500);
    }

    public static String userEmail = "wse1@mailinator.com";
    public static String userPass = "qwerty";
    public static String firstName = "Johny";
    public static String lastName = "Best";
    public static String company = "KS";
    public static String dropBoxEmail = "";
    public static String dropBoxPass = "";


    int t = 20;
    int t1 = 20;
    int t2 = 30;
    int t3 = 40;


    @Test(priority = 1)
           // (enabled = false)
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
         //   (enabled = false)
    public void checkSyncStatus(){

        waitByName(AppMainButtons.menuIcon()).click();
        waitByName(AppMainButtons.syncedStatus());
        findByName(AppMainButtons.menuIcon()).click();
    }

    @Test//(priority = 3)
            (enabled = false)
    public void checkUIOfAddDocumentMenu(){

        findByName(AddDocumentFields.addDocButton()).click();

        waitByName(AddDocumentFields.addNewDocTitile());
        System.out.println("Title has been checked");

        findByName(AppMainButtons.cancelButton());
        System.out.println("Cancel button has been checked");

        //Template
        findByName(AddDocumentFields.templateIcon());
        findByName(AddDocumentFields.templateTitle());
        findByName(AddDocumentFields.templateText());
        System.out.println("UI of Template has been checked");

        //DropBox
        findByName(AddDocumentFields.dropboxIcon());
        findByName(AddDocumentFields.dropboxTitle());
        System.out.println("DropBox UI has been checked");

        //GoogleDrive
        findByName(AddDocumentFields.googleDriveIcon());
        findByName(AddDocumentFields.googleDriveTitle());
        System.out.println("Google Drive UI has been checked");

        //iCloudDriver
        findByName(AddDocumentFields.icloudIcon());
        findByName(AddDocumentFields.icloudTitle());
        System.out.println("iCloud Driver UI has been checked");

        //Evernote
        findByName(AddDocumentFields.evernoteIcon());
        findByName(AddDocumentFields.evernoteTitle());
        System.out.println("Evernote UI has been checked");

        //Camera
        findByName(AddDocumentFields.cameraIcon());
        findByName(AddDocumentFields.cameraTitle());
        System.out.println("Camera UI has been checked");

        //Gallery?

        findByName(AppMainButtons.cancelButton()).click();
    }

    @Test//(priority = 4)
            (enabled = false)
    public void addDocFromDropBox(){

        waitByName(AddDocumentFields.addDocButton()).click();
        waitByName(AddDocumentFields.dropboxTitle());
        findByName(AddDocumentFields.dropBoxButton()).click();

        //In the future need improved
        waitByName(AddDocumentFields.keepSolidSign());
        findByName(AddDocumentFields.wouldYouLikeToAcess());
        findByName(AddDocumentFields.allowButton()).click();

        waitByName(AddDocumentFields.passwordField()).click();
        waitByName(AddDocumentFields.passwordField()).sendKeys(userPass);
        findByName(AppMainButtons.doneButton()).click();

        waitByName(AddDocumentFields.dropboxTitle());
        waitByName(AddDocumentFields.objectiveCPdf()).click();
        waitByName(AppMainButtons.progressWheel()).isDisplayed();
        findByName(AppMainButtons.navigationCloseButton()).click();

        waitByName(AppMainButtons.menuIcon());
        findByName(AddDocumentFields.objectiveCC());
    }

    @Test(priority = 5)
    public void addDocFromGoogleDrive(){

        TouchAction action = new TouchAction(driver);

        findByName(AddDocumentFields.addDocButton()).click();
        waitByName(AddDocumentFields.googleDriveTitle());
        waitByName(AddDocumentFields.googleDriveButton()).click();

        waitByName(AddDocumentFields.googleAkksView());
        MobileElement swipe = (MobileElement) findByName(AddDocumentFields.googleAkksView());
        Dimension size = swipe.getSize();
        System.out.println(size);

        action
                .press(swipe)
                .waitAction(111)
                .moveTo(swipe, 1,1)
                .release()
                .perform();

        findByName(AddDocumentFields.johnyJohnsAkk()).click();
        waitByName(AddDocumentFields.ksSignExportedPdf()).click();
        waitByName(AppMainButtons.progressWheel()).isDisplayed();
        waitByName(AppMainButtons.navigationCloseButton()).click();

        waitByName(AppMainButtons.menuIcon());
        findByName(AddDocumentFields.ksSignExported());
    }

    @Test(priority = 6)
    public void addDocFromIcloud(){

        findByName(AddDocumentFields.addDocButton()).click();
        waitByName(AddDocumentFields.icloudTitle());
        findByName(AddDocumentFields.icloudButton()).click();

        waitByName(AddDocumentFields.locations());
        findByName(AddDocumentFields.doc398()).click();

        waitByName(AppMainButtons.menuIcon());
        findByName(AddDocumentFields.doc398InDocList());
    }


    @Test(priority = 7)
    public void addDocFromEvernote(){

        findByName(AddDocumentFields.addDocButton()).click();
        waitByName(AddDocumentFields.evernoteTitle());
        findByName(AddDocumentFields.evernoteButton()).click();

        waitByName(AddDocumentFields.evernoteSignInTitle());
        findByXpath(AddDocumentFields.evernoteSignInEmailField()).click();
        findByXpath(AddDocumentFields.evernoteSignInEmailField()).sendKeys(userEmail);
        findByXpath(AddDocumentFields.evernoteSignInPassword()).click();
        findByXpath(AddDocumentFields.evernoteSignInPassword()).sendKeys(userPass);
        findByName(AddDocumentFields.evernoteSignInButton()).click();

        waitByName(AddDocumentFields.evernoteAuthoriseKSSignTitle());
        findByName(AddDocumentFields.evernoteAuthoriseButton()).click();

        waitByName(AddDocumentFields.evernoteFirstNotebook()).click();
        waitByName(AddDocumentFields.evernoteExptTest2()).click();
       // waitByName(AddDocumentFields.progressWheel()).isDisplayed();
        waitByName(AppMainButtons.navigationCloseButton()).click();

        waitByName(AppMainButtons.menuIcon());
        findByName(AddDocumentFields.evernoteDocListExptTest2());
    }

    @Test//(priority = 2)
            (enabled = false)
    public void addDocFromScan() {

        TouchAction action = new TouchAction(driver);
        Actions builder = new Actions(driver);


        waitByName(DocumentListFields.documentMenuAddDocumentButton()).click();
        waitByName(DocumentListFields.documentAddScanIcon());
        findByName(DocumentListFields.documentAddScanIcon());
        System.out.println("Icon");
        findByName(DocumentListFields.documentAddScanIconName());
        System.out.println("Name");
        findByName(DocumentListFields.documentAddScanIcon()).click();
        waitByName(DocumentListFields.scanGetPhotoButton()).click();
        waitByName(DocumentListFields.docNavigationOkButton()).click();
        findByXpath(DocumentListFields.scanCropElement1());


        MobileElement slider = (MobileElement) findByXpath(DocumentListFields.cropImageView());
        Dimension size = slider.getSize();
        Point sizeL = slider.getLocation();

        TouchAction swipe = new TouchAction(driver).press(slider, size.width / 8, size.height /118 )
                .waitAction(Duration.ofSeconds(2)).moveTo(slider, 390, size.height / 627).release();
        swipe.perform();

        TouchAction swipe1 = new TouchAction(driver).press(slider, sizeL.x=8, sizeL.y=118 )
                .waitAction(Duration.ofSeconds(2)).moveTo(slider, sizeL.x=390, sizeL.y=627).release();
        swipe.perform();

        waitByName(DocumentListFields.scanCropImageTitle());
        waitByName(DocumentListFields.docNavigationOkButton()).click();
        waitByName(DocumentListFields.scanColourImageIcon()).click();
        waitByXpath(DocumentListFields.elementTypeSlider());
    }

    @AfterClass
    public void logOutFromAllClouds(){

        findByName(AppMainButtons.menuIcon()).click();
        findByName(AddDocumentFields.settingsMenuButton()).click();
        waitByName(AddDocumentFields.settingsCloudStorage()).click();

        findByName(AddDocumentFields.dropboxTitle()).click();
        findByName(AddDocumentFields.googleDriveTitle()).click();
        findByName(AddDocumentFields.evernoteTitle()).click();

        findByName(AppMainButtons.navigBackButton()).click();
        findByName(AppMainButtons.menuIcon()).click();
        findByName(AppMainButtons.docMenuButton()).click();

        driver.quit();
    }

}
