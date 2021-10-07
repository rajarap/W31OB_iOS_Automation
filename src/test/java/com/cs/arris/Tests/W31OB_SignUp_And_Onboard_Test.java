package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.WelcomeSignupPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.W31OB_SignUp_Workflow;

public class W31OB_SignUp_And_Onboard_Test extends ParentClass
{
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	
	 @BeforeClass
	 public void beforeClass() throws Exception 
	 {
		 try 
	   	  	{
			  String dataFileName = "testdata/signup";
			  utils.log().info("Loading...Sign Up Test Data");
			  super.loadTestData(dataFileName);
			  this.firstName = properties.getProperty("firstname");
			  System.out.println("First Name : " + this.firstName);
			  this.lastName = properties.getProperty("lastname");
			  System.out.println("Last Name : " + this.lastName);
			  this.email = properties.getProperty("email");
			  System.out.println("Email address : " + this.email);
			  utils.log().info("Retrieved...Sign Up Test Data");
			} catch(Exception e) {
			 e.printStackTrace();
		} 
     }
	
	  @BeforeMethod
	  public void beforeMethod(Method m) 
	  {
		   utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	  }
	  
	  @Test(priority = 1)
	  public void W31OB_SignUpUser()
	  {
		  W31OB_SignUp_Workflow.getStartedPage(getStarted -> {
			  getStarted.clickGetStartedButton();
		  }).grantPermissionsPage(grantPermission -> {
			  grantPermission.clickContinueButton();
		  }).deviceLocationPage(deviceLocation -> {
			  deviceLocation.clickOnlyThisTimeLink();
		  }).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
			  accessResoucesOnDevice.clickAllowLink();
		  }).selectYourDevicePage(selectDevice -> {
			  selectDevice.selectSurfboardMaxOption();
			  selectDevice.clickNextButton();
		  }).selectYourDevicePage2(selectDevice2 -> {
			  selectDevice2.selectMaxProAX11000RadioButton();
			  selectDevice2.clickNextButton();
		  }).welcomeSigninPage(signin -> {
			  signin.clickSignUpButton();
		  }).welcomeSignupPage(signup -> {
			  signup.enterValidEmailAddress(email);
			  signup.enterFirstName(firstName);
			  signup.enterLastName(lastName);
			  signup.clickSignupButton();
		  }).enterOTPPage(otpverify -> {
			  try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			  otpverify.enterPassCode();
		  }).codeVerifiedPage(codeVerified -> {
			  codeVerified.getCodeVerifiedText();
		  }).optimizeYourNetworkPage(optimize -> {
			  optimize.clickSkipOptimizeButton();
		  });
	  }
}

