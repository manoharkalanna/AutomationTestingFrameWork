package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	WebDriver driver;
	//here we are reading data from the config.properties file so the following steps has to follow;
	Properties prop;
	public BaseClass() throws Exception{

		String proppath="C:\\Users\\Dell\\eclipse-workspace\\MavenFrameWorkSelenium\\TestData\\config.properties";
		FileInputStream fis = new FileInputStream(proppath);// this like webdriver abc = new CD;
		prop = new Properties();
		prop.load(fis);//this is like driver.findelement();
		System.out.println(prop.getProperty("Broswer"));
		
	}
	
	
	public WebDriver IntilizationBrowseAndlaunchapplication() {
		
		//String Browser = "Chrome";//this line use when thers no need of perticular broswer;
		String Browser = prop.getProperty("Browser");
		
		if(Browser.equals("Chrome")) {
			driver= new ChromeDriver();
		}
		else if(Browser.equals("fire fox")) {
			driver= new FirefoxDriver();
		}
		else if(Browser.equals("edge")) {
			driver= new EdgeDriver();
		}
		else {
			System.out.println("unable to find the browser,thank you....!");
		}
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		
		return driver;
	}
	

}
