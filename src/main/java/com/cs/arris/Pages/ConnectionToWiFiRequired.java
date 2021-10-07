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

public class ConnectionToWiFiRequired extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btnRetry']"),  //CONTINUE
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[122,1953][958,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btnRetry") 
	})
	public MobileElement continueButton; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_congratulations") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_congratulations']") // text = CONNECTION NEEDED
	public MobileElement connectToWifiText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_f_connect_internet_desc") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_f_connect_internet_desc']") // text = To continue with the install please connect to (arrisw311) through your Mobile Device Wi-Fi settings.
	public MobileElement connectRouterToWifiText;
	
	public ConnectionToWiFiRequired()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
