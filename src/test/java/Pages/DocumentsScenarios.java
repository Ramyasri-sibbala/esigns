package Pages;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class DocumentsScenarios {
	
	static WebDriver driver;

	public DocumentsScenarios(WebDriver driver) {

		this.driver = driver;

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}
	public void waitEle1(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).clear();
	}
	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
	}

	@SuppressWarnings("unused")
	private void waitAndClick(Actions actions, WebElement element, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		try {

			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

			actions.clickAndHold(clickableElement).moveToElement(target).release().build().perform();

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void DocScenario() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}

		By ad = By.xpath("//span[normalize-space()='Documents']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			WebElement docu = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//h3[@class='fw-medium blue-dark mb-3 fs-6']")));
			Assert.notNull(docu, "Documents");
			System.out.println("Clicked On Documents using JS successfully");

		} catch (Exception e) {

			System.out.println("Element not clickable or not found: ");
		}
		Thread.sleep(10000);
		
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='el-button scaling-button el-button--primary create-btn px-4 ml-2']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
 

	}

	public boolean ValidDocScenario() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[normalize-space()='Documents']")));
		System.out.println("click Document Successful");
		return Success.isDisplayed();
	}
	public void Templatesceanario() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}

		By ad = By.xpath("//span[normalize-space()='Templates']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			
		} catch (Exception e) {

			System.out.println("Element not clickable or not found: ");
		}
		
		
	}
	public void CreateBlankTemplate(String s) throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='el-button create-btn px-2 ml-2 p-05 el-button--primary el-button--medium']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		waitEle(By.xpath("//span[normalize-space()='Blank template']"));
		
		waitEle(By.xpath("//span[normalize-space()='Continue as Blank Template']"));
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter template name']"), s);
		
		waitEle(By.xpath("//span[normalize-space()='Continue']"));
		
			}
	public void Templateactions() throws Exception {
		Perform();
		
		waitEle(By.xpath("//ul[@x-placement]//a[2]"));
		
		Thread.sleep(10000);
		}
	public void Docsend(int id, String Mail) throws Exception {
		
		Thread.sleep(10000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()=\"Send Document\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		Thread.sleep(3000);
		System.out.println("click on Search with email done Successfully");
		String xpath21 = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']", id);
		waitEle(By.xpath(xpath21));
		Thread.sleep(1000);
		
		System.out.println("click on Search with email done Successfully");
		String xpath3 = String.format("//div[@x-placement]//li[text()=\" %s \"]", Mail);
		waitEle(By.xpath(xpath3));
		
//		sendKeysToElement(By.xpath(xpath21), Mail);
//		
//		waitEle(By.xpath("//span[normalize-space()='Save Users']"));
//		Thread.sleep(1000);
//		
//		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));
//		
//		windowHandle();
//		
//		waitEle(By.xpath("//i[@class='el-icon-circle-plus-outline']"));
//		
//		windowHandle();
//		
//		String xpath3 = String.format("//input[@placeholder='Single line text']");
//		waitEle(By.xpath(xpath3));
//		Thread.sleep(1000);
//		sendKeysToElement(By.xpath(xpath3), Name);
//		
////		WebElement element1 = wait
////				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='el-radio__inner'])[1]")));
////		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
//		
////		
////		waitEle(By.xpath("//div[@class=\"v-modal\"]"));
//		
//		Thread.sleep(3000);
//		
//        waitEle(By.xpath("//span[text()=' Add Account ']"));
//
//        Thread.sleep(10000);
//		waitEle(By.xpath("(//span[normalize-space()='Save'])[3]"));
	}
	public void BlankDoc(String s) throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		waitEle(By.xpath("//img[@src='/img/Blank.1f314c3f.svg']"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		By Element2 = By.xpath("//input[@placeholder='Enter Document name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.sendKeys(s);

		waitEle(By.xpath("//input[@placeholder='Select number of pages']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("//span[normalize-space()='Continue']"));

	}
	public void Signorder() throws Exception {
		
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Enforce Signature Order']"));
		System.out.println("Enforce signature order enabled successfully");

	}

	public void Saveuser() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Save Users']"));
		System.out.println("Clicked on save users successfull");
		Thread.sleep(1000);

	}
	
	public void waitAndClick(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();
	}
	public void Copylink() throws Exception {
		
		waitEle(By.xpath("//button[@class='el-button el-tooltip manage-recipients ml-2 el-button--default is-plain']"));
		
		waitEle(By.xpath("(//img[@src='/img/more-icon.dca8767b.svg'])[1]"));
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("(//ul[@class='el-dropdown-menu el-popper']//a[1])[2]"));
		
		waitEle(By.xpath("(//i[@class='el-dialog__close el-icon el-icon-close'])[6]"));
		
	}
	public void Viewcommenteddocument() throws Exception {
		
		String Parentwindowid1 = driver.getWindowHandle();
		waitEle(By.xpath("//a[text()=\"View the document\"]"));
		Thread.sleep(10000);
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(1000);
				driver.switchTo().window(Parentwindowid1).close();
				driver.switchTo().window(childwindow);
 
				Thread.sleep(1000);
			}
		}
	}
	public void Changeruser() throws Exception {
		
		waitEle(By.xpath("//button[@class='el-button el-tooltip manage-recipients ml-2 el-button--default is-plain']"));
		
		waitEle(By.xpath("(//img[@src='/img/more-icon.dca8767b.svg'])[1]"));
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("(//ul[@class='el-dropdown-menu el-popper']//a[2])[2]"));
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter first name']")));
        element.clear();
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter first name']"), "Prudvi");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter last name']")));
        element1.clear();
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter last name']"),"B");
		
		waitEle(By.xpath("//i[@class='el-select__caret el-input__icon el-icon-arrow-up']"));
		
		waitEle(By.xpath("//input[@placeholder='Enter email']"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
		
		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[2]"));
		}
	public void Deletepages() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//canvas[@id='0_canvas_page_2']"));

		waitEle(By.xpath("(//button[@class='el-button el-tooltip item el-button--default el-button--mini is-plain is-circle'])[6]"));
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));
		
		Thread.sleep(10000);
		
		System.out.println("Deleted existing page from the existed document");
		
			}
	public void Addpages() throws Exception {
		Thread.sleep(10000);
		
	waitEle(By.xpath("(//button[@class='el-button el-tooltip add-page-top item el-button--default is-plain'])[2]"));
	
	Thread.sleep(10000);
	
	waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));
	
	Thread.sleep(10000);
	
	waitEle(By.xpath("(//button[@class='el-button el-tooltip add-page-top item el-button--default is-plain'])[2]"));
	
	Thread.sleep(10000);
	
	waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));
	
	Thread.sleep(10000);
	
	System.out.println("Added pages succesfully for the uploaded document");
		
		}
	public void Lockfields() throws Exception {
		
		Thread.sleep(10000);

		waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//span[@class='el-checkbox__inner']"));
		
		Thread.sleep(10000);
		
		System.out.println("Locked fields successfully");

	}
	@SuppressWarnings("deprecation")
	public void changedoc() throws Exception {
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//img[@class='arrows']"));

//		waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));
		
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

		waitEle(By.xpath("//img[@src='/img/attachment-filling.da0448d7.svg']"));

		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe");
		
		Thread.sleep(10000);

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[8]"));
		
		Thread.sleep(10000);

	}
	public void otheroptionsdelete() throws Exception {
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[9]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

		System.out.println("clicked on delete");

	}
	public void clickondocuments() throws Exception {
		
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Documents']"));
	}
	@SuppressWarnings("deprecation")
	public void UploadMultipledocuments() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//h4[@class='fw-normal blue pb-2']"));
		Runtime.getRuntime()
				.exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\multiple document.exe");

		Thread.sleep(10000);
	}
	public void PCOnedoc() throws Exception {

		waitEle(By.xpath("//span[@class='el-checkbox__inner']"));
		
		System.out.println("clicked on processitassingle");
	}
	public void SaveAsDraft() throws Exception {
		
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Save Draft']"));
	}
	public void EntityMappingSettings() throws Exception {
		
		Thread.sleep(10000);

	waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));
	
	Thread.sleep(10000);

	waitEle(By.xpath("//ul[@x-placement]//a[1]"));

	Set<String> windowHandles = driver.getWindowHandles();
	for (String handle : windowHandles) {
		driver.switchTo().window(handle);
	}
	
	Thread.sleep(10000);

//	waitEle(By.xpath("(//span[normalize-space()='Secure E-Sign'])[1]"));

//	waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[2]"));
	
	Thread.sleep(10000);

	waitEle(By.xpath("//button[@class='el-button type-2 el-button--default']"));

}
	public void Finishdocument() throws Exception {
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//span[normalize-space()='Finish Document']"));
		
		Thread.sleep(10000);
		
		System.out.println("Document completed");
		
		
	}
	public void Senddoc() throws Exception {
		
		Thread.sleep(10000);
		 
		waitEle(By.xpath("//span[normalize-space()=\"Send Document\"]"));
		System.out.println("click on send Doc after drag and drop done successfully");
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys("Test Sample");
 
		By ele2 = By.xpath("//textarea[@placeholder='Type your text here' or @placeholder='Type your message here']");
		WebElement sen2 = wait.until(ExpectedConditions.elementToBeClickable(ele2));
		sen2.sendKeys("Test Sample");
		Thread.sleep(5000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
 
	}
	public void switchEmail() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@class=\"_8ZYZKvxC8bvw1xgQGSkvvA==\"]"));
		waitEle(By.xpath("//div[text()=\"Sign in with a different account\"]"));
 
	}
	public void Outlooklogin(String email, String password) throws Exception {
		Thread.sleep(10000);
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		switchEmail();
		sendKeysToElement(By.xpath("//input[@id=\"i0116\"]"), email);
		try {
			waitEle(By.xpath("//input[@id=\"idSIButton9\"]"));
		} catch (Exception e) {
			waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		}
		Thread.sleep(3000);
		sendKeysToElement(By.xpath("//input[@placeholder=\"Password\"]"), password);
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//button[@id=\"declineButton\"]"));
//		System.out.printf("%s Login successfull", email);
	}
	public void DradAndDropSigAndFullName(int n, int x1, int y1, int x2, int y2) throws Exception {
 
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select a Recipient']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(5000);
		String xpath = String.format("//div[@x-placement=\"bottom-start\"]//li[%d]", n);
		waitEle(By.xpath(xpath));
		Thread.sleep(5000);
		Actions actions1 = new Actions(driver);
 
		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
 
		WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));
 
		waitAndClick(actions1, signElement, targetElement, x1, y1);
		System.out.println("Signature Element Drag and Drop Done");
 
		WebElement fullNameElement = driver.findElement(By.xpath("//button[@id='fullNameEle']"));
		waitAndClick(actions1, fullNameElement, targetElement, x2, y2);
		System.out.println("FullName Drag and Drop Done");
 
	}
	public void DradAndDropSigAndDateSigned(int n, int x1, int y1, int x2, int y2,int x3 ,int y3) throws Exception {
		 
		Thread.sleep(10000);
		
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(5000);
		String xpath = String.format("//div[@x-placement=\"bottom-start\"]//li[%d]", n);
		waitEle(By.xpath(xpath));
		//Thread.sleep(5000);
		Actions actions1 = new Actions(driver);
 
		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
 
		WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));
 
		waitAndClick(actions1, signElement, targetElement, x1, y1);
		System.out.println("Signature Element Drag and Drop Done");
 
		WebElement fullNameElement = driver.findElement(By.xpath("//button[@id='dateSingedEle']"));
		waitAndClick(actions1, fullNameElement, targetElement, x2, y2);
		System.out.println("datesign Drag and Drop Done");
		Thread.sleep(10000);
		WebElement element = driver
				.findElement(By.xpath("//div[text()=\"Other Primary Fields\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		waitEle(By.xpath("//div[text()=\"Other Primary Fields\"]"));
		Thread.sleep(10000);
		WebElement EmailId = driver.findElement(By.xpath("//button[@id='emailEle']"));
		waitAndClick(actions1, EmailId, targetElement, x3, y3);
		System.out.println("Email Drag and Drop Done");
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//div[text()=\"Other Primary Fields\"]"));
		
 
	}
	public void DradAndDropSigAndDateSigned(int n, int[] xCoordinates, int[] yCoordinates) throws Exception {
//	    Thread.sleep(10000);
//	    waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
//	    Thread.sleep(5000);
//
//	    String xpath = String.format("//div[@x-placement=\"bottom-start\"]//li[%d]", n);
//	    waitEle(By.xpath(xpath));
	    
	    Actions actions1 = new Actions(driver);
	    WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

	    // Signature Element
	    WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));
	    waitAndClick(actions1, signElement, targetElement, xCoordinates[0], yCoordinates[0]);
	    System.out.println("Signature Element Drag and Drop Done");

	    // Date Signed Element
	    WebElement fullNameElement = driver.findElement(By.xpath("//button[@id='dateSingedEle']"));
	    waitAndClick(actions1, fullNameElement, targetElement, xCoordinates[1], yCoordinates[1]);
	    System.out.println("Date Signed Drag and Drop Done");

	    Thread.sleep(10000);
	    WebElement element = driver.findElement(By.xpath("//div[text()=\"Other Primary Fields\"]"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    waitEle(By.xpath("//div[text()=\"Other Primary Fields\"]"));
	    Thread.sleep(10000);

	    // Email Element
	    WebElement EmailId = driver.findElement(By.xpath("//button[@id='emailEle']"));
	    waitAndClick(actions1, EmailId, targetElement, xCoordinates[2], yCoordinates[2]);
	    System.out.println("Email Drag and Drop Done");

	    Thread.sleep(10000);
	    waitEle(By.xpath("//div[text()=\"Other Primary Fields\"]"));
	}

	public void PlaceFieldsByUsingCoordinates() throws Exception {
	    int[][] coordinates = {
	        {-250, -150, -250, -120, -250, -90},
	        {-250, -40, -250, -10, -250, 20},
	        {-250, 70, -250, 100, -250, 130},
	        {-250, 180, -250, 210, -250, 240},
	        {10, -150, 10, -120, 10, -90},
	        {10, -40, 10, -10, 10, 20},
	        {10, 70, 10, 100, 10, 130},
	        {10, 180, 10, 210, 10, 240},
	        {250, -150, 250, -120, 250, -90},
	        {250, -40, 250, -10, 250, 20},
	        {250, 70, 250, 100, 250, 130},
	        {250, 180, 250, 210, 250, 240}
	    };

	    for (int i = 0; i < coordinates.length; i++) {
	        int n = i + 1;
	        int[] xCoordinates = {coordinates[i][0], coordinates[i][2], coordinates[i][4]};
	        int[] yCoordinates = {coordinates[i][1], coordinates[i][3], coordinates[i][5]};
	        
	        waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
	        Thread.sleep(10000);
	        String xpath = String.format("//div[@x-placement=\"bottom-start\"]//li[%d]", n);
	        WebElement recipient = driver.findElement(By.xpath(xpath));
	        recipient.click();

	        DradAndDropSigAndDateSigned(n, xCoordinates, yCoordinates);
	    }
	}
	public void SelectRecipients() throws Exception {
	    int[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
	    String[] contactTypes = {"Receiver", "Receiver", "Receiver", "Receiver", "Receiver", "Receiver", "Receiver", "Receiver", "Receiver", "Receiver", "Receiver"};
	    String[] emails = {"prudhvib200@outlook.com", "jeevithapatnana200@outlook.com", "ramyasibbala200@outlook.com", "meghanan180894@outlook.com", "pmmeghana200@outlook.com", "ramyas200@outlook.com", "ramyas2002@outlook.com", "esigns100@outlook.com", "esigns200@outlook.com", "esigns300@outlook.com", "esigns400@outlook.com"};
	    String[] signerTypes = {"SIGNER", "APPROVER", "SIGNER", "SIGNER", "SIGNER", "SIGNER", "SIGNER", "SIGNER", "SIGNER", "SIGNER", "SIGNER"};

	    for (int i = 0; i < ids.length; i++) {
	        waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));
	        System.out.println("Click on Add recipient done Successfully");
	        
	        String xpath = String.format("//div[@id='user_%d']//input[@placeholder='Select contact type']", ids[i]);
	        waitEle(By.xpath(xpath));
	        String contacttype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", contactTypes[i]);
	        waitEle(By.xpath(contacttype));
	        System.out.println("Selected contact type Successfully");
	        
	        String xpath2 = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']", ids[i]);
	        waitEle(By.xpath(xpath2));
	        Thread.sleep(3000);
	        System.out.println("Click on Search with email done Successfully");
	        
	        String xpath3 = String.format("//div[@x-placement]//li[text()=\" %s \"]", emails[i]);
	        waitEle(By.xpath(xpath3));
	        
	        String xpath4 = String.format("//div[@id='user_%d']//input[@placeholder='Select Signer Type']", ids[i]);
	        waitEle(By.xpath(xpath4));
	        Thread.sleep(3000);
	        
	        String signertype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", signerTypes[i]);
	        waitEle(By.xpath(signertype));
	        System.out.println("Selected Recipients Successfully");
	    }
	}
	public void DragsinglelineText(int n, int x1, int y1) throws Exception {
	    Thread.sleep(1000);
	    waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
	    Thread.sleep(5000);
	    String xpath = String.format("//div[@x-placement=\"bottom-start\"]//li[%d]", n);
	    waitEle(By.xpath(xpath));
	    Actions actions1 = new Actions(driver);

	    WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

	    WebElement signElement = driver.findElement(By.xpath("//button[@id='singleLineTextEle']"));

	    waitAndClick(actions1, signElement, targetElement, x1, y1);
	    System.out.println("Signature Element Drag and Drop Done");
	}

	public void placeFieldsRepeatedly() throws Exception {
		for (int x = -300; x <= 250; x += 250) {
	        for (int y = -80; y <= 210; y += 50) {
	            DragsinglelineText(2, x, y);
	            Thread.sleep(5000);
	        }
	    }
	}
	public static void Javascriptclick(By xpath) throws Exception {
		Thread.sleep(3000);
 
		WebElement element = driver.findElement(xpath);
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
 
	}
	public void Doubleclick() throws InterruptedException {
		Thread.sleep(1000);
		
		WebElement elementToHover2 = driver.findElement(By.xpath("(//textarea[@class='el-textarea__inner'])[1]"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).doubleClick().perform();
		Thread.sleep(10000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
	}
	public void updateWithParentBasicFieldsLoop(String Fieldtype, String SelectTemplate) throws Exception {
		int n = 1;
		int i = 1;
		for (int x = -300; x <= 250; x = x + 250) {
			for (int y = -120; y <= 210; y = y + 50) {
				if (i >= 20) {
					break;
				} else {
					
					Thread.sleep(5000);
					Actions actions1 = new Actions(driver);
 
					WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
 
					WebElement SingleElement = driver.findElement(By.xpath("//button[@id='singleLineTextEle']"));
 
					waitAndClick(actions1, SingleElement, targetElement, x, y);
					Thread.sleep(5000);
//				WebElement singleelement2 = driver.findElement(By.xpath("//div[@class='form-fields-holder']//div[@data-text='Single Line Text %d']"));
					String singleline = String
							.format("//div[@class='form-fields-holder']//div[@data-text='Single Line Text %d']", n);
					Javascriptclick(By.xpath(singleline));
					Thread.sleep(5000);
					WebElement singleelement2 = driver.findElement(By.xpath(singleline));
					actions1.doubleClick(singleelement2).build().perform();
 
					Set<String> windowHandles = driver.getWindowHandles();
					for (String handle : windowHandles) {
						driver.switchTo().window(handle);// div[@x-placement]//ul//li//span[contains(text(),"Entity-entityMappingUpdateWithParentIndividualEntity")]
						Thread.sleep(5000);
						waitEle(By.xpath("//div[@class=\"el-form-item\"]//input[@placeholder=\"Select a Recipient\"]"));
						String con = String.format("//div[@x-placement]//ul//li//span[contains(text(),\"%s\")]",
								Fieldtype);
						Javascriptclick(By.xpath(con));
						Thread.sleep(5000);
						waitEle(By.xpath("(//div[@class=\"el-dialog__body\"]//div[@class=\"el-select\"]//input[@placeholder=\"Select\"])[1]"));
						String sel = String.format("//div[@x-placement]//ul//li//span[normalize-space()=\"%s\"]",
								SelectTemplate);
						Javascriptclick(By.xpath(sel));
						Thread.sleep(5000);
						waitEle(By.xpath("(//div[@class=\"el-dialog__body\"]//div[@class=\"el-select\"]//input[@placeholder=\"Select\"])[2]"));
						String select = String.format("//div[@x-placement]//ul//li[%d]", i);
						Javascriptclick(By.xpath(select));
						WebElement element = driver.findElement(By.xpath(select));
						String text = element.getText();
						System.out.println(text);
						if (text.equals("Single line text") || text.equals("Phonono")) {
							n=n+1;
						}
						System.out.println(n);
						Thread.sleep(5000);
						if (text.equals("Document")) {
							String pdffile = System.getProperty("user.dir") + "/src/test/resources/Test.pdf";
							uploadFileWithSendKeys(pdffile);
						}
						System.out.println(n);
						Thread.sleep(5000);
						waitEle(By.xpath("//span[normalize-space()=\"Update Parent\"]"));
						
						waitEle(By.xpath("(//div[@class=\"el-dialog__footer\"]//span[text()=\"Save\"])[2]"));
						i++;
					}
				}
			}
		}
	}
	public void uploadFileWithSendKeys(String Path) throws InterruptedException {
		Thread.sleep(10000);
		File uploadFile = new File(Path);
 
		WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].style.display='block';", fileInput);

	        JavascriptExecutor js1 = (JavascriptExecutor) driver;
	        js1.executeScript("arguments[0].value = '';", fileInput);
		fileInput.sendKeys(uploadFile.getAbsolutePath());
		
 
	}
	public void Mappwithentity() throws Exception {
		
		Doubleclick();
		Thread.sleep(1000);		
		waitEle(By.xpath("//div[@class='el-form-item__content']//input[@placeholder='Select a Recipient']"));
		
		waitEle(By.xpath("(//div[@x-placement]//ul//span[text()='Entity'])[1]"));
		
		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='VerifyAddEntityfieldstodocumentprimaryfields']"));
		
		Thread.sleep(1000);
		
		waitEle(By.xpath("(//input[@placeholder='Select'])[3]"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='dataundefined']"));
		
		waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[4]"));
		
		waitEle(By.xpath("(//span[normalize-space()='Save'])[2]"));
		}
	public void ModifyingData() throws Exception {
		
		waitEle(By.xpath("//input[@placeholder='Start date']"));
		
		waitEle(By.xpath("(//div[@class='el-picker-panel__content el-date-range-picker__content is-left']//span[normalize-space()='5'])[1]"));
		
		waitEle(By.xpath("(//div[@class='el-picker-panel__content el-date-range-picker__content is-right']//span[normalize-space()='30'])[2]"));
		
		waitEle(By.xpath("(//span[@class='el-radio__inner'])[2]"));
		
		waitEle(By.xpath("//input[@placeholder='Weekdays']"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Friday']"));
		
		waitEle(By.xpath("//input[@placeholder='Date']"));
		
		waitEle(By.xpath("//div[@class='el-picker-panel__content']//span[normalize-space()='12']"));
	}

	public void autoFill(String dataValofChkBx) throws Exception {
        Thread.sleep(1000);
        driver.get("https://nsui.esigns.io/profilesettings/application-settings");
        Thread.sleep(1000);
 
 
        WebElement element = driver.findElement(By.xpath("//span[text()=' Auto-complete sender if all fields filled']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
 
      
        boolean isChecked = driver.findElement(By.xpath("(//span[@class='el-checkbox__inner'])[2]")).isSelected();
 
        if (dataValofChkBx != null && dataValofChkBx.equalsIgnoreCase("Y")) {
            if (!isChecked) {
            	
                driver.findElement(By.xpath("(//span[@class='el-checkbox__inner'])[2]")).click();
                System.out.println("Checkbox checked.");
            } else {
                System.out.println("Checkbox already checked.");
            }
        } else if (dataValofChkBx != null && dataValofChkBx.equalsIgnoreCase("N")) {
            if (isChecked) {
                // Checkbox is already checked, click it to uncheck
                driver.findElement(By.xpath("(//span[@class='el-checkbox__inner'])[2]")).click();
                System.out.println("Checkbox unchecked.");
            } else {
                System.out.println("Checkbox already unchecked.");
            }
        } else {
            throw new IllegalArgumentException("Invalid dataValofChkBx value: " + dataValofChkBx);
        }
 
        waitEle(By.xpath("//span[text()='Save Changes']"));
    }
	public void SplitBox() throws Exception {
		
		Thread.sleep(10000);
		
		WebElement elementToHover2 = driver.findElement(By.xpath("(//textarea[@class='el-textarea__inner'])[2]"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).doubleClick().perform();
		Thread.sleep(10000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		
		waitEle(By.xpath("(//span[@class='el-checkbox__input'])[2]"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='el-input__inner'])[10]")));
        element1.clear();
		
		sendKeysToElement(By.xpath("(//input[@class='el-input__inner'])[10]"),"30");
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='el-input__inner'])[11]")));
        element.clear();
		
		sendKeysToElement(By.xpath("(//input[@class='el-input__inner'])[11]"),"3");
		
		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[4]"));
	}
	public void DradAndDropSigAndSingleline(int n, int x1, int y1, int x2, int y2) throws Exception {
		 
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(5000);
		String xpath = String.format("//div[@x-placement=\"bottom-start\"]//li[%d]", n);
		waitEle(By.xpath(xpath));
		Thread.sleep(5000);
		Actions actions1 = new Actions(driver);
 
		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
 
		WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));
 
		waitAndClick(actions1, signElement, targetElement, x1, y1);
		System.out.println("Signature Element Drag and Drop Done");
 
		WebElement fullNameElement = driver.findElement(By.xpath("//button[@id='singleLineTextEle']"));
		waitAndClick(actions1, fullNameElement, targetElement, x2, y2);
		System.out.println("FullName Drag and Drop Done");
 
	}
	public void windowHandle() throws InterruptedException {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
	}
	public void AddRecipientforEntity(int id, String s,String Mail,String Name,String signerType) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));
		System.out.println("Click on Add recipient done Successfully");
		String xpath = String.format("//div[@id='user_%d']//input[@placeholder='Select contact type']", id);
		Thread.sleep(1000);
		waitEle(By.xpath(xpath));
//		By Title = By.xpath("//div[@x-placement]//ul//li[normalize-space()='%s']");
//		WebElement Title1 = wait.until(ExpectedConditions.elementToBeClickable(Title));
//		Title1.sendKeys(s);
		String con = String.format("//div[@x-placement]//ul//li[normalize-space()='%s']", s);
		waitEle(By.xpath(con));
		System.out.println("Selected contact type Successfully");
		String xpath2 = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']", id);
		waitEle(By.xpath(xpath2));
		sendKeysToElement(By.xpath(xpath2), Mail);
		
		waitEle(By.xpath("//span[normalize-space()='Save Users']"));
		Thread.sleep(1000);
		
		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));
		
		windowHandle();
		
		waitEle(By.xpath("//i[@class='el-icon-circle-plus-outline']"));
		
		windowHandle();
		
//		WebElement element = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='el-radio__inner'])[1]")));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
//		waitEle(By.xpath("//div[@class=\"v-modal\"]"));
		
		String xpath3 = String.format("//input[@placeholder='Single line text']");
		waitEle(By.xpath(xpath3));
		Thread.sleep(1000);
		sendKeysToElement(By.xpath(xpath3), Name);
		
		Thread.sleep(3000);
		
        waitEle(By.xpath("//span[text()=' Add Account ']"));

        Thread.sleep(10000);
		waitEle(By.xpath("(//span[normalize-space()='Save'])[3]"));
		
		String xpath4 = String.format("//div[@id='user_%d']//input[@placeholder='Select Signer Type']", id);
		waitEle(By.xpath(xpath4));
		Thread.sleep(3000);
		String signertype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", signerType);
		waitEle(By.xpath(signertype));
		Thread.sleep(1000);
		System.out.println("Selected Recipients Successfully");
		
		
		
		}
	public void RecipientSigner(int id, String contactType,String email, String signerType) throws Exception {
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));
		System.out.println("Click on Add recipient done Successfully");
		String xpath = String.format("//div[@id='user_%d']//input[@placeholder='Select contact type']", id);
		waitEle(By.xpath(xpath));
		String contacttype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", contactType);
		waitEle(By.xpath(contacttype));
		System.out.println("Selected contact type Successfully");
		String xpath2 = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']", id);
		waitEle(By.xpath(xpath2));
		Thread.sleep(3000);
		System.out.println("click on Search with email done Successfully");
		String xpath3 = String.format("//div[@x-placement]//li[text()=\" %s \"]", email);
		waitEle(By.xpath(xpath3));
		String xpath4 = String.format("//div[@id='user_%d']//input[@placeholder='Select Signer Type']", id);
		waitEle(By.xpath(xpath4));
		Thread.sleep(3000);
		String signertype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", signerType);
		waitEle(By.xpath(signertype));
		System.out.println("Selected Recipients Successfully");
	}
	
	public void RecipientSignerToTemplate(String contactType, String signerType) throws Exception {

		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(1000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select Contact type']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//		String xpath = String.format("//input[@placeholder='Select Contact type']");
//		waitEle(By.xpath(xpath));
		String contacttype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", contactType);
		waitEle(By.xpath(contacttype));
		System.out.println("Selected contact type Successfully");
		String xpath4 = String.format("//input[@placeholder='Select Signer Type']");
		waitEle(By.xpath(xpath4));
		Thread.sleep(3000);
		String signertype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", signerType);
		waitEle(By.xpath(signertype));
		System.out.println("Selected Recipients Successfully");
		
		Thread.sleep(1000);
		
		waitEle(By.xpath("(//span[normalize-space()='Add'])[2]"));
	
	}
	public void clickSubmit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(5000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		Thread.sleep(10000);
	}
	public boolean Verifysubmit() {
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Document Sent \"]")));
		System.out.println("Sent Document Sucessfully");
		return name.isDisplayed();
	}
	public void Viewdocument() throws Exception {
		
		waitEle(By.xpath("//span[normalize-space()='View Document']"));

		System.out.println("View Document successfull");
	}

	public void Blankwithoutsenderautofill() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Edit']"));
		driver.findElement(By.xpath("//input[@placeholder='Enter signature']")).sendKeys("Meghana");

		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));

		System.out.println("mySignatureEle Element opened With Double Click and Entered New Sign Data Successfully");

		waitEle(By.xpath("//span[normalize-space()='FINISH']"));
		System.out.println("Finish document successfull");

	}
	public void clickok() throws Exception {
		Thread.sleep(1000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		waitEle(By.xpath("(//span[normalize-space()='OK'])[3]"));
	}
	public void Checkbox() throws Exception {
		Thread.sleep(10000);
		
		waitEle(By.xpath("(//div[@class='el-tooltip tooltip']//input)[14]"));
		
	}
	public void autofilloff() throws Exception {
		
		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}
		Thread.sleep(5000);
		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//li[text()=\" Settings \"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//a[text()=\"Application Settings\"]"));
		WebElement element = driver
				.findElement(By.xpath("//span[text()=\" Auto-complete sender if all fields filled\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			waitEle(By.xpath(
					"//label[@class=\"el-checkbox is-checked\"]//span[text()=\" Auto-complete sender if all fields filled\"]"));
			System.out.println("autofill is off");
			
		} catch (Exception e) {
			System.out.println("Autofill is already off");
		}
 
		Thread.sleep(5000);
		waitEle(By.xpath("//span[text()=\"Save Changes\"]"));
 
	}
	public void autofillon() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//li[text()=\" Settings \"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//a[text()=\"Application Settings\"]"));
		Thread.sleep(5000);
		WebElement element = driver
				.findElement(By.xpath("//span[text()=\" Auto-complete sender if all fields filled\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			driver.findElement(By.xpath(
					"//label[@class=\"el-checkbox\"]//span[text()=\" Auto-complete sender if all fields filled\"]"))
					.click();
			System.out.println("autofill is on");
			
		} catch (Exception e) {
			System.out.println("Autofill is already on");
		}
		waitEle(By.xpath("//span[text()=\"Save Changes\"]"));
	}
 
	public void Nextbt() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='Next']"));
		
		System.out.println("Next button clicked successfully");
		Thread.sleep(10000);
	}
	public void Selecttofillrec() throws Exception {
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
		Thread.sleep(20000);
	}
	public void PdfEditmode() throws Exception {
		Thread.sleep(10000);
		
		waitEle(By.xpath("//span[@class='el-switch__core']"));
		
		waitEle(By.xpath("//img[@src='/img/eraser-icon.34c3de87.png']"));
		
		waitEle(By.xpath("//*[@id='svg']"));
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//a[@class='text-icon el-link el-link--default']"));
		
		Thread.sleep(100000);
		
		waitEle(By.xpath("//a[@class='save-icon el-link el-link--default']"));
		
		}
	public void Chat() throws Exception {
		
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		waitEle(By.xpath("//span[normalize-space()='Chat']"));
		
		Thread.sleep(10000);

		By comment = By.xpath("//textarea[@placeholder='Enter comments here...']");
		WebElement comment2 = wait.until(ExpectedConditions.elementToBeClickable(comment));
		comment2.sendKeys("no comments");
		
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Post']"));
	}
	public void Logs() throws Exception {
		
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Logs']"));

	}
	public void OtherOptions() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//div[@class='el-dropdown']//span//i"));

		System.out.println("clicked on other options");

	}
	public void otheroptionsvoiddoc() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[8]"));
		
		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Yes'])[2]"));
		Thread.sleep(10000);

		System.out.println("clicked on voiddocument");

	}
	public void Clonedocument() throws Exception {
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("(//div[@class='el-dropdown']//span//i)[1]"));
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[3]"));
		
		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));
		
		Thread.sleep(10000);
		
	}
	public void otheroptionssaveastem() throws Exception {
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[7]"));

		System.out.println("clicked on saveastemplate");

	}
	public void otheroptionsCorrectdoc() throws Exception {

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[6]"));

		waitEle(By.xpath("(//span[normalize-space()='Yes'])[2]"));

		System.out.println("clicked on correctdocument");
		
		Thread.sleep(10000);

	}
	@SuppressWarnings("deprecation")
	public void otheroptionsprintandsign() throws Exception {

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[2]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button float-right mt-1 el-button--default']"));
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//button[@class='el-button el-button--danger']"));

		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--mini']"));
		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe");
		
		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button el-button--danger']"));

		System.out.println("clicked on print and sign");
	}
	public void otheroptionssettings() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[5]"));
		
		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		
		WebElement checkbox = driver.findElement(By.xpath("(//span[@class='el-radio__inner'])[1]"));
        boolean isChecked = checkbox.isSelected();

        if (!isChecked) {
            checkbox.click();
            System.out.println("Checkbox was unchecked. Now it's checked.");
        } else {
            System.out.println("Checkbox was already checked. No action taken.");
        }

		waitEle(By.xpath("//button[@class='el-button type-2 el-button--default']"));

		System.out.println("clicked on settings");
	}
	public void otheroptionshistory() throws Exception {

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[4]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[2]"));
		
		System.out.println("clicked on history");
		
		waitEle(By.xpath("(//button[@class='el-dialog__headerbtn'])[19]"));
	}
	public void Otheroptionsdownload() throws Exception {
		
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[3]"));
		
		Thread.sleep(10000);

		System.out.println("clicked on download");

	}
	public void otheroptionsfinishlater() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));

		System.out.println("clicked on finishlater");

	}
	public void Afterfinishlater() throws Exception {
		Thread.sleep(10000);
		
		waitEle(By.xpath("//span[normalize-space()='TRY IT']"));
		String Parentwindowid1 = driver.getWindowHandle();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(By.xpath("(//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-edit-outline'])[1]"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).click().perform();
		Thread.sleep(10000);
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(1000);
				driver.switchTo().window(Parentwindowid1).close();
				driver.switchTo().window(childwindow);
 
				Thread.sleep(1000);
			}
		}
		}
	@SuppressWarnings("deprecation")
	public void uploadDocument() throws Exception {
		
		Thread.sleep(10000);

		waitEle(By.xpath("//h4[@class='fw-normal blue pb-2']"));

		Runtime.getRuntime().exec("\"C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\blankupload..exe\"");

		Thread.sleep(10000);
	}
	public void Adddatatoemptypdf() throws Exception {
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//div[@class='el-switch el-tooltip mr-1 item']//span"));
		
		Thread.sleep(10000);
		
		sendKeysToElement(By.xpath("//*[@id=\"svg\"]"), "This document is for texting purose we are adding data to an empty pdf document");
		
	}
	public void Clonedocumentforsinglesender() throws Exception {
		
		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}
	
		Thread.sleep(10000);
		waitEle(By.xpath("(//div[@class='el-dropdown']//span//i)[1]"));
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[5]"));
		
		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//a[@class='el-icon-circle-plus el-link el-link--danger']"));
		}
	public void SendClonedoc() throws Exception {
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//button[@class='el-button type-2 ml-2 settigns-font button-type-one send-btn el-button--danger']"));
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Alert Message!'])[1]")));
		Assert.notNull(Message1, "Alert popup is not displayed");
		
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
	private static int counter = 0;

	public static String generateUniqueString() {
		return "unique_string_sample" + UUID.randomUUID().toString().substring(0, 8) + counter++;

	}
	public void CreateFormtemplate(String s) throws Exception {

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
		Name1.sendKeys(s);

		sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Template Description']"),"Test purpose");

		waitEle(By.xpath("(//span[normalize-space()='Submit'])[1]"));
	}
	public void BasicFields() throws Exception {
		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(10000);
		// Single Line
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));
		Actions actions = new Actions(driver);
		WebElement Singlelinetext = driver.findElement(By.xpath("//span[text()=\"Single Line Text\"]"));
		waitAndClick(actions, Singlelinetext, Target);
		System.out.println("Singleline Drag and Drop Done");
		By SName = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement SName1 = wait.until(ExpectedConditions.elementToBeClickable(SName));
		SName1.sendKeys("Single line text");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Multiline
		WebElement Multiline = driver.findElement(By.xpath("//span[text()=\"Multi Line Text\"]"));
		waitAndClick(actions, Multiline, Target);
		System.out.println("Multiline Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Multiline");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Number Of Rows']"), "3");
		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Select Field
		WebElement Select = driver.findElement(By.xpath("//span[text()=\"Select\"]"));
		waitAndClick(actions, Select, Target);
		System.out.println("Select Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Select");
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "Computer science");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "maths");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "Physics");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		Thread.sleep(10000);
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Number
		WebElement Number = driver.findElement(By.xpath("//span[text()=\"Number\"]"));
		waitAndClick(actions, Number, Target);
		System.out.println("Number Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Number");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// MultiSelect
		WebElement MultiSelect = driver
				.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[5]"));
		waitAndClick(actions, MultiSelect, Target);
		System.out.println("MultiSelect Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Multiselect");
 
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "Computer science");
 
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
 
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "maths");
 
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
 
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "Physics");
 
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// List
		WebElement List = driver
				.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[6]"));
		waitAndClick(actions, List, Target);
		System.out.println("List Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Number");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Name']"), "List");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Value']"), "123");
		waitEle(By.xpath("//button[@class='el-button f-weight-600 el-button--primary']"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
 
		// Date
		WebElement Date = driver.findElement(By.xpath("//span[text()=\"Date\"]"));
		waitAndClick(actions, Date, Target);
		System.out.println("Date Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Date");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Time
		WebElement Time = driver.findElement(By.xpath("//span[text()=\"Time\"]"));
		waitAndClick(actions, Time, Target);
		System.out.println("Time Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Time");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Fixed Time
		WebElement FixedTime = driver.findElement(By.xpath("//span[text()=\"Fixed Time\"]"));
		waitAndClick(actions, FixedTime, Target);
		System.out.println("FixedTime Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "FixedTime");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Time Range
		WebElement TimeRange = driver.findElement(By.xpath("//span[text()=\"Time Range\"]"));
		waitAndClick(actions, TimeRange, Target);
		System.out.println("TimeRange Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "TimeRange");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// DateTime
		WebElement DateTime = driver.findElement(By.xpath("//span[text()=\"Date Time\"]"));
		waitAndClick(actions, DateTime, Target);
		System.out.println("DateTime Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DateTime");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// DateRange
		WebElement DateRange = driver.findElement(By.xpath("//span[text()=\"Date Range\"]"));
		waitAndClick(actions, DateRange, Target);
		System.out.println("DateRange Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DateRange");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
 
		// Weekdays
		WebElement Weekdays = driver.findElement(By.xpath("//span[text()=\"Week Days\"]"));
		waitAndClick(actions, Weekdays, Target);
		System.out.println("Weekdays Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Weekdays");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
 
		// YesorNo
		WebElement YesorNo = driver.findElement(By.xpath("//span[text()=\"Yes or No\"]"));
		waitAndClick(actions, YesorNo, Target);
		System.out.println("YesorNo Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "YesorNo");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// checkbox
		WebElement Checkbox = driver.findElement(By.xpath("//span[text()=\"Checkbox\"]"));
		waitAndClick(actions, Checkbox, Target);
		System.out.println("Checkbox Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Checkbox");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Checkbox Group
		WebElement Checkboxgroup = driver.findElement(By.xpath("//span[text()=\"Checkbox Group\"]"));
		waitAndClick(actions, Checkboxgroup, Target);
		System.out.println("Checkbox Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "CheckboxGroup");
		Thread.sleep(5000);
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "1");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "2");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "3");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("(//div[@class=\"el-input\"]//input[@class=\"el-input__inner\"])[2]"), "1");
		sendKeysToElement(By.xpath("(//div[@class=\"el-input\"]//input[@class=\"el-input__inner\"])[3]"), "2");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Document
		WebElement Document = driver.findElement(By.xpath("//span[text()=\"Document\"]"));
		waitAndClick(actions, Document, Target);
		System.out.println("Document Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Document");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Radio
		WebElement Radio = driver.findElement(By.xpath("//span[text()=\"Radio\"]"));
		waitAndClick(actions, Radio, Target);
		System.out.println("Radio Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Radio");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// RadioGroup
		WebElement Radiogroup = driver.findElement(By.xpath("//span[text()=\"Radio Group\"]"));
		waitAndClick(actions, Radiogroup, Target);
		System.out.println("Radio Group Field Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "RadioGroup");
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "1");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "2");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "3");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
 
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// phone number
		WebElement Phoneno = driver.findElement(By.xpath("//span[text()=\"Phone\"]"));
		waitAndClick(actions, Phoneno, Target);
		System.out.println("Phoneno Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Phonono");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Signature
		WebElement Sign = driver.findElement(By.xpath("//span[text()=\"Signature\"]"));
		waitAndClick(actions, Sign, Target);
		System.out.println("Sign Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Sign");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

	}
	public void Entity() throws Exception {
		Thread.sleep(1000);

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
	public void Createentity(String s,String EntityType,String CreateType) throws Exception {
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
		Title1.sendKeys(s);
		
		String entitytype = String.format("//span[contains(text(), '%s')]", EntityType);
		waitEle(By.xpath(entitytype));
		System.out.println("Selected entity type Successfully");
		
		String createtype = String.format("//p[contains(text(), '%s')]", CreateType);
		waitEle(By.xpath(createtype));
		System.out.println("Selected entity type Successfully");

//		waitEle(By.xpath("//span[contains(text(), '%s')]", EntityType));
		
		Thread.sleep(10000);

		waitEle(By.xpath("//i[@class='fa fa-check-square-o']"));

		System.out.println("Create entity successfull");
	}
	public void addtemplatetoentity() throws Exception {
		Thread.sleep(10000);
		
		waitEle(By.xpath("//button[normalize-space()='templateBasicFeilds']"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement FullName = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='dropBox'])[1]//li[text()=' Single line text ']")));

		WebElement Target = driver.findElement(By.xpath("(//div[@class='dropBox'])[2]"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, FullName, Target);

		System.out.println("Name Drag and Drop Done");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

	}
	public void RemoveWarning() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Update & Next']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println("Document Updated Sucessfully");

		Thread.sleep(10000);
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
	public void DragBasicFeildsCompanyProfile(int n) throws Exception {
		
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(5000);
		String xpath = String.format("//div[@x-placement=\"bottom-start\"]//li[%d]", n);
		waitEle(By.xpath(xpath));
		
		String feilds[] = { "Single line text", "Time", "Number", "Multiline", "DateTime", "Multiselect", "Select", "Weekdays", "Date", "list","RadioGroup", "DateRange", "Sign", "YesOrNo", "Document", "FixedTime",
				"Phonono", "CheckBox","checkboxGroup","Radio","TimeRange" };
		int l = feilds.length;
		Thread.sleep(5000);
		waitEle(By.xpath("//div[text()=\"templateBasicFeilds\"]"));
		Thread.sleep(5000);
		int i = 1;
		for (int x = -250; x <= 250; x = x + 250) {
			for (int y = -120; y <= 250; y = y + 50) {
				String xpath1 = String.format("(//button[@class=\"el-tooltip field-element tooltip\"])[%d]", i++);
				if (i <= l + 1) {
					Actions actions = new Actions(driver);
					WebElement ele = driver.findElement(By.xpath(xpath1));
					WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
					waitAndClick(actions, ele, Target, x, y);
					System.out.printf("%s Field Drag and Drop Done\n", feilds[i - 2]);
					} else {
						break;
					}
	 
				}
			}
	 
		}
	public void Clickcreatedocument() throws Exception {
		Thread.sleep(1000);
		waitEle(By.xpath("//span[normalize-space()='Create Document']"));
		
		try {
			waitEle(By.xpath("//div[@class='el-notification__closeBtn el-icon-close']"));
		}catch (Exception e){
			Thread.sleep(1000);
		}
		}
	public void documentsettings() throws Exception {
		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		
		WebElement checkbox = driver.findElement(By.xpath("(//span[@class='el-radio__inner'])[1]"));
        boolean isChecked = checkbox.isSelected();

        if (!isChecked) {
            checkbox.click();
            System.out.println("Checkbox was unchecked. Now it's checked.");
        } else {
            System.out.println("Checkbox was already checked. No action taken.");
        }
        
        waitEle(By.xpath("//span[normalize-space()='Save Changes']"));

//		waitEle(By.xpath("//span[text()='Save & Send ']"));

		System.out.println("clicked on settings");
	}
	public void Updateafterdocumentcompletionfromsettings() throws Exception {
		
		Thread.sleep(10000);
		
		waitEle(By.xpath("//span[@class='el-icon-arrow-down text-white']"));
		
		Thread.sleep(10000);

		By ad = By.xpath("//li[normalize-space()='Settings'] ");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on Settings using JS.");
		
		waitEle(By.xpath("//a[@class='router-link-exact-active router-link-active list-group-item list-group-item-action active']"));
	}
	public void Settings() throws Exception {
		
//		waitEle(By.xpath("//a[@class='router-link-exact-active router-link-active list-group-item list-group-item-action active']"));
		
		Thread.sleep(10000);
		
		WebElement checkbox = driver.findElement(By.xpath("(//span[@class='el-radio__inner'])[1]"));
        boolean isChecked = checkbox.isSelected();

        if (!isChecked) {
            checkbox.click();
            System.out.println("Checkbox was unchecked. Now it's checked.");
        } else {
            System.out.println("Checkbox was already checked. No action taken.");
        }
		
		waitEle(By.xpath("//span[normalize-space()='Save Changes']"));
		
		Thread.sleep(10000);
		}
	public void Documentsettings() throws Exception {
		
		Thread.sleep(10000);

		waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));
		
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		
		waitEle(By.xpath("//button[@class='el-button type-2 el-button--default']"));
		
		
	}
	public void Settings2() throws Exception {
		
		Thread.sleep(1000);
		
		WebElement checkbox = driver.findElement(By.xpath("(//span[@class='el-radio__input'])[2]"));
        boolean isChecked = checkbox.isSelected();

        if (!isChecked) {
            checkbox.click();
            System.out.println("Checkbox was unchecked. Now it's checked.");
        } else {
            System.out.println("Checkbox was already checked. No action taken.");
        }
		waitEle(By.xpath("//button[@class='el-button type-2 el-button--default']"));
		}
	public void Settings3() throws Exception {
		
		Thread.sleep(1000);
		
		WebElement checkbox = driver.findElement(By.xpath("//span[@class='el-radio__input is-checked']"));
        boolean isChecked = checkbox.isSelected();

        if (!isChecked) {
            checkbox.click();
            System.out.println("Checkbox was unchecked. Now it's checked.");
        } else {
            System.out.println("Checkbox was already checked. No action taken.");
        }
		waitEle(By.xpath("//button[@class='el-button type-2 el-button--default']"));
		}
	@SuppressWarnings("deprecation")
	public void enteringdatatoentity() throws Exception {
		
		Thread.sleep(1000);
		
		waitEle(By.xpath("(//span[@class='el-radio__inner'])[1]"));
		
		waitEle(By.xpath("//input[@placeholder='Start date']"));
		
		waitEle(By.xpath("(//div[@class='el-picker-panel__content el-date-range-picker__content is-left']//span[normalize-space()='4'])[1]"));
		
		waitEle(By.xpath("(//div[@class='el-picker-panel__content el-date-range-picker__content is-right']//span[normalize-space()='4'])[1]"));
		
		waitEle(By.xpath("//i[@class='el-icon-edit']"));
		
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
		
		waitEle(By.xpath("//input[@placeholder='Date Time']"));
		
		waitEle(By.xpath("(//div[@class='el-picker-panel__content']//span[normalize-space()='4'])[1]"));
		
		waitEle(By.xpath("//span[normalize-space()='OK']"));
		
		waitEle(By.xpath("(//span[@class='el-radio__inner'])[4]"));
		
		waitEle(By.xpath("//input[@placeholder='Weekdays']"));
		
		waitEle(By.xpath("//div[@x-placement]//span[normalize-space()='Thursday']"));
		
		waitEle(By.xpath("//input[@placeholder='Date']"));
		
		waitEle(By.xpath("(//div[@class='el-picker-panel__content']//span[normalize-space()='4'])[3]"));
		
		sendKeysToElement(By.xpath("//input[@placeholder='Single Line Text']"),"Ramya");
		
		waitEle(By.xpath("//img[@src='/img/upload-icon.30a8f8f6.svg']"));
		
		Runtime.getRuntime().exec("\"C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\blankupload..exe\"");
		
		waitEle(By.xpath("//input[@placeholder='Please select...']"));
		
		waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='list']"));
		
		waitEle(By.xpath("//input[@placeholder='Fixed Time']"));
		
		waitEle(By.xpath("//div[normalize-space()='01:30']"));
		
		waitEle(By.xpath("//input[@placeholder='Multi Select']"));
		
		waitEle(By.xpath("//div[@x-placement]//span[normalize-space()='2']"));
		
		waitEle(By.xpath("//i[@class='el-select__caret el-input__icon el-icon-arrow-up is-reverse']"));
		
		sendKeysToElement(By.xpath("//input[@placeholder='Number']"),"123456");
		
		waitEle(By.xpath("//input[@placeholder='Time']"));
		
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[4]//ul//li[text()='00']"));
 
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[5]//ul//li[text()='00']"));
 
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[6]//ul//li[text()='00']"));
		
		waitEle(By.xpath("(//button[text()=\"OK\"])[2]"));
		
		Thread.sleep(1000);
		
		waitEle(By.xpath("(//button[normalize-space()='OK'])[4]"));
		
		sendKeysToElement(By.xpath("//input[@placeholder='Phone no']"),"1234567890");
		
		sendKeysToElement(By.xpath("//textarea[@placeholder='Multiline']"),"This is only for the sake of testing");
		
		waitEle(By.xpath("//input[@placeholder='Select']"));
		
		waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='maths']"));
		
		waitEle(By.xpath("(//div[@class='el-tooltip tooltip']//input)[14]"));

		}
	public void receiverSideBasicFeildsFill(int n,int checkbox,int checkboxGroup1,int checkboxGroup2) throws Exception {
		Thread.sleep(10000);
		
		//single line text
		String singlelinetext = String.format("(//input[@placeholder=\"Single line text\"])[%d]", n);
		WebElement singlelineField = driver.findElement(By.xpath(singlelinetext));

		String existingValue = singlelineField.getAttribute("value");

		if (existingValue != null && !existingValue.isEmpty()) {
			singlelineField.clear();
		}
		singlelineField.sendKeys("Ramyasri sibbala");

		System.out.println("Filled phone number field.");
		
		//Time
		String Time=String.format("(//input[@placeholder=\"Time\"])[%d]", n);
		waitEle(By.xpath(Time));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[1]//ul//li[text()='00']"));
		Thread.sleep(1000);
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[2]//ul//li[text()='00']"));
		Thread.sleep(1000);
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[3]//ul//li[text()='00']"));
		waitEle(By.xpath("//button[text()='OK']"));
		System.out.println("filled time feild");
		
		//number
		String Number = String.format("(//input[@placeholder=\"Number\"])[%d]", n);
		WebElement NumberField = driver.findElement(By.xpath(Number));
		String existingValue1 = NumberField.getAttribute("value");
		if (existingValue1 != null && !existingValue1.isEmpty()) {
			NumberField.clear();
					}
			NumberField.sendKeys("9347618053");
				
		System.out.println("Filled phone number field.");
		
		// Multiline
		String Multiline=String.format("(//textarea[@placeholder=\"Multiline\"])[%d]", n);
		driver.findElement(By.xpath(Multiline)).clear();
		sendKeysToElement(By.xpath(Multiline), "PemmaMohan ReddyMeghana");
		System.out.println("filled Multiline feild");
		
		// multiselect
		waitEle(By.xpath("//input[@placeholder=\"Multi select\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		waitEle(By.xpath("//div[@x-placement]//li[2]"));
		waitEle(By.xpath("//i[@class='el-select__caret el-input__icon el-icon-arrow-up is-reverse']"));
		System.out.println("filled multiselect feild");
		
		//select
		String Select=String.format("(//input[@placeholder=\"Select\"])[%d]", n);
		waitEle(By.xpath(Select));
		Thread.sleep(5000);
		Javascriptclick(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("filled select feild");
				
		// Weekday
		String Weekdays=String.format("(//input[@placeholder=\"Weekdays\"])[%d]", n);
		waitEle(By.xpath(Weekdays));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("filled Weekday feild");
		
		// date Feild
//		WebElement element = driver
//				.findElement(By.xpath("(//input[@placeholder=\"Date\"])[%d]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		waitEle(By.xpath("(//input[@placeholder=\"Date\"])[%d]"));
		
		String Date=String.format("(//input[@placeholder=\"Date\"])[%d]", n);
		waitEle(By.xpath(Date));
		waitEle(By.xpath("//div[@x-placement]//tr[@class=\"el-date-table__row\"][1]//td[7]"));
		System.out.println("filled date Feild feild");
		
		// list
		String list=String.format("(//input[@placeholder=\"Please select...\"])[%d]", n);
		waitEle(By.xpath(list));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("filled list feild");
		
		// date time
		String DateTime=String.format("(//input[@placeholder=\"DateTime\"])[%d]", n);
		waitEle(By.xpath(DateTime));
		waitEle(By.xpath("(//div[@x-placement]//tr[@class=\"el-date-table__row\"])[2]//td[4]"));
		waitEle(By.xpath("//span[normalize-space()=\"OK\"]"));
		System.out.println("filled  date time feild");
		
		// TimeRange
		waitEle(By.xpath("placeholder=\"Start time\""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath("//button[text()=\"OK\"]"));
		System.out.println("filled TimeRange feild");
		
		// fixedTime
		String FixedTime=String.format("(//input[@placeholder=\"FixedTime\"])[%d]", n);
		waitEle(By.xpath(FixedTime));
		waitEle(By.xpath("//div[@x-placement]//div[text()=\"01:00\"]"));
		waitEle(By.xpath("//input[@placeholder=\"Please select...\"]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("filled fixedTime feild");
		
		// yes or no
		String YesOrNo=String.format("(//span[text()=\"YES\"])[%d]", n);
		Javascriptclick(By.xpath(YesOrNo));
		System.out.println("filled yes or no feild");
		
		// checkbox
		String checkbox1=String.format("(//input[@type=\"checkbox\"])[%d]", checkbox);
		waitEle(By.xpath(checkbox1));
		System.out.println("filled checkbox feild");
		
		// document
		String pdffile = System.getProperty("user.dir") + "\\src\\test\\resources\\TESTING.pdf";
		Thread.sleep(10000);
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		fileInput.sendKeys(pdffile);
		System.out.println("Uploaded file successfully");
		
		// check box group
		String checkboxgroup1=String.format("(//input[@type=\"checkbox\"])[%d]", checkboxGroup1);
		waitEle(By.xpath(checkboxgroup1));
		String checkboxgroup2=String.format("(//input[@type=\"checkbox\"])[%d]", checkboxGroup2);
		waitEle(By.xpath(checkboxgroup2));
		System.out.println("filled check box group feild");
		
		// phone no
		String phone = String.format("(//input[@placeholder=\"Phonono\"])[%d]", n);
		WebElement phonenumField = driver.findElement(By.xpath(phone));
		String existingValue11 = phonenumField.getAttribute("value");
		if (existingValue11 != null && !existingValue11.isEmpty()) {
			phonenumField.clear();
					}
		NumberField.sendKeys("9347618053");
		System.out.println("Filled phone number field.");
		
		// date Range
		Thread.sleep(10000);
		String DateRange=String.format("(//input[@placeholder=\"Start date\"])[%d]", n);
		Javascriptclick(By.xpath(DateRange));
		Javascriptclick(By.xpath("(//div[@class=\"el-picker-panel__content el-date-range-picker__content is-left\"]//td[@class=\"available\"])[1]"));
		Javascriptclick(By.xpath("(//div[@class=\"el-picker-panel__content el-date-range-picker__content is-right\"]//td[@class=\"available\"])[1]"));
		System.out.println("filled dateRange feild");
		
		// Signature
		Thread.sleep(5000);
		try {
			waitEle(By.xpath("//button[text()=\" Sign \"]"));
			} catch (Exception e) {
				waitEle(By.xpath("(//img[@class=\"el-tooltip tooltip\"])[1]"));
				}
		Thread.sleep(10000);
		waitEle(By.xpath("//span[text()=\"Verify & Save Secure Signature\"]"));
		System.out.println("filled Signature feild");
		
		// radio group
		String radioGroup=String.format("(//span[text()=\"1\"])[%d]", n);
		waitEle(By.xpath(radioGroup));
		
		// sigleLine Text
		
		
//		
//		String Singlelinetext = String.format("(//input[@placeholder=\"Single line text\"])[%d]");
//		WebElement a=driver.findElement(By.xpath(Singlelinetext));
//        if (!a.getAttribute("value").isEmpty()) {
//        	driver.findElement(By.xpath(Singlelinetext)).clear();
//    		sendKeysToElement(By.xpath(Singlelinetext), "PemmaMohan ReddyMeghana");
//        }else {
//		sendKeysToElement(By.xpath(Singlelinetext), "PemmaMohan ReddyMeghana");
//		System.out.println("filled sigleLine Text feild");
		
//		
//		String Number=String.format("(//input[@placeholder=\"Number\"])[%d]", n);	
//		driver.findElement(By.xpath(Number)).clear();
//		sendKeysToElement(By.xpath(Number), "1");
//		System.out.println("filled Number feild");
		
		// time
		
//		String Phonono=String.format("(//input[@placeholder=\"Phonono\"])[%d]", n);
//		driver.findElement(By.xpath(Phonono)).clear();
//		sendKeysToElement(By.xpath(Phonono), "9347618053");
//		System.out.println("filled phone no feild");
		
		clickFinish();
		try {
			waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"));
		} catch (Exception e) {
		}
		
	}
	public void Perform() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[1]//span[normalize-space()='Actions']"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).perform();

	}
	public void VerifyEntityData() throws Exception {
		
		Thread.sleep(10000);
		
		driver.get("https://nsui.esigns.io/");
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
		.sendKeys("ramya.sibbala@nimbleaccounting.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Ramyasri@123");
		driver.findElement(By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--danger']")).click();
		Thread.sleep(10000);
		
		Entity();
		
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

	}
	public void VerifyTemplateData() throws Exception {

		Thread.sleep(10000);
		
		driver.get("https://nsui.esigns.io/");
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
		.sendKeys("ramya.sibbala@nimbleaccounting.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Ramyasri@123");
		driver.findElement(By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--danger']")).click();
		Thread.sleep(10000);
		
		Templatesceanario();
		
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[9]"));
	}
	public void Showall() throws Exception {
		Thread.sleep(1000);	
		waitEle(By.xpath("//i[@class='fa fa-ellipsis-v fa-fade']"));
		
		waitEle(By.xpath("//span[normalize-space()='Show all'] "));
		
		waitEle(By.xpath("(//i[@class='el-dialog__close el-icon el-icon-close'])[1]"));
	}
	public void verifyBasicFieldDataFillInIndividualEntity(String[] fieldValues, int n) throws Exception {
		
		Thread.sleep(1000);
		String fields[] = { "RadioGroup", "DateRange", "Sign", "Date Time", "Yes Or No", "Weekdays", "Date",
		        "Single Line Text", "Document", "List", "Fixed Time", "Multi Select", "Number", "Time", "Phone no",
		        "Multiline", "Select", "CheckBox" };
		final String RESET = "\033[0m"; // Text Reset
		final String RED = "\033[0;31m"; // RED
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
		for (int i = 0; i < fieldValues.length; i++) {
			String fieldValue = fieldValues[i];
			String field = fields[i];
			String xpath = String.format(
					"//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[%d]/td[%d]//p[normalize-space()=\"%s\"] | "
							+ "//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[1]/td[%d]//span[normalize-space()=\"%s\"]|"
							+ "(//img[@alt=\"%s\"])[1]",
					n, i + 2, fieldValue, n, i + 2, fieldValue, n, i + 2, fieldValue);
 
			try {
				WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
				if (element.isDisplayed()) {
					System.out.printf("%s Field data %s displayed correctly\n", field, fieldValue);
				} else {
					System.out.printf("%s Field data %s not displayed or displayed incorrectly\n", field, fieldValue);
				}
			} catch (Exception e) {
				try {
					WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", element);
					if (element.isDisplayed()) {
						System.out.printf("%s Field data %s displayed correctly after scroll\n", field, fieldValue);
					} else {
						System.out.printf(
								RED + "%s Field data %s not displayed or displayed incorrectly after scroll\n" + RESET,
								field, fieldValue);
					}
				} catch (Exception ex) {
					System.out.printf(RED + "%s Field data %s not found in the DOM\n" + RESET, field, fieldValue);
				}
			}
		}
	}
	public void clickFinish() throws Exception {
		waitEle(By.xpath("//span[text()=\"FINISH\"]"));
		System.out.println("Review and Sign successful");
 
	}
	@SuppressWarnings("deprecation")
	public void receiverSideUpdatedBasicFeildsFill() throws Exception {
		// radio group
		Thread.sleep(5000);
		waitEle(By.xpath("//span[text()=\"2\"]"));
		System.out.println("radio group field updated");
		// date Range
		waitEle(By.xpath("//input[@placeholder=\"Start date\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@class='el-picker-panel__content el-date-range-picker__content is-left']//td[@class='available in-range start-date']"));
		waitEle(By.xpath("(//div[@class='el-picker-panel__content el-date-range-picker__content is-right']//span[normalize-space()='7'])[1]"));
		System.out.println("date Range field updated");
		// Signature
		waitEle(By.xpath("(//img[@class=\"el-tooltip tooltip\"])[2]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[text()=\"Verify & Save Secure Signature\"]"));
		WebElement inputField = driver.findElement(By.xpath("(//img[@class=\"el-tooltip tooltip\"])[1]"));
		String filledData = inputField.getAttribute("value");
		System.out.println(filledData);
		System.out.println("Signature field updated");
		// date time
		waitEle(By.xpath("//input[@placeholder='Date Time']"));
		waitEle(By.xpath("(//div[@class='el-picker-panel__content']//td[@class='available'])[5]"));
		waitEle(By.xpath("//span[normalize-space()=\"OK\"]"));
		System.out.println("date time field updated");
		// yes or no
		waitEle(By.xpath("//span[text()=\"NO\"]"));
		System.out.println("yes or no field updated");
		// Weekday
		waitEle(By.xpath("//input[@placeholder=\"Weekdays\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[2]"));
		System.out.println("Weekday field updated");
		// TimeRange
//				waitEle(By.xpath("placeholder=\"Start time\""));
//				waitEle(By.xpath(""));
//				waitEle(By.xpath(""));
//				waitEle(By.xpath("//button[text()=\"OK\"]"));
 
		// date Feild
		waitEle(By.xpath("//input[@placeholder=\"Date\"]"));
		waitEle(By
				.xpath("(//div[@class=\"el-picker-panel__content\"])[2]//tr[@class=\"el-date-table__row\"][2]//td[3]"));
		System.out.println("date Feild field updated");
		// sigleLine Text
		driver.findElement(By.xpath("//input[@placeholder='Single Line Text']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Single Line Text']"), "Automation testing");
		System.out.println("sigleLine Text field updated");
				
		// document
		
		waitEle(By.xpath("//div[@class='el-upload el-upload--text']//span"));
		
		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe");
		
//		String pdffile = System.getProperty("user.dir") + "\\src\\test\\resources\\test.pdf";
//		Thread.sleep(10000);
//		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
//		fileInput.sendKeys(pdffile);
		System.out.println("Uploaded file successfully");
		System.out.println("document field updated");
		// list
		waitEle(By.xpath("//input[@placeholder='Please select...']"));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement]//li[2]"));
		System.out.println("list field updated");
		// fixedTime
		waitEle(By.xpath("//input[@placeholder='Fixed Time']"));
		waitEle(By.xpath("//div[@x-placement]//div[text()=\"02:00\"]"));
		System.out.println("fixedTime field updated");
		
		// multiselect
		try {
			waitEle(By.xpath("//i[@class=\"el-tag__close el-icon-close\"]"));
			Thread.sleep(3000);
			waitEle(By.xpath("//i[@class=\"el-tag__close el-icon-close\"]"));
		} catch (Exception e) {
 
		}
		waitEle(By.xpath("//input[@placeholder='Multi Select']"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[3]"));
		waitEle(By.xpath("//div[@x-placement]//li[2]"));
		waitEle(By.xpath("//i[@class='el-select__caret el-input__icon el-icon-arrow-up is-reverse']"));
		System.out.println("multiselect field updated");
		// Number
		driver.findElement(By.xpath("//input[@placeholder='Number']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Number']"), "10");
		System.out.println("Number field updated");
		
		// time
		waitEle(By.xpath("//input[@placeholder='Time']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[4]//ul//li[text()='00']"));
 
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[5]//ul//li[text()='00']"));
 
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[6]//ul//li[text()='00']"));
		waitEle(By.xpath("(//button[text()=\"OK\"])[2]"));
		System.out.println("time field updated");
	
		// phone no
		driver.findElement(By.xpath("//input[@placeholder='Phone no']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Phone no']"), "7337060228");
		System.out.println("phone no field updated");
		// Multiline
		driver.findElement(By.xpath("//textarea[@placeholder='Multiline']")).clear();
		sendKeysToElement(By.xpath("//textarea[@placeholder='Multiline']"), "Automation testing");
		System.out.println("Multiline field updated");
		// select
		waitEle(By.xpath("//input[@placeholder=\"Select\"]"));
		Thread.sleep(2000);
		waitEle(By.xpath("//div[@x-placement]//span[text()='chemistry']"));
		System.out.println("select field updated");
	
		// check box group
		waitEle(By.xpath("(//input[@type=\"checkbox\"])[1]"));
		System.out.println("check box group field updated");
	
		clickFinish();
		try {
			waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"));
		} catch (Exception e) {
		}
	}
	public void addPageAndClickOnPageTwoInDoc() throws Exception {
		waitEle(By.xpath("//button[@class=\"el-button el-tooltip add-page-bottom item el-button--default is-plain\"]"));
		waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//canvas[@id='0_canvas_page_2']"));
 
	}
	public void Rearranges(int id1,int id2) throws Exception {
		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));
 
		Actions actions = new Actions(driver);
 
		actions.clickAndHold(scrollbar).perform();
 
		int offset = 100;
		actions.moveByOffset(0, offset).perform();
 
		actions.release().perform();
		String xpath1 = String.format("//div[@id='user_%d']", id1);
		String xpath2 = String.format("//div[@id='user_%d']", id2);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement CC = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
		WebElement Signer = driver.findElement(By.xpath(xpath2));
		actions.clickAndHold(CC).moveToElement(Signer).release().build().perform();
		System.out.println("Rearrangement done");
	}
	public void clickGlobalVariable() throws Exception {
		Thread.sleep(20000);
 
		waitEle(By.xpath("//div[text()=\" Ramya Sibbala \"]"));
		Javascriptclick(By.xpath("//li[normalize-space()='Global Variables']"));
 
		System.out.println("Clicked on Global Variables in profile completed");
	}
	public boolean VerifyClickGlobalVariable() {
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id=\"global-variables-list\"]")));
		System.out.println("Click on global variables done Sucessfully");
		return name.isDisplayed();
	}
	
	public void clickNewVariable() throws Exception {
		waitEle(By.xpath("//span[@class='new-variable']"));
	}
	
	public void selectDataType() throws Exception {
		waitEle(By.xpath("//input[@placeholder=\"Select Data Type\"]"));
	}
	public void Htmlglobalvariable() throws Exception {
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@x-placement]//ul//span[text()='Html']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "HTML");
		
		sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"), "https://nsui.esigns.io/global-variables/add");
		
		}
	public void Imageglobalvariable() throws Exception {
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@x-placement]//ul//span[text()='Image']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Image");
		
		waitEle(By.xpath("//input[@placeholder='Select Image Upload Type']"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//span[text()='UPLOAD']"));
		
		waitEle(By.xpath("//em[text()='click to upload']"));
		Thread.sleep(1000);
		
		String pdffile = System.getProperty("user.dir") + "\\src\\test\\resources\\sent to contacts.png";
		Thread.sleep(10000);
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		fileInput.sendKeys(pdffile);
		System.out.println("Uploaded file successfully");
		
		}
	public void Listglobalvariable() throws Exception {
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@x-placement]//ul//span[text()='List']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "List");
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Name']"),"Fruits");
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Value']"),"100");
		
		waitEle(By.xpath("//span[normalize-space()='ADD']"));
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Name']"),"Vegetables");
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Value']"),"200");
		
		}
	public void AddVariable() throws Exception {
		
		waitEle(By.xpath("//span[normalize-space()='Add Variable']"));
		
		System.out.println("Global variable added successfully");
	}
	public void Currencyglobalvariable() throws Exception {
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@x-placement]//ul//span[text()='Currency']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Currency");
		
		waitEle(By.xpath("//input[@placeholder='Select']"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//span[text()='INR']"));
		
		sendKeysToElement(By.xpath("(//input[@class='el-input__inner'])[6]"),"1000");
		}
	public void Checkboxgroupglobalvariable() throws Exception {
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@x-placement]//ul//span[text()='Checkbox Group']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Checkbox Group");
		
		sendKeysToElement(By.xpath("(//input[@class='el-input__inner'])[5]"),"1");
		
		sendKeysToElement(By.xpath("(//input[@class='el-input__inner'])[6]"),"3");
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter options']"),"A");
		
		waitEle(By.xpath("//div[@x-placement]//ul//span[text()='A']"));
		
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"B");
		
		waitEle(By.xpath("//div[@x-placement]//ul//span[text()='B']"));
		
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"C");
		
		waitEle(By.xpath("//div[@x-placement]//ul//span[text()='C']"));
		
		}
	public void RadioGroupglobalvariable() throws Exception {
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@x-placement]//ul//span[text()='Radio Group']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Radio Group");
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter options']"),"1");
		
		waitEle(By.xpath("//div[@x-placement]//ul//span[text()='1']"));
		
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"2");
		
		waitEle(By.xpath("//div[@x-placement]//ul//span[text()='2']"));
		
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"),"3");
		
		waitEle(By.xpath("//div[@x-placement]//ul//span[text()='3']"));
		
	}
	public void StarRatingglobalvariable() throws Exception {
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@x-placement]//ul//span[text()='Star Rating']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Star Rating");
		
		waitEle(By.xpath("(//i[@class='el-rate__icon el-icon-star-off'])[1]"));
		
		waitEle(By.xpath("(//i[@class='el-rate__icon el-icon-star-off'])[1]"));
		
		waitEle(By.xpath("(//i[@class='el-rate__icon el-icon-star-off'])[1]"));
		}
	public void EditGlobalvariable() throws Exception {
		
		waitEle(By.xpath("(//button[@class='el-button el-tooltip el-button--warning el-button--mini is-plain is-circle'])[1]"));
		
		waitEle(By.xpath("(//i[@class='el-rate__icon el-icon-star-off'])[1]"));
		
		waitEle(By.xpath("//span[normalize-space()='Update Variable']"));
		
	}
	public void Duplicateglobalvariable() throws Exception {
		waitEle(By.xpath("(//button[@class='el-button el-tooltip el-button--default el-button--mini is-plain is-circle'])[2]"));
		
		Thread.sleep(1000);
		
		String Radiogroup = String.format("//input[@placeholder='Enter Field Title']");
		driver.findElement(By.xpath(Radiogroup)).clear();
		
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Radio Button1");
		
		waitEle(By.xpath("//span[normalize-space()='Duplicate Variable']"));
		}
	public void Deleteglobalvariable() throws Exception {

		waitEle(By.xpath("(//button[@class='el-button el-tooltip el-button--danger el-button--mini is-plain is-circle'])[3]"));
		
		waitEle(By.xpath("//span[normalize-space()='OK']"));
		
	}
	public void clickFormbuilder() throws Exception {
		Thread.sleep(20000);
		 
		waitEle(By.xpath("//div[text()=\" Ramya Sibbala \"]"));
		Javascriptclick(By.xpath("//li[normalize-space()='Form Builder']"));
 
		System.out.println("Clicked on Form builder in profile completed");
	}
	public void Addformbuilder() throws Exception {
		
		waitEle(By.xpath("//span[normalize-space()='Add Form Builder']"));
		
		sendKeysToElement(By.xpath("//input[@placeholder='Form builder name']"),"Formbuilder000");
		
		waitEle(By.xpath("//input[@placeholder='Select user type']"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Anyone']"));
		
		Thread.sleep(10000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select Group']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='QA']"));
		
		waitEle(By.xpath("//i[@class='el-select__caret el-input__icon el-icon-arrow-up is-reverse']"));
		
		waitEle(By.xpath("//span[normalize-space()='Save and Next']"));
		
		waitEle(By.xpath("(//div[normalize-space()='Contact details'])[1]"));
		
		waitEle(By.xpath("(//div[normalize-space()='templateBasicFeilds'])[1]"));
		
		waitEle(By.xpath("//span[normalize-space()='Save Steps']"));
		
	}
	public void AddAdminApprover() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		
		waitEle(By.xpath("//span[normalize-space()='Add Approvers']"));
		
		waitEle(By.xpath("(//input[@placeholder='Select user type'])[2]"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Company Users']"));
		
		waitEle(By.xpath("//input[@placeholder='Select company user type']"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='SA - ADMIN']"));
		Thread.sleep(1000);
		
		waitEle(By.xpath("//input[@placeholder='Select preferred user']"));
		
		Thread.sleep(1000);
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='jeevitha.patnana@nimbleaccounting.com']"));
		
		Thread.sleep(1000);
		
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='el-select__caret el-input__icon el-icon-arrow-up is-reverse']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
		
	}
	public void AddManagerapprover() throws Exception {
		
		waitEle(By.xpath("//span[normalize-space()='Add Approvers']"));
		
		waitEle(By.xpath("(//input[@placeholder='Select user type'])[3]"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Company Users']"));
		
		waitEle(By.xpath("(//input[@placeholder='Select company user type'])[2]"));
		
		Thread.sleep(1000);
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='SA - MANAGER']"));
	}
	public void AddMemberapprover() throws Exception {
		waitEle(By.xpath("//span[normalize-space()='Add Approvers']"));
		
		waitEle(By.xpath("(//input[@placeholder='Select user type'])[4]"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Company Users']"));
		
		waitEle(By.xpath("(//input[@placeholder='Select company user type'])[3]"));
		
		Thread.sleep(1000);
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='SA - MEMBER']"));
		
	}
	public void AddOwnerapprover() throws Exception {
		waitEle(By.xpath("//span[normalize-space()='Add Approvers']"));
		
		waitEle(By.xpath("(//input[@placeholder='Select user type'])[5]"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Company Users']"));
		
		waitEle(By.xpath("(//input[@placeholder='Select company user type'])[4]"));
		
		Thread.sleep(1000);
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='SA - OWNER']"));
		
		waitEle(By.xpath("//span[normalize-space()='Save Form builder']"));
	}
	public void ViewFormbuilder() throws Exception {
		Thread.sleep(1000);
		
		waitEle(By.xpath("(//div[@class='el-table__body-wrapper is-scrolling-none']//span[normalize-space()='Actions'])[1]"));
		
		waitEle(By.xpath("//ul[@x-placement]//a[1]"));
		
		Thread.sleep(10000);
		 WebElement urlElement = driver.findElement(By.xpath("//i[@class='el-icon-copy-document']"));

	        Actions actions = new Actions(driver);
	 
	        actions.click(urlElement).perform();

	        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
	        System.out.println(urlElement);
	        driver.switchTo().newWindow(WindowType.TAB);

	        Thread.sleep(2000);

	        actions.sendKeys(Keys.CONTROL + "l").perform(); // Focus the address bar
	        Thread.sleep(10000);
	        actions.sendKeys(Keys.CONTROL + "a").sendKeys(Keys.DELETE).perform(); // Select all and delete to clear the address bar
	        Thread.sleep(10000);
	        actions.sendKeys(Keys.CONTROL + "v").sendKeys(Keys.ENTER).perform();

	        Thread.sleep(5000);
		
	}
	public void SaveFormbuilder() throws Exception {
		waitEle(By.xpath("//span[normalize-space()='Save Form builder']"));
	}
	public void ApprovalSettings() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitEle(By.xpath("//span[normalize-space()='Approval Settings']"));
		
		waitEle(By.xpath("(//span[@class='el-checkbox__input'])[3]"));
		
		waitEle(By.xpath("//input[@placeholder='Select user type']"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Application Users']"));
		
		waitEle(By.xpath("//input[@placeholder='Select application user type']"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		Thread.sleep(1000);
		
		waitEle(By.xpath("//input[@placeholder='Select preferred user']"));
		
		Thread.sleep(1000);
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='jeevitha.patnana@nimbleaccounting.com']"));
		
		Thread.sleep(1000);
		
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='el-select__caret el-input__icon el-icon-arrow-up is-reverse']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
	}
	public void VerifyPrimarySettings() throws Exception {
		Thread.sleep(1000);
		
		waitEle(By.xpath("(//span[@class='el-checkbox__input'])[1]"));
		
		System.out.println("Primary settings successfull");
		}
	public void Limitedperiod() throws Exception {
		
		waitEle(By.xpath("(//span[@class='el-radio__input'])[1]"));
		
		waitEle(By.xpath("//input[@placeholder='Start date']"));
		
		waitEle(By.xpath("//div[@class='el-picker-panel__content el-date-range-picker__content is-left']//span[normalize-space()='22']"));
		
		waitEle(By.xpath("//div[@class='el-picker-panel__content el-date-range-picker__content is-right']//span[normalize-space()='22']"));
		
		Thread.sleep(3000);
		
		waitEle(By.xpath("//span[normalize-space()='OK']"));
		
		System.out.println("Limit period successfull");
	}
	public void UserSubmissionsettings() throws Exception {
		
		waitEle(By.xpath("//span[normalize-space()='User Submission Settings']"));
		
		waitEle(By.xpath("(//span[@class='el-checkbox__input'])[2]"));
		
		System.out.println("User submission settings successfull");
	}
	public void SuccessandRedirectpage() throws Exception {
		
		waitEle(By.xpath("//span[normalize-space()='Success Pages & Redirects']"));
		
		sendKeysToElement(By.xpath("//div[@class='paragraphScroll']//p"),"ThankYou for filling this form....");
		
		System.out.println("Success and Redirectpage settings successfull");
	}
	public void RemainderSettings() throws Exception {
		
		waitEle(By.xpath("//span[normalize-space()='Reminder Settings']"));
		
		String Range=String.format("(//input[@class='el-input__inner'])[1]");
		driver.findElement(By.xpath(Range)).clear();
		sendKeysToElement(By.xpath(Range), "2");
		
		waitEle(By.xpath("(//input[@placeholder='Select Type'])[1]"));
		
		waitEle(By.xpath("//div[@x-placement]//li//span[normalize-space()='HOURS']"));
		
		String Limit=String.format("(//input[@class='el-input__inner'])[2]");
		driver.findElement(By.xpath(Limit)).clear();
		sendKeysToElement(By.xpath(Limit), "2");
		
		waitEle(By.xpath("(//input[@placeholder='Select Type'])[2]"));
		
		waitEle(By.xpath("//div[@x-placement]//li//span[normalize-space()='DAYS']"));
		
		System.out.println("Remainder settings successfull");
		}
	public void ReceiverEmailCustomization() throws Exception {
		
		waitEle(By.xpath("//span[normalize-space()='Receiver email customization']"));
		
		System.out.println("ReceiverEmailCustomization settings successfull");
		
	}
	public void ExpirationSettings() throws Exception {
		
		waitEle(By.xpath("//span[normalize-space()='Expiration Settings']"));
		
		waitEle(By.xpath("//input[@placeholder='Expiry type']"));
		
		waitEle(By.xpath("//div[@x-placement]//li//span[normalize-space()='Month(s)']"));
		
		String Period=String.format("//input[@placeholder='Expiry Duration']");
		driver.findElement(By.xpath(Period)).clear();
		sendKeysToElement(By.xpath(Period), "1");
		
		System.out.println("Expiration settings successfull");
		}
	public void Customization() throws Exception {
		
		waitEle(By.xpath("//span[normalize-space()='Customization']"));
		
		System.out.println("Customization settings successfull");
	}
}
