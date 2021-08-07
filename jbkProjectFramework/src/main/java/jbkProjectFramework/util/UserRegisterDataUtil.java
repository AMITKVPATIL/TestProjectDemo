package jbkProjectFramework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class UserRegisterDataUtil {

	public static String[][] DataDrivenUserRegister()
	{
		File src;
		String [][]data=null;;
	try {
		
		
		
		src=new File("D:\\java jdk\\jbkProjectFramework\\src\\main\\java\\jbkProjectFramework\\testData\\userData.xls");

		FileInputStream fis=new FileInputStream(src);

		Workbook wb=Workbook.getWorkbook(fis);
		Sheet sheet=wb.getSheet("Sheet1");


		int rowsize=sheet.getRows();
		System.out.println(rowsize);

		int colsize=sheet.getColumns();
		System.out.println(colsize);

		data=new String[rowsize][colsize];
		for(int i=0;i<rowsize;i++)
		{

			for(int j=0;j<colsize;j++)
			{

				Cell cell=sheet.getCell(j, i);
				data[i][j]=cell.getContents();

			}

		}

		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[0].length;j++)
			{

				System.out.print(data[i][j]+"  ");

			}
			System.out.println();

		}


	} catch (IOException | BiffException e) {

		e.printStackTrace();
	}
	return data;

}}

