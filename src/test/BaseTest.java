package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait wait;

	@Before
	public void baseSetUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
//----------------iPhone-------------------------------------------------------------
		// String ios8 = "Mozilla/5.0 (iPhone; CPU iPhone OS 8_0_2 like Mac OS
		// X) "
		// + "AppleWebKit/600.1.4 (KHTML, like Gecko)"
		// + " Version/8.0 Mobile/12A366 Safari/600.1.4";
		//
		// ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.addArguments("--user-agent=" + ios8);
		//
		// driver = new ChromeDriver(chromeOptions);
		// driver.manage().window().setSize(new Dimension(414, 736));
		
//-----------------Safari-------------------------------------------------------------
//		String safari = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_6; en-US) "
//				+ "AppleWebKit/533.20.25 (KHTML, like Gecko)"
//				+ " Version/5.0.4 Safari/533.20.27";
//		 ChromeOptions chromeOptions = new ChromeOptions();
//				 chromeOptions.addArguments("--user-agent=" + safari);
//				 
//				 driver = new ChromeDriver(chromeOptions);

//-----------------main drivers--------------------------------------------------------		
		driver = new FirefoxDriver();
//		// driver = new ChromeDriver();
//		// driver = new SafariDriver();

		wait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void baseTearDown() throws Exception {
		driver.quit();
	}
}