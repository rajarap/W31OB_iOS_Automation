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

public class ErrorCode_0000_1506_Warranty_Support_Page extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/troubleShootButton_generic']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1983][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/troubleShootButton_generic") 
	})
	public MobileElement continueButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_title") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_title']") // text = SOMETHING WENT WRONG
	public MobileElement somethingWentWrong;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_description") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_description']") // text = 	
	//Sorry, your warranty and support registration has failed as we are unable to reach the server. Please check your internet connection or call 1-877-466-8646 to register your device.
	public MobileElement warrantyAndSupportMessage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_code") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_code']") // text = 0000-1506
	public MobileElement errorCode;  
	
	public ErrorCode_0000_1506_Warranty_Support_Page()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickContinueButton()
	{
		utils.log().info("Warranty and Support Page - Clicked on Continue Button");
		click(continueButton);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	

}
