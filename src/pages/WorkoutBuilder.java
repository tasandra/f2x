package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import modules.SignIn;

public class WorkoutBuilder extends HomePage {

	private Duration second = Duration.ofSeconds(1);

	private By panel = By.className("f2x-preconfigure-workout-group");
	private By save = By.xpath("//*[@class = 'f2x-workout-save-buttons']/button[2]");

	public WorkoutBuilder(WebDriver driver) {
		super(driver);
	}
	
	public String getTime(){
		String time = driver.findElement(By.cssSelector(".f2x-exercise-time.pc")).getText();	
		return time;
	}
	
	public String getCal(){
		String cal = driver.findElement(By.cssSelector(".f2x-exercise-cal.pc")).getText();
		return cal;
	}

	public void addClasses() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("f2x-exercise-add")))
				.click();

	}
	
	public void jsAddClasses(){
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector('.f2x-exercise-add.cover-img').click()");
		
	}

	public void dragDropClasses() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.className("f2x-exercise-img")));
		WebElement drag = driver.findElement(By.cssSelector(".f2x-exercise-img.cover-img.cursor"));
		WebElement drop = driver.findElement(By.cssSelector(".f2x-configure-workout-empty"));
		
		actions.pause(second);
		//actions.dragAndDrop(drag, drop);
		actions.clickAndHold(drag);
		actions.pause(second);
		actions.moveToElement(drop).release();
		actions.perform();

	}

	public void saveClasses1() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("f2x-add-workout")));
		driver.findElement(save).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("workout");
		driver.findElement(By.cssSelector(".f2x-buttons-rect")).click();

	}
	
	public void saveClasses2(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("f2x-add-workout")));
		driver.findElement(By.className("f2x-new-workout-name")).clear();
		driver.findElement(By.className("f2x-new-workout-name")).sendKeys("workout2");
		driver.findElement(save).click();
		
	}

	public WebElement getWorkoutPanel() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(panel));

	}

	public WebElement emptyWorkout() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@class = 'f2x-myworkout-empty-label-button']/button")));
	}

}
