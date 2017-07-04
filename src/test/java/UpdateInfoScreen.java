import findElementMethod.FindUI;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.UpAction;
import org.openqa.selenium.remote.server.handler.interactions.touch.Up;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.UpdateInfoFields;

import java.net.MalformedURLException;

public class UpdateInfoScreen extends FindUI{

    public UpdateInfoScreen() throws MalformedURLException {
    }

    @BeforeClass
    public void start(){
        Setup();
        wait = new WebDriverWait(driver,1500);
    }

    public static String userEmail = "wse4@mailinator.com";
    public static String userPass = "qwerty";
    public static String firstName = "Johny";
    public static String lastName = "Best";
    public static String company = "KS";


    @Test(priority = 1)
    public void authorise(){

        waitByName(UpdateInfoFields.updateInfoEmail());
        findByName(UpdateInfoFields.updateInfoEmail()).click();
        findByName(UpdateInfoFields.updateInfoEmail()).sendKeys(userEmail);
        findByName(UpdateInfoFields.updateInfoPass()).sendKeys(userPass);
        findByName(UpdateInfoFields.updateKSIDLogo()).click();
        findByName(UpdateInfoFields.updateInfoSignInButton()).click();

    }

    @Test(priority = 2)
    public void checkUIofUpdateInfoScreen(){

        waitByName(UpdateInfoFields.updateInfoTitle());
        findByName(UpdateInfoFields.updateInfoTitle());
        System.out.println("Title has been checked");
        findByName(UpdateInfoFields.updateInfoFirstName());
        System.out.println("First name field has been checked");
        findByName(UpdateInfoFields.updateInfoLastName());
        System.out.println("Last name has been checked");
        findByName(UpdateInfoFields.updateInfoCompany());
        System.out.println("Company has been checked");
        findByName(UpdateInfoFields.updateInfoUpdateButton());
        System.out.println("Update button has been checked");
        findByName(UpdateInfoFields.updateInfoChangeAkk());
        System.out.println("Change account button has been checked");
    }


    @Test(priority = 3)
    public void checkFunctionalityOfLockScreen(){

        runAppInBAckground();
        waitByName(UpdateInfoFields.updateKSIDLogo());
        findByName(UpdateInfoFields.updateInfoPass()).click();
        findByName(UpdateInfoFields.updateInfoPass()).sendKeys(userPass);
        findByName(UpdateInfoFields.updateInfoDoneButton()).click();

    }

    @Test(priority = 4)
    public void checkChangeAkkfunctionality(){

        waitByName(UpdateInfoFields.updateInfoTitle());
        findByName(UpdateInfoFields.updateInfoChangeAkk()).click();
        waitByName(UpdateInfoFields.updateInfoLogOutTitle());
        findByName(UpdateInfoFields.updateInfoCancelButton()).click();
        findByName(UpdateInfoFields.updateInfoChangeAkk()).click();
        waitByName(UpdateInfoFields.updateInfoLogOutTitle());
        findByName(UpdateInfoFields.updateInfoLogOutTitle());
        findByName(UpdateInfoFields.updateInfoLogOutMEssage());
        findByName(UpdateInfoFields.updateInfoLogOutButton()).click();
    }

    @Test(priority = 5)
    public void relog(){

        waitByName(UpdateInfoFields.updateInfoEmail());
        findByName(UpdateInfoFields.updateInfoEmail()).click();
        findByName(UpdateInfoFields.updateInfoEmail()).sendKeys(userEmail);
        findByName(UpdateInfoFields.updateInfoPass()).sendKeys(userPass);
        findByName(UpdateInfoFields.updateKSIDLogo()).click();
        findByName(UpdateInfoFields.updateInfoSignInButton()).click();

    }

    @Test(priority = 6)
    public void fillUpReqInfoScreen(){

        waitByName(UpdateInfoFields.updateInfoFirstName());
        findByName(UpdateInfoFields.updateInfoFirstName()).sendKeys(firstName);
        findByName(UpdateInfoFields.updateInfoLastName()).click();
        findByName(UpdateInfoFields.updateInfoLastName()).sendKeys(lastName);
        findByName(UpdateInfoFields.updateInfoCompany()).click();
        findByName(UpdateInfoFields.updateInfoCompany()).sendKeys(company);
        findByName(UpdateInfoFields.updateInfoDoneButton()).click();
        waitByName(UpdateInfoFields.updateMenuIcon());
        findByName(UpdateInfoFields.updateMenuIcon()).click();
        waitByName(UpdateInfoFields.updateSynced());
        findByName(UpdateInfoFields.updateLogout()).click();
        waitByName(UpdateInfoFields.updateInfoLogOutTitle());
        findByName(UpdateInfoFields.updateInfoLogOutMEssage());
        findByName(UpdateInfoFields.updateInfoLogOutButton()).click();
        findByName(UpdateInfoFields.updateInfoLogOutButton()).click();
    }
}
