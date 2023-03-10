package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//testcase
	//1.move curser on help and contact
	//2.click download forms
	//3.click on credit card
	//4.on new page download form
	private WebDriver driver;
	private Actions act;
	@FindBy(xpath ="//header[@id='new-header']//a[text() = 'HELP & CONTACT']")
	private WebElement helpAndContact;
	
	@FindBy(xpath = "//a[text() = 'Download Forms']")
	private WebElement downloadForms;
	

	
	//Test case : go to mutual fund
	//TestCase
	//move curser to invest
	// move curser to grow welth
	//click on mutualfund
	//click here to investnow
	@FindBy(xpath = "//span[text() = 'Invest']")
	private WebElement invest;
	
	@FindBy(xpath = "//a[@href='https://www.icicibank.com/Personal-Banking/investments/investment.page?ITM=nli_cms_grow_wealth_navigation_btn']")
	private WebElement growWelth; 
	
	@FindBy(xpath = "//a[@href='https://www.icicibank.com/Personal-Banking/investments/mutual-funds/index.page?ITM=nli_cms_MF_menu_navigation']")
	private WebElement mutualFund; 
	
 
	
	//constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		 act = new Actions(driver);
	}
	
	//methods
	//Test case : downloadAutoDebiFacililty form
	public void clickHelpAndContact (){
		 act.moveToElement(helpAndContact);
	}
	public void clickOnDownloadForms() {
		act.moveToElement(downloadForms).click().build().perform();
	}

	
	
	//Test case : go to mutual fund
	public void moveToInvest() {
		act.moveToElement(invest).perform();
	}
	public void moveToGrowWelth() {
		act.moveToElement(growWelth).perform();
	}
	public void clickOnMutualFund() {
		act.moveToElement(mutualFund).click().build().perform();
	}

	
	
	
}
