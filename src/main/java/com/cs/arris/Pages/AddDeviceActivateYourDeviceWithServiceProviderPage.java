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

public class AddDeviceActivateYourDeviceWithServiceProviderPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tv_register_device")
	public MobileElement activateDeviceTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ic_back_icon")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/need_help")
	public MobileElement helpIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tv_description")
	public MobileElement description1;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tv_second_description")
	public MobileElement description2;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tv_device_activated")
	public MobileElement description3;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/btnCallService")
	public MobileElement contactServiceProviderButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/btnSelfActivated")
	public MobileElement selfActivateButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/btn_skip")
	public MobileElement skipButton;

	public AddDeviceActivateYourDeviceWithServiceProviderPage() {
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

	public boolean clickSkipButton() {
		if (skipButton.isDisplayed()) {
			click(skipButton);
			utils.log().info("Clicked on Skip Button");
			return true;
		} else {
			utils.log().info("Skip Button is not displayed");
			return false;
		}
	}

	public boolean clickContactServiceProvideButton() {
		if (contactServiceProviderButton.isDisplayed()) {
			click(contactServiceProviderButton);
			utils.log().info("Clicked on Contact Service Provider Button");
			return true;
		} else {
			utils.log().info("Contact Service Provide Button is not displayed");
			return false;
		}
	}

	public boolean clickSelfActivateButton() {
		if (selfActivateButton.isDisplayed()) {
			click(selfActivateButton);
			utils.log().info("Clicked on Self Activate Button");
			return true;
		} else {
			utils.log().info("Self Activate  Button is not displayed");
			return false;
		}
	}

	public boolean verifyActivateDeviceUI() {
		try {
			if (activateDeviceTitle.isDisplayed())
				utils.log().info(activateDeviceTitle.getText() + " text is displayed");
			else
				utils.log().info("CHOOSE YOUR INTERNET SERVICE PROVIDER Text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back button is displayed");
			else
				utils.log().info("Back button is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help icon is displayed");
			else
				utils.log().info("Help icon is not displayed");

			if (description1.isDisplayed())
				utils.log().info(description1.getText() + " text is displayed");
			else
				utils.log().info("Activation is required  Text is not displayed");

			if (description2.isDisplayed())
				utils.log().info(description2.getText() + " text is displayed");
			else
				utils.log().info("Please choose the method  Text is not displayed");

			if (description3.isDisplayed())
				utils.log().info(description3.getText() + " text is displayed");
			else
				utils.log().info(
						"If the device has already been activated, press Skip button below Text is not displayed");

			if (contactServiceProviderButton.isDisplayed())
				utils.log().info(skipButton.getText() + " button is displayed");
			else
				utils.log().info("CONTACT SERVICE PROVIDER button is not displayed");

			if (selfActivateButton.isDisplayed())
				utils.log().info(skipButton.getText() + " button is displayed");
			else
				utils.log().info("SELF ACTIVATE button is not displayed");

			if (skipButton.isDisplayed())
				utils.log().info(skipButton.getText() + " button is displayed");
			else
				utils.log().info("Skip button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (activateDeviceTitle.isDisplayed()) {
			utils.log().info("On Add Device - ACTIVATE YOUR DEVICE WITH SERVICE PROVIDER Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - ACTIVATE YOUR DEVICE WITH SERVICE PROVIDER Page");
			return false;
		}
	}
}