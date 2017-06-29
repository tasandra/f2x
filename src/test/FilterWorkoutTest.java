package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.HomePage;
import pages.FilterWorkout;
import pages.WorkoutBuilder;

public class FilterWorkoutTest extends BaseTest {
	private WorkoutBuilder workout;
	private FilterWorkout filter;
	private HomePage home;

	@Before
	public void setUp() throws Exception {
		workout = new WorkoutBuilder(driver);
		filter = new FilterWorkout(driver);	
		home = new HomePage(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		home.load();
		workout.goToBuilder();
		
		filter.sortAbs();
		List<WebElement> absSort = driver.findElements(By.className("f2x-exercise-img-labels "));
		for (WebElement abs : absSort) {
			String label = abs.getText();
			assertTrue(label.equals("Abs/Core"));
		}
		
		filter.sortLegsAndAbs();
		List<WebElement> abslegsSort = driver.findElements(By.className("f2x-exercise-img-labels "));
		for (WebElement abs : abslegsSort) {
			String label = abs.getText();
			assertTrue(label.equals("Abs/Core"));
			assertTrue(label.equals("Legs") || label.equals("Abs/Core"));
		}
		
	}

}
