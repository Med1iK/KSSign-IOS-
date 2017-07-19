package Documents.DocumentView;


import findElementMethod.FindUI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import uipages.Documents.DocumentViewFields;
import uipages.MySign.MySignatureFields;

import java.awt.dnd.DragSourceDropEvent;
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
    public static String regular = "Regular, 1 of 4";
    public static String bold = "Bold, 2 of 4";
    public static String italic = "Italic, 3 of 4";
    public static String boldItalic = "Bold Italic, 4 of 4";

    public static String defaultFontSize = "12, 5 of 293";
    public static String fontSize13 = "13, 6 of 293";
    public static String fontSize14 = "14, 7 of 293";
    public static String fontSize15 = "15, 8 of 293";

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
         //   (enabled = false)
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
/*        waitByName(DocumentViewFields.docViewSaveSignatureTitle());
        findByName(DocumentViewFields.docViewSaveSignatureMessage());
        findByName(DocumentViewFields.docViewDontSaveAction()).click();*/
    }

    @Test(priority = 3)
         //   (enabled = false)
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

    @Test(priority = 4)
         //   (enabled = false)
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

    @Test(priority = 5)
         //   (enabled = false)
    public void checkFunctionalityOFInitialsAnnotation(){

        TouchAction action = new TouchAction(driver);
        TouchAction action1 = new TouchAction(driver);
        TouchAction action2 = new TouchAction(driver);
        TouchAction action3 = new TouchAction(driver);
        TouchAction action4 = new TouchAction(driver);

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

    @Test(priority = 6)
         //   (enabled = false)
    public void checkDateAnnotationFunctional(){

        TouchAction action = new TouchAction(driver);
        TouchAction action1 = new TouchAction(driver);
        TouchAction action2 = new TouchAction(driver);
        TouchAction action3 = new TouchAction(driver);
        TouchAction action4 = new TouchAction(driver);
        TouchAction action5 = new TouchAction(driver);
        TouchAction action6 = new TouchAction(driver);
        TouchAction action7 = new TouchAction(driver);
        TouchAction action8 = new TouchAction(driver);
        TouchAction action9 = new TouchAction(driver);

        findByName(DocumentViewFields.docViewAddAnnotationButton()).click();
        findByName(DocumentViewFields.docViewDateAnnotation()).click();
        findByName(DocumentViewFields.docViewMeAsSigner()).click();

        MobileElement docView = (MobileElement) findByXpath(DocumentViewFields.documentView());
        System.out.println(docView);

        MobileElement dateAnnotation = (MobileElement) findByXpath(DocumentViewFields.docAnnotationView());

        Dimension size = docView.getSize();
        System.out.println("Doc view size" + size);
        Dimension annotationSize = dateAnnotation.getSize();

        action
                .press(docView, size.width/2, size.height/2)
                .waitAction(Duration.ofSeconds(2))
                .release()
                .perform();

        findByName(DocumentViewFields.docActionFont()).click();

        MobileElement setFont = (MobileElement) waitByXpath(DocumentViewFields.fontPickerView1());
        Dimension sizeOfFontView = setFont.getSize();
        System.out.println(sizeOfFontView);
        MobileElement setSize = (MobileElement) waitByXpath(DocumentViewFields.fontPickerView2());
       // Dimension sizeOfSetSize = setSize.getSize();

        Assert.assertEquals(setFont.getAttribute("value"), regular);
        Assert.assertEquals(setSize.getAttribute("value"), defaultFontSize);

        action1
                .press(setFont, size.width/10,size.height/5)
                .waitAction(111)
                .moveTo(setFont, size.width/10, size.height/10)
                .release()
                .perform();
        Assert.assertEquals(setFont.getAttribute("value"),bold);

        //Italic
        action2
                .press(setFont, size.width/10,size.height/5)
                .waitAction(111)
                .moveTo(setFont, size.width/10, size.height/10)
                .release()
                .perform();
        Assert.assertEquals(setFont.getAttribute("value"), italic);

        //Bold Italic
        action3
                .press(setFont, size.width/10, size.height/5)
                .waitAction(111)
                .moveTo(setFont, size.width/10,size.height/10)
                .release()
                .perform();
        Assert.assertEquals(setFont.getAttribute("value"), boldItalic);

        action4
                .press(setSize, size.width/10, size.height/5)
                .waitAction(111)
                .moveTo(setSize, size.width/10, size.height/10)
                .release()
                .perform();
        Assert.assertEquals(setSize.getAttribute("value"), fontSize13);

        findByXpath(DocumentViewFields.docVIEw()).click();

        action5
                .press(docView, size.width/2, size.height/2)
                .waitAction(11)
                .moveTo(docView, 1, 2*annotationSize.height)
                .release()
                .perform();

        action6
                .press(docView, 1, 2*annotationSize.height)
                .release()
                .perform();

        findByName(DocumentViewFields.datePickerSetButton()).click();

        action7
                .press(docView, 1, 2*annotationSize.height)
                .release()
                .perform();

        findByName(DocumentViewFields.datePickerClearButton()).click();

        action8
                .press(docView, 1, 2*annotationSize.height)
                .release()
                .perform();

        findByXpath(DocumentViewFields.datePickerWheel1()).sendKeys("December");
        findByXpath(DocumentViewFields.datePickerWheel2()).sendKeys("25");
        findByXpath(DocumentViewFields.datePickerWheel3()).sendKeys("2019");
        findByName(DocumentViewFields.datePickerSetButton()).click();
    }


    @Test(priority = 7)
          //(enabled = false)
    public void checkFunctionalOfCheckMarkAnnotation(){

        TouchAction action = new TouchAction(driver);
        TouchAction action1 = new TouchAction(driver);
        TouchAction action2 = new TouchAction(driver);
        TouchAction action3 = new TouchAction(driver);
        TouchAction action4 = new TouchAction(driver);

        findByName(DocumentViewFields.docViewAddAnnotationButton()).click();
        findByName(DocumentViewFields.docViewCheckmarkAnnotatin()).click();
        findByName(DocumentViewFields.docViewMeAsSigner()).click();

        MobileElement docView = (MobileElement) findByXpath(DocumentViewFields.documentView());
        System.out.println(docView);

        MobileElement checkMarkAnnotation = (MobileElement) findByXpath(DocumentViewFields.docAnnotationView());

        Dimension size = docView.getSize();
        System.out.println("Doc view size" + size);
        Dimension annotationSize = checkMarkAnnotation.getSize();
        System.out.println(annotationSize);

        action
                .press(docView, size.width/2, size.height/2)
                .release()
                .perform();
        findByName(DocumentViewFields.checkMarkNO()).click();

        action1
                .press(docView, size.width/2, size.height/2)
                .release()
                .perform();
        findByName(DocumentViewFields.checkMarkYES()).click();



/*        MobileElement checkMarkResize = (MobileElement) findByName(DocumentViewFields.checkMarkRecize());
        Dimension resizeIcon = checkMarkResize.getSize();
        System.out.println("Resize icon" + resizeIcon);

        action2
                .press(checkMarkResize)
                .waitAction(111)
                .moveTo(checkMarkResize, resizeIcon.width+200, resizeIcon.height+200)
                .release()
                .perform();

        action3
                .press(checkMarkResize)
                .waitAction(111)
                .moveTo(checkMarkResize, resizeIcon.width-200, resizeIcon.height-200)
                .release()
                .perform();*/

        action2
                .press(docView, size.width/2, size.height/2)
                .waitAction(111)
                .moveTo(docView, 5, size.height/2)
                .release()
                .perform();

        MobileElement docView1 = (MobileElement) findByXpath(DocumentViewFields.documentView());

        try {
            action3
                    .tap(docView1, 1, size.height/2)
                    .release()
                    .perform();
            findByName(DocumentViewFields.checkMarkYES()).click();
        }catch (NoSuchElementException f){

            System.out.println(ANSI_RED+"CheckMark annotation doesn't move");
            action4
                    .press(docView,1,size.height/2)
                    .waitAction(Duration.ofSeconds(2))
                    .release()
                    .perform();
            findByName(DocumentViewFields.docActionRemove()).click();
        }

    }

    public String textValue = "Hello World!";

    @Test(priority = 8)
    public void checkFuntionalityOfTextAnnotation(){

        TouchAction action = new TouchAction(driver);
        TouchAction action1 = new TouchAction(driver);
        TouchAction action2 = new TouchAction(driver);
        TouchAction action3 = new TouchAction(driver);
        TouchAction action4 = new TouchAction(driver);
        TouchAction action5 = new TouchAction(driver);
        TouchAction action6 = new TouchAction(driver);
        TouchAction action7 = new TouchAction(driver);
        TouchAction action8 = new TouchAction(driver);

        waitByName(DocumentViewFields.docViewAddAnnotationButton()).click();
        findByName(DocumentViewFields.docViewTextAnnotation()).click();
        findByName(DocumentViewFields.docViewMeAsSigner()).click();

        MobileElement docView = (MobileElement) findByXpath(DocumentViewFields.documentView());
        System.out.println(docView);

        MobileElement textAnnotation = (MobileElement) findByXpath(DocumentViewFields.docAnnotationView());

        Dimension size = docView.getSize();
        System.out.println("Doc view size" + size);
        Dimension annotationSize = textAnnotation.getSize();
        System.out.println(annotationSize);

        action
                .press(docView, size.width/2, size.height/2)
                .waitAction(Duration.ofSeconds(2))
                .release()
                .perform();

        findByName(DocumentViewFields.docActionFont()).click();

        MobileElement setFont = (MobileElement) waitByXpath(DocumentViewFields.fontPickerView1());
        Dimension sizeOfFontView = setFont.getSize();
        System.out.println(sizeOfFontView);
        MobileElement setSize = (MobileElement) waitByXpath(DocumentViewFields.fontPickerView2());
        // Dimension sizeOfSetSize = setSize.getSize();

        Assert.assertEquals(setFont.getAttribute("value"), regular);
        Assert.assertEquals(setSize.getAttribute("value"), defaultFontSize);

        action1
                .press(setFont, size.width/10,size.height/5)
                .waitAction(111)
                .moveTo(setFont, size.width/10, size.height/10)
                .release()
                .perform();
        Assert.assertEquals(setFont.getAttribute("value"),bold);

        //Italic
        action2
                .press(setFont, size.width/10,size.height/5)
                .waitAction(111)
                .moveTo(setFont, size.width/10, size.height/10)
                .release()
                .perform();
        Assert.assertEquals(setFont.getAttribute("value"), italic);

        //Bold Italic
        action3
                .press(setFont, size.width/10, size.height/5)
                .waitAction(111)
                .moveTo(setFont, size.width/10,size.height/10)
                .release()
                .perform();
        Assert.assertEquals(setFont.getAttribute("value"), boldItalic);

        action4
                .press(setSize, size.width/10, size.height/5)
                .waitAction(111)
                .moveTo(setSize, size.width/10, size.height/10)
                .release()
                .perform();
        Assert.assertEquals(setSize.getAttribute("value"), fontSize13);

        findByXpath(DocumentViewFields.docVIEw()).click();

        action5
                .tap(docView, size.width/2,size.height/2)
                .release()
                .perform();

        waitByName(DocumentViewFields.editTextTitle());
        findByXpath(DocumentViewFields.editTextView()).sendKeys("Hello World");
        findByName(DocumentViewFields.docViewNavigOkButton()).click();

        action6
                .longPress(docView,size.width/2,size.height/2)
                .release()
                .perform();

        findByName(DocumentViewFields.docActionEdit()).click();
        waitByName(DocumentViewFields.editTextTitle());
        findByXpath(DocumentViewFields.editTextView()).sendKeys("!");

        MobileElement editViewCheck = (MobileElement) findByXpath(DocumentViewFields.editTextView());

        Assert.assertEquals(editViewCheck.getAttribute("value"), textValue);

        findByName(DocumentViewFields.docViewNavigOkButton()).click();

        action7
                .press(docView,size.width/2,size.height/2)
                .waitAction(111)
                .moveTo(docView,3,annotationSize.height*3)
                .release()
                .perform();

    }

    @AfterClass(timeOut = 50000)
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
    }

}
