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

public class NetworkLANSettingsPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	// ====================Network SSID Password
	// ===========================================
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement lanSettingsTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/lan_ip_reservation_txt")
	public MobileElement lanIPReservationLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/lan_dhcp_range_txt")
	public MobileElement lanSubnetLabel;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/lan_dhcp_lease_time_txt")
	public MobileElement lanDHCPLeaseTimeLabel;


	// ==================== Network Settings
	// ===========================================

	public NetworkLANSettingsPage() {
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
 	 
  	public NetworkLANIPReservationPage getNetworkLANIPReservationPageObject() {
  		NetworkLANIPReservationPage wanIPv6Configuration = new NetworkLANIPReservationPage();
		return wanIPv6Configuration;
	}
  	
 	public NetworkLANSubnetDHCPRangeConfigurationPage getNetworkLANDHCPLeaseTimePageObject() {
 		NetworkLANSubnetDHCPRangeConfigurationPage wanIPv6Configuration = new NetworkLANSubnetDHCPRangeConfigurationPage();
		return wanIPv6Configuration;
	}
 	
 	public NetworkLANDHCPLeaseTimePage getNetworkWANIPConfigurationIPv6PageObject() {
 		NetworkLANDHCPLeaseTimePage wanIPv6Configuration = new NetworkLANDHCPLeaseTimePage();
		return wanIPv6Configuration;
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
	
	public void clickLANIPResevationLink()
	{
		try {
			if (lanIPReservationLabel.isDisplayed()) 
				click(lanIPReservationLabel);
		} catch (Exception e) {
			utils.log().info("LAN IP Reservation Link is not displayed");
		}
	}
	
	public void clickLANSubnetLink() {
		try {
			if (lanSubnetLabel.isDisplayed()) {
				click(lanSubnetLabel);
				utils.log().info("Clicked on LAN Subnet and DHCP Range Configuration Link");
			}
		} catch (Exception e) {
			utils.log().info("LAN Subnet and DHCP Range Configuration Link is not displayed");
		}
	}
	
	public void clickDHCPLeaseTimeLink() {
		try {
			if (lanDHCPLeaseTimeLabel.isDisplayed()) {
				click(lanDHCPLeaseTimeLabel);
				utils.log().info("Clicked on LAN DHCP Lease Time Link");
			}
		} catch (Exception e) {
			utils.log().info("LAN DHCP Lease Time Link is not displayed");
		}
	}
	
	public void verifyUIOnLANSettingsPage() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Verifying UI Elements on Network - LAN Settings Page ");
		utils.log().info("*****************************************************");
		try {
			if (lanSettingsTitle.isDisplayed())
				utils.log().info(lanSettingsTitle.getText() + " title text is displayed ");
		} catch (Exception e) {
			utils.log().info("LAN Settings title text is not displayed");
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
			if(lanIPReservationLabel.isDisplayed())
				utils.log().info("LAN IP Reservation Link is displayed");
		} catch (Exception e) {
			utils.log().info("LAN IP Reservation Link is not displayed");
		}

		try {
			if (lanSubnetLabel.isDisplayed())
				utils.log().info("LAC Link is displayed");
		} catch (Exception e) {
			utils.log().info("LAC Link is not displayed");
		}

		try {
			if (lanDHCPLeaseTimeLabel.isDisplayed())
				utils.log().info("DNS Configuration Link is displayed ");
		} catch (Exception e) {
			utils.log().info("DNS Configuration Link is not displayed");
		}
	}

	@Override
	public boolean isAt() {
		if (lanSettingsTitle.isDisplayed()) {
			utils.log().info("On LAN Settings Page");
			return true;
		} else {
			utils.log().info("Not on LAN Settings Page");
			return false;
		}
	}
}
