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

public class AddDeviceLetsStartWithDeviceConnectionPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/title_text")
	public MobileElement StartDeviceConnectionTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ic_back_icon")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca")
	public MobileElement cloudIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/need_help")
	public MobileElement helpIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/description_text1")
	public MobileElement descriptionText1;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/description_text2")
	public MobileElement descriptionText2;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/description_text3")
	public MobileElement descriptionText3;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/need_help")
	public MobileElement descriptionText4;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/description_text4")
	public MobileElement nextButton;

	public AddDeviceLetsStartWithDeviceConnectionPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
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

	public boolean clickNextButton() {
		if (nextButton.isDisplayed()) {
			click(nextButton);
			utils.log().info("Clicked on Next Button");
			return true;
		} else {
			utils.log().info("Next Button is not displayed");
			return false;
		}
	}

	public boolean verifyStartDeviceConnectionUI() {
		try {
			if (StartDeviceConnectionTitle.isDisplayed())
				utils.log().info(StartDeviceConnectionTitle.getText() + " text is displayed");
			else
				utils.log().info("Steps For Activation Text is not displayed");
			if (backIcon.isDisplayed())
				utils.log().info("Back button is displayed");
			else
				utils.log().info("Back button is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help icon is displayed");
			else
				utils.log().info("Help icon is not displayed");

			if (descriptionText1.isDisplayed())
				utils.log().info(descriptionText1.getText() + " text is displayed");
			else
				utils.log().info("Remove your existing modem/gateway Text is not displayed");

			if (descriptionText2.isDisplayed())
				utils.log().info(descriptionText2.getText() + " text is displayed");
			else
				utils.log().info("Connect the coax cable behind the Text is not displayed");

			if (descriptionText3.isDisplayed())
				utils.log().info(descriptionText3.getText() + " text is displayed");
			else
				utils.log().info("device being installed Text is not displayed");

			if (descriptionText4.isDisplayed())
				utils.log().info(descriptionText4.getText() + " text is displayed");
			else
				utils.log().info("Plug in and power up your device Text is not displayed");

			if (nextButton.isDisplayed())
				utils.log().info(nextButton.getText() + " button is displayed");
			else
				utils.log().info("NEXT button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (StartDeviceConnectionTitle.isDisplayed()) {
			utils.log().info("On Add Device - Let's Start With Device Connection Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - Let's Start With Device Connection Page");
			return false;
		}
	}
}
