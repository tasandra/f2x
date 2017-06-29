package pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SortWorkout extends HomePage {

	public SortWorkout(WebDriver driver) {
		super(driver);
	}

	public void sortAbs() {
		driver.findElement(
				By.xpath("//*[@class = 'f2x-exercise-filter-inter']/div[5]/div[2]/button[1]"))
				.click();

		List<WebElement> absSort = driver.findElements(By.className("f2x-exercise-img-labels "));
		for (WebElement abs : absSort) {
			String label = abs.getText();
			assertTrue(label.equals("Abs/Core"));
		}
	}

	public void sortLegsAndAbs(){
		driver.findElement(
				By.xpath("//*[@class = 'f2x-exercise-filter-inter']/div[5]/div[2]/button[5]"))
				.click();
		
		List<WebElement> abslegsSort = driver.findElements(By.className("f2x-exercise-img-labels "));
		for (WebElement abs : abslegsSort) {
			String label = abs.getText();
			assertTrue(label.equals("Abs/Core"));
			assertTrue(label.equals("Legs") || label.equals("Abs/Core"));
		}

	}

}
