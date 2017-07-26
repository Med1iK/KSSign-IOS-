package Contacts;

import findElementMethod.FindUI;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
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

        waitByName(AppMainButtons.contactsMenuButton()).click();
        waitByName(ContactFields.contactInviteButton()).click();

        waitByName(ContactFields.addFromAddressBook()).click();
        waitByName(ContactFields.importContactTitle());
        waitByName(ContactFields.fef1()).click();
        findByName(AppMainButtons.addButton()).click();

        waitByName(AppMainButtons.loadingWheel()).isDisplayed();

    }

    @Test(priority = 3)
    public void  addContactByEmail() {

        waitByName(ContactFields.contactInviteButton()).click();
        waitByName(ContactFields.addByEmail()).click();

        waitByName(ContactFields.addNewContactTitle());
        findByName(ContactFields.addContactFirstName()).sendKeys(userFirstName);
        findByName(ContactFields.addContactLastName()).click();
        findByName(ContactFields.addContactLastName()).sendKeys(userLastName);
        findByName(ContactFields.addContactEmail()).click();
        findByName(ContactFields.addContactEmail()).sendKeys(addUserEmail);

        findByName(AppMainButtons.addButton()).click();
    }


    @Test(priority = 4)
    public void editContactFunc(){

        TouchAction action = new TouchAction(driver);

        MobileElement user1 = (MobileElement) waitByName(ContactFields.fef1());
        MobileElement contactView = (MobileElement) findByXpath(ContactFields.contactView());
        Dimension size = contactView.getSize();
        Dimension size1 = user1.getSize();
        System.out.println(size);

        action
                .press(user1, size1.width*2,size1.height)
                .waitAction(111)
                .moveTo(user1, 1, size1.height)
                .release()
                .perform();

        findByName(ContactFields.editContactAction()).click();
        findByName(ContactFields.addContactFirstName()).sendKeys(updateUserFirstName);
        findByName(ContactFields.addContactLastName()).click();
        findByName(ContactFields.addContactLastName()).sendKeys(updateUserLastName);
        findByName(AppMainButtons.saveButton()).click();
    }


    @Test(priority = 5)
    public void deleteContacts() {

        TouchAction action = new TouchAction(driver);
        TouchAction action1 = new TouchAction(driver);

        MobileElement user1 = (MobileElement) waitByName(ContactFields.fef1());
        MobileElement user2 = (MobileElement) waitByName(ContactFields.wse2());
        MobileElement contactView = (MobileElement) findByXpath(ContactFields.contactView());
        Dimension size = contactView.getSize();
        Dimension size1 = user1.getSize();
        Dimension size2 = user2.getSize();
        System.out.println(size);

        action
                .press(user1, size1.width*2,size1.height)
                .waitAction(111)
                .moveTo(user1, 1, size1.height)
                .release()
                .perform();

        findByName(ContactFields.deleteContactAction()).click();
        waitByName(ContactFields.deleteContactTitle());
        findByName(AppMainButtons.deleteButton()).click();
        waitByName(AppMainButtons.loadingWheel()).isDisplayed();

        action1
                .press(user2,size2.width*2,size2.height)
                .waitAction(111)
                .moveTo(user2,1,size2.height)
                .release()
                .perform();

        findByName(ContactFields.deleteContactAction()).click();
        waitByName(ContactFields.deleteContactTitle());
        findByName(AppMainButtons.deleteButton()).click();
        waitByName(AppMainButtons.loadingWheel()).isDisplayed();
    }
}
