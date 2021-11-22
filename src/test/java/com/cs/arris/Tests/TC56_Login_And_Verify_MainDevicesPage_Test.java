package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
import com.cs.arris.Pages.MainDeviceAllTabPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Pages.SpeedTestPage;
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
		utils.log().info("\n" + "\n" + "****** starting test : " + m.getName() + " ******" + "\n");
	}

	@Test(priority = 1)
	public void Login_And_Onboard() {
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
				  if(home.okButton.isDisplayed())
					  home.clickOkButton();
			  }catch(Exception e) {
				  e.getMessage();  }
		  });
	}

	@Test(priority = 2)
	public void Verify_Main_Device_UI_On_All_Tab_Page() {
		SoftAssert softmain2 = new SoftAssert();
		softmain2.assertTrue(new HomePage().clickMainDeviceImage());
		if(new MainDeviceAllTabPage().isAt()) 
			softmain2.assertTrue(new MainDeviceAllTabPage().verifyUIOnMainDevicePage());
	}
	
	@Test(priority = 3)
	public void Verify_LED_Settings_UI_On_All_Tab() {
		SoftAssert softmain3 = new SoftAssert();
		softmain3.assertTrue(new MainDeviceAllTabPage().verifyUIOnLedSettings());
	}
	
	@Test(priority = 3)
	public void Verify_Decrease_LED_Settings_On_All_Tab_Page() {
		SoftAssert softmain3 = new SoftAssert();
		softmain3.assertTrue(new MainDeviceAllTabPage().decreaseLedBrightnessSettings());
	}
	
	@Test(priority = 4)
	public void Verify_Increase_LED_Settings_On_All_Tab_Page() {
		SoftAssert softmain4 = new SoftAssert();
		softmain4.assertTrue(new MainDeviceAllTabPage().increaseLedBrightnessSettings());
	}
	
	@Test(priority = 5)
	public void Verify_Connected_Devices_On_All_Tab_Page() {
		SoftAssert softmain5 = new SoftAssert();
		softmain5.assertTrue(new MainDeviceAllTabPage().verifyConnectedDeviceDetails());
	}
	
	@Test(priority = 6)
	public void Verify_Main_Router_Details_On_All_Tab_Page() {
		SoftAssert softmain6 = new SoftAssert();
		softmain6.assertTrue(new MainDeviceAllTabPage().verifyMainRouterDetails());
	}
	
	@Test(priority = 7)
	public void Verify_Edit_Main_Router_Name_On_All_Tab_Page() {
		SoftAssert softmain7 = new SoftAssert();
		softmain7.assertTrue(new MainDeviceAllTabPage().clickMainDeviceName());
		if(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().isAt())
		{
			softmain7.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
			softmain7.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().editMainDeviceName());
			softmain7.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().clickSaveButton());
		}
	}
	
	@Test(priority = 8)
	public void Verify_Edit_Connected_Device_Name_On_All_Tab_Page() {
		SoftAssert softmain8 = new SoftAssert();
		softmain8.assertTrue(new MainDeviceAllTabPage().clickDeviceName());
		if(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().isAt())
		{
			softmain8.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
			softmain8.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().editDeviceName());
			softmain8.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().clickSaveButton());
		}
	}
	
	@Test(priority = 9)
	public void Verify_Devices_Count_Validation_On_All_Tab_Page() {
		SoftAssert softmain9 = new SoftAssert();
		softmain9.assertTrue(new MainDeviceAllTabPage().validations());
	}
	
	@Test(priority = 10)
	public void Verify_Main_Device_UI_On_5GHz_Tab_Page() {
		SoftAssert softmain10 = new SoftAssert();
		softmain10.assertTrue(new MainDeviceAllTabPage().click5GhzTab());
		if(new MainDeviceAllTabPage().get5GHzPageObject().isAt())
			softmain10.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyUIOn5GHzDevicePage());
	}
	
	@Test(priority = 11)
	public void Verify_LED_Settings_UI_On_5GHz_Tab_Page() {
		SoftAssert softmain11 = new SoftAssert();
		softmain11.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyUIOnLedSettings());
	}
	
	@Test(priority = 12)
	public void Verify_Decrease_LED_Settings_On_5GHz_Tab_Page() {
		SoftAssert softmain12 = new SoftAssert();
		softmain12.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().decreaseLedBrightnessSettings());
	}
	
	@Test(priority = 13)
	public void Verify_Increase_LED_Settings_On_5GHz_Tab_Page() {
		SoftAssert softmain4 = new SoftAssert();
		softmain4.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().increaseLedBrightnessSettings());
	}
	
	@Test(priority = 14)
	public void Verify_Connected_Devices_On_5GHz_Tab_Page() {
		SoftAssert softmain14 = new SoftAssert();
		softmain14.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyConnectedDeviceDetails());
	}
	
	@Test(priority = 15)
	public void Verify_Main_Router_Details_On_5GHz_Tab_Page() {
		SoftAssert softmain15 = new SoftAssert();
		softmain15.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyMainRouterDetails());
	}
	
	@Test(priority = 16)
	public void Verify_Edit_Main_Router_Name_On_5GHz_Tab_Page() {
		SoftAssert softmain16 = new SoftAssert();
		softmain16.assertTrue(new MainDeviceAllTabPage().clickMainDeviceName());
		if(new MainDeviceAllTabPage().get5GHzPageObject().getEditMainDeviceNameDialogObject().isAt())
		{
			softmain16.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
			softmain16.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditMainDeviceNameDialogObject().editMainDeviceName());
			softmain16.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditMainDeviceNameDialogObject().clickSaveButton());
		}
	}
	
	@Test(priority = 17)
	public void Verify_Edit_Connected_Device_Name_On_5GHz_Tab_Page() {
		SoftAssert softmain17 = new SoftAssert();
		softmain17.assertTrue(new MainDeviceAllTabPage().clickDeviceName());
		if(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().isAt())
		{
			softmain17.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
			softmain17.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditDeviceNameDialogObject().editDeviceName());
			softmain17.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditDeviceNameDialogObject().clickSaveButton());
		}
	}
	
	@Test(priority = 18)
	public void Verify_Devices_Count_Validation_On_5GHz_Tab_Page() {
		SoftAssert softmain18 = new SoftAssert();
		softmain18.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().validations());
	}
	
	@Test(priority = 19)
	public void Verify_Main_Device_UI_On_24GHz_Tab_Page() {
		SoftAssert softmain19 = new SoftAssert();
		softmain19.assertTrue(new MainDeviceAllTabPage().click24GhzTab());
		if(new MainDeviceAllTabPage().get24GHzPageObject().isAt())
			softmain19.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyUIOn24GHzDevicePage());
	}
	
	@Test(priority = 20)
	public void Verify_LED_Settings_UI_On_24GHz_Tab_Page() {
		SoftAssert softmain20 = new SoftAssert();
		softmain20.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyUIOnLedSettings());
	}
	
	@Test(priority = 21)
	public void Verify_Decrease_LED_Settings_On_24GHz_Tab_Page() {
		SoftAssert softmain21 = new SoftAssert();
		softmain21.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().decreaseLedBrightnessSettings());
	}
	
	@Test(priority = 22)
	public void Verify_Increase_LED_Settings_On_24GHz_Tab_Page() {
		SoftAssert softmain22 = new SoftAssert();
		softmain22.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().increaseLedBrightnessSettings());
	}
	
	@Test(priority = 23)
	public void Verify_Connected_Devices_On_24GHz_Tab_Page() {
		SoftAssert softmain23 = new SoftAssert();
		softmain23.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyConnectedDeviceDetails());
	}
	
	@Test(priority = 24)
	public void Verify_Main_Router_Details_On_24GHz_Tab_Page() {
		SoftAssert softmain24 = new SoftAssert();
		softmain24.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyMainRouterDetails());
	}
	
	@Test(priority = 25)
	public void Verify_Edit_Main_Router_Name_On_24GHz_Tab_Page() {
		SoftAssert softmain25 = new SoftAssert();
		softmain25.assertTrue(new MainDeviceAllTabPage().clickMainDeviceName());
		if(new MainDeviceAllTabPage().get24GHzPageObject().getEditMainDeviceNameDialogObject().isAt())
		{
			softmain25.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
			softmain25.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditMainDeviceNameDialogObject().editMainDeviceName());
			softmain25.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditMainDeviceNameDialogObject().clickSaveButton());
		}
	}
	
	@Test(priority = 26)
	public void Verify_Edit_Connected_Device_Name_On_24GHz_Tab_Page() {
		SoftAssert softmain26 = new SoftAssert();
		softmain26.assertTrue(new MainDeviceAllTabPage().clickDeviceName());
		if(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().isAt())
		{
			softmain26.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
			softmain26.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditDeviceNameDialogObject().editDeviceName());
			softmain26.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditDeviceNameDialogObject().clickSaveButton());
		}
	}
	
	@Test(priority = 27)
	public void Verify_Devices_Count_Validation_On_24GHz_Tab_Page() {
		SoftAssert softmain27 = new SoftAssert();
		softmain27.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().validations());
	}
	
	@Test(priority = 28)
	public void Verify_Main_Device_UI_On_Ethernet_Tab_Page() {
		SoftAssert softmain28 = new SoftAssert();
		softmain28.assertTrue(new MainDeviceAllTabPage().clickEthernetTab());
		if(new MainDeviceAllTabPage().getEthernetPageObject().isAt())
			softmain28.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyUIOnEthernetDevicePage());
	}
	
	@Test(priority = 29)
	public void Verify_LED_Settings_UI_On_Ethernet_Tab_Page() {
		SoftAssert softmain29 = new SoftAssert();
		softmain29.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyUIOnLedSettings());
	}
	
	@Test(priority = 30)
	public void Verify_Decrease_LED_Settings_On_Ethernet_Tab_Page() {
		SoftAssert softmain30 = new SoftAssert();
		softmain30.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().decreaseLedBrightnessSettings());
	}
	
	@Test(priority = 31)
	public void Verify_Increase_LED_Settings_On_Ethernet_Tab_Page() {
		SoftAssert softmain31 = new SoftAssert();
		softmain31.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().increaseLedBrightnessSettings());
	}
	
	@Test(priority = 32)
	public void Verify_Connected_Devices_On_Ethernet_Tab_Page() {
		SoftAssert softmain32 = new SoftAssert();
		softmain32.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyConnectedDeviceDetails());
	}
	
	@Test(priority = 33)
	public void Verify_Main_Router_Details_On_Ethernet_Tab_Page() {
		SoftAssert softmain33 = new SoftAssert();
		softmain33.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyMainRouterDetails());
	}
	
	@Test(priority = 34)
	public void Verify_Edit_Main_Router_Name_On_Ethernet_Tab_Page() {
		SoftAssert softmain34 = new SoftAssert();
		softmain34.assertTrue(new MainDeviceAllTabPage().clickMainDeviceName());
		if(new MainDeviceAllTabPage().getEthernetPageObject().getEditMainDeviceNameDialogObject().isAt())
		{
			softmain34.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
			softmain34.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditMainDeviceNameDialogObject().editMainDeviceName());
			softmain34.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditMainDeviceNameDialogObject().clickSaveButton());
		}
	}
	
	@Test(priority = 35)
	public void Verify_Edit_Connected_Device_Name_On_Ethernet_Tab_Page() {
		SoftAssert softmain35 = new SoftAssert();
		softmain35.assertTrue(new MainDeviceAllTabPage().clickDeviceName());
		if(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().isAt())
		{
			softmain35.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
			softmain35.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditDeviceNameDialogObject().editDeviceName());
			softmain35.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditDeviceNameDialogObject().clickSaveButton());
		}
	}
	
	@Test(priority = 36)
	public void Verify_Devices_Count_Validation_On_Ethernet_Tab_Page() {
		SoftAssert softmain36 = new SoftAssert();
		softmain36.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().validations());
	}

	@Test(priority = 37)
	public void Verify_Main_Device_Help_Page() {
		SoftAssert softmain37 = new SoftAssert();
		softmain37.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().clickHelpButton());
		if(new MainDeviceAllTabPage().getMainRouterDetailsHelpPageObject().isAt())
			new MainDeviceAllTabPage().getMainRouterDetailsHelpPageObject().clickCloseButton();
		new MainDeviceAllTabPage().getEthernetPageObject().clickBackButton();
	}
}