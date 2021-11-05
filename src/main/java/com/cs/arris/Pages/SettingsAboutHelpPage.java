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

public class SettingsAboutHelpPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") //Settings
	public MobileElement settingsTitle; 
	
	@AndroidFindAll({ 
		@AndroidBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"), // back button
		@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']") })
	public MobileElement backButton;

	@AndroidFindAll({ 
		@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"), // help																									// Icon
		@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[980,153][1046,219]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/helpIcon") })
public MobileElement helpIcon;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/settings_header") //Account Settings
	public MobileElement accountSettingsTitle;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/settings_name_message") //Name
	public MobileElement nameLabel;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/settings_name") //demouser demouser
	public MobileElement accountName; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/user_iv") 
	public MobileElement userImage; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/settings_email_message") //Email
	public MobileElement emailLabel;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/settings_email") //Name
	public MobileElement emailAddress;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/email_iv") 
	public MobileElement emailImage; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/settings_sign_out") // Sign Out
	public MobileElement signoutButton; 
		
	public SettingsAboutHelpPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void verifyUIOnSettingsPage() {
		if (settingsTitle.isDisplayed())
			utils.log().info("Title " + settingsTitle.getText() + " is displayed");
		
		if (accountSettingsTitle.isDisplayed())
			utils.log().info(accountSettingsTitle.getText() + " : text is displayed");
		else
			utils.log().info("Account Settings Text is not displayed");

		if (nameLabel.isDisplayed())
			utils.log().info(nameLabel.getText() + " label is displayed");
		else
			utils.log().info("Name Label is not displayed");

		if (accountName.isDisplayed())
			utils.log().info("Users account firstname and lastname is displayed : " +  accountName.getText());
		else
			utils.log().info("Users account firstname and lastname is not displayed");
		
		if (userImage.isDisplayed())
			utils.log().info("User Image is displayed");
		else
			utils.log().info("User Image Label is not displayed");

		if (emailImage.isDisplayed())
			utils.log().info("Email Address image is displayed");
		else
			utils.log().info("Email Address image is not displayed");
		
		if (emailAddress.isDisplayed())
			utils.log().info("Email Address label is displayed");
		else
			utils.log().info("Email Address Label is not displayed");
		
		if (emailLabel.isDisplayed())
			utils.log().info(emailLabel.getText() + " label is displayed");
		else
			utils.log().info("Email Label is not displayed");
		
		if (signoutButton.isDisplayed())
			utils.log().info("Sign Out button is displayed");
		else
			utils.log().info("Sign Out button is not displayed");
	}
	
	public void verifyUIOnHelpPage() {
		if (settingsTitle.isDisplayed())
			utils.log().info("Title " + settingsTitle.getText() + " is displayed");
		
		if (accountSettingsTitle.isDisplayed())
			utils.log().info(accountSettingsTitle.getText() + " : text is displayed");
		else
			utils.log().info("Account Settings Text is not displayed");
	}
	
	public void verifyUIOnAboutPage() {
		if (settingsTitle.isDisplayed())
			utils.log().info("Title " + settingsTitle.getText() + " is displayed");
		
		if (accountSettingsTitle.isDisplayed())
			utils.log().info(accountSettingsTitle.getText() + " : text is displayed");
		else
			utils.log().info("Account Settings Text is not displayed");
	}
	
	public void clickSignOutButton()
	{
		click(signoutButton);
		utils.log().info("Settings Page - Clicked on Sign Out button");
	}
	
	public String getUserAccountName()
	{
		return accountName.getText();
	}
	
	public String getUserEmailAddress()
	{
		return emailAddress.getText();
	}
	
	@Override
	public boolean isAt() {
		if(accountSettingsTitle.isDisplayed())
		{
			utils.log().info("On Settings Page");
			return true;}
		else {
			utils.log().info("Not on Settings Page");
		return false;}
	}

}
