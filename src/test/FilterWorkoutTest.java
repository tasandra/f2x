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
		
		// filter LEAD TRAINER
		String trainer = filter.filterLeadTrainer();
		List<WebElement> lead = driver.findElements(By.className("f2x-exercise-trainer"));
		for (WebElement leadTrainer : lead){
			String lt = leadTrainer.getText();
			assertEquals(trainer, lt);
		}
		
		filter.resetAll();
		
		// filter INTENSITY
		filter.filterIntensity();
		List<WebElement> inten = driver.findElements(By.className(".f2x-exercise-img-labels.pc"));
		for (WebElement level : inten) {
			String label = level.getText();
			assertTrue(label.equals(2));
		}
		
		filter.resetAll();
		
		// filter MUSCLE GROUP
		filter.filterAbs();
		List<WebElement> absSort = driver.findElements(By.className("f2x-exercise-img-labels"));
		for (WebElement abs : absSort) {
			String label = abs.getText();
			assertTrue(label.equals("Abs/Core"));
		}
		
		filter.filterLegsAndAbs();
		List<WebElement> abslegsSort = driver.findElements(By.className("f2x-exercise-img-labels"));
		for (WebElement abs : abslegsSort) {
			String label = abs.getText();
			assertTrue(label.equals("Legs") || label.equals("Abs/Core"));
		}
		
	}

}
