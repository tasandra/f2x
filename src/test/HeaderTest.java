package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import pages.HomePage;

public class HeaderTest extends BaseTest {
	public HomePage home;

	@Before
	public void setUp() throws Exception {
		home = new HomePage(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		home.load();
		// logo test
		WebElement logo = driver.findElement(By.cssSelector(".f2x-logo-img>a>img"));
		Dimension logoSize = logo.getSize();
		
		assertEquals(37, logoSize.height);
		assertTrue(45 == logoSize.width);
		
		Point logoLocation = logo.getLocation();
		// only need Y to test that it is at the top of the page
		int topSection = 71;
		assertTrue(logoLocation.y + logoSize.height < topSection);
		
		// join test
		WebElement join = driver.findElement(By.cssSelector(".f2x-buttons-geo"));
		Dimension joinSize = join.getSize();
		
		assertEquals(71, joinSize.height);
		assertEquals(100, joinSize.width);
		
		Point joinLocation = join.getLocation();
		assertTrue(joinLocation.y + joinSize.height <= topSection);
				
	}

}
