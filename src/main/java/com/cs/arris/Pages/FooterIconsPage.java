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

public class FooterIconsPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public Integer count;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/home_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[0,2000][355,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/home_view") 
	})
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
	
	//Verify if all the required UI elements are displayed on the Home Page
	public void verifyUIOnFooterIconsPage()
	{
		try {
			if(homeButton.isDisplayed())
				utils.log().info("Footer Icons Page - Home Button is displayed");
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Home Button is not displayed");
		}
		
		try {
			if(homeButtonText.isDisplayed())
				utils.log().info("Footer Icons Page - Home Button Text is displayed");
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Home Button Text is not displayed");
		}
		
		try {
			if(homeButtonImage.isDisplayed())
				utils.log().info("Footer Icons Page - Home Button Image is displayed");
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Home Button Image is not displayed");
		}

		try {
			if(networkButton.isDisplayed())
				utils.log().info("Footer Icons Page - Network Button is displayed");
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Network Button is not displayed");
		}

		try {
			if(networkButtonText.isDisplayed())
				utils.log().info("Footer Icons Page - Network Button Text is displayed");
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Network Button Text is displayed");
		}
			
		try {
			if(networkButtonImage.isDisplayed())
				utils.log().info("Footer Icons Page - Network Button Image is displayed");
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Network Button Image is not displayed");
		}
		
		try {
			if(parentalButton.isDisplayed())
				utils.log().info("Footer Icons Page - Partental Button is displayed");
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Parental Button is not displayed");
		}
		
		try {
			if(parentalButtonText.isDisplayed())
				utils.log().info("Footer Icons Page - Partental Button Text is displayed");
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Parental Button Text is not displayed");
		}
		
		try {
			if(parentalButtonImage.isDisplayed())
				utils.log().info("Footer Icons Page - Footer Icons Page - Parental Button Image is displayed");
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Parental Button Image is not displayed");
		}
	}

	public void clickHomeButton()
	{
		try {
			click(homeButton);
			utils.log().info("Footer Icons Page - Clicked on Home Button");
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Home Button is not displayed");
		}
	}
	
	public void clickNetworkButton()
	{
		try {
			click(networkButton);
			utils.log().info("Footer Icons Page - Clicked on Network Button");
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Network Button is not displayed");
		}
	}
	
	public void clickParentalButton()
	{
		try {
			click(parentalButton);
			utils.log().info("Footer Icons Page - Clicked on Parental Button");
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - Parental Button is not displayed");
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
