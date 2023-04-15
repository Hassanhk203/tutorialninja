package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class LandingPage {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
	}
	
//	@AfterClass
//	public void teardown() {
//		driver.close();
//	}

}
