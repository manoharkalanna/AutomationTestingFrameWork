package testcases;

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

public class RegestrationTest {
	
	WebDriver driver;// this is the global variable
	
	@BeforeMethod
	
	public void setup() {
		
		String Browser = "chrome";
		
		if(Browser.equals("chrome")) {
			driver= new ChromeDriver();
			
		}
		else if(Browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if(Browser.equals("edge")) {
			driver= new EdgeDriver();
		}
		else {
			System.out.println("Browser is not defined thank you.....!");
		}
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
	}
	
	@AfterMethod
	
	public void Quit() {
		driver.quit();
		
	}
	
	//TC1
	
	@Test
	
	public void RegestrationWithAllNeededDetails() {
	
	driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("sankarappa");
	driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("kalanna");
	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("sankarappakalanna996388@gmail.com");
	driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("997788668");
	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234567");
	driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234567");
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	String logintext =driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
	Assert.assertTrue(logintext.contains("Your Account"));
	
		
	}
	//tc2
	@Test
	public void RegisterWithOutAcceptingChechkBox() {
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("ravi");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("kalanna");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("kalannaravi3322@gmail.con");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9977886662");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234567");
		//driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String loginerror = driver.findElement(By.xpath("//div[text()='Warning: You must agree to the Privacy Policy!']")).getText();
		Assert.assertTrue(loginerror.contains("You must agree to the Privacy Policy!"));
		
	}
	
	
}
