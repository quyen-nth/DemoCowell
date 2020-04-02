package PageObjects;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPage;
import PageUIs.HomePageUI;

public class HomePageObject extends AbstractPage{

	public void ClickToContactLink(WebDriver driver) {
		clickToElement(driver, HomePageUI.CONTACT_LINK);
	}
	
	public String GetHomePageTitle(WebDriver driver) {
		return getTitleUrl(driver);
	}
	
	public void WaitHomePageLoad(WebDriver driver) {
		waitForPageReload(driver);
	}
}
