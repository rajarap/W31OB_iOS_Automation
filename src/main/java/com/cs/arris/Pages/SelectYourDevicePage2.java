package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SelectYourDevicePage2 extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/need_help") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Screen_TitleLabel_SelectYourDeviceBelow\"]")
	public MobileElement selectYourDeviceMessage;
	
//	@AndroidFindAll({
//		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[404,511][464,571]']"),
//		@AndroidBy (xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.ImageView[2]")
//	})
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Select_Your_Device_Router_Selection_Screen_Image_deselect_mAX Pro AX11000\"]")
	public MobileElement selectYourDeviceMaxProAX11000RadioButton;
	
//	@AndroidFindAll({
//		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[884,511][944,571]']"),
//		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[2]/android.widget.RelativeLayout/android.widget.ImageView[2]")
//	})
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Select_Your_Device_Router_Selection_Screen_Image_deselect_mAX Plus AX7800\"]")
	public MobileElement selectYourDeviceMaxPlusAX7800RadioButton;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@bounds='[404,511][464,571]']") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Select_Your_Device_Router_Selection_Screen_Image_deselect_mAX AX6600\"]")
	public MobileElement selectYourDeviceMaxAX6600;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@bounds='[404,511][464,571]']") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Select_Your_Device_Router_Selection_Screen_Image_deselect_mAX Dash AC3800\"]")
	public MobileElement selectYourDeviceMaxDashAC3800;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/app_product_not_listing']") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Screen_Label_ThisAppSupportsTheProductsListedAbove\"]")
	public MobileElement selectYourDevicePlayStoreMessage;	
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/play_store_link]") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"App Store Link\"]")
	public MobileElement selectYourDevicePlayStoreLink;	

	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_selection_next"),
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_selection_next']"),
		@AndroidBy (xpath = "//android.widget.Button[@text='NEXT"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[119,1925][961,2042]']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")
	})
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Select_Your_Device_Screen_Button_Next\"]")
	public MobileElement selectYourDeviceNextButton;
	
	public SelectYourDevicePage2()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void selectMaxProAX11000RadioButton()
	{
		String selector = "**/XCUIElementTypeImage[`name == \"Select_Your_Device_Router_Selection_Screen_Image_deselect_mAX Pro AX11000\"`]";
		super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();
		utils.log().info("Select your Device 2 - Selected mAX Pro AX11000 option");
	}
	
	public void selectMaxProAX7800RadioButton()
	{
		String selector = "**/XCUIElementTypeImage[`name == \"Select_Your_Device_Router_Selection_Screen_Image_deselect_mAX Plus AX7800\"`]";
		super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();
		utils.log().info("Select your Device 2 - Selected mAX Pro AX7800 option");
	}
	public void clickNextButton()
	{
		if(selectYourDeviceNextButton.isEnabled())
		{
			click(selectYourDeviceNextButton);
			utils.log().info("Select your Device 2 - Clicked Next Button");
//		}else {
//			selectMaxProAX11000RadioButton();
//			clickNextButton();
		}
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}




