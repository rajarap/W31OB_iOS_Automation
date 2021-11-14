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

public class TC56_Login_And_Verify_MainDevicesPage_Test extends ParentClass {
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
	public void Verify_Devices_Page() {
		TC56_Login_And_Verify_MainDevicesPage_Workflow.getStartedPage(getStarted -> {
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
				home.clickMainDeviceImage();
			}
		}).mainDevicePage(mainDevice -> {
			if (mainDevice.isAt()) {
				mainDevice.verifyUIOnMainDevicePage();
				mainDevice.verifyUIOnLedSettings();
				mainDevice.decreaseLedBrightnessSettings();
				mainDevice.increaseLedBrightnessSettings();
				mainDevice.verifyConnectedDeviceDetails();
				mainDevice.verifyMainRouterDetails();
				
				mainDevice.changeMainDeviceName();
				if(mainDevice.getEditMainDeviceNameDialogObject().isAt())
				{
					mainDevice.getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog();
					mainDevice.getEditMainDeviceNameDialogObject().editMainDeviceName();
					mainDevice.getEditMainDeviceNameDialogObject().clickSaveButton();
					super.pause(5);
				}
				mainDevice.changeDeviceName();
				if(mainDevice.getEditDeviceNameDialogObject().isAt())
				{
					mainDevice.getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog();
					mainDevice.getEditDeviceNameDialogObject().editDeviceName();
					mainDevice.getEditDeviceNameDialogObject().clickSaveButton();
					super.pause(5);
				}
				mainDevice.validations();
				
				mainDevice.click5GhzTab();
//				mainDevice.get5GHzPageObject().verifyUIOn5GHzDevicePage();
//				mainDevice.get5GHzPageObject().verifyUIOnLedSettings();
//				mainDevice.get5GHzPageObject().decreaseLedBrightnessSettings();
//				mainDevice.get5GHzPageObject().increaseLedBrightnessSettings();
				mainDevice.get5GHzPageObject().verifyConnectedDeviceDetails();
				mainDevice.get5GHzPageObject().verifyMainRouterDetails();
				mainDevice.get5GHzPageObject().validations();
				
				mainDevice.click24GhzTab();
//				mainDevice.get24GHzPageObject().verifyUIOn24DevicePage();
//				mainDevice.get24GHzPageObject().verifyUIOnLedSettings();
//				mainDevice.get24GHzPageObject().decreaseLedBrightnessSettings();
//				mainDevice.get24GHzPageObject().increaseLedBrightnessSettings();
				mainDevice.get24GHzPageObject().verifyConnectedDeviceDetails();
				mainDevice.get24GHzPageObject().verifyMainRouterDetails();
				mainDevice.get24GHzPageObject().validations();
				
				mainDevice.clickEthernetTab();
//				mainDevice.getEthernetPageObject().verifyUIOnEthernetDevicePage();
//				mainDevice.getEthernetPageObject().verifyUIOnLedSettings();
//				mainDevice.getEthernetPageObject().decreaseLedBrightnessSettings();
//				mainDevice.getEthernetPageObject().increaseLedBrightnessSettings();
				mainDevice.getEthernetPageObject().verifyConnectedDeviceDetails();
				mainDevice.getEthernetPageObject().verifyMainRouterDetails();
				mainDevice.getEthernetPageObject().validations();
				
				mainDevice.clickHelpButton();
				super.pause(3);
				if(mainDevice.getMainRouterDetailsHelpPageObject().isAt())
				{
					mainDevice.getMainRouterDetailsHelpPageObject().verifyUIOnMainRouterHelpPage();
					mainDevice.getMainRouterDetailsHelpPageObject().clickCloseButton();
				}
				mainDevice.clickBackButton();
				super.pause(3);
			}
		});
	}
}