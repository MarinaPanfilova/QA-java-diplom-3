package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    //Кнопка зарегистрироваться
    @FindBy(xpath = "//*[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrationButton;

    //Вход после регистрации
    @FindBy(xpath = ".//*[@class='Auth_login__3hAey']")
    private SelenideElement loginPage;

    //Поле email
    @FindBy(xpath =  "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement email;

    //Поле пароль
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement password;

    //Кнопка войти
    @FindBy(xpath = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    //Кнопка восстановить пароль
    @FindBy(xpath = "//*[text()='Восстановить пароль']")
    private SelenideElement recoveryPasswordButton;

    //Методы для авторизации
    public RegistrationPage clickRegistrationButton() {
        registrationButton.scrollTo();
        registrationButton.click();
        return page(RegistrationPage.class);
    }

    public RegistrationPage checkLoginPage() {
        loginPage.scrollTo();
        return page(RegistrationPage.class);
    }

    public void setEmail(String email) {
        this.email.setValue(email);
    }

    public void setPassword(String password) {
        this.password.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.scrollTo();
        loginButton.click();
    }

    public PasswordRecoveryPage clickPasswordRecoveryButton() {
        recoveryPasswordButton.scrollTo();
        recoveryPasswordButton.click();
        return page(PasswordRecoveryPage.class);
    }

    public void login( String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

}
