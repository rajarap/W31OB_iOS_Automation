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

public class SettingsHelpPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/ivDialogClose]"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[915,146][1046,241]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/ivDialogClose") 
	})
	public MobileElement closeButton; 
	
	@AndroidFindBy (xpath = "//android.webkit.WebView[@resource-id='com.arris.sbcBeta:id/webView']")
	public MobileElement settingsText;
	
	public SettingsHelpPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickCloseButton()
	{
		click(closeButton);
		utils.log().info("Settings Help Page - Clicked on Close Button");
	}
	
		
	@Override
	public boolean isAt() {
		if(settingsText.isDisplayed())
		{
			utils.log().info("On Settings Help Page");
			return true;}
		else {
			utils.log().info("Not on Settings Help Page");
		return false;}
	}

}
