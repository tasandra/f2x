package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterWorkout extends HomePage {

	public FilterWorkout(WebDriver driver) {
		super(driver);
	}

	public void filterAbs() {
		driver.findElement(
				By.xpath("//*[@class = 'f2x-exercise-filter-inter']/div[5]/div[2]/button[1]"))
				.click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".f2x-exercise-img-padding button")));
	}

	public void filterLegsAndAbs() {
		driver.findElement(
				By.xpath("//*[@class = 'f2x-exercise-filter-inter']/div[5]/div[2]/button[5]"))
				.click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".f2x-exercise-img-padding button")));

	}

}
