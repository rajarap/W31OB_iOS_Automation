package com.cs.arris.Pages;

import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
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

public class RemoveDevicePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Remove_Device_Screen_TitleLabel\"]")
	public MobileElement selectDeviceTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

//	@AndroidFindBy(id = "com.arris.sbcBeta:id/tv_description_text")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Remove_Device_Screen_Label_Title_Cable Modem\"]")
//	public MobileElement description;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/btn_remove_product")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Remove_Device_Screen_Button_Next\"]")
	public MobileElement nextButton;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Remove_Device_Screen_Label_Description_W133/W31\"]")
	public MobileElement deviceName1;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Remove_Device_Screen_Image_BoxW133/W31\"]")
	public MobileElement radioButton1;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Remove_Device_Screen_Label_Title_Cable Modem\"]")
	public MobileElement deviceName2;
	
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageView[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Remove_Device_Screen_Image_BoxCable Modem\"]")
	public MobileElement radioButton2;

	public RemoveDevicePage() {
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
			utils.log().info("Clicked on help Button");
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
	
	public boolean selectDeviceToRemove()
	{
//		if(deviceName1.getText() == "Cable Modem") {
//			click(getDriver().findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView[2]")));
		//utils.log().info("Device Name : " + deviceName2.getText());
		if(deviceName2.getText().contains("Cable Modem")){
			utils.log().info("Selected Device Name : " + deviceName2.getText());
			click(radioButton2);
			return true;
		}else {
				return false;
		}
	}
	

	@Override
	public boolean isAt() {
		if (selectDeviceTitle.isDisplayed()) {
			utils.log().info("On Remove Device - Select Your Device Page");
			return true;
		} else {
			utils.log().info("Not on Remove Device - Select Your Device Page");
			return false;
		}
	}
}