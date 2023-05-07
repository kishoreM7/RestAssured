package endToEnd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class EtoETest {
	@Test
	public void etoETest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8084/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		
		

	}

}
