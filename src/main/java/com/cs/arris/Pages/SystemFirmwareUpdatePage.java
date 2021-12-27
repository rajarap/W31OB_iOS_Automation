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

public class SystemFirmwareUpdatePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btnContinue']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1926][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btnContinue") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA_Your_System_Uptodate_Screen_Button\"]")
	public MobileElement nextButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text']") // text = YOUR SYSTEM IS UP TO DATE
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Your_System_Uptodate_Screen_TitleLabel\"]")
	public MobileElement systemUpToDate;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_description_text") 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Your_System_Uptodate_Screen_SubTitleLabel\"]")
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_description_text']") // text = Your system has the latest software version AXR.0335.201111.12 . No update is needed at this time.
	public MobileElement firmwareUpdateMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Error_Screen_Button\"]")
	public MobileElement continueButton;
	
	public SystemFirmwareUpdatePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickNextButton()
	{
		utils.log().info("System Firmware Update Page - Clicked on Next Button");
		click(nextButton);
	}
	
	public void clickContinueButton()
	{
		utils.log().info("Warranty and Support Page - Clicked on Continue Button");
		click(continueButton);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}

