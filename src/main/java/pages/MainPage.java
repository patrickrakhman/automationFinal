package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[contains(@id, 'react-burger-menu-btn')]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(@id, 'logout_sidebar_link')]")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[contains(@data-test, 'product_sort_container')]")
    private WebElement sortMenu;

    @FindBy(xpath = "//*[contains(@value, 'az')]")
    private WebElement azSort;

    @FindBy(xpath = "//*[contains(@value, 'za')]")
    private WebElement zaSort;

    @FindBy(xpath = "//*[contains(@value, 'lohi')]")
    private WebElement lohiSort;

    @FindBy(xpath = "//*[contains(@value, 'hilo')]")
    private WebElement hiloSort;

    @FindBy(xpath = "//*[contains(@id, 'add-to-cart-sauce-labs-backpack')]")
    private WebElement addToCart;

    @FindBy(xpath = "//*[contains(@class, 'shopping_cart_link')]")
    private WebElement cartBtn;

    @FindBy(xpath = "//*[contains(@class, 'inventory_item_name')]")
    private WebElement goToProduct;





    public void entryMenu() {
        userMenu.click();
    }


    public void userLogout() {
        logoutBtn.click();
    }

    public void clickSortMenu() {
        sortMenu.click();
    }

    public void clickAzSort() {
        azSort.click();
    }

    public void clickZaSort() {
        zaSort.click();
    }

    public void clickLohiSort() {
        lohiSort.click();
    }

    public void clickHiloSort() {
        hiloSort.click();
    }

    public void clickAddToCart() {
        addToCart.click();
    }

    public void clickCartBtn() {
        cartBtn.click();
    }
    public void clickGoToProduct() {
        goToProduct.click();
    }


}

