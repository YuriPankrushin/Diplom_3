package org.diplom3;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.diplom3.pages.AbstractPage;
import org.diplom3.pages.AccountPage;
import org.diplom3.pages.ConstructorPage;
import org.diplom3.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.diplom3.utils.Constants.BASE_URL;
import static org.diplom3.utils.Constants.LOGIN;
import static org.diplom3.utils.Constants.PASSWORD;

public class LoginTest extends AbstractTest {
    private WebDriver driver;


    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Открываем веб сайт
        driver.get(BASE_URL);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    @Description("Проверить, что пользователь может успешно авторизоваться на сайте, пройдя к форме входа по ккнопке «Войти в аккаунт» на главной странице")
    public void authThroughLoginToAccountButton() {
        //Нажимаем на кнопку Войти в аккаунт
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.pressLoginToAccountButton();

        //Попадаем на страницу входа
        LoginPage loginPage = new LoginPage(driver);
        //Вводим данные и нажмаем кнопку войти
        loginPage.loginWith(LOGIN, PASSWORD);

        //Для проверки авторизации, входим в личный кабинет
        constructorPage.pressAccountButton();

        // Проверяем, что попали в личный кабинет
        AccountPage accountPage = new AccountPage(driver);
        accountPage.observeNotificationText();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверить, что пользователь может успешно авторизоваться на сайте, пройдя к форме входа по ккнопке «Лчный кабинет»")
    public void authThroughAccountButton() {
        //Нажимаем на кнопку Войти в аккаунт
        AbstractPage abstractPage = new AbstractPage(driver);
        abstractPage.pressAccountButton();

        //Попадаем на страницу входа
        LoginPage loginPage = new LoginPage(driver);
        //Вводим данные и нажмаем кнопку войти
        loginPage.loginWith(LOGIN, PASSWORD);

        //Для проверки авторизации, входим в личный кабинет
        abstractPage.pressAccountButton();

        // Проверяем, что попали в личный кабинет
        AccountPage accountPage = new AccountPage(driver);
        accountPage.observeNotificationText();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверить, что пользователь может успешно авторизоваться на сайте, пройдя к форме входа через форму регистрации")
    public void authThroughRegistrationPage() {
        //Попадаем на форму регистрации через форму логина
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegistrationPage();

        //Нажимаем ссылку на Вход
        loginPage.pressLoginLink();

        //Вводим данные и нажмаем кнопку войти
        loginPage.loginWith(LOGIN, PASSWORD);

        //Для проверки авторизации, входим в личный кабинет
        AbstractPage abstractPage = new AbstractPage(driver);
        abstractPage.pressAccountButton();

        // Проверяем, что попали в личный кабинет
        AccountPage accountPage = new AccountPage(driver);
        accountPage.observeNotificationText();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверить, что пользователь может успешно авторизоваться на сайте, пройдя к форме входа через форму восстановления пароля")
    public void authThroughResetPasswordPage() {
        //Попадаем на форму восстановления пароля через форму логина
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToResetPasswordPage();

        //Нажимаем ссылку Восстановить пароль
        loginPage.pressLoginLink();

        //Вводим данные и нажмаем кнопку войти
        loginPage.loginWith(LOGIN, PASSWORD);

        //Для проверки авторизации, входим в личный кабинет
        AbstractPage abstractPage = new AbstractPage(driver);
        abstractPage.pressAccountButton();

        // Проверяем, что попали в личный кабинет
        AccountPage accountPage = new AccountPage(driver);
        accountPage.observeNotificationText();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}