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

public class NetworkWANIPConfigurationIPv6Page extends ParentClass implements Page {
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
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/radia_stateful' and @checked='true']")
	public MobileElement statefulRadioButtonChecked;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/radia_stateful' and @checked='false']")
	public MobileElement statefulRadioButtonUnChecked;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/radia_stateless' and @checked='true']")
	public MobileElement statelessRadioButtonChecked;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/radia_stateless' and @checked='false']")
	public MobileElement statelessRadioButtonUnChecked;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='IPV6 Address']")
	public MobileElement ipv6AddressLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/wan_ipv6_address_et' and @enabled='false']")
	public MobileElement ipv6Address;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='IPV6 Prefix Length']")
	public MobileElement ipv6PrefixLengthLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/ipv6_prefix_length_et' and @enabled='false']")
	public MobileElement ipv6PrefixLength;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gateway']")
	public MobileElement gatewayLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/default_gate_ip_address_et' and @enabled='false']")
	public MobileElement dhcp_gateway;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary DNS']")
	public MobileElement primaryDNSLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/dns_primary_ip_et' and @enabled='false']")
	public MobileElement dhcp_primaryDNS;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Secondary DNS']")
	public MobileElement secondayDNSLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/dns_secondary_ip_et' and @enabled='false']")
	public MobileElement dhcp_secondaryDNS;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/save_wan_ip_configure' and @enabled='false']")
	public MobileElement dhcp_saveChangesButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/save_wan_ip_configure' and @enabled='true']")
	public MobileElement static_saveChangesButton;


	public NetworkWANIPConfigurationIPv6Page() {
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
 	 
  	public NetworkWANIPConfigurationIPv4Page getNetworkWANIPConfigurationIPv4PageObject() {
 		NetworkWANIPConfigurationIPv4Page wanIPv4Configuration = new NetworkWANIPConfigurationIPv4Page();
		return wanIPv4Configuration;
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
	
	public void clickWANIPv4Tab() {
		try {
			if (wanIPv4Tab.isDisplayed()) {
				click(wanIPv4Tab);
				utils.log().info("Clicked on IPv4 Tab");
			}
		} catch (Exception e) {
			utils.log().info("IPv4 Tab is not displayed");
		}
	}
	
	public void clickSaveChangesButton_DHCP() {
		try {
			if (dhcp_saveChangesButton.isDisplayed() && dhcp_saveChangesButton.isEnabled()) {
				click(dhcp_saveChangesButton);
				utils.log().info("Clicked on SAVE CHANGES button");
			}
		} catch (Exception e) {
			utils.log().info("SAVE CHANGES button is displayed, but is disabled");
		}
	}
	
	public void clickSaveChangesButton_Static() {
		try {
			if (static_saveChangesButton.isDisplayed() && static_saveChangesButton.isEnabled()) {
				click(static_saveChangesButton);
				utils.log().info("Clicked on SAVE CHANGES button");
			}
		} catch (Exception e) {
			utils.log().info("SAVE CHANGES button is displayed, but is disabled");
		}
	}
	
	
	public void verifyUIOnWANIPv6Stateful() {
		utils.log().info("                                                    ");
		utils.log().info("****************************************************");
		utils.log().info("Verifying WAN IPv6 - Stateful Configuration Settings");
		utils.log().info("****************************************************");
		
	//	this.clickDHCPRadioButton();
		
		try {
			if (wanIPConfigurationTitle.isDisplayed())
				utils.log().info(wanIPConfigurationTitle.getText() + " title text is displayed ");
		} catch (Exception e) {
			utils.log().info("WAN IP Configuration title text is not displayed");
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
			if(wanIPv4Tab.isDisplayed() && wanIPv4Tab.isSelected())
				utils.log().info("IPv4 Tab is displayed and is currently selected");
		} catch (Exception e) {
			utils.log().info("IPv4 Tab is not displayed");
		}

		try {
			if (wanIPv6Tab.isDisplayed())
				utils.log().info("IPV6 Tab is displayed and is not selected");
		} catch (Exception e) {
			utils.log().info("IPV6 Tab is not displayed");
		}
		
		try {
			if (gatewayLabel.isDisplayed() && dhcp_gateway.isDisplayed() && !(dhcp_gateway.isEnabled()))
				utils.log().info(gatewayLabel.getText() + " : " + dhcp_gateway.getText());
		} catch (Exception e) {
			utils.log().info("Gateway details is not displayed");
		}
		
		try {
			if (primaryDNSLabel.isDisplayed() && dhcp_primaryDNS.isDisplayed() && !(dhcp_primaryDNS.isEnabled()))
				utils.log().info(primaryDNSLabel.getText() + " : " + dhcp_primaryDNS.getText());
		} catch (Exception e) {
			utils.log().info("Primary DNS details is not displayed");
		}
		
		try {
			if (secondayDNSLabel.isDisplayed() && dhcp_secondaryDNS.isDisplayed() && !(dhcp_secondaryDNS.isEnabled()))
				utils.log().info(secondayDNSLabel.getText() + " : " + dhcp_secondaryDNS.getText());
		} catch (Exception e) {
			utils.log().info("Secondary DNS details is not displayed");
		}
		
		try {
			if (dhcp_saveChangesButton.isDisplayed() && !(dhcp_saveChangesButton.isEnabled()))
				utils.log().info(dhcp_saveChangesButton.getText() + " button is displayed and is disabled");
		} catch (Exception e) {
			utils.log().info("SAVE CHANGES button is not displayed");
		}
	}
	
	public void verifyUIOnWANIPv6Stateless() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Verifying WAN IPv6 - Stateless Configuration Settings");
		utils.log().info("*****************************************************");
		
	//	this.clickStaticRadioButton();
		
		try {
			if (wanIPConfigurationTitle.isDisplayed())
				utils.log().info(wanIPConfigurationTitle.getText() + " title text is displayed ");
		} catch (Exception e) {
			utils.log().info("WAN IP Configuration title text is not displayed");
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
			if(wanIPv4Tab.isDisplayed() && wanIPv4Tab.isSelected())
				utils.log().info("IPv4 Tab is displayed and is currently selected");
		} catch (Exception e) {
			utils.log().info("IPv4 Tab is not displayed");
		}

		try {
			if (wanIPv6Tab.isDisplayed())
				utils.log().info("IPV6 Tab is displayed and is not selected");
		} catch (Exception e) {
			utils.log().info("IPV6 Tab is not displayed");
		}
		
		try {
			if (static_saveChangesButton.isDisplayed() && static_saveChangesButton.isEnabled())
				utils.log().info(static_saveChangesButton.getText() + " button is displayed and is Enabled");
		} catch (Exception e) {
			utils.log().info("SAVE CHANGES button is not displayed");
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
