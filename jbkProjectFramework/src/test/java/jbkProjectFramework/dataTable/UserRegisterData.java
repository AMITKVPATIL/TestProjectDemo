package jbkProjectFramework.dataTable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class UserRegisterData {
@Test(dataProvider="userRegisterData")
public void verifyuser(int a,String s)
{
	System.out.println(a+"  "+s);

}
@DataProvider
public Object[][] userRegisterData()
{
	File src=new File("D:\\java jdk\\jbkProjectFramework\\src\\main\\java\\jbkProjectFramework\\testData\\userData.xls");
	
	try {
		FileInputStream fis=new FileInputStream(src);
		
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet sheet=wb.getSheet("Sheet1");
		int rowsize=sheet.getRows();
		
		System.out.println(rowsize);

		int colsize=sheet.getColumns();
		System.out.println(colsize);
		
		for(int i=0;i<rowsize;i++)
		{
			for(int j=0;j<colsize;j++)
			{
				Cell cell=sheet.getCell(j, i);
				//System.out.print(cell.getContents()+"   ");
				
				String name=cell.getContents();
				return new Object[][] {
					new Object[] {1,name},
					
					
					
					
					
				};

				
			}
			System.out.println();
			
		}
	
	
	
	
	} catch (IOException | BiffException e) {

		e.printStackTrace();
	}
	
	
	return new Object[][] {
		//new Object[] {1,"a"},
		//new Object[] {2,"b"}
		
		
		
		
	};

	
	
	
	
	
	

}
}
