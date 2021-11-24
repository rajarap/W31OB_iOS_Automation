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

public class AddDeviceChooseInternetServiceProviderPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tv_header")
	public MobileElement chooseInternetServiceProviderTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ic_back_icon")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca")
	public MobileElement cloudIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/need_help")
	public MobileElement helpIcon;

	
//	@AndroidFindBy(id = "com.arris.sbcBeta:id/btn_next")
//	public MobileElement nextButton;

	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_next"),
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_next']"),
		@AndroidBy (xpath = "//android.widget.Button[@text='NEXT"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[102,1949][978,2042]']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")
	})
	public MobileElement nextButton;
	
	
	public AddDeviceChooseInternetServiceProviderPage() {
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
			super.pause(3);
			utils.log().info("Clicked on Next Button on Choose Internet Service Provider Page");
			return true;
		} else {
			utils.log().info("Next Button is not displayed");
			return false;
		}
	}

	public boolean verifyChoosingInternetProviderUI() {
		try {
			if (chooseInternetServiceProviderTitle.isDisplayed())
				utils.log().info(chooseInternetServiceProviderTitle.getText() + " text is displayed");
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

			if (helpIcon.isDisplayed())
				utils.log().info("Help icon is displayed");
			else
				utils.log().info("Help icon is not displayed");

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
		if (chooseInternetServiceProviderTitle.isDisplayed()) {
			utils.log().info("On Add Device - CHOOSE YOUR INTERNET SERVICE PROVIDER Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - CHOOSE YOUR INTERNET SERVICE PROVIDER Page");
			return false;
		}
	}
}
