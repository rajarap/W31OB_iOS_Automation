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
		
		@AndroidFindAll({
			@AndroidBy (id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button"),
			@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']"),
			@AndroidBy (xpath = "//android.widget.Button[@bounds='[64,1689][1016,1784]']"),
			@AndroidBy (xpath = "//android.widget.Button[@text='Deny']"),
			@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
		})
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
			@AndroidBy (xpath = "//android.widget.Button[@text='While using the app']"),
			@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[3]")
		})
		public MobileElement denyLink;
		
		//######################  DENY  ##############################
		
		//Click the Deny button - An alert window appears
		
		@AndroidFindBy (id = "android:id/message")
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
		utils.log().info("Grant Access Permissions Page - Device Location mini page");
		return accessDeviceLocationMessage.getText();
	}
	
	public String getWhileUsingTheAppLinkText()
	{
		utils.log().info("Grant Access Permissions Page - Device Location mini page - Retrieving While Using the App Text");
		return whileUsingTheAppLink.getText();
	}
	
	public String getOnlyThisTimeLinkText()
	{
		utils.log().info("Grant Access Permissions Page - Device Location mini page - Retrieving Only This Time Text");
		return onlyThisTimeLink.getText();
	}
	
	public String getDenyLinkText()
	{
		utils.log().info("Grant Access Permissions Page - Device Location mini page - Retrieving Deny Text");
		return denyLink.getText();
	}
	
	public void clickWhileUsingTheAppLink() 
	{
		utils.log().info("Clicking While Using The App Link on Grant Access Permissions Mini Page");
		click(whileUsingTheAppLink);
	}
	
	public void clickOnlyThisTimeLink() 
	{
		utils.log().info("Clicking Only This Time Link on Grant Access Permissions Mini Page");
		click(onlyThisTimeLink);
	}
	
	public void clickDenyLink() 
	{
		utils.log().info("Clicking Deny Link on Grant Access Permissions Mini Page");
		click(denyLink, "Clicking Deny Link on Grant Access Permissions Mini Page");
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
