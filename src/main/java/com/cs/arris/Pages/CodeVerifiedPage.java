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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CodeVerifiedPage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Code_Verified_Screen_TitleLabel_EnterVerificationCode\"]")
	public MobileElement codeVerifiedText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/success_icon") 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Code_Verified_Screen_Image_OtpSuccess\"]")
	public MobileElement successIcon;
	
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/user_email_id_success']")
	@AndroidFindBy (id = "com.arris.sbcBeta:id/user_email_id_success") 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Code_Verified_Screen_Label_Email\"]")
	public MobileElement emailAddress;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/next_button']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/next_button"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[85,973][995,1110]']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")
	}) 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Code_Verified_Screen_Button_NextOnboard\"]")
	public MobileElement nextButton;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/btn_continue_onboarding]"),//CONTINUE ONBOARDING
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[61,1812][1019,1949]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_continue_onboarding") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Launch_Error_Screen_Button_ContinueOnboarding\"]")
	public MobileElement continueOnBoardingButton;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/btn_error_frag_retry]"),//TRY AGAIN
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[61,1983][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_error_frag_retry") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Launch_Error_Screen_Button_TryAgain\"]")
	public MobileElement tryAgainButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_description") 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label_Error\"]")
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_description']") // text = The mobile device cannot connect to your Router.
	public MobileElement mobileDeviceCannotConnectToRouter;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView") // text = 	
	//If you have previously installed the device, please connect your mobile device to the local Wi-Fi network. Click on "Try Again" to retry the connection to the device.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label\"]")
	public MobileElement connectMobileToLocalWifiText;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView") // text = 	
	//If you have completed performing a factory reset on the device, then Click on "Continue Onboarding" to reinstall the device.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label\"]")
	public MobileElement factoryResetOnDeviceText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_code") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_code']") // text = 0015-1805
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label_ErrorCode\"]")
	public MobileElement errorCode;  
	
	public CodeVerifiedPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickNextButton()
	{
		utils.log().info("OTP Code Verified Page - Clicked on Next Button");
		click(nextButton);
	}
	
	public void getCodeVerifiedText()
	{
		System.out.println(codeVerifiedText.getText());
	}
	
	public void clickContinueOnboardingButton()
	{
		click(continueOnBoardingButton);
	}

	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
