package uipages;


import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class Authorisation{



    @iOSFindBy(className = "AuthKSEmail")
    public IOSElement UserEmail;

    @iOSFindBy(className = "AuthKSPass")
    public IOSElement UserPassword;

    @iOSFindBy(className = "Sign in with Keepsolid ID")
    public IOSElement Title;

    @iOSFindBy(className = "KeepsolidIDLogo")
    public IOSElement Logo;

    @iOSFindBy(className = "AuthKSSignIn")
    public IOSElement SignInButton;

    @iOSFindBy(className = "Remember password")
    public IOSElement RememberPass;

    @iOSFindBy(className = "Forgot your password?")
    public IOSElement ForgotPass;

    @iOSFindBy(className = "Create a new KeepSolid ID")
    public IOSElement CreateNewKSID;

    @iOSFindBy(className = "By signing in, you agree to our")
    public IOSElement BySignInYouAgree;

    @iOSFindBy(className = "Terms & Conditions")
    public IOSElement TermsConditions;

    @iOSFindBy(className = "Done")
    public IOSElement DoneButton;



    public void ClickOnUserEmail(){
        this.UserEmail.click();
    }
    public void EnterUserEmail(String UserEmail){
        this.UserEmail.sendKeys(UserEmail);
    }

    public void EnterUserPassword(String UserPassword){
        this.UserPassword.sendKeys(UserPassword);
    }

    public void ClickOnLoginButton(){
        this.DoneButton.click();
    }
}
