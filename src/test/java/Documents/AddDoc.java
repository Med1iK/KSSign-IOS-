package Documents;


import findElementMethod.FindUI;
import io.appium.java_client.TouchAction;
import org.bouncycastle.asn1.DEROctetString;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.DocumentListFields;
import uipages.UpdateInfoFields;

import javax.print.Doc;
import javax.swing.*;
import java.net.MalformedURLException;

public class AddDoc extends FindUI{


    public AddDoc() throws MalformedURLException {
    }

    @BeforeClass
    public void start(){
        Setup();
        wait = new WebDriverWait(driver,1500);
    }

    public static String userEmail = "wse1@mailinator.com";
    public static String userPass = "qwerty";
    public static String firstName = "Johny";
    public static String lastName = "Best";
    public static String company = "KS";

    @Test(priority = 1)
    public void authorisation(){

        waitByName(DocumentListFields.documentAuthEmail());
        findByName(DocumentListFields.documentAuthEmail()).click();
        findByName(DocumentListFields.documentAuthEmail()).sendKeys(userEmail);
        findByName(DocumentListFields.documentAuthPass()).sendKeys(userPass);
        findByName(DocumentListFields.documentAuthKSIDLogo()).click();
        findByName(DocumentListFields.documentAuthSignInButton()).click();
    }

/*    @Test(priority = 2)
    public void checKUIOfDocumentListMenu(){

        waitByName(DocumentListFields.documentMenuIcon());
        findByName(DocumentListFields.documentMenuIcon()).click();
        waitByName(DocumentListFields.documentSynced());
        findByName(DocumentListFields.documentMenuIcon()).click();
        System.out.println("Menu Icon has been checked");
        findByName(DocumentListFields.documentMenuTitle());
        System.out.println("Title has been checked");
        findByName(DocumentListFields.documentMenuNotificationIcon());
        System.out.println("Notification icon has been checked");
        findByName(DocumentListFields.documentMenuFilterAll());
        System.out.println("All documents filter has been checked");
        findByName(DocumentListFields.documentMenuFilterWaitingForMe());
        System.out.println("Waiting for me filter has been checked");
        findByName(DocumentListFields.documentMenuFilterWaitingForOthers());
        System.out.println("Waiting for other filter has been checked");
        findByName(DocumentListFields.documentMenuNoDocumenttsPlaceholderIcon());
        System.out.println("No document icon has been checked");
        findByName(DocumentListFields.documentMenuNoDocumentsPlaceholderIconText());
        System.out.println("No document text has been checked");
        findByName(DocumentListFields.documentMenuAddDocumentButton());
        System.out.println("Add document button has been checked");
        findByName(DocumentListFields.documentMenuEditButton());
        System.out.println("Edit button has been checked");
        findByName(DocumentListFields.documentMenuSearchButton());
        System.out.println("Search button has been checked");

    }*/


/*
    @Test(priority = 2)
    public void addDocFromScan(){

        TouchAction action = new TouchAction(driver);

        waitByName(DocumentListFields.documentMenuAddDocumentButton()).click();
        waitByName(DocumentListFields.documentAddScanIcon());
        findByName(DocumentListFields.documentAddScanIcon());
        System.out.println("Icon");
        findByName(DocumentListFields.documentAddScanIconName());
        System.out.println("Name");
        findByName(DocumentListFields.documentAddScanIcon()).click();
        waitByName(DocumentListFields.scanGetPhotoButton()).click();
      //  findByName(DocumentListFields.scanGetPhotoButton()).click();
        waitByName(DocumentListFields.docNavigationOkButton()).click();
        waitByName(DocumentListFields.scanCropImageTitle());

        action.press(findByXpath(DocumentListFields.scanCropElement1())).waitAction(111).moveTo(findByXpath(DocumentListFields.scanCropElement2())).perform().release();
    }
*/


    @Test(priority = 2)
    public void test(){

            TouchAction action = new TouchAction(driver);

            waitByName(DocumentListFields.documentPreview()).click();
            waitByName(DocumentListFields.documentNavigationNextButton()).click();
            waitByXpath(DocumentListFields.annotation());
            action.press(findByXpath(DocumentListFields.annotation()));

            action.press(findByXpath(DocumentListFields
                    .annotation()))
                    .waitAction()
                    .moveTo(11, 11)
                    .perform()
                    .release();


        waitByName(DocumentListFields.documentPreview());
    }

}
