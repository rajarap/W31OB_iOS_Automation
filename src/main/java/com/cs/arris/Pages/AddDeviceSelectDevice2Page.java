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

public class AddDeviceSelectDevice2Page extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/title_product_selection")
	public MobileElement selectDeviceTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@rsource-id='com.arris.sbcBeta:id/ic_back_icon']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca")
	public MobileElement cloudIcon;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@rsource-id='com.arris.sbcBeta:id/need_help']")
	public MobileElement helpIcon;

	@AndroidFindBy(xpath = "//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup[1]/android.widget.GridView/android.view.ViewGroup[5]/android.widget.RelativeLayout/android.widget.ImageView[1]")
	public MobileElement t25RoutersImage;

	@AndroidFindBy(xpath = "//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup[1]/android.widget.GridView/android.view.ViewGroup[5]/android.widget.RelativeLayout/android.widget.ImageView[2]")
	public MobileElement t25RadioButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/btn_product_next")
	public MobileElement nextButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/product_selection_description")
	public MobileElement productSelectionDescription;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_app_store_link")
	public MobileElement playStoreLink;

	public AddDeviceSelectDevice2Page() {
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

	public boolean selectT25RadioButton() {
		super.swipeUp();
		if (t25RoutersImage.isDisplayed() && t25RadioButton.isDisplayed()) {
			click(t25RadioButton);
			utils.log().info("Clicked on T25 Radio Button");
			return true;
		} else {
			utils.log().info("T25 Radio Button is not displayed");
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

	public boolean clickPlayStoreLink() {
		if (playStoreLink.isDisplayed()) {
			click(playStoreLink);
			utils.log().info("Clicked on PlayStore Link Text");
			return true;
		} else {
			utils.log().info("PlayStore Link Text is not displayed");
			return false;
		}
	}

	public boolean verifySelectYourDevice2UI() {
		try {
			if (selectDeviceTitle.isDisplayed())
				utils.log().info(selectDeviceTitle.getText() + " text is displayed");
			else
				utils.log().info("Select Your Device Text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back button is displayed");
			else
				utils.log().info("Back button is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help icon is displayed");
			else
				utils.log().info("Help icon is not displayed");

			if (t25RoutersImage.isDisplayed())
				utils.log().info("T25 Router Image is displayed");
			else
				utils.log().info("T25 Router Image is not displayed");

			if (t25RadioButton.isDisplayed())
				utils.log().info("T25 Radio button is displayed");
			else
				utils.log().info("T25 Radio button is not displayed");

			if (productSelectionDescription.isDisplayed())
				utils.log().info(productSelectionDescription.getText() + " text is displayed");
			else
				utils.log().info("Product Selection text is not displayed");

			if (playStoreLink.isDisplayed())
				utils.log().info(playStoreLink.getText() + " text is displayed");
			else
				utils.log().info("Play Store Link text is not displayed");

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
		if (selectDeviceTitle.isDisplayed()) {
			utils.log().info("On Add Device - Select You Device Below 2 Page");
			return true;
		} else {
			utils.log().info("Not on  Add Device - Select You Device Below 2 Page");
			return false;
		}
	}
}
