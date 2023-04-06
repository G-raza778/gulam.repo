package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.ContactUsPage;
import pomPages.HomePage;
import pomPages.SeleniumTrainingPage;
import pomPages.TestingPage;
import pomPages.skillraryDemoAppLink;

public class BaseClass {
	protected webDriverUtility web;
	protected PropertyFileUtility property;
	protected ExcelUtility excel;
	protected javaUtility jUtil;
	protected WebDriver driver;
	protected HomePage home;
	protected skillraryDemoAppLink demoApp;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected ContactUsPage contact;
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	public void classConfiguration() {
		web = new webDriverUtility();
		property = new PropertyFileUtility();
		excel = new ExcelUtility();
		jUtil = new javaUtility();
		
		property.propertyConfig(iconstantPath.PROPERTIES_PATH);
		String browser = property.fetchProperty("browser");
		String url = property.fetchProperty("url");
		long time = Long.parseLong(property.fetchProperty("time"));
		driver = web.openApplication(browser, url, time);
	}
	
	@BeforeMethod
	public void methodConfiguration() {
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
		home = new HomePage(driver);
		demoApp = new skillraryDemoAppLink(driver);
		selenium = new SeleniumTrainingPage(driver);
		testing = new TestingPage(driver);
		contact = new ContactUsPage(driver);
		
		Assert.assertTrue(home.getLogo().isDisplayed());
	}
	
	@AfterMethod
	public void methodTearDown() {
		excel.closeWorkbook();
	}
	
	@AfterClass
	public void classTearDown() {
		web.quiteBrowser();
	}
	
	//@AfterTest
	//@AfterSuite
}
