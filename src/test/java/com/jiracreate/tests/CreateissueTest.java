package com.jiracreate.tests;

import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jiracreate.pages.Createpage;

import Data.ExcelReader;

public class CreateissueTest extends TestBase {

	public CreateissueTest() throws IOException {
		super();
	}
	 Createpage createobject;
	 
	 @DataProvider(name="userdata") //data provider with link between script and execl sheet
		public Object[][] data_for_register() throws IOException  //method to pass data to testcase
		{
			ExcelReader excelreader=new ExcelReader(); //object from class execl reader
			return excelreader.getExcelData(); //to get and return  data from excel sheet

		}
	 @Test(priority=1,dataProvider="userdata")
	 public void createissue(String Epicname,String summary ,String component,String description)
	 {
		 createobject=new Createpage(driver);
		 createobject.createepic(Epicname, summary, component, description);
	 }

}
