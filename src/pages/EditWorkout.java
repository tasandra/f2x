package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditWorkout extends HomePage {

	private Duration second = Duration.ofSeconds(3);

	private By panel = By.className("f2x-preconfigure-workout-group-i");
	private By delete = By.xpath("//*[@class = 'f2x-myworkouts-options']/button[2]");
	private By edit = By.xpath("//*[@class = 'f2x-myworkouts-options']/button");
	private By deleteConf = By.cssSelector(".f2x-new-button-black");
	private By save = By.xpath("//*[@class = 'f2x-workout-save-buttons']/button[2]");
	private WorkoutBuilder workout;

	public EditWorkout(WebDriver driver) {
		super(driver);
		workout = new WorkoutBuilder(driver);
	}

	public void editWorkout() {
		actions.moveToElement(driver.findElement(panel)).moveToElement(driver.findElement(edit))
				.click();
		actions.perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("f2x-modal-title")))
				.equals("EDIT WORKOUT");

	}

	public void addExercise() {
		driver.findElement(By.xpath("//*[@class = 'f2x-workout-save-buttons']/button")).click();
		workout.addClasses();
		driver.findElement(save).click();

	}

	public void deleteExercise() {

		driver.findElement(By.cssSelector(".remove")).click();
		driver.findElement(save).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".f2x-myworkout-item")));
	}

	public void deleteWorkout() {
		actions.pause(second);
		actions.moveToElement(driver.findElement(panel)).moveToElement(driver.findElement(delete))
				.click();
		actions.perform();

		wait.until(ExpectedConditions.presenceOfElementLocated(deleteConf)).isDisplayed();
		driver.findElement(deleteConf).click();
	}

	public WebElement empty() {
		return wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.className("f2x-myworkout-empty-label")));
	}

}
