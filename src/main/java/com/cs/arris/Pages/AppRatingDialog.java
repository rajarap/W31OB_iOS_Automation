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

public class AppRatingDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/textView9") //Enjoying our SURFboard Central App?
	public MobileElement appRatingTitle; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/textView13") //Let us know how we are doing by rating us below. We welcome your feedback to help us improve.
	public MobileElement appRatingMessage; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/feedbackRatingBar") //
	public MobileElement appRatingStarBar;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/textView10") //Tap the star to rate
	public MobileElement tapTheStarToRate;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/remindMeLaterTxt") //REMIND ME LATER
	public MobileElement remindMeLaterText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/imgCancelDialog") 
	public MobileElement cancelDialogIcon; 
		
	public AppRatingDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean clickRemindMeLaterLink() {
		if (remindMeLaterText.isDisplayed()) {
			click(remindMeLaterText);
			utils.log().info("App Rating Dialog - Clicked on Remind Me Later");
		}
			return true;
	}

	public boolean clickCloseDialog() {
		if (cancelDialogIcon.isDisplayed()) {
			click(cancelDialogIcon);
			utils.log().info("App Rating Dialog - Clicked on Close Icon");
			return true;
		} else {
			utils.log().info("App Rating Dialog - Close Icon is not displayd");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (appRatingTitle.isDisplayed()) {
			utils.log().info("On App Rating Dialog Page");
			return true;
		} else {
			utils.log().info("Not on App Rating Dialog Page");
			return false;
		}
	}
}
