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

public class AccessResourcesOnDevicePage extends ParentClass implements Page
{
	TestUtils utils = new TestUtils();

	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.android.permissioncontroller:id/permission_message']")
	public MobileElement accessResourcesMessage;	
		
//	@AndroidFindAll({
//		@AndroidBy (id = "com.android.permissioncontroller:id/permission_allow_button"),
//		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']"),
//		@AndroidBy (xpath = "//android.widget.Button[@bounds='[64,1826][1016,1921]"),
//		@AndroidBy (xpath = "//android.widget.Button[@text='Allow']"),
//		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
//	})
	@AndroidFindBy (xpath = "//android.widget.Button[@text='Allow']")
	public MobileElement allowLink;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.android.permissioncontroller:id/permission_deny_button"),
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[64,1963][1016,2042]"),
		@AndroidBy (xpath = "//android.widget.Button[@text='Deny']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[2]")
	})
	public MobileElement denyLink;
	
	public AccessResourcesOnDevicePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void clickAllowLink() 
	{
		click(allowLink);
		utils.log().info("Access Resources On Device - Clicked on Allow Link");
	}

	public void clickDenyLink() 
	{
		click(denyLink);
		utils.log().info("Access Resources On Device - Clicked on Deny Link");
	}
	
	@Override
	public boolean isAt() {
		if(allowLink.isDisplayed())
		{
			utils.log().info("At Access Resource On Device Page");
			return true;
		}
		else
		{
			utils.log().info("Access Resource On Device Page is not displayed");
			return false;
		}
	}

}
