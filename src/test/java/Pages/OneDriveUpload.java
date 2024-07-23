package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneDriveUpload {
	WebDriver driver;

	public OneDriveUpload(WebDriver driver) {
		this.driver = driver;
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
				driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
				Thread.sleep(10000);
				By password = By.xpath("//input[@id='i0118']");
				WebDriverWait file1 = new WebDriverWait(driver, Duration.ofMinutes(3));
				WebElement Upload1 = file1.until(ExpectedConditions.elementToBeClickable(password));
				Upload1.sendKeys("Prjking@99");
				driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
				By password1 = By.xpath("//input[@id='idSIButton9']");
				WebDriverWait file2 = new WebDriverWait(driver, Duration.ofMinutes(3));
				WebElement Upload2 = file2.until(ExpectedConditions.elementToBeClickable(password1));
				Upload2.click();
				Thread.sleep(5000);
				Set<String> windowHandles1 = driver.getWindowHandles();
				for (String handle :windowHandles1) { driver.switchTo().window(handle);
				}
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span//span[normalize-space()='Document 1.docx']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span[@title='Upload']")).click();
				Thread.sleep(10000);
				//driver.findElement(By.xpath(""))
				driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
			}
		}
	}
}
