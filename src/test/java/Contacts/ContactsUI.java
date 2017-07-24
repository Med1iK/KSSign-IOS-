package Contacts;


import findElementMethod.FindUI;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.Contacts.ContactFields;
import uipages.MainButtons.AppMainButtons;
import uipages.MySign.MySignatureFields;

import java.net.MalformedURLException;

import static info.userInfo.*;


public class ContactsUI extends FindUI {
    public ContactsUI() throws MalformedURLException {
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
    public void checkUIOfContactList() throws InterruptedException {

        waitByName(AppMainButtons.menuIcon()).click();

        waitByName(AppMainButtons.syncedStatus());

        Assert.assertEquals(findByName(AppMainButtons.syncedStatus()).getAttribute("value"), synced);

        findByName(AppMainButtons.contactsMenuButton()).click();

        findByName(AppMainButtons.menuIcon());
        findByName(ContactFields.contactsTitle());
        findByName(ContactFields.contactInviteButton());
        System.out.println("Contacts navigation bar has been checked");

        findByName(AppMainButtons.searchField());
        System.out.println("Search field has been checked");

        findByName(ContactFields.noContactIcon());
        findByName(ContactFields.noContactText());
        System.out.println("No contact Icon with text has been checked");

    }

    @Test(priority = 3)
    public void checkUIOfAddNewContactActionSheet(){

        findByName(ContactFields.contactInviteButton()).click();

        findByName(ContactFields.addNewContactTitle());
        findByName(ContactFields.addFromAddressBook());
        findByName(ContactFields.addByEmail());
        findByName(AppMainButtons.cancelButton());
        System.out.println("Add a new contact action sheet has been checked");

        findByName(AppMainButtons.cancelButton()).click();
    }

    @Test(priority = 4)
    public void checkUIOfAddNewContactViaEmail(){

        waitByName(ContactFields.contactInviteButton()).click();
        waitByName(ContactFields.addByEmail()).click();

        waitByName(ContactFields.addNewContactTitle());
        findByName(ContactFields.addContactFirstName());
        findByName(ContactFields.addContactLastName());
        findByName(ContactFields.addContactEmail());

        findByName(AppMainButtons.addButton());
        findByName(AppMainButtons.cancelButton());
        System.out.println("UI of Add new contact via Email has been checked");

        findByName(AppMainButtons.cancelButton()).click();
    }

    @Test(priority = 5)
    public void checkUIOfAddNewContactViaAddressBook(){

        findByName(ContactFields.contactInviteButton()).click();
        waitByName(ContactFields.addFromAddressBook()).click();

        try {
            findByName(ContactFields.wouldYouLikeToAcessContact());
            findByName(AppMainButtons.allowButton()).click();
        }catch (NoSuchElementException f){

            findByName(ContactFields.importContactTitle());
            findByName(AppMainButtons.navigBackButton());
            System.out.println("Address book navigation bar has been checked");
        }
        findByName(AppMainButtons.navigBackButton()).click();
    }
}
