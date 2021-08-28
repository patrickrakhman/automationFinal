package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[contains(@id, 'first-name')]")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[contains(@id, 'last-name')]")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[contains(@id, 'postal-code')]")
    private WebElement postalCodeField;

    @FindBy(xpath = "//*[contains(@id, 'cancel')]")
    private WebElement cancelBtn;

    @FindBy(xpath = "//*[contains(@id, 'continue')]")
    private WebElement continueBtn;

    public void inputFirstName(String firstName) {
        firstNameField.sendKeys(firstName); }

    public void inputLastName(String lastName) {
        lastNameField.sendKeys(lastName); }

    public void inputCode(String code) {
        postalCodeField.sendKeys(code); }

    public void clickCancelBtn() {
        cancelBtn.click();
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }

}
