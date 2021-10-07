package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BlueToothPage extends ParentClass implements Page
{
	TestUtils utils = new TestUtils();
	String BTOn = "Bluetooth, On";
	String BTOff = "Bluetooth, Off";

	@AndroidFindBy (xpath = "//android.widget.Switch[@resource-id='com.android.settings:id/switch_widget']")
	//@AndroidFindBy (xpath = "//aandroid.widget.Switch[@text='Bluetooth, On']")
	public MobileElement blueToothOnIcon;	
	
	@AndroidFindBy (xpath = "//android.widget.Switch[@resource-id='com.android.settings:id/switch_widget']")
	//@AndroidFindBy (xpath = "//aandroid.widget.Switch[@text='Bluetooth, Off']")
	public MobileElement blueToothOffIcon;	
	
	//@AndroidFindBy (xpath = "//android.widget.TextView[@text='On']")
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.android.settings:id/switch_text']")
	public MobileElement blueToothOnText;
	
	//@AndroidFindBy (xpath = "//android.widget.TextView[@text='Off']")
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.android.settings:id/switch_text']")
	public MobileElement blueToothOffText;
	
	public BlueToothPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void enableBlueTooth()
	{
		setBlueTooth(BTOn, blueToothOnIcon);
	}
	
	public void disableBlueTooth()
	{
		setBlueTooth(BTOff, blueToothOnIcon);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
