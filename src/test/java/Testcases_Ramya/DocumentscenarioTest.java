package Testcases_Ramya;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Documents;
import Pages.DocumentsScenarios;
import Pages.Entities;
import Pages.Login;
import Pages.Newdocument;
import Pages.Nsuidocuments;
import Pages.Recieverside;
import Pages.RetryAnalyzer;
import TestBase.Testcasebase;
import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("unused")
public class DocumentscenarioTest extends Testcasebase {
	Login login;
	Documents documents;
	DocumentsScenarios documentsScenarios;
	Recieverside recieverside;
	Nsuidocuments nsuidocuments;
	Newdocument newdocument;
	Entities entities;
	
	

@BeforeMethod
public  void initialize() {
	setUpchrome();
	login = new Login(driver);
	documents = new Documents(driver);
	documentsScenarios = new DocumentsScenarios(driver);
	recieverside = new Recieverside(driver);
	
}

@Test()
public void VerifyLoginFunctionalityWithValidCredantials() throws InterruptedException {
//	System.out.println("Testing");
	login.Signin();
	login.VerifyLoginSucess();
//	Assert.assertEquals(true, false);

}
// rearrange to approver other signers and sender without enforce and without autofill
@Test(priority = 30)
public void VerifyAppSigSenderorderWOEWOA() throws Exception {
    String a="VerifyAppSigSenderorderWOEWOA";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
//	documentsScenarios.RecipientSigner(2,"Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
//	documentsScenarios.RecipientSigner(3,"Receiver", "ramyasibbala200@outlook.com", "APPROVER");
//	documentsScenarios.Rearranges(3,1);
//	documentsScenarios.Rearranges(0, 1);
//	documentsScenarios.Rearranges(1,3);
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,60,10,90);
//	documentsScenarios.DradAndDropSigAndFullName(3,10,-20,10,10);
//	documentsScenarios.DradAndDropSigAndFullName(4,10,-100,10,-70);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
//	documentsScenarios.Blankwithoutsenderautofill();
//	recieverside.prudhvioutlooklogin();
//	recieverside.clickEmail(a);
//	recieverside.reviewSigner();
//	recieverside.reviewandSign("Prudvi");
//	recieverside.FinishDocumentRecieverside();
//	documentsScenarios.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
//	recieverside.clickEmail(a);
//	recieverside.reviewSigner();
//	recieverside.reviewandSign("Jeevitha");
//	recieverside.FinishDocumentRecieverside();
//	documentsScenarios.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//	recieverside.clickEmail(a);
//	recieverside.reviewandSignApprover();
//	recieverside.reviewandSign("Ramya");
//	recieverside.Approvedocument();
//	System.out.println("Testing");
//	Assert.assertEquals(false, true);
}
//rearrange to sender other signers and cc without enforce and without autofill
@Test(priority = 31)
public void VerifySendersigCCorderWOEWOA() throws Exception {
	String a="VerifySendersigCCorderWOEWOA";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autofilloff();
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver","prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(2,"Receiver","jeevithapatnana200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(3,"Receiver","ramyasibbala200@outlook.com", "CC");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,60,10,90);
	documentsScenarios.DradAndDropSigAndFullName(3,10,-20,10,10);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Jeevitha");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
	recieverside.documentcompleted(a);
}
//rearrange to other signers and sender cc without enforce and without autofill
@Test(priority = 32)
public void VerifySigSenderCCorderWOEWOA() throws Exception {
	String a="VerifySigSenderCCorderWOEWOA";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(2,"Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(3,"Receiver", "ramyasibbala200@outlook.com", "CC");
	documentsScenarios.Rearranges(2,1);
	documentsScenarios.Rearranges(0,1);
	documentsScenarios.Rearranges(1,2);
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,60,10,90);
	documentsScenarios.DradAndDropSigAndFullName(3,10,-20,10,10);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Jeevitha");
	recieverside.FinishDocumentRecieverside();;
	documentsScenarios.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
	recieverside.documentcompleted(a);

}
//rearrange to cc and sender  other signers without enforce and without autofill
@Test(priority = 33)
public void VerifyCCSenderSingerWOEWOA() throws Exception {
	String a="VerifyCCSenderSingerWOEWOA";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(2,"Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(3,"Receiver", "ramyasibbala200@outlook.com", "CC");
	documentsScenarios.Rearranges(3,1);
	documentsScenarios.Rearranges(0,1);
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(2,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(3,10,60,10,90);
	documentsScenarios.DradAndDropSigAndFullName(4,10,-20,10,10);
	recieverside.SubDocScenarios(a);;
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Meghana");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
	recieverside.documentcompleted(a);

}
//rearrange to signer cc and sender without enforce and without autofill
@Test(priority = 34)
public void VerifySingerCCSenderWOEWOA() throws Exception {
	String a="VerifySingerCCSenderWOEWOA";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(2,"Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(3,"Receiver", "ramyasibbala200@outlook.com", "CC");
	documentsScenarios.Rearranges(2,1);
	documentsScenarios.Rearranges(0,1);
	documentsScenarios.Rearranges(1,3);
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,60,10,90);
	documentsScenarios.DradAndDropSigAndFullName(4,10,-20,10,10);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Jeevitha");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
	recieverside.documentcompleted(a);

}
//rearrange to sender cc and signers without enforce and without autofill
@Test(priority = 35)
public void VerifySenderCCSignerWOEWOA() throws Exception {
	String a="VerifySenderCCSignerWOEWOA";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(2,"Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(3,"Receiver", "ramyasibbala200@outlook.com", "CC");
	documentsScenarios.Rearranges(3,1);
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(3,10,60,10,90);
	documentsScenarios.DradAndDropSigAndFullName(4,10,-20,10,10);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Jeevitha");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
	recieverside.documentcompleted(a);
}
//rearrange to cc and other signers sender without enforce and without autofill
@Test(priority = 36)
public void VerifyCCSignerSenderWOEWOA() throws Exception {
	String a="VerifyCCSignerSenderWOEWOA";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(2,"Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(3,"Receiver", "ramyasibbala200@outlook.com", "CC");
	documentsScenarios.Rearranges(3,1);
	documentsScenarios.Rearranges(0,1);
	documentsScenarios.Rearranges(1,3);
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(2,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(3,10,60,10,90);
	documentsScenarios.DradAndDropSigAndFullName(4,10,-20,10,10);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Jeevitha");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
	recieverside.documentcompleted(a);
	

}
//rearrange to sender multiple approvers without enforce and without autofill
@Test(priority = 37)
public void VerifySenderMultipleApprovers() throws Exception {
	String a="VerifySenderMultipleApprovers";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "APPROVER");
	documentsScenarios.RecipientSigner(2,"Receiver", "ramyasibbala200@outlook.com", "APPROVER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,60,10,90);
	documentsScenarios.DradAndDropSigAndFullName(3,10,-20,10,10);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewandSignApprover();
	recieverside.reviewandSign("Prudvi");
	recieverside.Approvedocument();
	documentsScenarios.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewandSignApprover();
	recieverside.reviewandSign("Ramya");
	recieverside.Approvedocument();
	
	}
//rearrange to multiple approvers sender without enforce and without autofill
@Test(priority = 38)
public void VerifyMultpleApproverSender() throws Exception {
    String a="VerifyMultpleApproverSender";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "APPROVER");
	documentsScenarios.RecipientSigner(2,"Receiver", "ramyasibbala200@outlook.com", "APPROVER");
	documentsScenarios.Rearranges(2,0);
	documentsScenarios.Rearranges(2,1);
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,60,10,90);
	documentsScenarios.DradAndDropSigAndFullName(3,10,-20,10,10);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewandSignApprover();
	recieverside.reviewandSign("Prudvi");
	recieverside.Approvedocument();
	documentsScenarios.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewandSignApprover();
	recieverside.reviewandSign("Ramya");
	recieverside.Approvedocument();
	
	}
//rearrange to sender multiple cc without enforce and without autofill
@Test(priority = 39)
public void VerifySenderMultipleCC() throws Exception {
	String a="VerifySenderMultipleCC";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "CC");
	documentsScenarios.RecipientSigner(2,"Receiver", "ramyasibbala200@outlook.com", "CC");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.Finishdocument();
	recieverside.prudhvioutlooklogin();
	recieverside.documentcompleted(a);
	documentsScenarios.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
	recieverside.documentcompleted(a);
	
}
//rearrange to multiple cc and sender without enforce and without autofill
@Test(priority = 40)
public void VerifyMultpleCCSender() throws Exception {
	String a="VerifyMultipleCCSender";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "CC");
	documentsScenarios.RecipientSigner(2,"Receiver", "ramyasibbala200@outlook.com", "CC");
	documentsScenarios.Rearranges(2,0);
	documentsScenarios.Rearranges(2,1);
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.Finishdocument();
	recieverside.prudhvioutlooklogin();
	recieverside.documentcompleted(a);
	documentsScenarios.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
	recieverside.documentcompleted(a);
	}
//send document with uploading blank doc for single sender (complete through login account)
@Test(priority = 41)
public void VerifyDocForSingleSender() throws Exception {
	String a="VerifyDocForSingleSender";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
//	recieverside.Meghanaesignslogin();
	documentsScenarios.Finishdocument();
	
}
//Verify status of draftdocument
@Test(priority = 42)
public void VerifyDaftsentdocument() throws Exception {
login.Signin();
login.VerifyLoginSucess();
documents.DraftStatus();
documents.VerifyDraft();
documents.Perform();
documents.DraftSentDocument();
documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
documentsScenarios.DradAndDropSigAndFullName(2,10,60,10,90);
documentsScenarios.Senddoc();
documents.ValidDraftSendDocument();
}
//Performing action for save as template in draft documents
@Test(priority = 43)
public void VerifyDraftSaveAsTemplate() throws Exception {
login.Signin();
login.VerifyLoginSucess();
documents.DraftStatus();
documents.VerifyDraft();
documents.Perform();
documents.DraftSaveAsTemplate();
documents.ValidDraftSaveasTemplate();
}
//Performing action for rename document in draft documents
@Test(priority = 44)
public void VerifyDraftrenamedocument() throws Exception {
login.Signin();
login.VerifyLoginSucess();
documents.DraftStatus();
documents.VerifyDraft();
documents.Perform();
documents.DraftrenameDocument();
documents.ValidDraftRenameDocument();
}
//Performing action for document Settings in draft documents
@Test(priority = 45)
public void VerifyDraftDocumentSettings() throws Exception {
login.Signin();
login.VerifyLoginSucess();
documents.DraftStatus();
documents.VerifyDraft();
documents.Perform();
documents.Draftdocumentsetting();
documents.ValidDraftDocumentSettings();
}
//Performing action for delete document in draft documents
@Test(priority = 46)
public void VerifyDraftDeleteDocument() throws Exception {
login.Signin();
login.VerifyLoginSucess();
documents.DraftStatus();
documents.VerifyDraft();
documents.DraftDeletedocument();
documents.ValidDraftDeleteDocument();
}
////Performing action for save as templat in draft documents
//@Test(priority = 47)
//public void VerifyDraftDownloadOriginal() throws Exception {
//login.Signin();
//login.VerifyLoginSucess();
//documents.DraftStatus();
//documents.VerifyDraft();
//documents.DraftDownloadOriginal();
////documents.ValidDraftDownloadOriginal();
//}
//Performing action for correct document in sent documents
@Test(priority = 48)
public void VerifySentCorrectDocument() throws Exception {
login.Signin();
login.VerifyLoginSucess();
documents.SentStatus();
documents.ValidSent();
documents.SentcorrectDocument();
//documents.ValidSentcorrectDocument();
documentsScenarios.Senddoc();
}
//Performing action for Resend document in sent documents
@Test(priority = 49)
public void VerifySentResenddocument() throws Exception {
login.Signin();
login.VerifyLoginSucess();
documents.SentStatus();
documents.ValidSent();
documents.SentResenddocument();
documents.ValidSentResenddocument();
}
//Performing action for save as template in sent documents
@Test(priority = 50)
public void VerifySentsavetoTemplate() throws Exception {
login.Signin();
login.VerifyLoginSucess();
documents.SentStatus();
documents.ValidSent();
documents.SentsavetoTemplate();
documents.ValidSentsavetoTemplate();
}
//Performing action for void document in sent documents
@Test(priority = 51)
public void VerifySentVoiddocument() throws Exception {
login.Signin();
login.VerifyLoginSucess();
documents.SentStatus();
documents.ValidSent();
documents.SentVoiddocument();
documents.ValidSentVoiddocument();
}
//Performing action for rename document in sent documents
@Test(priority = 52)
public void VerifySentRenamedocument() throws Exception {
login.Signin();
login.VerifyLoginSucess();
documents.SentStatus();
documents.ValidSent();
documents.SentRenamedocument();
documents.ValidSentRenamedocument();
}
//Performing action for document settings in sent documents
@Test(priority = 53)
public void VerifySentdocumentsettings() throws Exception {
login.Signin();
login.VerifyLoginSucess();
documents.SentStatus();
documents.ValidSent();
documents.Sentdocumentsettings();
documents.ValidSentdocumentsettings();
}
//Performing action for delete document in sent documents
@Test(priority = 54)
public void VerifySentDeletedocument() throws Exception {
login.Signin();
login.VerifyLoginSucess();
documents.SentStatus();
documents.ValidSent();
documents.SentDeletedocument();
documents.ValidSentDeletedocument();
}
//Performing action for correct document in Approved documents
@Test(priority = 55)
public void VerifyApprovedCorrectdocumentDocuments() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.ApprovedStatus();
	documents.VerifySelectStatus();
	documents.ApprovedCorrectdocument();
	documents.ValidApprovedCorrectdocument();
}
//Performing action for Resend document in Approved documents
@Test(priority = 56)
public void VerifyApprovedResendDocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.ApprovedStatus();
	documents.VerifySelectStatus();
	documents.ApprovedResenddocument();
	documents.ValidResendDocument();

}
//Performing action for save as template in Approved documents
@Test(priority = 57)
public void VerifyApprovedSaveAsTemplate() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.ApprovedStatus();
	documents.VerifySelectStatus();
	documents.ApprovedSaveastemplate();
	documents.ValidSaveAsTemplate();
}
//Performing action for void document in Approved documents
@Test(priority = 58)
public void VerifyApprovedVoidDocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.ApprovedStatus();
	documents.VerifySelectStatus();
	documents.ApprovedVoiddocument();
	documents.ValidVoidDocument();
}
//Performing action for rename document in Approved documents
@Test(priority = 59)
public void VerifyApprovedRenameDocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.ApprovedStatus();
	documents.VerifySelectStatus();
	documents.ApprovedRenamedocument();
	documents.ValidRenameDocument();
}
//Performing action for document settings in Approved documents
@Test(priority = 60)
public void VerifyApprovedDocumentSettings() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.ApprovedStatus();
	documents.VerifySelectStatus();
	documents.ApprovedDocumentsettings();
	documents.ValidDocumentSettings();
}
//Performing action for delete document in Approved documents
@Test(priority = 61)
public void VerifyApprovedApprovedDeleteDocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.ApprovedStatus();
	documents.VerifySelectStatus();
	documents.ApprovedDeletedocument();
	documents.ValidDeleteDocument();
}
//Performing action for declined document in decline documents
@Test(priority = 62)
public void VerifyDelineddocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.DeclinedStatus();
	documents.VerifyDeclined();
	documents.DeclinedSaveastemplate();
	documents.ValidDeclinedSaveastemplate();
}
//Performing action for void document in decline documents
@Test(priority = 63)
public void VerifyDeclinedVoiddocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.DeclinedStatus();
	documents.VerifyDeclined();
	documents.DeclinedVoiddocument();
	documents.ValidDeclinedVoiddocument();
}
//Performing action for rename document in decline documents
@Test(priority = 64)
public void VerifyDeclinedDeclinedRenamedocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.DeclinedStatus();
	documents.VerifyDeclined();
	documents.DeclinedRenamedocument();
	documents.ValidDeclinedRenamedocument();
}
//Performing action for document settings in decline documents
@Test(priority = 65)
public void VerifyDeclinedDocumentSettings() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.DeclinedStatus();
	documents.VerifyDeclined();
	documents.DeclinedDocumentsettings();
	documents.ValidDeclinedDocumentSettings();
}
//Performing action for delete document in decline documents
@Test(priority = 66)
public void VerifyDeclinedDeletedocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.DeclinedStatus();
	documents.VerifyDeclined();
	documents.DeclinedDeletedocument();
	documents.ValidDeclinedDeleteDocument();
}
//Performing action for save as template in void documents
@Test(priority = 67)
public void VerifYVoidSaveastemplate() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.VoidStatus();
	documents.ValidVoid();
	documents.VoidSaveastemplate();
	documents.ValidVoidSaveastemplate();
}
//Performing action for clone document in void documents
@Test(priority = 68)
public void VerifyVoidClonedocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.VoidStatus();
	documents.ValidVoid();
	documents.VoidClonedocument();
//	documents.ValidVoidClonedocument();
	documentsScenarios.Senddoc();
	
}
//Performing action for delete document in void documents
@Test(priority = 69)
public void VerifyVoidDeletedocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.VoidStatus();
	documents.ValidVoid();
	documents.VoidDeletedocument();
	documents.ValidVoidDeletedocument();
}
//Performing action for rename document in Archieved documents
@Test(priority = 70)
public void VerifyArchivedRenamedocuments() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.ArchievdStatus();
	documents.VerifyArchieved();
	documents.ArchivedRenamedocuments();
	documents.ValidRenamedocument();
}
//Performing action for undo document in Archieved documents
@Test(priority = 71)
public void VerifyArchivedUndodocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.ArchievdStatus();
	documents.VerifyArchieved();
	documents.ArchivedUndodocument();
	documents.ValidUndodocument();
}
//Performing action for permanent delete document in Archieved documents
@Test(priority = 72)
public void VerifyArchivedPermanentdelete() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.ArchievdStatus();
	documents.VerifyArchieved();
	documents.ArchivedPermanentdelete();
	documents.ValidPermanentDelete();
}
//Performing action for save as template in Completed documents
@Test(priority = 73)
public void VerifyCompletedSaveastemplate() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.CompletedStatus();
	documents.VerifyCompleted();
	documents.CompletedSaveastemplate();
	documents.ValidSaveastemplate();
}
//Performing action for Share with users in Completed documents
@Test(priority = 74)
public void VerifyCompletedSharewithothers() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.CompletedStatus();
	documents.VerifyCompleted();
	documents.CompletedSharewithothers();
	documents.ValidCompletedSharewithothers();
}
//Performing action for clone document in Completed documents
@Test(priority = 75)
public void VerifyCompletedClonedocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.CompletedStatus();
	documents.VerifyCompleted();
	documents.CompletedClonedocument();
	documentsScenarios.Senddoc();
}
//Performing action for Rename document in Completed documents
@Test(priority = 76)
	public void VerifyCompletedRenamedocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.CompletedStatus();
	documents.VerifyCompleted();
	documents.CompletedRenamedocument();
	documents.ValidCompletedRenamedocument();

}
//Performing action for download document in Completed documents
@Test(priority = 77)
public void VerifyCompletedDownloaddocuement() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.CompletedStatus();
	documents.VerifyCompleted();
	documents.CompletedDownloaddocuement();
//	documents.ValidCompletedDownloaddocuement();
}
//Performing action for delete document in Completed documents
@Test(priority = 78)
public void VerifyCompletedDeletedocuement() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.CompletedStatus();
	documents.VerifyCompleted();
	documents.CompletedDeletedocuement();
	documents.ValidCompletedDeletedocument();
}
//Performing action for sent to mail in Completed documents
@Test(priority = 79)
public void VerifyCompletedSenttomail() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.CompletedStatus();
	documents.VerifyCompleted();
	documents.CompletedSenttomail();
	documents.ValidCompletedSenttomail();
}
//Performing action in waiting for me documents
@Test(priority = 80)
public void VerifyWaitformeWaitforme() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.WaitingformeStatus();
	documents.ValidWaitingforme();
	documents.WaitformeWaitforme();
	documents.ValidWaitingforme();
}
//Performing action for correct document in waiting for others documents
@Test(priority = 81)
public void VerifyWaitingForOthersCorrectdocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.Waitingforotherstatus();
	documents.ValidWaitingforothers();
	documents.WaitingForOthersCorrectdocument();
	documentsScenarios.Senddoc();
}
//Performing action for resend document in waiting for others documents
@Test(priority = 82)
public void VerifyWaitingForOthersResenddocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.Waitingforotherstatus();
	documents.ValidWaitingforothers();
	documents.WaitingForOthersResenddocument();
	documents.ValidWaitingForOthersResenddocument();
}
//Performing action for save as template in waiting for others documents
@Test(priority = 83)
public void VerifyWaitingForOthersSaveastemplate() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.Waitingforotherstatus();
	documents.ValidWaitingforothers();
	documents.WaitingForOthersSaveastemplate();
	documents.ValidWaitingForOthersSaveastemplate();
}
//Performing action for void document in waiting for others documents
@Test(priority = 84)
public void VerifyWaitingForOthersVoiddocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.Waitingforotherstatus();
	documents.ValidWaitingforothers();
	documents.WaitingForOthersVoiddocument();
	documents.ValidWaitingForOthersVoiddocument();
}
//Performing action for rename document in waiting for others documents
@Test(priority = 85)
public void VerifyWaitingForOthersRenamedocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.Waitingforotherstatus();
	documents.ValidWaitingforothers();
	documents.WaitingForOthersRenamedocument();
	documents.ValidWaitingForOthersRenamedocument();
}
//Performing action for document settings in waiting for others documents
@Test(priority = 86)
public void VerifyWaitingForOthersDocumentsettings() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.Waitingforotherstatus();
	documents.ValidWaitingforothers();
	documents.WaitingForOthersDocumentsettings();
	documents.ValidWaitingForOthersDocumentsettings();
}
//Performing action for delete document in waiting for others documents
@Test(priority = 87)
public void VerifyWaitingForOthersDeletedocument() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documents.Waitingforotherstatus();
	documents.ValidWaitingforothers();
	documents.WaitingForOthersDeletedocument();
	documents.ValidWaitingForOthersDeletedocument();
}
//uploading different types of files (processing it as single document)
@Test(priority = 88)
public void VerifyProcessSingleDoc() throws Throwable {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.DocScenario();
	documentsScenarios.uploadDocument();
	documentsScenarios.UploadMultipledocuments();
	documentsScenarios.PCOnedoc();
	documentsScenarios.Nextbt();
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.Selecttofillrec();
	documentsScenarios.Selectautofill();
	documentsScenarios.Senddoc();
}
//uploading different types of files ( without processing it as single document)
@Test(priority = 89)
public void VerifyProcessWithOutSingledoc() throws Throwable {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.DocScenario();
	documentsScenarios.uploadDocument();
	documentsScenarios.UploadMultipledocuments();
	documentsScenarios.Nextbt();
	documentsScenarios.RecipientSigner(1, "Receiver","prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.Selecttofillrec();
	documentsScenarios.Selectautofill();
	documentsScenarios.Senddoc();
}
@Test(priority = 90)
public void VerfySaveAsDraft() throws Exception {
	String a="VerfySaveAsDraft";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1, "Receiver","prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.SaveAsDraft();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudhvi");
	recieverside.FinishDocumentRecieverside();
}
// Verify settings before sending document
@Test(priority = 91)
public void VerifySettings() throws Exception {
	String a="VerifySettings";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.Documentsettings();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	
}
//Verify change document before sending document
@Test(priority = 92)
public void VerifyChangeDoc() throws Exception {
	String a="VerifyChangeDoc";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.changedoc();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
}
//Verify lock fields before sending document
//Lock fields
@Test(priority = 93)
public void VerifyLockFields()throws Exception {
	String a="VerifyLockFields";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "APPROVER");
	documentsScenarios.Saveuser();
	documentsScenarios.Lockfields();

}
//Verify adding extra pages before sending document
//Add pages
@Test(priority = 94)
public void VerifyAddPages() throws Exception {
	String a="VerifyAddPages";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.Addpages();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	
}
//Verify deleting pages from document before sending document
//Delete pages
@Test(priority = 95)
public void VerifyDeletePages() throws Exception {
	String a="VerifyDeletePages";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	documentsScenarios.Deletepages();
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	
} 
//Approve document for single approver
// Approve document
@Test(priority = 96)
public void VerifyApproverSenderapprove() throws Exception {
	String a="VerifyApproverSenderapprove";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "APPROVER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewandSignApprover();
	recieverside.reviewandSign("Prudvi");
	recieverside.Approvedocument();
}
//decline document for sigle approver
//Decline document
@Test(priority = 97)
public void VerifyApproverSenderDecline() throws Exception {
	String a ="VerifyApproverSenderDecline";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "APPROVER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewandSignApprover();
	recieverside.reviewandSign("Prudvi");
	recieverside.Declinedocument();
}
// verify other options in document from reciever side -Finsih later
@Test(priority = 98)
public void Verifyotheroptionsfinishlater() throws Exception {
	String a="Verifyotheroptionsfinishlater";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.OtherOptions();
	documentsScenarios.otheroptionsfinishlater();
	documentsScenarios.Afterfinishlater();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();


}
//verify other options in document from reciever side - Print and sign
@Test(priority = 99)
public void Verifyotheroptionsprintandsign() throws Exception {
	String a ="Verifyotheroptionsprintandsign";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.OtherOptions();
	documentsScenarios.otheroptionsprintandsign();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
}
//verify other options in document from reciever side -Download
@Test(priority = 100)
public void VerifyOtheroptionsdownload() throws Exception {
	String a ="VerifyOtheroptionsdownload";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.OtherOptions();
	documentsScenarios.Otheroptionsdownload();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
}
//verify other options in document from reciever side -History
@Test(priority = 101)
public void Verifyotheroptionshistory() throws Exception {
	String a="Verifyotheroptionshistory";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.OtherOptions();
	documentsScenarios.otheroptionshistory();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
}
//verify other options in document from reciever side - Settings
@Test(priority = 102)
public void Verifyotheroptionssettings() throws Exception {
	String a ="Verifyotheroptionssettings";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.OtherOptions();
	documentsScenarios.otheroptionssettings();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
}
//verify other options in document from reciever side - Correct document
@Test(priority = 103)
public void VerifyotheroptionsCorrectdoc() throws Exception {
	String a ="VerifyotheroptionsCorrectdoc";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.OtherOptions();
	documentsScenarios.otheroptionsCorrectdoc();
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
}
//verify other options in document from reciever side -Save as template
@Test(priority = 104)
public void Verifyotheroptionssaveastem() throws Exception {
	String a ="Verifyotheroptionssaveastem";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.OtherOptions();
	documentsScenarios.otheroptionssaveastem();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
}
//verify other options in document from reciever side - Void document
@Test(priority = 105)
public void Verifyotheroptionsvoiddoc() throws Exception {
	String a ="Verifyotheroptionsvoiddoc";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.OtherOptions();
	documentsScenarios.otheroptionsvoiddoc();
	documentsScenarios.Clonedocument();
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	
}
//verify chats and logs from sender to reciever side
@Test(priority = 106)
public void Verifychatandlogs() throws Exception {
	String a="Verifychatandlogs";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	documentsScenarios.Chat();
	documentsScenarios.Logs();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	documentsScenarios.Viewcommenteddocument();
}
//verify other options in document from reciever side - Delete document
@Test(priority = 107)
public void VerifyOtheroptionsdeletedocument() throws Exception {
	String a="VerifyOtheroptionsdeletedocument";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
//	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.OtherOptions();
	documentsScenarios.otheroptionsdelete();
//	documentsScenarios.Blankwithoutsenderautofill();
//	recieverside.prudhvioutlooklogin();
//	recieverside.clickEmail(a);
//	recieverside.reviewandSignSigner();
}
//Upload autofill document and complete it from both sender and reciever side
@Test(priority = 108)
public void VerifyPdfAutoFillreceiver() throws Throwable {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.DocScenario();
	documentsScenarios.UploadMultipledocuments();
	documentsScenarios.Nextbt();
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.Selecttofillrec();
	documentsScenarios.Selectautofill();
	documentsScenarios.Senddoc();
	recieverside.ABCaccount();
}
//Bulk delete documents
@Test(priority = 109)
public void VerifyBuldDeleteDocuments() throws InterruptedException {
	login.Signin();
	login.VerifyLoginSucess();
	documents.clickondocuments();
	documents.BuldDelete();
	}
// strike, Erase in uploaded document
@Test(priority = 110)
public void VerifyStrikeEraseuploadDocument() throws Throwable {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.DocScenario();
	documentsScenarios.uploadDocument();
	documentsScenarios.Nextbt();
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.Selecttofillrec();
	documentsScenarios.Selectautofill();
	documentsScenarios.PdfEditmode();
	documentsScenarios.Senddoc();
}
//Slipting single line text fields into different boxes in document
@Test(priority = 111)
public void SplitSinglelineText() throws Exception {
	String a="SplitSinglelineText";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	documentsScenarios.SplitBox();
//	recieverside.SubDocScenarios(a);
//	documentsScenarios.clickSubmit();
//	documentsScenarios.Verifysubmit();
//	documentsScenarios.Viewdocument();
//	documentsScenarios.Blankwithoutsenderautofill();
//	recieverside.prudhvioutlooklogin();
//	recieverside.clickEmail(a);
//	recieverside.reviewandSignSignerSplitbox();
	
}
//changing user for the document
@Test(priority = 112)
public void Verifychangeuser() throws Exception {
	String a="Verifychangeuser";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.autofilloff();
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.OtherOptions();
	documentsScenarios.otheroptionsfinishlater();
	documentsScenarios.Afterfinishlater();
	documentsScenarios.Changeruser();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
}
//copy link option when we click on finish later
@Test(priority = 113)
public void VerifyCopylink() throws Exception {
	String a="VerifyCopylink";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autofilloff();
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.DradAndDropSigAndFullName(2,10,50,10,80);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.OtherOptions();
	documentsScenarios.otheroptionsfinishlater();
	documentsScenarios.Afterfinishlater();
	documentsScenarios.Copylink();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	
}
//send document document for single send with any feilds after that clone that document and try to sennd that document again ,Verify whether it showig pop up for to add reciever fields
@Test(priority = 114)
public void VerifyClonedocumentForsinglesender() throws Exception {
	String a ="VerifyClonedocumentForsinglesender";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autofilloff();
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,10,130,10,160);
	documentsScenarios.Finishdocument();
	documentsScenarios.Clonedocumentforsinglesender();
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Saveuser();
	documentsScenarios.SendClonedoc();
}
@Test
public void VerifydocumentWith10user() throws Exception {
	String a="VerifydocumentWith10user";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"Receiver", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(2,"Receiver", "jeevithapatnana200@outlook.com", "APPROVER");
	documentsScenarios.RecipientSigner(3,"Receiver", "ramyasibbala200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(4,"Receiver", "meghanan180894@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(5,"Receiver", "pmmeghana200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(6,"Receiver", "ramyas200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(7,"Receiver", "ramyas2002@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(8,"Receiver", "esigns100@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(9,"Receiver", "esigns200@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(10,"Receiver", "esigns300@outlook.com", "SIGNER");
	documentsScenarios.RecipientSigner(11,"Receiver", "esigns400@outlook.com", "SIGNER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndDateSigned(1,-250,-150,-250,-120,-250,-90);
	documentsScenarios.DradAndDropSigAndDateSigned(2,-250,-40,-250,-10,-250,20);
	documentsScenarios.DradAndDropSigAndDateSigned(3,-250,70,-250,100,-250,130);
	documentsScenarios.DradAndDropSigAndDateSigned(4,-250,180,-250,210,-250,240);
	documentsScenarios.DradAndDropSigAndDateSigned(5,10,-150,10,-120,10,-90);
	documentsScenarios.DradAndDropSigAndDateSigned(6,10,-40,10,-10,10,20);
	documentsScenarios.DradAndDropSigAndDateSigned(7,10,70,10,100,10,130);
	documentsScenarios.DradAndDropSigAndDateSigned(8,10,180,10,210,10,240);
	documentsScenarios.DradAndDropSigAndDateSigned(9,250,-150,250,-120,250,-90);
	documentsScenarios.DradAndDropSigAndDateSigned(10,250,-40,250,-10,250,20);
	documentsScenarios.DradAndDropSigAndDateSigned(11,-250,70,-250,100,-250,130);
	documentsScenarios.DradAndDropSigAndDateSigned(12,-250,180,240,210,240,240);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewandSignApprover();
	recieverside.reviewandSign("Jeevitha");
	recieverside.Approvedocument();
	documentsScenarios.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Ramya");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("meghana");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("pmmeghana200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Ramya");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("meghana");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("ramyas2002@outlook.com", "Ramya@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Ramya");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("esigns100@outlook.com", "Ramya@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Ramya");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("esigns200@outlook.com", "Ramya@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Ramya");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("esigns300@outlook.com", "Ramya@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Ramya");
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.Outlooklogin("esigns400@outlook.com", "Ramya@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Ramya");
	recieverside.FinishDocumentRecieverside();
	}
@Test
public void RunningInLoop() throws Exception {
	String a="RunningInLoop";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.SelectRecipients();
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.PlaceFieldsByUsingCoordinates();
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	recieverside.reviewandSign("Prudvi");
	recieverside.FinishDocumentRecieverside();
	recieverside.VerifyAllloginCredantials();
	
	
}
@Test
public void VerifyAddEntityfieldstodocumentprimaryfields1() throws Exception {
//	UUID uuid = UUID.randomUUID();
//	String doc = uuid.toString().replaceAll("-", "");
	String arr[] = { "1", "06-04-2024 To 07-04-2024","prudvi","06-04-2024 00:00:00","YES","Thursday","06-04-2024","Ramya","blank.pdf","list","01:30","2","123456","01:01:01","1234567890","This is only for the sake of testing","maths", "1"};
	String a ="VerifyAddEntityfieldstodocumentprimaryfields8";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.Settings();
	documentsScenarios.Entity();
	documentsScenarios.ClickCreateEntity();
	documentsScenarios.Createentity(a,"BUSINESS","Create a new app base with custom fields,tables, and filters.");
	documentsScenarios.addtemplatetoentity();
	documentsScenarios.Updation();
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.AddRecipientforEntity(1,a,"prudhvib200@outlook.com","Ramya","SIGNER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,-10,-200,-10,-250);
	documentsScenarios.DragBasicFeildsCompanyProfile(2);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
//	documentsScenarios.enteringdatatoentity();
	documentsScenarios.receiverSideBasicFeildsFill(1, 4, 1, 2);
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.clickok();
	documentsScenarios.VerifyEntityData();
	documentsScenarios.Showall();
	documentsScenarios.verifyBasicFieldDataFillInIndividualEntity(arr, 1);
//	documentsScenarios.AdddataandValid();
	
	}
@Test
public void VerifyUpdateAddEntityfieldstodocumentprimaryfields() throws Exception {
	String arr[] = { "2", "06-02-2024 To 07-07-2024","prudvi","06-06-2024 00:00:00","NO","Tuesday","06-04-2024","Automation testing","fw4 2024 1 (1).pdf","template","02:00","3,2","10","00:00:00","7337060228","Automation testing","chemistry", "3"};
	String a="VerifyUpdateAddEntityfieldstodocumentprimaryfields";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
//	documentsScenarios.Updateafterdocumentcompletionfromsettings();
	documentsScenarios.Settings();
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"VerifyAddEntityfieldstodocumentprimaryfields", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,-10,-200,-10,-250);
	documentsScenarios.DragBasicFeildsCompanyProfile(2);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	documentsScenarios.receiverSideUpdatedBasicFeildsFill();
	documentsScenarios.VerifyEntityData();
	documentsScenarios.verifyBasicFieldDataFillInIndividualEntity(arr, 1);
}
@Test
public void VerifyUpdateafteruserfinishesthedocument() throws Exception {
	String a="VerifyUpdateafteruserfinishesthedocument";
	String arr[] = { "1", "06-04-2024 To 07-04-2024","prudvi","06-04-2024 00:00:00","YES","Thursday","06-04-2024","Ramya","blank.pdf","list","01:30","2","123456","01:01:01","1234567890","This is only for the sake of testing","maths", "1"};
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	//documentsScenarios.Updateafterdocumentcompletionfromsettings();
	documentsScenarios.Settings2();
	documentsScenarios.Entity();
	documentsScenarios.ClickCreateEntity();
	documentsScenarios.Createentity(a,"BUSINESS","Create a new app base with custom fields,tables, and filters.");
	documentsScenarios.addtemplatetoentity();
	documentsScenarios.Updation();
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.AddRecipientforEntity(1,a,"prudhvib200@outlook.com","Ramya","SIGNER");
	documentsScenarios.AddRecipientforEntity(2,a,"jeevithapatnana200@outlook.com","Ramya","SIGNER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,-10,-200,-10,-250);
	documentsScenarios.DragBasicFeildsCompanyProfile(2);
	documentsScenarios.addPageAndClickOnPageTwoInDoc();
	documentsScenarios.DragBasicFeildsCompanyProfile(3);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
//	documentsScenarios.enteringdatatoentity();
	documentsScenarios.receiverSideBasicFeildsFill(1, 4, 1, 2);
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.clickok();
	documentsScenarios.VerifyEntityData();
	documentsScenarios.verifyBasicFieldDataFillInIndividualEntity(arr, 1);
	documentsScenarios.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	documentsScenarios.enteringdatatoentity();
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.clickok();
	documentsScenarios.VerifyEntityData();
	documentsScenarios.verifyBasicFieldDataFillInIndividualEntity(arr, 2);
}
@Test
public void VerifyNeverUpdate() throws Exception {
	String arr[] = { "2", "06-02-2024 To 07-07-2024","prudvi","06-06-2024 00:00:00","NO","Tuesday","06-04-2024","Automation testing","fw4 2024 1 (1).pdf","template","02:00","3,2","10","00:00:00","7337060228","Automation testing","chemistry", "3"};
	String a="VerifyNeverUpdate";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.Settings3();
	documentsScenarios.Entity();
	documentsScenarios.ClickCreateEntity();
	documentsScenarios.Createentity(a,"BUSINESS","Create a new app base with custom fields,tables, and filters.");
	documentsScenarios.addtemplatetoentity();
	documentsScenarios.Updation();
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.AddRecipientforEntity(1,a,"prudhvib200@outlook.com","Ramya","SIGNER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,-10,-200,-10,-250);
	documentsScenarios.DragBasicFeildsCompanyProfile(2);
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
//	documentsScenarios.enteringdatatoentity();
	documentsScenarios.receiverSideBasicFeildsFill(1, 4, 1, 2);
	recieverside.FinishDocumentRecieverside();
	documentsScenarios.clickok();
	documentsScenarios.VerifyEntityData();
	documentsScenarios.Showall();
	documentsScenarios.verifyBasicFieldDataFillInIndividualEntity(arr, 1);
	
}
@Test
public void Updateparentdata() throws Exception {
	String a="Updateparentdata";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.DocScenario();
	documentsScenarios.BlankDoc(a);
	documentsScenarios.RecipientSigner(1,"VerifyAddEntityfieldstodocumentprimaryfields", "prudhvib200@outlook.com", "SIGNER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(2,-10,-200,-10,-250);
//	documentsScenarios.placeFieldsRepeatedly();
	documentsScenarios.Mappwithentity();
	documentsScenarios.updateWithParentBasicFieldsLoop("Entity-VerifyAddEntityfieldstodocumentprimaryfields 1","templateBasicFeilds");
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	documentsScenarios.receiverSideBasicFeildsFill(1, 4, 1, 2);
//	documentsScenarios.ModifyingData();
	recieverside.FinishDocumentRecieverside();
	
	}
@Test
public void Templateaction() throws Exception {
	String a="Templateaction";
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.Templatesceanario();
	documentsScenarios.CreateBlankTemplate(a);
	documentsScenarios.RecipientSignerToTemplate("business entity-template","SIGNER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,-10,-200,-10,-250);
	documentsScenarios.DragBasicFeildsCompanyProfile(2);
	documentsScenarios.Clickcreatedocument();
	documentsScenarios.Docsend(1,"prudhvib200@outlook.com");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	recieverside.SubDocScenarios(a);
	documentsScenarios.clickSubmit();
//	documentsScenarios.Verifysubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(a);
	recieverside.reviewSigner();
	documentsScenarios.receiverSideBasicFeildsFill(1, 4, 1, 2);
	}
@Test
public void UpdateAfterdocumentcompletionTemplate() throws Exception {
	UUID uuid = UUID.randomUUID();
	String doc = uuid.toString().replaceAll("-", "");
	String arr[] = { "1", "06-04-2024 To 07-04-2024","prudvi","06-04-2024 00:00:00","YES","Thursday","06-04-2024","Ramya","blank.pdf","list","01:30","2","123456","01:01:01","1234567890","This is only for the sake of testing","maths", "1"};
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.autoFill("N");
	documentsScenarios.Settings();
	documentsScenarios.Templatesceanario();
	documentsScenarios.CreateBlankTemplate(doc);
	documentsScenarios.RecipientSignerToTemplate("business entity-template","SIGNER");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	documentsScenarios.DradAndDropSigAndFullName(1,-10,-200,-10,-250);
	documentsScenarios.DragBasicFeildsCompanyProfile(2);
	documentsScenarios.Clickcreatedocument();
	documentsScenarios.Docsend(1,"prudhvib200@outlook.com");
	documentsScenarios.Signorder();
	documentsScenarios.Saveuser();
	recieverside.SubDocScenarios(doc);
	documentsScenarios.clickSubmit();
	documentsScenarios.Viewdocument();
	documentsScenarios.Blankwithoutsenderautofill();
	recieverside.prudhvioutlooklogin();
	recieverside.clickEmail(doc);
	recieverside.reviewSigner();
	documentsScenarios.receiverSideBasicFeildsFill(1, 4, 1, 2);
	documentsScenarios.VerifyTemplateData();
	documentsScenarios.verifyBasicFieldDataFillInIndividualEntity(arr, 1);
	}
//Global Variables
@Test
public void VerifyAddingHtmlGlobalvariables() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.clickGlobalVariable();
	documentsScenarios.VerifyClickGlobalVariable();
	documentsScenarios.clickNewVariable();
	documentsScenarios.selectDataType();
	documentsScenarios.Htmlglobalvariable();
	documentsScenarios.AddVariable();
}
@Test
public void VerifyAddingImage() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.clickGlobalVariable();
	documentsScenarios.VerifyClickGlobalVariable();
	documentsScenarios.clickNewVariable();
	documentsScenarios.selectDataType();
	documentsScenarios.Imageglobalvariable();
	documentsScenarios.AddVariable();
	}
@Test
public void VerifyAddingList() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.clickGlobalVariable();
	documentsScenarios.VerifyClickGlobalVariable();
	documentsScenarios.clickNewVariable();
	documentsScenarios.selectDataType();
	documentsScenarios.Listglobalvariable();
	documentsScenarios.AddVariable();
	}
@Test
public void VerifyAddingCurrency() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.clickGlobalVariable();
	documentsScenarios.VerifyClickGlobalVariable();
	documentsScenarios.clickNewVariable();
	documentsScenarios.selectDataType();
	documentsScenarios.Currencyglobalvariable();
	documentsScenarios.AddVariable();
	}
@Test
public void VerifyAddCheckBoxGroup() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.clickGlobalVariable();
	documentsScenarios.VerifyClickGlobalVariable();
	documentsScenarios.clickNewVariable();
	documentsScenarios.selectDataType();
	documentsScenarios.Checkboxgroupglobalvariable();
	documentsScenarios.AddVariable();
}
@Test
public void VerifyAddRadioGroup() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.clickGlobalVariable();
	documentsScenarios.VerifyClickGlobalVariable();
	documentsScenarios.clickNewVariable();
	documentsScenarios.selectDataType();
	documentsScenarios.RadioGroupglobalvariable();
	documentsScenarios.AddVariable();
	}
@Test
public void VerifyAddStartRating() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.clickGlobalVariable();
	documentsScenarios.VerifyClickGlobalVariable();
	documentsScenarios.clickNewVariable();
	documentsScenarios.selectDataType();
	documentsScenarios.StarRatingglobalvariable();
	documentsScenarios.AddVariable();
}
@Test
public void VerifyEditGlobalvariable() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.clickGlobalVariable();
	documentsScenarios.VerifyClickGlobalVariable();
	documentsScenarios.EditGlobalvariable();
}
@Test
public void VerifyDuplicateGlobalvariable() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.clickGlobalVariable();
	documentsScenarios.VerifyClickGlobalVariable();
	documentsScenarios.Duplicateglobalvariable();
}
@Test
public void VerifyDeleteGlobalvariable() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.clickGlobalVariable();
	documentsScenarios.VerifyClickGlobalVariable();
	documentsScenarios.Deleteglobalvariable();
}
@Test
public void VerifyFormBuilder() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.clickFormbuilder();
	documentsScenarios.Addformbuilder();
	documentsScenarios.VerifyPrimarySettings();
	documentsScenarios.SaveFormbuilder();
	documentsScenarios.ViewFormbuilder();
//	documentsScenarios.AddAdminApprover();
//	documentsScenarios.AddManagerapprover();
//	documentsScenarios.AddMemberapprover();
//	documentsScenarios.AddOwnerapprover();
}
@Test
public void VerifyLemitedPeriod() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	documentsScenarios.clickFormbuilder();
	documentsScenarios.Addformbuilder();
//	documentsScenarios.Limitedperiod();
//	documentsScenarios.UserSubmissionsettings();
//	documentsScenarios.SuccessandRedirectpage();
//	documentsScenarios.RemainderSettings();
//	documentsScenarios.RemainderSettings();
//	documentsScenarios.ReceiverEmailCustomization();
	documentsScenarios.ApprovalSettings();
//	documentsScenarios.ExpirationSettings();
//	documentsScenarios.Customization();
	documentsScenarios.SaveFormbuilder();
	documentsScenarios.ViewFormbuilder();
	documentsScenarios.Addmail("Ramya","Sibbala","ramyas200@outlook.com");
	documentsScenarios.DatatoFormbuilder();
	documentsScenarios.Finishformbuilder();
	documentsScenarios.ApproveFormbuilder();
	documentsScenarios.Reviewandapproveformbuilder();
	recieverside.clickEmail("Approval request");
	}
}
