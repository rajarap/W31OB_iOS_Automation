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

public class AddDeviceSuccessPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text")
	public MobileElement successTitle; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/ic_back_icon")
	public MobileElement backIcon; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") 
	public MobileElement cloudIcon; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/need_help")
	public MobileElement helpIcon; 
		
	@AndroidFindBy (id = "com.arris.sbcBeta:id/description_text")
	public MobileElement descriptionText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_next")
	public MobileElement nextButton;


	public AddDeviceSuccessPage()
	{
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
				utils.log().info("Clicked on Next Button");
				return true;
			} else {
				utils.log().info("Next Button is not displayed");
				return false;
			}
		}

		public boolean verifyEstablishingConnectionUI() {
			try {
				if (successTitle.isDisplayed())
					utils.log().info(successTitle.getText() + " text is displayed");
				else
					utils.log().info("SUCCESS! Text is not displayed");

				if (backIcon.isDisplayed())
					utils.log().info("Back button is displayed");
				else
					utils.log().info("Back button is not displayed");

				if (helpIcon.isDisplayed())
					utils.log().info("Help icon is displayed");
				else
					utils.log().info("Help icon is not displayed");

				if (descriptionText.isDisplayed())
					utils.log().info(descriptionText.getText() + " text is displayed");
				else
					utils.log().info("You are almost done! Text is not displayed");

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
			if (successTitle.isDisplayed()) {
				utils.log().info("On Add Device - SUCCESS! Page");
				return true;
			} else {
				utils.log().info("Not on Add Device - SUCCESS! Page");
				return false;
			}
		}
	}
