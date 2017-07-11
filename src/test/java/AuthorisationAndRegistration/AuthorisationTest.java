package AuthorisationAndRegistration;

import findElementMethod.FindUI;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.AuthReg.AuthorisationFields;
import java.net.MalformedURLException;



public class AuthorisationTest extends FindUI{

    public AuthorisationTest() throws MalformedURLException {
    }

    @BeforeClass
    public void start(){
        Setup();
        wait = new WebDriverWait(driver,1500);
    }

/*    @AfterClass
    public void TearDown(){
        driver.quit();
    }*/

    @Test(priority = 1)
    public void checkAllUiElement(){

        findByName(AuthorisationFields.authTitle());
        System.out.println("Title has been checked");
        findByName(AuthorisationFields.authLogo());
        System.out.println("Logo has been checked");
        findByName(AuthorisationFields.authEmail());
        System.out.println("Email field has been checked");
        findByName(AuthorisationFields.authPass());
        System.out.println("Pass field has been checked");
        findByName(AuthorisationFields.authSignInButton());
        System.out.println("SignIn button has been checked");
        findByName(AuthorisationFields.authRememberPass());
        System.out.println("Remember password field has been checked");
        findByName(AuthorisationFields.authForgotPass());
        System.out.println("Forgot pass field has been checked");
        findByName(AuthorisationFields.authCreateNewKSID());
        System.out.println("Create new KS ID field has been checked");
        findByName(AuthorisationFields.authBySignInYouAgree());
        System.out.println("By signing in, you agree to our - has been checked");
        findByName(AuthorisationFields.authTermsConditions());
        System.out.println("Terms and Conditions field has bee checked");

    }


    @Test(priority = 2)
    public void checkTermsAndConditions(){

        findByName(AuthorisationFields.authTermsConditions()).click();
        waitByName(AuthorisationFields.authTermsConditionsCheck());
        findByName(AuthorisationFields.authTermsConditionsCheck());
        findByName(AuthorisationFields.authTermsConditionsCloseButton()).click();

    }


    @Test(priority = 3)
    public void checkRememberPassFunctionality(){

        waitByName(AuthorisationFields.authEmail());
        findByName(AuthorisationFields.authEmail()).click();
        findByName(AuthorisationFields.authEmail()).sendKeys("wse1@mailinator.com");
        findByName(AuthorisationFields.authPass()).sendKeys("qwerty");
        findByName(AuthorisationFields.authLogo()).click();
        findByName(AuthorisationFields.authSignInButton()).click();
        waitByName(AuthorisationFields.authMenuIcon());
        findByName(AuthorisationFields.authMenuIcon()).click();
        waitByName(AuthorisationFields.authSynced());
        runAppInBAckground();
        waitByName(AuthorisationFields.authRecoveryDetailsMail());
        findByName(AuthorisationFields.authPass()).click();
        findByName(AuthorisationFields.authPass()).sendKeys("qwerty");
        findByName(AuthorisationFields.authLogo()).click();
        findByName(AuthorisationFields.authRememberPass()).click();
        findByName(AuthorisationFields.authSignInButton()).click();
        waitByName(AuthorisationFields.authMenuIcon());
        // findByName(AuthorisationFields.authMenuIcon()).click();
        waitByName(AuthorisationFields.authSynced());
        runAppInBAckground();
        waitByName(AuthorisationFields.authMenuIcon());
        waitByName(AuthorisationFields.authSynced());
        findByName(AuthorisationFields.authLogout()).click();
        waitByName(AuthorisationFields.authAreYouSureLogout());
        findByName(AuthorisationFields.authLogout()).click();

    }


    @Test(priority = 4)
    public void failToSignIn(){

        waitByName(AuthorisationFields.authEmail());
        findByName(AuthorisationFields.authEmail()).click();
        findByName(AuthorisationFields.authEmail()).sendKeys("test@test.com");
        findByName(AuthorisationFields.authPass()).sendKeys("qwerty");
        findByName(AuthorisationFields.authDoneButton()).click();

        waitByName(AuthorisationFields.auth1C2O3N());
        findByName(AuthorisationFields.auth1C2O3N()).click();

        waitByName(AuthorisationFields.authFeedBackMessage());
        findByName(AuthorisationFields.authFeedBackMessage());
        System.out.println("Feedback Title has been checked");
        findByName(AuthorisationFields.authSubjectField());
        System.out.println("Subject field has been checked");
        findByName(AuthorisationFields.authMessageBody()).sendKeys("Test");
        System.out.println("Message body has been added");
        findByName(AuthorisationFields.authSend()).click();

        waitByName(AuthorisationFields.authEmail());
        findByName(AuthorisationFields.authEmail()).click();
        findByName(AuthorisationFields.authClearText()).click();
        findByName(AuthorisationFields.authEmail()).sendKeys("test@test.com");
        findByName(AuthorisationFields.authPass()).sendKeys("qwerty");
        findByName(AuthorisationFields.authDoneButton()).click();

        waitByName(AuthorisationFields.auth1C2O3N());
        findByName(AuthorisationFields.auth1C2O3N()).click();
        waitByName(AuthorisationFields.authCancel());
        findByName(AuthorisationFields.authCancel()).click();
        waitByName(AuthorisationFields.authDeleteDraft());
        findByName(AuthorisationFields.authDeleteDraft()).click();

    }

    @Test(priority = 5)
    public void checkForgotPass(){

        waitByName(AuthorisationFields.authForgotPass());
        findByName(AuthorisationFields.authForgotPass()).click();
        waitByName(AuthorisationFields.authPasswordRecovery());
        findByXpath(AuthorisationFields.authRecoveryTextField()).sendKeys("wse1@mailinator.com");
        findByName(AuthorisationFields.authRecoverySendButton()).click();
        waitByName(AuthorisationFields.authRecoveryDetails());
        waitByName(AuthorisationFields.authRecoveryDetailsMail());
        findByName(AuthorisationFields.authRecoveryURL()).sendKeys("mailinator.com");
        findByName(AuthorisationFields.authRecoveryGo()).click();
        waitByName(AuthorisationFields.authRecoveryFreePublicEmail());
        findByXpath(AuthorisationFields.authRecoveryMailinatorInputTextField()).sendKeys("wse1");
        findByName(AuthorisationFields.authRecoveryMailinatorGoButton()).click();
        waitByName(AuthorisationFields.authRecoveryKeepSolidInc());
        System.out.println("Forgot password letter has been located");
        findByName(AuthorisationFields.authRecoveryReturnToKeepSolidSign()).click();

    }


}
