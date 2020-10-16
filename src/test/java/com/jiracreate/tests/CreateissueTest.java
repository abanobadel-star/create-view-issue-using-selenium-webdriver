package com.jiracreate.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	 public void createissue(String Epicname,String summary ,String component,String description) throws InterruptedException
	 {
		 createobject=new Createpage(driver);
		 createobject.createepic(Epicname, summary, component, description);
		 Thread.sleep(5000);
	     createobject.viewissue();
		 String actualresult1=createobject.summarytxt.getText();
		 String expectedresult1="as a user i want to login to can buy product";
		 SoftAssert softassert=new SoftAssert();
		 softassert.assertEquals(actualresult1, expectedresult1);
		 String actualresult2=createobject.assertepicname.getText();
		 String expectedresult2="first epic";
		 softassert.assertEquals(actualresult2, expectedresult2);
		 softassert.assertAll();
		 
	 }

}
