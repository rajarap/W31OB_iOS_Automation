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

public class NetworkLANSubnetDHCPRangeConfigurationPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	// ====================Network SSID Password
	// ===========================================
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

	// ==================== Network SSID Password
	// ===========================================

	// ==================== Guest Wi-Fi Network
	// ===========================================

	@AndroidFindBy(id = "com.arris.sbcBeta:id/guest_wifi_network_text")
	public MobileElement guestWifiNetworkLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/enable_guest_wifi_text")
	public MobileElement enableDisableGuestNetwork;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/pause_internet_enable_disable' and @checked='false']")
	public MobileElement disableGuestNetworkToggleButton;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/pause_internet_enable_disable' and @checked='true']")
	public MobileElement enableGuestNetworkToggleButton;

	// ==================== Guest Wi-Fi Network
	// ===========================================

	// ==================== Extended Wi-Fi Settings
	// ===========================================

	@AndroidFindBy(id = "com.arris.sbcBeta:id/extended_wifi_network_text")
	public MobileElement extendedWifiSettingsLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/extended_network_plus_icon")
	public MobileElement extendedWifiExpandIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/enable_wideband_wifi_text")
	public MobileElement fiveGHzWidebandModeLabel;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/wideband_network_enable_disable' and @checked='false']")
	public MobileElement disableWidebandModeToggleButton;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/wideband_network_enable_disable' and @checked='true']")
	public MobileElement enableWidebandModeToggleButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enables DFS (up to) 160MHz channels']")
	public MobileElement enableDFSLabel;

	// ==================== Extended Wi-Fi Settings
	// ===========================================

	// ==================== Network Settings
	// ===========================================

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

	// ==================== Network Settings
	// ===========================================

	public NetworkLANSubnetDHCPRangeConfigurationPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}
	
	public NetworkHelpPage getNetworkPageObject() {
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
	 
	public void clickBackButton() {
		try {
			if (backIcon.isDisplayed()) {
				click(backIcon);
				utils.log().info("Clicked on Back Button");
			}
		} catch (Exception e) {
			utils.log().info("Back Button is not displayed");
		}
	}

	public void clickHelpButton() {
		try {
			if (helpIcon.isDisplayed()) {
				click(helpIcon);
				utils.log().info("Clicked on Help Button");
			}
		} catch (Exception e) {
			utils.log().info("Help Button is not displayed");
		}
	}
	
	public void clickTestConnectionSpeedButton() {
		try {
			if (testMyConnectionSpeedButton.isDisplayed()) {
				click(testMyConnectionSpeedButton);
				utils.log().info("Clicked on Test Your Connection Speed button");
			}
		} catch (Exception e) {
			utils.log().info("Test Your Connection Speed button is not displayed");
		}
	}
	
	public void clickNetworkSettingsExpandButton()
	{
		try {
			if (networkSettingsExpandIcon.isDisplayed()) 
				click(networkSettingsExpandIcon);
		} catch (Exception e) {
			utils.log().info("Network Settings Expand Button is not displayed");
		}

	}
	
	public void clickGeneralSettings() {
		try {
			click(networkSettingsExpandIcon);
			if (generalSettingsLabel.isDisplayed()) {
				click(generalSettingsLabel);
				utils.log().info("Clicked on General Settings");
			}
		} catch (Exception e) {
			utils.log().info("General Settings Link is not displayed");
		}
	}
	
	public void clickWANSettings() {
		try {
			click(networkSettingsExpandIcon);
			if (wanSettingsLabel.isDisplayed()) {
				click(wanSettingsLabel);
				utils.log().info("Clicked on WAN Settings");
			}
		} catch (Exception e) {
			utils.log().info("WAN Settings Link is not displayed");
		}
	}
	
	public void clickLANSettings() {
		try {
			click(networkSettingsExpandIcon);
			if (lanSettingsLabel.isDisplayed()) {
				click(lanSettingsLabel);
				utils.log().info("Clicked on LAN Settings");
			}
		} catch (Exception e) {
			utils.log().info("LAN Settings Link is not displayed");
		}
	}
	
	public void clickDevicePrioritySettings() {
		try {
			click(networkSettingsExpandIcon);
			if (devicePrioritySettings.isDisplayed()) {
				click(devicePrioritySettings);
				utils.log().info("Clicked on Device Priority Settings");
			}
		} catch (Exception e) {
			utils.log().info("Device Priority Settings Link is not displayed");
		}
	}
	
	public void clickTimeZone() {
		try {
			click(timeZone);
			if (timeZone.isDisplayed()) {
				click(timeZone);
				utils.log().info("Clicked on Time Zone Settings");
			}
		} catch (Exception e) {
			utils.log().info("Time Zone Priority Settings Link is not displayed");
		}
	}

	public void verifyUIOnNetworkPage() {
		utils.log().info("                                     ");
		utils.log().info("**************************************");
		utils.log().info("Verifying UI Elements on Network Page ");
		utils.log().info("**************************************");
		try {
			if (networkTitle.isDisplayed())
				utils.log().info(networkTitle.getText() + " title text is displayed ");
		} catch (Exception e) {
			utils.log().info("Network title text is not displayed");
		}

		try {
			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
		} catch (Exception e) {
			utils.log().info("Back Icon is not displayed");
		}

		try {
			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
		} catch (Exception e) {
			utils.log().info("Help Icon is not displayed");
		}

		try {
			if (expandButton.isDisplayed())
				utils.log().info("Main WiFi expand button is displayed");
			click(expandButton);
		} catch (Exception e) {
			utils.log().info("Main WiFi expand button is not displayed");
		}

		try {
			if (networkNameSSIDLabel.isDisplayed() && ssidName.isDisplayed())
				utils.log().info(networkNameSSIDLabel.getText() + " : " + ssidName.getText());
		} catch (Exception e) {
			utils.log().info("Network SSID Name is not displayed");
		}

		try {
			if (passwordLabel.isDisplayed() && showPassword.isDisplayed())
				utils.log().info(passwordLabel.getText() + " : " + showPassword.getText());
		} catch (Exception e) {
			utils.log().info("SSID Password is not displayed");
		}

		try {
			if (showPasswordIcon.isDisplayed())
				utils.log().info("Show Password Icon is displayed ");
			click(expandButton);
		} catch (Exception e) {
			utils.log().info("Show Password Icon is not displayed");
		}

		try {
			if (guestWifiNetworkLabel.isDisplayed())
				utils.log().info(guestWifiNetworkLabel.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("Guest Wi-Fi label is not displayed");
		}

		try {
			if (enableDisableGuestNetwork.isDisplayed())
				utils.log().info(enableDisableGuestNetwork.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("Enable/disable Guest Network label is not displayed");
		}

		try {
			if (disableGuestNetworkToggleButton.isDisplayed())
				utils.log().info("Guest Newtork toggle button is disabled(OFF)");
			else
				utils.log().info("Guest Newtork toggle button is enabled(ON)");
		} catch (Exception e) {
			utils.log().info("Guest Network toggle button is not displayed");
		}

		try {
			if (extendedWifiExpandIcon.isDisplayed())
				utils.log().info("Extended WiFi Settings expand button is displayed");
			click(extendedWifiExpandIcon);
		} catch (Exception e) {
			utils.log().info("Extended WiFi Settings expand button is not displayed");
		}

		try {
			if (extendedWifiSettingsLabel.isDisplayed())
				utils.log().info(extendedWifiSettingsLabel.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("Extended Wi-Fi Settings label is not displayed");
		}

		try {
			if (fiveGHzWidebandModeLabel.isDisplayed())
				utils.log().info(fiveGHzWidebandModeLabel.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("5GHz Widebank Mode label is not displayed");
		}

		try {
			if (enableDFSLabel.isDisplayed())
				utils.log().info(enableDFSLabel.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("Enables DFS (up to) 160MHz channels label is not displayed");
		}

		try {
			if (disableWidebandModeToggleButton.isDisplayed())
				utils.log().info("Extended Wifi toggle button is disabled(OFF)");
			else
				utils.log().info("Extended Wifi toggle button is enabled(ON)");
			click(extendedWifiExpandIcon);
		} catch (Exception e) {
			utils.log().info("Extended Wifi toogle button is not displayed");
		}

		try {
			if (networkSettingsExpandIcon.isDisplayed())
				utils.log().info("Network Settings expand button is displayed");
			click(networkSettingsExpandIcon);
			new SwipeActions().swipeScreen(Direction.UP);
		} catch (Exception e) {
			utils.log().info("Network Settings expand button is not displayed");
		}

		try {
			if (networkSettingsLabel.isDisplayed())
				utils.log().info(networkSettingsLabel.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("Netowrk Settings label is not displayed");
		}

		try {
			if (lanIPAddressLabel.isDisplayed() && lanIPAddress.isDisplayed())
				utils.log().info(lanIPAddressLabel.getText() + " : " + lanIPAddress.getText());
		} catch (Exception e) {
			utils.log().info("LAN IP Address data is not displayed");
		}

		try {
			if (gatewayIPAddressLabel.isDisplayed() && gatewayIPAddress.isDisplayed())
				utils.log().info(gatewayIPAddressLabel.getText() + " : " + gatewayIPAddress.getText());
		} catch (Exception e) {
			utils.log().info("Gateway IP Address label is not displayed");
		}

		try {
			if (generalSettingsLabel.isDisplayed())
				utils.log().info(generalSettingsLabel.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("General Settings label is not displayed");
		}

		try {
			if (wanSettingsLabel.isDisplayed())
				utils.log().info(wanSettingsLabel.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("WAN Settings label is not displayed");
		}

		try {
			if (lanSettingsLabel.isDisplayed())
				utils.log().info(lanSettingsLabel.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("LAN Settings label is not displayed");
		}

		try {
			if (devicePrioritySettings.isDisplayed())
				utils.log().info(devicePrioritySettings.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("Device Priority Settings label is not displayed");
		}

		try {
			if (timeZone.isDisplayed())
				utils.log().info(timeZone.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("Time Zone label is not displayed");
		}

		try {
			if (gmt530.isDisplayed())
				utils.log().info(gmt530.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("Chennai, Kolkata, Mumbai, New Delhi (GMT+05:30) label is not displayed");
		}

		try {
			if (testMyConnectionSpeedButton.isDisplayed())
				utils.log().info(testMyConnectionSpeedButton.getText() + " button is displayed");
			click(networkSettingsExpandIcon);
		} catch (Exception e) {
			utils.log().info("Test My Connection Speed button is not displayed");
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
