package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SortWorkout extends HomePage {

	public SortWorkout(WebDriver driver) {
		super(driver);
	}

	public void sortA_Z() {
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector(".f2x-exercise-sort")))
				.click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class = 'f2x-exercise-sort']//div[4]")))
				.click();
	}
	
	public void sortZ_A() {
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector(".f2x-exercise-sort")))
				.click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class = 'f2x-exercise-sort']//div[5]")))
				.click();
	}

}
