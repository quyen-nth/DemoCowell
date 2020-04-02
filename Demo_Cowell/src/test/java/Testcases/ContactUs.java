package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Commons.AbstractTest;
import Commons.DriverManager;
import PageObjects.ContactPageObject;
import PageObjects.HomePageObject;
import PageUIs.ContactPageUI;
import PageUIs.HomePageUI;
import Testdatas.Contact;

public class ContactUs extends AbstractTest {

	WebDriver driver;
	String homePageUrl = "https://co-well.vn/";
	HomePageObject homePage;
	ContactPageObject contactPage;
	Contact contactObj;

	@Test
	public void TC01_ContactUsWithValidData() {

		contactObj = new Contact("Test QA", "test@gmail.com", "0123456789", "Tuyển dụng",
				"Bạn có thể gửi thông tin tuyển dụng vị trí Automation tester vào email của mình được không?");

		log.info("TC01_ContactUsWithValidData: Step 01: Waiting for Home page is displayed");
		homePage.WaitHomePageLoad(driver);
		verifyEquals(HomePageUI.TITLEPAGE, homePage.GetHomePageTitle(driver));		
		log.info("TC01_ContactUsWithValidData: Step 02: Click to 'Liên hệ' link");
		homePage.ClickToContactLink(driver);

		contactPage = DriverManager.pageGenerator.getContactPage();
		log.info("TC01_ContactUsWithValidData: Step 03: Waiting for Contact page is displayed");
		verifyEquals(ContactPageUI.TITLEPAGE, contactPage.GetContactPageTitle(driver));
		log.info("TC01_ContactUsWithValidData: Step 04: Input data to 'Họ & tên' textbox");
		contactPage.InputDataToHoTen(driver, contactObj.getHoTen());
		log.info("TC01_ContactUsWithValidData: Step 05: Input data to 'Email' textbox");
		contactPage.InputDataToEmail(driver, contactObj.getEmail());
		log.info("TC01_ContactUsWithValidData: Step 06: Input data to 'Điện thoại' textbox");
		contactPage.InputDataToDienThoai(driver, contactObj.getDienThoai());
		log.info("TC01_ContactUsWithValidData: Step 07: Select value for 'Mục đích liên hệ'");
		contactPage.SelectDataToMucDich(driver, contactObj.getMucDich());
		log.info("TC01_ContactUsWithValidData: Step 08: Input data to 'Message' textarea");
		contactPage.InputDataToMessage(driver, contactObj.getMessage());
		log.info("TC01_ContactUsWithValidData: Step 09: Click to 'Gửi tin' button");
		contactPage.ClickToSubmit(driver);
		log.info("TC01_ContactUsWithValidData: Step 11: Wait for the success message displayed");
		contactPage.WaitForSuccessMsgDisplayed(driver);
		log.info("TC01_ContactUsWithValidData: Step 12: Verify the success message");
		verifyEquals(ContactPageUI.CONTACT_SUCCESSMSG, contactPage.GetContactSuccessMsg(driver));
	}

	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browserName) {
		driver = DriverManager.initDriver(browserName);
		driver.get(homePageUrl);

		homePage = DriverManager.pageGenerator.getHomePage();
	}

	@AfterClass
	public void afterClass() {
	}

}
