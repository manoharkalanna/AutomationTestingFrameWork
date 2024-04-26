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

import base.BaseClass;

public class SearchTest extends BaseClass {
	
	public SearchTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		
		driver= IntilizationBrowseAndlaunchapplication();
			
		
		
	}
	@AfterMethod
	public void Quit() {
		driver.quit();
	}

	//TC1
	@Test
	
	public void SearchWithValidKeyWords() {
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("HP");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	    String text = driver.findElement(By.xpath("//a[text()='HP LP3065']")).getText();
	    Assert.assertTrue(text.contains("HP"));
	
	}
	
	//TC2
	@Test
	public void SearchWithInvalidKey() {
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("ktm bike");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String text = driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).getText();
		Assert.assertTrue(text.contains("There is no product"));
	}
	
	//TC3
	@Test(dependsOnMethods="SearchWithInvalidKey")//here we this becose if TC2 will not run then Tc3 will skip so we us
	                                              // this method;
	
	public void SearchWithOutAnyKey() {
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String text = driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).getText();
		Assert.assertTrue(text.contains("There is no product"));
	}
}
