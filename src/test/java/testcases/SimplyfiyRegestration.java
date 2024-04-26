package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class SimplyfiyRegestration extends BaseClass{
	
	public SimplyfiyRegestration() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
	@BeforeMethod
	public void setup(){
		
		driver= IntilizationBrowseAndlaunchapplication();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
	}
	
	@Test
	
	public void simpleRegestration() {
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("lucky");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("L");
		driver.findElement(By.id("input-email")).sendKeys("luckyL123@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("hello123");
		driver.findElement(By.id("input-confirm")).sendKeys("hello123");
	}

}
