package org.diplom3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.diplom3.pages.AccountPage;
import org.diplom3.pages.LoginPage;
import org.junit.Test;

import static org.diplom3.utils.Constants.LOGIN;
import static org.diplom3.utils.Constants.PASSWORD;

public class LogoutTest extends AbstractTest {

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверить выход по кнопке «Выйти» в личном кабинете")
    public void logoutButtonClickShouldRemoveUserAuthorization() {
        //Открываем личный кабинет авторизованного пользователя
        AccountPage accountPage = new AccountPage(driver);
        accountPage.openAccountPage(LOGIN, PASSWORD);

        //Нажать кнопку Выход
        accountPage.pressLogoutButton();

        //Проверить, что отображилась страница Вход
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageFields();
    }
}