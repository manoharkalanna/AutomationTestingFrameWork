package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
   @Test
	public void LoginWithValidUserNameAndValidPassword() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("kallanagarimanohar00@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		String actualltext =driver.findElement(By.partialLinkText("Edit your account")).getText();
		String Exeptext = "Edit your account information"; // here actual text & Exep Text should be same;
		// here we use assertion to validate the actual & exep text, they are two types;
		// 1 hard assertion 2 soft assertion , 
		// we sue more hard assertion coz if there is an any error then it stop further step it wont execute.but soft will execute;
		
		Assert.assertEquals(actualltext, Exeptext);
		
		driver.quit();
		
	}
   //tc2
   @Test
   public void loginWithValidUsernameandInvalidPassword() {
	   
	   WebDriver driver = new ChromeDriver();
	   driver.get("https://tutorialsninja.com/demo/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   
	   driver.findElement(By.xpath("//span[text()='My Account']")).click();
	   driver.findElement(By.xpath("//a[text()='Login']")).click();
	   driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("kallanagarimanohar00@gmail.com");
	   driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234509876");
	   driver.findElement(By.xpath("//input[@value='Login']")).click();
	   
	   String ActualText = driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).getText();
	   String ExepText = "Warning: No match for E-Mail Address and/or Password.";
	   Assert.assertEquals(ActualText, ExepText);
	   driver.quit();
 
	   
   }
   //TC3
   @Test
   public void Loninwithinvalidusernameandvalidpassword() {
	   
	   WebDriver driver = new ChromeDriver();
	   driver.get("https://tutorialsninja.com/demo/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   
	   driver.findElement(By.xpath("//span[text()='My Account']")).click();
	   driver.findElement(By.xpath("//a[text()='Login']")).click();
	   driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("kalanagarimanohar00@gmail.com");
	   driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234567890");
	   driver.findElement(By.xpath("//input[@value='Login']")).click();
	   
	   String ActualText = driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).getText();
	   String ExepText = "Warning: No match for E-Mail Address and/or Password.";
	   Assert.assertEquals(ActualText, ExepText);
	   driver.quit();
	   
   }
   //tc4
   @Test
   public void loginwithinvalidusernameandinvalidpassword() {
	   
	   WebDriver driver = new ChromeDriver();
	   driver.get("https://tutorialsninja.com/demo/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   
	   driver.findElement(By.xpath("//span[text()='My Account']")).click();
	   driver.findElement(By.xpath("//a[text()='Login']")).click();
	   driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("kalanagarimanohar00@gmail.com");
	   driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234509876");
	   driver.findElement(By.xpath("//input[@value='Login']")).click();
	   
	   String ActualText = driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).getText();
	   String ExepText = "Warning: No match for E-Mail Address and/or Password.";
	   Assert.assertEquals(ActualText, ExepText);
	   driver.quit();
	   
   }

}
