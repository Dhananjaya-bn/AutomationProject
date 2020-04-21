package generic;

import java.io.FileInputStream;
import java.util.Properties;

public class FileManager {

	public static String getAppUrl()
	{
		String url=null;
		try {
			FileInputStream fis=new FileInputStream("./Configuration.Properties");
			
			Properties pro=new Properties();
			pro.load(fis);
			 url = pro.getProperty("qaTest1");
		} catch (Exception e) {
			
		}
		return url;
	}
}
