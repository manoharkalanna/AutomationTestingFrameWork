package home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {//this is constructor;
		
		this.driver=driver;
	}
	
		public void clickonmyaccount() {
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
		}
		public void clickonlogin() {
			driver.findElement(By.xpath("//a[text()='Login']")).click();
		}
		
		//here we have to Send this method to "LoginFromBase";By creating Obj of this class along with "driver" in "LoginFromBase"
		//here in this class we don't have driver so we call the driver from"LoginFRomBase"claa which already have driver
		// for calling driver we have to create "CONSTRUCTOR"of this class;
		// after calling driver from "LoginFromBase" add WebDriver to it  =WebDriver driver; add this driver to local
		//variable driver --> this.driver=driver;(from Right to left);
	

}
