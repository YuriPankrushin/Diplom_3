package org.diplom3.yandexbrowser;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.diplom3.model.User;
import org.diplom3.pages.AccountPage;
import org.diplom3.pages.LoginPage;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.Random;

public class LogoutTest extends BaseTest {

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
    @DisplayName("Выход из аккаунта")
    @Description("Проверить выход по кнопке «Выйти» в личном кабинете")
    public void logoutButtonClickShouldRemoveUserAuthorization() {
        //Открываем личный кабинет авторизованного пользователя
        AccountPage accountPage = new AccountPage(driver);
        accountPage.openAccountPage(user);

        //Нажать кнопку Выход
        accountPage.pressLogoutButton();

        //Проверить, что отображилась страница Вход
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageFields();
    }
}