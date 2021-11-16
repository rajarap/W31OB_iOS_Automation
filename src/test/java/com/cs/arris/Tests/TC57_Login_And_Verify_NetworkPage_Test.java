package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.HomePage_Workflow;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
import com.cs.arris.Workflows.TC53_Login_And_Verify_DevicesPage_Workflow;
import com.cs.arris.Workflows.TC56_Login_And_Verify_MainDevicesPage_Workflow;
import com.cs.arris.Workflows.TC57_Login_And_Verify_NetworkPage_Workflow;

public class TC57_Login_And_Verify_NetworkPage_Test extends ParentClass {
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	String passCode;
	String ssid;
	String ssidpass;
	String udid;
	String countOfDeviceSignalStrength;
	String countOfDevicesSpeedHistory;
	String countOfDevicesBlocked;
	String downloadSpeed;
	String uploadSpeed;
	int totalCountOfDevices;

	@BeforeClass
	public void beforeClass() throws Exception {
		try {
			String dataFileName = "testdata/signup";
			utils.log().info("Loading...Sign Up Test Data");
			super.loadTestData(dataFileName);

			this.firstName = properties.getProperty("firstname");
			utils.log().info("First Name : " + this.firstName);

			this.lastName = properties.getProperty("lastname");
			utils.log().info("Last Name : " + this.lastName);

			this.email = properties.getProperty("email");
			utils.log().info("Email address : " + this.email);

			this.udid = properties.getProperty("udid");
			utils.log().info("UDID : " + this.udid);

			utils.log().info("Retrieved...Sign Up Test Data");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		utils.log().info("****** starting test:" + m.getName() + "******");
	}

	@Test(priority = 1)
	public void Verify_Network_Page() {
		TC57_Login_And_Verify_NetworkPage_Workflow.getStartedPage(getStarted -> {
			getStarted.clickGetStartedButton();
		}).grantPermissionsPage(grantPermission -> {
			grantPermission.clickContinueButton();
		}).deviceLocationPage(deviceLocation -> {
			deviceLocation.clickOnlyThisTimeLink();
		}).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
			super.pause(3);
			accessResoucesOnDevice.clickAllowLink();
		}).selectYourDevicePage(selectDevice -> {
			selectDevice.selectSurfboardMaxOption();
			selectDevice.clickNextButton();
		}).selectYourDevicePage2(selectDevice2 -> {
			selectDevice2.selectMaxProAX11000RadioButton();
			selectDevice2.clickNextButton();
			super.pause(3);
		}).welcomeSigninPage(signin -> {
			signin.enterEmailAddress(email);
			signin.clickSigninButton();
			super.pause(12);
		}).getOTPCode(getOTP -> {
			passCode = getOTP.getValidOTP();
		}).enterOTPPage(otpverify -> {
			otpverify.enterValidPassCode(passCode);
		}).codeVerifiedPage(codeVerified -> {
			codeVerified.getCodeVerifiedText();
			codeVerified.clickNextButton();
			super.pause(3);
			try {
				if (codeVerified.continueOnBoardingButton.isDisplayed()) {
					codeVerified.clickContinueOnboardingButton();
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}).setupWifi(setupwifi -> {
			setupwifi.clickskipTutorialButton();
		}).homePage(home -> {
			try {
				if (home.okButton.isDisplayed()) {
					home.clickOkButton();
				}
			} catch (Exception e) {
				e.getMessage();
			}
			if (home.isAt()) {
				home.getFooterIconsPageObject().clickNetworkButton();
			}
		}).networkPage(network -> {
			if (network.isAt()) {
				network.verifyUIOnNetworkPage();
				network.clickHelpButton();
//				network.getNetworkPageObject().verifyUIOnNetworkHelpPage();
				network.getNetworkPageObject().clickCloseButton();
				network.clickTestConnectionSpeedButton();
				network.getSpeedTestPageObject().performSpeedTest();
				network.getSpeedTestPageObject().clickBackIcon();

				// Verify WAN Settings
				network.clickWANSettings();
				try {
					if (network.getAppRatingPageObject().isAt())
						network.getAppRatingPageObject().clickRemindMeLaterLink();
				} catch (Exception e) {
					utils.log().info("App Rating Dialog did not appear");
				}
				network.getWANSettingsPageObject().verifyUIOnWANSettingsPage();
				network.getWANSettingsPageObject().clickHelpButton();
				if (network.getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().isAt()) {
					network.getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject()
							.verifyUIOnNetworWANSettingsHelpPage();
					network.getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().clickCloseButton();
				}
				network.getWANSettingsPageObject().clickWANIPConfigurationLink();
				if (network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().isAt()) {
					network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4DHCP();
					network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4Static();
					network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().clickHelpButton();
					if (network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject()
							.getNetworkWANIPConfigurationHelpPageObject().isAt())
						network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject()
								.getNetworkWANIPConfigurationHelpPageObject().clickCloseButton();
					network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().clickWANIPv6Tab();
				}
				if (network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().isAt()) {
					network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateful();
					network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateless();
					network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickBackButton();
					network.getWANSettingsPageObject().clickDNSConfigurationLink();
				}
				if (network.getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().isAt()) {
					network.getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject()
							.verifyUIOnDNSIPv4Automatic();
					network.getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Static();
					network.getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().clickHelpButton();
					if (network.getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject()
							.getNetworkWANDNSConfigurationHelpPageObject().isAt())
						network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject()
								.getNetworkWANIPConfigurationHelpPageObject().clickCloseButton();
					network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().clickWANIPv6Tab();
				}
				if (network.getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().isAt()) {
					network.getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject()
							.verifyUIOnDNSIPv6Automatic();
					network.getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().verifyUIOnDNSIPv6Static();
					network.getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().clickBackButton();
				}
				if (network.getWANSettingsPageObject().isAt()) {
					network.getWANSettingsPageObject().clickLacAlertIcon();
					if(network.getWANSettingsPageObject().getLACAlertDialogObject().isAt())
						network.getWANSettingsPageObject().getLACAlertDialogObject().clickCloseDialog();
				}
				network.getWANSettingsPageObject().clickBackButton();
				network.clickNetworkSettingsExpandButton();
				
				// Verify LAN Settings
				network.clickLANSettings();
				try {
					if (network.getAppRatingPageObject().isAt())
						network.getAppRatingPageObject().clickRemindMeLaterLink();
				} catch (Exception e) {
					utils.log().info("App Rating Dialog did not appear");
				}
				network.getLANSettingsPageObject().verifyUIOnLANSettingsPage();
//				network.clickNetworkSettingsExpandButton();
			}

			
			// network.clickBackButton(); //goes back to home page
		});
	}
}