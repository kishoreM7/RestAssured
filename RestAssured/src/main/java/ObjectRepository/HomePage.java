package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement loginBtn ;
	

}
