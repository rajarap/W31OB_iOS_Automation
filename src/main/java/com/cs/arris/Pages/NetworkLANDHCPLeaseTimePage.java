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

public class NetworkLANDHCPLeaseTimePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	// ====================Network SSID Password
	// ===========================================
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement lanDHCPLeaseTimeTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Set Lease Time']")
	public MobileElement setLeaseTimeLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/et_lease_time")
	public MobileElement enterLeaseTimeTextBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Time Unit']")
	public MobileElement selctTimeUnitLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tv_select_unit")
	public MobileElement selectTimeUnitButton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/save_lease_time")
	public MobileElement saveLeaseTimeButton;

	public NetworkLANDHCPLeaseTimePage() {
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
	 
	 public NetworkLANSettingsPage getLANSettingsPageObject() {
		 NetworkLANSettingsPage lanSettings = new NetworkLANSettingsPage();
	     return lanSettings;
	  }
	 
		public boolean clickBackButton() {
			try {
				if (backIcon.isDisplayed()) {
					click(backIcon);
					utils.log().info("Clicked on Back Button");
				}
				return true;
			} catch (Exception e) {
				utils.log().info("Back Button is not displayed");
				return false;
			}
		}

	public boolean clickHelpButton() {
		try {
			if (helpIcon.isDisplayed()) {
				click(helpIcon);
				utils.log().info("Clicked on Help Button");
			}
			return true;
		} catch (Exception e) {
			utils.log().info("Help Button is not displayed");
			return false;
		}
	}
	
	public boolean clickTimeUnitButton() {
		try {
			if (selectTimeUnitButton.isDisplayed()) {
				click(selectTimeUnitButton);
				utils.log().info("Clicked on TimeUnit Button");
			}
			return true;
		} catch (Exception e) {
			utils.log().info("TimeUnit Button is not displayed");
			return false;
		}
	}
	
	public boolean clickSaveLeaseTimeButton() {
		try {
			if (saveLeaseTimeButton.isDisplayed()) {
				click(saveLeaseTimeButton);
				utils.log().info("Clicked on Save Lease Time Button");
			}
			return true;
		} catch (Exception e) {
			utils.log().info("Save Lease Time Button is not displayed");
			return false;
		}
	}
	
	public boolean enterLeaseTime() {
		try {
			if (enterLeaseTimeTextBox.isDisplayed()) {
				sendKeys(enterLeaseTimeTextBox, "1550");
				utils.log().info("Entered Lease time of 1550");
			}
			return true;
		} catch (Exception e) {
			utils.log().info("Save Lease Time Button is not displayed");
			return false;
		}
	}
	

	public boolean verifyUIOnLANLeaseTimePage() {
		utils.log().info("                                             ");
		utils.log().info("*********************************************");
		utils.log().info("Verifying UI Elements on LAN Lease Time Page ");
		utils.log().info("*********************************************");
		try
		{
			if (lanDHCPLeaseTimeTitle.isDisplayed())
				utils.log().info(lanDHCPLeaseTimeTitle.getText() + " title text is displayed ");
//			else
//				utils.log().info("LAN DHCP Lease Time text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
//			else
//				utils.log().info("Back Icon is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
//			else
//				utils.log().info("Help Icon is not displayed");
//		
			if (setLeaseTimeLabel.isDisplayed())
				utils.log().info(setLeaseTimeLabel.getText() + " label is displayed");
//			else
//				utils.log().info("Set Lease Time label is displayed");
			
			if (enterLeaseTimeTextBox.isDisplayed())
				utils.log().info("Enter Lease Time TextBox is displayed");
//			else
//				utils.log().info("Enter Lease Time TextBoxis not displayed");
			
			if (selctTimeUnitLabel.isDisplayed())
				utils.log().info(selctTimeUnitLabel.getText() + " label is displayed");
//			else
//				utils.log().info("Select Time Unit Label is not displayed");
			
			if (selectTimeUnitButton.isDisplayed())
				utils.log().info("Button to select the time unit is displayed");
//			else
//				utils.log().info("Button to select the time unit is not displayed");
			
			if (saveLeaseTimeButton.isDisplayed())
				utils.log().info("Save Lease Time Button is displayed");
//			else
//				utils.log().info("Button to select the time unit is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}


	}

	@Override
	public boolean isAt() {
		if (lanDHCPLeaseTimeTitle.isDisplayed()) {
			utils.log().info("On LAN DHCP Lease Time Page");
			return true;
		} else {
			utils.log().info("Not on LAN DHCP Lease Time Page");
			return false;
		}
	}
}
