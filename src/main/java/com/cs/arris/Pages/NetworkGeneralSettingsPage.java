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

public class NetworkGeneralSettingsPage extends ParentClass implements Page {

	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement generalSettingsTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/upnp_text")
	public MobileElement upnpLabel;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/upnp_enable_disable' and @checked='false']")
	public MobileElement disableUPNPToggleButton;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/upnp_enable_disable' and @checked='true']")
	public MobileElement enableUPNPToggleButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/upnp_info_icon")
	public MobileElement upnpInfoIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bridge Mode']")
	public MobileElement bridgeModeLabel;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/bridge_mode_enable_disable' and @checked='false']")
	public MobileElement disableBridgeModeToggleButton;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/bridge_mode_enable_disable' and @checked='true']")
	public MobileElement enableBridgeModeToggleButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/bridge_mode_info_icon")
	public MobileElement bridgeModeInfoIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/port_frwd_text")
	public MobileElement portForwardingLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ipv6_txt")
	public MobileElement ipv6EnableLabel;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/ipv6_enable_enable_disable' and @checked='false']")
	public MobileElement disableIPv6ToggleButton;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/ipv6_enable_enable_disable' and @checked='true']")
	public MobileElement enableIPv6ToggleButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ipv6_enable_info_icon")
	public MobileElement ipv6InfoIcon;

	public NetworkGeneralSettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public NetworkGeneralSettingsHelpPage getNetworkGeneralSettingsHelpPageObject() {
		NetworkGeneralSettingsHelpPage networkGeneralHelpPage = new NetworkGeneralSettingsHelpPage();
		return networkGeneralHelpPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public NetworkGeneralSettingsUPnPInfoDialog getNetworkGeneralSettingsUPnPInfoDialogObject() {
		NetworkGeneralSettingsUPnPInfoDialog networkGeneralUPnpInfo = new NetworkGeneralSettingsUPnPInfoDialog();
		return networkGeneralUPnpInfo;
	}

	public NetworkGeneralSettingsBridgeModeInfoDialog getNetworkGeneralSettingsBridgeModeInfoDialogObject() {
		NetworkGeneralSettingsBridgeModeInfoDialog networkGeneralBridgeModeInfo = new NetworkGeneralSettingsBridgeModeInfoDialog();
		return networkGeneralBridgeModeInfo;
	}

	public NetworkGeneralSettingsIPv6EnableInfoDialog getNetworkGeneralSettingsIPv6EnableInfoDialogObject() {
		NetworkGeneralSettingsIPv6EnableInfoDialog networkGeneralIPv6Info = new NetworkGeneralSettingsIPv6EnableInfoDialog();
		return networkGeneralIPv6Info;
	}

	public NetworkGeneralSettingsPortForwardingPage getNetworkGeneralSettingsPortForwardingPageObject() {
		NetworkGeneralSettingsPortForwardingPage portForwarding = new NetworkGeneralSettingsPortForwardingPage();
		return portForwarding;
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

	public boolean clickPortForwardingink() {
		if (portForwardingLabel.isDisplayed()) {
			click(portForwardingLabel);
			return true;
		} else {
			utils.log().info("WAN IP Configuration Link is not displayed");
			return false;
		}
	}

	public boolean clickUPNPInfoIcon() {
		if (upnpInfoIcon.isDisplayed()) {
			click(upnpInfoIcon);
			utils.log().info("Clicked on UPnP Info Icon");
			return true;
		} else {
			utils.log().info("LAC Link is not displayed");
			return false;
		}
	}

	public boolean clickBridgeModeInfoIcon() {
		if (bridgeModeInfoIcon.isDisplayed()) {
			click(bridgeModeInfoIcon);
			utils.log().info("Clicked on Bridge Mode Info Icon");
			return true;
		} else {
			utils.log().info("LAC Link is not displayed");
			return false;
		}
	}

	public boolean clickIPv6InfoIcon() {
		if (ipv6InfoIcon.isDisplayed()) {
			click(ipv6InfoIcon);
			utils.log().info("Clicked on IPv6 Info Icon");
			return true;
		} else {
			utils.log().info("LAC Link is not displayed");
			return false;
		}
	}

	public boolean enableUPnP() {
		if (enableUPNPToggleButton.isDisplayed()) {
			utils.log().info("UPnP is already enabled");
			return true;
		} else if (disableUPNPToggleButton.isDisplayed()) {
			click(disableUPNPToggleButton);
			utils.log().info("UPnP is turned ON");
			return true;
		} else {
			utils.log().info("UPnP toggle switch button is not displayed");
			return false;
		}
	}

	public boolean disableUPnP() {
		if (disableUPNPToggleButton.isDisplayed()) {
			utils.log().info("UPnP is already disabled");
			return true;
		} else if (enableUPNPToggleButton.isDisplayed()) {
			click(enableUPNPToggleButton);
			utils.log().info("UPnP is turned OFF");
			return true;
		} else {
			utils.log().info("UPnP toggle switch button is not displayed");
			return false;
		}
	}

	public boolean enableBridgeMode() {
		if (enableBridgeModeToggleButton.isDisplayed()) {
			utils.log().info("Bridge Mode is already enabled");
			return true;
		} else if (disableBridgeModeToggleButton.isDisplayed()) {
			click(disableBridgeModeToggleButton);
			utils.log().info("Bridge Mode is turned ON");
			return true;
		} else {
			utils.log().info("Bridge Mode toggle switch button is not displayed");
			return false;
		}
	}

	public boolean disableBridgeMode() {
		if (disableBridgeModeToggleButton.isDisplayed()) {
			utils.log().info("Bridge Mode is already disabled");
			return true;
		} else if (enableBridgeModeToggleButton.isDisplayed()) {
			click(enableBridgeModeToggleButton);
			utils.log().info("Bridge Mode is turned OFF");
			return true;
		} else {
			utils.log().info("Bridge Mode toggle switch button is not displayed");
			return false;
		}
	}

	public boolean enableIPV6Enable() {
		if (enableIPv6ToggleButton.isDisplayed()) {
			utils.log().info("IPv6 Enableis already enabled");
			return true;
		} else if (disableIPv6ToggleButton.isDisplayed()) {
			click(disableIPv6ToggleButton);
			utils.log().info("IPv6 Enable is turned ON");
			return true;
		} else {
			utils.log().info("IPv6 Enable toggle switch button is not displayed");
			return false;
		}
	}

	public boolean disableIPv6Enable() {
		if(disableIPv6ToggleButton.isDisplayed()) {
			utils.log().info("IPv6 Enable is already disabled");
			return true;
		} else if (enableIPv6ToggleButton.isDisplayed()) {
			click(enableIPv6ToggleButton);
			utils.log().info("IPv6 Enable is turned OFF");
			return true;
		} else {
			utils.log().info("IPv6 Enable toggle switch button is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnGeneralSettingsPage() {
		utils.log().info("                                                         ");
		utils.log().info("*********************************************************");
		utils.log().info("Verifying UI Elements on Network - General Settings Page ");
		utils.log().info("*********************************************************");

		try {
			if (generalSettingsTitle.isDisplayed())
				utils.log().info(generalSettingsTitle.getText() + " title text is displayed ");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");

			if (upnpLabel.isDisplayed())
				utils.log().info("UPnP Link is displayed");

			if (disableUPNPToggleButton.isDisplayed() && !(disableUPNPToggleButton.isEnabled()))
				utils.log().info("UPnp toggle button is displayed but is disabled(OFF)");
			else
				utils.log().info("UPnp toggle button is displayed and is enabled(ON)");

			if (upnpInfoIcon.isDisplayed())
				utils.log().info("UPnP Info Icon is displayed");

			if (bridgeModeLabel.isDisplayed())
				utils.log().info("Bridge Mode Link is displayed");

			if (disableBridgeModeToggleButton.isDisplayed() && !(disableBridgeModeToggleButton.isEnabled()))
				utils.log().info("Bridge Mode toggle button is displayed but is disabled(OFF)");
			else
				utils.log().info("Bridge Mode toggle button is displayed and is enabled(ON)");

			if (bridgeModeInfoIcon.isDisplayed())
				utils.log().info("Bridge Mode Info Icon is displayed");

			if (portForwardingLabel.isDisplayed())
				utils.log().info("Port Forwarding Link is displayed ");

			if (ipv6EnableLabel.isDisplayed())
				utils.log().info("IPv6 Enable is displayed");

			if (disableIPv6ToggleButton.isDisplayed() && !(disableIPv6ToggleButton.isEnabled()))
				utils.log().info("IPv6 Enable toggle button is displayed but is disabled(OFF)");
			else
				utils.log().info("IPv6 Enable toggle button is displayed and is enabled(ON)");

			if (ipv6InfoIcon.isDisplayed())
				utils.log().info("IPv6 Enable Info Icon is displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (generalSettingsTitle.isDisplayed()) {
			utils.log().info("On General Settings Page");
			return true;
		} else {
			utils.log().info("Not on General Settings Page");
			return false;
		}
	}
}
