package jira.create;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Data.ExcelReader;



public class Create_issue {
	static String chromepath =System.getProperty("user.dir")+"\\resources\\chromedriver.exe"; //to get path for chrome driver
	static  ChromeDriver driver;     // make driver static to allow to all function access it
	@DataProvider(name="userdata") //data provider with link between script and execl sheet
	public Object[][] data_for_epic() throws IOException
	{
		ExcelReader excelreader=new ExcelReader(); //object from class execl reader
		return excelreader.getExcelData(); //to get and return  data from excel sheet
		
	}
	 @BeforeTest 
	 public void initalization() {    //this intialization before any test
	
		 System.setProperty("webdriver.chrome.driver", chromepath); //to set driver 
		  driver=new ChromeDriver(); // get object from chrome driver
		 driver.navigate().to("https://id.atlassian.com/login?continue=https%3A%2F%2Fstart.atlassian.com%2F"); // to open jira website
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); //implicit wait to make page load and element
		 driver.manage().window().maximize();    //to maximize window 
	
		 WebElement username=driver.findElement(By.id("username")); //to get element  username
		 username.sendKeys("gelej67940@vmgmails.com");  //to send word in field of username
		 WebElement submit=driver.findElement(By.id("login-submit"));
		 submit.click(); //to click on button continue
		 WebElement password=driver.findElement(By.id("password"));
		 password.sendKeys("123456789");
		 WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
		 login.click();
		 WebElement software= driver.findElement(By.xpath("//div[@class='sc-ifAKCX xEYqw']"));
		 software.click();
		 WebElement project=driver.findElement(By.xpath("//img[@class='sc-bSbAYC dMTTyH']"));
		 project.click();
		 }
	 @Test(priority=1,dataProvider = "userdata") //to link data from excel sheet to code
	 public void create_issue(String Epicname1,String summary1 ,String component1,String description1) { // to get parameters from excel sheet
	 
		
		  driver.navigate().refresh();   //to refresh driver 
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); // implicit wait to reload page and element
		 WebElement create=driver.findElement(By.xpath("(//span[@class='css-t5emrf'])[7]"));
		 create.click();
		 WebElement epicname=driver.findElement(By.xpath("//input[@class='textfield text long-field']"));
		 epicname.sendKeys(Epicname1);
		 WebElement summary=driver.findElement(By.id("summary"));
		 summary.sendKeys(summary1);
		 WebElement component =driver.findElement(By.id("components-textarea"));
		 component.click();
		 component.sendKeys(component1);
		 WebElement description=driver.findElement(By.id("description"));
		 description.sendKeys(description1);
		 WebElement linkedissues= driver.findElement(By.id("issuelinks-linktype"));
		 Select linkedvalue= new Select(linkedissues);
		 linkedvalue.selectByVisibleText("is blocked by");
		 WebElement creatbutton=driver.findElement(By.id("create-issue-submit"));
		 creatbutton.click(); 
	 } 
	@Test(priority=2)
	 public void view_issue()
	 {
		 driver.navigate().refresh();  //to refresh driver
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); //implicit wait to reload page and elements
		 try {     //to handle alert 
			   Alert alt = driver.switchTo().alert();
			   alt.accept();
			} catch(NoAlertPresentException noe) {
			   // no alert.
			}
		WebElement allissue=driver.findElement(By.xpath("(//div[@class='css-1olrtn'])[3]"));
		allissue.click();
		WebElement summary_assert= driver.findElement(By.id("summary-val"));
		String actual_result=summary_assert.getText();
		System.out.println(actual_result);
		String expected_result="as a user i want to login to can buy product";
		 SoftAssert softassert=new SoftAssert();   //get object from softassert
		 softassert.assertEquals(actual_result, expected_result); //compare between actual result and expected result
		 WebElement assert_epic_name=driver.findElement(By.id("customfield_10011-val"));
		 String actual_resut2=assert_epic_name.getText();
		 System.out.println(actual_resut2);
		 String expected_result2="first epic";
		 softassert.assertEquals(actual_resut2, expected_result2);
		 
				 
		 softassert.assertAll();   //to apply assert to all assertion in method
		 
				
		
	 }
	 @AfterTest
	 public void close()
	 {
		 driver.quit();   //to close driver"chrome" After  run steps
	 }
	 
	 
	 
 }


