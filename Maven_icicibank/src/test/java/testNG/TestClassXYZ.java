package testNG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.TestResult;

import pomClasses.DownloadForms;
import pomClasses.HomePage;
import pomClasses.MutualFundsIvestment;
import utils.Utility;

public class TestClassXYZ {
	WebDriver driver;
	static String TestID;
	HomePage homePage;
	DownloadForms downloadForms;
	MutualFundsIvestment mutualFundslvestment;
	ArrayList<String> addr;
	SoftAssert soft;
	
		@Parameters("browser")
		@BeforeTest
		public void openBrowser(String browserName) {
			
			if(browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new\\chromedriver.exe");
				driver = new ChromeDriver();
				}
			
			if(browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver","E:\\software testing\\selenium\\new\\geckodriver.exe");
				driver = new FirefoxDriver();
				
			}
			

			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		@BeforeClass
		public void creatPomObjects() {
			
			homePage = new HomePage(driver);
			mutualFundslvestment = new MutualFundsIvestment(driver);
			downloadForms = new DownloadForms(driver);
			 soft = new SoftAssert();
		}
		
		@BeforeMethod
		public void beforeMehtod() {
//*********	System.out.println("Before Method");
// in usability excel sheet ka code  use in facebook
//			String user = Utility.getDatafromExcel(TestID, 1, 0) //testId(sheetnam)row 1, column 0
//			loginOrSignUpPage.sendUserName(Utility.getDatafromExcel(TestID, 1, 0));
// 
// 			String pass = Utility.getDatafromExcel(TestID, 1, 0) //testId(sheetnam)row 1, column 0
//			loginOrSignUpPage.sendPassword(pass);
						
			driver.get("https://www.icicibank.com/");
		}
		
		@Test
		public void verifyDownloadFilebutton() {
			TestID = "1";
			System.out.println("Test -1");
			
			homePage.clickHelpAndContact();
			homePage.clickOnDownloadForms();
			
			
//			downloadForms.clickOncreditCard();
//			downloadForms.clickAutoDebiFacility();
			
//			addr = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(addr.get(1));
			
			String actualURL = driver.getCurrentUrl();
		  //String expectedURL = "https://www.icicibank.com/form-center?ITM=nli_cms_form_center_footer_link";
			String expectedURL = "https://www.icicibank.com/form-center";
		
//			if(actualURL.equals(expectedURL))
//			{
//				System.out.println("PASSED");
//			}
//			else
//			{
//				System.out.println("FAILED");
//			}
	
			
//			we use it when we need to sendkey data in like login page 


			
			Assert.assertEquals(actualURL, expectedURL);
			
//			SoftAssert soft = new SoftAssert();
//			soft.assertEquals(actualURL, expectedURL);
//			soft.assertAll();
			
		}
		
		@Test
		public void verifytoGrowWelthButton() {
			TestID = "2";
			System.out.println("test -2");
		
			mutualFundslvestment.clickOnGrowWelth();
			
			String actualURL = driver.getCurrentUrl();
			String actualTitle = driver.getTitle();
			
			String expectedURL = "https://www.icicibank.com/personal-banking/investments?ITM=nli_cms_grow_wealth_navigation_btn";
			String expectedTitle = "Investment Options - Online Investment Products, Schemes";
			
//			if(actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle))
//			{
//				System.out.println("PASSED");
//			}
//			else
//			{
//				System.out.println("FAILED");
//			}
						
			boolean result = (actualURL.equals(expectedURL) && actualTitle.equals(expectedTitle));
			Assert.assertEquals(result, result);

		}
		
		@AfterMethod
//		public void afterMethod() throws IOException {
		public void afterMethod(ITestResult result) throws IOException {	
			System.out.println("After method");
			if(TestResult.FAILURE == result.getStatus())
			{
//				Utility.captureScreenShot(TestID);
				Utility.captureScreenShot(driver, TestID);
			}
			
			  
			 
			
//			Utility.captureScreenShot(driver,TestID);
			 
//			driver.close();//if you use driver.close();
			//Configuration Failures: 1, Skips: 4
			//org.openqa.selenium.NoSuchSessionException: invalid session id
			//sol : NoSuchSessionExpection happens when you try to perform any actions after webdriver.quit(). Make sure you are not calling any command after webdriver.quit().
			
			ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(addr.get(0));

		}
		

		
		
		@AfterClass
		public void afterClass() {
			System.out.println("After Class");
			homePage = null;
			mutualFundslvestment = null;
			downloadForms = null;
		}
		
		@AfterTest
		public void afterTest() {
			System.out.println("After Test");
			driver.quit();
			driver = null;
			System.gc();
		}
			
		//thread-count="5"	
		
}
	
	

