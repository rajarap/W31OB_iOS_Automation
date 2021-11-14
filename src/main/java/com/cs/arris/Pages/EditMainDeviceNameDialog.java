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

public class EditMainDeviceNameDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialogBoxTitle") //EDIT DEVICE NAME
	public MobileElement editDeviceNameTitle; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialogBoxdetail") //Please enter a name for this device
	public MobileElement editDeviceNameText; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialog") //Enter Device Name  Label
	public MobileElement enterDeviceNameLabel;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialogEditText") //Enter Device Name
	public MobileElement enterDeviceName;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialogSave") 
	public MobileElement saveButton; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialogClose") 
	public MobileElement closeButton; 
	
	
	public EditMainDeviceNameDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void verifyUIOnEditDeviceNameDialog()
	{
		try
		{
			if(editDeviceNameTitle.isDisplayed());
			utils.log().info(editDeviceNameTitle.getText() + " title is displayed");
		}catch (Exception e) {
			utils.log().info("EDIT DEVICE NAME title is not displayed");
		}
		
		try
		{
			if(editDeviceNameText.isDisplayed());
			utils.log().info(editDeviceNameText.getText() + " text is displayed");
		}catch (Exception e) {
			utils.log().info("Enter Device Name text is not displayed");
		}
		
		try
		{
			if(enterDeviceNameLabel.isDisplayed());
			utils.log().info(enterDeviceNameLabel.getText() + " Label is displayed");
		}catch (Exception e) {
			utils.log().info("Enter Device Name Label is not displayed");
		}
		
		try
		{
			if(enterDeviceName.isDisplayed());
			utils.log().info("Enter Device Name text box is displayed");
		}catch (Exception e) {
			utils.log().info("Enter Device Name text box is not displayed");
		}
		
		try
		{
			if(saveButton.isDisplayed());
			utils.log().info(saveButton.getText() + " button is displayed");
		}catch (Exception e) {
			utils.log().info("SAVE CHANGES button is not displayed");
		}
		
		try
		{
			if(closeButton.isDisplayed());
			utils.log().info("Close Icon is displayed");
		}catch (Exception e) {
			utils.log().info("Close Icon is not displayed");
		}
	}
	
	
	
	public void clickSaveButton()
	{
		try
		{
			click(saveButton);
			utils.log().info("Clicked on Save Changes Button");
			super.pause(3);
		}catch (Exception e) {
			utils.log().info("Save Changes button is not displayed");
		}
	}
	
	public void clickCloseButton()
	{
		try
		{
			click(closeButton);
			utils.log().info("Clicked on Close Icon");
		}catch (Exception e) {
			utils.log().info("Close Icon is not displayed");
		}
	}
	
	public void editMainDeviceName()
	{
		try
		{
			String device = enterDeviceName.getText();
			String editedName = device + "-1";
			super.editedDeviceName = editedName;
			super.clear(enterDeviceName);
			super.sendKeys(enterDeviceName, editedName);
			utils.log().info("Changed device name from " + device + " to " + editedName);
		}catch (Exception e) {
			utils.log().info("Edit Router name text box is not displayed");
		}
	}
	
	@Override
	public boolean isAt() {
		if (editDeviceNameTitle.isDisplayed()) {
			utils.log().info("On Edit Main Device Name Dialog");
			utils.log().info("-------------------------------");
			return true;
		} else {
			utils.log().info("Not on Edit Main Device Name Dialog");
			return false;
		}
	}
}
