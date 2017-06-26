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
		// add two class
		workout.addClasses();
		workout.addClasses();
		workout.saveClasses();
		WebElement panel = workout.getWorkoutPanel();
		assertEquals(true, panel.isDisplayed());
		workout.deleteWorkout();
		WebElement empty = workout.emptyWorkout();
		assertEquals(true, empty.isDisplayed());
		
		// drop one class
		workout.goToBuilder();
		String title = workout.goToBuilder();
		assertEquals("EXERCISES", title);
		workout.dragDropClasses();
		
		// edit 
		workout.editWorkout();
		// delete last class
		workout.deleteWorkout();
		WebElement empty2 = workout.emptyWorkout();
		assertEquals(true, empty2.isDisplayed());

	}

}
