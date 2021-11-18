package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NetworkGeneralSettingsBridgeModeInfoDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/cancel_dialog")
	public MobileElement closeButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_header_dialog") 
	public MobileElement bridgeModetitle;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_description") 
	public MobileElement bridgeModedescription;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ok_dialog") 
	public MobileElement okButton;
	
	
	public NetworkGeneralSettingsBridgeModeInfoDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void clickCloseButton() {
		try {
			if (closeButton.isDisplayed()) {
				click(closeButton);
				utils.log().info("Clicked on Close Button");}
		} catch (Exception e) {
			utils.log().info("Close button is not displayed");
		}
	}


	@Override
	public boolean isAt() {
		if (bridgeModetitle.isDisplayed()) {
			utils.log().info("On Bridge Mode Info Dialog");
			return true;
		} else {
			utils.log().info("Not on Bridge Mode Info Dialog");
			return false;
		}
	}
}
