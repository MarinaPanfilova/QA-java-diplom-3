package tests;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.ProfilePage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static pageObjects.MainPage.URL;

public class ProfileTest {

    //Тесты только для браузера гугл хром, т.к. яндекс браузер на маке с М1 не открывается (перепробовано всё)
    private UserOperations userOperations;

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @After
    public void tearDown() {
        userOperations.delete();
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Checking logout user")
    public void checkLogoutUserTest() {
        Map<String, String> credentials = userOperations.register();
        MainPage mainPage = open(URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLoginButton();
        loginPage.login(credentials.get("email"), credentials.get("password"));
        ProfilePage profilePage = mainPage.clickProfileButton();
        profilePage.clickLogoutButton();
        loginPage.checkLoginPage();
    }

    @Test
    @DisplayName("Checking user can go to main page by click constructor button")
    public void checkGoToMainPageByConstructorButtonTest() {
        Map<String, String> credentials = userOperations.register();
        MainPage mainPage = open(URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLoginButton();
        loginPage.login(credentials.get("email"), credentials.get("password"));
        ProfilePage profilePage = mainPage.clickProfileButton();
        profilePage.clickConstructorButton();
        mainPage.createOrderButton();
    }

    @Test
    @DisplayName("Checking user can go to main page by click on the logo")
    public void checkGoToMainPageByLogoTest() {
        Map<String, String> credentials = userOperations.register();
        MainPage mainPage = open(URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLoginButton();
        loginPage.login(credentials.get("email"), credentials.get("password"));
        ProfilePage profilePage = mainPage.clickProfileButton();
        profilePage.clickLogo();
        mainPage.createOrderButton();
    }

}
