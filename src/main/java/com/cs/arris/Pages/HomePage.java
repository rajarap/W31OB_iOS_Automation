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

public class HomePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle]"),  //INSTALL NOW
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[474,149][606,223]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") 
	})
	public MobileElement homeTitle; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/ssidName"),  
		@AndroidBy (id = "com.arris.sbcBeta:id/ssidName") 
	})
	public MobileElement ssidName; 
	
	
	//Network Optimization dialog elements
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialog_heading") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/dialog_heading']") // text = Network Optimization
	public MobileElement networkOptimizationTitle;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialog_description") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/dialog_description']") // text = Please connect to arrisw3130 through your Mobile Device Wi-Fi settings.
	public MobileElement networkOptimizationMessage;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_dialog_ok']"), // text = NEXT
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[147,1312][933,1449]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_dialog_ok") 
	})
	public MobileElement okButton;
	
	
	public HomePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void getSSIDName()
	{
		String ssidname = ssidName.getText();
		utils.log().info("You are connected to your " + ssidname + " home network....Happy Surfing");
	}
	
	public void clickOkButton()
	{
		click(okButton);
		utils.log().info("Network Optimization Dialog2 - Clicked on OK Button");
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
