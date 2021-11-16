package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

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

public class NetworkWANSettingsPage extends ParentClass implements Page {
	
	public TestUtils utils = new TestUtils();
	public SoftAssert wanAssert = new SoftAssert();
	public int z = 10;
	//public SoftAssert softAssert = new SoftAssert();

	// ====================Network SSID Password
	// ===========================================
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement wanSettingsTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='WAN IP Configuration']")
	public MobileElement wanIPConfigurationLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='LAC']")
	public MobileElement lacLabel; //Link Aggregation Control
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/lac_info_icon")
	public MobileElement lacAlertIcon;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/lac_enable_disable' and @checked='false']")
	public MobileElement disableLACToggleButton;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/lac_enable_disable' and @checked='true']")
	public MobileElement enableLACToggleButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='DNS Configuration']")
	public MobileElement dnsConfigurationLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/renew_wan_dhcp_btn")
	public MobileElement wanIPRenewButton;

	// ==================== Network Settings
	// ===========================================

	public NetworkWANSettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}
	
	public NetworkWANSettingsHelpPage getNetworkWanSettingsHelpPageObject() {
		NetworkWANSettingsHelpPage networkWANHelpPage = new NetworkWANSettingsHelpPage();
		return networkWANHelpPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

 	 public AppRatingDialog getAppRatingPageObject() {
		 AppRatingDialog rating = new AppRatingDialog();
	     return rating;
	  }
 	 
 	 public NetworkWANIPConfigurationIPv4Page getWANIPv4ConfigurationPageObject() {
 		NetworkWANIPConfigurationIPv4Page wanIPv4Config = new NetworkWANIPConfigurationIPv4Page();
	     return wanIPv4Config;
	  }
	  
 	 public NetworkWANIPConfigurationIPv6Page getWANIPv6ConfigurationPageObject() {
 		NetworkWANIPConfigurationIPv6Page wanIPv6Config = new NetworkWANIPConfigurationIPv6Page();
	     return wanIPv6Config;
	  }
 	 
 	 public NetworkWANDNSConfigurationIPv4Page getWANDNSIPv4ConfigurationPageObject() {
 		NetworkWANDNSConfigurationIPv4Page wanDNSIPv4Config = new NetworkWANDNSConfigurationIPv4Page();
	     return wanDNSIPv4Config;
	  }
 	 
 	 public NetworkWANDNSConfigurationIPv6Page getWANDNSIPv6ConfigurationPageObject() {
 		NetworkWANDNSConfigurationIPv6Page wanDNSIPv6Config = new NetworkWANDNSConfigurationIPv6Page();
	     return wanDNSIPv6Config;
	  }
 	 
 	 public NetworkLACConfigurationAlertDialog getLACAlertDialogObject() {
 		NetworkLACConfigurationAlertDialog lacAlert = new NetworkLACConfigurationAlertDialog();
	     return lacAlert;
	  }
 	 
	public void clickBackButton() {
		try {
			if (backIcon.isDisplayed()) {
				click(backIcon);
				utils.log().info("Clicked on Back Button");
			}else
				wanAssert.assertFalse(backIcon.isDisplayed(), "Back Button is not displayed");
		} catch (Exception e) {
			utils.log().info("Back Button is not displayed");
		}
	}

	public void clickHelpButton() {
		try {
			if (helpIcon.isDisplayed()) {
				click(helpIcon);
				utils.log().info("Clicked on Help Button");
			}else
				wanAssert.assertFalse(helpIcon.isDisplayed(), "Help Button is not displayed");
		} catch (Exception e) {
			utils.log().info("Help Button is not displayed");
		}
		wanAssert.assertAll();
	}
	
	public void clickWANIPRenewButton() {
		try {
			if (wanIPRenewButton.isDisplayed()) {
				click(wanIPRenewButton);
				utils.log().info("Clicked on WAN IP Renew button");
			}else
				wanAssert.assertFalse(wanIPRenewButton.isDisplayed(), "WAN IP Renew button is not displayed");
		} catch (Exception e) {
			utils.log().info("WAN IP Renew button is not displayed");
		}
		wanAssert.assertAll();
	}
	
	public void clickWANIPConfigurationLink()
	{
		try {
			if (wanIPConfigurationLabel.isDisplayed()) 
				click(wanIPConfigurationLabel);
			else
				wanAssert.assertFalse(wanIPConfigurationLabel.isDisplayed(), "WAN IP Configuration Link is not displayed");
		} catch (Exception e) {
			utils.log().info("WAN IP Configuration Link is not displayed");
		}
		wanAssert.assertAll();
	}
	
	public void clickLACLink() {
		try {
			if (lacLabel.isDisplayed()) {
				click(lacLabel);
				utils.log().info("Clicked on LAC Link");
			}else
				wanAssert.assertFalse(lacLabel.isDisplayed(), "LAC Link is not displayed");
		} catch (Exception e) {
			utils.log().info("LAC Link is not displayed");
		}
	}
	
	public void clickLacAlertIcon() {
		try {
			if (lacAlertIcon.isDisplayed()) {
				click(lacAlertIcon);
				utils.log().info("Clicked on LAC Alert Icon");
			}else
				wanAssert.assertFalse(lacAlertIcon.isDisplayed(), "LAC Alert Icon is not displayed");
		} catch (Exception e) {
			utils.log().info("LAC Alert Icon is not displayed");
		}
	}
	
	public void clickDNSConfigurationLink() {
		try {
			if (dnsConfigurationLabel.isDisplayed()) {
				click(dnsConfigurationLabel);
				utils.log().info("Clicked on DNS Configuration Link");
			}else
				wanAssert.assertFalse(dnsConfigurationLabel.isDisplayed(), "DNS Configuration Link is not displayed");
		} catch (Exception e) {
			utils.log().info("DNS Configuration Link is not displayed");
		}
		wanAssert.assertAll();
	}
	
	public void verifyUIOnWANSettingsPage() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Verifying UI Elements on Network - WAN Settings Page ");
		utils.log().info("*****************************************************");
		try {
			if (wanSettingsTitle.isDisplayed())
				utils.log().info(wanSettingsTitle.getText() + " title text is displayed ");
			else
				wanAssert.assertFalse(wanSettingsTitle.isDisplayed(), "WAN Settings title text is not displayed");
		} catch (Exception e) {
			utils.log().info("WAN Settings title text is not displayed");
		}

		try {
			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				wanAssert.assertFalse(backIcon.isDisplayed(), "Back Icon is not displayed");
		} catch (Exception e) {
			utils.log().info("Back Icon is not displayed");
		}

		try {
			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				wanAssert.assertFalse(helpIcon.isDisplayed(), "Help Icon is not displayed");
		} catch (Exception e) {
			utils.log().info("Help Icon is not displayed");
		}

		try {
			if(wanIPConfigurationLabel.isDisplayed())
				utils.log().info("WAN IP Configuration Link is displayed");
			else
				wanAssert.assertFalse(wanIPConfigurationLabel.isDisplayed(), "WAN IP Configuration Link is not displayed");
		} catch (Exception e) {
			utils.log().info("WAN IP Configuration Link is not displayed");
		}

		try {
			if (lacLabel.isDisplayed())
				utils.log().info("LAC Link is displayed");
			else
				wanAssert.assertFalse(lacLabel.isDisplayed(), "LAC Link is not displayed");
		} catch (Exception e) {
			utils.log().info("LAC Link is not displayed");
		}

		try {
			if (dnsConfigurationLabel.isDisplayed())
				utils.log().info("DNS Configuration Link is displayed ");
			else
				wanAssert.assertFalse(dnsConfigurationLabel.isDisplayed(), "DNS Configuration Link is not displayed");
		} catch (Exception e) {
			utils.log().info("DNS Configuration Link is not displayed");
		}

		try {
			if (disableLACToggleButton.isDisplayed() && !(disableLACToggleButton.isEnabled()))
				utils.log().info("LAC toggle button is displayed but is disabled(OFF)");
			else if(disableLACToggleButton.isDisplayed() && disableLACToggleButton.isEnabled())
				utils.log().info("LAC toggle button is displayed and is enabled(ON)");
			else
				wanAssert.assertFalse(disableLACToggleButton.isDisplayed(), "Guest Network toggle button is not displayed");
		} catch (Exception e) {
			utils.log().info("Guest Network toggle button is not displayed");
		}

		try {
			if (wanIPRenewButton.isDisplayed())
				utils.log().info(wanIPRenewButton.getText() + " button is displayed");
			else
				wanAssert.assertFalse(wanIPRenewButton.isDisplayed(), "WAN IP RENEW button is not displayed");
		} catch (Exception e) {
			utils.log().info("WAN IP RENEW button is not displayed");
		}
	}

	@Override
	public boolean isAt() {
		if (wanSettingsTitle.isDisplayed()) {
			utils.log().info("On WAN Settings Page");
			return true;
		} else {
			utils.log().info("Not on WAN Settings Page");
			return false;
		}
	}
}
