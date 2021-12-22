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

public class ConnectMaxRouterToMobileDevicePage extends ParentClass implements Page
{
public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text']") // text = SUCCESSFULLY CONNECTED
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Succesfully_Connected_Screen_TitleLabel\"]")
	public MobileElement successfullyConnectedText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_description_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_description_text']") // text = Your mAX router is now connected to your mobile device.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Succesfully_Connected_Screen_SubTitleLabel\"]")
	public MobileElement maxRouterConnectedToMobileDeviceText;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_bluetooth_pairing_success_Continue']"), // text = NEXT
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1915][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_bluetooth_pairing_success_Continue") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA_Succesfully_Connected_Screen_Button\"]")
	public MobileElement nextButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/btn_generic_error_retry")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Error_Screen_Button\"]")
	public MobileElement tryAgainButton;
	
	public boolean getTryAgainButton()
	{
		if (tryAgainButton.isDisplayed())
			return true;
		else 
			return false;
	}
	
	public ConnectMaxRouterToMobileDevicePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickNextButton()
	{
		click(nextButton);
		utils.log().info("Connecting mAX Router to Mobile Device Page - Clicked on Next Button");
	}
	
	public void clickTryAgainButton()
	{
		click(tryAgainButton);
		utils.log().info("Router Failed to Connect To Internet- Clicked on Try Again Button");
	}

	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
