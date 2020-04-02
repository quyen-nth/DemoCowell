package PageObjects;

public class PageGeneratorManager {

	public HomePageObject getHomePage() {
		return new HomePageObject();
	}

	public ContactPageObject getContactPage() {
		return new ContactPageObject();
	}

	
}
