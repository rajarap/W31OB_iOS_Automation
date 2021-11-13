package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainRouterDetailsHelpPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/ivDialogClose]"),  //CONTINUE
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[915,146][1046,241]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/ivDialogClose") 
	})
	public MobileElement closeButton; 
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.widget.TextView")
	public MobileElement routerDetails;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.widget.ListView/android.view.View[1]/android.widget.TextView")
	public MobileElement connectedDeviceGraphic;
	
	public MainRouterDetailsHelpPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickCloseButton() {
		try {
			new SwipeActions().swipeScreen(Direction.UP);
			click(closeButton);
			utils.log().info("Clicked on Close Button");
		} catch (Exception e) {
			utils.log().info("Close button is not displayed");
		}
	}

	public void verifyUIOnMainRouterHelpPage() {
		try {
			if (routerDetails.isDisplayed())
				utils.log().info(routerDetails.getText() + " title is displayed ");
		} catch (Exception e) {
			utils.log().info("Router Details Title is not displayed");
		}
		
		try {
			if (connectedDeviceGraphic.isDisplayed())
				utils.log().info(connectedDeviceGraphic.getText() + " text is displayed ");
		} catch (Exception e) {
			utils.log().info("Connected Devices Graphic text is not displayed");
		}
	}
	
	@Override
	public boolean isAt() {
		if(routerDetails.isDisplayed())
		{
			utils.log().info("                           ");
			utils.log().info("---------------------------");
			utils.log().info("On Router Details Help Page");
			return true;}
		else {
			utils.log().info("Not on Router Details Help Page");
		return false;}
		
	}

}
