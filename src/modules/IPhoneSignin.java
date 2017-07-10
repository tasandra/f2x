package modules;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.HomePage;

public class IPhoneSignin extends HomePage {
	private Duration second = Duration.ofSeconds(2);

	public IPhoneSignin(WebDriver driver) {
		super(driver);
	}

	public void isignin(String username, String password) {
		// driver.findElement(By.xpath("//*[@id='f2x-header']//button[3]")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='f2x-header']//button[3]"))).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.cssSelector(".f2x-signin-btn>button")).click();
	}

	public WebElement iPhoneGetAvatar() {
		WebElement element = driver.findElement(By.cssSelector(".f2x-logo-menu-mobile"));

		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.pause(second);
		actions.click().perform();

		return wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".f2x-mobile-menu-box-user")));
	}
	
	public String icheckError(String username, String password) {
		isignin(username, password);
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//form/div[1]/div[2]/div/div[3]")))
				.getText();
	}

	public void iPhonesignout() {
		driver.findElement(By.cssSelector(".f2x-mobile-menu-box-user")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".signOut > u:nth-child(1)"))).click();
	}
}
