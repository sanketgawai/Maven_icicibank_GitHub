package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.ClickHereToInvestNow;
import pomClasses.DownloadForms;
import pomClasses.HomePage;

public class TestClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.icicibank.com/");
		//testcase
		//1.move curser on help and contact
		//2.click download forms
		//3.click on credit card
		//4.on new page download form
		HomePage homePage = new HomePage(driver);
		homePage.clickHelpAndContact();
		homePage.clickOnDownloadForms();
		
		DownloadForms downloadForms = new DownloadForms(driver);
		downloadForms.clickOncreditCard();
		downloadForms.clickAutoDebiFacility();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		driver.close();
		driver.switchTo().window(addr.get(0));
		driver.navigate().back();
		
		//Test case : go to mutual fund
		//TestCase
		//move curser to invest
		// move curser to grow welth
		//click on mutualfund
		//click here to investnow
		homePage.moveToInvest();
		homePage.moveToGrowWelth();
		homePage.clickOnMutualFund();
		
		ClickHereToInvestNow clickHereToInvestNow = new ClickHereToInvestNow(driver);
		clickHereToInvestNow.clickOnClickHereToInvestNow();
		
		
	}
}
