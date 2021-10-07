package com.cs.arris.Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GrantPermissionsPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/need_help") 
	public MobileElement helpIcon;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txt_welcome_two_title") 
	public MobileElement grantAccessPermissionMessage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txt_welcome_two_description") 
	public MobileElement accessToResourcesMessage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txt_welcome_two_location") 
	public MobileElement locationMessage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/img_welcome_two_location_icon") 
	public MobileElement locationIcon;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[3]") 
	public MobileElement locationText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txt_welcome_two_storage") 
	public MobileElement storageMessage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/img_welcome_two_storage_icon") 
	public MobileElement storageIcon;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[5]") 
	public MobileElement storageText;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[8]") 
	public MobileElement phoneMessage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/img_welcome_two_phone_icon") 
	public MobileElement phoneIcon;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[5]") 
	public MobileElement phoneText;

	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_fragment_permission_continue']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[112,1966][968,2042]']")
	})
	public MobileElement continueButton;
	

	
	//######################  While Using this app  ##############################

	@AndroidFindBy (id = "com.android.permissioncontroller:id/permission_message")
	public MobileElement whileUsingThisAppPopUpMessage;
	
	@AndroidFindBy (id = "com.android.permissioncontroller:id/permission_allow_button")
	public MobileElement whileUsingThisAppPopUpAllowLink;	//Click allow - Select the below device screen should appear
	
	@AndroidFindBy (id = "com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button")
	public MobileElement whileUsingThisAppPopUpDenyLink;
	
	//######################  While Using this app  ##############################
	
	
	
	
	//######################  Only this time  ##############################
	
	//######################  Only this time  ##############################
	
	public GrantPermissionsPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean VerifyHelpIcon()
	{
		utils.log().info("Grant Access Permissions Page - Is Help icon displayed");
		if (helpIcon.isDisplayed())
			return true;
		else
			return false;
	}
	
	public String getGrantAccessPermissionMessage()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Grant Access Permission Message");
		return grantAccessPermissionMessage.getText();
	}
	
	public String getAccessToResourceMessage()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Grant Access To Resource Message");
		return accessToResourcesMessage.getText();
	}
	
	public String getLocationMessage()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Location Message");
		return locationMessage.getText();
	}
	
	public String getLocationText()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Location Text");
		return locationText.getText();
	}
	
	public boolean VerifyLocationIcon()
	{
		utils.log().info("Grant Access Permissions Page - Is Location icon displayed");
		if (locationIcon.isDisplayed())
			return true;
		else
			return false;
	}
	
	public String getStorageMessage()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Storage Access Message");
		return storageMessage.getText();
	}
	
	public String getStorageText()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Storage Message");
		return storageText.getText();
	}
	
	public boolean VerifyStorageIcon()
	{
		utils.log().info("Grant Access Permissions Page - is Storge icon displayed");
		if (storageIcon.isDisplayed())
			return true;
		else
			return false;
	}
	
	public String getPhoneMessage()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Phone Message");
		return phoneMessage.getText();
	}
	
	public String getPhoneText()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Phone Text");
		return phoneText.getText();
	}
	
	public boolean VerifyPhoneIcon()
	{
		utils.log().info("Grant Access Permissions Page - is Phone icon displayed");
		if (phoneIcon.isDisplayed())
			return true;
		else
			return false;
	}
	
	public String getContinueButtonText()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Continue Button Text");
		return continueButton.getText();
	}
	
	public void clickContinueButton() 
	{
			click(continueButton);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
