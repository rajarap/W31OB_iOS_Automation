package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NetworkEnableGuestNetworkDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/network_cancel_dialog")
	public MobileElement closeButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/network_header_dialog") 
	public MobileElement enableGuestNetworkTitle;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/network_message") 
	public MobileElement enableGuestNetworkDescription;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ssid_name_title_tv") 
	public MobileElement networkSSIDNameLabel;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ssid_name_value_et") 
	public MobileElement enterNetworkSSIDNameTextBox;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ssid_password_title_tv") 
	public MobileElement passwordLabel;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ssid_password_value_et") 
	public MobileElement enterPasswordTextBox;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/show_hide_password_iv") 
	public MobileElement showHidePasswordIcon;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/tv_security_type_title") 
	public MobileElement securityTypeLabel;
	
	@AndroidFindBy(id = "android:id/text1") 
	public MobileElement securityTypeText;  //WPA2-PSK (AES)
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/network_save_dialog") 
	public MobileElement saveChangesButton;
	
	
	public NetworkEnableGuestNetworkDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void clickCloseButton() {
		try {
			if (closeButton.isDisplayed()) {
				click(closeButton);
				utils.log().info("Clicked on Close Button");}
		} catch (Exception e) {
			utils.log().info("Close button is not displayed");
		}
	}
	
	public void clickSaveChangesButton() {
		try {
			if (saveChangesButton.isDisplayed()) {
				click(saveChangesButton);
				utils.log().info("Clicked on Save Changes Button");}
		} catch (Exception e) {
			utils.log().info("Save Changes button is not displayed");
		}
	}

	public boolean verifyUIOnNetworkPage() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Verifying UI Elements on Enable Guest Network Dialog ");
		utils.log().info("*****************************************************");
		try {
			if (enableGuestNetworkTitle.isDisplayed())
				utils.log().info(enableGuestNetworkTitle.getText() + " title text is displayed ");
			else
				utils.log().info("Enable Guest Network title text is not displayed");

			if (closeButton.isDisplayed())
				utils.log().info("Close Icon is displayed ");
			else
				utils.log().info("Close Icon is not displayed");

			if (enableGuestNetworkDescription.isDisplayed()) 
				utils.log().info("Enable Guest Netowrk Description is displayed");
			else
				utils.log().info("Enable Guest Netowrk Description is not displayed");
			
			if (networkSSIDNameLabel.isDisplayed())
				utils.log().info("Network SSID label is displayed");
			else
				utils.log().info("Network SSID label is not displayed");

			if (enterNetworkSSIDNameTextBox.isDisplayed())
				utils.log().info("Text Box to enter Network SSID is displayed");
			else
				utils.log().info("Text Box to enter Network SSID is not displayed");
			
			if (passwordLabel.isDisplayed()) 
				utils.log().info("Password label is displayed");
			else
				utils.log().info("Password label is not displayed");
			
			if (enterPasswordTextBox.isDisplayed())
				utils.log().info("Text Box to enter Password is displayed");
			else
				utils.log().info("Text Box to enter Password is not displayed");

			if (showHidePasswordIcon.isDisplayed()) {
				utils.log().info("Show Password Icon is displayed ");
			} else
				utils.log().info("Show Password Icon is not displayed");
			
			if (securityTypeLabel.isDisplayed()) 
				utils.log().info("Security Type label is displayed");
			else
				utils.log().info("Security Type label is not displayed");
			
			if (securityTypeText.isDisplayed())
				utils.log().info("Security Type - WPA2-PSK (AES) - is displayed");
			else
				utils.log().info("Security Type - WPA2-PSK (AES) - is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public boolean isAt() {
		if (enableGuestNetworkTitle.isDisplayed()) {
			utils.log().info("On Enable Guest Network Dialog");
			return true;
		} else {
			utils.log().info("Not on Enable Guest Network Dialog");
			return false;
		}
	}
}
