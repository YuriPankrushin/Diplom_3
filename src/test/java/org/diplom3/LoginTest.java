package org.diplom3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.diplom3.pages.BasePage;
import org.diplom3.pages.AccountPage;
import org.diplom3.pages.ConstructorPage;
import org.diplom3.pages.LoginPage;
import org.junit.Test;

import static org.diplom3.utils.Constants.LOGIN;
import static org.diplom3.utils.Constants.PASSWORD;

public class LoginTest extends BaseTest {

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
        BasePage basePage = new BasePage(driver);
        constructorPage.pressTabButton(basePage.getAccountButton());

        // Проверяем, что попали в личный кабинет
        AccountPage accountPage = new AccountPage(driver);
        accountPage.observeNotificationText();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверить, что пользователь может успешно авторизоваться на сайте, пройдя к форме входа по ккнопке «Лчный кабинет»")
    public void authThroughAccountButton() {
        //Нажимаем на кнопку Войти в аккаунт
        BasePage basePage = new BasePage(driver);
        basePage.pressTabButton(basePage.getAccountButton());

        //Попадаем на страницу входа
        LoginPage loginPage = new LoginPage(driver);
        //Вводим данные и нажмаем кнопку войти
        loginPage.loginWith(LOGIN, PASSWORD);

        //Для проверки авторизации, входим в личный кабинет
        basePage.pressTabButton(basePage.getAccountButton());

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
        BasePage basePage = new BasePage(driver);
        basePage.pressTabButton(basePage.getAccountButton());

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
        BasePage basePage = new BasePage(driver);
        basePage.pressTabButton(basePage.getAccountButton());

        // Проверяем, что попали в личный кабинет
        AccountPage accountPage = new AccountPage(driver);
        accountPage.observeNotificationText();
    }
}