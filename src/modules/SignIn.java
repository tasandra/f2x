package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.HomePage;

public class SignIn extends HomePage {

	public SignIn(WebDriver driver) {
		super(driver);
	}

	public void signin(String username, String password) {
		driver.findElement(By.cssSelector(".f2x-header-logbox-btn>button")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.cssSelector(".f2x-signin-btn>button")).click();
	}

	public WebElement getAvatar() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".icon")));

	}

	public String checkError(String username, String password) {
		signin(username, password);
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//form/div[1]/div[2]/div/div[3]")))
				.getText();
	}

	public void signout() {
		driver.findElement(By.className("user")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ul[@class='f2x-hr montse_light']/li[2]")))
				.click();

	}
}
