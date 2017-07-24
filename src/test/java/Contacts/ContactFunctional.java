package Contacts;

import findElementMethod.FindUI;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import org.testng.annotations.Test;
import uipages.Contacts.ContactFields;
import uipages.MainButtons.AppMainButtons;
import uipages.MySign.MySignatureFields;

import static info.userInfo.*;

public class ContactFunctional extends FindUI{

    public ContactFunctional() throws MalformedURLException {
    }

    @BeforeClass
    public void start(){
        Setup();
        wait = new WebDriverWait(driver, 1500);
    }

    @Test//(priority = 1)
            (enabled = false)
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
    public void addContactFromAddressBook(){

        waitByName(AppMainButtons.menuIcon()).click();
        waitByName(AppMainButtons.syncedStatus());

        findByName(AppMainButtons.contactsMenuButton()).click();
        findByName(ContactFields.contactInviteButton()).click();

        waitByName(ContactFields.addFromAddressBook()).click();
        waitByName(ContactFields.importContactTitle());
        findByName(ContactFields.fef1()).click();
        findByName(AppMainButtons.addButton()).click();
      //  waitByName(AppMainButtons.loadingWheel()).isDisplayed();

    }

}
