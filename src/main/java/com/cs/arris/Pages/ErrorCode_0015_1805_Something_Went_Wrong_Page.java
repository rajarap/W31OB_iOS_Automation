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

public class ErrorCode_0015_1805_Something_Went_Wrong_Page extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/btn_continue_onboarding]"),//CONTINUE ONBOARDING
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[61,1812][1019,1949]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_continue_onboarding") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Launch_Error_Screen_Button_ContinueOnboarding\"]")
	public MobileElement continueOnBoardingButton;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/btn_error_frag_retry]"),//TRY AGAIN
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[61,1983][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_error_frag_retry") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Launch_Error_Screen_Button_TryAgain\"]")
	public MobileElement tryAgainButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_description") 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label_Error\"]")
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_description']") // text = The mobile device cannot connect to your Router.
	public MobileElement mobileDeviceCannotConnectToRouter;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView") // text = 	
	//If you have previously installed the device, please connect your mobile device to the local Wi-Fi network. Click on "Try Again" to retry the connection to the device.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label\"]")
	public MobileElement connectMobileToLocalWifiText;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView") // text = 	
	//If you have completed performing a factory reset on the device, then Click on "Continue Onboarding" to reinstall the device.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label\"]")
	public MobileElement factoryResetOnDeviceText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_code") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_code']") // text = 0015-1805
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label_ErrorCode\"]")
	public MobileElement errorCode;  
	
	public ErrorCode_0015_1805_Something_Went_Wrong_Page()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickContinueOnboardingButton()
	{
		click(continueOnBoardingButton);
	}
	
	@Override
	public boolean isAt() {
		if(continueOnBoardingButton.isDisplayed())
		{
			utils.log().info("At Something Went Wrong Page displayed");
			return true;
		}
		else
		{
			utils.log().info("Something Went Wrong Page is not displayed");
			return false;
		}
			
	}
	

}
