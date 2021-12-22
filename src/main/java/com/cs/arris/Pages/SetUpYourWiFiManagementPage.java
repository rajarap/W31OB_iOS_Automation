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

public class SetUpYourWiFiManagementPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btnGetStarted]"),  //GET STARTED
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1829][1019,1966]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btnGetStarted") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Home_Welcome_Screen_Button_GetStarted\"]")
	public MobileElement getStartedButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/btnskip]"),  //SKIP TUTORIAL
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[61,1829][1019,1966]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btnskip") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Home_Welcome_Screen_Button_SkipTutorial\"]")
	public MobileElement skipTutorialButton; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_getting_started") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_getting_started']") // text = SETUP YOUR Wi-Fi MANAGEMENT
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Home_Welcome_Screen_TitleLabel\"]")
	public MobileElement setupWifiManagementText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/description_add_satelite") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/description_add_satelite']") // text = You have successfully configured your router and home network
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Home_Welcome_Screen_SubTitleLabel\"]")
	public MobileElement setupWifiManagementMessage;
	
	public SetUpYourWiFiManagementPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickskipTutorialButton()
	{
		click(skipTutorialButton);
		utils.log().info("Setup Wifi Management Page - Clicked on Skip Tutorial Button");
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
