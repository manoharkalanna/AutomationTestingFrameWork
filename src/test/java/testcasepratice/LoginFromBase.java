package testcasepratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import browserbase.BrowserCode;
import home.HomePage;
import home.LoginPage;
import text.TextVerify;

public class LoginFromBase extends BrowserCode {// here we take the code from BrowserCode & build Constructor of LoginFromBase;
	
	LoginFromBase() throws Exception {
		super();
	}
	WebDriver driver;
	
	
	
	@BeforeMethod
	public void setup() {
		
		driver= CallingBrowserAndLaunchingApplication();//this method present in BrowserCode class;
		
		HomePage HP = new HomePage(driver);//this we call from "LoginHome"class along with calling we have to get driver;
		HP.clickonmyaccount();
		HP.clickonlogin();
	}
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	//TC1
	@Test
	public void login() {
		
		LoginPage LP = new LoginPage(driver);
		LP.enterusername("manojkalanna@gmail.com");
		LP.enterpassword("1234567890");
		LP.clickonsubmit();
		TextVerify TV = new TextVerify(driver);
		TV.LoginTextVerify();
	}
	//TC2
	@Test
	public void LoginFail() {
		LoginPage LP = new LoginPage(driver);
		LP.enterusername("manojkalanna@gmail.com");
		LP.enterpassword("12345");
		LP.clickonsubmit();
		LP.Warningtext();
	}
	//TC3
	@Test
	public void LoginFailWithEmail() {
		LoginPage LP = new LoginPage(driver);
		LP.enterusername("manojkalannna@gmail.com");
		LP.enterpassword("1234567890");
		LP.clickonsubmit();
		LP.Warningtext();
	}
	//TC4
	@Test
	public void Nodetails() {
		LoginPage LP = new LoginPage(driver);
		LP.clickonsubmit();
		LP.Warningtext();
	}

}
