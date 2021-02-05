package pageFactory;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common {

	public WebDriver lunchBrowser() {
		WebDriver driver = null;
		String browser = null;
		try {

			Properties prop = new Properties();
			prop.load(new FileInputStream("cof.properties"));

			browser = prop.getProperty("Browser");

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe");
				driver = new EdgeDriver();

			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();

			}

			System.out.println("Successfully lunch browser  " + browser);
		} catch (Exception e) {
			System.out.println("Failure to lunch browser  " + browser);
		}
		return driver;

	}

	public void navigateUrl(WebDriver driver) {

		String environment = null;

		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("cof.properties"));

			environment = prop.getProperty("Environment");
			String url = null;
			if (environment.equalsIgnoreCase("QA")) {
				url = prop.getProperty("QA_Url");

			} else if (environment.equalsIgnoreCase("Dev")) {
				url = prop.getProperty("Dev_Url");
			}

			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			System.out.println("Seccessfully navigate url  " + environment);

		} catch (Exception e) {
			System.out.println("Failure to navigate url " + environment);
		}
	}

	public void clickOb(WebElement ele,String msg) {
		try {
			ele.click();
			System.out.println("Successfully Click " + msg);

		} catch (Exception e) {
			System.out.println("Failure Click " + msg);
		}
	}

	public void enterText(WebElement ele, String input, String msg) {

		try {
			ele.sendKeys(input);
			System.out.println("Successfully enter Text  " + msg);

		} catch (Exception e) {
			System.out.println("Failure to EnterText  " + msg);

		}
	}

	public void tearDown(WebDriver driver) {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
