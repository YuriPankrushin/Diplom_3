package org.diplom3.googlechrome;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.diplom3.model.User;
import org.diplom3.pages.BasePage;
import org.diplom3.pages.AccountPage;
import org.diplom3.pages.ConstructorPage;
import org.diplom3.pages.LoginPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;


public class AccountTest extends BaseTest {

    /** Тестовые данные */
    //Данные пользователя
    static Random random = new Random();
    static User user = new User("box" + random.nextInt(10000000) + "@yandex.ru", "password", "user" + random.nextInt(10000000));
    //Регистрируем пользователя
    static Response userRegisteredData = userApi.userRegister(user);

    @AfterClass
    public static void testDataClear(){
        /** Удаление тестовых данных */
        //Удаление пользователя
        try {
            userApi.userDelete(userApi.getUserAccessToken(userApi.userLogin(user)));
        } catch (NullPointerException e) {
            System.out.println("Некорректное поведение: пользователь должен был быть создан, а затем удалиться. Необходимо проверить входные данные для теста.");
        }
    }

    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    @Description("Проверь, что авторизованный пользовать попадет в личный кабинет при нажатии одноименной кнопки")
    public void accessToAccountTest() {
        //Нажимаем на кнопку Личный кабинет
        BasePage basePage = new BasePage(driver);
        basePage.pressTabButton(basePage.getAccountButton());
        //Авторизуем пользователя
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith(user);

        //Для проверки авторизации, проверяем появление кнопки Оформить заказ
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.checkMakeOrderButton();

        //Переходим в личный кабинет
        constructorPage.pressTabButton(basePage.getAccountButton());

        // Проверяем, что попали в личный кабинет
        AccountPage accountPage = new AccountPage(driver);
        accountPage.checkNotificationText();
        Assert.assertEquals("Имя должно совпадать с имененм при регистрации пользователя", user.getName(), accountPage.getValueFromField("Имя"));
        Assert.assertEquals("Email должен совпадать с email при регистрации пользователя", user.getEmail(), accountPage.getValueFromField("Логин"));
        Assert.assertEquals("Пароль должен быть скрыт пятью звездочками", "*****", accountPage.getValueFromField("Пароль"));
    }
}