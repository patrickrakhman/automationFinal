package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора меню пользователя
     */
    @FindBy(xpath = "//*[contains(@id, 'back-to-products')]")
    private WebElement backToProducts;


    public void clickBackToProducts() {
        backToProducts.click();
    }
}
