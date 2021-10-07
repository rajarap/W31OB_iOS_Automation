package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MaxRouterSuccessfullyConnectedToMobileDeivcePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text']") // text = SUCCESSFULLY CONNECTED
	public MobileElement successfullyConnectedText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_description_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_description_text']") // text = Your mAX router is now connected to your mobile device.
	public MobileElement maxRouterConnectedToMobileText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/btn_bluetooth_pairing_success_Continue") 
	//@AndroidFindBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_bluetooth_pairing_success_Continue']") // text = NEXT
	public MobileElement nextButton;
	
	public MaxRouterSuccessfullyConnectedToMobileDeivcePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
