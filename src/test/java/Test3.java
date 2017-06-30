import findElementMethod.FindUI;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.AuthorisationFields;

import java.net.MalformedURLException;

public class Test3 extends FindUI {


    public Test3() throws MalformedURLException {
    }

    @BeforeClass
    public void start(){
        Setup();
        wait = new WebDriverWait(driver,1500);
    }

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
}
