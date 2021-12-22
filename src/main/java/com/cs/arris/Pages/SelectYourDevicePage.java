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

public class SelectYourDevicePage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/need_help") 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Category_Screen_TitleLabel_SelectYourDeviceBelow\"]")
	public MobileElement selectYourDeviceMessage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/product_category_recycler_view") 
	public MobileElement selectYourDeviceOptions;  //contains both the product category options
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/radioButton_product_category_selection']"),
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[905,1079][965,1139]']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView")
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Select_Your_Device_Category_Screen_Image_deselect_SURFboard Mesh\"]")
	public MobileElement selectYourDeviceSurfboardMaxOption; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/radioButton_product_category_selection']"),
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[905,1369][965,1429]']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView")
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Select_Your_Device_Category_Screen_Image_deselect_SURFboard Gateway\"]")
	public MobileElement selectYourDeviceISBCableOption; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/app_help_selection") 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Category_Screen_Label_HelpMeWithTheSelection\"]")
	public MobileElement selectYourDeviceHelpMeWithSelection; 	
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_product_next"),
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_product_next']"),
		@AndroidBy (xpath = "//android.widget.Button[@text='NEXT"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[119,1925][961,2042]']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Select_Your_Device_Category_Screen_Button_Next\"]")
	public MobileElement selectYourDeviceNextButton; 
	
	
	
	public SelectYourDevicePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void selectSurfboardMaxOption()
	{
		click(selectYourDeviceSurfboardMaxOption);
		utils.log().info("Select your Device 1 - Selected SURFboard mAX option");
	}
	
	public void clickNextButton()
	{
		if(selectYourDeviceNextButton.isEnabled())
		{
			click(selectYourDeviceNextButton);
			utils.log().info("Select your Device 1 - Clicked Next Button");

		}else {
			selectSurfboardMaxOption();
			clickNextButton();
		}
	}

	@Override
	public boolean isAt() {
		if(selectYourDeviceNextButton.isDisplayed())
		{
			utils.log().info("At Select your Device Page");
			return true;
		}
		else
		{
			utils.log().info("Select your Device Page is not displayed");
			return false;
		}
	}
	
}
