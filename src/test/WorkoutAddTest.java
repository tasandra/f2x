package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import modules.SignIn;
import pages.HomePage;
import pages.WorkoutBuilder;

public class WorkoutAddTest extends LoginAuthenticationTest {
	private WorkoutBuilder workout;
	private HomePage home;

	@Before
	public void setUp() throws Exception {
		workout = new WorkoutBuilder(driver);
		home = new HomePage(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		String title = home.goToBuilder();

		// add two classes
		assertEquals("EXERCISES", title);
		workout.addClasses();
		assertEquals("EXERCISES", title);
		workout.addClasses();
		workout.saveClasses1();
		WebElement panel = workout.getWorkoutPanel();
		assertEquals(true, panel.isDisplayed());

		// drop one class
		home.goToBuilder();
		assertEquals("EXERCISES", title);
		workout.dragDropClasses();
		//workout.jsAddClasses();
		assertEquals("EXERCISES", title);
		workout.jsAddClasses();
		workout.saveClasses2();
		WebElement panel2 = workout.getWorkoutPanel();
		assertEquals(true, panel2.isDisplayed());

	}

}
