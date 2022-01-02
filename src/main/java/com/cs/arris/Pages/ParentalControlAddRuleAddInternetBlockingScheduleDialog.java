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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ParentalControlAddRuleAddInternetBlockingScheduleDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_Button_Close\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Time_Schedule_Screen_Label_AddTime\"]")
	public MobileElement addInternetBlockingScheduleTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Time_Schedule_Screen_Label_SelectSchedule\"]")
	public MobileElement selectScheduleDays;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_EveryDay\"]")
	public MobileElement everydayButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_Custom\"]")
	public MobileElement customButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Time_Schedule_Screen_Label_StartTimeTitle\"]")
	public MobileElement startTime;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Time_Schedule_Screen_Label_EndTimeTitle\"]")
	public MobileElement endTime;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Time_Schedule_Screen_Label_StartTime\"]")
	public MobileElement addStartTimeLink;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Time_Schedule_Screen_Label_EndTime\"]")
	public MobileElement addStopTimeLink;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_Button_Save\"]")
	public MobileElement saveChangesButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Time_Schedule_Screen_Label_Select\"]")
	public MobileElement selectDaysLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_Button_Sunday\"]")
	public MobileElement sunday;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_Button_Monday\"]")
	public MobileElement monday;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_Button_Tuesday\"]")
	public MobileElement tuesday;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_Button_Wednesday\"]")
	public MobileElement wednesday;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_Button_Thursday\"]")
	public MobileElement thrusday;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_Button_Friday\"]")
	public MobileElement friday;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_Button_Saturday\"]")
	public MobileElement saturday;
	
	//When start date and end date are same
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Time_Schedule_Screen_Label_Error\"]")
	public MobileElement errorDescriptionWhenNoDaysAreSelected;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Time_Schedule_Screen_Label_Error\"]")
	public MobileElement errorDescriptionForSameStartEndTime;
	
	
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
