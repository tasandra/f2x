package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import modules.SignIn;
import pages.WorkoutBuilder;

public class WorkoutAddTest extends BaseTest {
	private WorkoutBuilder workout;
	private SignIn signin;

	@Before
	public void setUp() throws Exception {
		workout = new WorkoutBuilder(driver);
		signin = new SignIn(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		signin.load();
		signin.signin("tasandra", "password");
		WebElement avatar = signin.getAvatar();
		assertEquals(true, avatar.isDisplayed());
		String title = signin.goToBuilder();

		// add two class

		assertEquals("EXERCISES", title);
		workout.addClasses();
		assertEquals("EXERCISES", title);
		workout.addClasses();
		workout.saveClasses1();
		WebElement panel = workout.getWorkoutPanel();
		assertEquals(true, panel.isDisplayed());

		// drop one class
		signin.goToBuilder();
		assertEquals("EXERCISES", title);
		workout.dragDropClasses();
		workout.addClasses();
		workout.saveClasses2();

	}

}
