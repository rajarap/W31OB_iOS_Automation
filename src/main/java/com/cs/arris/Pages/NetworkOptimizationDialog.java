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

public class NetworkOptimizationDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialog_heading") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/dialog_heading']") // text = Network Optimization
	public MobileElement networkOptimizationText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialog_description") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/dialog_description']") // text = Let's check for available software updates for your system.
	public MobileElement networkOptimizationMessage;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_dialog_ok']"), // text = NEXT
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[147,1283][933,1420]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_dialog_ok") 
	})
	public MobileElement okButton;
	
	public NetworkOptimizationDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickOkButton()
	{
		click(okButton);
		utils.log().info("Network Optimization Dialog - Clicked on OK Button");
	}

	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
