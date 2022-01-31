package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {

    //Кнопка выход
    @FindBy(xpath = "//*[contains(text(),'Выход')]")
    private SelenideElement logoutButton;

    //Кнопка контруктор
    @FindBy(xpath = "//*[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;

    //Логотип
    @FindBy(xpath = ".//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;

    public MainPage clickLogoutButton() {
        logoutButton.scrollTo();
        logoutButton.click();
        return page(MainPage.class);
    }

    public MainPage clickConstructorButton() {
        constructorButton.scrollTo();
        constructorButton.click();
        return page(MainPage.class);
    }

    public MainPage clickLogo() {
        logo.scrollTo();
        logo.click();
        return page(MainPage.class);
    }

}
