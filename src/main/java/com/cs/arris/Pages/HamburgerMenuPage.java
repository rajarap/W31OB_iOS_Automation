package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HamburgerMenuPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/nav_add_device")
	public MobileElement addDevice;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/nav_remove_device")
	public MobileElement removeDevice;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/nav_max_speed_test")
	public MobileElement speedTest;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/nav_add_max")
	public MobileElement addNewSatellite;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/nav_Alexa_Skill")
	public MobileElement amazonFeatures;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/nav_Help")
	public MobileElement helpMenu;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/nav_About")
	public MobileElement aboutApp;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/nav_Settings")
	public MobileElement appSettings;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/closeLogoIcon")
	public MobileElement closeHamburgerMenu;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/centralLogo")
	public MobileElement logo;

	public HamburgerMenuPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public SpeedTestPage getSpeedTestPageObject() {
		SpeedTestPage speedTestPage = new SpeedTestPage();
		return speedTestPage;
	}
	
	public SettingsAboutHelpPage getSettingAboutHelpPageObject() {
		SettingsAboutHelpPage speedTestPage = new SettingsAboutHelpPage();
		return speedTestPage;
	}
	
	public AmazonFeaturesPage getAmazonFeaturesPageObject() {
		AmazonFeaturesPage amazonFeaturesPage = new AmazonFeaturesPage();
		return amazonFeaturesPage;
	}
	
	public AddDeviceSelectDevice1Page getAddDevicePageObject() {
		AddDeviceSelectDevice1Page addDevicePage = new AddDeviceSelectDevice1Page();
		return addDevicePage;
	}
	
	public RemoveDevicePage getRemoveDevicePageObject() {
		RemoveDevicePage removeDevicePage = new RemoveDevicePage();
		return removeDevicePage;
	}


	public boolean clickCloseButton() {
		if (closeHamburgerMenu.isDisplayed()) {
			click(closeHamburgerMenu); // back to home page
			utils.log().info("Clicked Close Icon on Hanburger Manu");
			return true;
		} else {
			return false;
		}
	}

	public boolean clickAddDeviceButton() {
		if(addDevice.isDisplayed()) {
			click(addDevice);
			utils.log().info("Clicked on Add Device Menu Button");
			return true;
		}else {
			utils.log().info("Add Device Menu Button is not displayed");
			return false;
		}
	}

	public boolean clickRemoveDeviceButton() {
		if(removeDevice.isDisplayed()) {
			click(addDevice);
			utils.log().info("Clicked on Remove Device Menu Button");
			return true;
		}else {
			utils.log().info("Remove Device Menu Button is not displayed");
			return false;
		}
	}

	public boolean clickSpeedTestButton() {
		if(speedTest.isDisplayed()) {
			click(speedTest);
			utils.log().info("Clicked on Speed Test Menu Button");
			return true;
		}else {
			utils.log().info("Speed Test Menu Button is not displayed");
			return false;
		}
	}

	public boolean clickAddSatelliteButton() {
		if(addNewSatellite.isDisplayed()) {
			click(addNewSatellite);
			utils.log().info("Clicked on Add New Satellite Menu Button");
			return true;
		}else {
			utils.log().info("Add New Satellite Menu Button is not displayed");
			return false;
		}
	}

	public boolean clickAmazonFeaturesButton() {
		if(amazonFeatures.isDisplayed()) {
			click(amazonFeatures);
			utils.log().info("Clicked on Amazon Features Menu Button");
			return true;
		}else {
			utils.log().info("Amazon Features Menu Button is not displayed");
			return false;
		}
	}

	public boolean clickHelpMenuButton() {
		if(helpMenu.isDisplayed()) {
			click(helpMenu);
			utils.log().info("Clicked on Help Menu Button");
			return true;
		}else {
			utils.log().info("Help Menu Button is not displayed");
			return false;
		}
	}

	public boolean clickAboutAppButton() {
		if(aboutApp.isDisplayed()) {
			click(aboutApp);
			utils.log().info("Clicked on About Menu Button");
			return true;
		}else {
			utils.log().info("About Menu Button is not displayed");
			return false;
		}
	}

	public boolean clickSettingsButton() {
		if(appSettings.isDisplayed()) {
			click(appSettings);
			super.pause(10);
			utils.log().info("Clicked on Settings Menu Button");
			return true;
		}else {
			utils.log().info("Settings Menu Button is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnHamburgerMenuPage() {
		utils.log().info("**********************************************");
		utils.log().info("Details of UI Elements on the Hamburger Page  ");
		utils.log().info("**********************************************");
		try {
			if (addDevice.isDisplayed())
				utils.log().info("Hamburger Menu - " + addDevice.getText() + " - is displayed");
			else
				utils.log().info("Hamburger Menu - " + addDevice.getText() + " - is not displayed");

			if (removeDevice.isDisplayed())
				utils.log().info("Hamburger Menu - " + removeDevice.getText() + " - is displayed");
			else
				utils.log().info("Hamburger Menu - " + removeDevice.getText() + " - is not displayed");

			if (speedTest.isDisplayed())
				utils.log().info("Hamburger Menu - " + speedTest.getText() + " - is displayed");
			else
				utils.log().info("Hamburger Menu - " + speedTest.getText() + " - is not displayed");

			if (addNewSatellite.isDisplayed())
				utils.log().info("Hamburger Menu - " + addNewSatellite.getText() + " - is displayed");
			else
				utils.log().info("Hamburger Menu - " + addNewSatellite.getText() + " - is not displayed");

			if (amazonFeatures.isDisplayed())
				utils.log().info("Hamburger Menu - " + amazonFeatures.getText() + " - is displayed");
			else
				utils.log().info("Hamburger Menu - " + amazonFeatures.getText() + " - is not displayed");

			if (helpMenu.isDisplayed())
				utils.log().info("Hamburger Menu - " + helpMenu.getText() + " - is displayed");
			else
				utils.log().info("Hamburger Menu - " + helpMenu.getText() + " - is not displayed");

			if (aboutApp.isDisplayed())
				utils.log().info("Hamburger Menu - " + aboutApp.getText() + " - is displayed");
			else
				utils.log().info("Hamburger Menu - " + aboutApp.getText() + " - is not displayed");

			if (appSettings.isDisplayed())
				utils.log().info("Hamburger Menu - " + appSettings.getText() + " - is displayed");
			else
				utils.log().info("Hamburger Menu - " + appSettings.getText() + " - is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (logo.isDisplayed()) {
			utils.log().info("On Hamburger Menu Page");
			return true;
		} else {
			utils.log().info("Hamburger Menu Page is not displayed");
			return false;
		}
	}

}
