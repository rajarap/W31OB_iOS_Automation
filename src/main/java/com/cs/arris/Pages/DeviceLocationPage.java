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

public class DeviceLocationPage  extends ParentClass implements Page
{
		TestUtils utils = new TestUtils();
	
		@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.android.permissioncontroller:id/permission_message']")
		public MobileElement accessDeviceLocationMessage;	
		
		
//		@AndroidFindAll({
//			@AndroidBy (id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button"),
//			@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']"),
//			@AndroidBy (xpath = "//android.widget.Button[@bounds='[64,1689][1016,1784]']"),
//			@AndroidBy (xpath = "//android.widget.Button[@text='While using the app']"),
//			@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
//		})
		@AndroidFindBy(xpath = "//android.widget.Button[@text='While using the app']")
		public MobileElement whileUsingTheAppLink;
		
		@AndroidFindAll({
			@AndroidBy (id = "com.android.permissioncontroller:id/permission_allow_one_time_button"),
			@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_one_time_button']"),
			@AndroidBy (xpath = "//android.widget.Button[@bounds='[64,1826][1016,1921]']"),
			@AndroidBy (xpath = "//android.widget.Button[@text='Only this time']"),
			@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[2]")
		})
		public MobileElement onlyThisTimeLink;
		
		@AndroidFindAll({
			@AndroidBy (id = "com.android.permissioncontroller:id/permission_deny_button"),
			@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']"),
			@AndroidBy (xpath = "//android.widget.Button[@bounds='[64,1963][1016,2042]']"),
			@AndroidBy (xpath = "//android.widget.Button[@text='Deny']"),
			@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[3]")
		})
		public MobileElement denyLink;
		
		//######################  DENY  ##############################
		
		//Click the Deny button - An alert window appears
		
		@AndroidFindBy (id = "android:id/message") //These permissions are mandatory for the application. Please allow access from App settings.
		public MobileElement denyPopUpMessage;
		
		@AndroidFindBy (id = "android:id/button1")
		public MobileElement denyPopUpOK;
		
		@AndroidFindBy (id = "android:id/button2")
		public MobileElement denyPopUpCancel;
			
		// alert Popup CANCEL goes back to the GrantPermissionsPage
		
		//alert Popup OK, displays the SBC APP Info Page
		
		//######################  DENY  ##############################
	
	public DeviceLocationPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public String getDeviceLocationMessage()
	{
		//utils.log().info("Grant Access Permissions Page Text : " + accessDeviceLocationMessage.getText());
		return accessDeviceLocationMessage.getText();
	}
	
	public String getWhileUsingTheAppLinkText()
	{
		return whileUsingTheAppLink.getText();
	}
	
	public String getOnlyThisTimeLinkText()
	{
		return onlyThisTimeLink.getText();
	}
	
	public String getDenyLinkText()
	{
		return denyLink.getText();
	}
	
	public void clickWhileUsingTheAppLink() 
	{
		click(whileUsingTheAppLink);
		utils.log().info("Device Location - Clicked " + whileUsingTheAppLink.getText());
	}
	
	public void clickOnlyThisTimeLink() 
	{
		click(onlyThisTimeLink);
		utils.log().info("Device Location - Clicked " + onlyThisTimeLink.getText());
	}
	
	public void clickDenyLink() 
	{
		click(denyLink);
		utils.log().info("Device Location - Clicked " + denyLink.getText());
	}
	
	@Override
	public boolean isAt() {
		if(onlyThisTimeLink.isDisplayed())
		{
			utils.log().info("At Device Location Page");
			return true;
		}
		else
		{
			utils.log().info("Device Location Page is not displayed");
			return false;
		}
	}
	
}
