package pages;

import java.io.IOException;

import javax.swing.plaf.basic.BasicTreeUI;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.reader;
import base.util;

public class accountinformation extends BasicTreeUI {
	 @FindBy(xpath = "//b[contains(.,'Enter Account Information')]")
	    private WebElement enterAccountInformation;

	    @FindBy(id = "id_gender1")
	    private WebElement titleMrCheckbox;

	    @FindBy(id = "password")
	    private WebElement passwordInput;

	    @FindBy(id = "days")
	    private WebElement daysSelect;

	    @FindBy(id = "months")
	    private WebElement monthsSelect;

	    @FindBy(id = "years")
	    private WebElement yearsSelect;

	    @FindBy(id = "newsletter")
	    private WebElement newsletterCheckbox;

	    @FindBy(id = "optin")
	    private WebElement specialOffersCheckbox;

	    @FindBy(id = "first_name")
	    private WebElement firstNameInput;

	    @FindBy(id = "last_name")
	    private WebElement lastNameInput;

	    @FindBy(id = "company")
	    private WebElement companyInput;

	    @FindBy(id = "address1")
	    private WebElement address1Input;

	    @FindBy(id = "address2")
	    private WebElement address2Input;

	    @FindBy(id = "country")
	    private WebElement countrySelect;

	    @FindBy(id = "state")
	    private WebElement stateInput;

	    @FindBy(id = "city")
	    private WebElement cityInput;

	    @FindBy(id = "zipcode")
	    private WebElement zipcodeInput;

	    @FindBy(id = "mobile_number")
	    private WebElement mobileNumberInput;

	    @FindBy(css = "button[data-qa='create-account']")
	    private WebElement createAccountButton;

	    private WebDriver driver;

	    public accountinformation(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    public WebElement getEnterAccountInformation() {
	        return enterAccountInformation;
	    }

	    public createaccount fillAccountDetails() throws IOException, ParseException {
	        String password = "pass" + util.generateCurrentDateAndTime();
	        titleMrCheckbox.click();
	        passwordInput.sendKeys(password);
	        Select days = new Select(daysSelect);
	        days.selectByValue(reader.accountDetails("day"));
	        Select months = new Select(monthsSelect);
	        months.selectByValue(reader.accountDetails("month"));
	        Select years = new Select(yearsSelect);
	        years.selectByValue(reader.accountDetails("year"));
	        newsletterCheckbox.click();
	        specialOffersCheckbox.click();
	        firstNameInput.sendKeys(reader.accountDetails("firstName"));
	        lastNameInput.sendKeys(reader.accountDetails("lastName"));
	        companyInput.sendKeys(reader.accountDetails("company"));
	        address1Input.sendKeys(reader.accountDetails("address1"));
	        address2Input.sendKeys(reader.accountDetails("address2"));
	        Select countrySelector = new Select(countrySelect);
	        countrySelector.selectByValue(reader.accountDetails("country"));
	        stateInput.sendKeys(reader.accountDetails("state"));
	        cityInput.sendKeys(reader.accountDetails("city"));
	        zipcodeInput.sendKeys(reader.accountDetails("zipcode"));
	        mobileNumberInput.sendKeys(reader.accountDetails("mobileNumber"));
	        createAccountButton.click();
	        return new createaccount(driver);
	    }
}
