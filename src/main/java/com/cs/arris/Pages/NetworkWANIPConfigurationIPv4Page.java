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

public class NetworkWANIPConfigurationIPv4Page extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement wanIPConfigurationTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ipv4_btn")
	public MobileElement wanIPv4Tab;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ipv6_btn")
	public MobileElement wanIPv6Tab;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/dhcp_btn' and @checked='true']")
	public MobileElement dhcpRadioButtonChecked;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/dhcp_btn' and @checked='false']")
	public MobileElement dhcpRadioButtonUnChecked;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/static_btn' and @checked='true']")
	public MobileElement staticRadioButtonChecked;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/static_btn' and @checked='false']")
	public MobileElement staticRadioButtonUnChecked;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='IP Address']")
	public MobileElement ipAddressLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/wan_ip_address_et' and @enabled='false']")
	public MobileElement dhcp_ipAddress;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/wan_ip_address_et' and @enabled='true']")
	public MobileElement static_ipAddress;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Subnet Mask']")
	public MobileElement subnetMaskLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/subnet_mask_et' and @enabled='false']")
	public MobileElement dhcp_subnetMask;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/subnet_mask_et' and @enabled='true']")
	public MobileElement static_subnetMask;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gateway']")
	public MobileElement gatewayLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/default_gate_ip_address_et' and @enabled='false']")
	public MobileElement dhcp_gateway;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/default_gate_ip_address_et' and @enabled='true']")
	public MobileElement static_gateway;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary DNS']")
	public MobileElement primaryDNSLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/dns_primary_ip_et' and @enabled='false']")
	public MobileElement dhcp_primaryDNS;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/dns_primary_ip_et' and @enabled='true']")
	public MobileElement static_primaryDNS;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Secondary DNS']")
	public MobileElement secondayDNSLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/dns_secondary_ip_et' and @enabled='false']")
	public MobileElement dhcp_secondaryDNS;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/dns_secondary_ip_et' and @enabled='true']")
	public MobileElement static_secondaryDNS;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/save_wan_ip_configure' and @enabled='false']")
	public MobileElement dhcp_saveChangesButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/save_wan_ip_configure' and @enabled='true']")
	public MobileElement static_saveChangesButton;


	public NetworkWANIPConfigurationIPv4Page() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public NetworkWANIPConfigurationHelpPage getNetworkWANIPConfigurationHelpPageObject() {
		NetworkWANIPConfigurationHelpPage wanIPConfiguration = new NetworkWANIPConfigurationHelpPage();
		return wanIPConfiguration;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

 	 public AppRatingDialog getAppRatingPageObject() {
		 AppRatingDialog rating = new AppRatingDialog();
	     return rating;
	  }
 	 
 	public NetworkWANIPConfigurationIPv6Page getNetworkWANIPConfigurationIPv6PageObject() {
 		NetworkWANIPConfigurationIPv6Page wanIPv6Configuration = new NetworkWANIPConfigurationIPv6Page();
		return wanIPv6Configuration;
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

	public boolean clickWANIPv6Tab() {
		if (wanIPv6Tab.isDisplayed()) {
			click(wanIPv6Tab);
			utils.log().info("Clicked on IPv6 Tab");
			return true;
		} else {
			utils.log().info("IPv6 Tab is not displayed");
			return false;
		}
	}
	
	public boolean clickSaveChangesButton_DHCP() {
		if (dhcp_saveChangesButton.isDisplayed() && dhcp_saveChangesButton.isEnabled()) {
			click(dhcp_saveChangesButton);
			utils.log().info("Clicked on SAVE CHANGES button");
			return true;
		} else {
			utils.log().info("SAVE CHANGES button is displayed, but is disabled");
			return false;
		}
	}
	
	public boolean clickSaveChangesButton_Static() {
		if (static_saveChangesButton.isDisplayed() && static_saveChangesButton.isEnabled()) {
			click(static_saveChangesButton);
			utils.log().info("Clicked on SAVE CHANGES button");
			return true;
		} else {
			utils.log().info("SAVE CHANGES button is displayed, but is disabled");
			return false;
		}
	}
	
	public boolean clickDHCPRadioButton() {
		if (dhcpRadioButtonChecked.isDisplayed()) {
			utils.log().info("DHCP Radion button is already selected");
			return true;
		}else if(dhcpRadioButtonUnChecked.isDisplayed()) {
			click(dhcpRadioButtonUnChecked);
			utils.log().info("Clicked on DHCP Radion button");
			return true;
		} else {
			utils.log().info("DHCP Radio button is not displayed");
			return false;
		}
	}
	
	public boolean clickStaticRadioButton() {
		if (staticRadioButtonUnChecked.isDisplayed()) {
			click(staticRadioButtonUnChecked);
			utils.log().info("Static Radio button is selected");
			return true;
		}else if(staticRadioButtonChecked.isDisplayed()) {
			utils.log().info("Static Radio button is already selected");
			return true;
		} else {
			utils.log().info("Static Radio button is not displayed");
			return false;
		}
	}
	
	public boolean verifyUIOnWANIPv4DHCP() {
		utils.log().info("                                                ");
		utils.log().info("************************************************");
		utils.log().info("Verifying WAN IPv4 - DHCP Configuration Settings");
		utils.log().info("************************************************");
		
		this.clickDHCPRadioButton();
		try {
			if (wanIPConfigurationTitle.isDisplayed())
				utils.log().info(wanIPConfigurationTitle.getText() + " title text is displayed ");
			else
				utils.log().info("WAN IP Configuration title text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");

			if (wanIPv4Tab.isDisplayed())
				utils.log().info("IPv4 Tab is displayed and is currently selected");
			else
				utils.log().info("IPv4 Tab is not displayed");

			if (wanIPv6Tab.isDisplayed())
				utils.log().info("IPV6 Tab is displayed and is not selected");
			else
				utils.log().info("IPV6 Tab is not displayed");

			if (dhcpRadioButtonChecked.isDisplayed())
				utils.log().info("DHCP Radio button is displayed and is selected");
			else
				utils.log().info("DHCP Radio button is not displayed");

//		try {
//			if (dhcpRadioButtonUnChecked.isDisplayed())
//				utils.log().info("DHCP Radio button is displayed and is not selected ");
//		} catch (Exception e) {
//			utils.log().info("DHCP Radio button is not displayed");
//		}

			if (ipAddressLabel.isDisplayed() && dhcp_ipAddress.isDisplayed() && !(dhcp_ipAddress.isEnabled()))
				utils.log().info(ipAddressLabel.getText() + " : " + dhcp_ipAddress.getText());
			else
				utils.log().info("IP Address details is not displayed");

			if (subnetMaskLabel.isDisplayed() && dhcp_subnetMask.isDisplayed() && !(dhcp_subnetMask.isEnabled()))
				utils.log().info(subnetMaskLabel.getText() + " : " + dhcp_subnetMask.getText());
			else
				utils.log().info("Subnet Mask details is not displayed");

			if (gatewayLabel.isDisplayed() && dhcp_gateway.isDisplayed() && !(dhcp_gateway.isEnabled()))
				utils.log().info(gatewayLabel.getText() + " : " + dhcp_gateway.getText());
			else
				utils.log().info("Gateway details is not displayed");

			if (primaryDNSLabel.isDisplayed() && dhcp_primaryDNS.isDisplayed() && !(dhcp_primaryDNS.isEnabled()))
				utils.log().info(primaryDNSLabel.getText() + " : " + dhcp_primaryDNS.getText());
			else
				utils.log().info("Primary DNS details is not displayed");

			if (secondayDNSLabel.isDisplayed() && dhcp_secondaryDNS.isDisplayed() && !(dhcp_secondaryDNS.isEnabled()))
				utils.log().info(secondayDNSLabel.getText() + " : " + dhcp_secondaryDNS.getText());
			else
				utils.log().info("Secondary DNS details is not displayed");

			if (dhcp_saveChangesButton.isDisplayed() && !(dhcp_saveChangesButton.isEnabled()))
				utils.log().info(dhcp_saveChangesButton.getText() + " button is displayed but is disabled");
			else
				utils.log().info("SAVE CHANGES button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean verifyUIOnWANIPv4Static() {
		utils.log().info("                                                  ");
		utils.log().info("**************************************************");
		utils.log().info("Verifying WAN IPv4 - Static Configuration Settings");
		utils.log().info("**************************************************");
		
		this.clickStaticRadioButton();

		try {
			if (wanIPConfigurationTitle.isDisplayed())
				utils.log().info(wanIPConfigurationTitle.getText() + " title text is displayed ");
			else
				utils.log().info("WAN IP Configuration title text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");

			if(wanIPv4Tab.isDisplayed())
				utils.log().info("IPv4 Tab is displayed and is currently selected");
			else
				utils.log().info("IPv4 Tab is not displayed");

			if (wanIPv6Tab.isDisplayed())
				utils.log().info("IPV6 Tab is displayed and is not selected");
			else
				utils.log().info("IPV6 Tab is not displayed");

			if (staticRadioButtonChecked.isDisplayed())
				utils.log().info("Static Radio button is displayed and is selected");
			else
				utils.log().info("Static Radio button is not displayed");

//		try {
//			if (staticRadioButtonUnChecked.isDisplayed())
//				utils.log().info("Static Radio button is displayed and is not selected ");
//		} catch (Exception e) {
//			utils.log().info("Static Radio button is displayed and is already selected");
//		}
		
			if (ipAddressLabel.isDisplayed() && static_ipAddress.isDisplayed() && static_ipAddress.isEnabled())
				utils.log().info(ipAddressLabel.getText() + " : " + static_ipAddress.getText());
			else
			utils.log().info("IP Address details is not displayed");

			if (subnetMaskLabel.isDisplayed() && static_subnetMask.isDisplayed() && static_subnetMask.isEnabled())
				utils.log().info(subnetMaskLabel.getText() + " : " + static_subnetMask.getText());
			else
			utils.log().info("Subnet Mask details is not displayed");

			if (gatewayLabel.isDisplayed() && static_gateway.isDisplayed() && static_gateway.isEnabled())
				utils.log().info(gatewayLabel.getText() + " : " + static_gateway.getText());
			else
			utils.log().info("Gateway details is not displayed");

			if (primaryDNSLabel.isDisplayed() && static_primaryDNS.isDisplayed() && static_primaryDNS.isEnabled())
				utils.log().info(primaryDNSLabel.getText() + " : " + static_primaryDNS.getText());
			else
			utils.log().info("Primary DNS details is not displayed");

			if (secondayDNSLabel.isDisplayed() && static_secondaryDNS.isDisplayed() && static_secondaryDNS.isEnabled())
				utils.log().info(secondayDNSLabel.getText() + " : " + static_secondaryDNS.getText());
			else
			utils.log().info("Secondary DNS details is not displayed");

			if (static_saveChangesButton.isDisplayed() && static_saveChangesButton.isEnabled())
				utils.log().info(static_saveChangesButton.getText() + " button is displayed and is Enabled");
			else
			utils.log().info("SAVE CHANGES button is not displayed");
			return true;
		}catch(	Exception e){
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (wanIPConfigurationTitle.isDisplayed()) {
			utils.log().info("On WAN IPv4 Configuration Page");
			return true;
		} else {
			utils.log().info("Not on WAN IPv4 Configuration Page");
			return false;
		}
	}
}
