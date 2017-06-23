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
		forgot.forgot("tasandra@mail.ru", "");
		String reset = forgot.getEmailReset();
		assertEquals("RESET PASSWORD", reset);
		home.closeModal();
	}

}
