package scripts;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReportManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class SptTest {
//String BaseURL = "https://spttest2.azurewebsites.net/";
private WebDriver driver;
protected String user = "prebera@dpssoftware.co.uk";
protected String pwd = "Enfield2019!";
protected ReportManager report;

  @Test
  public void sptLogin() {
	  try {
	    report = new ReportManager("Spitfire My Task", "Sanity Test");
	    By uName = By.xpath("//input[@name='loginfmt']");
	    waitForElemenet(uName);

		driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		
		By passwd = By.xpath("//input[@name='passwd']");
		waitForElemenet(passwd);
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		
		By btn = By.xpath("//input[@id='idBtn_Back']");
		waitForElemenet(btn);
		driver.findElement(By.xpath("//input[@id='idBtn_Back']")).click();
		
		
		By welcome = By.xpath("//dps-dashboard-layout//span[contains(text(),'Spitfire')]");
		waitForElemenet(welcome);
		Assert.assertEquals(driver.getTitle(), "Spitfire");
		
		report.writeLog("Login is succssfull");
		report.passStep("Login scenario is completed");
	  }catch(Exception e) {
	    e.printStackTrace();
	    report.writeFailure("DPS application environment is down");
	    report.finish();
	  }
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
	  //ChromeDriverManager.getInstance().setup();
	  
	  //WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  
	  String BaseURL= System.getProperty("customproperty");
	  driver.get(BaseURL);
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  //Thread.sleep(5000);
	  report.finish();
	  driver.close();
  }
  
  //Wait for element
 	public void waitForElemenet(By element) {
 		WebDriverWait waitO = new WebDriverWait(driver, 50);
 		WebElement elmOk = waitO.until(ExpectedConditions.elementToBeClickable(element));
 	}

}

//test -Dcustomproperty=https://spttest2.azurewebsites.net/
