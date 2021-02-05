package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//*[text()='Sign-In'])[2]")
	public WebElement signin;
	
	@FindBy(xpath="(//*[text()='Sign Up Now'])[2]")
	public WebElement signup;
	
}

