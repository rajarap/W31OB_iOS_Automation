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

public class AddDeviceSelectDevice1Page extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/title_text")
	public MobileElement selectDeviceTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ic_back_icon")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca")
	public MobileElement cloudIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/need_help")
	public MobileElement helpIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/product_category_selection_bg")
	public MobileElement bgRoutersImage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ISP cable connected without Wi-Fi']")
	public MobileElement ispCableWithoutWiFiText;

	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView")
	public MobileElement ispCableWithoutWiFiRadioButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/btn_product_next")
	public MobileElement nextButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/app_help_selection")
	public MobileElement helpMeWithSelectionLink;

	// On click of help me with selection link

	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_header_dialog")
	public MobileElement selectProductCategoryTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/cancel_dialog")
	public MobileElement cancelIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ok_dialog")
	public MobileElement okButton;

	// On click of help me with selection link

	public AddDeviceSelectDevice1Page() {
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

	public boolean selectISPCableRadioButton() {
		if (ispCableWithoutWiFiRadioButton.isDisplayed()) {
			click(ispCableWithoutWiFiRadioButton);
			utils.log().info("Clicked on ISP Cable Connected without Wi-Fi Radio Button");
			return true;
		} else {
			utils.log().info("ISP Cable Connected without Wi-Fi Radio Button is not displayed");
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

	public boolean clickHelpMeWithSelectionLink() {
		if (helpMeWithSelectionLink.isDisplayed()) {
			click(helpMeWithSelectionLink);
			utils.log().info("Clicked on Help Me With the Selection help text");
			return true;
		} else {
			utils.log().info("Help Me With the Selection help text is not displayed");
			return false;
		}
	}

	public boolean clickOKButton() {
		if (selectProductCategoryTitle.isDisplayed() && okButton.isDisplayed()) {
			click(okButton);
			utils.log().info("Clicked OK button on Selecting Product Category Help Dialog");
			return true;
		} else {
			utils.log().info("Selecting Product Category Help Dialog did not appear");
			return false;
		}
	}

	public boolean verifySelectYourDevice1UI() {
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

			if (bgRoutersImage.isDisplayed())
				utils.log().info("Background Router Image is displayed");
			else
				utils.log().info("Background Router Image is not displayed");

			if (ispCableWithoutWiFiText.isDisplayed())
				utils.log().info(ispCableWithoutWiFiText.getText() + " text is displayed");
			else
				utils.log().info("ISP Cable connected without Wi-Fi text is not displayed");

			if (ispCableWithoutWiFiRadioButton.isDisplayed())
				utils.log().info("ISP Cable connected without Wi-Fi Radio button is displayed");
			else
				utils.log().info("ISP Cable connected without Wi-Fi Radio button is not displayed");

			if (helpMeWithSelectionLink.isDisplayed())
				utils.log().info(helpMeWithSelectionLink.getText() + " text is displayed");
			else
				utils.log().info("Help Me With the Selection help text is not displayed");

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
			utils.log().info("On Add Device - Select You Device Below 1 Page");
			return true;
		} else {
			utils.log().info("Not on  Add Device - Select You Device Below 1 Page");
			return false;
		}
	}
}
