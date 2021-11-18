package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

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

public class NetworkGeneralSettingsPortForwardingPage extends ParentClass implements Page {
	
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement portForwardingTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/port_forwarding_add_rule")
	public MobileElement addRuleButton;
	
	public NetworkGeneralSettingsPortForwardingPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public NetworkGeneralSettingsPortFowardingHelpPage getPortForwardingHelpPageObject() {
		NetworkGeneralSettingsPortFowardingHelpPage portForwardingHelpPage = new NetworkGeneralSettingsPortFowardingHelpPage();
		return portForwardingHelpPage;
	}
	
	public NetworkGeneralSettingsPortFowardingAddRulePage getPortForwardingHAddRulePageObject() {
		NetworkGeneralSettingsPortFowardingAddRulePage portForwardingHAddRulePage = new NetworkGeneralSettingsPortFowardingAddRulePage();
		return portForwardingHAddRulePage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}
  	 
	public void clickBackButton() {
		try {
			if (backIcon.isDisplayed()) {
				click(backIcon);
				utils.log().info("Clicked on Back Button");
			}
		} catch (Exception e) {
			utils.log().info("Back Button is not displayed");
		}
	}

	public void clickHelpButton() {
		try {
			if (helpIcon.isDisplayed()) {
				click(helpIcon);
				utils.log().info("Clicked on Help Button");}
		} catch (Exception e) {
			utils.log().info("Help Button is not displayed");
		}
	}
	
	public void clickAddRuleButton() {
		try {
			if (addRuleButton.isDisplayed()) {
				click(addRuleButton);
				utils.log().info("Clicked on Add Rule Button");}
		} catch (Exception e) {
			utils.log().info("Add Rule Button is not displayed");
		}
	}

		
	public void verifyUIOnPortForwardingPage() {
		utils.log().info("                                                                         ");
		utils.log().info("*************************************************************************");
		utils.log().info("Verifying UI Elements on Network - General Settings Port Forwarding Page ");
		utils.log().info("*************************************************************************");
		try {
			if (portForwardingTitle.isDisplayed())
				utils.log().info(portForwardingTitle.getText() + " title text is displayed ");
		} catch (Exception e) {
			utils.log().info("Port Forwarding title text is not displayed");
		}

		try {
			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
		} catch (Exception e) {
			utils.log().info("Back Icon is not displayed");
		}

		try {
			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
		} catch (Exception e) {
			utils.log().info("Help Icon is not displayed");
		}

		try {
			if(addRuleButton.isDisplayed())
				utils.log().info("Add Rule button is displayed");
		} catch (Exception e) {
			utils.log().info("Add Rule button is not displayed");
		}
	}

	@Override
	public boolean isAt() {
		if (portForwardingTitle.isDisplayed()) {
			utils.log().info("On General Settings Port Fowarding Page");
			return true;
		} else {
			utils.log().info("Not on General Settings Port Fowarding Page");
			return false;
		}
	}
}
