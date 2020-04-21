package generic;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory implements Auto_Const {

	private static Map<String,WebDriver> drivers=new HashMap<String,WebDriver>();
	public static WebDriver getBrowser(String browserName)
	{
		WebDriver driver=null;
		switch (browserName) {
		case "firefox":
			driver=drivers.get("firefox");
			if(driver==null)
				System.setProperty(firefox_key, firefox_value);
			driver=new FirefoxDriver();
			drivers.put("firefox", driver);
			break;
			
		case "chrome":
			driver=drivers.get("chrome");
			if(driver==null)
				System.setProperty(chrome_key,chrome_value);
			driver=new ChromeDriver();
			drivers.put("chrome", driver);
			
		default:
			System.out.println("no such browser");
			break;
		}
		return driver;
		
	}
	
}
