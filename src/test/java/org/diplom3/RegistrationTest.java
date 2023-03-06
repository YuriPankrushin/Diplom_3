package org.diplom3;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.diplom3.pages.LoginPage;
import org.diplom3.pages.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.diplom3.utils.Constants.BASE_URL;


public class RegistrationTest extends AbstractTest {

    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Открываем веб сайт
        driver.get(BASE_URL);
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
        registrationPage.setNewUserCorrectData();
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
        registrationPage.setNewUserDataWithShortPassword();
        //Нажать на кнопку Зарегистрироваться
        registrationPage.pressRegistrationButton();
        //Проверить валидацию пароля
        registrationPage.observePasswordValidationAppeared();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}