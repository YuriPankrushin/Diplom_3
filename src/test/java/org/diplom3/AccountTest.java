package org.diplom3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.diplom3.pages.BasePage;
import org.diplom3.pages.AccountPage;
import org.diplom3.pages.ConstructorPage;
import org.diplom3.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

import static org.diplom3.utils.Constants.LOGIN;
import static org.diplom3.utils.Constants.PASSWORD;

public class AccountTest extends BaseTest {

    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    @Description("Проверь, что авторизованный пользовать попадет в личный кабинет при нажатии одноименной кнопки")
    public void accessToAccountTest() {
        //Нажимаем на кнопку Личный кабинет
        BasePage basePage = new BasePage(driver);
        basePage.pressTabButton(basePage.getAccountButton());
        //Авторизуем пользователя
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith(LOGIN, PASSWORD);

        //Для проверки авторизации, проверяем появление кнопки Оформить заказ
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.checkMakeOrderButton();

        //Переходим в личный кабинет
        constructorPage.pressTabButton(basePage.getAccountButton());

        // Проверяем, что попали в личный кабинет
        AccountPage accountPage = new AccountPage(driver);
        accountPage.checkNotificationText();
        Assert.assertEquals("Имя должно совпадать с имененм при регистрации пользователя", "Юрий", accountPage.getValueFromField("Имя"));
        Assert.assertEquals("Email должен совпадать с email при регистрации пользователя", "pankrushinyuri@mail.ru", accountPage.getValueFromField("Логин"));
        Assert.assertEquals("Пароль должен быть скрыт пятью звездочками", "*****", accountPage.getValueFromField("Пароль"));
    }
}