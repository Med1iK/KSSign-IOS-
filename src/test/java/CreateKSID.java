import findElementMethod.FindUI;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.CreateAkkFields;

import java.net.MalformedURLException;

public class CreateKSID extends FindUI{


    public CreateKSID() throws MalformedURLException {
    }

    @BeforeClass
    public void start(){
        Setup();
        wait = new WebDriverWait(driver,1500);
    }

    public static String createEmail = "ff2fqwer@binka.me";
    public static String createPass = "qwerty";
    public static String firstName = "Johny";
    public static String lastName = "Best";
    public static String company = "KS";
    
    @Test(priority = 1)
    public void checkUiOfCreateKSScreen(){

        findByName(CreateAkkFields.createKSID()).click();
        waitByName(CreateAkkFields.createKSIDTitle());
        findByName(CreateAkkFields.createKSIDTitle());
        System.out.println("Create KS Titile has been checked");
        findByName(CreateAkkFields.createNavigBackButton());
        System.out.println("Navigation back button has been checked");
        findByName(CreateAkkFields.createKSIDLogo());
        System.out.println("KS Logo icon has been checked");
        findByName(CreateAkkFields.createKSEmail());
        System.out.println("Email field has been checked");
        findByName(CreateAkkFields.createKSPass());
        System.out.println("Pass field has been checked");
        findByName(CreateAkkFields.createKSRepeatPass());
        System.out.println("Repeat pass has been checked");
        findByName(CreateAkkFields.createKSSignUpButton());
        System.out.println("Next button has been checked");
        findByName(CreateAkkFields.createBySignUpYouAgree());
        System.out.println("By signing up message has been checked");
        findByName(CreateAkkFields.createTermsConditions());
        System.out.println("Terms&Conditions link has been checked");

    }

    @Test(priority = 2)
    public void fillUpCreateKSIDForm(){

        findByName(CreateAkkFields.createKSEmail()).click();
        findByName(CreateAkkFields.createKSEmail()).sendKeys(createEmail);
        findByName(CreateAkkFields.createKSPass()).sendKeys(createPass);
        findByName(CreateAkkFields.createKSRepeatPass()).sendKeys(createPass);
        findByName(CreateAkkFields.createKSIDLogo()).click();
        findByName(CreateAkkFields.createKSSignUpButton()).click();
    }

    @Test(priority = 3)
    public void checkUIofRequiredInfoScreen(){

        findByName(CreateAkkFields.createKSReqTitle());
        System.out.println("Required Titile has been checked");
        findByName(CreateAkkFields.createNavigBackButton());
        System.out.println("Navigation back button has been checked");
        findByName(CreateAkkFields.createKSReqInfoFirstName());
        System.out.println("First Name field has been checked");
        findByName(CreateAkkFields.createKSReqInfoLastName());
        System.out.println("Last Name field has been checked");
        findByName(CreateAkkFields.createKSReqInfoCompany());
        System.out.println("Company field has been checked");
        findByName(CreateAkkFields.createKSReqInfoSignUp());
        System.out.println("Sign up button has been checked");
        findByName(CreateAkkFields.createBySignUpYouAgree());
        System.out.println("By signing up message has been checked");
        findByName(CreateAkkFields.createTermsConditions());
        System.out.println("Terms&Conditions link has been checked");

    }

    @Test(priority = 4)
    public void fillUpRequiredInfoForm(){

        findByName(CreateAkkFields.createKSReqInfoFirstName()).sendKeys(firstName);
        findByName(CreateAkkFields.createKSReqInfoLastName()).click();
        findByName(CreateAkkFields.createKSReqInfoLastName()).sendKeys(lastName);
        findByName(CreateAkkFields.createKSReqInfoCompany()).click();
        findByName(CreateAkkFields.createKSReqInfoCompany()).sendKeys(company);
        findByName(CreateAkkFields.createKSReqInfoDoneButton()).click();
        waitByName(CreateAkkFields.createMenuIcon());
        findByName(CreateAkkFields.createMenuIcon()).click();
        waitByName(CreateAkkFields.createSynced());
        findByName(CreateAkkFields.createLogout()).click();
        waitByName(CreateAkkFields.createAreYouSureLogout());
        findByName(CreateAkkFields.createLogout()).click();

    }

}
