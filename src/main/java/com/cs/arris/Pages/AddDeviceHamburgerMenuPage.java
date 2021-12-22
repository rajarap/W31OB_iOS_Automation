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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddDeviceHamburgerMenuPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/nav_add_device")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add Device\"]")
	public MobileElement addDevice;  //must be disabled. Onclick of add device, Add device dialog box should be displayed

	@AndroidFindBy(id = "com.arris.sbcBeta:id/nav_remove_device")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Remove Device\"]")
	public MobileElement removeDevice;

	public AddDeviceHamburgerMenuPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	 public HomePage getHomePageObject() {
		 HomePage homePage = new HomePage();
	     return homePage;
	  }
	 
	 public boolean clickAddDeviceButton() {
			if (addDevice.isDisplayed()) {
				click(addDevice);
				utils.log().info("Clicked on Add Device Button");
				return true;
			} else {
				utils.log().info("Add Device button is not displayed");
				return false;
			}
		}

		public boolean clickRemoveDeviceButton() {
			if (removeDevice.isDisplayed()) {
				click(removeDevice);
				utils.log().info("Clicked on Remove Device Button");
				return true;
			} else {
				utils.log().info("Remove Device Button is not displayed");
				return false;
			}
		}

	@Override
	public boolean isAt() {
		if (addDevice.isDisplayed()) {
			utils.log().info("On Add Device - Hamburger Menu Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - Hamburger Menu Page");
			return false;
		}
	}
}
