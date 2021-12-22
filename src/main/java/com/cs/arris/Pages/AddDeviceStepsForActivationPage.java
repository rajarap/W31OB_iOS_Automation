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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddDeviceStepsForActivationPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/title_text")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Activation_Step_Screen_TitleLabel_StepsForActivation\"]")
	public MobileElement stepsForActivation;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/description_text")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Activation_Step_Screen_SubTitleLabel_ThereAreJustAFewSteps\"]")
	public MobileElement titleDescriptionText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/step_one_background")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Activation_Step_Screen_Image_Step1\"]")
	public MobileElement firstSquareBox;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/step_one_text")
	public MobileElement step1Text;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/step_one_description")
	public MobileElement step1Description;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/step_two_background")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Activation_Step_Screen_Image_Step2\"]")
	public MobileElement secondSquareBox;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/step_two_text")
	public MobileElement step2Text;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/step_two_description")
	public MobileElement step2Description;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/btn_lets_start")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activation_Step_Screen_Button_LetsStart\"]")
	public MobileElement letsStartButton;

	public AddDeviceStepsForActivationPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickStartButton() {
		if (letsStartButton.isDisplayed()) {
			click(letsStartButton);
			utils.log().info("Clicked on Let's Start Button");
			return true;
		} else {
			utils.log().info("Let's Start Button is not displayed");
			return false;
		}
	}

	public boolean verifyStepsForActivationUI() {
		try {
			if (stepsForActivation.isDisplayed())
				utils.log().info(stepsForActivation.getText() + " text is displayed");
			else
				utils.log().info("Steps For Activation Text is not displayed");

			if (titleDescriptionText.isDisplayed())
				utils.log().info(titleDescriptionText.getText() + " text is displayed");
			else
				utils.log().info("Description Text is not displayed");

//			if (step1Text.isDisplayed() && step1Description.isDisplayed())
//				utils.log().info(step1Text.getText() + " : " + step1Description.getText() + " is displayed");
//			else
//				utils.log().info("Step 1 information is not displayed");
//
//			if (step2Text.isDisplayed() && step2Description.isDisplayed())
//				utils.log().info(step2Text.getText() + " : " + step2Description.getText() + " is displayed");
//			else
//				utils.log().info("Step 2 information is not displayed");
			
			if (firstSquareBox.isDisplayed())
				utils.log().info("Step1 box is displayed");
			else
				utils.log().info("Step1 box is not displayed");

			if (secondSquareBox.isDisplayed())
				utils.log().info("Step2 box is displayed");
			else
				utils.log().info("Step2 box is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (stepsForActivation.isDisplayed()) {
			utils.log().info("On Add Device - Steps For Activation Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - Steps For Activation Page");
			return false;
		}
	}
}
