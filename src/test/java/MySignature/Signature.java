package MySignature;


import findElementMethod.FindUI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.MySign.MySignatureFields;

import java.net.MalformedURLException;
import java.time.Duration;


public class Signature extends FindUI{


    public Signature() throws MalformedURLException {
    }

    public String userEmail = "wse1@mailinator.com";
    public String userPass = "qwerty";
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
    public void checkUIOfMySignScreen(){

        waitByName(MySignatureFields.signMenuButton()).click();
        waitByName(MySignatureFields.mySignSynced());
        findByName(MySignatureFields.signMySignMenuButton()).click();
        findByName(MySignatureFields.signMenuButton());
        System.out.println("Menu button has been located");
        findByName(MySignatureFields.signMySignMenuTitle());
        System.out.println("My Signature Titile has been located");
        findByName(MySignatureFields.signNotificationIcon());
        System.out.println("Notification Icon has been located");
        findByName(MySignatureFields.signMySignLabel());
        System.out.println("My Signature label has been checked");
        findByName(MySignatureFields.signMyInitialsLabel());
        System.out.println("My Initials label has been checked");
        findByName(MySignatureFields.signLabelOfMySignView());
        System.out.println("My Signature view has been checked");
        findByName(MySignatureFields.signlabelOfMyInitialsView());
        System.out.println("My Initials view has been checked");
    }


    @Test(priority = 3)
    public void checkUiOfCreateSignatureScreen(){

        findByName(MySignatureFields.signLabelOfMySignView()).click();
        waitByName(MySignatureFields.signNavigationCloseButton());
        System.out.println("Close button has been located");
        findByName(MySignatureFields.signCreateSignTitle());
        System.out.println("Create Sign title has been located");
        findByName(MySignatureFields.signNavigationOkButton());
        System.out.println("Navigation OK button has been located");
        findByName(MySignatureFields.signDrawYourSignHere());
        System.out.println("Draw your sign label has been checked");
        findByName(MySignatureFields.signDrawingView());
        System.out.println("Drawing view has been located");
        findByName(MySignatureFields.signPencilTool()).click();
        System.out.println("Pencil has been located");
        findByName(MySignatureFields.signBrushTool());
        System.out.println("Brush tool has been located");
        findByName(MySignatureFields.signEaserTool());
        System.out.println("Easer has been located");
        findByName(MySignatureFields.signEaserAll());
        System.out.println("Clear all button has been located");
        findByName(MySignatureFields.signPencilTool()).click();
        findByName(MySignatureFields.signPhotoIcon());
        System.out.println("Photo icon has been located");
        findByName(MySignatureFields.signBlackColor()).click();
        System.out.println("Black colour has been located");
        findByName(MySignatureFields.signRedColor());
        System.out.println("Red color has been located");
        findByName(MySignatureFields.signVioletColor());
        System.out.println("Violet color has been located");
        findByName(MySignatureFields.signGreyColor());
        System.out.println("Grey color has been located");
        findByName(MySignatureFields.signBlueColor());
        System.out.println("Blue color has been located");
        findByName(MySignatureFields.signBlackColor()).click();
    }

    @Test(priority = 4)
    public void checDrawingFunctionality(){

        TouchAction action = new TouchAction(driver);
        TouchAction action2 = new TouchAction(driver);

       // waitByXpath(MySignatureFields.signDrawSignWindow());
        MobileElement sign1 = (MobileElement) findByName(MySignatureFields.signDrawingView());

        int signWidth = sign1.getSize().getWidth();
        int signHeight = sign1.getSize().getHeight();
        System.out.println("Width"+signWidth);
        System.out.println("Heigh"+signHeight);


        action
                .press(sign1,1,1)
                .waitAction(111)
                .moveTo(sign1, signWidth, signHeight)
                .release().perform();

        action2
                .press(sign1,1,signHeight-1)
                .waitAction(111)
                .moveTo(sign1,signWidth-1,1)
                .release().perform();

        findByName(MySignatureFields.signNavigationOkButton()).click();
    }

    @Test(priority = 5)
    public void checkSignColor(){

        findByName(MySignatureFields.signLabelOfMySignView()).click();
        if(findByName(MySignatureFields.signBlackColor()).isDisplayed()) {

            System.out.println("Black color has been checked");

        }else {
            System.out.println(ANSI_RED+ "CHECK FUCTIONAL OF SIGNATURE COLOR");
            driver.quit();
        }

        findByName(MySignatureFields.signBlackColor()).click();
        findByName(MySignatureFields.signRedColor()).click();
        findByName(MySignatureFields.signNavigationOkButton()).click();
        waitByName(MySignatureFields.signLabelOfMySignView()).click();


        //Need upgrade this
        if(findByName(MySignatureFields.signNavigationOkButton()).isEnabled()){

            System.out.println("CHECK FUCTIONAL OF NAVIGATION OK BUTTON");
            driver.quit();

        }else {
            findByName(MySignatureFields.signRedColor()).isDisplayed();
            System.out.println("Red color has been checked");
            findByName(MySignatureFields.signRedColor()).click();
            findByName(MySignatureFields.signVioletColor()).click();
            findByName(MySignatureFields.signNavigationOkButton()).click();
            waitByName(MySignatureFields.signLabelOfMySignView()).click();

            findByName(MySignatureFields.signVioletColor()).isDisplayed();
            System.out.println("Violet color has been checked");
            findByName(MySignatureFields.signVioletColor()).click();
            findByName(MySignatureFields.signGreyColor()).click();
            findByName(MySignatureFields.signNavigationOkButton()).click();
            waitByName(MySignatureFields.signLabelOfMySignView()).click();

            findByName(MySignatureFields.signGreyColor()).isDisplayed();
            System.out.println("Grey color has been checked");
            findByName(MySignatureFields.signGreyColor()).click();
            findByName(MySignatureFields.signBlueColor()).click();
            findByName(MySignatureFields.signNavigationOkButton()).click();
            waitByName(MySignatureFields.signLabelOfMySignView()).click();

            findByName(MySignatureFields.signBlueColor()).isDisplayed();
            System.out.println("Blue color has been checked");
            findByName(MySignatureFields.signPencilTool()).click();
            findByName(MySignatureFields.signEaserAll()).click();
            findByName(MySignatureFields.signNavigationOkButton()).click();
        }
    }

    @Test(priority = 6)
    public void createSignByCamera(){

        findByName(MySignatureFields.signLabelOfMySignView()).click();
        waitByName(MySignatureFields.signPhotoIcon()).click();
        waitByName(MySignatureFields.signGetPhotoButton()).click();
        waitByName(MySignatureFields.signCropImageTitle());

        MobileElement cropView = (MobileElement) findByXpath(MySignatureFields.sigCropImageView());
        Dimension size = cropView.getSize();
        System.out.println("Crop view size" + size);

        TouchAction swipe = new TouchAction(driver)
                .press(cropView, size.width / 20, size.height / 20)
                .waitAction(Duration.ofSeconds(2))
                .moveTo(cropView,  size.width / 10, size.height / 50)
                .release();
        swipe.perform();

        findByName(MySignatureFields.signNavigationOkButton()).click();
        waitByName(MySignatureFields.signImageOption());
        waitByName(MySignatureFields.signNavigationOkButton()).click();
        waitByName(MySignatureFields.signLabelOfMySignView()).click();

        if (findByName(MySignatureFields.signBlackColor()).isDisplayed()) {
            System.out.println("Good");
        }else {
            System.out.println(ANSI_RED + "BUG! MY SIGN COLOUR SHOULD BE BLACK!");
        }
        //findByName(MySignatureFields.signNavigationCloseButton()).click();

    }
}
