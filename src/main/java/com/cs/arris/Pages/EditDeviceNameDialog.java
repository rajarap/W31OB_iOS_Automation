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

public class EditDeviceNameDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialogBoxTitle") //EDIT DEVICE NAME
	public MobileElement editDeviceNameTitle; 
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialogBoxdetail") //Please enter a name for this device
	public MobileElement editDeviceNameText; 
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialog") //Enter Device Name  Label
	public MobileElement enterDeviceNameLabel;
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialogEditText") //Enter Device Name
	public MobileElement enterDeviceName;
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialogSelectTextLength") //Select Your Device Type Label
	public MobileElement selectYourDeviceTypeLabel;
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialogSelectTextLength")
	public MobileElement selectYourDeviceTypeListBox;
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialogSave") 
	public MobileElement saveButton; 
	
	@AndroidBy (id = "com.arris.sbcBeta:id/dialogClose") 
	public MobileElement closeButton; 
	
	
	public EditDeviceNameDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickSaveButton()
	{
		click(saveButton);
		utils.log().info("Edit Device Name Dialog - Clicked on Save Changes Button");
	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
