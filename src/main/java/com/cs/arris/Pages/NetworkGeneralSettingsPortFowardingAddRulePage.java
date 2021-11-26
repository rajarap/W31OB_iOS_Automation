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
	String[] ipAddress = {"192.168.7.101", "192.168.7.102" , "192.168.7.103", "192.168.7.104" , "192.168.7.105"};

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
	
	//Error messages
	
	//Please enter Port Forwarding Rule Name.
	@AndroidFindBy(id = "com.arris.sbcBeta:id/port_name_dialog_error")
	public MobileElement portNameDialogError;
	
	//Port should be in between 1 to 65536
	@AndroidFindBy(id = "com.arris.sbcBeta:id/internal_port_start_dialog_error")
	public MobileElement internalPortStartError;
	
	//Port should be in between 1 to 65536
	@AndroidFindBy(id = "com.arris.sbcBeta:id/internal_port_end_dialog_error")
	public MobileElement internalPortEndError;
	
	//Start port should be lesser than End port
	@AndroidFindBy(id = "com.arris.sbcBeta:id/internal_port_start_dialog_error")
	public MobileElement internalStartPortLessThanEndPort;
	
	//Port should be in between 1 to 65536
	@AndroidFindBy(id = "com.arris.sbcBeta:id/external_port_start_dialog_error")
	public MobileElement externalPortStartError;
	
	//Port should be in between 1 to 65536
	@AndroidFindBy(id = "com.arris.sbcBeta:id/external_port_end_dialog_error")
	public MobileElement externalPortEndError;
	
	//Please enter a valid IP Address
	@AndroidFindBy(id = "com.arris.sbcBeta:id/internal_ip_address_dialog_error")
	public MobileElement enterValidIPAddress;
	
	//IP Address must be within the subnet range.
	@AndroidFindBy(id = "com.arris.sbcBeta:id/internal_ip_address_dialog_error")
	public MobileElement enterInvalidIPAddress;
	
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
			super.pause(15);
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
	
	//Click Save Changes without entering any data
	public boolean verifyEnterPortForwardingRuleName() {
		utils.log().info("                                                 ");
		utils.log().info("*************************************************");
		utils.log().info("Verifying Enter Port Forwarding Rule Name Error  ");
		utils.log().info("*************************************************");
		super.getDriver().hideKeyboard();
		this.clickSaveButton();
		super.pause(2);
		if(portNameDialogError.isDisplayed())
			utils.log().info("Validation Message : " + portNameDialogError.getText() + " is displayed");
		String ruleName = super.generatePortRuleName();
		sendKeys(enterPortRuleNameTextBox, ruleName);
		utils.log().info("Entered Rule Name: " + ruleName);
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterInternalPortStart() {
		utils.log().info("                                            ");
		utils.log().info("********************************************");
		utils.log().info("Verifying Enter Internal Port Start Error   ");
		utils.log().info("********************************************");
		super.getDriver().hideKeyboard();
		this.clickSaveButton();
		super.pause(2);
		if(internalPortStartError.isDisplayed())
			utils.log().info("Validation Message : " + internalPortStartError.getText() + " is displayed");
		String internalPortStart = super.generateInternalPortStart();
		sendKeys(enterInternalPortStartTextBox, internalPortStart);
		utils.log().info("Entered Internal Port Start" + internalPortStart);
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterInternalPortEnd() {
		utils.log().info("                                            ");
		utils.log().info("********************************************");
		utils.log().info("Verifying Enter Internal Port End Error   ");
		utils.log().info("********************************************");
		super.getDriver().hideKeyboard();
		this.clickSaveButton();
		super.pause(2);
		if(internalStartPortLessThanEndPort.isDisplayed())
			utils.log().info("Validation Message : " + internalStartPortLessThanEndPort.getText() + " is displayed");
		String internalPortEnd = super.generateInternalPortStart();
		sendKeys(enterInternalPortEndTextBox, internalPortEnd);
		utils.log().info("Entered Internal Port End" + internalPortEnd);
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyInternalPortStartLessThenPortEnd() {
		utils.log().info("                                                                 ");
		utils.log().info("*****************************************************************");
		utils.log().info("Verifying Internal Port Start Should Be Less Than Port End Error ");
		utils.log().info("*****************************************************************");
		super.getDriver().hideKeyboard();
		this.clickSaveButton();
		super.pause(2);
		if(internalStartPortLessThanEndPort.isDisplayed())
			utils.log().info("Validation Message : " + internalStartPortLessThanEndPort.getText() + " is displayed");
		int startPort1 = Integer.valueOf(enterInternalPortStartTextBox.getText());
		String internalPortEnd = String.valueOf(startPort1--);
		sendKeys(enterInternalPortEndTextBox, internalPortEnd);
		utils.log().info("Entered Port Start less than Port End" + internalPortEnd);
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterExternalPortStart() {
		utils.log().info("                                            ");
		utils.log().info("********************************************");
		utils.log().info("Verifying Enter External Port Start Error   ");
		utils.log().info("********************************************");
		super.getDriver().hideKeyboard();
		this.clickSaveButton();
		super.pause(2);
		if(externalPortStartError.isDisplayed())
			utils.log().info("Validation Message : " + externalPortStartError.getText() + " is displayed");
		String externalPortEnd = super.generateExternalPortStart();
		sendKeys(enterExternalPortStartTextBox, externalPortEnd);
		utils.log().info("Entered External Port Start"+ externalPortEnd);
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterExternalPortEnd() {
		utils.log().info("                                            ");
		utils.log().info("********************************************");
		utils.log().info("Verifying Enter External Port End Error   ");
		utils.log().info("********************************************");
		super.getDriver().hideKeyboard();
		this.clickSaveButton();
		super.pause(2);
		if(externalPortEndError.isDisplayed())
			utils.log().info("Validation Message : " + externalPortEndError.getText() + " is displayed");
		String externalPortEnd = super.generateExternalPortEnd();
		sendKeys(enterExternalPortStartTextBox, externalPortEnd);
		sendKeys(enterExternalPortEndTextBox, externalPortEnd);
		utils.log().info("Entered External Port End");
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterValidIPAddress() {
		utils.log().info("                                        ");
		utils.log().info("****************************************");
		utils.log().info("Verifying Enter Valid IP Address Error  ");
		utils.log().info("****************************************");
		super.getDriver().hideKeyboard();
		this.clickSaveButton();
		if(enterValidIPAddress.isDisplayed())
			utils.log().info("Validation Message : " + enterValidIPAddress.getText() + " is displayed");
		//enter invalid IP address
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterInValidIPAddress() {
		utils.log().info("                                          ");
		utils.log().info("******************************************");
		utils.log().info("Verifying Enter InValid IP Address Error  ");
		utils.log().info("******************************************");
		super.getDriver().hideKeyboard();
		sendKeys(enterInternalIPAddressTextBox, "127.0.0.1");
		utils.log().info("Entered Invalid IP Address");
		this.clickSaveButton();
		if(enterInvalidIPAddress.isDisplayed())
			utils.log().info("Validation Message : " + enterInvalidIPAddress.getText() + " is displayed");
		sendKeys(enterInternalIPAddressTextBox, "192.168.7.150");
		utils.log().info("Entered valid IP Address");
		super.getDriver().hideKeyboard();
		this.clickSaveButton();
		return true;
	}
	
	public boolean createPortRuleName() {
		getDriver().hideKeyboard();
		if(enterPortRuleNameTextBox.isDisplayed())
			sendKeys(enterPortRuleNameTextBox, super.generatePortRuleName());
		return true;
	}
	
	public boolean selectTCP() {
		if(tcpButton.isDisplayed())
			click(tcpButton);
		return true;
	}
	
	public boolean selectUdp() {
		if(udpButton.isDisplayed())
			click(udpButton);
		return true;
	}
	
	public boolean selectTcpUdp() {
		if(tcpUdpButton.isDisplayed())
			click(tcpUdpButton);
		return true;
	}
	
	public boolean createInternalPortStart() {
		getDriver().hideKeyboard();
		if(enterInternalPortStartTextBox.isDisplayed())
			sendKeys(enterInternalPortStartTextBox, super.generateInternalPortStart());
		return true;
	}
	
	public boolean createInternalPortEnd() {
		getDriver().hideKeyboard();
		if(enterInternalPortEndTextBox.isDisplayed())
			sendKeys(enterInternalPortEndTextBox, super.generateInternalPortEnd());
		return true;
	}
	
	public boolean createExternalPortStart() {
		getDriver().hideKeyboard();
		if(enterExternalPortStartTextBox.isDisplayed())
			sendKeys(enterExternalPortStartTextBox, super.generateExternalPortStart());
		return true;
	}
	
	public boolean createExternalPortEnd() {
		getDriver().hideKeyboard();
		if(enterExternalPortEndTextBox.isDisplayed())
			sendKeys(enterExternalPortEndTextBox, super.generateExternalPortEnd());
		return true;
	}
	
	public boolean createIPAddress(String ipAdd) {
		getDriver().hideKeyboard();
		if(enterInternalIPAddressTextBox.isDisplayed())
			sendKeys(enterInternalIPAddressTextBox, ipAdd);
		return true;
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
