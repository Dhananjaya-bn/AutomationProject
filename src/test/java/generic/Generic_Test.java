package generic;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
//import org.testng.reporters.HtmlHelper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Generic_Test implements Auto_Const {

	public WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	
	Logger log=Logger.getLogger(Generic_Test.class);

@BeforeSuite
public void setUp()
{
	htmlReporter=new ExtentHtmlReporter("./Photos/"+new Date().toString().replace(":","-")+"E.html");
	reports=new ExtentReports();
	reports.attachReporter(htmlReporter);
}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openAppln(@Optional("chrome") String browser)
	{
	if(browser.equals("firefox"))
	{
		log.info("starting browser");
		driver=BrowserFactory.getBrowser("firefox");
		driver.get(FileManager.getAppUrl());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	else if(browser.equals("chrome"))
	{
		driver=BrowserFactory.getBrowser("chrome");
		driver.get(FileManager.getAppUrl());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
		
	}
	@AfterMethod
	public void closeAppln(ITestResult res)throws IOException
	{
		System.out.println(res.getStatus());
		if(ITestResult.FAILURE==res.getStatus())
		{
			String testName = res.getName();
			test.fail("test script failed ", MediaEntityBuilder.createScreenCaptureFromPath(new ScreenShot().getPhoto(driver,testName)).build());
		}
		test.assignAuthor("dhananjaya");
		test.assignCategory("GUI Automation");
		test.assignDevice("laptop");
		reports.setSystemInfo("windows", "10");
		/*
		 * test.fatal("blocker"); test.warning(""); test.error(""); test.skip("");
		 */
		driver.quit();
		log.info("closing browser");
	}
	@AfterSuite
	public void tearDown()
	{
		reports.flush();
		
	}
}
