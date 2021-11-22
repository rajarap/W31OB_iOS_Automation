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

public class AFFSHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/ivDialogClose']"), 
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[915,146][1046,241]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/ivDialogClose")
	})
	public MobileElement closeButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Amazon AFFS settings']") 
	public MobileElement affsSettingstitle;
	
	
	public AFFSHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		super.swipeUp();
		if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (affsSettingstitle.isDisplayed()) {
			utils.log().info("On AFFS Settings Help Page");
			return true;
		} else {
			utils.log().info("Not on AFFS Settings Help Page");
			return false;
		}
	}
}
