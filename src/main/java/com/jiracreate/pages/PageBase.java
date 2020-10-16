package com.jiracreate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase { //this is "parent" class for all pages
	
	public static WebDriver driver;
	public PageBase(WebDriver driver) // this is cconstrcutor
	{
		PageFactory.initElements(driver, this);
	}

}
