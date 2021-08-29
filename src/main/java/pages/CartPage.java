package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[contains(@id, 'continue-shopping')]")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//*[contains(@id, 'remove-sauce-labs-backpack')]")
    private WebElement removeFromCartBtn;

    @FindBy(xpath = "//*[contains(@id, 'checkout')]")
    private WebElement checkoutBtn;

    @FindBy (xpath = "//div[@class='removed_cart_item']")
    WebElement removedCartItem;

    public void clickContinueShoppingBtn() {
        continueShoppingBtn.click();
    }

    public void clickRemoveFromCartBtn() {
        removeFromCartBtn.click();
    }

    public void clickCheckoutBtn() {
        checkoutBtn.click();
    }

    public boolean cartIsEmpty(){
        return removedCartItem.isEnabled();
    }

}
