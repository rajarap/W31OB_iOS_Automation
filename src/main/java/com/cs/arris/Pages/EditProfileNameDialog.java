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

public class EditProfileNameDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidBy (id = "com.arris.sbcBeta:id/add_profile_text") 
	public MobileElement editProfileNameTitle; 
	
	@AndroidBy (id = "com.arris.sbcBeta:id/profile_message") 
	public MobileElement editProfileNameMessage; 
	
	@AndroidBy (id = "com.arris.sbcBeta:id/profile_title") 
	public MobileElement editProfileNameLabel;
	
	@AndroidBy (id = "com.arris.sbcBeta:id/edt_profile_name") 
	public MobileElement enterProfileName;
	
	@AndroidBy (id = "com.arris.sbcBeta:id/profile_save_dialog") 
	public MobileElement saveButton; 
	
	@AndroidBy (id = "com.arris.sbcBeta:id/profile_cancel_dialog") 
	public MobileElement closeButton; 
	
	
	public EditProfileNameDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void verifyUIOnEditUserProfileDialog() {
		try {
			if (editProfileNameTitle.isDisplayed())
				utils.log().info("Title - " + editProfileNameTitle.getText() + " - is displayed");
		} catch (Exception e) {
			utils.log().info("Edit Profile Name Title is not displayed");
		}
		
		try {
			if (editProfileNameMessage.isDisplayed())
				utils.log().info(editProfileNameMessage.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Please provide a name for the profile text is not displayed");
		}
		
		try {
			if (editProfileNameLabel.isDisplayed())
				utils.log().info(editProfileNameLabel.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("Profile Name Label is not displayed");
		}
		
		try {
			if (enterProfileName.isDisplayed())
				utils.log().info(enterProfileName.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("Enter User Profile Name text is not displayed");
		}
		
		try {
			if (saveButton.isDisplayed())
				utils.log().info(saveButton.getText() + " button is displayed");
		} catch (Exception e) {
			utils.log().info("Save Changes button is not displayed");
		}
	}
	
	public void clickSaveButton()
	{
		try {
			click(saveButton);
			utils.log().info("Clicked on Save Changes Button");
		} catch (Exception e) {
			utils.log().info("Save Changes button is not displayed");
		}
	}
	
	public void clickCloseButton()
	{
		try {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
		} catch (Exception e) {
			utils.log().info("Close button is not displayed");
		}
	}
	
	public void enterUserProfileName()
	{
		super.generateProfileName();
		super.sendKeys(enterProfileName, super.profileName);
		utils.log().info("Changed Profle Name");
	}
	
	@Override
	public boolean isAt() {
		if(editProfileNameTitle.isDisplayed())
		{
			utils.log().info("On Edit User Profile Dialog");
			return true;}
		else {
			utils.log().info("Not on Edit User Profile Dialog");
		return false;}

	}

}
