package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Documents {
	WebDriver driver;
	public Documents(WebDriver driver) {
		this.driver = driver;
	}
//	 Hover on document to click on an action
	public void Perform() throws Exception {
			Thread.sleep(1000);
			WebElement elementToHover2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));
			Actions actions2 = new Actions(driver);
			actions2.moveToElement(elementToHover2).perform();

		}
	public void waitEle(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}
	public void DraftStatus() throws InterruptedException {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		waitEle(By.xpath("//input[@placeholder='Select Status']"));
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

	}
	public boolean VerifyDraft() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        WebElement Draft = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Draft'])[1]")));
        System.out.println("Draft Status Successful");
        return Draft.isDisplayed();
	}
	public void DraftSentDocument() throws Exception {

		Perform();
		waitEle(By.xpath("//ul[@x-placement]//a[1]"));


	}
	public boolean ValidDraftSendDocument() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Send Document Successful");
	        return Success.isDisplayed();
	}
	public void DraftSaveAsTemplate() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

	}
	public boolean ValidDraftSaveasTemplate(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Save as Template Successful");
	        return Success.isDisplayed();
	}
	public void DraftrenameDocument() throws Exception {
		Perform();
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("Rename2");
		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

	}
	public boolean ValidDraftRenameDocument(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Rename Document Successful");
	        return Success.isDisplayed();
	}
	public void Draftdocumentsetting() throws Exception {
		Perform();
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

		waitEle(By.xpath("//span[normalize-space()='Save']"));

	}
	public boolean ValidDraftDocumentSettings(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Document settings Successful");
	        return Success.isDisplayed();
	}
	public void DraftDeletedocument() throws Exception {
		Perform();
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}
	public boolean ValidDraftDeleteDocument(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Delete Document Successful");
	        return Success.isDisplayed();
	}
	

	public void SentStatus() throws InterruptedException {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		waitEle(By.xpath("//input[@placeholder='Select Status']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

	}
	public boolean ValidSent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement Sent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Sent'])[1]")));
        System.out.println("Sent Status Successful");
        return Sent.isDisplayed();
	}
	public void SentcorrectDocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

		}
	public boolean ValidSentcorrectDocument(){

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
        System.out.println("Correct Document Successful");
        return Success.isDisplayed();
	}
	public void SentResenddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		Thread.sleep(10000);
		waitEle(By.xpath("(//span[normalize-space()='Resend'])[1]"));

		waitEle(By.xpath("//button[@class='close-button']"));

	}
	public boolean ValidSentResenddocument(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
        System.out.println("Resend Document Successful");
        return Success.isDisplayed();
	}
	public void SentsavetoTemplate() throws Exception {
		Thread.sleep(10000);
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

		}
	public boolean ValidSentsavetoTemplate(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
        System.out.println("Save To Template Successful");
        return Success.isDisplayed();
	}
	public void SentVoiddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		waitEle(By.xpath("//span[normalize-space()='Yes']"));

	}
	public boolean ValidSentVoiddocument(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
        System.out.println("Void Document Successful");
        return Success.isDisplayed();
	}
	public void SentRenamedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[6]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("Rename");

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

	}
	public boolean ValidSentRenamedocument(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
        System.out.println("Rename Document Successful");
        return Success.isDisplayed();
	}
	public void Sentdocumentsettings() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[7]"));

		waitEle(By.xpath("//span[normalize-space()='Save']"));


	}
	public boolean ValidSentdocumentsettings(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
        System.out.println("Document Settings Successful");
        return Success.isDisplayed();
	}
	public void SentDeletedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[8]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}
	public boolean ValidSentDeletedocument(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
        System.out.println("Delete Document Successful");
        return Success.isDisplayed();
	}
	public void SentDownloaddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[9]"));

		System.out.println("Download Original Document Successful");
	}

	public void ApprovedStatus() throws InterruptedException {

		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		waitEle(By.xpath("//input[@placeholder='Select Status']"));
		
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
		
		Thread.sleep(10000);

	}
	public void VerifySelectStatus() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
	        WebElement ApprovedDocuments = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Approved'])[1]")));


	        Assert.assertNotNull(ApprovedDocuments, "Approveddocuments is not presents it is failed");
	        System.out.println("Approved Document Select Status Successful");
	}

	public void ApprovedCorrectdocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

		}
	public boolean ValidApprovedCorrectdocument(){
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
	        WebElement Error = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Correct Document Successful");
	        return Error.isDisplayed();
	}
	public void ApprovedResenddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Resend']"));


	}
	public boolean ValidResendDocument(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Resend Document Successful");
	        return Success.isDisplayed();
	}
	public void ApprovedSaveastemplate() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

	}
	public boolean ValidSaveAsTemplate(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Save As Template Successful");
	        return Success.isDisplayed();
	}
	public void ApprovedVoiddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		waitEle(By.xpath("//span[normalize-space()='Yes']"));

	}
	public boolean ValidVoidDocument(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("VoidDocument Successful");
	        return Success.isDisplayed();
	}
	public void ApprovedRenamedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[6]"));

//		waitEle(By.xpath("//span[normalize-space()='Yes']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("approve");

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

	}
	public boolean ValidRenameDocument(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Rename Successful");
	        return Success.isDisplayed();
	}
	public void ApprovedDocumentsettings() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[7]"));

		waitEle(By.xpath("//span[normalize-space()='Save']"));

}
	public boolean ValidDocumentSettings(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Documentsettings Successful");
	        return Success.isDisplayed();
	}
	public void ApprovedDeletedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[8]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

}
	public boolean ValidDeleteDocument(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Delete document Successful");
	        return Success.isDisplayed();
	}

	
	public void DeclinedStatus() throws InterruptedException {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Documents']"));
		
		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select Status']"));
		
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));

		Thread.sleep(10000);

	}
	public boolean VerifyDeclined() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement Declined = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Declined'])[1]")));
        System.out.println("Declined Status Successful");
        return Declined.isDisplayed();
	}
	public void DeclinedSaveastemplate() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

		}
	public boolean ValidDeclinedSaveastemplate(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Save As Template Successful");
	        return Success.isDisplayed();
	}
	public void DeclinedVoiddocument() throws Exception {
		Perform();
		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Yes']"));

	}
	public boolean ValidDeclinedVoiddocument() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Void Document Successful");
	        return Success.isDisplayed();
	}
	public void DeclinedRenamedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();
		Thread.sleep(10000);

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("Decline");
		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

	}
	public boolean ValidDeclinedRenamedocument(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Rename Document Successful");
	        return Success.isDisplayed();
	}
	public void DeclinedDocumentsettings() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		waitEle(By.xpath("//span[normalize-space()='Save']"));

}
	public boolean ValidDeclinedDocumentSettings(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Document Settings Successful");
	        return Success.isDisplayed();
	}
	public void DeclinedDeletedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[6]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

}
	public boolean ValidDeclinedDeleteDocument() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Delete Document Successful");
	        return Success.isDisplayed();
	}

	public void VoidStatus() throws InterruptedException {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Documents']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select Status']"));
		
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[6]"));

		Thread.sleep(10000);

	}
	public boolean ValidVoid(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement Void = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Voided'])[1]")));
        System.out.println("Void Status Successful");
        return Void.isDisplayed();
	}
	public void VoidSaveastemplate() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

}
public boolean ValidVoidSaveastemplate() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
    System.out.println("Save As Template Successful");
    return Success.isDisplayed();
}
	public void VoidClonedocument() throws Exception {
		Perform();

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

}
	public boolean ValidVoidClonedocument(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	    WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	    System.out.println("Clone Document Successful");
	    return Success.isDisplayed();
	}
	public void VoidDeletedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

}
	public boolean ValidVoidDeletedocument(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	    WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	    System.out.println("Delete Document Successful");
	    return Success.isDisplayed();
	}

	public void ArchievdStatus() throws InterruptedException {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		waitEle(By.xpath("//input[@placeholder='Select Status']"));
		
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[7]"));

	}
	public boolean VerifyArchieved() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
	        WebElement Archieved = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Archived'])[1]")));
	        System.out.println("Archieved Status Successful");
	        return Archieved.isDisplayed();

	}
	public void ArchivedRenamedocuments() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();
		Thread.sleep(10000);

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("Archieved");
		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

	}
	public boolean ValidRenamedocument() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Rename Document Successful");
	        return Success.isDisplayed();
	}
	public void ArchivedUndodocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}
	public boolean ValidUndodocument(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Undo Document Successful");
	        return Success.isDisplayed();
	}
	public void ArchivedPermanentdelete() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

}
	public boolean ValidPermanentDelete(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Permanet Delete Document Successful");
	        return Success.isDisplayed();
	}
	public void CompletedStatus() throws InterruptedException {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Documents']"));
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//input[@placeholder='Select Status']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[8]"));

	}
	public boolean VerifyCompleted(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement Completed = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Completed'])[1]")));
        System.out.println("completed Status Successful");
        return Completed.isDisplayed();
	}
	public void CompletedSaveastemplate() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

	}
	public boolean ValidSaveastemplate(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Save As Template Document Successful");
	        return Success.isDisplayed();

	}

	public void CompletedSharewithothers() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='ramyasibbala200@outlook.com']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		waitEle(By.xpath("//span[normalize-space()='Save & Update']"));

	}
	public boolean ValidCompletedSharewithothers(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Share With Users Successful");
	        return Success.isDisplayed();
	}
	public void CompletedClonedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

	}
	public boolean ValidCompletedClonedocument() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Clone Document Successful");
	        return Success.isDisplayed();
	}
	public void CompletedRenamedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();
		Thread.sleep(10000);

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("test");
		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));



	}
	public boolean ValidCompletedRenamedocument() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Rename Document Successful");
	        return Success.isDisplayed();
	}
	public void CompletedDownloaddocuement() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[6]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		
		waitEle(By.xpath("//td[@class='el-table_3_column_17   el-table__cell']"));

//		waitEle(By.xpath("(//i[@class='el-icon-download'])[41]"));

		System.out.println("Download Document Successful");
		Thread.sleep(10000);
	}
	public void CompletedDeletedocuement() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[7]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

}
	public boolean ValidCompletedDeletedocument(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Delete Document Successful");
	        return Success.isDisplayed();
	}
	
	public void CompletedSenttomail() throws Exception {
		Perform();
		
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[8]"));

		waitEle(By.xpath("//input[@class='el-select__input']"));

		waitEle(By.xpath("//ul//li[text()=' ramyasibbala200@outlook.com ']"));
		
		Thread.sleep(1000);
		
		waitEle(By.xpath("//input[@class='el-select__input']"));

		waitEle(By.xpath("//span[normalize-space()='Send']"));

	}
	public boolean ValidCompletedSenttomail(){
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	        System.out.println("Sent to mail Successful");
	        return Success.isDisplayed();
	}
	public void WaitingformeStatus() throws InterruptedException {

		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		waitEle(By.xpath("//input[@placeholder='Select Status']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[9]"));
		
		Thread.sleep(10000);

	}
	public boolean ValidWaitingforme() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	    WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Sent'])[1]")));
	    System.out.println("Waitingforme Successful");
	    return Success.isDisplayed();
	}
	public void WaitformeWaitforme() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

	}

	public void Waitingforotherstatus() throws InterruptedException {
		
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Documents']"));
		
		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select Status']"));
		
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[10]"));

	}
	public boolean ValidWaitingforothers() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	    WebElement Void = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@x-placement]//ul//li[10]")));
	    System.out.println("waiting for other Status Successful");
	    return Void.isDisplayed();

	}

	public void WaitingForOthersCorrectdocument() throws Exception {

		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));
		
		Thread.sleep(10000);

	}
	public boolean ValidWaitingForOthersCorrectdocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	    WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	    System.out.println("Correct Document Successful");
	    return Success.isDisplayed();
	}
	public void WaitingForOthersResenddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Resend']"));
//
//		waitTill(By.xpath("(//button//i)[15]"));

	}
public boolean ValidWaitingForOthersResenddocument() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
    System.out.println("Resend Document Successful");
    return Success.isDisplayed();
}
	public void WaitingForOthersSaveastemplate() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

	}
	public boolean ValidWaitingForOthersSaveastemplate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	    WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	    System.out.println("Save As Template Successful");
	    return Success.isDisplayed();
	}
	public void WaitingForOthersVoiddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		waitEle(By.xpath("//span[normalize-space()='Yes']"));

}
	public boolean ValidWaitingForOthersVoiddocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	    WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	    System.out.println("Void Document Successful");
	    return Success.isDisplayed();
	}
	public void WaitingForOthersRenamedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[6]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("hfsdbjhdk");

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

}
public boolean ValidWaitingForOthersRenamedocument() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
    System.out.println("Rename Document Successful");
    return Success.isDisplayed();
}
public void WaitingForOthersDocumentsettings() throws Exception {
	Perform();

	waitEle(By.xpath("//ul[@x-placement]//a[7]"));

	waitEle(By.xpath("//span[normalize-space()='Save']"));

}
	public boolean ValidWaitingForOthersDocumentsettings() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Document Settings Successful");
		return Success.isDisplayed();
}
	public void WaitingForOthersDeletedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[8]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

}
	public boolean ValidWaitingForOthersDeletedocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	    WebElement Success = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
	    System.out.println("Delete Document Successful");
	    return Success.isDisplayed();
	}

	public void WaitingForOthersDownloadoriginal() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[9]"));

		System.out.println("Download Original Successful");
	}

	public void clickondocuments() throws InterruptedException {
		
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Documents']"));
	}
	public void BuldDelete() throws InterruptedException {
		
		Thread.sleep(20000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("(//span[@class='el-checkbox__input'])[1]");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();
		
//		waitEle(By.xpath("(//span[@class='el-checkbox__input'])[1]"));
		
		waitEle(By.xpath("//button[@class='el-button el-dropdown-link px-2 el-button--default el-button--mini el-dropdown-selfdefine ']"));
		
		waitEle(By.xpath("//ul[@x-placement]//li[1]"));
		
		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[1]"));
		
	}

}
