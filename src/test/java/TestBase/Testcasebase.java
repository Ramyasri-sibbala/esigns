package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcasebase {
	protected WebDriver driver;

//	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//	public void setUp() {
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		options.addArguments("--window-size=1920,1080");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--no-sandbox");
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.get("https://nsui.esigns.io/");
//		driver.get("https://dev.esigns.io/signin");
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
////			driver.navigate().to("https://dev.esigns.io/");
//			driver.navigate().to("https://nsui.esigns.io/");
        

       
//		}
	public void setUpchrome() {
	        
       // WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--ignore-certificate-errors");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        
//        driver = new ChromeDriver();

    	driver.manage().window().maximize();

    	driver.get("https://nsui.esigns.io/");
		
     
    }
	public void setUpedge() {
		 WebDriverManager.edgedriver().setup();
	        EdgeOptions options = new EdgeOptions();
	        options.addArguments("-inprivate");
	        driver = new EdgeDriver(options);
	        driver.manage().window().maximize();
	        driver.navigate().to("https://nsui.esigns.io/");
	}
	public void setUpIcognito() {
		WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--incognito");
		   
		    driver = new ChromeDriver(options); 

	        driver.manage().window().maximize();
	        driver.get("https://nsui.esigns.io/");
		
	}
//   public WebDriver getDriver() {
//        return driver.get();
//    }

	

}
