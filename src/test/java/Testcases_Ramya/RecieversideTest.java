package Testcases_Ramya;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.Recieverside;
import TestBase.Testcasebase;

public class RecieversideTest extends Testcasebase {
	Login login;
	Recieverside recieverside;


@BeforeMethod
public  void initialize() {
	setUpchrome();
	login = new Login(driver);
	recieverside = new Recieverside(driver);
		}
@Test
public void VerifyLoginFunctionalityWithValidCredantials() throws InterruptedException {
	login.Signin();
	login.VerifyLoginSucess();

}
@Test
public void VerifyRecieverside() throws Exception {
	login.Signin();
	login.VerifyLoginSucess();
	recieverside.AllCombos();
	recieverside.BlankDoc();
	recieverside.AddRep();
	recieverside.AddSigner();
	recieverside.Saveuser();
	recieverside.Receiverfields();
	recieverside.Senddocument();
	recieverside.ABCaccount();


}
	}
