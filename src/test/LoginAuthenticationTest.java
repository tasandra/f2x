package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import modules.SignIn;

public class LoginAuthenticationTest extends BaseTest {

	private SignIn loginPage;

	@Before
	public void setUpLogin() throws Exception {
		loginPage = new SignIn(driver);

		loginPage.load();
		loginPage.signin("tasandra", "password");
		WebElement avatar = loginPage.getAvatar();
		assertEquals(true, avatar.isDisplayed());
	}

}