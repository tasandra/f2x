package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import modules.SignIn;

public class WorkoutBuilder extends HomePage {

	private Duration second = Duration.ofSeconds(1);

	private By panel = By.className("f2x-preconfigure-workout-group");
	private By delete = By.xpath("//*[@class = 'f2x-myworkouts-options']/button[3]");
	private By edit = By.xpath("//*[@class = 'f2x-myworkouts-options']/button");
	private By deleteConf = By.cssSelector(".f2x-new-button-black");

	public WorkoutBuilder(WebDriver driver) {
		super(driver);
	}

	public String goToBuilder() {
		driver.findElement(By.xpath("//*[@class = 'f2x-header-menu-items']/ul/li[1]")).click();

		return wait.until(
				ExpectedConditions.presenceOfElementLocated(By.className("f2x-section-title")))
				.getText();
	}

	public void addClasses() {
		driver.findElement(By.className("f2x-exercise-add")).click();

	}

	public void dragDropClasses() {
		WebElement drag = driver.findElement(By.className("f2x-exercise-img"));
		WebElement drop = driver.findElement(By.className("f2x-configure-workout-slider"));

		actions.dragAndDrop(drag, drop);
		actions.pause(second);
		actions.perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("f2x-add-workout")));
		driver.findElement(By.className("f2x-new-workout-name")).clear();
		driver.findElement(By.className("f2x-new-workout-name")).sendKeys("workout2");
		driver.findElement(By.xpath("//div[@class = 'f2x-workout-save-buttons']//button[2]"))
				.click();

	}

	public void saveClasses() {
		driver.findElement(By.xpath("//div[@class = 'f2x-workout-save-buttons']//button[2]"))
				.click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("workout");
		driver.findElement(By.cssSelector(".f2x-button.f2x-button-black")).click();

	}

	public WebElement getWorkoutPanel() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(panel));

	}

	public void editWorkout() {
		actions.moveToElement(driver.findElement(panel)).moveToElement(driver.findElement(edit))
				.click();
		actions.perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("f2x-modal-title")))
				.equals("EDIT WORKOUT");
		// add class
		driver.findElement(By.xpath("//*[@class = 'f2x-workout-save-buttons']/button")).click();
		addClasses();
		driver.findElement(By.xpath("//div[@class = 'f2x-workout-save-buttons']/button[2]"))
				.click();
		// delete class
		getWorkoutPanel();
		actions.moveToElement(driver.findElement(panel)).moveToElement(driver.findElement(edit))
				.click();
		actions.perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("f2x-modal-title")))
				.equals("EDIT WORKOUT");
		driver.findElement(By
				.xpath("//*[@class = 'f2x-configure-workout-slider ps-container ps-theme-default']/div[2]/div"))
				.click();
		driver.findElement(By.xpath("//div[@class = 'f2x-workout-save-buttons']/button[2]"))
				.click();
	}

	public void deleteWorkout() throws InterruptedException {
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(panel)).moveToElement(driver.findElement(delete))
				.click();
		actions.perform();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(deleteConf));
		driver.findElement(deleteConf).click();
	}

	public WebElement emptyWorkout() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@class = 'f2x-myworkout-empty-label-button']/button")));
	}

}
