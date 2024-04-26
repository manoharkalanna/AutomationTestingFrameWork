package text;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegestrationSuccessText {
	
	WebDriver driver;
	public RegestrationSuccessText(WebDriver driver) {
		this.driver=driver;
	}
	
	public void Regestrationtext() {
	String Text=driver.findElement(By.xpath("//p[text()='Congratulations! Your new account has been successfully created!']")).getText();
	Assert.assertTrue(Text.contains("Congratulations! Your new account"));
	}

}
