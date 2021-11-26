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

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement lanSettingsTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/lan_ip_reservation_txt")
	public MobileElement lanIPReservationLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/lan_dhcp_range_txt")
	public MobileElement lanSubnetLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/lan_dhcp_lease_time_txt")
	public MobileElement lanDHCPLeaseTimeLabel;

	public NetworkLANSettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public NetworkLANSettingsHelpPage getNetworkLanSettingsHelpPageObject() {
		NetworkLANSettingsHelpPage networkLANHelpPage = new NetworkLANSettingsHelpPage();
		return networkLANHelpPage;
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

	public NetworkLANSubnetDHCPRangeConfigurationPage getNetworkLANSubnetDHCPLRangePageObject() {
		NetworkLANSubnetDHCPRangeConfigurationPage lanDHCPConfiguration = new NetworkLANSubnetDHCPRangeConfigurationPage();
		return lanDHCPConfiguration;
	}

	public NetworkLANDHCPLeaseTimePage getNetworkLANDHCPLeaseTimePageObject() {
		NetworkLANDHCPLeaseTimePage lanLeaseTime = new NetworkLANDHCPLeaseTimePage();
		return lanLeaseTime;
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

	public boolean clickLANIPResevationLink() {
		if (lanIPReservationLabel.isDisplayed()) {
			click(lanIPReservationLabel);
			return true;
		} else {
			utils.log().info("LAN IP Reservation Link is not displayed");
			return false;
		}
	}

	public boolean clickLANSubnetLink() {
		if (lanSubnetLabel.isDisplayed()) {
			click(lanSubnetLabel);
			utils.log().info("Clicked on LAN Subnet and DHCP Range Configuration Link");
			return true;
		} else {
			utils.log().info("LAN Subnet and DHCP Range Configuration Link is not displayed");
			return false;
		}
	}

	public boolean clickDHCPLeaseTimeLink() {
		if (lanDHCPLeaseTimeLabel.isDisplayed()) {
			click(lanDHCPLeaseTimeLabel);
			utils.log().info("Clicked on LAN DHCP Lease Time Link");
			return true;
		} else {
			utils.log().info("LAN DHCP Lease Time Link is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnLANSettingsPage() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Verifying UI Elements on Network - LAN Settings Page ");
		utils.log().info("*****************************************************");
		try {

			if (lanSettingsTitle.isDisplayed())
				utils.log().info(lanSettingsTitle.getText() + " title text is displayed ");
			else
				utils.log().info("LAN Settings title text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");

			if (lanIPReservationLabel.isDisplayed())
				utils.log().info("LAN IP Reservation Link is displayed");
			else
				utils.log().info("LAN IP Reservation Link is not displayed");

			if (lanSubnetLabel.isDisplayed())
				utils.log().info("LAC Link is displayed");
			else
				utils.log().info("LAC Link is not displayed");
			if (lanDHCPLeaseTimeLabel.isDisplayed())
				utils.log().info("DNS Configuration Link is displayed ");
			else
				utils.log().info("DNS Configuration Link is not displayed");
			return true;
		} catch (Exception e) {
			return false;
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
