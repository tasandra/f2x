package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import modules.IPhoneSignin;
import pages.HomePage;

public class IPhoneTest extends BaseTest {
	private HomePage home;
	private IPhoneSignin iphone;

	@Before
	public void setUp() throws Exception {
		home = new HomePage(driver);
		iphone = new IPhoneSignin(driver);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		home.load();
		String userAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		System.out.print(userAgent);
		
		String title = driver.findElement(By.xpath("//*[@id='f2x-header']/div[2]/div[2]/div")).getText();
		assertEquals("FASHION/FITNESS", title);
		
		// log in with user name
				iphone.isignin("tasandra", "password");
				WebElement avatar = iphone.iPhoneGetAvatar();
				assertEquals(true, avatar.isDisplayed());
				iphone.iPhonesignout();
				
				// log in with email
				iphone.isignin("tasandra@mail.ru", "password");
				WebElement avatar1 = iphone.iPhoneGetAvatar();
				assertEquals(true, avatar1.isDisplayed());
				iphone.iPhonesignout();
				
				// check error messages
				String exError = iphone.icheckError("tasandra", "password1");	
				assertEquals("PLEASE ENTER A CORRECT USERNAME AND PASSWORD", exError);
				iphone.closeModal();
				
				String exError1 = iphone.icheckError("tasandra1", "password");	
				assertEquals("PLEASE ENTER A CORRECT USERNAME AND PASSWORD", exError1);
				iphone.closeModal();
	}

}
