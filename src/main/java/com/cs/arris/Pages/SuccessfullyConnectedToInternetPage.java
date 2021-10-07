package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SuccessfullyConnectedToInternetPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_f_connect_internet_title") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_f_connect_internet_title']") // text = SUCCESSFULLY CONNECTED TO THE INTERNET
	public MobileElement successfullyConnectedToInternetText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_f_connect_internet_desc") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_f_connect_internet_desc']") // text = Let's check for available software updates for your system.
	public MobileElement maxRouterSoftwareUpdatesText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/btn_connect_internet_retry") 
	//@AndroidFindBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_connect_internet_retry']") // text = NEXT
	public MobileElement nextButton;
	
	public SuccessfullyConnectedToInternetPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
