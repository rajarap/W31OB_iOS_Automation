package com.cs.arris.Workflows;

import java.util.function.Consumer;

import com.cs.arris.Interface.Page;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
import com.cs.arris.Pages.CodeVerifiedPage;
import com.cs.arris.Pages.DeviceLocationPage;
import com.cs.arris.Pages.GetStartedPage;
import com.cs.arris.Pages.GrantPermissionsPage;
import com.cs.arris.Pages.EnterOTPPage;
import com.cs.arris.Pages.OptimizeYourNetworkPage;
import com.cs.arris.Pages.RetrieveOTPPage;
import com.cs.arris.Pages.SelectYourDevicePage;
import com.cs.arris.Pages.SelectYourDevicePage2;
import com.cs.arris.Pages.WelcomeSigninPage;
import com.cs.arris.Pages.WelcomeSignupPage;
import com.cs.arris.Utilities.TestUtils;

public class W31OB_SignUp_Workflow 
{
	TestUtils utils = new TestUtils();
	
	//GET STARTED
    public static W31OB_SignUp_Workflow getStartedPage(Consumer<GetStartedPage> c){
    	GetStartedPage p = new GetStartedPage();
        c.accept(p);
        return new W31OB_SignUp_Workflow();
    }
    
    //GRANT PERMISSIONS
    public W31OB_SignUp_Workflow grantPermissionsPage(Consumer<GrantPermissionsPage> c){
    	GrantPermissionsPage p = new GrantPermissionsPage();
        c.accept(p);
        return this;
    }
    
    //Enable DEVICE LOCATION only this time
    public W31OB_SignUp_Workflow deviceLocationPage(Consumer<DeviceLocationPage> c){
    	DeviceLocationPage p = new DeviceLocationPage();
        c.accept(p);
        return this;
    }
    
   //Access resource on device media-contacts
    public W31OB_SignUp_Workflow accessResourcesOnDevicePage(Consumer<AccessResourcesOnDevicePage> c){
    	AccessResourcesOnDevicePage p = new AccessResourcesOnDevicePage();
         c.accept(p);
        return this;
    }
    
    //select SURFboard MAX mesh
    public W31OB_SignUp_Workflow selectYourDevicePage(Consumer<SelectYourDevicePage> c){
    	SelectYourDevicePage p = new SelectYourDevicePage();
        c.accept(p);
        return this;
    }
    
    //select max Pro AX11000
    public W31OB_SignUp_Workflow selectYourDevicePage2(Consumer<SelectYourDevicePage2> c){
    	SelectYourDevicePage2 p = new SelectYourDevicePage2();
        c.accept(p);
        return this;
    }
    
    //click Signup on the Sigin page
    public W31OB_SignUp_Workflow welcomeSigninPage(Consumer<WelcomeSigninPage> c){
    	WelcomeSigninPage p = new WelcomeSigninPage();
        c.accept(p);
        return this;
    }
    
    //enter email, first name and last name
    public W31OB_SignUp_Workflow welcomeSignupPage(Consumer<WelcomeSignupPage> c){
    	WelcomeSignupPage p = new WelcomeSignupPage();
    	//this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //Retrieve OTP 
//    public W31OB_SignUp_Workflow retrieveOTPPage(Consumer<RetrieveOTPPage> c){
//    	RetrieveOTPPage p = new RetrieveOTPPage();
//        c.accept(p);
//        return this;
//    }
    
    //enter OTP
    public W31OB_SignUp_Workflow enterOTPPage(Consumer<EnterOTPPage> c){
    	EnterOTPPage p = new EnterOTPPage();
        c.accept(p);
        return this;
    }
    
    //OTP verified
    public W31OB_SignUp_Workflow codeVerifiedPage(Consumer<CodeVerifiedPage> c){
    	CodeVerifiedPage p = new CodeVerifiedPage();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //click skip optimization button
    public W31OB_SignUp_Workflow optimizeYourNetworkPage(Consumer<OptimizeYourNetworkPage> c){
    	OptimizeYourNetworkPage p = new OptimizeYourNetworkPage();
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
