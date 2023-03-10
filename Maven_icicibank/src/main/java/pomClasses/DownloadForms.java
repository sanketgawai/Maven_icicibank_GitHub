package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadForms {
	private WebDriver driver;
	private Actions act;
	
	//testcase
	//1.move curser on help and contact
	//2.click download forms
	//3.click on credit card
	//4.on new page download form
//	@FindBy(xpath ="//header[@id='new-header']//a[text() = 'HELP & CONTACT']")
//	private WebElement helpAndContact;
//	
	@FindBy(xpath = "//a[text() = 'Download Forms']")
	private WebElement downloadForms;
	
	@FindBy(xpath = "//div[@id='faqaccordion-1']//h3")
	private WebElement creditCard;
	
	@FindBy(xpath = "(//div[@itemprop='text']//ul//li//a)[1]")
	private WebElement autoDebitFacility;
	
	public DownloadForms(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
//	public void clickHelpAndContact (){
//		 act.moveToElement(helpAndContact);
//	}
//	public void clickOnDownloadForms() {
//		act.moveToElement(downloadForms).click().build().perform();
//	}
	public void clickOncreditCard() {
		creditCard.click();
	}
	public void clickAutoDebiFacility() {
		autoDebitFacility.click();
	}
}
