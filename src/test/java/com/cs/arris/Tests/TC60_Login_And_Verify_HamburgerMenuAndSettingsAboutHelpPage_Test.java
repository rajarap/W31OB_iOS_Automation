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
import com.cs.arris.Workflows.TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow;

public class TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Test extends ParentClass {
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
		utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	}

	@Test(priority = 1)
	public void Verify_HamburgerMEnu_And_Settings_About_Help_Pages() {
		TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow.getStartedPage(getStarted -> {
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
			super.pause(3);
		}).homePage(home -> {
			try {
				if (home.okButton.isDisplayed()) {
					home.clickOkButton();
				}
			} catch (Exception e) {
				e.getMessage();
			}
			if (home.isAt()) {
				super.pause(3);
				home.clickNavigationButton();
			}
		}).hamburgerMenuPage(hamburger -> {
			if (hamburger.isAt()) {
				hamburger.verifyUIOnHamburgerMenuPage();
				hamburger.clickSettingsButton();
			}
		}).settingsAboutHelpPage(settings -> {
			if (settings.isAt()) {
				settings.verifyUIOnSettingsPage();
				settings.clickHelpIcon();
				if (settings.getSettingsHelpPageObject().isAt()) {
					settings.getSettingsHelpPageObject().clickCloseButton();
				}
				settings.clickBackButton();
			}
		}).homePage(home -> {
			if (home.isAt()) {
				super.pause(3);
				home.clickNavigationButton();
			}
		}).hamburgerMenuPage(hamburger -> {
			if (hamburger.isAt()) {
				hamburger.clickAboutAppButton();
			}
		}).settingsAboutHelpPage(settings -> {
			if (settings.isAtAboutPage()) {
				settings.verifyUIOnAboutPage();
				settings.clickHelpIcon();
				if (settings.getAboutHelpPageObject().isAt()) {
					settings.getAboutHelpPageObject().verifyUIOnAboutHelpPage();
					settings.getAboutHelpPageObject().clickCloseButton();
				}
				settings.clickLicenseButton();
				super.pause(5);
				if (settings.getLicensesPageObject().isAt()) {
					settings.getLicensesPageObject().verifyUIOnLicensesPage();
					settings.getLicensesPageObject().clickCloseButton();
				}
				settings.clickGetAnotherMaxRouterButton();
				settings.clickBackButton();
			}
		}).homePage(home -> {
			if (home.isAt()) {
				super.pause(3);
				home.clickNavigationButton();
			}
		}).hamburgerMenuPage(hamburger -> {
			if (hamburger.isAt()) {
				hamburger.clickHelpMenuButton();
			}
		}).settingsAboutHelpPage(settings -> {
			if (settings.isAtHelpPage()) {
				settings.verifyUIOnHelpPage();
				settings.clickLiveChatHelp();
				settings.clickSelfHelp();
				settings.clickFAQButton();
				super.pause(5);
				if (settings.getFAQHelpPageObject().isAt()) {
					settings.getFAQHelpPageObject().verifyUIOnFAQHelpPage();
					settings.getFAQHelpPageObject().clickBackButton();
				}
				settings.clickBackButton();
			}
		}).homePage(home -> {
			if (home.isAt()) {
				super.pause(3);
			}
		});
	}
}