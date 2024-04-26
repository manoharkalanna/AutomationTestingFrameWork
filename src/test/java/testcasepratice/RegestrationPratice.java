package testcasepratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegestrationPratice {
	
	WebDriver driver;
	@BeforeMethod
	
	public void setup() {
		
		String Browser = "Chrome";
		
		if(Browser.equals("Chrome")) {
			
			driver= new ChromeDriver();
			
		}
		else if(Browser.equals("Edge")) {
			driver= new EdgeDriver();
			
		}
		else if (Browser.equals("Firefox")) {
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("Browser is not found....thankyou!!!!!");
		}
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
			
	}
	@AfterMethod
	public void QuitBrowser() {
		driver.quit();
	}
	//tc1
	@Test
	
	public void RegestrationWithAllDetails() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("manoj");
		driver.findElement(By.id("input-lastname")).sendKeys("kalanna");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("manojkalanna010@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9963881234");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	  String ActualText =driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
	  String ExpectedText="Your Account Has Been Created!";
	  Assert.assertEquals(ActualText, ExpectedText);
	}
	
	//tc2
	@Test
	public void RegestrationWithOutAntDetails() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String ActualText =driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(ActualText.contains("You must agree to the Privacy Policy!"));
		
	}
	//tc3
	
	@Test
	public void RegestrationWithoutAcceptingCheckBox() {
		driver.findElement(By.id("input-firstname")).sendKeys("manoj");
		driver.findElement(By.id("input-lastname")).sendKeys("kalanna");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("manojkalanna019@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9963881234");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String ActualText =driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(ActualText.contains("You must agree to the Privacy Policy!"));
		
		
		
	}
}
