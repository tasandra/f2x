package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import modules.SignIn;

public class WorkoutBuilder extends HomePage {
	private By panel = By.className("f2x-preconfigure-workout-group");
	private By delete = By.xpath("//*[@class = 'f2x-myworkouts-options']/button[3]");
	private By deleteConf = By.cssSelector(".f2x-new-button-black");

	public WorkoutBuilder(WebDriver driver) {
		super(driver);
	}

	public void addClasses() {
		driver.findElement(By.className("f2x-exercise-add")).click();
		driver.findElement(By.className("f2x-exercise-add")).click();

		driver.findElement(By.xpath("//div[@class = 'f2x-workout-save-buttons']//button[2]"))
				.click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("workout1");
		driver.findElement(By.cssSelector(".f2x-button.f2x-button-black")).click();

	}

	public WebElement getWorkoutPanel() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(panel));

	}

	public void deleteWorkout() {
		actions.moveToElement(driver.findElement(panel)).moveToElement(driver.findElement(delete))
				.click();
		actions.perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteConf));
		driver.findElement(deleteConf).click();
	}

	public WebElement emptyWorkout() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@class = 'f2x-myworkout-empty-label-button']/button")));
	}

}
