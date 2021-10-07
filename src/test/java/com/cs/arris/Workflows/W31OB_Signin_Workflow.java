package com.cs.arris.Workflows;

import java.util.function.Consumer;

import com.cs.arris.Interface.Page;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
import com.cs.arris.Pages.CodeVerifiedPage;
import com.cs.arris.Pages.DeviceLocationPage;
import com.cs.arris.Pages.GetStartedPage;
import com.cs.arris.Pages.GrantPermissionsPage;
import com.cs.arris.Pages.MaxRouterSuccessfullyConnectedToMobileDeivcePage;
import com.cs.arris.Pages.EnterOTPPage;
import com.cs.arris.Pages.OptimizeYourNetworkPage;
import com.cs.arris.Pages.PlugInMaxRouterPage;
import com.cs.arris.Pages.RetrieveOTPPage;
import com.cs.arris.Pages.SelectYourDevicePage;
import com.cs.arris.Pages.SelectYourDevicePage2;
import com.cs.arris.Pages.SetupHomeNetworkPage;
import com.cs.arris.Pages.SuccessfullyConnectedToInternetPage;
import com.cs.arris.Pages.UnPackYourBoxPage;
import com.cs.arris.Pages.WelcomeSigninPage;
import com.cs.arris.Pages.WelcomeSignupPage;
import com.cs.arris.Utilities.TestUtils;

public class W31OB_Signin_Workflow 
{
	
TestUtils utils = new TestUtils();
	
	//GET STARTED
    public static W31OB_Signin_Workflow getStartedPage(Consumer<GetStartedPage> c){
    	GetStartedPage p = new GetStartedPage();
        c.accept(p);
        return new W31OB_Signin_Workflow();
    }
    
    //GRANT PERMISSIONS
    public W31OB_Signin_Workflow grantPermissionsPage(Consumer<GrantPermissionsPage> c){
    	GrantPermissionsPage p = new GrantPermissionsPage();
        c.accept(p);
        return this;
    }
    
    //Enable DEVICE LOCATION only this time
    public W31OB_Signin_Workflow deviceLocationPage(Consumer<DeviceLocationPage> c){
    	DeviceLocationPage p = new DeviceLocationPage();
        c.accept(p);
        return this;
    }
    
   //Access resource on device media-contacts
    public W31OB_Signin_Workflow accessResourcesOnDevicePage(Consumer<AccessResourcesOnDevicePage> c){
    	AccessResourcesOnDevicePage p = new AccessResourcesOnDevicePage();
         c.accept(p);
        return this;
    }
    
    //select SURFboard MAX mesh
    public W31OB_Signin_Workflow selectYourDevicePage(Consumer<SelectYourDevicePage> c){
    	SelectYourDevicePage p = new SelectYourDevicePage();
        c.accept(p);
        return this;
    }
    
    //select max Pro AX11000
    public W31OB_Signin_Workflow selectYourDevicePage2(Consumer<SelectYourDevicePage2> c){
    	SelectYourDevicePage2 p = new SelectYourDevicePage2();
        c.accept(p);
        return this;
    }
    
    //Enter valid email id and login
    public W31OB_Signin_Workflow welcomeSigninPage(Consumer<WelcomeSigninPage> c){
    	WelcomeSigninPage p = new WelcomeSigninPage();
        c.accept(p);
        return this;
    }
    
    //Retrieve OTP 
//    public W31OB_Signin_Workflow retrieveOTPPage(Consumer<RetrieveOTPPage> c){
//    	RetrieveOTPPage p = new RetrieveOTPPage();
//        c.accept(p);
//        return this;
//    }
    
  //enter OTP
    public W31OB_Signin_Workflow enterOTPPage(Consumer<EnterOTPPage> c){
    	EnterOTPPage p = new EnterOTPPage();
        c.accept(p);
        return this;
    }
    
    
    //OTP verified
    public W31OB_Signin_Workflow codeVerifiedPage(Consumer<CodeVerifiedPage> c){
    	CodeVerifiedPage p = new CodeVerifiedPage();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //click skip optimization button
    public W31OB_Signin_Workflow optimizeYourNetworkPage(Consumer<OptimizeYourNetworkPage> c){
    	OptimizeYourNetworkPage p = new OptimizeYourNetworkPage();
        c.accept(p);
        return this;
    }
    
    //setup home network
    public W31OB_Signin_Workflow setupHomeNetworkPage(Consumer<SetupHomeNetworkPage> c){
    	SetupHomeNetworkPage p = new SetupHomeNetworkPage();
        c.accept(p);
        return this;
    }
   
    //UnPack your Box
    public W31OB_Signin_Workflow unboxYourBoxPage(Consumer<UnPackYourBoxPage> c){
    	UnPackYourBoxPage p = new UnPackYourBoxPage();
        c.accept(p);
        return this;
    }
    
    //Plugin Max Router
    public W31OB_Signin_Workflow pluginMaxRouterPage(Consumer<PlugInMaxRouterPage> c){
    	PlugInMaxRouterPage p = new PlugInMaxRouterPage();
        c.accept(p);
        return this;
    }
    
    //Max Router successfully connected to mobile
    public W31OB_Signin_Workflow maxRouterConnectedToMobilePage(Consumer<MaxRouterSuccessfullyConnectedToMobileDeivcePage> c){
    	MaxRouterSuccessfullyConnectedToMobileDeivcePage p = new MaxRouterSuccessfullyConnectedToMobileDeivcePage();
        c.accept(p);
        return this;
    }
    
    //Max Router successfully connected to internet
    public W31OB_Signin_Workflow maxRouterConnectedToInternetPage(Consumer<SuccessfullyConnectedToInternetPage> c){
    	SuccessfullyConnectedToInternetPage p = new SuccessfullyConnectedToInternetPage();
        c.accept(p);
        return this;
    }
       
  //handle page sync techniques here
    private void waitForPageLoad(Page p){
        System.out.println("------------------------------");
        System.out.println("Waiting for " + p.toString() + " to load" );
        // wait till p.isAt() returns true with a timeout
    }
    

}
