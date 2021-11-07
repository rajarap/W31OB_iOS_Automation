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

public class ParentalControlPauseInternetForAllDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement closeDialog;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_header_dialog")
	public MobileElement pauseInternetTitle;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_description") 
	public MobileElement pauseInternetMessage;
	
	//YES, PAUSE INTERNET
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ok_dialog")
	public MobileElement pauseInternetbutton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_cancel_dialog")
	public MobileElement cancelButton;
	
	public void verifyUIOnPauseInternetForAllDialog() {
		try {
			if (closeDialog.isDisplayed())
				utils.log().info("Close Dialog button is displayed");
		} catch (Exception e) {
			utils.log().info("Close Dialog button is not displayed");
		}

		try {
			if (pauseInternetTitle.isDisplayed())
				utils.log().info(pauseInternetTitle.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Pause Internet for All text is not displayed");
		}
		
		try {
			if (pauseInternetMessage.isDisplayed())
				utils.log().info(pauseInternetMessage.getText() + " message is displayed");
		} catch (Exception e) {
			utils.log().info("All you sure to pause internet for all mesasge is not displayed");
		}

		try {
			if (pauseInternetbutton.isDisplayed())
				utils.log().info(pauseInternetbutton.getText() + "  button is displayed");
		} catch (Exception e) {
			utils.log().info("Pause Internet for All button is not displayed");
		}

		try {
			if (cancelButton.isDisplayed())
				utils.log().info("Cancel Button is displayed");
		} catch (Exception e) {
			utils.log().info("Cancel Button is not displayed");
		}
	}
	
	public void clickPauseInternetForAllButton() {
		click(pauseInternetbutton);
		utils.log().info("Internet is paused for all profiles");
	}

	public void clickCancelButton() {
		click(cancelButton);
		utils.log().info("Internet will not be paused for all profiles");
	}

	public void clickCloseButton() {
		click(closeDialog);
		utils.log().info("Internet will not be paused for all profiles");
	}

	@Override
	public boolean isAt() {
		if (pauseInternetTitle.isDisplayed()) {
			utils.log().info("On Pause Internet for all dialog");
			return true;
		} else {
			utils.log().info("Not on Pause Internet for all dialog");
			return false;
		}
	}
}
