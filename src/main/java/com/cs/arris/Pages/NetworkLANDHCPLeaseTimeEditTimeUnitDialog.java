package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

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

public class NetworkLANDHCPLeaseTimeEditTimeUnitDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/dialogBoxTitle")
	public MobileElement editTimeUnitTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/dialogClose")
	public MobileElement closeIcon;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Minutes']")
	public MobileElement minutes;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Hourly']")
	public MobileElement hourly;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Days']")
	public MobileElement days;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Weekly']")
	public MobileElement weekly;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Forever']")
	public MobileElement forever;

	public NetworkLANDHCPLeaseTimeEditTimeUnitDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		if (closeIcon.isDisplayed()) {
			click(closeIcon);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close Button is not displayed");
			return false;
		}
	}

	public boolean clickMinutesRadioButton() {
		if (minutes.isDisplayed()) {
			click(minutes);
			utils.log().info("Clicked on Minutes Radio Button");
			return true;
		} else {
			utils.log().info("Minutes Radio Button is not displayed");
			return false;
		}
	}

	public boolean clickHourlyRadioButton() {
		if (hourly.isDisplayed()) {
			click(hourly);
			utils.log().info("Clicked on Hourly Radio Button");
			return true;
		} else {
			utils.log().info("Hourly Radio Button is not displayed");
			return false;
		}
	}

	public boolean clickDaysRadioButton() {
		if (days.isDisplayed()) {
			click(days);
			utils.log().info("Clicked on Days Radio Button");
			return true;
		} else {
			utils.log().info("Days Radio Button is not displayed");
			return false;
		}
	}

	public boolean clickWeeklyRadioButton() {
		if (weekly.isDisplayed()) {
			click(weekly);
			utils.log().info("Clicked on Weekly Radio Button");
			return true;
		} else {
			utils.log().info("Weekly Radio Button is not displayed");
			return false;
		}
	}

	public boolean clickForeverRadioButton() {
		if (forever.isDisplayed()) {
			click(forever);
			utils.log().info("Clicked on Foever Radio Button");
			return true;
		} else {
			utils.log().info("Forever Radio Button is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnLANEditLeaseTimePage() {
		utils.log().info("                                             ");
		utils.log().info("*********************************************");
		utils.log().info("Verifying UI Elements on LAN Lease Time Page ");
		utils.log().info("*********************************************");
		try
		{
			if (editTimeUnitTitle.isDisplayed())
				utils.log().info(editTimeUnitTitle.getText() + " title text is displayed ");
			else
				utils.log().info("LAN DHCP Lease Time text is not displayed");

			if (closeIcon.isDisplayed())
				utils.log().info("Close Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");

			if (minutes.isDisplayed())
				utils.log().info("Minutes Radio button is displayed");
			else
				utils.log().info("Help Icon is not displayed");
		
			if (hourly.isDisplayed())
				utils.log().info("Hourly Radio button is displayed");
			else
				utils.log().info("Set Lease Time label is displayed");
			
			if (days.isDisplayed())
				utils.log().info("Days Radio button is displayed");
			else
				utils.log().info("Enter Lease Time TextBoxis not displayed");
			
			if (weekly.isDisplayed())
				utils.log().info(" Weekly Radio button is displayed");
			else
				utils.log().info("Select Time Unit Label is not displayed");
			
			if (forever.isDisplayed())
				utils.log().info("Forever Radion button is displayed");
			else
				utils.log().info("Button to select the time unit is not displayed");
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (editTimeUnitTitle.isDisplayed()) {
			utils.log().info("On LAN DHCP Lease Edit Time Page");
			return true;
		} else {
			utils.log().info("Not on LAN DHCP Edit Lease Time Page");
			return false;
		}
	}
}
