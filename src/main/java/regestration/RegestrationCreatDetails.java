package regestration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegestrationCreatDetails {
	
    WebDriver driver;
	public RegestrationCreatDetails(WebDriver driver){
		this.driver=driver;
	}
	public void enterfirstname(String firstname) {
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(firstname);
	}
	public void entersecondname(String lastname) {
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(lastname);
	}
	public void enteremail(String email) {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
	}
	public void enterphonenum(String phone) {
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(phone);
	}
	public void enterpassword(String password) {
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
	}
	public void enterconfirmpassword(String conformpassword) {
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(conformpassword);
	}
	public void clickonPrivacyPolicy() {
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	}
	public void clickoncontinue() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	public void failtext() {
	String Text=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	Assert.assertTrue(Text.contains("Warning: You must agree to the Privacy Policy!"));
	}
}
