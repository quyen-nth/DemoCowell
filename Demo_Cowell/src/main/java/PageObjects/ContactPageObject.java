package PageObjects;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPage;
import PageUIs.ContactPageUI;

public class ContactPageObject extends AbstractPage{
	
	public String GetContactPageTitle(WebDriver driver) {
		return getTitleUrl(driver);
	}

	public void InputDataToHoTen(WebDriver driver, String value) {
		inputToElement(driver, ContactPageUI.TXT_HOTEN, value);
	}
	
	public void InputDataToEmail(WebDriver driver, String value) {
		inputToElement(driver, ContactPageUI.TXT_EMAIL, value);
	}
	
	public void InputDataToDienThoai(WebDriver driver, String value) {
		inputToElement(driver, ContactPageUI.TXT_DIENTHOAI, value);
	}
	
	public void SelectDataToMucDich(WebDriver driver, String value) {
		selectTextValue(driver, ContactPageUI.TXT_MUCDICH, value);
	}
	
	public void InputDataToMessage(WebDriver driver, String value) {
		inputToElement(driver, ContactPageUI.TXT_MESSAGE, value);
	}
	
	public void ClickToSubmit(WebDriver driver) {
		clickToElement(driver, ContactPageUI.BTN_SEND);
	}
	
	public void WaitForSuccessMsgDisplayed(WebDriver driver) {
		waitForElementVisible(driver, ContactPageUI.LBL_SUCCESSMESSAGE);
	}
	
	public String GetContactSuccessMsg(WebDriver driver) {
		return getTextElement(driver, ContactPageUI.LBL_SUCCESSMESSAGE);
	}
}
