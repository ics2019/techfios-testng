package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewDepositTest {

	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://techfios.com/test/billing/?ng=login/");
	}
	@Test
	public void userShouldBeAbleToAddNewDeposit() {
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("techfiosdemo@gmail.com");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
	}
	
	@AfterMethod
	public void closeEveryThing() {
		driver.close();
		driver.quit();
	}
	
}
