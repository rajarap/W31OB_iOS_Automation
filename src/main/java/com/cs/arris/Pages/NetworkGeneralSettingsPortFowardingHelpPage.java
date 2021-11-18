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

public class NetworkGeneralSettingsPortFowardingHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ivDialogClose")
	public MobileElement closeButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Port forwarding']") 
	public MobileElement portForwardingtitle;
	

	public NetworkGeneralSettingsPortFowardingHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void clickCloseButton() {
		try {
			if (closeButton.isDisplayed()) {
				new SwipeActions().swipeScreen(Direction.UP);
				click(closeButton);
				utils.log().info("Clicked on Close Button");}
		} catch (Exception e) {
			utils.log().info("Close button is not displayed");
		}
	}

	@Override
	public boolean isAt() {
		if (portForwardingtitle.isDisplayed()) {
			utils.log().info("On Port Forwarding Help Page");
			return true;
		} else {
			utils.log().info("Not on Port Forwarding Help Page");
			return false;
		}
	}
}
