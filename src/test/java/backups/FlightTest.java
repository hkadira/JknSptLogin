package backups;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class FlightTest {
	private final String BASE_URL = "http://newtours.demoaut.com/";
	private WebDriver driver;

	@Test(enabled = true , priority = 1)
	public void nav() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Cruises")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Home")).click();
	}

	@Test(enabled = true , priority = 2)
	public void login() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
	}

	@BeforeTest
	public void beforeTest() {
		//System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get(BASE_URL);
	}

	@AfterTest
	public void afterTest() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();
	}
}
