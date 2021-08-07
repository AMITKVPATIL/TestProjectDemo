package jbkProjectFramework.testPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import jbkProjectFramework.util.UserRegisterDataUtil;
import jbkProjectFramework.util.UtilTest;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class UserRegisterDataDrivenExcel {
	WebDriver driver;
	Properties prop=new Properties();
	FileInputStream fis;
	@Test
	public void TC_01_UserRegisterDataDriven()
	{
		try {
			fis=new FileInputStream("D:\\java jdk\\jbkProjectFramework\\src\\main\\java\\jbkProjectFramework\\config\\locatorpath.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		String [][]data1=UserRegisterDataUtil.DataDrivenUserRegister();
		for(int i=0;i<data1.length;i++)
		{
			for(int j=0;j<data1[i].length;j++)
			{

				System.out.print(data1[i][j]+"  ");

			}
			System.out.println();


		}
		driver=UtilTest.urlOpen(driver, prop.getProperty("browser"), prop.getProperty("url"));
		UtilTest.sendKeysValue(driver, "id", prop.getProperty("emailid"), prop.getProperty("validemail"));
		UtilTest.sendKeysValue(driver, "id", prop.getProperty("passid"), prop.getProperty("validpass"));
		UtilTest.clickElement(driver, "xpath", prop.getProperty("signinxpath"));
		String expalerttext="User Added Successfully. You can not see added user.";
		String actalerttext;
		for(int i=1;i<data1.length;i++)
		{
			UtilTest.clickElement(driver, "xpath", prop.getProperty("userclick"));//user click
			UtilTest.clickElement(driver, "xpath", prop.getProperty("adduserclick"));//AddUser click


			String username1=data1[i][0];
			String mobile1=data1[i][1];
			String email1=data1[i][2];
			String course1=data1[i][3];
			String gender1=data1[i][4];
			String state1=data1[i][5];
			String password1=data1[i][6];


			UtilTest.sendKeysValue(driver, "id", "username", username1);
			UtilTest.sendKeysValue(driver, "id", "mobile", mobile1);
			UtilTest.sendKeysValue(driver, "id", "email", email1);
			UtilTest.sendKeysValue(driver, "id", "course", course1);

			if(gender1.equalsIgnoreCase("male"))
			{
				UtilTest.clickElement(driver, "id", "Male");
			}
			else if(gender1.equalsIgnoreCase("female"))
			{
				UtilTest.clickElement(driver, "id", "Female");	
			}


			Select list=new Select(driver.findElement(By.xpath(prop.getProperty("selectstate"))));
			if(state1.equalsIgnoreCase("maharashtra"))
			{
				list.selectByVisibleText("Maharashtra");
			}else if(state1.equalsIgnoreCase("delhi"))
			{
				list.selectByVisibleText("Delhi");
			}else if(state1.equalsIgnoreCase("hp"))
			{
				list.selectByVisibleText("HP");
			}else if(state1.equalsIgnoreCase("panjab"))
			{
				list.selectByVisibleText("Punjab");
			}

			UtilTest.sendKeysValue(driver, "id", "password", password1);
			UtilTest.clickElement(driver, "id", "submit");
			driver.switchTo().alert();
			actalerttext=driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();

			Assert.assertEquals(actalerttext, expalerttext);

		}

driver.close();
	}
}