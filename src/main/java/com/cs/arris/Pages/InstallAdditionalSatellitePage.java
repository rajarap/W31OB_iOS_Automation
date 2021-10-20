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

public class InstallAdditionalSatellitePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/dialog_install_now]"),  //INSTALL NOW
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[151,1179][929,1316]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/dialog_install_now") 
	})
	public MobileElement installNowButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/dialog_install_later]"),  //SKIP TUTORIAL
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[151,1374][929,1511]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/dialog_install_later") 
	})
	public MobileElement installLaterButton; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_getting_started") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_getting_started']") // text = SETUP YOUR Wi-Fi MANAGEMENT
	public MobileElement setupWifiManagementText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/description_add_satelite") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/description_add_satelite']") // text = You have successfully configured your router and home network
	public MobileElement setupWifiManagementMessage;
	
	public InstallAdditionalSatellitePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickinstallLaterButton()
	{
		click(installLaterButton);
		utils.log().info("Install Additonal Satellite Dialog - Clicked on Install Later Button");
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
