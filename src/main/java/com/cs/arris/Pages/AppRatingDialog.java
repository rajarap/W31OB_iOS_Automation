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
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/feedbackRatingBar") 
	public MobileElement appRatingStarBar;
	
	@AndroidFindBy (xpath = "//android.widget.RatingBar[@text='1.0']") 
	public MobileElement oneStar;
	
	@AndroidFindBy (xpath = "//android.widget.RatingBar[@text='2.0']") 
	public MobileElement twoStar;
	
	@AndroidFindBy (xpath = "//android.widget.RatingBar[@text='3.0']") 
	public MobileElement threeStar;
	
	@AndroidFindBy (xpath = "//android.widget.RatingBar[@text='4.0']") 
	public MobileElement fourStar;
	
	@AndroidFindBy (xpath = "//android.widget.RatingBar[@text='5.0']")  
	public MobileElement fiveStar;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/feedbackCommentDescEdt") 
	public MobileElement feebackTextBox;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/btnSaveChanges") 
	public MobileElement saveButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/btnSaveChanges") 
	public MobileElement sendFeedBackButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/feedbackDescTxt") 
	public MobileElement weAreGlabMessage;  // only for 4.0/5.0 rating
	
		@AndroidFindBy (id = "com.arris.sbcBeta:id/btnSaveChanges") 
	public MobileElement reviewOnPlayStoreButton;// only for 4.0/5.0 rating
			
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
	
	public boolean clickStarBar() {
		if (appRatingStarBar.isDisplayed()) {
			click(appRatingStarBar);
			utils.log().info("App Rating Dialog - Clicked on Star Bar");
		}
			return true;
	}
	
	public boolean clickOneStar() {
		if (oneStar.isDisplayed()) {
			click(oneStar);
			utils.log().info("App Rating Dialog - Clicked on One Star");
		}
			return true;
	}
	
	public boolean clickTwoStar() {
		if (twoStar.isDisplayed()) {
			click(twoStar);
			utils.log().info("App Rating Dialog - Clicked on Two Star");
		}
			return true;
	}
	
	public boolean clickThreeStar() {
		if (threeStar.isDisplayed()) {
			click(threeStar);
			utils.log().info("App Rating Dialog - Clicked on Three Star");
		}
			return true;
	}
	
	public boolean clickFourStar() {
		if (fourStar.isDisplayed()) {
			click(fourStar);
			utils.log().info("App Rating Dialog - Clicked on Four Star");
		}
			return true;
	}
	
	public boolean clickFiveStar() {
		if (fiveStar.isDisplayed()) {
			click(fiveStar);
			utils.log().info("App Rating Dialog - Clicked on Five Star");
		}
			return true;
	}
	
	public boolean enterFeedback() {
		if (feebackTextBox.isDisplayed()) {
			sendKeys(feebackTextBox, "Needs Improvement");
			utils.log().info("App Rating Dialog - Entered feedback");
		}
			return true;
	}

	public boolean clickSaveButton() {
		if (saveButton.isDisplayed()) {
			click(saveButton);
			utils.log().info("App Rating Dialog - Clicked on Save Button");
		}
			return true;
	}
	
	public boolean clickSendFeebackButton() {
		if (sendFeedBackButton.isDisplayed()) {
			click(sendFeedBackButton);
			utils.log().info("App Rating Dialog - Clicked on Send Feedback Button");
		}
			return true;
	}
	
	public boolean clickRemindMeLaterLink() {
		if (remindMeLaterText.isDisplayed()) {
			click(remindMeLaterText);
			utils.log().info("App Rating Dialog - Clicked on Remind Me Later Button");
		}
			return true;
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
