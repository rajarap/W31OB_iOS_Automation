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

public class InstallAdditionalSatellitePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/dialog_title']"),  //INSTALL ADDITIONAL SATELLITE
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[151,803][929,990]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/dialog_title") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Install_Additional_Satellite_Screen_TitleLabel\"]")
	public MobileElement installAdditionalSatelliteTitleText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/dialog_description']"),  //Press Install Now if you have an additional satellite unit to install.
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[151,1024][929,1159]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/dialog_description") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Install_Additional_Satellite_Screen_SubTitleLabel\"]")
	public MobileElement installAdditionalSatelliteDescription; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/dialog_install_now']"),  //INSTALL NOW
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[151,1179][929,1316]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/dialog_install_now") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Install_Additional_Satellite_Screen_Button_Now\"]")
	public MobileElement installNowButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/dialog_install_later']"),  //CANCEL
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[151,1412][929,1549]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/dialog_install_later") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Install_Additional_Satellite_Screen_Image\"]")
	public MobileElement cancelButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/dialog_install_later']"),  //SKIP TUTORIAL
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[151,1374][929,1511]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/dialog_install_later") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Install_Additional_Satellite_Screen_Button_Later\"]")
	public MobileElement installLaterButton; 

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"I do not have a satellite\"]")
	public MobileElement dontHaveSatelliteLink;
	
	public InstallAdditionalSatellitePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickInstallLaterButton()
	{
		click(installLaterButton);
		utils.log().info("Install Additonal Satellite Dialog - Clicked on Install Later Button");
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
