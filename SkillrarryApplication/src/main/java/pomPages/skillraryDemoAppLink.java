package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.webDriverUtility;

public class skillraryDemoAppLink {
/*
 * this class contains all the element and respect business libraries of skillrarry demo app page.
 * @author raza
 */
	//declaration
	@FindBy(xpath="//div[@class='navbar-header']/a")
	private WebElement pageHeader;
	@FindBy(id="course")
	private WebElement courseTab;
	@FindBy(xpath="//span/a[text()='Selenium Training']")
	private WebElement seleniumTrainingLink;
	public WebElement getCourseTab() {
		return courseTab;
	}
	public WebElement getSeleniumTrainingLink() {
		return seleniumTrainingLink;
	}
	public WebElement getCategoryDropDowns() {
		return categoryDropDowns;
	}
	public WebElement getContactUsLink() {
		return contactUsLink;
	}
	@FindBy(name="addresstype")
	private WebElement categoryDropDowns;
	@FindBy(xpath="a[text()='Contact Us']")
	private WebElement contactUsLink;
	
	//initialisation
	public skillraryDemoAppLink(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilisation
	/*
	 * this method returns page header text
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	/*
	 * this method is used to mouse hover to course tab
	 * @param web
	 */
	public void mouseHoverToCourse(webDriverUtility web) {
		web.mouseHover(courseTab);
	}
	/*
	 * this method is used to click on selnium training link
	 * 
	 */
	public void clickSeleniumTraining() {
		seleniumTrainingLink.click();
	}
	/*
	 * this method is used to choose category from drag and drop down
	 * @param web
	 * @param index
	 */
	public void selectCategory(webDriverUtility web, int index) {
		web.dropDown(categoryDropDowns, index);
	}
	/*
	 * this method is used to click on contact us link
	 */
	public void clickContactUs() {
		contactUsLink.click();
	}
}
