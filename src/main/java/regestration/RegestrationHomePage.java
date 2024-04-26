package regestration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegestrationHomePage {
	
	WebDriver driver;
	 public RegestrationHomePage(WebDriver driver){
		this.driver=driver;
	}
	public void accountclick() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
	}
	public void regesterclick() {
		driver.findElement(By.xpath("//a[text()='Register']")).click();
	}

}
