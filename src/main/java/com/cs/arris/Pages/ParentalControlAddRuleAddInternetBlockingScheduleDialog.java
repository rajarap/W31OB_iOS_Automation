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

	public class ParentalControlAddRuleAddInternetBlockingScheduleDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/time_block_cancel_dialog")
	public MobileElement closeButton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/time_block_heading")
	public MobileElement addInternetBlockingScheduleTitle;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/time_block_protocol")
	public MobileElement selectScheduleDays;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/btn_every_day")
	public MobileElement everydayButton;
		
	@AndroidFindBy(id = "com.arris.sbcBeta:id/btn_custom")
	public MobileElement customButton;
		
	@AndroidFindBy(id = "com.arris.sbcBeta:id/tvFrom")
	public MobileElement startTime;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/tvTo")
	public MobileElement endTime;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/tvStartTime")
	public MobileElement addStartTimeLink;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/tvEndTime")
	public MobileElement addStopTimeLink;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/save_time_blocks")
	public MobileElement saveChangesButton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/select_days")
	public MobileElement selectDaysLabel;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/cbSunday")
	public MobileElement sunday;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/cbMonday")
	public MobileElement monday;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/cbTuesday")
	public MobileElement tuesday;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/cbWednesday")
	public MobileElement wednesday;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/cbThrusday")
	public MobileElement thrusday;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/cbFriday")
	public MobileElement friday;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/cbSaturday")
	public MobileElement saturday;
	
	public ParentalControlUserProfileAddRuleDatePickerDialog getDatePickerDialogObject(){
		ParentalControlUserProfileAddRuleDatePickerDialog datePickerDialog = new ParentalControlUserProfileAddRuleDatePickerDialog();
		return datePickerDialog;
	}

	public ParentalControlAddRuleAddInternetBlockingScheduleDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void verifyUIOnAddRuleHelpPage() {
		try {
			if (addInternetBlockingScheduleTitle.isDisplayed())
				utils.log().info(addInternetBlockingScheduleTitle.getText() + " title is displayed ");
		} catch (Exception e) {
			utils.log().info("Add Internet Blocking Schedule title is not displayed");
		}
		
		try {
			if (selectScheduleDays.isDisplayed())
				utils.log().info(selectScheduleDays.getText() + " text is displayed ");
		} catch (Exception e) {
			utils.log().info("Select Schedule Days Text is not displayed");
		}
		
		try {
			if (everydayButton.isDisplayed())
				utils.log().info("EVERY DAY button is displayed ");
		} catch (Exception e) {
			utils.log().info("EVERY DAY button is not displayed");
		}
		
		try {
			if (customButton.isDisplayed())
				utils.log().info("CUSTOM button is displayed ");
		} catch (Exception e) {
			utils.log().info("CUSTOM button is not displayed");
		}
		
		try {
			if (startTime.isDisplayed())
				utils.log().info(startTime.getText() + " text is displayed ");
		} catch (Exception e) {
			utils.log().info("Start Time Text is not displayed");
		}
		
		try {
			if (endTime.isDisplayed())
				utils.log().info(endTime.getText() + " text is displayed ");
		} catch (Exception e) {
			utils.log().info("End Time Text is not displayed");
		}
		
		try {
			if (addStartTimeLink.isDisplayed())
				utils.log().info("Add Start Time Link is displayed ");
		} catch (Exception e) {
			utils.log().info("Add Start Time Link is not displayed");
		}
		
		try {
			if (addStopTimeLink.isDisplayed())
				utils.log().info("Add Stop Time Link text is displayed ");
		} catch (Exception e) {
			utils.log().info("Add Stop Time Link is not displayed");
		}
		
		try {
			if (saveChangesButton.isDisplayed())
				utils.log().info("SAVE CHANGES button is displayed ");
		} catch (Exception e) {
			utils.log().info("SAVE CHANGES button is not displayed");
		}
	}
	
	public void clickCloseButton() {
		try {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
		} catch (Exception e) {
			utils.log().info("Close button is not displayed");
		}
	}
	
	public void clickEveryDayButton() {
		try {
			click(everydayButton);
			utils.log().info("Clicked on Every Day Button");
		} catch (Exception e) {
			utils.log().info("Every Day button is not displayed");
		}
	}

	public void clickCustomButton() {
		try {
			click(customButton);
			utils.log().info("Clicked on Custom Button");
		} catch (Exception e) {
			utils.log().info("Custom button is not displayed");
		}
	}
	
	public void clickStartTimeLink() {
		try {
			click(addStartTimeLink);
			utils.log().info("Clicked Start Time Link");
		} catch (Exception e) {
			utils.log().info("Start Time Link is not displayed");
		}
	}
	
	public void clickStopTimeLink() {
		try {
			click(addStopTimeLink);
			utils.log().info("Clicked Stop Time Link");
		} catch (Exception e) {
			utils.log().info("Stop Time Link is not displayed");
		}
	}
	
	public void clickSaveChangesButton() {
		try {
			click(saveChangesButton);
			utils.log().info("Clicked Save Changes Button");
		} catch (Exception e) {
			utils.log().info("Save Changes Button is not displayed");
		}
	}
	
	public void verifyUIOnCustomClick()
	{
		try {
			if (selectDaysLabel.isDisplayed())
				utils.log().info(selectDaysLabel.getText() + " Label is displayed ");
		} catch (Exception e) {
			utils.log().info("Select days of the week Label is not displayed");
		}
		
		try {
			if (sunday.isDisplayed())
				utils.log().info(sunday.getText() + " button is displayed ");
		} catch (Exception e) {
			utils.log().info("Sunday button is not displayed");
		}
		
		try {
			if (monday.isDisplayed())
				utils.log().info(monday.getText() + " button is displayed ");
		} catch (Exception e) {
			utils.log().info("Monday button is not displayed");
		}
		
		try {
			if (tuesday.isDisplayed())
				utils.log().info(tuesday.getText() + " button is displayed ");
		} catch (Exception e) {
			utils.log().info("Monday button is not displayed");
		}
		
		try {
			if (wednesday.isDisplayed())
				utils.log().info(wednesday.getText() + " button is displayed ");
		} catch (Exception e) {
			utils.log().info("Wednesday button is not displayed");
		}
		
		try {
			if (thrusday.isDisplayed())
				utils.log().info(thrusday.getText() + " button is displayed ");
		} catch (Exception e) {
			utils.log().info("Thrusday button is not displayed");
		}
		
		try {
			if (friday.isDisplayed())
				utils.log().info(friday.getText() + " button is displayed ");
		} catch (Exception e) {
			utils.log().info("Friday button is not displayed");
		}
		
		try {
			if (saturday.isDisplayed())
				utils.log().info(saturday.getText() + " button is displayed ");
		} catch (Exception e) {
			utils.log().info("Saturday button is not displayed");
		}
	}
	
	public void clickSunday()
	{
		try {
			click(sunday);
			utils.log().info("Clicked Sunday Button");
		} catch (Exception e) {
			utils.log().info("Sunday Button is not displayed");
		}
	}
	
	public void clickMonday()
	{
		try {
			click(monday);
			utils.log().info("Clicked Monday Button");
		} catch (Exception e) {
			utils.log().info("Monday Button is not displayed");
		}
	}
	
	public void clickTuesday()
	{
		try {
			click(sunday);
			utils.log().info("Clicked Tuesday Button");
		} catch (Exception e) {
			utils.log().info("Tuesday Button is not displayed");
		}
	}
	
	public void clickWednesday()
	{
		try {
			click(sunday);
			utils.log().info("Clicked Wednesday Button");
		} catch (Exception e) {
			utils.log().info("Wednesday Button is not displayed");
		}
	}
	
	public void clickThrusday()
	{
		try {
			click(sunday);
			utils.log().info("Clicked Thrusday Button");
		} catch (Exception e) {
			utils.log().info("Thrusday Button is not displayed");
		}
	}
	
	public void clickFriday()
	{
		try {
			click(sunday);
			utils.log().info("Clicked Friday Button");
		} catch (Exception e) {
			utils.log().info("Friday Button is not displayed");
		}
	}
	
	public void clickSaturday()
	{
		try {
			click(sunday);
			utils.log().info("Clicked Saturday Button");
		} catch (Exception e) {
			utils.log().info("Saturday Button is not displayed");
		}
	}
	
	@Override
	public boolean isAt() {
		if (addInternetBlockingScheduleTitle.isDisplayed()) {
			utils.log().info("On Parental Control Add Internet Blocking Schedule Dialog");
			return true;
		} else {
			utils.log().info("Not on Parental Control Add Internet Blocking Schedule Dialog");
			return false;
		}
	}
}
