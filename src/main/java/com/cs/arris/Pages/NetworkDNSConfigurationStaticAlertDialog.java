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

public class NetworkDNSConfigurationStaticAlertDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/error_header_dialog") 
	public MobileElement alertTitle; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/error_description") 
	public MobileElement alertMessage; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/ok_dialog") 
	public MobileElement okButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/cancel_dialog") 
	public MobileElement cancelDialogIcon; 
		
	public NetworkDNSConfigurationStaticAlertDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickOKButton() {
		try {
			click(okButton);
			utils.log().info("Alert Dialog - Clicked on OK Button");
		} catch (Exception e) {
			utils.log().info("Alert Dialog - OK is not displayd");
		}
	}

	public void clickCloseDialog() {
		try {
			click(cancelDialogIcon);
			utils.log().info("Alert Dialog - Clicked on Close Icon");
		} catch (Exception e) {
			utils.log().info("Alert Dialog - Close Icon is not displayd");
		}
	}

	@Override
	public boolean isAt() {
		if (alertTitle.isDisplayed()) {
			utils.log().info("On Alert Dialog Page");
			return true;
		} else {
			utils.log().info("Not on Alert Dialog Page");
			return false;
		}
	}
}
