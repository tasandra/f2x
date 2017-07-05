package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
		String selected = driver
				.findElement(By.cssSelector("li.separated")).getAttribute("selected");
		assertTrue(selected, true);

		// add two classes and get time
		assertEquals("EXERCISES", title);
		String[] parts = workout.getTime().split(":");
		int min = Integer.parseInt(parts[0]);
		int sec = Integer.parseInt(parts[1]);
		int cal = Integer.parseInt( workout.getCal());
		workout.addClasses();
		
		assertEquals("EXERCISES", title);
		String[] parts2 = workout.getTime().split(":");
		int min2 = Integer.parseInt(parts2[0]);
		int sec2 = Integer.parseInt(parts2[1]);
		int cal2 = Integer.parseInt( workout.getCal());
		workout.addClasses();
		
		// calculate time
		int minsum = min + min2;
		int secsum = sec + sec2;
		if( secsum > 60){
			minsum += 1;
		}
		String sum = driver.findElement(By.cssSelector(".small-font.float-l.montse_light")).getText();
		assertEquals(minsum + " min | "+ (cal + cal2) +" cal", sum);
		workout.saveClasses1();
		WebElement panel = workout.getWorkoutPanel();
		assertEquals(true, panel.isDisplayed());

		// drop one class
		home.goToBuilder();
		assertEquals("EXERCISES", title);
		String[] parts3 = workout.getTime().split(":");
		int min3 = Integer.parseInt(parts3[0]);
		int sec3 = Integer.parseInt(parts3[1]);
		int cal3 = Integer.parseInt( workout.getCal());
		workout.dragDropClasses();
		//workout.jsAddClasses();
	
		assertEquals("EXERCISES", title);
		String[] parts4 = workout.getTime().split(":");
		int min4 = Integer.parseInt(parts4[0]);
		int sec4 = Integer.parseInt(parts4[1]);
		int cal4 = Integer.parseInt( workout.getCal());
		workout.jsAddClasses();
		
		int minsum2 = min3 + min4;
		int secsum2 = sec3 + sec4;
		if( secsum2 > 60){
			minsum2 += 1;
		}
		String sum2 = driver.findElement(By.cssSelector(".small-font.float-l.montse_light")).getText();
		assertEquals(minsum2 + " min | "+ (cal3 + cal4) +" cal", sum2);
		
		workout.saveClasses2();
		WebElement panel2 = workout.getWorkoutPanel();
		assertEquals(true, panel2.isDisplayed());

	}

}
