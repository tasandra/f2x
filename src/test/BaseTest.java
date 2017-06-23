package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait wait;

	@Before
	public void baseSetUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver");

	driver = new FirefoxDriver();
//		driver = new ChromeDriver();
		//driver = new SafariDriver();
		
		wait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void baseTearDown() throws Exception {
		driver.quit();
	}
}