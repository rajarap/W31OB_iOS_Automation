package com.cs.arris.Pages;


import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.RandomEmailAddress;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Utilities.GetOTPFromNada;
import com.cs.arris.Utilities.InValidOTP;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ErrorCode_0000_1303_Router_Failed_To_Connect_To_Internet extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtNeedHelp") 
	public MobileElement helpIcon;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text")  //ROUTER FAILED TO CONNECT TO INTERNET
	public MobileElement routerFailedToConnectToInternetTitle;

	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_description_text") 
	//Your mAX failed to connect to the Internet. This can be due to improper Ethernet connection or lack of Internet connectivity from your modem.
	public MobileElement routerFailedToConnectToInternetTitleMessage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_code_text") //0000-1303
	public MobileElement errorCode;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/btn_generic_troubleshoot")
	public MobileElement troubleShootButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/btn_generic_error_retry")
	public MobileElement tryAgainButton;
	

	public ErrorCode_0000_1303_Router_Failed_To_Connect_To_Internet()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);

	}
	
	public String getPageTitle()
	{
		return routerFailedToConnectToInternetTitle.getText();
	}
	
	public String getPageMessage()
	{
		return routerFailedToConnectToInternetTitleMessage.getText();
	}
	
	public String getErrCode()
	{
		return errorCode.getText();
	}
	
	public void clickTryAgainButton()
	{
		click(tryAgainButton);
	}
	
	public void clickTroubleShootButton()
	{
		click(troubleShootButton);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
