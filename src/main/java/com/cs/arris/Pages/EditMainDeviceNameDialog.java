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
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialogBoxTitle") //EDIT DEVICE NAME
	public MobileElement editDeviceNameTitle; 
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialogBoxdetail") //Please enter a name for this device
	public MobileElement editDeviceNameText; 
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialog") //Enter Device Name  Label
	public MobileElement enterDeviceNameLabel;
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialogEditTextt") //Enter Device Name
	public MobileElement enterDeviceName;
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialogSave") 
	public MobileElement saveButton; 
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialogClose") 
	public MobileElement closeButton; 
	
	
	public EditMainDeviceNameDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickSaveButton()
	{
		click(saveButton);
		utils.log().info("Edit Main Device Name Dialog - Clicked on Save Changes Button");
	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
