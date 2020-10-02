package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	 
	static FileInputStream file=null; //make file static to access by all function
	 
	public FileInputStream getFileInputStream() throws FileNotFoundException
	{
		String filepath= System.getProperty("user.dir")+"\\src\\test\\java\\Data\\user data.xlsx"; //to get path of excel sheet
		File filesrc= new File(filepath);  
		file=new FileInputStream(filesrc); 
		return file;
	}
	public Object [][] getExcelData() throws IOException //function to get data from excel
	{
		file=getFileInputStream();
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheetAt(0); //to get first sheet from excel if there more than sheet
		int Totalnumberofrows=(sheet.getLastRowNum()+1); //to get number of rows to excel sheet 
		int Totalnumberofcolums=4; //number of paramteres
		String[][] arrayExceldata= new String[Totalnumberofrows][Totalnumberofcolums];
		for (int i = 0; i <Totalnumberofrows; i++) { //this loop to loop all paramter in execl sheet by row
			
			for (int j = 0; j < Totalnumberofcolums; j++) { //this loop to loop all paramter in excel sheet by coloum
				XSSFRow row= sheet.getRow(i);
				arrayExceldata [i][j]=row.getCell(j).toString();
				
			}
			
		}
		
		workbook.close(); //to close work book
		return arrayExceldata;
	}

}
