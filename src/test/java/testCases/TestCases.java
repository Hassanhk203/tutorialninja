package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LandingPage;

public class TestCases extends LandingPage {

	@Test
	public void registrationTest() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Samir");
		driver.findElement(By.id("input-lastname")).sendKeys("Sami");
		driver.findElement(By.id("input-email")).sendKeys("Samir6652073@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("123 234 2345");
		driver.findElement(By.id("input-password")).sendKeys("Samir123");
		driver.findElement(By.id("input-confirm")).sendKeys("Samir123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		String expected = "Your Account Has Been Created!";
		String actual = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(expected, actual);
	}

	@Test(dependsOnMethods = { "registrationTest" })
	public void logoutTest() {
		driver.findElement(By.linkText("Logout")).click();
		String expectedlogoutmessag = "You have been logged off your account. It is now safe to leave the computer.";
		String actuallogoutmessage = driver.findElement(By.xpath("//div[@id ='content']/p[1]")).getText();
		Assert.assertEquals(expectedlogoutmessag, actuallogoutmessage);

	}

	@Test(dependsOnMethods = { "logoutTest" })
	public void loginTest() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

	}
	@Test(dependsOnMethods = { "loginTest" })
	public void searchTest() {
		
		driver.findElement(By.cssSelector(".form-control.input-lg")).sendKeys("iphone");
		driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']")).click();
		driver.findElement(By.xpath("//div[@class = 'button-group']/child ::button[1]/i")).click();

	}


}
