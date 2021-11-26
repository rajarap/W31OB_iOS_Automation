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

public class NetworkWANDNSConfigurationIPv4Page extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement dnsConfigurationTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ipv4_btn_dns")
	public MobileElement dnsIPv4Tab;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ipv6_btn_dns")
	public MobileElement dnsIPv6Tab;
	
//	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/ipv4_automatic_radio_btn' and @checked='true']")
//	public MobileElement automaticRadioButtonChecked;
//	
//	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/ipv4_automatic_radio_btn' and @checked='false']")
//	public MobileElement automaticRadioButtonUnChecked;
//	
//	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/ipv4_static_radio_btn' and @checked='true']")
//	public MobileElement staticRadioButtonChecked;
//	
//	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/ipv4_static_radio_btn' and @checked='false']")
//	public MobileElement staticRadioButtonUnChecked;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/ipv4_automatic_radio_btn']")
	public MobileElement automaticRadioButton;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/ipv4_static_radio_btn']")
	public MobileElement staticRadioButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Primary DNS']")
	public MobileElement primaryDNSLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/ipv4_primary_dns_et']")
	public MobileElement automatic_primaryDNS;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/ipv4_primary_dns_et']")
	public MobileElement static_primaryDNS;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Secondary DNS']")
	public MobileElement secondayDNSLabel;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/ipv4_secondary_dns_et']")
	public MobileElement automatic_secondaryDNS;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/ipv4_secondary_dns_et']")
	public MobileElement static_secondaryDNS;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/save_dns_configure']")
	public MobileElement automatic_saveChangesButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/save_dns_configure']")
	public MobileElement static_saveChangesButton;


	public NetworkWANDNSConfigurationIPv4Page() {
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
 	 
 	 public NetworkDNSConfigurationStaticAlertDialog getDNSStaticAlertDialogObject() {
 		NetworkDNSConfigurationStaticAlertDialog dnsStaticAlert = new NetworkDNSConfigurationStaticAlertDialog();
	     return dnsStaticAlert;
	  }
 	 
 	public NetworkWANIPConfigurationIPv6Page getNetworkWANIPConfigurationIPv6PageObject() {
 		NetworkWANIPConfigurationIPv6Page wanIPv6Configuration = new NetworkWANIPConfigurationIPv6Page();
		return wanIPv6Configuration;
	}
 	
	public NetworkWANDNSConfigurationHelpPage getNetworkWANDNSConfigurationHelpPageObject() {
		NetworkWANDNSConfigurationHelpPage wanDNSConfiguration = new NetworkWANDNSConfigurationHelpPage();
		return wanDNSConfiguration;
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
	
	public boolean clickDNSIPv6Tab() {
		if (dnsIPv6Tab.isDisplayed()) {
			click(dnsIPv6Tab);
			utils.log().info("Clicked on IPv6 Tab");
			return true;
		} else {
			utils.log().info("IPv6 Tab is not displayed");
			return false;
		}
	}
	
	public boolean clickSaveChangesButton_Automatic() {
		if (automatic_saveChangesButton.isDisplayed()) {
				utils.log().info("SAVE CHANGES button is disabled. You are not allowed to modify the Primary and Secondary DNS Automatic configuration for IPv4");
				return true;
		} else {
			utils.log().info("SAVE CHANGES button is not displayed");
			return false;
		}
	}
	
//	public void clickSaveChangesButton_Static() {
//		try {
//			if (static_saveChangesButton.isDisplayed() && static_saveChangesButton.isEnabled()) {
//				click(static_saveChangesButton);
//				utils.log().info("Clicked on SAVE CHANGES button");
//			}
//		} catch (Exception e) {
//			utils.log().info("SAVE CHANGES button is displayed, but is disabled");
//		}
//	}
//	

	public boolean clickAutomaticRadioButton() {
		if (automaticRadioButton.isSelected()) {
			utils.log().info("Automatic Radion button is already selected");
			return true;
		}else {
				click(automaticRadioButton);
				utils.log().info("Automatic Radion button is selected");
				return true;
		}
	}
	
	public boolean clickStaticRadioButton() {
		if (staticRadioButton.isEnabled()) {
			utils.log().info("Static Radion button is already selected");
			return true;
		} else {
			click(staticRadioButton);
			if (this.getDNSStaticAlertDialogObject().alertTitle.isDisplayed()) {
				this.getDNSStaticAlertDialogObject().clickOKButton();
			}
			utils.log().info("Static Radio button is selected");
			return true;
		}
	}
	
	public boolean verifyUIOnDNSIPv4Automatic() {
		utils.log().info("                                                ");
		utils.log().info("************************************************");
		utils.log().info("Verifying Automatic DNS Configuration for IPv4  ");
		utils.log().info("************************************************");
		
		this.clickAutomaticRadioButton();
		try {
			if (dnsConfigurationTitle.isDisplayed())
				utils.log().info(dnsConfigurationTitle.getText() + " title text is displayed ");
			else
				utils.log().info("DNS Configuration title text is not displayed ");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed ");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed ");

			if(dnsIPv4Tab.isDisplayed())
				utils.log().info("IPv4 Tab is displayed and is currently selected");
			else
				utils.log().info("IPv4 Tab is not displayed ");

			if (dnsIPv6Tab.isDisplayed())
				utils.log().info("IPV6 Tab is displayed but is not selected");
			else
				utils.log().info("IPV6 Tab is not displayed ");

			if (primaryDNSLabel.isDisplayed() && automatic_primaryDNS.isDisplayed() && !(automatic_primaryDNS.isEnabled()))
				utils.log().info(primaryDNSLabel.getText() + " : " + automatic_primaryDNS.getText());
			else
				utils.log().info("Primary DNS is not displayed ");

			if (secondayDNSLabel.isDisplayed() && automatic_secondaryDNS.isDisplayed() && !(automatic_secondaryDNS.isEnabled()))
				utils.log().info(secondayDNSLabel.getText() + " : " + automatic_secondaryDNS.getText());
			else
				utils.log().info("Secondary DNS is not displayed ");

			if (automatic_saveChangesButton.isDisplayed())
				utils.log().info(automatic_saveChangesButton.getText() + " button is displayed but is disabled");
			else
				utils.log().info("Save Changes Button is not displayed ");
			
			return true;
			
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean verifyUIOnDNSIPv4Static() {
		utils.log().info("                                             ");
		utils.log().info("*********************************************");
		utils.log().info("Verifying Static DNS Configuration for IPv4  ");
		utils.log().info("*********************************************");
		
		this.clickStaticRadioButton();
		try {
			if (dnsConfigurationTitle.isDisplayed())
				utils.log().info(dnsConfigurationTitle.getText() + " title text is displayed ");
			else
				utils.log().info("DNS Configuration title text is not displayed ");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed ");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed ");

			if(dnsIPv4Tab.isDisplayed() && dnsIPv4Tab.isSelected())
				utils.log().info("IPv4 Tab is displayed and is currently selected");
			else
				utils.log().info("IPV4 Tab is not displayed ");

			if (dnsIPv6Tab.isDisplayed())
				utils.log().info("IPV6 Tab is displayed but is not selected");
			else
				utils.log().info("IPV6 Tab is not displayed ");
			
			if (primaryDNSLabel.isDisplayed() && static_primaryDNS.isDisplayed())
				utils.log().info(primaryDNSLabel.getText() + " : " + static_primaryDNS.getText());
			else
				utils.log().info("Primary DNS is not displayed ");

			if (secondayDNSLabel.isDisplayed() && static_secondaryDNS.isDisplayed())
				utils.log().info(secondayDNSLabel.getText() + " : " + static_secondaryDNS.getText());
			else
				utils.log().info("Secondary DNS is not displayed ");

			if (static_saveChangesButton.isDisplayed())
				utils.log().info("Save Changes button is displayed");
			else
				utils.log().info("Save Changes Button is not displayed ");
			return true;
			
		}catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if (dnsConfigurationTitle.isDisplayed()) {
			utils.log().info("On DNS IPv4 Configuration Page");
			return true;
		} else {
			utils.log().info("Not on DNS IPv4 Configuration Page");
			return false;
		}
	}
}
