package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Nsuidocuments {
	WebDriver driver;

	public Nsuidocuments(WebDriver driver) {
		this.driver = driver;
	}
	public void waitEle(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}
	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
	}
	public void AllCombos() throws InterruptedException {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Create Document']"));

	}
	public void ValidAllCombos() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='text-center text-dark fw-normal fs-4 mb-1']")));
		Assert.assertNotNull(Message, "Upload document element is not present Create document failed");
        System.out.println("Create document successfull");
	}
	@SuppressWarnings("deprecation")
	public void uploadDocument() throws Exception {
		
		Thread.sleep(10000);

		waitEle(By.xpath("//h4[@class='fw-normal blue pb-2']"));

		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe");

		waitEle(By.xpath("//button[@class='el-button text-center upload-btn el-button--danger']"));

		Thread.sleep(10000);
	}
	public void ValidUploadDocument() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button not present Create document failed");
        System.out.println("Upload document successfull");

	}
	@SuppressWarnings("deprecation")
	public void UploadMultipledocuments() throws IOException, InterruptedException {
		waitEle(By.xpath("//h4[@class='fw-normal blue pb-2']"));
		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\multiple document.exe");

		Thread.sleep(10000);
	}
	public void ValidUploadMultipleDocument() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button not present Create document failed");
        System.out.println("Upload document successfull");

	}
public void PCOnedoc() throws InterruptedException {
	Thread.sleep(10000);

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

	By Pconedoc = By.xpath("//span[@class='el-checkbox__inner']");
	WebElement Pconedoc2 = wait.until(ExpectedConditions.elementToBeClickable(Pconedoc));
	Pconedoc2.click();

//		waitEle(By.xpath("//span[@class='el-checkbox__inner']"));
	}
	public void ValidPCOneDoc() {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button is not present Create document failed");
        System.out.println("Process as a single Document successfull");

	}
	public void Nextbt() throws InterruptedException {

		waitEle(By.xpath("//span[normalize-space()='Next']"));
		Thread.sleep(10000);
	}
	public void ValidNextbtn() {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[normalize-space()='Add Recipients']")));
		Assert.assertNotNull(Message1, "Add Recipient not present Create document failed");
        System.out.println("Document successfull");

	}
	public void AddRep() throws InterruptedException {

		Thread.sleep(10000);

		waitEle(By.xpath("//img[@src='/img/Add Recipients.0f0af0e8.svg']"));

	}
	public void Addrepsigner1() throws InterruptedException {
		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[12]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select Signer Type']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
	}

	public void ValidAddRepSigner1() {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@x-placement]//ul//li[1]")));
		Assert.assertNotNull(Message1, "Signer present in Add Recipient failed");
        System.out.println("Signer  is successfull");
	}
	public void Saveuser() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Save Users']"));

	}
	public void Selecttofillrec() throws InterruptedException {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

	}
	public void Selectautofill() throws Throwable {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Add fields']"));
		Thread.sleep(10000);
	}
	public void Senddocument() throws InterruptedException {
		Thread.sleep(10000);

		By ad = By.xpath("//span[normalize-space()='Send Document']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Element clicked using JS.");
		} catch (Exception e) {

			System.out.println("Element not clickable or not found: ");
		}

		System.out.println("click on send Doc after drag and drop done successfully");
		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys("Test Sample");

		By ele2 = By.xpath("//textarea[@placeholder='Type your text here']");
		WebElement sen2 = wait.until(ExpectedConditions.elementToBeClickable(ele2));
		sen2.sendKeys("Test Sample");
		Thread.sleep(5000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		Thread.sleep(20000);
		
		By ad1 = By.xpath("//span[normalize-space()='Send Document']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad1));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Element clicked using JS.");
		} catch (Exception e) {

			System.out.println("Element not clickable or not found: ");
		}
		
		Thread.sleep(20000);
		
		waitEle(By.xpath("(//button[@class='el-dialog__headerbtn'])[3]"));
		
		Thread.sleep(10000);
	}
	public void BlankDoc() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//img[@src='/img/Blank.1f314c3f.svg']"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Document name']"), "test");

		waitEle(By.xpath("//input[@placeholder='Select number of pages']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("(//span[normalize-space()='Continue'])[2]"));

	}
	public void ValidBlankDoc() {

		WebDriverWait page = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement doc = page.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='fw-bold fs-24']")));
		Assert.assertNotNull(doc, "Add Recepient element is not present Create document failed");
        System.out.println("Upload document successfull");

	}
	private void waitAndClick(Actions actions, WebElement element, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		try {

			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

			actions.clickAndHold(clickableElement).moveToElement(target).release().build().perform();

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public void Receiverfields() throws InterruptedException {

		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		// ... (omitting the previous code for brevity)

		// Sign
		WebElement Sign = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='signatureEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		System.out.println("Signature Element Drag and Drop Done");


		//initial
		WebElement initial = driver.findElement(By.id("initialEle"));


//		//FullName
		WebElement fullName = driver.findElement(By.id("fullNameEle"));


//		//Date Signed
		WebElement Dsign = driver.findElement(By.id("dateSingedEle"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, Sign, Target);
		System.out.println("Sign Element Drag and Drop Done");

		waitAndClick(actions, initial, Target);
		System.out.println("Intial Element Drag and Drop Done");

		waitAndClick(actions, fullName, Target);
		System.out.println("Fullname Element Drag and Drop Done");

		waitAndClick(actions, Dsign, Target);
		System.out.println("dateSinged Element Drag and Drop Done");
 }
	public void Viewdoc() throws InterruptedException {

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='View Document']"));

	}
	public void Settings() throws InterruptedException {

		waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		waitEle(By.xpath("(//span[normalize-space()='Secure E-Sign'])[1]"));

		waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[2]"));

		waitEle(By.xpath("//button[@class='el-button type-2 el-button--default']"));
		
		

	}
	@SuppressWarnings("deprecation")
	public void changedoc() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));


		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

		waitEle(By.xpath("//img[@src='/img/attachment-filling.da0448d7.svg']"));

		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe");

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Continue']"));

		Thread.sleep(10000);

		Actions actions1 = new Actions(driver);

		WebElement Target = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"svg\"]")));

		// Sign
		WebElement Sign = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='signatureEle']")));
		actions1.clickAndHold(Sign).moveToElement(Target).release().build().perform();

		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		//signature

		Actions actions = new Actions(driver);

		WebElement Target1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"svg\"]")));

		// Sign
		WebElement Sign1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='signatureEle']")));
		actions.clickAndHold(Sign1).moveToElement(Target1).release().build().perform();
		}
	public void Lockfields() throws InterruptedException {

		waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//ul[@x-placement]//li)[3]"));

	}
	public void oneDriveupload() throws Exception {
		// driver.findElement(By.xpath("//img[@src='/img/onedrive.cc38d634.svg']"));
		Thread.sleep(10000);
		By Onedrive = By.xpath("//img[@src='/img/onedrive.cc38d634.svg']");
		WebDriverWait file = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement Upload = file.until(ExpectedConditions.elementToBeClickable(Onedrive));
		Upload.click();
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		String Parentwindowid = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[normalize-space()='Connect OneDrive']")).click();
		Thread.sleep(5000);

		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String childwindow : allwindowhandles) {
			if (!childwindow.endsWith(Parentwindowid)) {
				driver.switchTo().window(childwindow);
				driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("bsrv.prudhviraju@outlook.com");
				driver.findElement(By.xpath("//button[@id='idSIButton9']")).click();
				Thread.sleep(10000);
				By password = By.xpath("//input[@id='i0118']");
				WebDriverWait file1 = new WebDriverWait(driver, Duration.ofMinutes(3));
				WebElement Upload1 = file1.until(ExpectedConditions.elementToBeClickable(password));
				Upload1.sendKeys("Prjking@99");
				driver.findElement(By.xpath("//button[@id='idSIButton9']")).click();
				By password1 = By.xpath("//button[@id='acceptButton']");
				WebDriverWait file2 = new WebDriverWait(driver, Duration.ofMinutes(3));
				WebElement Upload2 = file2.until(ExpectedConditions.elementToBeClickable(password1));
				Upload2.click();
				Thread.sleep(5000);
				Set<String> windowHandles1 = driver.getWindowHandles();
				for (String handle :windowHandles1) { driver.switchTo().window(handle);
				}
				Thread.sleep(10000);
				driver.findElement(By.xpath("//span//span[normalize-space()='Document 1.docx']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span[@title='Upload']")).click();
				Thread.sleep(10000);

				System.out.println("One drive file uploaded");

//				//driver.findElement(By.xpath(""))
//				driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
			}
		}
	}
	public void DocscenariosGdrive() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//img[@placeholder=\"top-start\"]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid = driver.getWindowHandle();
		waitEle(By.xpath("//span[normalize-space()=\"Sign in with Google\"]"));
		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String childwindow : allwindowhandles) {
			if (!childwindow.endsWith(Parentwindowid)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
				driver.findElement(By.xpath("//input[@id=\"identifierId\"]")).sendKeys("n180894@rguktn.ac.in");

				waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));
				Thread.sleep(10000);
				Set<String> windowHandles1 = driver.getWindowHandles();
				for (String handle : windowHandles1) {
					driver.switchTo().window(handle);

				}
				driver.findElement(By.xpath("//input[@name=\"Passwd\"]")).sendKeys("meghu@123");
				waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));
				Thread.sleep(10000);
				Set<String> windowHandles11 = driver.getWindowHandles();
				for (String handle : windowHandles11) {
					driver.switchTo().window(handle);

				}

				waitEle(By.xpath("(//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-INsAgc VfPpkd-LgbsSe-OWXEXe-dgl2Hf Rj2Mlf OLiIxf PDpWxe P62QJc LQeN7 BqKGqe pIzcPc TrZEUc lw1w4b'])[2]"));
				waitEle(By.xpath("//span[normalize-space()='Allow']"));

				Thread.sleep(10000);
				Set<String> windowHandles111 = driver.getWindowHandles();
				for (String handle : windowHandles111) {
					driver.switchTo().window(handle);

				}
				Thread.sleep(10000);
				waitEle(By.xpath("(//div[@class='fsp-grid__cell'])[5]"));
				Set<String> windowHandles2 = driver.getWindowHandles();
				for (String handle : windowHandles2) {
					driver.switchTo().window(handle);

				}
				waitEle(By.xpath("//span[@class='fsp-button fsp-button--primary fsp-button-upload']"));

				System.out.println("Google drive file uploaded");
			}
		}

	}
	private static int counter = 0;

	public static String generateUniqueString() {
		return "unique_string_sample" + UUID.randomUUID().toString().substring(0, 8) + counter++;

	}

	public void FormTemplate() throws Exception {
		Thread.sleep(10000);

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		Thread.sleep(10000);

		waitEle(By.xpath("//span[@class='el-icon-arrow-down text-white']"));

		Thread.sleep(3000);

		By Entities = By.xpath("(//img[@src='/img/Form_Inactive.622b7154.svg'])[1]");
		WebElement Entities1 = wait.until(ExpectedConditions.elementToBeClickable(Entities));
		Entities1.click();

		System.out.println("Clicked on Form template in profile completed");

	}
	public void CreateFormtemplate() throws Exception {

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By ad = By.xpath("//button[normalize-space()='Create Template']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on ceate form template using JS.");

		By Name = By.xpath("//input[@placeholder='Enter Template Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name1.sendKeys(generateUniqueString());

		sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Template Description']"),"Test purpose");

		waitEle(By.xpath("(//span[normalize-space()='Submit'])[1]"));
	}
	public void Managetab() throws InterruptedException {
	Set<String> windowHandles111 = driver.getWindowHandles();
	for (String handle : windowHandles111) {
		driver.switchTo().window(handle);
	}
	Thread.sleep(10000);
	}
	public void Addbasicfields() throws Exception {

		waitEle(By.xpath("(//div[normalize-space()='Basic Fields'])[2]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);

		WebElement Singlelinetext = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[1]"));

		waitAndClick(actions,Singlelinetext,Target);

		System.out.println("Singleline Drag and Drop Done");

		Managetab();

		By SName = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement SName1 = wait.until(ExpectedConditions.elementToBeClickable(SName));
		SName1.sendKeys("Single line text");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Multiline = driver
				.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[2]"));


		waitAndClick(actions, Multiline, Target);

		System.out.println("Multiline Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Multiline");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Number Of Rows']"), "3");

		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Select = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[3]"));

		waitAndClick(actions,Select,Target);

		System.out.println("Select Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"Select");

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"Computer science");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"maths");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"Physics");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Number = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[4]"));

		waitAndClick(actions, Number, Target);

		System.out.println("Number Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"Number");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement MultiSelect = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[5]"));

		waitAndClick(actions, MultiSelect, Target);

		System.out.println("MultiSelect Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"Multiselect");

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"Computer science");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"maths");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"Physics");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));


		WebElement List = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[6]"));

		waitAndClick(actions, List, Target);

		System.out.println("List Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"List");

		Thread.sleep(10000);

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Name']"),"List");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Value']"),"123");

		waitEle(By.xpath("//button[@class='el-button f-weight-600 el-button--primary']"));

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Date = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[7]"));

		waitAndClick(actions, Date, Target);

		System.out.println("Date Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"Date");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Time = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[8]"));

		waitAndClick(actions, Time, Target);

		System.out.println("Time Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"Time");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement FixedTime = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[9]"));

		waitAndClick(actions, FixedTime, Target);

		System.out.println("FixedTime Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"FixedTime");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement TimeRange = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[10]"));

		waitAndClick(actions, TimeRange, Target);

		System.out.println("TimeRange Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"TimeRange");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement DateTime = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[11]"));

		waitAndClick(actions, DateTime, Target);

		System.out.println("DateTime Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"DateTime");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Weekdays = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[12]"));

		waitAndClick(actions, Weekdays, Target);

		System.out.println("Weekdays Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"Weekdays");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement DateTimerange = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[13]"));

		waitAndClick(actions, DateTimerange, Target);

		System.out.println("DateTimerange Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"DateTimerange");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement DateRange = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[14]"));

		waitAndClick(actions, DateRange, Target);

		System.out.println("DateRange Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"DateRange");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement YesorNo = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[15]"));

		waitAndClick(actions, YesorNo, Target);

		System.out.println("YesorNo Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"YesorNo");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Checkbox = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[16]"));

		waitAndClick(actions, Checkbox, Target);

		System.out.println("Checkbox Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"Checkbox");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Checkboxgroup = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[17]"));

		waitAndClick(actions, Checkboxgroup, Target);

		System.out.println("Checkboxgroup Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"CheckboxGroup");

		sendKeysToElement(By.xpath("(//div[@class='el-input']//input[@class='el-input__inner'])[2]"),"1");

		sendKeysToElement(By.xpath("(//div[@class='el-input']//input[@class='el-input__inner'])[3]"),"2");

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"1");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"2");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"3");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Document = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[18]"));

		waitAndClick(actions, Document, Target);

		System.out.println("Document Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"Document");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Radio = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[19]"));

		waitAndClick(actions,Radio, Target);

		System.out.println("Radio Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"Radio");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Radiogroup = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[20]"));

		waitAndClick(actions, Radiogroup, Target);

		System.out.println("Radio Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"RadioGroup");

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"1");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"2");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"3");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Phoneno = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[21]"));

		waitAndClick(actions,Phoneno, Target);

		System.out.println("Phoneno Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"Phonono");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Sign = driver.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[22]"));

		waitAndClick(actions,Sign, Target);

		System.out.println("Sign Element Drag and Drop Done");

		Managetab();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),"Sign");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		waitEle(By.xpath("//span[normalize-space()='Save']"));

	}
	public void AddTocompanyprofile() {

		waitEle(By.xpath("(//tr[@class='el-table__row']//span[@class='el-checkbox__inner'])[1]"));

		waitEle(By.xpath("//button[@class='btn btn-sm btn-outline-primary  add-button float-right m-lr-1']"));
		}
	public void Entity() throws Exception {
		Thread.sleep(10000);

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		Thread.sleep(3000);

		waitEle(By.xpath("//div[@class=\"icon-text\"]"));

		Thread.sleep(3000);

		By Entities = By.xpath("(//img[@src='/img/Entities Inactive.4c2a8f0e.svg'])[1]");
		WebElement Entities1 = wait.until(ExpectedConditions.elementToBeClickable(Entities));
		Entities1.click();

		System.out.println("Clicked on entities in profile completed");

		Thread.sleep(10000);

	}
	public void ClickCreateEntity() throws Exception {
		Thread.sleep(10000);

		By ad = By.xpath("//button[normalize-space()='Create Entity']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on ceate entity using JS.");

	}
	public void CreateEntity() throws Exception {

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		try {
			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		By Title = By.xpath("//input[@placeholder='Title']");
		WebElement Title1 = wait.until(ExpectedConditions.elementToBeClickable(Title));
		Title1.sendKeys(generateUniqueString());

		sendKeysToElement(By.xpath("//textarea[@placeholder='Description']"),"This entity is only for testing purpose");

		waitEle(By.xpath("//span[normalize-space()='INDIVIDUAL']"));

		waitEle(By.xpath("//p[normalize-space()='Create a new app base with custom fields,tables, and filters.']"));

		WebElement ele = driver.findElement(By.xpath("//button[@class='btn btn btn-outline-primary btn-sm m-lr-1']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele);

		waitEle(By.xpath("//button[@class='btn btn btn-outline-primary btn-sm m-lr-1']"));

		System.out.println("Create entity successfull");

	}
	public void addtemplatetIndividualentity() throws Exception {
		Thread.sleep(10000);
		By ad = By.xpath("(//div[@class='el-scrollbar__view'])[2]//button[1]");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));


	}
	public void RemoveWarning() throws InterruptedException {

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}

		Thread.sleep(10000);

		By ad = By.xpath("//button[@class='el-button el-button--primary mt-1 mr-1']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on Update& Next using JS.");
	}

	public void Updation() throws Exception {

		RemoveWarning();

		RemoveWarning();

		RemoveWarning();

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='el-button mt-1 mr-1 el-button--primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println("Document Done Sucessfully");

	}
	public void Perform() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[1]//span[normalize-space()='Actions']"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).perform();

	}
	public void enterdata() throws Exception {

		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}
		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button el-tooltip entity-add-btn el-button--primary']"));

		sendKeysToElement(By.xpath("//input[@placeholder='First Name']"),"Tejasri");

		sendKeysToElement(By.xpath("//input[@placeholder='Last Name']"),"Aluri");

		sendKeysToElement(By.xpath("//input[@placeholder='Email']"),"tejasri.");

		waitEle(By.xpath("//button[@class='el-button scaling-button el-button--primary el-button--mini']"));

		waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[1]"));

		waitEle(By.xpath("//button[@class='el-button scaling-button el-button--primary el-button--mini']"));
}
	public void ABCaccount() throws Exception {
		
		Thread.sleep(20000);
		driver.get("https://email.ionos.com/");
 
		sendKeysToElement(By.xpath("//input[@id='username']"), "*@abccorp.org");
 
		waitEle(By.xpath("//button[@class='button button--primary button--full-width button--with-loader']"));
 
		sendKeysToElement(By.xpath("//input[@id='password']"), "Itserve123#");
 
		waitEle(By.xpath("//button[@class='button button--primary button--full-width button--with-loader']"));
 
		System.out.println("Signin successfull");
 
		waitEle(By.xpath("(//div[@class='abs list-view-control toolbar-top-visible']//ul//li[2])[4]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement iframeElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='mail-detail-frame']")));
		driver.switchTo().frame(iframeElement);
 
		Thread.sleep(10000);
 
		WebElement copy = driver.findElement(By.xpath("//tbody//span[text()]"));
		Thread.sleep(10000);
		Actions action = new Actions(driver);
		action.doubleClick(copy).perform();
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		System.out.println("copied otp successfull");
	
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[normalize-space()='Review & sign']//a")));
        element.click();
        
        System.out.println("clicked on review and sign");
        
        String Parentwindowid1 = driver.getWindowHandle();
        
        Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
		WebElement paste = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter 6 letters code']")));
		paste.sendKeys(Keys.CONTROL + "v");
		
		System.out.println("pasted otp successfull");
 
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--primary']")));
		button.click();
		
			}
		}
		Thread.sleep(10000);
 
		waitEle(By.xpath("//span[@class='el-checkbox__inner']"));
 
		Thread.sleep(10000);
 
		waitEle(By.xpath("//span[text()='Continue']"));
		
		System.out.println("clicked on continue");
		Thread.sleep(10000);
 
		sendKeysToElement(By.xpath("(//input[@placeholder='Enter Value'])[1]"), "Ramya");
		
		sendKeysToElement(By.xpath("(//input[@placeholder='Enter Value'])[2]"), "sibbala");
		
		sendKeysToElement(By.xpath("(//input[@placeholder='Enter Value'])[3]"), "1234567890");
		
		sendKeysToElement(By.xpath("(//input[@placeholder='Enter Value'])[4]"), "Tirupathi");
		
		sendKeysToElement(By.xpath("(//input[@placeholder='Enter Value'])[5]"), "517194");
		
		waitEle(By.xpath("//button[@class='el-button finish-drawer-finish el-button--danger el-button--mini']"));
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));
		
		
		
		
		
//		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[1]"));
//		
//		System.out.println("signature successfull");
//		
//		Thread.sleep(10000);
//		
//		waitEle(By.xpath("//button[@class='el-tooltip tooltip active']"));
//		
//		Thread.sleep(10000);
//		
//		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[1]"));
//		
//		waitEle(By.xpath("//button[@class='el-button finish-drawer-finish el-button--danger el-button--mini']"));
//		

}
}


