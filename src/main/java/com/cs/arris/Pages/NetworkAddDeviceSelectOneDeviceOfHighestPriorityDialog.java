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

public class NetworkAddDeviceSelectOneDeviceOfHighestPriorityDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/titleTextView")
	public MobileElement title;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/messageTextView")
	public MobileElement description;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/imageView")
	public MobileElement closeIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/okay_button")
	public MobileElement okButton;

	public NetworkAddDeviceSelectOneDeviceOfHighestPriorityDialog() {
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

	public boolean clickCloseButton() {
		if (closeIcon.isDisplayed()) {
			click(closeIcon);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close Button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (description.isDisplayed()) {
			utils.log().info("On Add Device - Only one device can be at Highest Priority Dialog");
			return true;
		} else {
			utils.log().info("Not on Add Device - Only one device can be at Highest Priority Dialog");
			return false;
		}
	}
}
