package com.jiracreate.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Createpage  extends PageBase{
	public JavascriptExecutor js;
	public Createpage(WebDriver driver) {
		super(driver);
		js=((JavascriptExecutor)driver);
	}

	@FindBy(id="username")
	public WebElement usernametxtbox;

	@FindBy(id="login-submit")
	public WebElement submitbutton;

	@FindBy(id="password")
	public WebElement passwordtxtbox;

	@FindBy(xpath="//button[@type='submit']")
	public WebElement loginbutton;

	@FindBy(xpath="//div[@class='sc-ifAKCX xEYqw']")
	public WebElement softwarelink;

	//@FindBy(xpath="//img[@class='sc-bSbAYC dMTTyH']")
	@FindBy(xpath="//span[@class='sc-cfWELz ktXlVd']")
	public WebElement selectproject;
	
	@FindBy(xpath="(//span[@class='css-t5emrf'])[7]")
	public WebElement createissuebutton;
	
	@FindBy(xpath="//input[@class='textfield text long-field']")
	public WebElement epicnametxtbox;
	
	@FindBy(id="summary")
	public WebElement summaryofepictxtbox;
	
	@FindBy(id="components-textarea")
	public WebElement componentstextarea;
	
	@FindBy(id="description")
	public WebElement descriptiontxtarea;
	
	@FindBy(id="issuelinks-linktype")
	public WebElement linkedissues;
	 
	@FindBy(id="create-issue-submit")
	public WebElement submitissuebutton;
	 
	@FindBy(xpath="(//div[@class='css-1olrtn'])[3]") ////div[@class='css-1olrtn'][contains(normalize-space(),'Issues')]
	public WebElement allissuelink;
	
	@FindBy(id="summary-val")
	public WebElement summarytxt;
	
	@FindBy(id="customfield_10011-val")
	public WebElement assertepicname;
	
	 
	//@FindBy(xpath="//div[@class='aui-message aui-message-success closeable shadowed']")
	//public WebElement createmessage;


	 //Select linkedvalue= new Select(linkedissues);

	public void logintojira(String username,String password)
	{
		usernametxtbox.sendKeys(username);
		submitbutton.click();
		passwordtxtbox.sendKeys(password);
		loginbutton.click();
		softwarelink.click();
		selectproject.click();
	}
	public void createepic(String Epicname,String summary ,String component,String description)
	{
		createissuebutton.click();
		epicnametxtbox.sendKeys(Epicname);
		summaryofepictxtbox.sendKeys(summary);
		componentstextarea.sendKeys(component);
		descriptiontxtarea.sendKeys(description);
		//linkedvalue.selectByVisibleText("is blocked by");
		submitissuebutton.click();
		//allissuelink.click();
	}
	public void viewissue()
	{
		js.executeScript("arguments[0].click();",allissuelink); //to click on allissue  link
	}

}