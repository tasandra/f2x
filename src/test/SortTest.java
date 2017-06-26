package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.HomePage;
import pages.SortWorkout;
import pages.WorkoutBuilder;

public class SortTest extends BaseTest {
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
		workout.goToBuilder();
		sort.sortAbs();
		sort.sortLegsAndAbs();
		
	}

}
