package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import pages.HomePage;
import pages.SortWorkout;
import pages.WorkoutBuilder;

public class SortWorkoutTest extends BaseTest {
	private WorkoutBuilder workout;
	private SortWorkout sort;
	private HomePage home;

	@Before
	public void setUp() throws Exception {
		workout = new WorkoutBuilder(driver);
		sort = new SortWorkout(driver);
		home = new HomePage(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		home.load();
		String userAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		System.out.print(userAgent);
		workout.goToBuilder();
// sort ascendent
		sort.sortA_Z();

		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> sortNameASC = driver
				.findElements(By.cssSelector(".f2x-exercise-name>span"));

		for (WebElement name : sortNameASC) {
			obtainedList.add(name.getText());
		}
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		assertTrue(sortedList.equals(obtainedList));
// sort descended
		sort.sortZ_A();
		
		ArrayList<String> obtainedList2 = new ArrayList<>();
		List<WebElement> sortNameDEC = driver
				.findElements(By.cssSelector(".f2x-exercise-name>span"));

		for (WebElement name2 : sortNameDEC) {
			obtainedList.add(name2.getText());
		}
		ArrayList<String> sortedList2 = new ArrayList<>();
		for (String s2 : obtainedList2) {
			sortedList2.add(s2);
		}
		Collections.reverse(sortedList2);
		assertTrue(sortedList2.equals(obtainedList2));

	}
}
