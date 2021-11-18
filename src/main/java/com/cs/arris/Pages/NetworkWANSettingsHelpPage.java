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

public class NetworkWANSettingsHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ivDialogClose")
	public MobileElement closeButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='WAN Settings']") 
	public MobileElement wanSettingstitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[52,731][1029,968]']")
	public MobileElement controlAndConfigure;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1012][1029,1640]']")
	public MobileElement dhcp;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1637][1029,1952]']")
	public MobileElement dns;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1640][1015,2042]']")
	public MobileElement wanIPRenew;
	
	public NetworkWANSettingsHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void clickCloseButton() {
		try {
			if (closeButton.isDisplayed()) {
				new SwipeActions().swipeScreen(Direction.UP);
				click(closeButton);
				utils.log().info("Clicked on Close Button");}
		} catch (Exception e) {
			utils.log().info("Close button is not displayed");
		}
	}

	public void verifyUIOnNetworWANSettingsHelpPage() {
		try {
			if (wanSettingstitle.isDisplayed())
				utils.log().info(wanSettingstitle.getText() + " title is displayed ");
		} catch (Exception e) {
			utils.log().info("WAN Settings title is not displayed");
		}
		
		try {
			if (controlAndConfigure.isDisplayed())
				utils.log().info("WAN Setting allows you to control and configure help is displayed ");
		} catch (Exception e) {
			utils.log().info("WAN Setting allows you to control and configure help is not displayed");
		}
		
		try {
			if (dhcp.isDisplayed())
				utils.log().info("You can configure DHCP help is displayed ");
		} catch (Exception e) {
			utils.log().info("You can configure DHCP help is not displayed");
		}
		
		try {
			if (dns.isDisplayed())
				utils.log().info("DNS Server can als be configured help is displayed ");
		} catch (Exception e) {
			utils.log().info("DNS Server can als be configured help is not displayed");
		}
		
		try {
			if (wanIPRenew.isDisplayed())
				utils.log().info("WAN IP Renew help is displayed ");
		} catch (Exception e) {
			utils.log().info("WAN IP Renew help is not displayed");
		}
	}

	@Override
	public boolean isAt() {
		if (wanSettingstitle.isDisplayed()) {
			utils.log().info("On WAN Settings Help Page");
			return true;
		} else {
			utils.log().info("Not on WAN Settings Help Page");
			return false;
		}
	}
}