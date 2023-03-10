package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MutualFundsIvestment {
	private WebDriver driver;
	private Actions act;

	//Test case : go to mutual fund
	//TestCase
	//move curser to invest
	// move curser to grow welth
	//click on growWelth
	//check groWwelth button working 
	@FindBy(xpath = "//span[text() = 'Invest']")
	private WebElement invest;
	
	@FindBy(xpath = "//a[@href='https://www.icicibank.com/Personal-Banking/investments/investment.page?ITM=nli_cms_grow_wealth_navigation_btn']")
	private WebElement growWelth; 
//	
	@FindBy(xpath = "//a[@href='https://www.icicibank.com/Personal-Banking/investments/mutual-funds/index.page?ITM=nli_cms_MF_menu_navigation']")
	private WebElement mutualFund; 
	

	
	public MutualFundsIvestment(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		 act = new Actions(driver);
	}
	

	public void clickOnGrowWelth() {
	act.moveToElement(invest).click().moveToElement(growWelth).click();
}

}
