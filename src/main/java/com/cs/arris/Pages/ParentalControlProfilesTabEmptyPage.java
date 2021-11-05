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

public class ParentalControlProfilesTabEmptyPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle']"),  //Devices (2)
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[359,149][721,223]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") 
	})
	public MobileElement parentalControlTitle; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"),  //back button
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']")
	})
	public MobileElement backButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"),  //help Icon
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[980,153][1046,219]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/helpIcon") 
	})
	public MobileElement helpIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_parental_view']"),  //Profile tab
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[102,276][540,378]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/profile_parental_view") 
	})
	public MobileElement profilesTab; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/blocked_parental_view']"),  //Currently blocked tab
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[540,276][978,378]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/blocked_parental_view") 
	})
	public MobileElement blockedTab; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/parental_enable_disable']"),  //toggle Icon
		@AndroidBy (xpath = "//android.widget.Switch[@text='ON']"),
		@AndroidBy (xpath = "//android.widget.Switch[@bounds='[980,153][1046,219]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/parental_enable_disable") 
	})
	public MobileElement parentalControlToggleIconON; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/parental_enable_disable']"),  //toggle Icon
		@AndroidBy (xpath = "//android.widget.Switch[@text='OFF']"),
		@AndroidBy (xpath = "//android.widget.Switch[@bounds='[980,153][1046,219]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/parental_enable_disable") 
	})
	public MobileElement parentalControlToggleIconOFF; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/add_profile']"),  //+Add Profile
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[722,671][978,735]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/add_profile") 
	})
	public MobileElement addProfileLink; 
	//when toggle button is off, add profile link is disabled
	//when toggle button is on, add profile link is enabled

	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Enable Parental Control']")  //Enable Parental Control Text
	public MobileElement enableParentalControlText; 
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Enable Parental Control']")  //Enable Disable Profile Text
	public MobileElement enableDisableProfileText; 
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='User Profiles']")  //User Profiles Text
	public MobileElement userProfilesText; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/heading_error_message")  //There are currently no User Profiles
	public MobileElement errorMessage1; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/heading_error_message_1")  //Please note that you must create profiles using the Add Profile button before User Profiles will appear here.
	public MobileElement errorMessage2; 
	
	
	//Alert controls - appears when currently blocked tab is clicked when taggle button is OFF on profiles page
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/cancel_dialog")  //click the X icon
	public MobileElement cancelDialog; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/error_header_dialog")  //Alert
	public MobileElement alertTitle;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/error_description")  //Enable Parental control to see Blocked Profiles
	public MobileElement alertText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/ok_dialog")  //OK
	public MobileElement okButton;
	
	
	public ParentalControlProfilesTabEmptyPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickBackButton()
	{
		click(backButton);
		utils.log().info("Profiles Page - Clicked on Back Button");
	}
	
	public void clickHelpIcon()
	{
		click(helpIcon);
		utils.log().info("Profiles Page - Clicked on Help Icon");
	}
	
	public void verifyUIOnProfilesPage()
	{
		if(enableParentalControlText.isDisplayed())
			utils.log().info(parentalControlTitle.getText() + " Text is displayed");
		else
			utils.log().info(parentalControlTitle.getText() + " Text is not displayed");
		
		if(enableDisableProfileText.isDisplayed())
			utils.log().info(enableDisableProfileText.getText() + " Text is displayed");
		else
			utils.log().info(enableDisableProfileText.getText() + " Text is not displayed");
		
		if(userProfilesText.isDisplayed())
			utils.log().info(userProfilesText.getText() + " Text is displayed");
		else
			utils.log().info(userProfilesText.getText() + " Text is not displayed");
		
		if(errorMessage1.isDisplayed())
			utils.log().info(errorMessage1.getText() + " Text is displayed");
		else
			utils.log().info(errorMessage1.getText() + " Text is not displayed");
		
		if(errorMessage2.isDisplayed())
			utils.log().info(errorMessage2.getText() + " Text is displayed");
		else
			utils.log().info(errorMessage2.getText() + " Text is not displayed");
		
		if(parentalControlToggleIconOFF.isDisplayed())
			utils.log().info("Toggle Button is displayed. Status is currently " + parentalControlToggleIconOFF.getText());
		else
			utils.log().info("Toggle button is not displayed");
		
		if(addProfileLink.isDisplayed() && parentalControlToggleIconOFF.isDisplayed())
		{
			utils.log().info("Add Profile Link is displayed and is currently in disabled state");
		}
		
		click(blockedTab);
		
		if(alertTitle.isDisplayed())
		{
			utils.log().info("Alert Dialog is displayed");
		}
		
		if(alertText.isDisplayed())
		{
			utils.log().info(alertText.getText() + " - text on Alert Dialog is displayed");
		}
		
		if(okButton.isDisplayed())
		{
			utils.log().info(okButton.getText() + " - button on Alert Dialog is displayed");
		}
		
		if(cancelDialog.isDisplayed())
		{
			utils.log().info("Cancel Icon on Alert Dialog is displayed");
		}
		
		click(okButton);
		utils.log().info("Clicked OK button on Alert Dialog box");
		
		this.enableParentalConrol();
		
		if(addProfileLink.isDisplayed() && parentalControlToggleIconON.isDisplayed())
		{
			utils.log().info("Add Profile Link is displayed and is currently in enabled state");
		}
	}
	
	public void clickCurrentlyBlockedsTab()
	{
		click(blockedTab);
		utils.log().info("Clicked Currently Blocked Tab on Profiles Tab Page");
	}
	
	public AppRatingDialog getAppRatingDialogObject()
	{
		AppRatingDialog appRating = new AppRatingDialog();
		return appRating;
	}
	
	public void enableParentalConrol()
	{
		click(parentalControlToggleIconOFF);
		try
		{
			if(getAppRatingDialogObject().isAt())
			{
				getAppRatingDialogObject().clickRemindMeLaterLink();
				utils.log().info("App Rating Dialog - Clicked on Remind me Later Text");
			}
		}catch(Exception e) { utils.log().info("App Rating Dialog is not displayed");}
		
		utils.log().info("Enabled Parental Control");
	}
	
	public void disableParentalConrol()
	{
		click(parentalControlToggleIconON);
		utils.log().info("Disabled Parental Control");
	}
	
	public boolean enableAddProfileLink()
	{
		click(parentalControlToggleIconOFF);
		utils.log().info("Add Profile Link is enabled");
		return true;
	}
	
	public boolean disableAddProfileLink()
	{
		click(parentalControlToggleIconON);
		utils.log().info("Add Profile Link is disabled");
		return false;
	}
	
	public void clickAddProfileLink()
	{
		if(addProfileLink.isEnabled())
		{
			click(addProfileLink);
		}
		else
		{
			this.enableAddProfileLink();
			this.clickAddProfileLink();
		}
	}
	
	@Override
	public boolean isAt() {
		if(enableParentalControlText.isDisplayed())
		{
			utils.log().info("On Parental Control - Profiles Page");
			return true;}
		else {
			utils.log().info("Not on Parental Control - Profilees Page");
		return false;}
	}
}
