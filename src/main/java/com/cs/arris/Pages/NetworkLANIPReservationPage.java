package com.cs.arris.Pages;

import java.util.List;

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

public class NetworkLANIPReservationPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement lanIPTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/add_lan_ip_rule")
	public MobileElement addReservationButton;

	public NetworkLANIPReservationPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}


	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public AppRatingDialog getAppRatingPageObject() {
		AppRatingDialog rating = new AppRatingDialog();
		return rating;
	}

	public NetworkReserveLANIPDialog getLANIPReservationDialogObject() {
		NetworkReserveLANIPDialog reserveLanIP = new NetworkReserveLANIPDialog();
		return reserveLanIP;
	}
	
	public NetworkEditReserveLANIPDialog getEditLANIPReservationDialogObject() {
		NetworkEditReserveLANIPDialog editReserveLanIP = new NetworkEditReserveLANIPDialog();
		return editReserveLanIP;
	}

	public NetworkLANSettingsPage getLANSettingsPageObject() {
		NetworkLANSettingsPage lanSettings = new NetworkLANSettingsPage();
		return lanSettings;
	}
	
	public NetworkLANIPReservationHelpPage getLanIPReservationHelpPageObject() {
		NetworkLANIPReservationHelpPage networkLANIPHelpPage = new NetworkLANIPReservationHelpPage();
		return networkLANIPHelpPage;
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

	public void clickAddReservationButton() {
		try {
			if (addReservationButton.isDisplayed()) {
				click(addReservationButton);
				utils.log().info("Clicked on ADD RESERVATION button");
			}
		} catch (Exception e) {
			utils.log().info("ADD RESERVATION button is not displayed");
		}
	}

	public void verifyUIOnNetworkLANIPReservationPage() {
		utils.log().info("                                                 ");
		utils.log().info("*************************************************");
		utils.log().info("Verifying UI Elements on LAN IP Reservation Page ");
		utils.log().info("*************************************************");
		try {
			if (lanIPTitle.isDisplayed())
				utils.log().info(lanIPTitle.getText() + " title text is displayed ");
		} catch (Exception e) {
			utils.log().info("LAN IP Reservation title text is not displayed");
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
			if (addReservationButton.isDisplayed())
				utils.log().info(addReservationButton.getText() + " button is displayed");
		} catch (Exception e) {
			utils.log().info("ADD RESERVATION button is not displayed");
		}
	}

	public void verifyDevicesOnLAPIPReservationPage() {
		utils.log().info("                                                 ");
		utils.log().info("*************************************************");
		utils.log().info("Verifying Devicees UI on LAN IP Reservation Page ");
		utils.log().info("*************************************************");

		//int deviceCount = super.lanIPRuleName.size();
		//if (deviceCount > 0) {
			for (int i = 1; i <= 2; i++) {
				utils.log().info("Device Details with Reserved IP address  : " + i);
				utils.log().info("-----------------------------------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]");

				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/alise_name']")
								.isDisplayed())
							utils.log()
									.info("Device Name: " + e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/alise_name']")
											.getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not displayed ");
					}

					try {
						if (e.findElementByXPath("//android.widget.TextView[@text='IP Address']").isDisplayed() && (e
								.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/lan_ip_address']")
								.isDisplayed()))
							utils.log().info(e.findElementByXPath("//android.widget.TextView[@text='IP Address']")
									.getText()
									+ " : "
									+ (e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/lan_ip_address']")
											.getText()));
					} catch (Exception exp) {
						utils.log().info("Device IP Address is not available ");
					}

					try {
						if (e.findElementByXPath("//android.widget.TextView[@text='MAC Address']").isDisplayed() && (e
								.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/mac_address']")
								.isDisplayed()))
							utils.log().info(e.findElementByXPath("//android.widget.TextView[@text='MAC Address']")
									.getText()
									+ " : "
									+ (e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/mac_address']")
											.getText()));
					} catch (Exception exp) {
						utils.log().info("Device MAC Address is not available ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/edit_btn']")
								.isDisplayed())
							utils.log().info("Edit Icon is displayed");
					} catch (Exception exp) {
						utils.log().info("Edit Icon is not displayed ");
					}

				}
			}
		}
//	}

	
	public void clickEditLAPIPReservation() 
	{
		//int deviceCount = super.lanIPRuleName.size();
		//if (deviceCount > 0) {
			for (int i = 1; i <= 1; i++) 
			{
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]");

				for (MobileElement e : entity) 
				{
						click(e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/edit_btn']"));
				}
			}
	}
	
	@Override
	public boolean isAt() {
		if (lanIPTitle.isDisplayed()) {
			utils.log().info("On LAN IP Reservation Page");
			return true;
		} else {
			utils.log().info("Not on LAN IP Reservation Page");
			return false;
		}
	}
}