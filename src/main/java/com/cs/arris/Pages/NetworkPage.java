package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

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

public class NetworkPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement networkTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/main_wifi_plus_icon")
	public MobileElement expandButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Network Name (SSID)']")
	public MobileElement networkNameSSIDLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/main_wifi_ssid")
	public MobileElement ssidName;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/main_wifi_ssid")
	public MobileElement editSSIDName;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Password']")
	public MobileElement passwordLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/main_wifi_password_show_hide")
	public MobileElement showPasswordIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/main_wifi_password")
	public MobileElement showPassword;



	@AndroidFindBy(id = "com.arris.sbcBeta:id/guest_wifi_network_text")
	public MobileElement guestWifiNetworkLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/enable_guest_wifi_text")
	public MobileElement enableDisableGuestNetwork;

//	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/guest_network_enable_disable' and @checked='false']")
//	public MobileElement disableGuestNetworkToggleButton;
//
//	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/guest_network_enable_disable' and @checked='true']")
//	public MobileElement enableGuestNetworkToggleButton;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/guest_network_enable_disable']")
	public MobileElement guestNetworkToggleButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/guest_network_plus_icon")
	public MobileElement guestNetworkExpandIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Network Name (SSID)']")
	public MobileElement guestNetworkSIDLabel;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/guest_network_wifi_ssid")
	public MobileElement guestNetworkSSIDName;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Password']")
	public MobileElement guestNetworkPasswordLabel;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/guest_network_wifi_password")
	public MobileElement guestNetworkPassword;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/guest_network_password_show_hide")
	public MobileElement guestNetworkShowPasswordIcon;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/guest_network_wifi_edit_icon")
	public MobileElement guestNetworkEditIcon;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/share_guest_network")
	public MobileElement guestNetworkShareCredentialsButton;
	

	@AndroidFindBy(id = "com.arris.sbcBeta:id/extended_wifi_network_text")
	public MobileElement extendedWifiSettingsLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/extended_network_plus_icon")
	public MobileElement extendedWifiExpandIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/enable_wideband_wifi_text")
	public MobileElement fiveGHzWidebandModeLabel;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/wideband_info_icon")
	public MobileElement fiveGHzWidebandInfoIcon;
	
//	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/wideband_network_enable_disable' and @checked='false']")
//	public MobileElement disableWidebandModeToggleButton;
//
//	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/wideband_network_enable_disable' and @checked='true']")
//	public MobileElement enableWidebandModeToggleButton;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/wideband_network_enable_disable']")
	public MobileElement widebandModeToggleButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enables DFS (up to) 160MHz channels']")
	public MobileElement enableDFSLabel;



	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Network Settings']")
	public MobileElement networkSettingsLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/network_setting_plus_icon")
	public MobileElement networkSettingsExpandIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='LAN IP Address']")
	public MobileElement lanIPAddressLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/lan_ip_address_close")
	public MobileElement lanIPAddress;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gateway IP Address']")
	public MobileElement gatewayIPAddressLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/geteway_ip_address_close")
	public MobileElement gatewayIPAddress;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='General Settings']")
	public MobileElement generalSettingsLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='WAN Settings']")
	public MobileElement wanSettingsLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='LAN Settings']")
	public MobileElement lanSettingsLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Device Priority Settings']")
	public MobileElement devicePrioritySettings;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Time Zone']")
	public MobileElement timeZone;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/time_zone_data")
	public MobileElement gmt530;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/speed_test_view")
	public MobileElement testMyConnectionSpeedButton;


	public NetworkPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public NetworkHelpPage getNetworkHelpPageObject() {
		NetworkHelpPage networkHelpPage = new NetworkHelpPage();
		return networkHelpPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public SpeedTestPage getSpeedTestPageObject() {
		SpeedTestPage speedTestPage = new SpeedTestPage();
		return speedTestPage;
	}

	public AppRatingDialog getAppRatingPageObject() {
		AppRatingDialog rating = new AppRatingDialog();
		return rating;
	}

	public NetworkWANSettingsPage getWANSettingsPageObject() {
		NetworkWANSettingsPage wanSettings = new NetworkWANSettingsPage();
		return wanSettings;
	}

	public NetworkLANSettingsPage getLANSettingsPageObject() {
		NetworkLANSettingsPage lanSettings = new NetworkLANSettingsPage();
		return lanSettings;
	}
	
	public Network5GHzWidebandModeInfoDialog get5GHzWidebandModeDialogObject() {
		Network5GHzWidebandModeInfoDialog widebandMode = new Network5GHzWidebandModeInfoDialog();
		return widebandMode;
	}
	
	public Network5GHzWidebandModeAlertDialog get5GHzWidebandModeAlertDialogObject() {
		Network5GHzWidebandModeAlertDialog widebandModeAlert = new Network5GHzWidebandModeAlertDialog();
		return widebandModeAlert;
	}
	
	public NetworkEnableGuestNetworkDialog getEnableGuestNetworkDialogObject() {
		NetworkEnableGuestNetworkDialog guestNetwork = new NetworkEnableGuestNetworkDialog();
		return guestNetwork;
	}
	
	public NetworkEditGuestNetworkDialog getEditGuestNetworkDialogObject() {
		NetworkEditGuestNetworkDialog editGuestNetwork = new NetworkEditGuestNetworkDialog();
		return editGuestNetwork;
	}
		
	public NetworkEnableGuestNetworkAlertDialog getEnableGuestNetworkAlertDialogObject() {
		NetworkEnableGuestNetworkAlertDialog guestNetworkalert = new NetworkEnableGuestNetworkAlertDialog();
		return guestNetworkalert;
	}
	
	
	public NetworkDevicePrioritySettings getNetworkDevicePrioritySettingsPageObject() {
		NetworkDevicePrioritySettings widebandMode = new NetworkDevicePrioritySettings();
		return widebandMode;
	}
	
	public NetworkTimeZoneSettingsPage getTimeZoneSettingsPageObject() {
		NetworkTimeZoneSettingsPage timeZone = new NetworkTimeZoneSettingsPage();
		return timeZone;
	}
	
	public NetworkGeneralSettingsPage getGeneralSettingsPageObject() {
		NetworkGeneralSettingsPage generalSettings = new NetworkGeneralSettingsPage();
		return generalSettings;
	}
	
	
	public boolean clickBackButton() {
		if (backIcon.isDisplayed()) {
			click(backIcon);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			utils.log().info("Back Button is not displayed");
			return false;
		}
	}

	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			return true;
		} else {
			utils.log().info("Help button is not displayed");
			return false;
		}
	}

	public boolean clickTestConnectionSpeedButton() {
		if (testMyConnectionSpeedButton.isDisplayed()) {
			click(testMyConnectionSpeedButton);
			utils.log().info("Clicked on Test Your Connection Speed button");
			return true;
		} else {
			utils.log().info("Test Your Connection Speed button is not displayed");
			return false;
		}
	}
	
	public boolean clickExtendedWifiSettingsExpandButton() {
		if (extendedWifiExpandIcon.isDisplayed()) {
			click(extendedWifiExpandIcon);
			return true;
		} else {
			utils.log().info("Extended Wifi Settings Expand Button is not displayed");
			return false;
		}
	}

	public boolean clickNetworkSettingsExpandButton() {
		if (networkSettingsExpandIcon.isDisplayed()) {
			click(networkSettingsExpandIcon);
			return true;
		}else {
			utils.log().info("Network Settings Expand Button is not displayed");
			return false;
		}
	}
	
	public boolean clickGuestNetworkExpandButton() {
		if (guestNetworkExpandIcon.isDisplayed()) {
			click(guestNetworkExpandIcon);
			return true;
		}else {
			utils.log().info("Guest Network Expand Button is not displayed");
			return false;
		}
	}
	
	public boolean clickGuestNetworkShowPasswordButton() {
		if (guestNetworkShowPasswordIcon.isDisplayed()) {
			click(guestNetworkShowPasswordIcon);
			return true;
		}else {
			utils.log().info("Show Password Icon is not displayed");
			return false;
		}
	}
	
	public boolean clickGuestNetworkEditdButton() {
		if (guestNetworkEditIcon.isDisplayed()) {
			click(guestNetworkEditIcon);
			return true;
		}else {
			utils.log().info("Edit Icon is not displayed");
			return false;
		}
	}
	
	public boolean clickfiveGHzWidebandInfoIcon() {
		if (fiveGHzWidebandInfoIcon.isDisplayed()) {
			click(fiveGHzWidebandInfoIcon);
			utils.log().info("Clicked on 5GHz Wideband Info Icon");
			return true;
		} else {
			utils.log().info("5GHz Wideband Mode Info Icon is not displayed");
			return false;
		}
	}
	
	public boolean enable5GHzWidebandMode() {
		if (widebandModeToggleButton.isSelected()) {
			utils.log().info("5GHz Wideband Mode is already enabled");
			return true;
		} else {
			click(widebandModeToggleButton);
			utils.log().info("5GHz Wideband Mode is now enabled");
			return true;
		}
	}

	public boolean disable5GHzWidebandMode() {
		if (!(widebandModeToggleButton.isSelected())) {
			utils.log().info("5GHz Wideband Mode is already disabled");
			return true;
		} else {
			click(widebandModeToggleButton);
			utils.log().info("5GHz Wideband Mode is now disabled");
			return true;
		}
	}
	
	public boolean enableGuestWifiNetwork() {
		if (guestNetworkToggleButton.isSelected()) {
			utils.log().info("Enable/Disable Guest Network is already enabled");
			return true;
		}else {
			click(guestNetworkToggleButton);
			super.pause(20);
			utils.log().info("Enable/Disable Guest Network is now enabled");
			return true;
		}
	}

	public boolean disableGuestWifiNetwork() {
		if (!(guestNetworkToggleButton.isSelected())) {
			utils.log().info("Enable/Disable Guest Network is already disabled");
			return true;
		} else {
			click(guestNetworkToggleButton);
			super.pause(20);
			utils.log().info("Enable/Disable Guest Network is now disabled");
			return true;
		}
	}

	public boolean clickGeneralSettings() {
		if (generalSettingsLabel.isDisplayed()) {
			click(generalSettingsLabel);
			utils.log().info("Clicked on General Settings");
			return true;
		} else {
			utils.log().info("General Settings Link is not displayed");
			return false;
		}
	}

	public boolean clickWANSettings() {
		if (wanSettingsLabel.isDisplayed()) {
			click(wanSettingsLabel);
			utils.log().info("Clicked on WAN Settings");
			return true;
		} else {
			utils.log().info("WAN Settings Link is not displayed");
			return false;
		}
	}

	public boolean clickLANSettings() {
		if (lanSettingsLabel.isDisplayed()) {
			click(lanSettingsLabel);
			utils.log().info("Clicked on LAN Settings");
			return true;
		} else {
			utils.log().info("LAN Settings Link is not displayed");
			return false;
		}
	}

	public boolean clickDevicePrioritySettings() {
		super.swipeUp();
		if (devicePrioritySettings.isDisplayed()) {
			click(devicePrioritySettings);
			super.pause(35);
			utils.log().info("Clicked on Device Priority Settings");
			return true;
		} else {
			utils.log().info("Device Priority Settings Link is not displayed");
			return false;
		}
	}

	public boolean clickTimeZone() {
		if (timeZone.isDisplayed()) {
			click(timeZone);
			utils.log().info("Clicked on Time Zone Settings");
			return true;
		} else {
			utils.log().info("Time Zone Priority Settings Link is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnNetworkPage() {
		utils.log().info("                                     ");
		utils.log().info("**************************************");
		utils.log().info("Verifying UI Elements on Network Page ");
		utils.log().info("**************************************");
		try {
			if (networkTitle.isDisplayed())
				utils.log().info(networkTitle.getText() + " title text is displayed ");
			else
				utils.log().info("Network title text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");

			if (expandButton.isDisplayed()) {
				utils.log().info("Main WiFi expand button is displayed");
				click(expandButton);} 
			else
				utils.log().info("Main WiFi expand button is not displayed");

			if (networkNameSSIDLabel.isDisplayed() && ssidName.isDisplayed())
				utils.log().info(networkNameSSIDLabel.getText() + " : " + ssidName.getText());
			else
				utils.log().info("Network SSID Name is not displayed");

			if (passwordLabel.isDisplayed() && showPassword.isDisplayed())
				utils.log().info(passwordLabel.getText() + " : " + showPassword.getText());
			else
				utils.log().info("SSID Password is not displayed");

			if (showPasswordIcon.isDisplayed()) {
				utils.log().info("Show Password Icon is displayed ");
				click(expandButton);}
			else
				utils.log().info("Show Password Icon is not displayed");

			if (guestWifiNetworkLabel.isDisplayed())
				utils.log().info(guestWifiNetworkLabel.getText() + " label is displayed");
			else
				utils.log().info("Guest Wi-Fi label is not displayed");

			if (enableDisableGuestNetwork.isDisplayed())
				utils.log().info(enableDisableGuestNetwork.getText() + " label is displayed");
			else
				utils.log().info("Enable/disable Guest Network label is not displayed");
			
			try {
				if (!(guestNetworkToggleButton.isSelected()))
					utils.log().info("Guest Newtork toggle button is disabled");
			}catch(Exception e) {utils.log().info("Guest Newtork toggle button is enabled");}
			
			try {
				if (guestNetworkExpandIcon.isDisplayed()) 
				{
					utils.log().info("Guest Newtork expand button is displayed");
					click(guestNetworkExpandIcon);
					if (guestNetworkSIDLabel.isDisplayed())
						utils.log().info(guestNetworkSIDLabel.getText() + " label is displayed");
					else
						utils.log().info("Network Name (SSID) label is not displayed");

					if (guestNetworkSSIDName.isDisplayed())
						utils.log().info("Guest Newtork SSID Name is : " + guestNetworkSSIDName.getText());
					else
						utils.log().info("uest Newtork SSID Name is not displayed");
					
					if (guestNetworkPasswordLabel.isDisplayed())
						utils.log().info(guestNetworkPasswordLabel.getText() + " label is displayed");
					else
						utils.log().info("PAssword label is not displayed");
	
					if (guestNetworkPassword.isDisplayed())
						utils.log().info("Guest Newtork SSID Password is : " + guestNetworkPassword.getText());
					else
						utils.log().info("uest Newtork SSID Name is not displayed");

					if (guestNetworkShowPasswordIcon.isDisplayed()) {
						utils.log().info("Show Password Icon is displayed");
						click(guestNetworkShowPasswordIcon);
						click(guestNetworkShowPasswordIcon);}  //1
					else
						utils.log().info("Show Password Icon is not displayed");
					
					if (guestNetworkEditIcon.isDisplayed())
						utils.log().info("Edit Icon is displayed");
					else
						utils.log().info("Edit Icon is not displayed");
					
					if (guestNetworkShareCredentialsButton.isDisplayed())
						utils.log().info("SHARE CREDENTIALS button is displayed");
					else
						utils.log().info("SHARE CREDENTIALS button is not displayed");		
					
						click(guestNetworkExpandIcon);
					}  
				}catch(Exception e) {utils.log().info("Guest Newtork Settings expand button is not displayed");}
			

			if (extendedWifiExpandIcon.isDisplayed()) {
				utils.log().info("Extended WiFi Settings expand button is displayed");
				click(extendedWifiExpandIcon);}  //1
			else
				utils.log().info("Extended WiFi Settings expand button is not displayed");

			if (extendedWifiSettingsLabel.isDisplayed())
				utils.log().info(extendedWifiSettingsLabel.getText() + " label is displayed");
			else
				utils.log().info("Extended Wi-Fi Settings label is not displayed");

			if (fiveGHzWidebandModeLabel.isDisplayed())
				utils.log().info(fiveGHzWidebandModeLabel.getText() + " label is displayed");
			else
				utils.log().info("5GHz Widebank Mode label is not displayed");

			if (enableDFSLabel.isDisplayed())
				utils.log().info(enableDFSLabel.getText() + " label is displayed");
			else
				utils.log().info("Enables DFS (up to) 160MHz channels label is not displayed");
			
			try {
				if (!(widebandModeToggleButton.isDisplayed()))
					utils.log().info("Extended Wifi toggle button is disabled");
			}catch(Exception e) {utils.log().info("Extended Wifi toggle button is enabled");}
			
			click(extendedWifiExpandIcon); //2

			if (networkSettingsExpandIcon.isDisplayed()) {
				utils.log().info("Network Settings expand button is displayed");
				click(networkSettingsExpandIcon);	//1
				super.swipeUp();}
			else
				utils.log().info("Network Settings expand button is not displayed");

			if (networkSettingsLabel.isDisplayed())
				utils.log().info(networkSettingsLabel.getText() + " label is displayed");
			else
				utils.log().info("Netowrk Settings label is not displayed");

			if (lanIPAddressLabel.isDisplayed() && lanIPAddress.isDisplayed())
				utils.log().info(lanIPAddressLabel.getText() + " : " + lanIPAddress.getText());
			else
				utils.log().info("LAN IP Address data is not displayed");

			if (gatewayIPAddressLabel.isDisplayed() && gatewayIPAddress.isDisplayed())
				utils.log().info(gatewayIPAddressLabel.getText() + " : " + gatewayIPAddress.getText());
			else
				utils.log().info("Gateway IP Address label is not displayed");

			if (generalSettingsLabel.isDisplayed())
				utils.log().info(generalSettingsLabel.getText() + " label is displayed");
			else
				utils.log().info("General Settings label is not displayed");

			if (wanSettingsLabel.isDisplayed())
				utils.log().info(wanSettingsLabel.getText() + " label is displayed");
			else
				utils.log().info("WAN Settings label is not displayed");

			if (lanSettingsLabel.isDisplayed())
				utils.log().info(lanSettingsLabel.getText() + " label is displayed");
			else
				utils.log().info("LAN Settings label is not displayed");

			if (devicePrioritySettings.isDisplayed())
				utils.log().info(devicePrioritySettings.getText() + " label is displayed");
			else
				utils.log().info("Device Priority Settings label is not displayed");

			if (timeZone.isDisplayed())
				utils.log().info(timeZone.getText() + " label is displayed");
			else
				utils.log().info("Time Zone label is not displayed");

			if (gmt530.isDisplayed())
				utils.log().info(gmt530.getText() + " label is displayed");
			else
				utils.log().info("Chennai, Kolkata, Mumbai, New Delhi (GMT+05:30) label is not displayed");

			click(networkSettingsExpandIcon); //2
			
			if (testMyConnectionSpeedButton.isDisplayed()) {
				utils.log().info(testMyConnectionSpeedButton.getText() + " button is displayed");
			} else
				utils.log().info("Test My Connection Speed button is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (networkTitle.isDisplayed()) {
			utils.log().info("On Network Page");
			return true;
		} else {
			utils.log().info("Not on Network Page");
			return false;
		}
	}
}
