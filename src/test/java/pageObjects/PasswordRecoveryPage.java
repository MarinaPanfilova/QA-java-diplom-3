package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class PasswordRecoveryPage {

    //Кнопка войти
    @FindBy(xpath = "//*[text()='Войти']")
    private SelenideElement loginButton;

    //Метод клика по кнопке Зарегистрироваться
    public LoginPage clickRegistrationButton() {
        loginButton.scrollTo();
        loginButton.click();
        return page(LoginPage.class);
    }

}
