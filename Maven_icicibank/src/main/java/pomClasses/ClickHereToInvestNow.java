package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickHereToInvestNow {
	private WebDriver driver;
	private Actions act;
	
	@FindBy(xpath = "//a[text() = 'CLICK HERE TO INVEST NOW']")
	private WebElement clickHereToInvestNow;
	
	@FindBy(xpath ="//div[text() = 'Mutual Funds Investment - Invest In Mutual Funds Online']")
	private WebElement MutualFundsInvText;
	
	public ClickHereToInvestNow(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		 act = new Actions(driver);
	}
	
	public void clickOnClickHereToInvestNow() {
		clickHereToInvestNow.click();
	}
	
	public void getTextMutualFund() {
		String text = MutualFundsInvText.getText();
		System.out.println(text);
	}
	
}
