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

public class NetworkHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ivDialogClose")
	public MobileElement closeButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Network Settings']") 
	public MobileElement NetworkSettingstitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[52,731][1029,1359]']")
	public MobileElement mainWiFi;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1403][1029,1718]']")
	public MobileElement useCardToChangeSSID;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,681][1029,1154]']")
	public MobileElement pleaseNoteThat;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1151][1029,1934]']")
	public MobileElement duringTheTransition;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,424][1029,1130]']")
	public MobileElement enableYourGuestNetwork;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1125][1029,1598]']")
	public MobileElement changeGuestNetwork;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,422][1029,737]']")
	public MobileElement summary;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,734][1029,1283]']")
	public MobileElement expandYourCard;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1280][1029,1752]']")
	public MobileElement forSomeOfTheMoreAdvancedSettings;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[52,1794][1029,2042]']")
	public MobileElement testMySpeedConnection;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1406][1029,1721]']")
	public MobileElement internetAccessSpeed;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1716][1029,2042]']")
	public MobileElement speedBetweenMobileDevices;
	
	

	public NetworkHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		try {
			if (closeButton.isDisplayed()) {
				new SwipeActions().swipeScreen(Direction.UP);
				new SwipeActions().swipeScreen(Direction.UP);
				new SwipeActions().swipeScreen(Direction.UP);
				click(closeButton);}
			//	utils.log().info("Clicked on Close Button");}
			return true;
		} catch (Exception e) {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}

	public void verifyUIOnNetworkHelpPage() {
		try {
			if (NetworkSettingstitle.isDisplayed())
				utils.log().info(NetworkSettingstitle.getText() + " title is displayed ");
		} catch (Exception e) {
			utils.log().info("Network Settings title is not displayed");
		}
		
		try {
			if (mainWiFi.isDisplayed())
				utils.log().info("Main Wifi help is displayed ");
		} catch (Exception e) {
			utils.log().info("Main Wifi help is not displayed");
		}
		
		try {
			if (useCardToChangeSSID.isDisplayed())
				utils.log().info("Use this card to Change your SSID help is displayed ");
		} catch (Exception e) {
			utils.log().info("Use this card to Change your SSID help is not displayed");
		}
		
		try {
			if (pleaseNoteThat.isDisplayed())
				utils.log().info("Changing SSID and password help is displayed ");
			new SwipeActions().swipeScreen(Direction.UP);
		} catch (Exception e) {
			utils.log().info("Changing SSID and password help is not displayed");
		}
		
		try {
			if (duringTheTransition.isDisplayed())
				utils.log().info("You will be disconnected from your current network is displayed ");
		} catch (Exception e) {
			utils.log().info("You will be disconnected from your current network is not displayed");
		}
		
		try {
			if (enableYourGuestNetwork.isDisplayed())
				utils.log().info("Enable your Guest Network is displayed ");
			new SwipeActions().swipeScreen(Direction.UP);
		} catch (Exception e) {
			utils.log().info("Enable your Guest Network is not displayed");
		}
		
		try {
			if (changeGuestNetwork.isDisplayed())
				utils.log().info("Change your Guest Network is displayed ");
		} catch (Exception e) {
			utils.log().info("Change your Guest Network is not displayed");
		}
		
		try {
			if (summary.isDisplayed())
				utils.log().info("Network Settings is displayed ");
		} catch (Exception e) {
			utils.log().info("Network Settings is not displayed");
		}
		
		try {
			if (expandYourCard.isDisplayed())
				utils.log().info("Expand your cards is displayed ");
			new SwipeActions().swipeScreen(Direction.UP);
		} catch (Exception e) {
			utils.log().info("Expand your cards is not displayed");
		}
		
		try {
			if (forSomeOfTheMoreAdvancedSettings.isDisplayed())
				utils.log().info("For More Advanced Settings is displayed ");
		} catch (Exception e) {
			utils.log().info("For More Advanced Settings is not displayed");
		}
		
		try {
			if (testMySpeedConnection.isDisplayed())
				utils.log().info("Test My Connection Speed is displayed ");
		} catch (Exception e) {
			utils.log().info("Test My Connection Speed is not displayed");
		}
		
		try {
			if (internetAccessSpeed.isDisplayed())
				utils.log().info("Internet Access Speed is displayed ");
		} catch (Exception e) {
			utils.log().info("Internet Access Speed is not displayed");
		}
		
		try {
			if (speedBetweenMobileDevices.isDisplayed())
				utils.log().info("Internet Speed Between Mobile Devices is displayed ");
		} catch (Exception e) {
			utils.log().info("Internet Speed Between Mobile Devices is not displayed");
		}
	}

	@Override
	public boolean isAt() {
		if (NetworkSettingstitle.isDisplayed()) {
			utils.log().info("On Newtork Settings Help Page");
			return true;
		} else {
			utils.log().info("Not on Network Settings Help Page");
			return false;
		}
	}
}
