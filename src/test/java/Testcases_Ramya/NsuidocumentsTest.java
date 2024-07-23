package Testcases_Ramya;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.Nsuidocuments;
import TestBase.Testcasebase;

public class NsuidocumentsTest extends Testcasebase {
	Login login;
	Nsuidocuments nsuidocuments;

@BeforeMethod
public  void initialize() {
	setUpchrome();
	login = new Login(driver);
	nsuidocuments = new Nsuidocuments(driver);
	}
@Test
public void VerifyLoginFunctionalityWithValidCredantials() throws InterruptedException {
	login.Signin();
	login.VerifyLoginSucess();

}
@Test
public void Processmultipledocumentsassingle() throws Throwable {
	login.Signin();
	login.VerifyLoginSucess();
	nsuidocuments.AllCombos();
	nsuidocuments.ValidAllCombos();
	nsuidocuments.uploadDocument();
	nsuidocuments.ValidUploadDocument();
	nsuidocuments.UploadMultipledocuments();
	nsuidocuments.ValidUploadMultipleDocument();
	nsuidocuments.PCOnedoc();
	nsuidocuments.ValidPCOneDoc();
	nsuidocuments.Nextbt();
	nsuidocuments.ValidNextbtn();
	nsuidocuments.AddRep();
	nsuidocuments.Addrepsigner1();
	nsuidocuments.ValidAddRepSigner1();
	nsuidocuments.Saveuser();
	nsuidocuments.Selecttofillrec();
	nsuidocuments.Selectautofill();
	nsuidocuments.Senddocument();
	nsuidocuments.ABCaccount();

}
@Test
public void withoutprocessingmultipledocumentsassingle() throws Throwable {
	login.Signin();
	login.VerifyLoginSucess();
	nsuidocuments.AllCombos();
	nsuidocuments.ValidAllCombos();
	nsuidocuments.uploadDocument();
	nsuidocuments.ValidUploadDocument();
	nsuidocuments.UploadMultipledocuments();
	nsuidocuments.ValidUploadMultipleDocument();
	nsuidocuments.Nextbt();
	nsuidocuments.ValidNextbtn();
	nsuidocuments.AddRep();
	nsuidocuments.Addrepsigner1();
	nsuidocuments.ValidAddRepSigner1();
	nsuidocuments.Saveuser();
	nsuidocuments.Selecttofillrec();
	nsuidocuments.Selectautofill();
	nsuidocuments.Senddocument();
	nsuidocuments.ABCaccount();

}
@Test
public void verifySettings() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	nsuidocuments.AllCombos();
	nsuidocuments.ValidAllCombos();
	nsuidocuments.BlankDoc();
	nsuidocuments.ValidBlankDoc();
	nsuidocuments.AddRep();
	nsuidocuments.Addrepsigner1();
	nsuidocuments.ValidAddRepSigner1();
	nsuidocuments.Saveuser();
	nsuidocuments.Receiverfields();
	nsuidocuments.Settings();
	nsuidocuments.Senddocument();


}
@Test
public void Verifychangedoc() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	nsuidocuments.AllCombos();
	nsuidocuments.ValidAllCombos();
	nsuidocuments.BlankDoc();
	nsuidocuments.ValidBlankDoc();
	nsuidocuments.AddRep();
	nsuidocuments.Addrepsigner1();
	nsuidocuments.ValidAddRepSigner1();
	nsuidocuments.Saveuser();
	nsuidocuments.Receiverfields();
	nsuidocuments.changedoc();
	nsuidocuments.Senddocument();

}
@Test
public void VerifyLockfields() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	nsuidocuments.AllCombos();
	nsuidocuments.ValidAllCombos();
	nsuidocuments.BlankDoc();
	nsuidocuments.ValidBlankDoc();
	nsuidocuments.AddRep();
	nsuidocuments.Addrepsigner1();
	nsuidocuments.ValidAddRepSigner1();
	nsuidocuments.Saveuser();
	nsuidocuments.Receiverfields();
	nsuidocuments.Lockfields();
	nsuidocuments.Senddocument();
	}
@Test
public void VerifyDifferentdoc() throws Throwable {
	login.Signin();
	login.VerifyLoginSucess();
	nsuidocuments.AllCombos();
	nsuidocuments.ValidAllCombos();
	nsuidocuments.uploadDocument();
	nsuidocuments.ValidUploadDocument();
	nsuidocuments.oneDriveupload();
	nsuidocuments.DocscenariosGdrive();
	nsuidocuments.PCOnedoc();
	nsuidocuments.ValidPCOneDoc();
	nsuidocuments.Nextbt();
	nsuidocuments.ValidNextbtn();
	nsuidocuments.AddRep();
	nsuidocuments.Addrepsigner1();
	nsuidocuments.ValidAddRepSigner1();
	nsuidocuments.Saveuser();
	nsuidocuments.Selecttofillrec();
	nsuidocuments.Selectautofill();
	nsuidocuments.Senddocument();
}
@Test
public void VerifyOnedriveFileupload() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	nsuidocuments.AllCombos();
	nsuidocuments.ValidAllCombos();
	nsuidocuments.oneDriveupload();
	nsuidocuments.Nextbt();
	nsuidocuments.ValidNextbtn();
	nsuidocuments.AddRep();
	nsuidocuments.Addrepsigner1();
	nsuidocuments.ValidAddRepSigner1();
	nsuidocuments.Saveuser();
	nsuidocuments.Receiverfields();
	nsuidocuments.Senddocument();
}
@Test
public void VerifyGoogledriveFileupload() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	nsuidocuments.AllCombos();
	nsuidocuments.ValidAllCombos();
	nsuidocuments.DocscenariosGdrive();
	nsuidocuments.Nextbt();
	nsuidocuments.ValidNextbtn();
	nsuidocuments.AddRep();
	nsuidocuments.Addrepsigner1();
	nsuidocuments.ValidAddRepSigner1();
	nsuidocuments.Saveuser();
	nsuidocuments.Receiverfields();
	nsuidocuments.Senddocument();

}
@Test
public void Verifycompanyprofilerecieverside() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	nsuidocuments.FormTemplate();
	nsuidocuments.CreateFormtemplate();
	nsuidocuments.Addbasicfields();
	nsuidocuments.AddTocompanyprofile();
	nsuidocuments.Entity();
	nsuidocuments.ClickCreateEntity();
	nsuidocuments.CreateEntity();
	nsuidocuments.addtemplatetIndividualentity();
	nsuidocuments.Updation();
	nsuidocuments.enterdata();
	nsuidocuments.AllCombos();
	nsuidocuments.ValidAllCombos();
	nsuidocuments.BlankDoc();
	nsuidocuments.ValidBlankDoc();
	nsuidocuments.AddRep();
	nsuidocuments.Addrepsigner1();
	nsuidocuments.ValidAddRepSigner1();
	nsuidocuments.Saveuser();


}
}
