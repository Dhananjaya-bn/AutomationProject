package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class ScreenShot {

	public String getPhoto(WebDriver driver,String testName) 
	{
		//String path="C://photos/";
		Date d=new Date();
		String d1 = d.toString();
		String date = d1.replace(":", "-");
		
		final String path=System.getProperty("user.dir")+"/reports/"+date+testName+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(path+date+".png");
		try{
		FileHandler.copy(src, dst);
		}
		catch(Exception e)
		{
			Reporter.log("failed to take screenshot",true);
		}
		return path;
	}
}
