package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import modules.SignIn;

public class SigninTest extends BaseTest {
	private SignIn signin;

	@Before
	public void setUp() throws Exception {
		signin = new SignIn(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		signin.load();
		
		// log in with user name
		signin.signin("tasandra", "password");
		WebElement avatar = signin.getAvatar();
		assertEquals(true, avatar.isDisplayed());
		signin.signout();
		
		// log in with email
		signin.signin("tasandra@mail.ru", "password");
		WebElement avatar1 = signin.getAvatar();
		assertEquals(true, avatar1.isDisplayed());
		signin.signout();
		
		// check error messages
		String exError = signin.checkError("tasandra", "password1");	
		assertEquals("PLEASE ENTER A CORRECT USERNAME AND PASSWORD", exError);
		signin.closeModal();
		
		String exError1 = signin.checkError("tasandra1", "password");	
		assertEquals("PLEASE ENTER A CORRECT USERNAME AND PASSWORD", exError1);
		signin.closeModal();
	}
}
