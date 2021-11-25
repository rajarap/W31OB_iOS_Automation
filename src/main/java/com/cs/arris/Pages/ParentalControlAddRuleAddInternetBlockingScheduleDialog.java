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

	@AndroidFindBy(id = "com.arris.sbcBeta:id/cbThursday")
	public MobileElement thrusday;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/cbFriday")
	public MobileElement friday;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/cbSaturday")
	public MobileElement saturday;
	
	//When start date and end date are same
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/cancel_dialog")
	public MobileElement alertCloseButton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_description")
	public MobileElement errorDescription;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ok_dialog")
	public MobileElement alertOKButton;
	
	
	
	public ParentalControlUserProfileAddRuleDatePickerDialog getDatePickerDialogObject() {
		ParentalControlUserProfileAddRuleDatePickerDialog datePickerDialog = new ParentalControlUserProfileAddRuleDatePickerDialog();
		return datePickerDialog;
	}

	public ParentalControlAddRuleAddInternetBlockingScheduleDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean verifyUIOnAddInternetBlockingScheduleDialog() {
		try {
			if (addInternetBlockingScheduleTitle.isDisplayed())
				utils.log().info(addInternetBlockingScheduleTitle.getText() + " title is displayed ");
			else
				utils.log().info("Add Internet Blocking Schedule title is not displayed");

			if (selectScheduleDays.isDisplayed())
				utils.log().info(selectScheduleDays.getText() + " text is displayed ");
			else
				utils.log().info("Select Schedule Days Text is not displayed");

			if (everydayButton.isDisplayed())
				utils.log().info("EVERY DAY button is displayed ");
			else
				utils.log().info("EVERY DAY button is not displayed");

			if (customButton.isDisplayed())
				utils.log().info("CUSTOM button is displayed ");
			else
				utils.log().info("CUSTOM button is not displayed");

			if (startTime.isDisplayed())
				utils.log().info(startTime.getText() + " text is displayed ");
			else
				utils.log().info("Start Time Text is not displayed");

			if (endTime.isDisplayed())
				utils.log().info(endTime.getText() + " text is displayed ");
			else
				utils.log().info("End Time Text is not displayed");

			if (addStartTimeLink.isDisplayed())
				utils.log().info("Add Start Time Link is displayed ");
			else
				utils.log().info("Add Start Time Link is not displayed");

			if (addStopTimeLink.isDisplayed())
				utils.log().info("Add Stop Time Link text is displayed ");
			else
				utils.log().info("Add Stop Time Link is not displayed");

			if (saveChangesButton.isDisplayed())
				utils.log().info("SAVE CHANGES button is displayed ");
			else
				utils.log().info("SAVE CHANGES button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			new SwipeActions().swipeScreen(Direction.UP);
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}
	
	public boolean clickAlertCloseButton() {
		if (alertCloseButton.isDisplayed()) {
			click(alertCloseButton);
			utils.log().info("Clicked Close buton on Alert Dialog");
			return true;
		} else {
			utils.log().info("Alert Close button is not displayed");
			return false;
		}
	}
	
	public boolean clickAlertOKButton() {
		if (alertOKButton.isDisplayed()) {
			click(alertOKButton);
			utils.log().info("Clicked OK button on Alert Dialog");
			return true;
		} else {
			utils.log().info("Alert OK button is not displayed");
			return false;
		}
	}

	public boolean clickEveryDayButton() {
		if (everydayButton.isDisplayed()) {
			click(everydayButton);
			utils.log().info("Clicked on Every Day Button");
			return true;
		} else {
			utils.log().info("Every Day button is not displayed");
			return false;
		}
	}

	public boolean clickCustomButton() {
		if (customButton.isDisplayed()) {
			click(customButton);
			utils.log().info("Clicked on Custom Button");
			return true;
		} else {
			utils.log().info("Custom button is not displayed");
			return false;
		}
	}

	public boolean clickStartTimeLink() {
		if (addStartTimeLink.isDisplayed()) {
			click(addStartTimeLink);
			utils.log().info("Clicked Start Time Link");
			return true;
		} else {
			utils.log().info("Start Time Link is not displayed");
			return false;
		}
	}

	public boolean clickStopTimeLink() {
		if (addStopTimeLink.isDisplayed()) {
			click(addStopTimeLink);
			utils.log().info("Clicked Stop Time Link");
			return true;
		} else {
			utils.log().info("Stop Time Link is not displayed");
			return false;
		}
	}

	public boolean clickSaveChangesButton() {
		if (saveChangesButton.isDisplayed()) {
			click(saveChangesButton);
			utils.log().info("Clicked Save Changes Button");
			return true;
		} else {
			utils.log().info("Save Changes Button is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnCustomClick() {
		try {
			if (selectDaysLabel.isDisplayed())
				utils.log().info(selectDaysLabel.getText() + " Label is displayed ");
			else
				utils.log().info("Select days of the week Label is not displayed");

			if (sunday.isDisplayed())
				utils.log().info(sunday.getText() + " button is displayed ");
			else
				utils.log().info("Sunday button is not displayed");

			if (monday.isDisplayed())
				utils.log().info(monday.getText() + " button is displayed ");
			else
				utils.log().info("Monday button is not displayed");

			if (tuesday.isDisplayed())
				utils.log().info(tuesday.getText() + " button is displayed ");
			else
				utils.log().info("Monday button is not displayed");

			if (wednesday.isDisplayed())
				utils.log().info(wednesday.getText() + " button is displayed ");
			else
				utils.log().info("Wednesday button is not displayed");

			if (thrusday.isDisplayed())
				utils.log().info(thrusday.getText() + " button is displayed ");
			else
				utils.log().info("Thrusday button is not displayed");

			if (friday.isDisplayed())
				utils.log().info(friday.getText() + " button is displayed ");
			else
				utils.log().info("Friday button is not displayed");

			if (saturday.isDisplayed())
				utils.log().info(saturday.getText() + " button is displayed ");
			else
				utils.log().info("Saturday button is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickSunday() {
		if (sunday.isDisplayed()) {
			click(sunday);
			utils.log().info("Clicked Sunday Button");
			return true;
		} else {
			utils.log().info("Sunday Button is not displayed");
			return false;
		}
	}

	public boolean clickMonday() {
		if (monday.isDisplayed()) {
			click(monday);
			utils.log().info("Clicked Monday Button");
			return true;
		} else {
			utils.log().info("Monday Button is not displayed");
			return false;
		}
	}

	public boolean clickTuesday() {
		if (tuesday.isDisplayed()) {
			click(tuesday);
			utils.log().info("Clicked Tuesday Button");
			return true;
		} else {
			utils.log().info("Tuesday Button is not displayed");
			return false;
		}
	}

	public boolean clickWednesday() {
		if (wednesday.isDisplayed()) {
			click(wednesday);
			utils.log().info("Clicked Wednesday Button");
			return true;
		} else {
			utils.log().info("Wednesday Button is not displayed");
			return false;
		}
	}

	public boolean clickThrusday() {
		if (thrusday.isDisplayed()) {
			click(thrusday);
			utils.log().info("Clicked Thrusday Button");
			return true;
		} else {
			utils.log().info("Thrusday Button is not displayed");
			return false;
		}
	}

	public boolean clickFriday() {
		if (friday.isDisplayed()) {
			click(friday);
			utils.log().info("Clicked Friday Button");
			return true;
		} else {
			utils.log().info("Friday Button is not displayed");
			return false;
		}
	}

	public boolean clickSaturday() {
		if (saturday.isDisplayed()) {
			click(saturday);
			utils.log().info("Clicked Saturday Button");
			return true;
		} else {
			utils.log().info("Saturday Button is not displayed");
			return false;
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
