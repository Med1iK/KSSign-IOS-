package Documents;


import findElementMethod.FindUI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.apache.commons.io.output.TaggedOutputStream;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.AuthorisationFields;
import uipages.DocumentListFields;

import javax.print.Doc;
import java.net.MalformedURLException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class AddDoc extends FindUI {


    public AddDoc() throws MalformedURLException {
    }

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



/*    @Test(priority = 1)
    public void lockScreen(){

        waitByName(AuthorisationFields.authPass()).click();
        findByName(AuthorisationFields.authPass()).sendKeys("qwerty");
        findByName(AuthorisationFields.authLogo()).click();
        //findByName(AuthorisationFields.authRememberPass()).click();
        findByName(AuthorisationFields.authSignInButton()).click();
    }*/
 /*   @Test(priority = 1)
    public void authorisation() {

        waitByName(DocumentListFields.documentAuthEmail());
        findByName(DocumentListFields.documentAuthEmail()).click();
        findByName(DocumentListFields.documentAuthEmail()).sendKeys(userEmail);
        findByName(DocumentListFields.documentAuthPass()).sendKeys(userPass);
        findByName(DocumentListFields.documentAuthKSIDLogo()).click();
        findByName(DocumentListFields.documentAuthSignInButton()).click();
    }*/

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


    int t = 20;
    int t1 = 20;
    int t2 = 30;
    int t3 = 40;

    @Test(priority = 2)
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


    @Test(priority = 1)
    public void movingAnnotation(){

            TouchAction action = new TouchAction(driver);
            Actions builder = new Actions(driver);

            waitByName(DocumentListFields.documentPreview()).click();
            waitByName(DocumentListFields.documentNavigationNextButton()).click();
            waitByXpath(DocumentListFields.annotation());

        MobileElement slider = (MobileElement) findByXpath(DocumentListFields.documentView());
        MobileElement slider1 = (MobileElement) findByXpath(DocumentListFields.documentView());
        MobileElement slider2 = (MobileElement) findByXpath(DocumentListFields.annotation2());
        Dimension size = slider.getSize();
        Point sizeL = slider.getLocation();

/*        TouchAction swipe = new TouchAction(driver).press(slider, size.width / 8, size.height /118 )
                .waitAction(Duration.ofSeconds(2)).moveTo(slider, 390, size.height / 627).release();
        swipe.perform(); */

/*        TouchAction swipe = new TouchAction(driver).press(slider1, sizeL.x=141, sizeL.y=386 )
                .waitAction(Duration.ofSeconds(2)).moveTo(slider2, sizeL.x=270, sizeL.y=472).release();
        swipe.perform();*/

        TouchAction actvion = action.press(slider,350,390).waitAction(11).moveTo(slider,2,64).release();
        actvion.perform();



/*            Action dragAndDrop = builder.clickAndHold(findByXpath(DocumentListFields.annotation()))
                    .moveToElement(findByXpath(DocumentListFields.annotation2()))
                    .release(findByXpath(DocumentListFields.annotation2()))
                    .build();
            dragAndDrop.perform();
    waitByXpath(DocumentListFields.annotation());
            action.press(findByXpath(DocumentListFields.annotation()));

            action.longPress(findByXpath(DocumentListFields
                    .annotation()))
                    .moveTo(11, 11)
                    .perform()
                    .release();*/

      //  waitByName(DocumentListFields.documentPreview());
    }

}
