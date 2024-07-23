package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {
	WebDriver driver;

	public Login(WebDriver driver) {

		this.driver = driver;

	}

	public void Signin() throws InterruptedException {
		Thread.sleep(10000);
//		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
//				.sendKeys("N180959@rguktn.ac.in");
//		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Ramya@1234");
//		driver.findElement(By.xpath("//span[normalize-space()='Log In']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
		.sendKeys("ramya.sibbala@nimbleaccounting.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Ramyasri@123");
		driver.findElement(By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--danger']")).click();
		Thread.sleep(10000);

	}

	public void VerifyLoginSucess() {

	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	        WebElement welcomeMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='fw-large blue-dark mb-3 fs-10']")));


	        Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
	        System.out.println("Login Successful");
    }
	    }


