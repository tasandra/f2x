package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;
	protected String pageUrl = "http://jeekjee.net:8001/";

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
		actions = new Actions(driver);
	}

	public void load() {
		driver.get(pageUrl);
	}

	public String goToBuilder() {
		driver.findElement(By.xpath("//*[@class = 'f2x-header-menu-items']/ul/li[1]")).click();

		return wait.until(
				ExpectedConditions.presenceOfElementLocated(By.className("f2x-section-title")))
				.getText();
	}

	public WebElement goToMyWorkouts() {
		driver.findElement(By.xpath("//*[@class = 'f2x-header-menu-items']/ul/li[2]")).click();

		return wait.until(ExpectedConditions
				.presenceOfElementLocated(By.cssSelector(".f2x-myworkout-item ")));
		
	}

	public void closeModal() {
		driver.findElement(By.className("close-modal")).click();

	}

}
