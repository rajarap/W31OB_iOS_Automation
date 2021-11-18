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
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='IPV6 Gateway']")
	public MobileElement ipv6GatewayLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/default_gate_ipv6_address_et' and @enabled='false']")
	public MobileElement ipv6Gateway;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary DNS']")
	public MobileElement ipv6PrimaryDNSLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/dns_primary_ipv6_et' and @enabled='false']")
	public MobileElement ipv6PrimaryDNS;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Secondary DNS']")
	public MobileElement ipv6SecondayDNSLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/dns_secondary_ipv6_et' and @enabled='false']")
	public MobileElement ipv6SecondaryDNS;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Prefix Delegation']")
	public MobileElement ipv6PrefixDelegationLabel;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/prefix_chk' and @checked='false']")
	public MobileElement ipv6PrefixDelegationCheckbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/save_wan_ipv6_configure' and @enabled='false']")
	public MobileElement stateful_SaveChangesButton_Disabled;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/save_wan_ipv6_configure' and @enabled='true']")
	public MobileElement stateful_SaveChangesButton_Enabled;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/save_wan_ip_configure' and @enabled='true']")
	public MobileElement stateless_SaveChangesButton;


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
	
	public void clickStatefulSaveChangesButton() {
		try {
			if (stateful_SaveChangesButton_Enabled.isDisplayed() ) {
				click(stateful_SaveChangesButton_Enabled);
				utils.log().info("Clicked on Steteful SAVE CHANGES button");
			}
		} catch (Exception e) {
			utils.log().info("Stateful SAVE CHANGES button is displayed, but is disabled");
		}
	}
	
	public void clickStatelessSaveChangesButton() {
		try {
			if (stateless_SaveChangesButton.isDisplayed() && stateless_SaveChangesButton.isEnabled()) {
				click(stateless_SaveChangesButton);
				utils.log().info("Clicked on Stateless SAVE CHANGES button");
			}
		} catch (Exception e) {
			utils.log().info("Stateless SAVE CHANGES button is displayed, but is disabled");
		}
	}
	
	public void clickStatelessRadioButton() {
		try {
			if (statelessRadioButtonUnChecked.isDisplayed()) {
				click(statelessRadioButtonUnChecked);
				utils.log().info("Clicked on Stateless Radio button");
			}
		} catch (Exception e) {
			utils.log().info("Stateless Radio button is not displayed");
		}
	}
	
	public void clickStatefulRadioButton() {
		try {
			if (statefulRadioButtonUnChecked.isDisplayed()) {
				click(statefulRadioButtonUnChecked);
				utils.log().info("Clicked on Stateful Radio button");
			}
		} catch (Exception e) {
			utils.log().info("Stateful Radio button is not displayed");
		}
	}
	
	public void clickPrefixDelegationCheckbox() {
		try {
			if (ipv6PrefixDelegationCheckbox.isDisplayed()) {
				click(ipv6PrefixDelegationCheckbox);
				if(stateful_SaveChangesButton_Enabled.isDisplayed())
				{
					utils.log().info("SAVE CHANGES button is enabled on click of Prefix Delegation Checkbox");
				}
				utils.log().info("Selected Prefix Delegation Checkbox");
			}
		} catch (Exception e) {
			utils.log().info("Prefix Delegation Checkbox is not displayed");
		}
	}
	
	
	public void verifyUIOnWANIPv6Stateful() {
		utils.log().info("                                                    ");
		utils.log().info("****************************************************");
		utils.log().info("Verifying WAN IPv6 - Stateful Configuration Settings");
		utils.log().info("****************************************************");
		

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
			if(wanIPv6Tab.isDisplayed() && wanIPv6Tab.isSelected())
				utils.log().info("IPv6 Tab is displayed and is currently selected");
		} catch (Exception e) {
			utils.log().info("IPv6 Tab is not displayed");
		}

		try {
			if (wanIPv4Tab.isDisplayed())
				utils.log().info("IPv4 Tab is displayed and is not selected");
		} catch (Exception e) {
			utils.log().info("IPv4 Tab is not displayed");
		}
		
		try {
			if (statefulRadioButtonChecked.isDisplayed())
				utils.log().info("Stateful Radio button is displayed and is selected");
		} catch (Exception e) {
			utils.log().info("Stateful Radio button is not displayed");
		}
		
//		try {
//			if (statefulRadioButtonUnChecked.isDisplayed())
//				utils.log().info("Stateful Radio button is displayed and is not selected ");
//		} catch (Exception e) {
//			utils.log().info("Stateful Radio button is not displayed");
//		}
		
		try {
			if (ipv6AddressLabel.isDisplayed() && ipv6Address.isDisplayed() && !(ipv6Address.isEnabled()))
				utils.log().info(ipv6AddressLabel.getText() + " : " + ipv6Address.getText());
		} catch (Exception e) {
			utils.log().info("IPv6 Address details is not displayed");
		}
		
		try {
			if (ipv6PrefixLengthLabel.isDisplayed() && ipv6PrefixLength.isDisplayed() && !(ipv6PrefixLength.isEnabled()))
				utils.log().info(ipv6PrefixLengthLabel.getText() + " : " + ipv6PrefixLength.getText());
		} catch (Exception e) {
			utils.log().info("IPv6 Prefix Length details is not displayed");
		}
		
		try {
			if (ipv6GatewayLabel.isDisplayed() && ipv6Gateway.isDisplayed() && !(ipv6Gateway.isEnabled()))
				utils.log().info(ipv6GatewayLabel.getText() + " : " + ipv6Gateway.getText());
		} catch (Exception e) {
			utils.log().info("IPv6 Gateway details is not displayed");
		}
		
		try {
			if (ipv6PrefixDelegationLabel.isDisplayed())
				utils.log().info(ipv6PrefixDelegationLabel.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("IPv6 Prefix Delegation Label is not displayed");
		}
		
		try {
			if (ipv6PrefixDelegationCheckbox.isDisplayed())
				utils.log().info("IPv6 Prefix Delegation checkbox is displayed but is not selected");
		} catch (Exception e) {
			utils.log().info("IPv6 Prefix Delegation checkbox is not displayed");
		}
		
		try {
			if (ipv6PrimaryDNSLabel.isDisplayed() && ipv6PrimaryDNS.isDisplayed() && !(ipv6PrimaryDNS.isEnabled()))
				utils.log().info(ipv6PrimaryDNSLabel.getText() + " : " + ipv6PrimaryDNS.getText());
		} catch (Exception e) {
			utils.log().info("IPv6 Primary DNS details is not displayed");
		}
		
		try {
			if (ipv6SecondayDNSLabel.isDisplayed() && ipv6SecondaryDNS.isDisplayed() && !(ipv6SecondaryDNS.isEnabled()))
				utils.log().info(ipv6SecondayDNSLabel.getText() + " : " + ipv6SecondaryDNS.getText());
		} catch (Exception e) {
			utils.log().info("IPv6 Secondary DNS details is not displayed");
		}
		
		try {
			new SwipeActions().swipeScreen(Direction.UP);
			if (stateful_SaveChangesButton_Disabled.isDisplayed())
				utils.log().info(stateful_SaveChangesButton_Disabled.getText() + " button is displayed but is disabled");
		} catch (Exception e) {
			utils.log().info("SAVE CHANGES button is not displayed");
		}
	}
	
	public void verifyUIOnWANIPv6Stateless() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Verifying WAN IPv6 - Stateless Configuration Settings");
		utils.log().info("*****************************************************");
		
		this.clickStatelessRadioButton();
		
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
			if(wanIPv6Tab.isDisplayed() && wanIPv6Tab.isSelected())
				utils.log().info("IPv6 Tab is displayed and is currently selected");
		} catch (Exception e) {
			utils.log().info("IPv6 Tab is not displayed");
		}

		try {
			if (wanIPv4Tab.isDisplayed())
				utils.log().info("IPv4 Tab is displayed but is not selected");
		} catch (Exception e) {
			utils.log().info("IPv4 Tab is not displayed");
		}
		
		try {
			if (statelessRadioButtonChecked.isDisplayed())
				utils.log().info("Stateless Radio button is displayed and is selected");
		} catch (Exception e) {
			utils.log().info("Stateless Radio button is not displayed");
		}
		
//		try {
//			if (statelessRadioButtonUnChecked.isDisplayed())
//				utils.log().info("Stateless Radio button is displayed and is not selected ");
//		} catch (Exception e) {
//			utils.log().info("Stateless Radio button is not displayed");
//		}
		
		new SwipeActions().swipeScreen(Direction.UP);
		
		try {
			if (ipv6AddressLabel.isDisplayed() && ipv6Address.isDisplayed() && !(ipv6Address.isEnabled()))
				utils.log().info(ipv6AddressLabel.getText() + " : " + ipv6Address.getText());
		} catch (Exception e) {
			utils.log().info("IPv6 Address details is not displayed");
		}
		
		try {
			if (ipv6PrefixLengthLabel.isDisplayed() && ipv6PrefixLength.isDisplayed() && !(ipv6PrefixLength.isEnabled()))
				utils.log().info(ipv6PrefixLengthLabel.getText() + " : " + ipv6PrefixLength.getText());
		} catch (Exception e) {
			utils.log().info("IPv6 Prefix Length details is not displayed");
		}
		
		try {
			if (ipv6GatewayLabel.isDisplayed() && ipv6Gateway.isDisplayed() && !(ipv6Gateway.isEnabled()))
				utils.log().info(ipv6GatewayLabel.getText() + " : " + ipv6Gateway.getText());
		} catch (Exception e) {
			utils.log().info("IPv6 Gateway details is not displayed");
		}
		
		try {
			if (ipv6PrefixDelegationLabel.isDisplayed())
				utils.log().info(ipv6PrefixDelegationLabel.getText() + " label is displayed");
		} catch (Exception e) {
			utils.log().info("IPv6 Prefix Delegation Label is not displayed");
		}
		
		try {
			if (ipv6PrefixDelegationCheckbox.isDisplayed())
				utils.log().info("IPv6 Prefix Delegation checkbox is displayed but is not selected");
		} catch (Exception e) {
			utils.log().info("IPv6 Prefix Delegation checkbox is not displayed");
		}
		
		try {
			if (ipv6PrimaryDNSLabel.isDisplayed() && ipv6PrimaryDNS.isDisplayed() && !(ipv6PrimaryDNS.isEnabled()))
				utils.log().info(ipv6PrimaryDNSLabel.getText() + " : " + ipv6PrimaryDNS.getText());
		} catch (Exception e) {
			utils.log().info("IPv6 Primary DNS details is not displayed");
		}
		
		try {
			if (ipv6SecondayDNSLabel.isDisplayed() && ipv6SecondaryDNS.isDisplayed() && !(ipv6SecondaryDNS.isEnabled()))
				utils.log().info(ipv6SecondayDNSLabel.getText() + " : " + ipv6SecondaryDNS.getText());
		} catch (Exception e) {
			utils.log().info("IPv6 Secondary DNS details is not displayed");
		}
		
		try {
			if (stateless_SaveChangesButton.isDisplayed())
				utils.log().info(stateless_SaveChangesButton.getText() + " button is displayed and is enabled");
		} catch (Exception e) {
			utils.log().info("SAVE CHANGES button is not displayed");
		}
	}

	@Override
	public boolean isAt() {
		if (wanIPConfigurationTitle.isDisplayed()) {
			utils.log().info("On WAN IPv6 Configuration Page");
			return true;
		} else {
			utils.log().info("Not on WAN IPv6 Configuration Page");
			return false;
		}
	}
}
