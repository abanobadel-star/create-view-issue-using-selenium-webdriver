package com.jiracreate.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.jiracreate.pages.Createpage;

public class TestBase { //this class is the base "parent" for all class test "child" so it put all method which will repeat each testcase

	
	Createpage createobject;
	public static WebDriver driver;
	public static Properties prop;
	// to get path for config properties file
	public static String configpath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\jiracreate\\configuration\\config.properties";
	public static String chromepath=System.getProperty("user.dir")+"\\drivers2\\chromedriver.exe"; //to get path for chrome
	public static String firefoxpath=System.getProperty("user.dir")+"\\drivers2\\geckodriver.exe";  //to get path for firefox
	public static String InternetExplorerpath=System.getProperty("user.dir")+"\\drivers2\\IEDriverServer.exe"; //to get path for internet explorer
	
	public TestBase() throws IOException
	{
		prop=new Properties();
		FileInputStream file=new FileInputStream(configpath);
		prop.load(file);
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void initalization(@Optional ("chrome") String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "chromepath");
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "firefoxpath");
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("internetexplorer"))
		{
			System.setProperty("webdriver.ie.driver", "InternetExplorerpath");
			driver=new InternetExplorerDriver();
		}
			
		createobject=new Createpage(driver);
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		createobject.logintojira(prop.getProperty("username"), prop.getProperty("password"));
		
	}

}
