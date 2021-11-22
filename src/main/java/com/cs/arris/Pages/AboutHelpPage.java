package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AboutHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/ivDialogClose]"), // CONTINUE
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[915,146][1046,241]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/ivDialogClose") })
	public MobileElement closeButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[52,513][1029,671]']") // About
	public MobileElement aboutText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[52,731][1029,968]']")
	public MobileElement aboutHelpText;
	
	public AboutHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			click(closeButton); 
			utils.log().info("Clicked Close Button");
			return true;
		} else {
			return false;
		}
	}

	public void verifyUIOnAboutHelpPage() {
		try {
			if (aboutHelpText.isDisplayed())
				utils.log().info(aboutHelpText.getText() + " Text is displayed ");
		} catch (Exception e) {
			utils.log().info("Information about Application and Firwnware Version is not displayed");
		}
	}

	@Override
	public boolean isAt() {
		if (aboutText.isDisplayed()) {
			utils.log().info("On About Help Page");
			return true;
		} else {
			utils.log().info("Not on About Help Page");
			return false;
		}

	}

}
