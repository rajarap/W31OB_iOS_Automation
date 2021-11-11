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

public class ParentalControlCurrentlyBlockedPage extends ParentClass implements Page
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
	public MobileElement currentlyBlockedTab; 

	@AndroidFindBy (id = "com.arris.sbcBeta:id/heading_error_message")  //There are currently no Blocked Profiles
	public MobileElement currentlyBlockederrorMessage1; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/heading_error_message_1")  //Please note the profile will only appear here if the time block applied on the particular profile is active.
	public MobileElement currentlyBlockederrorMessage2; 
	
		
	public ParentalControlCurrentlyBlockedPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickBackButton()
	{
		try {
		click(backButton);
		utils.log().info("Clicked on Back Button");
		} catch (Exception e) {
			utils.log().info("Back Button is not displayed");
		}
	}
	
	public void clickProfilesTab()
	{
		try {
		click(profilesTab);
		utils.log().info("Clicked on Profiles Button");
		} catch (Exception e) {
			utils.log().info("Profiles Tab is not displayed");
		}
	}

	
	
	public void verifyInternetPausedUserProfiles() {
		try {
			int counter = 1;
			utils.log().info("**************************************************************");
			utils.log().info("Details of User Profiles For Whom Internt is Currently Paused");
			utils.log().info("**************************************************************");

			for (int i = 1; i < super.profileNames.size(); i++) {
				utils.log().info("User Profile : " + counter);
				utils.log().info("----------------------");
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
								+ "]");
				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/profile_image']")
								.isDisplayed())
							utils.log().info("Profile Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Profile Image is not displayed ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
								.isDisplayed()) {
							utils.log().info("Profile user Name is : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
									.getText());
						}
					} catch (Exception exp) {
						utils.log().info("User Profile Name is not displayed ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
								.isDisplayed()) {
							utils.log().info("Number of Devices Paused for Internet Connection is : " + (e
									.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
									.getText()));
						}
					} catch (Exception exp) {
						utils.log().info("Number of Devices Paused for Internet Connection is not displayed ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
								.isDisplayed()) {
							utils.log().info("Internet Paused Label is displayed : " + (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
									.getText()));
						}
					} catch (Exception exp) {
						utils.log().info("Internet Paused Label is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
					counter++;
				}
				if (i >= 7)
					new SwipeActions().swipeScreen(Direction.UP);
				super.pause(3);
			}
		} catch (Exception exp) {
			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
		}
	}
	
	public void verifyNoBlockedProfileMessages()
	{
		try {
			if(currentlyBlockederrorMessage1.isDisplayed())
				utils.log().info(currentlyBlockederrorMessage1.getText() + " message is displayed");
		} catch (Exception e) {
			utils.log().info("There are currently no Blocked Profiles message is not displayed");
		}
		
		try {
			if(currentlyBlockederrorMessage2.isDisplayed())
				utils.log().info(currentlyBlockederrorMessage2.getText() + " message is displayed");
		} catch (Exception e) {
			utils.log().info("Please note the profile will only appear here if the time block applied on the particular profile is active message is not displayed");
		}
	}
	
	@Override
	public boolean isAt() {
		if(currentlyBlockedTab.isDisplayed() && currentlyBlockedTab.isEnabled())
		{
			utils.log().info("On Parental Control - Currently Blocked Page");
			return true;}
		else {
			utils.log().info("Not on Parental Control - Currently Blocked Page");
		return false;}
	}
}
