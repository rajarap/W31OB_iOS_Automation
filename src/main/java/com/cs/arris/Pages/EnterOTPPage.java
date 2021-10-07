package com.cs.arris.Pages;


import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.RandomEmailAddress;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Utilities.OTP;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnterOTPPage   extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public RandomEmailAddress random;
	public OTP otp;
	
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/need_help") 
	public MobileElement helpIcon;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	public MobileElement enterVerificationCodeMessage;

	@AndroidFindBy (id = "com.arris.sbcBeta:id/description_text") 
	public MobileElement checkEmailAccounteMessage;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/user_email_id']") 
	public MobileElement emailAddress;
	
	@AndroidFindBy (xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/etConfirmPasscode']")
	public MobileElement otpCode;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tvResendPasscode']")
	public MobileElement resendPassCode;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/ic_back_icon") 
	public MobileElement otpVerificationBackButton;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/confirm_password_error']")
	public MobileElement invalidPassCodeMessage;
	
	public EnterOTPPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
		otp = new OTP();
	}
	
	public String verifyEmailAddress()
	{
		return emailAddress.getText();
	}
	
	public void enterPassCode()
	{
		String passcode = otp.getOTP();
		System.out.println("Entering OTP Passcode : --------> " + otp);
		sendKeys(otpCode, passcode);
	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
