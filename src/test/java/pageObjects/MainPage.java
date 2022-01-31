package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site";

    //Кнопка войти в аккаунт
    @FindBy(xpath = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement loginButton;

    //Кнопка оформить заказ
    @FindBy(xpath = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    //Кнопка личный кабинет
    @FindBy(xpath = "//*[text()='Личный Кабинет']")
    private SelenideElement personAreaButton;

    //Кнопка начинки
    @FindBy(xpath = "//*[text()='Начинки']")
    private SelenideElement fillingsButton;

    //Кнопка вкладки начинки
    @FindBy(xpath = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']")
    private SelenideElement fillingsTab;

    //Кнопка соусы
    @FindBy(xpath = "//*[text()='Соусы']")
    private SelenideElement saucesButton;

    //Кнопка вкладки соусы
    @FindBy(xpath = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']")
    private SelenideElement saucesTab;

    //Кнопка булки
    @FindBy(xpath = ".//*[//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]/span]")
    private SelenideElement bunsButton;

    //Кнопка вкладки булки
    @FindBy(xpath = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']")
    private SelenideElement bunsTab;

    //Методы для главной страницы
    public LoginPage clickLoginButton() {
        loginButton.scrollTo();
        loginButton.click();
        return page(LoginPage.class);
    }

    public LoginPage clickPersonAreaButton() {
        personAreaButton.scrollTo();
        personAreaButton.click();
        return page(LoginPage.class);
    }

    public ProfilePage clickProfileButton() {
        personAreaButton.scrollTo();
        personAreaButton.click();
        return page(ProfilePage.class);
    }

    public LoginPage createOrderButton() {
        this.createOrderButton.scrollTo();
        return page(LoginPage.class);
    }

    public void clickFillingsButton() {
        fillingsButton.scrollTo();
        fillingsButton.click();
    }

    public void fillingsTabText() {
        fillingsTab.shouldHave(exactText("Начинки"));
    }

    public void clickSaucesButton() {
        saucesButton.scrollTo();
        saucesButton.click();
    }

    public void saucesTabText() {
        saucesTab.shouldHave(exactText("Соусы"));
    }

    public void clickBunsButton() {
        bunsButton.scrollTo();
        bunsButton.click();
    }

    public void bunsTabText() {
        bunsTab.shouldHave(exactText("Булки"));
    }

    public void checkTabs() {
        clickFillingsButton();
        fillingsTabText();
        clickSaucesButton();
        saucesTabText();
        clickBunsButton();
        bunsTabText();
    }

}
