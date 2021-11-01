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

public class HamburgerMenuPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/nav_add_device")
	public MobileElement addDevice;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/nav_remove_device")
	public MobileElement removeDevice;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/nav_max_speed_test")
	public MobileElement speedTest;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/nav_add_max")
	public MobileElement addNewSatellite;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/nav_Alexa_Skill")
	public MobileElement amazonFeatures;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/nav_Help")
	public MobileElement helpMenu;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/nav_About")
	public MobileElement aboutApp;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/nav_Settings")
	public MobileElement appSettings;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/closeLogoIcon")
	public MobileElement closeHamburgerMenu;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/centralLogo")
	public MobileElement logo;
	
	public HamburgerMenuPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void verifyUIOnHamburgerMenuPage()
	{
		if(addDevice.isDisplayed())
			utils.log().info("Hamburger Menu - " + addDevice.getText() + " - is displayed");
		else
			utils.log().info("Hamburger Menu - " + addDevice.getText() + " - is not displayed");
		
		if(removeDevice.isDisplayed())
			utils.log().info("Hamburger Menu - " + removeDevice.getText() + " - is displayed");
		else
			utils.log().info("Hamburger Menu - " + removeDevice.getText() + " - is not displayed");
			
		if(speedTest.isDisplayed())
			utils.log().info("Hamburger Menu - " + speedTest.getText() + " - is displayed");
		else
			utils.log().info("Hamburger Menu - " + speedTest.getText() + " - is not displayed");
		
		if(addNewSatellite.isDisplayed())
			utils.log().info("Hamburger Menu - " + addNewSatellite.getText() + " - is displayed");
		else
			utils.log().info("Hamburger Menu - " + addNewSatellite.getText() + " - is not displayed");
		
		if(amazonFeatures.isDisplayed())
			utils.log().info("Hamburger Menu - " + amazonFeatures.getText() + " - is displayed");
		else
			utils.log().info("Hamburger Menu - " + amazonFeatures.getText() + " - is not displayed");
		
		if(helpMenu.isDisplayed())
			utils.log().info("Hamburger Menu - " + helpMenu.getText() + " - is displayed");
		else
			utils.log().info("Hamburger Menu - " + helpMenu.getText() + " - is not displayed");
		
		if(aboutApp.isDisplayed())
			utils.log().info("Hamburger Menu - " + aboutApp.getText() + " - is displayed");
		else
			utils.log().info("Hamburger Menu - " + aboutApp.getText() + " - is not displayed");
		
		if(appSettings.isDisplayed())
			utils.log().info("Hamburger Menu - " + appSettings.getText() + " - is displayed");
		else
			utils.log().info("Hamburger Menu - " + appSettings.getText() + " - is not displayed");
	}
	
	 public HomePage getHomePageObject() {
		 HomePage homePage = new HomePage();
	     return homePage;
	  }
	 
	 public SpeedTestPage getSpeedTestPageObject() {
		 SpeedTestPage speedTestPage = new SpeedTestPage();
	     return speedTestPage;
	  }

	public void clickCloseButton()
	{
		click(closeHamburgerMenu); //back to home page
	}
	
	public void clickAddDeviceButton()
	{
		click(addDevice); 
	}
	
	public void clickRemoveDeviceButton()
	{
		click(removeDevice); 
	}
	
	public void clickSpeedTestButton()
	{
		click(speedTest); 
	}
	
	public void clickAddSatelliteButton()
	{
		click(addNewSatellite); 
	}
	
	public void clickAmazonFeaturesButton()
	{
		click(amazonFeatures); 
	}
	
	public void clickHelpManuButton()
	{
		click(helpMenu); 
	}
	
	public void clickAboutAppButton()
	{
		click(aboutApp); 
	}
	
	@Override
	public boolean isAt() {
		if(logo.isDisplayed())
		{
			utils.log().info("At Hamburger Menu Page");
			return true;
		}
		else
		{
			utils.log().info("Hamburger Menu Page is not displayed");
			return false;
		}
	}

}
