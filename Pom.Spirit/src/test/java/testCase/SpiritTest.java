package testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageFactory.Common;
import pages.HomePage;

public class SpiritTest {

	@Test
	public void mPage() throws InterruptedException {
		
		
		ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReport\\Report.html");
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(htmlReport);
		ExtentTest test= extent.createTest("Test1");
		
		
		Common co = new Common();
		WebDriver driver = co.lunchBrowser();
		test.log(Status.PASS, "Successfully launch browser");
		co.navigateUrl(driver);
		test.log(Status.PASS, "Successfully navigate url");
		HomePage hp = new HomePage(driver);

		co.clickOb(hp.signin, "SignIN");
		Thread.sleep(3000);
		co.clickOb(hp.signup, "SignUP");
		extent.flush();
		co.tearDown(driver);
	}

}
