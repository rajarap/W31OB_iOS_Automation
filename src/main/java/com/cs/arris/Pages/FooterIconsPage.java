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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class FooterIconsPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public Integer count;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/home_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[0,2000][355,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/home_view") 
	})
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"TabBar_TitleHome\"]")
	public MobileElement homeButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/home_txt"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[137,2089][218,2135]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/home_txt") 
	})
	public MobileElement homeButtonText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_footer_home"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[142,2018][213,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_footer_home") 
	})
	public MobileElement homeButtonImage; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/network_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[362,2000][717,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/network_view") 
	})
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"TabBar_TitleNetwork\"]")
	public MobileElement networkButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/network_txt"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[484,2089][595,2135]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/network_txt") 
	})
	public MobileElement networkButtonText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView@resource-id='com.arris.sbcBeta:id/img_footer_network"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[504,2018][575,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_footer_network") 
	})
	public MobileElement networkButtonImage; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/parental_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[724,2000][1080,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/parental_view") 
	})
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"TabBar_TitleParental\"]")
	public MobileElement parentalButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/parental_txt"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[844,2089][959,2135]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/parental_txt") 
	})
	public MobileElement parentalButtonText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='ccom.arris.sbcBeta:id/img_footer_parental"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[866,2018][937,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_footer_parental") 
	})
	public MobileElement parentalButtonImage; 
	
	public FooterIconsPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean verifyUIOnFooterIconsPage()
	{
		try {
			if(homeButton.isDisplayed())
				utils.log().info("Footer Icons Page - Home Button is displayed");
			else
				utils.log().info("Footer Icons Page - Home Button is not displayed");

			if(homeButtonText.isDisplayed())
				utils.log().info("Footer Icons Page - Home Button Text is displayed");
			else
				utils.log().info("Footer Icons Page - Home Button Text is not displayed");

			if(homeButtonImage.isDisplayed())
				utils.log().info("Footer Icons Page - Home Button Image is displayed");
			else
				utils.log().info("Footer Icons Page - Home Button Image is not displayed");

			if(networkButton.isDisplayed())
				utils.log().info("Footer Icons Page - Network Button is displayed");
			else
				utils.log().info("Footer Icons Page - Network Button is not displayed");

			if(networkButtonText.isDisplayed())
				utils.log().info("Footer Icons Page - Network Button Text is displayed");
			else
				utils.log().info("Footer Icons Page - Network Button Text is displayed");

			if(networkButtonImage.isDisplayed())
				utils.log().info("Footer Icons Page - Network Button Image is displayed");
			else
				utils.log().info("Footer Icons Page - Network Button Image is not displayed");

			if(parentalButton.isDisplayed())
				utils.log().info("Footer Icons Page - Partental Button is displayed");
			else
				utils.log().info("Footer Icons Page - Parental Button is not displayed");

			if(parentalButtonText.isDisplayed())
				utils.log().info("Footer Icons Page - Partental Button Text is displayed");
			else
				utils.log().info("Footer Icons Page - Parental Button Text is not displayed");

			if(parentalButtonImage.isDisplayed())
				utils.log().info("Footer Icons Page - Footer Icons Page - Parental Button Image is displayed");
			else
				utils.log().info("Footer Icons Page - Parental Button Image is not displayed");
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean clickHomeButton()
	{
		try {
			click(homeButton);
			utils.log().info("Footer Icons Page - Clicked on Home Button");
			return true;
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Home Button is not displayed");
			return false;
		}
	}
	
	public boolean clickNetworkButton()
	{
		try {
			click(networkButton);
			utils.log().info("Footer Icons Page - Clicked on Network Button");
			return true;
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Network Button is not displayed");
			return false;
		}
	}
	
	public boolean clickParentalButton()
	{
		try {
			click(parentalButton);
			utils.log().info("Footer Icons Page - Clicked on Parental Button");
			return true;
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Parental Button is not displayed");
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if(homeButton.isDisplayed())
		{
			utils.log().info("On Footer Icons Page");
			return true;}
		else {
			utils.log().info("Not on Footer Icons Page");
		return false;}
	}
}
