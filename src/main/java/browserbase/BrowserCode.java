package browserbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BrowserCode  {
	
     WebDriver driver;
	 Properties prop;
	
	   public BrowserCode()throws Exception {
		String path ="C:\\Users\\Dell\\eclipse-workspace\\MavenFrameWorkSelenium\\TestData\\config.properties";
	    FileInputStream fis = new FileInputStream(path);
		prop = new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("Browser")); 
	}
	
	
	
	public WebDriver CallingBrowserAndLaunchingApplication() {
		String Browser = prop.getProperty("Browser");
		
		if(Browser.equals("Chrome")) {
			driver= new ChromeDriver();
		}
		else if(Browser.equals("edge")) {
			driver= new EdgeDriver();
		}
		else if(Browser.equals("Firefox")) {
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("Browsr is not found");
		}
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
	}
	

}
