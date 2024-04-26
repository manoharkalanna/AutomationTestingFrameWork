package text;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TextVerify {
   WebDriver driver;
  public TextVerify(WebDriver driver) {
	this.driver=driver;
}
	
	public void LoginTextVerify() {
		String Text=driver.findElement(By.xpath("//a[text()='Edit your account information']")).getText();
		Assert.assertTrue(Text.contains("Edit your account"));
	}

}
