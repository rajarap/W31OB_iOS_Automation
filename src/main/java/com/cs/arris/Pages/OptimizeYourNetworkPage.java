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

public class OptimizeYourNetworkPage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_placementTip")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label\"]")
	public MobileElement placementTips;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Placement_Tips_Network_Screen_TitleLabel\"]")
	public MobileElement helpYouOptimizeYourNetwork;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/description_text")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Placement_Tips_Network_Screen_SubTitleLabel\"]")
	public MobileElement stepsToOptimizeYourNetwork;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/need_help")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/helpme_button"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1880][1019,2017]']"),
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/helpme_button']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[1]") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Placement_Tips_Network_Screen_Button_Help\"]")
	public MobileElement helpMeOptimizeButton;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/skip_optimization"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,2017][1019,2042]']"),
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/skip_optimization']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Placement_Tips_Network_Screen_Button\"]")
	public MobileElement skipOptimizeButton;
	
	
	public OptimizeYourNetworkPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickSkipOptimizeButton()
	{
		click(skipOptimizeButton);
	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
