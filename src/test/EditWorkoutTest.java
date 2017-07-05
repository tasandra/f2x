package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import modules.SignIn;
import pages.EditWorkout;
import pages.HomePage;
import pages.WorkoutBuilder;

public class EditWorkoutTest extends LoginAuthenticationTest {
	private EditWorkout edit;
	private WorkoutBuilder workout;
	private HomePage home;

	@Before
	public void setUp() throws Exception {
		edit = new EditWorkout(driver);
		workout = new WorkoutBuilder(driver);
		home = new HomePage(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		home.goToMyWorkouts();
		WebElement item = edit.goToMyWorkouts();
		assertEquals(true, item.isDisplayed());

		// add classes, get size before add class
		List<WebElement> classes = driver.findElements(By.cssSelector(".f2x-myworkout-item"));
		int lenght = classes.size();
		edit.editWorkout();
		edit.addExercise();
		lenght++;
		classes = driver.findElements(By.cssSelector(".f2x-myworkout-item"));
		assertEquals(lenght, classes.size());

		// delete classes
		edit.editWorkout();
		edit.deleteExercise();
		assertEquals(lenght, classes.size());

		// delete workout
		WebElement panel = workout.getWorkoutPanel();
		assertEquals(true, panel.isDisplayed());
		List<WebElement> panels = driver
				.findElements(By.className("f2x-preconfigure-workout-group-i"));
		for (int i = 0; i < panels.size(); i++) {
			edit.deleteWorkout();
		}
		WebElement empty = edit.empty();
		assertEquals(true, empty.isDisplayed());

	}

}
