package Testcases_Ramya;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Documents;
import Pages.DocumentsScenarios;
import Pages.Login;
import Pages.Newdocument;
import Pages.Recieverside;
import TestBase.Testcasebase;

public class Documents1 extends Testcasebase {
	Login login;
	Documents documents;
	Newdocument newdocument;
	DocumentsScenarios documentsScenarios;
	Recieverside recieverside;

@BeforeMethod
public  void initialize() {
	setUpchrome();
	login = new Login(driver);
	documents = new Documents(driver);
	newdocument = new Newdocument(driver);
	documentsScenarios = new DocumentsScenarios(driver);
	recieverside = new Recieverside(driver);



}
@Test()
public void VerifyLoginFunctionalityWithValidCredantials() throws InterruptedException {
	login.Signin();
	login.VerifyLoginSucess();

}



}
