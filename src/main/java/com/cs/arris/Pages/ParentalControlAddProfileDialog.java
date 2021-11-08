package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ParentalControlAddProfileDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/add_profile_text")  //PROFILE NAME
	public MobileElement profileName; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/profile_cancel_dialog")  
	public MobileElement closeIcon; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/profile_message")  //Please provide a name for the profile.
	public MobileElement profileMessage1; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/profile_title")  //Profile Name
	public MobileElement profileTitle; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/edt_profile_name")  //text box to enter profile name
	public MobileElement enterProfileName; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/profile_save_dialog")  //create profile button
	public MobileElement createProfileButton; 
	
		
	public ParentalControlAddProfileDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void verifyUIOnProfilesPage()
	{
		if(profileName.isDisplayed())
			utils.log().info(profileName.getText() + " text is displayed");
		else
			utils.log().info(profileName.getText() + " text is not displayed");
		
		if(profileMessage1.isDisplayed())
			utils.log().info(profileMessage1.getText() + " text is displayed");
		else
			utils.log().info(profileMessage1.getText() + " text is not displayed");
		
		if(profileTitle.isDisplayed())
			utils.log().info(profileTitle.getText() + " text is displayed");
		else
			utils.log().info(profileTitle.getText() + " text is not displayed");
		
		if(enterProfileName.isDisplayed())
			utils.log().info(enterProfileName.getText() + " text is displayed");
		else
			utils.log().info(enterProfileName.getText() + " text is not displayed");
		
		if(closeIcon.isDisplayed())
			utils.log().info("Close Icon is displayed");
		else
			utils.log().info("Close Icon is not displayed");
		
		if(createProfileButton.isDisplayed())
			utils.log().info("Create Profile Button is displayed");
		else
			utils.log().info("Create Profile Button is not displayed");
	}
	
	public void enterProfileName()
	{
		super.generateProfileName();
		super.sendKeys(enterProfileName, super.profileName);
		utils.log().info("Entered new Profle Name");
	}
	
	public void clickCloseIcon()
	{
		click(closeIcon);
		utils.log().info("Clicked on Close Icon");
	}
	
	public void clickCreateProfileButton()
	{
		click(createProfileButton);
		utils.log().info("Clicked on Create Profile Button Icon");
	}
	

	@Override
	public boolean isAt() {
		if(profileName.isDisplayed())
		{
			utils.log().info("On Create Profile Name Dialog");
			return true;}
		else {
			utils.log().info("Not on Create Profile Name Dialog");
		return false;}
	}
}
