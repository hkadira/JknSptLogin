package scripts;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class JSTest {
private  final String BASE_URL = "https://www.google.lk/";
WebDriver driver;

  @Test(groups = "smoke")
  public void jsexecute() throws IOException {
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("alert(document.title);");
	  
	 /* String externalJS = Files.toString( new File("JS/alert.js"), Charset.forName("utf-8"));
	  js.executeScript(externalJS);*/

	  /*JavascriptExecutor js = (JavascriptExecutor)driver;
	  String sText =  js.executeScript("return document.title;").toString();*/
  }
  
  @BeforeClass(groups = "smoke")
  public void beforeClass() {
	  //System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
	  ChromeDriverManager.getInstance().setup();
	  driver = new ChromeDriver();
	  //driver.get(BASE_URL);
  }

  @AfterClass(groups = "smoke")
  public void afterClass() {
	  driver.close();
  }

}
