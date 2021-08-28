package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
    public WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'finish')]")
    private WebElement finishBtn;

    @FindBy(xpath = "//*[contains(@id, 'cancel')]")
    private WebElement cancelBtn;

    @FindBy(xpath = "//*[contains(@id, 'back-to-products')]")
    private WebElement homeBtn;

    public void clickFinishBtn() {
        finishBtn.click();
    }

    public void clickCancelBtn() {
        cancelBtn.click();
    }

    public void clickHomeBtn() {
        homeBtn.click();
    }

}
