package Documents.DocumentInfo;


import findElementMethod.FindUI;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import uipages.Documents.DocumentInfoFields;
import uipages.Documents.DocumentViewFields;
import uipages.MainButtons.AppMainButtons;
import uipages.MySign.MySignatureFields;

import java.net.MalformedURLException;

import static info.userInfo.*;


public class DocInfoDraft extends FindUI{
    public DocInfoDraft() throws MalformedURLException {
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
    public void checkAvailabilityOfTheDoc(){

        waitByName(AppMainButtons.menuIcon()).click();
        waitByName(AppMainButtons.syncedStatus());
        findByName(AppMainButtons.menuIcon()).click();

        try{
            findByName(DocumentViewFields.docViewNoDocumenttsPlaceholderIcon()).isDisplayed();
            findByName(DocumentViewFields.docAddDocPlusButton()).click();
            findByXpath(DocumentViewFields.cameraButton()).click();
            waitByName(DocumentViewFields.cameraGetPhoto()).click();
            findByName(DocumentViewFields.cameraNavigationOkButton()).click();
            waitByName(DocumentViewFields.cameraNavigationOkButton()).click();
            waitByName(DocumentViewFields.cameraNavigationOkButton()).click();
          //  waitByName(DocumentViewFields.docInfoNextButton()).click();

        }catch (NoSuchElementException f) {

            findByName(DocumentViewFields.docUnnamedTitle()).click();
          //  waitByName(DocumentViewFields.docInfoNextButton()).click();
        }
    }


    @Test(priority = 3)
    public void checkUIOfDraftDocInfo(){

        findByName(AppMainButtons.navigationCloseButton());
        findByName(AppMainButtons.nextButton());
        System.out.println("Navigation toolbar has been checked");

        findByName(DocumentInfoFields.docNameUnnamed());
        findByName(DocumentInfoFields.participants(zero));
        System.out.println("Doc name and participant has been checked");

        findByName(DocumentInfoFields.createdDate());
        findByName(DocumentInfoFields.documentStatus());
        findByName(DocumentInfoFields.documentStatusDraft());

        findByName(DocumentInfoFields.enterAMessage()).click();
        findByName(AppMainButtons.navigBackButton());
        findByName(DocumentInfoFields.editMessageTitile());
        findByName(AppMainButtons.navigationOkButton()).click();
        System.out.println("Edit message UI has been checked");

        findByName(DocumentInfoFields.signingSettings());
        findByName(DocumentInfoFields.fixedSignerOrder());
        findByName(DocumentInfoFields.signOrderSwitch());

        findByName(DocumentInfoFields.author());
        findByName(DocumentInfoFields.authorEmail());

        findByName(DocumentInfoFields.deleteTheDocument());

        findByName(DocumentInfoFields.addParticipantIcon());
        findByName(DocumentInfoFields.addParticipantButtonName());
        findByName(DocumentInfoFields.addParticipantButton());

        System.out.println("UI of Draft Doc info has been checked");
    }


    //Реализовать правильные сценарий используя в методах "value" с удалением сайнеров или обзерверов
}
