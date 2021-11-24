package com.cs.arris.Pages;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddDeviceHomePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement homeTitle;

	@AndroidFindAll({ 
		@AndroidBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"),
		@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']") })
	public MobileElement navigateButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_toolbar_notification")
	public MobileElement notificationsIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tv_mesh")
	public MobileElement maxRouterTab;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tv_modem")
	public MobileElement cableModemTab;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tvsubtitle")
	public MobileElement cableModemName;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/iv_gob_router_cm")
	public MobileElement cableModemImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_home_network_cm")
	public MobileElement cableModemProviderName;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_device_details")
	public MobileElement deviceDetailsText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_expand_collapse_device_details")
	public MobileElement deviceDetailsImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_device_leader_board")
	public MobileElement specificationsText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_expand_device_specfication")
	public MobileElement specificationsImage;

	public AddDeviceHomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
	     return homePage;
	  }	
	
	 public AddDeviceFooterIconsPage getAddDeviceFooterIconsPageObject() {
		 AddDeviceFooterIconsPage footerIconsPage = new AddDeviceFooterIconsPage();
	     return footerIconsPage;
	  }	

	 public AddDeviceHamburgerMenuPage getHamburgerMenuObject() {
		 AddDeviceHamburgerMenuPage hamburgerMenu = new AddDeviceHamburgerMenuPage();
		 return hamburgerMenu;
	 }
	 	 
	 public AddDeviceMaximumTwoDevicesDialog getMaxTwoDevicesDialogObject() {
		 AddDeviceMaximumTwoDevicesDialog maxTwoDevices = new AddDeviceMaximumTwoDevicesDialog();
		 return maxTwoDevices;
	 }
	 
	 public AddDeviceHomePageDeviceDetailsPage getDeviceDetailsPageObject() {
		 AddDeviceHomePageDeviceDetailsPage deviceDetails = new AddDeviceHomePageDeviceDetailsPage();
		 return deviceDetails;
	 }
	 
	 public AddDeviceHomePageSpecificationDetailsPage getDeviceSpecificationsPageObject() {
		 AddDeviceHomePageSpecificationDetailsPage deviceSpec = new AddDeviceHomePageSpecificationDetailsPage();
		 return deviceSpec;
	 }
	 
	 public AddDeviceNotificationsPage getNotificationsPageObject() {
		 AddDeviceNotificationsPage notifications = new AddDeviceNotificationsPage();
		 return notifications;
	 }
	 
	 public AddDeviceUserGuidePage getUserGuidePageObject() {
		 AddDeviceUserGuidePage userGuide = new AddDeviceUserGuidePage();
		 return userGuide;
	 }
	 
	 public AddDeviceFAQPage getFAQPageObject() {
		 AddDeviceFAQPage faqPage = new AddDeviceFAQPage();
		 return faqPage;
	 }
	 
	 public RemoveDevicePage getRemoveDevicePageObject() {
		 RemoveDevicePage removeDevice = new RemoveDevicePage();
		 return removeDevice;
	 }
	 
	public boolean clickNotificationsIcon() {
		if (notificationsIcon.isDisplayed()) {
			click(notificationsIcon);
			utils.log().info("Add Device Home Page - Clicked on Notifications Icon");
			return true;
		} else {
			utils.log().info(
					"Add Device Home Page - Notifications Icon is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickNavigationButton() {
		if (navigateButton.isDisplayed()) {
			click(navigateButton);
			utils.log().info("Add Device Home Page  - Clicked on Navigation Icon to display the Hamburger Menu");
			return true;
		} else {
			utils.log()
					.info("Add Device Home Page  - Navigation Icon is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickDeviceDetailsImage() {
		if (deviceDetailsImage.isDisplayed()) {
			click(deviceDetailsImage);
			utils.log().info("Add Device Home Page - Clicked on Device Details Image");
			return true;
		} else {
			utils.log().info(
					"Add Device Home Page - Device Details Image is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickSpecificationsImage() {
		if (specificationsImage.isDisplayed()) {
			click(specificationsImage);
			utils.log().info("Add Device Home Page - Clicked on Specifications Image");
			return true;
		} else {
			utils.log().info("Add Device Home Page - Specifications Image is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickDeviceDetailsText() {
		if (deviceDetailsText.isDisplayed()) {
			click(deviceDetailsText);
			utils.log().info("Add Device Home Page - Clicked on Device Details Text");
			return true;
		} else {
			utils.log().info("Add Device Home Page - Device Details Text is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickSpecificationsIText() {
		if (specificationsText.isDisplayed()) {
			click(specificationsText);
			utils.log().info("Add Device Home Page - Clicked on Specifications Text");
			return true;
		} else {
			utils.log().info("Add Device Home Page - Specifications Text is either not visible or is not present on the DOM");
			return false;
		}
	}
	
	public boolean clickMaxRouterTab() {
		if (maxRouterTab.isDisplayed()) {
			click(maxRouterTab);
			utils.log().info("Add Device Home Page - Clicked on mAX Router Tab");
			return true;
		} else {
			utils.log().info("Add Device Home Page - mAX Router Tab is either not visible or is not present on the DOM");
			return false;
		}
	}
	
	public boolean clickCableModemTab() {
		if (cableModemTab.isDisplayed()) {
			click(cableModemTab);
			utils.log().info("Add Device Home Page - Clicked on Cable Modem Tab");
			return true;
		} else {
			utils.log().info("Add Device Home Page - Cable Modem Tab is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean verifyUIOnHomePage() {
		utils.log().info("*****************************************");
		utils.log().info("Details of UI Elements on the Home Page  ");
		utils.log().info("*****************************************");
		try {
			if (homeTitle.isDisplayed())
				utils.log().info("Title " + homeTitle.getText() + " is displayed");
			else
				utils.log().info("Home Title is not displayed");

			if (navigateButton.isDisplayed())
				utils.log().info("Navigate Icon is displayed");
			else
				utils.log().info("Navigate Icon is displayed");

			if (notificationsIcon.isDisplayed())
				utils.log().info("Notifications Icon is displayed");
			else
				utils.log().info("Notifications Icon is not displayed");

			if (maxRouterTab.isDisplayed())
				utils.log().info("Max Router Tab is displayed");
			else
				utils.log().info("Max Router Tab is not displayed");

			if (cableModemTab.isDisplayed())
				utils.log().info("Cable Modem Tab is displayed");
			else
				utils.log().info("cable Modem Tab is not displayed");

			if (cableModemName.isDisplayed())
				utils.log().info("Cable Modem Name : " + cableModemName.getText() + " is displayed");
			else
				utils.log().info("Cable Modem Name is not displayed");

			if (cableModemImage.isDisplayed())
				utils.log().info("Cable Modem Image is displayed");
			else
				utils.log().info("Cable Modem Image is not displayed");

			if (deviceDetailsText.isDisplayed())
				utils.log().info("Device Details Text is displayed");
			else
				utils.log().info("Device Details is not displayed");

			if (deviceDetailsImage.isDisplayed())
				utils.log().info("Device Details Image is displayed");
			else
				utils.log().info("Device Details Image is not displayed");

			if (specificationsText.isDisplayed())
				utils.log().info("Specifications Text is displayed");
			else
				utils.log().info("Specifications is not displayed");

			if (specificationsImage.isDisplayed())
				utils.log().info("Specifications Image is displayed");
			else
				utils.log().info("Specifications Image is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (homeTitle.isDisplayed()) {
			utils.log().info("On Add Device - Home Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - Home Page");
			return false;
		}
	}
}