package jbkProjectFramework.testPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import jbkProjectFramework.dataTable.LoginFieldData;
import jbkProjectFramework.util.UtilTest;

public class VerifyLoginPage {
	WebDriver driver;

	Properties prop=new Properties();
	FileInputStream fis;

	@Test(dataProvider = "loginDataTest", dataProviderClass = LoginFieldData.class)
	public void TC_01_verifyLoginField(String tc, String stage, String enteremail, String enterpass,
			String expemailerr, String exppasserr) {
		try {
			fis=new FileInputStream("D:\\java jdk\\jbkProjectFramework\\src\\main\\java\\jbkProjectFramework\\config\\locatorpath.properties");
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println(tc+" TestCase run");

		driver = UtilTest.urlOpen(driver, prop.getProperty("browser"),
				prop.getProperty("url"));

		UtilTest.sendKeysValue(driver, "id",prop.getProperty("emailid"), enteremail);
		UtilTest.sendKeysValue(driver, "id", prop.getProperty("passid"), enterpass);

		UtilTest.clickElement(driver, "xpath", prop.getProperty("signinxpath"));

		if(stage.equals("bothcorrect"))
		{
			String expTitle="JavaByKiran | Dashboard";
			String actTitle=driver.getTitle();


			driver.navigate().back();
			driver.close();
			Assert.assertEquals(actTitle, expTitle);

		}else
		{
			String actemailerr=UtilTest.getElementTitle(driver, "id","email_error");
			String actpasserr=UtilTest.getElementTitle(driver, "id", "password_error");

			driver.close();
			Assert.assertEquals(actemailerr, expemailerr);
			Assert.assertEquals(actpasserr, exppasserr);
		}


	}
}
