package Pages;


import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Newdocument {
	WebDriver driver;

	public Newdocument(WebDriver driver) {
		this.driver = driver;
	}

	public void waitEle(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void AllCombos() throws InterruptedException {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Create Document']"));

	}

	public void ValidAllCombos() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Message = wait1.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[@class='text-center text-dark fw-normal fs-4 mb-1']")));
		Assert.assertNotNull(Message, "Upload document element is not present Create document failed");
		System.out.println("Create document successfull");
	}

	@SuppressWarnings("deprecation")
	public void uploadDocument() throws Exception {

		waitEle(By.xpath("//h4[@class='fw-normal blue pb-2']"));

		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe");

//		waitTill(By.xpath("//button[@class='el-button text-center upload-btn el-button--danger']"));

		Thread.sleep(10000);
	}

	public void ValidUploadDocument() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button not present Create document failed");
		System.out.println("Upload document successfull");

	}

	

	public void ValidUploadMultipleDocument() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button not present Create document failed");
		System.out.println("Upload document successfull");

	}

	public void oneDriveupload() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		waitEle(By.xpath("//img[@src='/img/onedrive.cc38d634.svg']"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		String Parentwindowid = driver.getWindowHandle();

		waitEle(By.xpath("//button[normalize-space()='Connect OneDrive']"));
		Thread.sleep(5000);

		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String childwindow : allwindowhandles) {
			if (!childwindow.endsWith(Parentwindowid)) {
				driver.switchTo().window(childwindow);
				driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("bsrv.prudhviraju@outlook.com");

				waitEle(By.xpath("//input[@id='idSIButton9']"));

				Thread.sleep(10000);

				By password = By.xpath("//input[@id='i0118']");
				WebElement Upload1 = wait.until(ExpectedConditions.elementToBeClickable(password));
				Upload1.sendKeys("Prjking@99");

				Thread.sleep(10000);
				waitEle(By.xpath("//input[@id='idSIButton9']"));
				try {
					waitEle(By.xpath("//button[normalize-space()='Yes']"));
				} catch (Exception e) {
					// TODO: handle exception
				}

				Thread.sleep(5000);
				Set<String> windowHandles1 = driver.getWindowHandles();
				for (String handle : windowHandles1) {
					driver.switchTo().window(handle);
				}

				waitEle(By.xpath("//span//span[normalize-space()='Document 1.docx']"));

				waitEle(By.xpath("//span[@title='Upload']"));

			}
		}
	}

	public void ValidOneDrive() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button not present Create document failed");
		System.out.println("One Drive Upload document successfull");

	}

	public void googledrive() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		waitEle(By.xpath("//img[@placeholder='top-start']"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid = driver.getWindowHandle();

		waitEle(By.xpath("//span[normalize-space()='Sign in with Google']"));

		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String childwindow : allwindowhandles) {
			if (!childwindow.endsWith(Parentwindowid)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);

				By upload3 = By.xpath("//input[@id=\\\"identifierId\\\"]");
				WebElement upload2 = wait.until(ExpectedConditions.elementToBeClickable(upload3));
				upload2.sendKeys("n180894@rguktn.ac.in");

				waitEle(By.xpath("//span[normalize-space()='Next']"));

				Set<String> windowHandles1 = driver.getWindowHandles();
				for (String handle : windowHandles1) {
					driver.switchTo().window(handle);

				}
				By user = By.xpath("//input[@name='Passwd']");
				WebElement user1 = wait.until(ExpectedConditions.elementToBeClickable(user));
				user1.sendKeys("meghu@123");

				waitEle(By.xpath("//span[normalize-space()='Next']"));

				Thread.sleep(10000);
				Set<String> windowHandles11 = driver.getWindowHandles();
				for (String handle : windowHandles11) {
					driver.switchTo().window(handle);

				}

				waitEle(By.xpath("//span[normalize-space()='Allow']"));

				Set<String> windowHandles111 = driver.getWindowHandles();
				for (String handle : windowHandles111) {
					driver.switchTo().window(handle);

				}

				waitEle(By.xpath("//span[normalize-space()='N180894-resume.pdf']"));

				Set<String> windowHandles2 = driver.getWindowHandles();
				for (String handle : windowHandles2) {
					driver.switchTo().window(handle);

				}

				waitEle(By.xpath("//span[@class='fsp-button fsp-button--primary fsp-button-upload']"));
			}
		}
	}

	public void ValidGoogleDriveUploadDocument() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button not present Create document failed");
		System.out.println("Google Drive Upload document successfull");

	}

	

	@SuppressWarnings("unused")
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

	public void waitAndClick(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();
	}
	
	
	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
	}
	
	
	

}
