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

public class AddDeviceAccessCameraDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/dialog_title")
	public MobileElement accessCameraTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/dialog_description")
	public MobileElement description;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_dialog_close")
	public MobileElement closeIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ok_btn")
	public MobileElement okButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tv_donot_allow")
	public MobileElement enterManuallyButton;

	public AddDeviceAccessCameraDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickOkButton() {
		if (okButton.isDisplayed()) {
			click(okButton);
			utils.log().info("Clicked on OK Button");
			return true;
		} else {
			utils.log().info("OK Button is not displayed");
			return false;
		}
	}

	public boolean clickEnterManuallyButton() {
		if (enterManuallyButton.isDisplayed()) {
			click(enterManuallyButton);
			utils.log().info("Clicked on Enter Manully Button");
			return true;
		} else {
			utils.log().info("Enter Manully Button is not displayed");
			return false;
		}
	}

	public boolean clickCloseIcon() {
		if (closeIcon.isDisplayed()) {
			click(closeIcon);
			utils.log().info("Clicked on Close Icon");
			return true;
		} else {
			utils.log().info("Close Icon is not displayed");
			return false;
		}
	}

	public boolean verifyAccessCameraDialogUI() {
		try {
			if (accessCameraTitle.isDisplayed())
				utils.log().info(accessCameraTitle.getText() + " text is displayed");
			else
				utils.log().info("THE APPLICATION WOULD LIKE TO ACCESS THE CAMERA Text is not displayed");

			if (description.isDisplayed())
				utils.log().info(description.getText() + " text is displayed");
			else
				utils.log().info("Application requries access Text is not displayed");

			if (closeIcon.isDisplayed())
				utils.log().info("Close icon is displayed");
			else
				utils.log().info("Close icon is not displayed");

			if (okButton.isDisplayed())
				utils.log().info("OK button is displayed");
			else
				utils.log().info("OK button is not displayed");

			if (enterManuallyButton.isDisplayed())
				utils.log().info("Enter Manually button is displayed");
			else
				utils.log().info("Enter Manually button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (accessCameraTitle.isDisplayed()) {
			utils.log().info("On Add Device - THE APPLICATION WOULD LIKE TO ACCESS THE CAMERA Dialog");
			return true;
		} else {
			utils.log().info("Not on Add Device - THE APPLICATION WOULD LIKE TO ACCESS THE CAMERA Dialog");
			return false;
		}
	}
}
