package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    //Локаторы регистрации
    //Поле имя
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement nameField;

    //Поле email
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailField;

    //Поле пароль
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input")
    private SelenideElement passwordField;

    //Кнопка зарегистрироваться
    @FindBy(xpath = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registrationButton;

    //Кнопка войти
    @FindBy(xpath = "//*[text()='Войти']")
    private SelenideElement loginButton;

    //Ошибка пароля
    @FindBy(xpath = ".//*[@class='input__error text_type_main-default']")
    private SelenideElement errorMessage;

    //Методы для регистрации
    public void setName(String name) {
        this.nameField.setValue(name);
    }

    public void setEmail(String email) {
        this.emailField.setValue(email);
    }

    public void setPassword(String password) {
        this.passwordField.setValue(password);
    }

    public void clickRegistrationButton() {
        registrationButton.scrollTo();
        registrationButton.click();
    }

    public void registration(String name, String password, String email) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegistrationButton();
    }

    public LoginPage clickLoginButton() {
        loginButton.scrollTo();
        loginButton.click();
        return page(LoginPage.class);
    }

    public void checkErrorMessage(String text) {
        errorMessage.shouldHave(exactText(text));
    }

}
