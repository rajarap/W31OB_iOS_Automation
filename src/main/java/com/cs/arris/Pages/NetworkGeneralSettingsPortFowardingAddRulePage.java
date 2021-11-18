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

	public void clickCloseButton() {
		try {
			if (closeButton.isDisplayed()) {
				click(closeButton);
				utils.log().info("Clicked on Close Button");}
		} catch (Exception e) {
			utils.log().info("Close button is not displayed");
		}
	}
	
	public void clickSaveButton() {
		try {
			if (saveChangesButton.isDisplayed()) {
				click(saveChangesButton);
				utils.log().info("Clicked on Save Changes Button");}
		} catch (Exception e) {
			utils.log().info("Save Changes button is not displayed");
		}
	}
	
	public void hideKeyboard()
	{
		super.getDriver().hideKeyboard();
	}
	
	public void verifyUIOnPortForwardingAddRulePage() {
		utils.log().info("                                                                                  ");
		utils.log().info("**********************************************************************************");
		utils.log().info("Verifying UI Elements on Network - General Settings Port Forwarding Add Rule Page ");
		utils.log().info("**********************************************************************************");
		try {
			if (portRuletitle.isDisplayed())
				utils.log().info(portRuletitle.getText() + " title text is displayed ");
		} catch (Exception e) {
			utils.log().info("ADD PORT FORWARDING RULE title text is not displayed");
		}
		
		try {
			if (portRuleNameLabel.isDisplayed())
				utils.log().info(portRuleNameLabel.getText() + " label is displayed ");
		} catch (Exception e) {
			utils.log().info("Port Forwarding Rule Name label is not displayed");
		}
		
		try {
			if (enterPortRuleNameTextBox.isDisplayed())
				utils.log().info("Port Forwarding Rule Name text box is displayed ");
		} catch (Exception e) {
			utils.log().info("Port Forwarding Rule Name text box is not displayed");
		}
		
		try {
			if (protocolLabel.isDisplayed())
				utils.log().info(protocolLabel.getText() + " label is displayed ");
		} catch (Exception e) {
			utils.log().info("Protocollabel is not displayed");
		}
		
		try {
			if (tcpButton.isDisplayed())
				utils.log().info("TCP button is displayed ");
		} catch (Exception e) {
			utils.log().info("TCP button is not displayed");
		}
		
		try {
			if (udpButton.isDisplayed())
				utils.log().info("UDP button is displayed ");
		} catch (Exception e) {
			utils.log().info("UDP button is not displayed");
		}
		
		try {
			if (tcpUdpButton.isDisplayed())
				utils.log().info("TCP/UDP button is displayed ");
		} catch (Exception e) {
			utils.log().info("TCP/UDP button is not displayed");
		}
		
		try {
			if (enterInternalPortStartLabel.isDisplayed())
				utils.log().info(enterInternalPortStartTextBox.getText() + " label is displayed ");
		} catch (Exception e) {
			utils.log().info("Enter Internal Port Start label is not displayed");
		}
		
		try {
			if (enterInternalPortStartTextBox.isDisplayed())
				utils.log().info("Enter Internal Port Start text box is displayed ");
		} catch (Exception e) {
			utils.log().info("Enter Internal Port Start text box is not displayed");
		}
		
		try {
			if (enterInternalPortEndLabel.isDisplayed())
				utils.log().info(enterInternalPortEndLabel.getText() + " label is displayed ");
		} catch (Exception e) {
			utils.log().info("Enter Internal Port End label is not displayed");
		}
		
		try {
			if (enterInternalPortEndTextBox.isDisplayed())
				utils.log().info("Enter Internal Port End text box is displayed ");
		} catch (Exception e) {
			utils.log().info("Enter Internal Port End text box is not displayed");
		}
		
		try {
			if (enterExternalPortStartLabel.isDisplayed())
				utils.log().info(enterExternalPortStartLabel.getText() + " label is displayed ");
		} catch (Exception e) {
			utils.log().info("Enter External Port Start label is not displayed");
		}
		
		try {
			if (enterExternalPortStartTextBox.isDisplayed())
				utils.log().info("Enter External Port Start text box is displayed ");
		} catch (Exception e) {
			utils.log().info("Enter External Port Start text box is not displayed");
		}
		
		try {
			if (enterExternalPortEndLabel.isDisplayed())
				utils.log().info(enterExternalPortEndLabel.getText() + " label is displayed ");
		} catch (Exception e) {
			utils.log().info("Enter External Port End label is not displayed");
		}
		
		try {
			if (enterExternalPortEndTextBox.isDisplayed())
				utils.log().info("Enter Internal Port End text box is displayed ");
		} catch (Exception e) {
			utils.log().info("Enter External Port End text box is not displayed");
		}
		
		try {
			if (enterInternalIPAddressLabel.isDisplayed())
				utils.log().info(enterInternalIPAddressLabel.getText() + " label is displayed ");
		} catch (Exception e) {
			utils.log().info("Enter Internal IP Address label is not displayed");
		}
		
		try {
			if (enterInternalIPAddressTextBox.isDisplayed())
				utils.log().info("Enter Internal IP Address text box is displayed ");
		} catch (Exception e) {
			utils.log().info("Enter Internal IP Address text box is not displayed");
		}
		
		try {
			if(saveChangesButton.isDisplayed())
				utils.log().info("Save button is displayed");
		} catch (Exception e) {
			utils.log().info("Save button is not displayed");
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
