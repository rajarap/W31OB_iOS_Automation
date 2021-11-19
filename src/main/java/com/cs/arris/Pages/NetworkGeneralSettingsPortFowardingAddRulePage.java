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

public class NetworkGeneralSettingsPortFowardingAddRulePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/port_cancel_dialog")
	public MobileElement closeButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/port_forwarding_header_dialog")
	public MobileElement portRuletitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/port_forwarding_name_dialog")
	public MobileElement portRuleNameLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/port_name_dialog")
	public MobileElement enterPortRuleNameTextBox;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/protocol_dialog")
	public MobileElement protocolLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tcp_dialog")
	public MobileElement tcpButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/udp_dialog")
	public MobileElement udpButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tcp_udp_dialog")
	public MobileElement tcpUdpButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Internal port start']")
	public MobileElement enterInternalPortStartLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/internal_port_start_dialog")
	public MobileElement enterInternalPortStartTextBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Internal port end']")
	public MobileElement enterInternalPortEndLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/internal_port_end_dialog")
	public MobileElement enterInternalPortEndTextBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter External port start']")
	public MobileElement enterExternalPortStartLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/external_port_start_dialog")
	public MobileElement enterExternalPortStartTextBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter External port end']")
	public MobileElement enterExternalPortEndLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/external_port_end_dialog")
	public MobileElement enterExternalPortEndTextBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter Internal IP Address']")
	public MobileElement enterInternalIPAddressLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/internal_ip_address_dialog")
	public MobileElement enterInternalIPAddressTextBox;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/port_save_dialog")
	public MobileElement saveChangesButton;

	public NetworkGeneralSettingsPortFowardingAddRulePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}
	public boolean clickSaveButton() {
		if (saveChangesButton.isDisplayed()) {
			click(saveChangesButton);
			utils.log().info("Clicked on Save Changes Button");
			return true;
		} else {
			utils.log().info("Save Changes button is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnPortForwardingAddRulePage() {
		utils.log().info("                                                                                  ");
		utils.log().info("**********************************************************************************");
		utils.log().info("Verifying UI Elements on Network - General Settings Port Forwarding Add Rule Page ");
		utils.log().info("**********************************************************************************");
		try {
			if (portRuletitle.isDisplayed())
				utils.log().info(portRuletitle.getText() + " title text is displayed ");

			if (portRuleNameLabel.isDisplayed())
				utils.log().info(portRuleNameLabel.getText() + " label is displayed ");

			if (enterPortRuleNameTextBox.isDisplayed())
				utils.log().info("Port Forwarding Rule Name text box is displayed ");

			if (protocolLabel.isDisplayed())
				utils.log().info(protocolLabel.getText() + " label is displayed ");

			if (tcpButton.isDisplayed())
				utils.log().info("TCP button is displayed ");

			if (udpButton.isDisplayed())
				utils.log().info("UDP button is displayed ");

			if (tcpUdpButton.isDisplayed())
				utils.log().info("TCP/UDP button is displayed ");

			if (enterInternalPortStartLabel.isDisplayed())
				utils.log().info(enterInternalPortStartTextBox.getText() + " label is displayed ");

			if (enterInternalPortStartTextBox.isDisplayed())
				utils.log().info("Enter Internal Port Start text box is displayed ");

			if (enterInternalPortEndLabel.isDisplayed())
				utils.log().info(enterInternalPortEndLabel.getText() + " label is displayed ");

			if (enterInternalPortEndTextBox.isDisplayed())
				utils.log().info("Enter Internal Port End text box is displayed ");

			if (enterExternalPortStartLabel.isDisplayed())
				utils.log().info(enterExternalPortStartLabel.getText() + " label is displayed ");

			if (enterExternalPortStartTextBox.isDisplayed())
				utils.log().info("Enter External Port Start text box is displayed ");

			if (enterExternalPortEndLabel.isDisplayed())
				utils.log().info(enterExternalPortEndLabel.getText() + " label is displayed ");

			if (enterExternalPortEndTextBox.isDisplayed())
				utils.log().info("Enter Internal Port End text box is displayed ");

			if (enterInternalIPAddressLabel.isDisplayed())
				utils.log().info(enterInternalIPAddressLabel.getText() + " label is displayed ");

			if (enterInternalIPAddressTextBox.isDisplayed())
				utils.log().info("Enter Internal IP Address text box is displayed ");

			if (saveChangesButton.isDisplayed())
				utils.log().info("Save button is displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean isAt() {
		if (portRuletitle.isDisplayed()) {
			utils.log().info("On Port Forwarding Add Rule Page");
			return true;
		} else {
			utils.log().info("Not on Port Forwarding Add Rule Page");
			return false;
		}
	}
}
