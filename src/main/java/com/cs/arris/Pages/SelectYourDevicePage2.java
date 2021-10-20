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

public class SelectYourDevicePage2 extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/need_help") 
	public MobileElement helpIcon;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	public MobileElement selectYourDeviceMessage;
	
//	@AndroidFindBy (xpath = "//android.widget.ImageView[@bounds='[404,511][464,571]']") 
//	public MobileElement selectYourDeviceMaxProAX11000;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[404,511][464,571]']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.ImageView[2]")
	})
	public MobileElement selectYourDeviceMaxProAX11000RadioButton;
	
//	@AndroidFindBy (xpath = "//android.widget.ImageView[@bounds='[404,511][464,571]']") 
//	public MobileElement selectYourDeviceMaxPlusAX7800;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[884,511][944,571]']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.GridView/android.view.ViewGroup[2]/android.widget.RelativeLayout/android.widget.ImageView[2]")
	})
	public MobileElement selectYourDeviceMaxPlusAX7800RadioButton;
	
//	@AndroidFindBy (xpath = "//android.widget.ImageView[@bounds='[404,511][464,571]']") 
//	public MobileElement selectYourDeviceMaxAX6600;
	
//	@AndroidFindBy (xpath = "//android.widget.ImageView[@bounds='[404,511][464,571]']") 
//	public MobileElement selectYourDeviceMaxDashAC3800;
	
//	@AndroidFindBy (id = "com.arris.sbcBeta:id/app_product_not_listing']") 
//	public MobileElement selectYourDevicePlayStoreMessage;	
//	
//	@AndroidFindBy (id = "com.arris.sbcBeta:id/play_store_link]") 
//	public MobileElement selectYourDevicePlayStoreLink;	


	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_selection_next"),
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_selection_next']"),
		@AndroidBy (xpath = "//android.widget.Button[@text='NEXT"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[119,1925][961,2042]']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")
	})
	public MobileElement selectYourDeviceNextButton;
	
	public SelectYourDevicePage2()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void selectMaxProAX11000RadioButton()
	{
		click(selectYourDeviceMaxProAX11000RadioButton);
		utils.log().info("Select your Device 2 - Selected mAX Pro AX11000 option");

	}
	
	public void clickNextButton()
	{
		if(selectYourDeviceNextButton.isEnabled())
		{
			click(selectYourDeviceNextButton);
			utils.log().info("Select your Device 2 - Clicked Next Button");
		}else {
			selectMaxProAX11000RadioButton();
			clickNextButton();
		}
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}




