package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.HomePage;

public class ForgotPass extends HomePage {

	public ForgotPass(WebDriver driver) {
		super(driver);
	}

	public void forgot(String email) {
		driver.findElement(By.cssSelector(".f2x-header-logbox-btn>button")).click();
		driver.findElement(By.cssSelector(".f2x-input-text-right")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(email);
		driver.findElement(By.xpath("//div[4]/button")).click();

	}

	public String getEmailReset() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.className("f2x-modal-title")))
				.getText();
	}

	public String getErrorMessage(String email) {
		forgot(email);
		return wait.until((ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error-msg"))))
				.getText();
	}

	public String getValidEmail(String email) {
		forgot(email);
		return wait
				.until((ExpectedConditions
						.presenceOfElementLocated(By.cssSelector(".f2x-modal-reset2-text"))))
				.getText();
		
	}
	
	
}

