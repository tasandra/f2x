package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modules.ForgotPass;
import pages.HomePage;

public class ForgotTest extends BaseTest {
	private ForgotPass forgot;
	private HomePage home;

	@Before
	public void setUp() throws Exception {
		forgot = new ForgotPass(driver);
		home = new HomePage(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		forgot.load();
// valid email send email with reset link
		forgot.forgot("tasandra@mail.ru");
		String reset = forgot.getEmailReset();
		assertEquals("RESET PASSWORD", reset);
		forgot.closeModal();
// invalid email error messages		
		String error = forgot.getErrorMessage("tasa");
		assertEquals("PLEASE ENTER A VALID EMAIL ADDRESS", error);
		forgot.closeModal();
		
		String error1 = forgot.getValidEmail("tasa@mail.ru");
		assertEquals("Please enter a correct username", error1);
		forgot.closeModal();
		
		String error2 = forgot.getErrorMessage("");
		assertEquals("USERNAME NEEDED", error2);
		forgot.closeModal();
		
		
		
	}

}
