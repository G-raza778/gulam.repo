package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webDriverUtility {
private WebDriver driver;
@SuppressWarnings("deprecation")
public WebDriver openApplication(String browser,String url, long time) {
	switch (browser){
	case "chrome": WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	break;
	case "edge":WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
	break;
	case "firefox":WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	break;
	default: System.out.println("invalid browser data");
}
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	return driver;
}
	public WebElement explicitwait(WebElement element,Duration time) {
		WebDriverWait wait=new WebDriverWait(driver,time) ;
			WebElement e=wait.until(ExpectedConditions.visibilityOf(element));
			return e;
		}
	public void mouseHover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void doubleClickOnElement(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	public void rightClick(WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	public void dragAndDropElement(WebElement element, WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(element, target).perform();
	}
	public void dropDown(WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void dropDown(WebElement element, String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void dropDown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(String name) {
		driver.switchTo().frame(name);
	}
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView(true)", element);
	}
	public void takeScreenShot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShot"+".png");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void handleElert(String Status) {
		Alert al=driver.switchTo().alert();
		if (Status.equalsIgnoreCase("ok")) {
			al.accept();
		}
		else {
			al.dismiss();
		}
		
	}
	public void handleChildBrowser() {
		Set<String> set=driver.getWindowHandles();
		for(String wId:set) {
			driver.switchTo().window(wId);
		}
	}
	public void closeCurrentTab() {
		driver.close();
	}
	public void quiteBrowser() {
		driver.quit();
	}
}


