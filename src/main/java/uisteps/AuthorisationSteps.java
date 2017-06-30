package uisteps;


import net.thucydides.core.annotations.Step;
import uipages.Authorisation;


public class AuthorisationSteps {

    Authorisation authorisation;



    @Step
    public void ClickOnUserEmail(){authorisation.ClickOnUserEmail();}

    @Step
    public void EnterUserEmail(String UserEmail){
        authorisation.EnterUserEmail(UserEmail);
    }

    @Step
    public void EnterUserPassword(String UserPassword){
        authorisation.EnterUserPassword(UserPassword);
    }

    @Step
    public void ClickOnLoginButton(){
        authorisation.ClickOnLoginButton();
    }

}
