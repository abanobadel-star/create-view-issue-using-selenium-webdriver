package com.jiracreate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Createpage  extends PageBase{

	public Createpage(WebDriver driver) {
		super(driver);

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

	@FindBy(xpath="//img[@class='sc-bSbAYC dMTTyH']")
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
	


	 Select linkedvalue= new Select(linkedissues);

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
		linkedvalue.selectByVisibleText("is blocked by");
		submitissuebutton.click();
		
	}
}