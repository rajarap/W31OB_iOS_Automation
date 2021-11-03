package com.cs.arris.Pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ParentalControlWithProfilesPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public SwipeActions swipe = new SwipeActions();
	public MobileElement me;
	public int counter = 2;
	int size;
	
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
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Pause All Profiles']")  //Pause All Profiles Text
	public MobileElement pauseAllProfilesText; 
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Pause Internet Access for All Profiles']")  //Pause Internet Access for All Profiles Text
	public MobileElement pauseInternetAccessToAllText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/parental_enable_disable']"),  //toggle Icon
		@AndroidBy (xpath = "//android.widget.Switch[@text='ON']"),
		@AndroidBy (xpath = "//android.widget.Switch[@bounds='[794,766][954,858]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/parental_enable_disable") 
	})
	public MobileElement pauseAllInternetProfileToggleIconON; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/parental_enable_disable']"),  //toggle Icon
		@AndroidBy (xpath = "//android.widget.Switch[@text='OFF']"),
		@AndroidBy (xpath = "//android.widget.Switch[@bounds='[794,766][954,858]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/parental_enable_disable") 
	})
	public MobileElement pauseAllInternetProfileToggleIconOFF; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/profile_list_view")  //Profile Dinning List View
	public List<MobileElement> profileListView; 
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/profile_image']")  //profile Image
	public List<MobileElement> profileImage; 
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")  //profile name
	public List<MobileElement> profileName; 
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")  //profile connected devices
	public List<MobileElement> profileConnectedDevices; 
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='ccom.arris.sbcBeta:id/pause_internet_message']")  //pause internet
	public List<MobileElement> pauseInternet; 
	
	@AndroidFindBy (xpath = "/android.widget.Switch[@text='OFF']")  //disable toggle icon
	public List<MobileElement> pauseInternetToggleOFF;  
	
	@AndroidFindBy (xpath = "/android.widget.Switch[@text='ON']")  //enable toggle icon name
	public List<MobileElement> pauseInternetToggleON; 
	
	
	public ParentalControlWithProfilesPage()
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
	
	public void verifyUserProfile()
	{
		utils.log().info("User Profile Details");
		utils.log().info("********************");
		size = profileListView.size();
		
		for(int i = 0 ; i < size ; i++)
		{
//			new SwipeActions().swipeScreen(Direction.UP);
			me = (MobileElement) super.getDriver().findElementByXPath("//android.view.ViewGroup[@index="+i+"]");		
			if (me.isDisplayed())
			{
				utils.log().info("----------------------------------------------------------------------");
				if(profileImage.get(i).isDisplayed())
					utils.log().info("User Profile Image is displayed");
				else
					utils.log().info("User Profile Image is not displayed");
				utils.log().info("User Profile Name		: " + profileName.get(i).getText());
				utils.log().info("Connected	Devices		: " + profileConnectedDevices.get(i).getText());
				utils.log().info("Pause Internet		: " + pauseInternet.get(i).getText());
				if(pauseInternetToggleOFF.get(i).isDisplayed())
					utils.log().info("Internet access is allowed for this user");
				if(pauseInternetToggleON.get(i).isDisplayed())
					utils.log().info("Internet access is paused for this user");
				utils.log().info("----------------------------------------------------------------------");
			}
			else
			{
				new SwipeActions().swipeScreen(Direction.UP);
				if (me.isDisplayed())
				{
					utils.log().info("----------------------------------------------------------------------");
					if(profileImage.get(i).isDisplayed())
						utils.log().info("User Profile Image is displayed");
					else
						utils.log().info("User Profile Image is not displayed");
					utils.log().info("User Profile Name		: " + profileName.get(i).getText());
					utils.log().info("Connected	Devices		: " + profileConnectedDevices.get(i).getText());
					utils.log().info("Pause Internet		: " + pauseInternet.get(i).getText());
					if(pauseInternetToggleOFF.get(i).isDisplayed())
						utils.log().info("Internet access is allowed for this user");
					if(pauseInternetToggleON.get(i).isDisplayed())
						utils.log().info("Internet access is paused for this user");
					utils.log().info("----------------------------------------------------------------------");
				}
				else
				{
					utils.log().info("Unable to access the invisible user profiles");
				}
			}
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
