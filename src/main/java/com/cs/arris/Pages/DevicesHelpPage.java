package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DevicesHelpPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/ivDialogClose]"),  //CONTINUE
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[915,146][1046,241]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/ivDialogClose") 
	})
	public MobileElement closeButton; 
	
	//@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[52,401][1029,558]']")
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.widget.TextView")
	public MobileElement deviceHelp1;
	
	//@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[157,1556][1029,2042]']")
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.widget.ListView/android.view.View[1]")
	public MobileElement deviceHelp2;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.widget.ListView/android.view.View[2]")
	public MobileElement deviceHelp3;
	
	//@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[157,936][1029,2042]']")
	//public MobileElement deviceHelp4;
	
	public DevicesHelpPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickCloseButton()
	{
		click(closeButton);
		utils.log().info("Devices Help Page - Clicked on Close Button");
	}
	
	public void verifyHelpText()
	{
		Assert.assertEquals(deviceHelp1.getText(), getStrings().get("device_list_details_help1"));
		utils.log().info("Device List Help Page - Title is displayed correctly");
		Assert.assertEquals(deviceHelp2.getText(), getStrings().get("device_list_details_help2"));
		utils.log().info("Device List Help Page - Device List Details are displayed correctly");
		Assert.assertEquals(deviceHelp3.getText(), getStrings().get("device_list_details_help3"));
		utils.log().info("Device List Help Page - Device Card details are displayed correctly");
//		Assert.assertEquals(deviceHelp4.getText(), getStrings().get("device_list_details_help4"));
//		utils.log().info("Device List Help Page - Network SSID details are displayed correctly");
	}
	
	
	@Override
	public boolean isAt() {
		if(deviceHelp1.isDisplayed())
		{
			utils.log().info("On Device List Help Page");
			return true;}
		else {
			utils.log().info("Not on Device List Help Page");
		return false;}
		
	}

}
