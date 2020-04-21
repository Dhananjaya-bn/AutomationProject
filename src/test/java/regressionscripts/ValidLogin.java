package regressionscripts;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.Generic_Test;
import pom.Actitime_Login_Page;

public class ValidLogin extends Generic_Test{
	@Test
	public void validLogin()
	{
		String username = Excel.getData("LoginCredentials", 1, 0);
		String password = Excel.getData("LoginCredentials", 1, 1);
		String etitle = Excel.getData("LoginCredentials", 1, 2);
		test=reports.createTest("ValidLogin","user verify acti time login");
		Actitime_Login_Page lp=new Actitime_Login_Page(driver);
		lp.setUsername(username);
		test.pass("user entered username");
		lp.setPassword(password);
		test.pass("user entered password");

		lp.clickLogin();
		test.pass("user click login");

        lp.verifyTitle("Enter", 5);
		test.pass("user entered data");

        String atitle = driver.getTitle();
        
       Assert.assertEquals(atitle, etitle);
        //Assert.fail();

	}

}
