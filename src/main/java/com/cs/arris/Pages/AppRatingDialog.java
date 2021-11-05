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
	
	@AndroidBy (id = "com.arris.sbcBeta:id/textView9") //Enjoying our SURFboard Central App?
	public MobileElement appRatingTitle; 
	
	@AndroidBy (id = "com.arris.sbcBeta:id/textView13") //Let us know how we are doing by rating us below. We welcome your feedback to help us improve.
	public MobileElement appRatingMessage; 
	
	@AndroidBy (id = "com.arris.sbcBeta:id/feedbackRatingBar") //
	public MobileElement appRatingStarBar;
	
	@AndroidBy (id = "com.arris.sbcBeta:id/textView10") //Tap the star to rate
	public MobileElement tapTheStarToRate;
	
	@AndroidBy (id = "com.arris.sbcBeta:id/remindMeLaterTxt") //REMIND ME LATER
	public MobileElement remindMeLaterText;
	
	@AndroidBy (id = "com.arris.sbcBeta:id/imgCancelDialog") 
	public MobileElement cancelDialogIcon; 
		
	public AppRatingDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickRemindMeLaterLink()
	{
		click(remindMeLaterText);
		utils.log().info("App Rating Dialog - Clicked on Remind Me Later");
	}
	
	public void clickCloseDialog()
	{
		click(cancelDialogIcon);
		utils.log().info("App Rating Dialog - Clicked on Close Icon");
	}
	
	@Override
	public boolean isAt() {
		if(appRatingTitle.isDisplayed())
		{
			utils.log().info("On App Rating Dialog Page");
			return true;}
		else {
			utils.log().info("Not on App Rating Dialog Page");
		return false;}
	}

}
