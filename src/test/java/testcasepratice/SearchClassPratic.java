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

public class SearchClassPratic {
	
	WebDriver driver;//this is global variable;
	@BeforeMethod
	
	public void setup() {
		
		String Browser = "Chrome";
		if(Browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(Browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(Browser.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("The Browser is Not Valid..Thankyou....!!!");
		}
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	@AfterMethod
	public void Quit() {
		driver.quit();
	}
	//tc 1
	@Test
	public void Searchthedefinedproductes() {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hp");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String Text = driver.findElement(By.xpath("//a[text()='HP LP3065']")).getText();
		Assert.assertTrue(Text.contains("HP LP3065"));
		
	}
	
	//tc2
	@Test
	public void SearchTheUndrfinedProductes() {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("bike");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String Text= driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).getText();
		Assert.assertTrue(Text.contains("There is no product that matches"));
	}

}
