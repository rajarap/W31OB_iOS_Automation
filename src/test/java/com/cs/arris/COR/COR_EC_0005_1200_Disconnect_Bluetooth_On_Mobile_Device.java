package com.cs.arris.COR;

import java.util.function.UnaryOperator;

import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
import com.cs.arris.Pages.BlueToothPage;
import com.cs.arris.Pages.EnableBlueToothPage;
import com.cs.arris.Pages.DisableBlueToothPage;
import com.cs.arris.Pages.CodeVerifiedPage;
import com.cs.arris.Pages.CongratulationsPage;
import com.cs.arris.Pages.ConnectMaxRouterToInternetPage;
import com.cs.arris.Pages.ConnectMaxRouterToMobileDevicePage;
import com.cs.arris.Pages.ConnectionToWifiNeededPage;
import com.cs.arris.Pages.DeviceLocationPage;
import com.cs.arris.Pages.DisableBlueToothPage;
import com.cs.arris.Pages.EnterInValidOTPPage;
import com.cs.arris.Pages.EnterValidOTPPage;
import com.cs.arris.Pages.ErrorCode_0000_1506_Warranty_Support_Page;
import com.cs.arris.Pages.ErrorCode_0015_1805_Something_Went_Wrong_Page;
import com.cs.arris.Pages.Error_0005_1200_Bluetooth_Connection_Failed_Page;
import com.cs.arris.Pages.GetStartedPage;
import com.cs.arris.Pages.GrantPermissionsPage;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.InstallAdditionalSatellitePage;
import com.cs.arris.Pages.NameYourNetwokSSIDPage;
import com.cs.arris.Pages.NetworkOptimizationDialog;
import com.cs.arris.Pages.OptimizeYourNetworkPage;
import com.cs.arris.Pages.PlugInMaxRouterPage;
import com.cs.arris.Pages.ResendOTPDialog;
import com.cs.arris.Pages.SelectYourDevicePage;
import com.cs.arris.Pages.SelectYourDevicePage2;
import com.cs.arris.Pages.SetUpYourWiFiManagementPage;
import com.cs.arris.Pages.SetupHomeNetworkPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Pages.SignupPage;
import com.cs.arris.Pages.SystemFirmwareUpdatePage;
import com.cs.arris.Pages.UnPackYourBoxPage;
import com.cs.arris.Utilities.InValidOTP;
import com.cs.arris.Utilities.ValidOTP;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Interface.W31_Onboarding_TestData;
import com.cs.arris.JsonMappers.Signin_TestData;

public class COR_EC_0005_1200_Disconnect_Bluetooth_On_Mobile_Device extends ParentClass
{
	TestUtils utils = new TestUtils();
	String validOTP;
	String inValidOTP;
	
    private GetStartedPage getStartedPage;
    private BlueToothPage blueToothPage;
    private EnableBlueToothPage enableBlueToothPage;
    private DisableBlueToothPage disableBlueToothPage;
    private GrantPermissionsPage grantPermissionsPage;
    private DeviceLocationPage deviceLocation;
    private AccessResourcesOnDevicePage accessResourcesOnDevicePage;
    private SelectYourDevicePage selectYourDevicePage;
    private SelectYourDevicePage2 selectYourDevicePage2;
    private SiginPage siginPage;
    private SignupPage signupPage;
    private ValidOTP validOtp;
    private InValidOTP inValidOtp;
    private EnterValidOTPPage enterValidOtpPage;
    private EnterInValidOTPPage enterInValidOtpPage;
    private CodeVerifiedPage codeVerifiedPage;
    private ErrorCode_0015_1805_Something_Went_Wrong_Page somethingWentWrongPage;
    private OptimizeYourNetworkPage optimizeNetworkPage;
    private SetupHomeNetworkPage setupHomeNetworkPage;
    private UnPackYourBoxPage unpackYourBoxPage;
    private PlugInMaxRouterPage plugInMaxRouterPage;
    private Error_0005_1200_Bluetooth_Connection_Failed_Page bluetoothConnectionFailedPage;
    private ResendOTPDialog resendOtpDialog;
    private ConnectMaxRouterToMobileDevicePage connectMaxRouterToMobile;
    private ConnectMaxRouterToInternetPage connectMaxRouterToInternet;
    private SystemFirmwareUpdatePage systemFirmwareUpgrade;
    private ErrorCode_0000_1506_Warranty_Support_Page warrantyAndSupport;
    private NameYourNetwokSSIDPage ssidPage;
    private ConnectionToWifiNeededPage connectionToWifiNeeded;
    private CongratulationsPage congratulations;
    private SetUpYourWiFiManagementPage setupWifi;
    private InstallAdditionalSatellitePage installSatellite;
    private NetworkOptimizationDialog networkOptimization;
    private HomePage homePage;
    
    
    
    public COR_EC_0005_1200_Disconnect_Bluetooth_On_Mobile_Device()
    {
    	this.getStartedPage = new GetStartedPage();
    	this.blueToothPage = new BlueToothPage();
    	this.enableBlueToothPage = new EnableBlueToothPage();
    	this.disableBlueToothPage = new DisableBlueToothPage();
    	this.grantPermissionsPage = new GrantPermissionsPage();
    	this.deviceLocation = new DeviceLocationPage();
    	this.accessResourcesOnDevicePage = new AccessResourcesOnDevicePage();
    	this.selectYourDevicePage = new SelectYourDevicePage();
    	this.selectYourDevicePage2 = new SelectYourDevicePage2();
    	this.siginPage = new SiginPage();
    	this.signupPage = new SignupPage();
    	this.validOtp = new ValidOTP();
    	this.inValidOtp = new InValidOTP();
    	this.enterValidOtpPage = new EnterValidOTPPage();
    	this.enterInValidOtpPage = new EnterInValidOTPPage();
    	this.codeVerifiedPage = new CodeVerifiedPage();
    	this.somethingWentWrongPage = new ErrorCode_0015_1805_Something_Went_Wrong_Page();
    	this.optimizeNetworkPage = new OptimizeYourNetworkPage();
    	this.setupHomeNetworkPage = new SetupHomeNetworkPage();
    	this.unpackYourBoxPage = new UnPackYourBoxPage();
    	this.plugInMaxRouterPage = new PlugInMaxRouterPage();
    	this.bluetoothConnectionFailedPage = new Error_0005_1200_Bluetooth_Connection_Failed_Page();
    	this.resendOtpDialog = new ResendOTPDialog();
    	this.connectMaxRouterToMobile = new ConnectMaxRouterToMobileDevicePage();
    	this.connectMaxRouterToInternet = new ConnectMaxRouterToInternetPage();
    	this.systemFirmwareUpgrade = new SystemFirmwareUpdatePage();
    	this.warrantyAndSupport = new ErrorCode_0000_1506_Warranty_Support_Page();
    	this.ssidPage = new NameYourNetwokSSIDPage();
    	this.connectionToWifiNeeded = new  ConnectionToWifiNeededPage();
    	this.congratulations = new CongratulationsPage();
    	this.setupWifi = new SetUpYourWiFiManagementPage();
    	this.installSatellite = new InstallAdditionalSatellitePage();
    	this.networkOptimization = new NetworkOptimizationDialog();
    	this.homePage = new HomePage();
    	    
    }
    
    public final UnaryOperator<Signin_TestData> GetStartedPage = (d) -> {
            Assert.assertTrue(getStartedPage.isAt());
            getStartedPage.clickGetStartedButton();
            return d;
    };
    
    public final UnaryOperator<Signin_TestData> EnableBlueToothPage = (d) -> {
      // Assert.assertTrue(enableBlueToothPage.isAt());
        enableBlueToothPage.enableBlueTooth();
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> DisableBlueToothPage = (d) -> {
        //Assert.assertTrue(disableBlueToothPage.isAt());
        disableBlueToothPage.disableBlueTooth();
        return d;
    };
    
    
    public final UnaryOperator<Signin_TestData> GrantPermissionsPage = (d) -> {
        Assert.assertTrue(grantPermissionsPage.isAt());
        grantPermissionsPage.clickContinueButton();
        super.pause(2);
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> DeviceLocationPage = (d) -> {
        Assert.assertTrue(deviceLocation.isAt());
        deviceLocation.clickOnlyThisTimeLink();
        super.pause(2);
        return d;
    };

    public final UnaryOperator<Signin_TestData> AccessResourcesOnDevicePage = (d) -> {
        Assert.assertTrue(accessResourcesOnDevicePage.isAt());
        accessResourcesOnDevicePage.clickAllowLink();
        super.pause(5);
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> SelectYourDevicePage = (d) -> {
        //Assert.assertTrue(selectYourDevicePage.isAt());
        selectYourDevicePage.selectSurfboardMaxOption();
        selectYourDevicePage.clickNextButton();
        super.pause(5);
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> SelectYourDevicePage2 = (d) -> {
        //Assert.assertTrue(selectYourDevicePage2.isAt());
        selectYourDevicePage2.selectMaxProAX11000RadioButton();
        selectYourDevicePage2.clickNextButton();
        super.pause(5);
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> SiginPage = (d) -> {
        //Assert.assertTrue(siginPage.isAt());
        siginPage.enterEmailAddress(d.getEmail_address());
        siginPage.clickSigninButton();
        super.pause(10);
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> SignupPage = (d) -> {
        //Assert.assertTrue(signupPage.isAt());
        signupPage.enterValidEmailAddress(d.getEmail_address());
        signupPage.enterFirstName(d.getFirst_name());
        signupPage.enterLastName(d.getLast_name());
		signupPage.clickSignupButton();
		super.pause(10);
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> ValidOTP = (d) -> {
        validOTP = validOtp.getValidOTP();
        super.pause(10);
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> InValidOTP = (d) -> {
        inValidOTP = inValidOtp.getInValidOTP();
        super.pause(10);
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> EnterValidOTPPage = (d) -> {
        //Assert.assertTrue(enterValidOtpPage.isAt());
        enterValidOtpPage.clearPassCodeText();
        enterValidOtpPage.enterValidPassCode(validOTP);
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> EnterInValidOTPPage = (d) -> {
        //Assert.assertTrue(enterInValidOtpPage.isAt());
        enterInValidOtpPage.enterInValidPassCode(inValidOTP);
        Assert.assertTrue(enterInValidOtpPage.verifyInvalidPassCodeMessage());
        enterInValidOtpPage.clickResendLink();
		super.pause(10);
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> CodeVerifiedPage = (d) -> {
        //Assert.assertTrue(codeVerifiedPage.isAt());
        codeVerifiedPage.clickNextButton();
        super.pause(10);
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> ErrorCode_0015_1805_Something_Went_Wrong_Page = (d) -> {
        //Assert.assertTrue(somethingWentWrongPage.isAt());
        somethingWentWrongPage.clickContinueOnboardingButton();
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> OptimizeYourNetworkPage = (d) -> {
        //Assert.assertTrue(optimizeNetworkPage.isAt());
        optimizeNetworkPage.clickSkipOptimizeButton();
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> SetupHomeNetworkPage = (d) -> {
        //Assert.assertTrue(setupHomeNetworkPage.isAt());
        setupHomeNetworkPage.clickNextButton();
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> UnPackYourBoxPage = (d) -> {
       // Assert.assertTrue(unpackYourBoxPage.isAt());
        unpackYourBoxPage.clickNextButton();
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> PlugInMaxRouterPage = (d) -> {
       // Assert.assertTrue(plugInMaxRouterPage.isAt());
        plugInMaxRouterPage.clickNextButton();
        super.pause(20);
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> Error_0005_1200_Bluetooth_Connection_Failed_Page = (d) -> {
       // Assert.assertTrue(bluetoothConnectionFailedPage.isAt());
        bluetoothConnectionFailedPage.clickTryAgainButton();
        super.pause(3);
        bluetoothConnectionFailedPage.clickTroubleShootButton();
        return d;
    };
    
    public final UnaryOperator<Signin_TestData> ResentOTPDialog = (d) -> {
        //Assert.assertTrue(resendOtpDialog.isAt());
        resendOtpDialog.clickOKButton();
        super.pause(15);
        return d;
        
    };
        
        public final UnaryOperator<Signin_TestData> ConnectMaxRouterToMobileDevicePage = (d) -> {
           // Assert.assertTrue(connectMaxRouterToMobile.isAt());
            connectMaxRouterToMobile.clickNextButton();
            super.pause(10);
            return d;
    };
    
    	public final UnaryOperator<Signin_TestData> ConnectMaxRouterToInternetPage = (d) -> {
    		//Assert.assertTrue(connectMaxRouterToInternet.isAt());
    		connectMaxRouterToInternet.clickNextButton();
    		super.pause(10);
    		return d;
    };
    
		public final UnaryOperator<Signin_TestData> SystemFirmwareUpdatePage = (d) -> {
			//Assert.assertTrue(systemFirmwareUpgrade.isAt());
			systemFirmwareUpgrade.clickNextButton();
			super.pause(10);
			return d;
	};

		public final UnaryOperator<Signin_TestData> ErrorCode_0000_1506_Warranty_Support_Page = (d) -> {
		//	Assert.assertTrue(warrantyAndSupport.isAt());
			warrantyAndSupport.clickContinueButton();
			super.pause(10);
			return d;
	};
	
		public final UnaryOperator<Signin_TestData> NameYourNetwokSSIDPage = (d) -> {
		//	Assert.assertTrue(ssidPage.isAt());
			ssidPage.enterSSIDName(d.getSsid_name());
			ssidPage.enterSSIDPassword(d.getSsid_pwd());
			ssidPage.clickNextButton();
			super.pause(25);
			return d;
	};
	
		public final UnaryOperator<Signin_TestData> ConnectionToWifiNeededPage = (d) -> {
		//	Assert.assertTrue(connectionToWifiNeeded.isAt());
			connectionToWifiNeeded.turnOnRouterWifi(d.getSsid_name(), d.getSsid_pwd(), d.getUdid());
			super.pause(10);
			connectionToWifiNeeded.clickContinue();
			super.pause(25);
			return d;
	};
	
		public final UnaryOperator<Signin_TestData> CongratulationsPage = (d) -> {
		//	Assert.assertTrue(congratulations.isAt());
			congratulations.clickContinueButton();
			super.pause(5);
			return d;
	};
	
		public final UnaryOperator<Signin_TestData> SetUpYourWiFiManagementPage = (d) -> {
		//	Assert.assertTrue(setupWifi.isAt());
			setupWifi.clickskipTutorialButton();
			return d;
	};

		public final UnaryOperator<Signin_TestData> InstallAdditionalSatellitePage = (d) -> {
		//	Assert.assertTrue(installSatellite.isAt());
			installSatellite.clickinstallLaterButton();;
			super.pause(5);
			return d;
	};
	
		public final UnaryOperator<Signin_TestData> NetworkOptimizationDialog = (d) -> {
		//	Assert.assertTrue(networkOptimization.isAt());
			networkOptimization.clickOkButton();
			super.pause(5);
			return d;
	};

		public final UnaryOperator<Signin_TestData> HomePage = (d) -> {
		//	Assert.assertTrue(homePage.isAt());
			return d;
	};

}

