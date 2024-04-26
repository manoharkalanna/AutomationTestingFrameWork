package testcasepratice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import browserbase.BrowserCode;
import regestration.RegestrationCreatDetails;
import regestration.RegestrationHomePage;
import text.RegestrationSuccessText;


public class RegisterFromBase extends BrowserCode {
	
	RegisterFromBase()throws Throwable{
		
	}
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver= CallingBrowserAndLaunchingApplication();
		RegestrationHomePage RHP = new RegestrationHomePage(driver);
		RHP.accountclick();
		RHP.regesterclick();
	}
	@AfterMethod
	public void Quitbrowser() {
		driver.quit();
	}
	
	//TC1
	@Test
	public void RegesterSuccess() {
		
		RegestrationCreatDetails RCD = new RegestrationCreatDetails(driver);
		RCD.enterfirstname("bindu");
		RCD.entersecondname("Reddy");
		RCD.enteremail("bindureddy@gmail.com");
		RCD.enterphonenum("9900447788");
		RCD.enterpassword("1234567890");
		RCD.enterconfirmpassword("1234567890");
		RCD.clickonPrivacyPolicy();
		RCD.clickoncontinue();
		RegestrationSuccessText RST = new RegestrationSuccessText(driver);
		RST.Regestrationtext();
		
	}
	//TC2
	@Test
	public void RegesterFail() {
		RegestrationCreatDetails RCD = new RegestrationCreatDetails(driver);
		RCD.enterfirstname("balu");
		RCD.entersecondname("BALU");
		RCD.enteremail("balubb@gmail.com");
		RCD.enterphonenum("9900887766");
		RCD.enterpassword("1234567890");
		RCD.enterconfirmpassword("1234567890");
		RCD.clickoncontinue();
		RCD.failtext();
	}
	//TC3
	@Test
	public void RegestrationFailWitoutDetails() {
		RegestrationCreatDetails RCD = new RegestrationCreatDetails(driver);
		RCD.clickoncontinue();
	}

}
