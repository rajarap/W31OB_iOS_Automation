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

public class AddDeviceFooterIconsPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public Integer count;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/home_view")
	public MobileElement homeButton; 
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/network_view")
	public MobileElement userGuideButton; 

	@AndroidFindBy(id = "com.arris.sbcBeta:id/parental_view")
	public MobileElement faqButton; 
	

	public AddDeviceFooterIconsPage()
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

			if(userGuideButton.isDisplayed())
				utils.log().info("Footer Icons Page - User Guide Button is displayed");
			else
				utils.log().info("Footer Icons Page - User Guideis not displayed");

			if(faqButton.isDisplayed())
				utils.log().info("Footer Icons Page - FAQ Button is displayed");
			else
				utils.log().info("Footer Icons Page - FAQ Button is not displayed");

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
	
	public boolean clickUserGuideButton()
	{
		try {
			click(userGuideButton);
			utils.log().info("Footer Icons Page - Clicked on User Guide Button");
			return true;
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - User Guide Button is not displayed");
			return false;
		}
	}
	
	public boolean clickFAQButton()
	{
		try {
			click(faqButton);
			utils.log().info("Footer Icons Page - Clicked on FAQ Button");
			return true;
		} catch (Exception e) {
			utils.log().info("Footer Icons Page - FAQ Button is not displayed");
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
