package home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterusername(String username) {
		driver.findElement(By.id("input-email")).sendKeys(username);
	}
	public void enterpassword(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}
	public void clickonsubmit() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	public void Warningtext() {
	String Text=driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).getText();
	Assert.assertTrue(Text.contains("Warning: No match for E-Mail"));
	}

}
