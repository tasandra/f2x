package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String pageUrl = "http://jeekjee.net:8001/";

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public void load() {
		driver.get(pageUrl);
	}
	
	public void closeModal(){
		driver.findElement(By.className("close-modal")).click();
		
	}
	
}
