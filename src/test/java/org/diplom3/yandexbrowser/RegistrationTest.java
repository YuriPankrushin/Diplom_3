package org.diplom3.yandexbrowser;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.diplom3.model.User;
import org.diplom3.pages.LoginPage;
import org.diplom3.pages.RegistrationPage;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.Random;

public class RegistrationTest extends BaseTest {

    /** Тестовые данные */
    //Данные пользователя
    static Random random = new Random();
    static User userValid = new User("box" + random.nextInt(10000000) + "@yandex.ru", "password", "user" + random.nextInt(10000000));
    static User userInvalidPassword = new User("box" + random.nextInt(10000000) + "@yandex.ru", "pass", "user" + random.nextInt(10000000));

    @AfterClass
    public static void testDataClear(){
        /** Удаление тестовых данных */
        //Удаление пользователя
        try {
            userApi.userDelete(userApi.getUserAccessToken(userApi.userLogin(userValid)));
        } catch (NullPointerException e) {
            System.out.println("Некорректное поведение: пользователь должен был быть создан, а затем удалиться. Необходимо проверить входные данные для теста.");
        }
        try {
            userApi.userDelete(userApi.getUserAccessToken(userApi.userLogin(userInvalidPassword)));
        } catch (NullPointerException e) {
            System.out.println("Корректное поведение: пользователь не был создан, удалять нечего.");
        }
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверить, что пользователь может успешно зарегистрироваться на сайте, указав корректные имя, email и пароль")
    public void registerNewUserWithCorrectNameEmailPassword() {
        //Осуществить переход на страницу регистрации
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegistrationPage();
        //Открывается страница Регистрации
        RegistrationPage registrationPage = new RegistrationPage(driver);
        //Ввести данные для регистрации: имя, email, пароль (с использованием случайных чисел)
        registrationPage.setNewUserData(userValid);
        //Нажать на кнопку Зарегистрироваться
        registrationPage.pressRegistrationButton();
        //Снова открывается страница Входа. Проверяем наличие атрибутов страницы: заголовок, поле ввода Email, поле ввода пароля
        loginPage.verifyLoginPageFields();
    }

    @Test
    @DisplayName("Регистрация с паролем менее 6 символов")
    @Description("Проверить, что пользователь не может зарегистрироваться на сайте, указав пароль из менее 6 символов")
    public void registerNewUserWithPasswordLessThenSixSymbols() {
        //Осуществить переход на страницу регистрации
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegistrationPage();
        //Открывается страница Регистрации
        RegistrationPage registrationPage = new RegistrationPage(driver);
        //Ввести данные для регистрации: имя, email, пароль менее 6 символов (с использованием случайных чисел)
        registrationPage.setNewUserData(userInvalidPassword);
        //Нажать на кнопку Зарегистрироваться
        registrationPage.pressRegistrationButton();
        //Проверить валидацию пароля
        registrationPage.checkPasswordValidationAppeared();
    }
}