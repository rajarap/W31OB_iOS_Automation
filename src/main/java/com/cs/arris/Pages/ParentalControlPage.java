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

public class ParentalControlPage extends ParentClass implements Page
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
		@AndroidBy (xpath = "//android.widget.Switch[@bounds='[980,153][1046,219]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/parental_enable_disable") 
	})
	public MobileElement parentalControlToggleIcon; 
	
	 public ParentalControlProfilesTabEmptyPage getParentalControlProfilesTabPageObject() {
		 ParentalControlProfilesTabEmptyPage parentalControlProfilesTabEmptyPage = new ParentalControlProfilesTabEmptyPage();
	     return parentalControlProfilesTabEmptyPage;
	  }
	 
	 public ParentalControlCurrentlyBlockedPage getParentalControlCurrentlyBlockedTabPageObject() {
		 ParentalControlCurrentlyBlockedPage parentalControlCurrentlyBlockedTabPage = new ParentalControlCurrentlyBlockedPage();
	     return parentalControlCurrentlyBlockedTabPage;
	  }
	
	 public HomePage getHomePageObject() {
		 HomePage homePage = new HomePage();
	     return homePage;
	  }
	 
	 public NetworkPage getNetworkPageObject() {
		 NetworkPage networkPage = new NetworkPage();
	     return networkPage;
	  }
	 
	 public FooterIconsPage getFooterIconsPageObject() {
		 FooterIconsPage footerIconsPage = new FooterIconsPage();
	     return footerIconsPage;
	  }
	
	public ParentalControlPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickBackButton()
	{
		click(backButton);
		utils.log().info("Parental Control Page - Clicked on Back Button");
	}
	
	public void clickHelpIcon()
	{
		click(helpIcon);
		utils.log().info("Parental Control Page - Clicked on Help Icon");
	}
	
	public void verifyUIOnParentalControlPage()
	{
		if(parentalControlTitle.isDisplayed())
			utils.log().info("Title - " + parentalControlTitle.getText() + " - is displayed");
		else
			utils.log().info("Parental Control Title Text is not displayed");
		
		if(backButton.isDisplayed())
			utils.log().info("Back Button is displayed");
		else
			utils.log().info("Back Button is not displayed");
		
		if(helpIcon.isDisplayed())
			utils.log().info("Help Icon is displayed");
		else
			utils.log().info("Help Icon is not displayed");
		
		if(profilesTab.isDisplayed())
			utils.log().info("Profiles Tab is displayed");
		else
			utils.log().info("Profiles Tab is not displayed");
		
		if(blockedTab.isDisplayed())
			utils.log().info("Currently Blocked Tab is displayed");
		else
			utils.log().info("Currently Blocked Tab is not displayed");
	}
	
	public void clickProfilesTab()
	{
		click(profilesTab);
		utils.log().info("Clicked Profiles Tab on Parental Control Page");
	}
	
	public void clickCurrentlyBlockedsTab()
	{
		click(blockedTab);
		utils.log().info("Clicked Currently Blocked Tab on Parental Control Page");
	}
	
	@Override
	public boolean isAt() {
		if(parentalControlTitle.isDisplayed())
		{
			utils.log().info("On Parental Control Page");
			return true;}
		else {
			utils.log().info("Not on Parental Control Page");
		return false;}
	}
}
