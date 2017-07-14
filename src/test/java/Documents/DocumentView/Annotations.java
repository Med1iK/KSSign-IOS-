package Documents.DocumentView;


import findElementMethod.FindUI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.Documents.DocumentViewFields;
import uipages.MySign.MySignatureFields;

import java.net.MalformedURLException;
import java.time.Duration;

public class Annotations extends FindUI{

    public Annotations() throws MalformedURLException {
    }

    @BeforeClass
    public void start() {
        Setup();
        wait = new WebDriverWait(driver, 1500);
    }

    public static final String ANSI_RED = "\u001B[31m";

    @Test(priority = 1)
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
    public void checkFunctionalityOfSignatureAnnotation(){

        TouchAction action = new TouchAction(driver);
        TouchAction action1 = new TouchAction(driver);
        TouchAction action2 = new TouchAction(driver);
        TouchAction action3 = new TouchAction(driver);

        findByName(DocumentViewFields.docViewAddAnnotationButton()).click();
        findByName(DocumentViewFields.docViewSignatureAnnotation()).click();
        findByName(DocumentViewFields.docViewMeAsSigner()).click();

        MobileElement annotation = (MobileElement) findByXpath(DocumentViewFields.documentView());
        System.out.println(annotation);

        Dimension size = annotation.getSize();
        System.out.println("Doc view size" + size);

        action
                .press(annotation, size.width/2, size.height/2)
                .waitAction(11)
                .moveTo(annotation, 1, 1)
                .release()
                .perform();

        action1
                .press(annotation, 1, 1)
                .release()
                .perform();

        waitByName(DocumentViewFields.docViewCreateSign());

        MobileElement sign = (MobileElement) findByName(MySignatureFields.signDrawingView());
        Dimension drawSize = sign.getSize();
        System.out.println("Draw size" + drawSize);

        action2
                .press(sign,drawSize.width/drawSize.width,drawSize.height/drawSize.height)
                .waitAction(111)
                .moveTo(sign, drawSize.width, drawSize.height)
                .release()
                .perform();

        action3
                .press(sign,drawSize.width/drawSize.width, drawSize.height-1)
                .waitAction(111)
                .moveTo(sign,drawSize.width-1,drawSize.height/drawSize.height)
                .release()
                .perform();

        findByName(DocumentViewFields.docViewNavigOkButton()).click();


        //Don't forget to remove
        waitByName(DocumentViewFields.docViewSaveSignatureTitle());
        findByName(DocumentViewFields.docViewSaveSignatureMessage());
        findByName(DocumentViewFields.docViewDontSaveAction()).click();
    }

    @Test(enabled = false)
    public void checkSaveSignaturePopup(){

        TouchAction action = new TouchAction(driver);
        TouchAction action1 = new TouchAction(driver);

        try {
            waitByName(DocumentViewFields.docViewSaveSignatureTitle());
            findByName(DocumentViewFields.docViewSaveSignatureMessage());
            findByName(DocumentViewFields.docViewDontSaveAction()).click();

            MobileElement annotation = (MobileElement) findByXpath(DocumentViewFields.documentView());
            System.out.println(annotation);
            Dimension size = annotation.getSize();

            action
                    .press(annotation, size.width/100, size.height/100)
                    .release()
                    .perform();

            waitByName(DocumentViewFields.docViewCreateSign());

            MobileElement sign = (MobileElement) findByName(MySignatureFields.signDrawingView());
            Dimension drawSize = sign.getSize();

            action1
                    .press(sign,drawSize.width/drawSize.width,drawSize.height/drawSize.height)
                    .release()
                    .perform();

            findByName(DocumentViewFields.docViewNavigOkButton()).click();

            waitByName(DocumentViewFields.docViewSaveSignatureTitle());
            findByName(DocumentViewFields.docViewSaveAction()).click();

        }catch (NoSuchElementException t){
            System.out.println(ANSI_RED + "No Save Signature popup");
            driver.quit();
        }
    }

    @Test(enabled = false)
    public void checkResizeOfSignatureAnnotation(){

        TouchAction action = new TouchAction(driver);
        TouchAction action1 = new TouchAction(driver);

        MobileElement signatureResize = (MobileElement) findByName(DocumentViewFields.docSignAnnotationResizeIcon());
        Dimension resizeIcon = signatureResize.getSize();
        System.out.println("Resize icon" + resizeIcon);

        action
                .press(signatureResize)
                .waitAction(111)
                .moveTo(signatureResize, resizeIcon.width+200, resizeIcon.height+200)
                .release()
                .perform();

        action1
                .press(signatureResize)
                .waitAction(111)
                .moveTo(signatureResize, resizeIcon.width-200, resizeIcon.height-200)
                .release()
                .perform();

    }



    @Test(enabled = false)
    public void checkFunctionalityOFInitialsAnnotation(){

        TouchAction action = new TouchAction(driver);
        TouchAction action1 = new TouchAction(driver);
        TouchAction action2 = new TouchAction(driver);
        TouchAction action3 = new TouchAction(driver);

        waitByName(DocumentViewFields.docViewAddAnnotationButton()).click();
        findByName(DocumentViewFields.docViewInitialsAnnotation()).click();
        findByName(DocumentViewFields.docViewMeAsSigner()).click();

        MobileElement docView = (MobileElement) findByXpath(DocumentViewFields.documentView());
        System.out.println(docView);

        MobileElement annotation = (MobileElement) findByXpath(DocumentViewFields.docAnnotationView());

        Dimension size = docView.getSize();
        System.out.println("Doc view size" + size);
        Dimension annotationSize = annotation.getSize();

        action
                .press(docView, size.width/2, size.height/2)
                .waitAction(11)
                .moveTo(docView, 1, 7+annotationSize.height)
                .release()
                .perform();


        action1
                .press(docView, 1, 7+annotationSize.height)
                .release()
                .perform();

        waitByName(DocumentViewFields.docViewCreateInitials());

        MobileElement sign = (MobileElement) findByName(MySignatureFields.signDrawingView());
        Dimension drawSize = sign.getSize();
        System.out.println("Draw size" + drawSize);

        action2
                .press(sign,drawSize.width/drawSize.width,drawSize.height/drawSize.height)
                .waitAction(111)
                .moveTo(sign, drawSize.width, drawSize.height)
                .release()
                .perform();

        action3
                .press(sign,drawSize.width/drawSize.width, drawSize.height-1)
                .waitAction(111)
                .moveTo(sign,drawSize.width-1,drawSize.height/drawSize.height)
                .release()
                .perform();

        findByName(DocumentViewFields.docViewNavigOkButton()).click();


        //Don't forget to remove
        waitByName(DocumentViewFields.docViewSaveInitialsTitle());
        findByName(DocumentViewFields.docViewSaveInitialsMessage());
        findByName(DocumentViewFields.docViewDontSaveAction()).click();

    }

    @Test(priority = 4)
    public void checkDateAnnotationFunctional(){

        TouchAction action = new TouchAction(driver);
        TouchAction action1 = new TouchAction(driver);
        TouchAction action2 = new TouchAction(driver);
        TouchAction action3 = new TouchAction(driver);
        TouchAction action4 = new TouchAction(driver);
        TouchAction action5 = new TouchAction(driver);

        findByName(DocumentViewFields.docViewAddAnnotationButton()).click();
        findByName(DocumentViewFields.docViewDateAnnotation()).click();
        findByName(DocumentViewFields.docViewMeAsSigner()).click();

        MobileElement docView = (MobileElement) findByXpath(DocumentViewFields.documentView());
        System.out.println(docView);

        MobileElement dateAnnotation = (MobileElement) findByXpath(DocumentViewFields.docAnnotationView());

        Dimension size = docView.getSize();
        System.out.println("Doc view size" + size);
        Dimension annotationSize = dateAnnotation.getSize();

        ///////
        action4
                .press(docView, size.width/2, size.height/2)
                .waitAction(Duration.ofSeconds(2))
                .release()
                .perform();

        findByName(DocumentViewFields.docActionFont()).click();

/*        MobileElement fontView1 = (MobileElement) findByXpath(DocumentViewFields.fontPickerView1());
        MobileElement fontView2 = (MobileElement) findByXpath(DocumentViewFields.fontPickerView2());
        Dimension fontSize1 = fontView1.getSize();
        Dimension fontSize2 = fontView2.getSize();*/

        action5
                .press(findByXpath(DocumentViewFields.fontMainPicker()), size.width/2, size.height/2)
                .waitAction(Duration.ofSeconds(1))
                .moveTo(findByXpath(DocumentViewFields.fontMainPicker()), size.width, size.height)
                .release()
                .perform();

/*        findByXpath(DocumentViewFields.datePickerWheel1());
        findByXpath(DocumentViewFields.datePickerWheel2()).sendKeys("20");*/


        action
                .press(docView, size.width/2, size.height/2)
                .waitAction(11)
                .moveTo(docView, 1, 2*annotationSize.height)
                .release()
                .perform();


        action1
                .press(docView, 1, 2*annotationSize.height)
                .release()
                .perform();

        findByName(DocumentViewFields.datePickerSetButton()).click();

        action2
                .press(docView, 1, 2*annotationSize.height)
                .release()
                .perform();

        findByName(DocumentViewFields.datePickerClearButton()).click();

        action3
                .press(docView, 1, 2*annotationSize.height)
                .release()
                .perform();

        findByXpath(DocumentViewFields.datePickerWheel1()).sendKeys("December");
        findByXpath(DocumentViewFields.datePickerWheel2()).sendKeys("25");
        findByXpath(DocumentViewFields.datePickerWheel3()).sendKeys("2019");
        findByName(DocumentViewFields.datePickerSetButton()).click();

        ///////////


    }


/*    @AfterClass(timeOut = 50000)
    public void removeSignature(){

        waitByName(DocumentViewFields.docViewNavigationBackButton()).click();
        waitByName(DocumentViewFields.docViewNavigCloseButton()).click();
        waitByName(DocumentViewFields.docViewMenuIcon()).click();
        findByName(DocumentViewFields.docMySignMenuButton()).click();
        waitByName(DocumentViewFields.docMySignView()).click();
        waitByName(DocumentViewFields.docSignPencilTool()).click();
        findByName(DocumentViewFields.docSignEaserAll()).click();
        findByName(DocumentViewFields.docViewNavigOkButton()).click();
        waitByName(DocumentViewFields.docViewMenuIcon()).click();
        waitByName(DocumentViewFields.docViewSynced());
        findByName(DocumentViewFields.documentsMenuButton()).click();
        driver.quit();
    }*/

}
