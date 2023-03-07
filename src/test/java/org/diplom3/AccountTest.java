package org.diplom3;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.diplom3.pages.AbstractPage;
import org.diplom3.pages.AccountPage;
import org.diplom3.pages.ConstructorPage;
import org.diplom3.pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.diplom3.utils.Constants.BASE_URL;
import static org.diplom3.utils.Constants.LOGIN;
import static org.diplom3.utils.Constants.PASSWORD;

public class AccountTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Открываем веб сайт
        driver.get(BASE_URL);
    }

    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    @Description("Проверь, что авторизованный пользовать попадет в личный кабинет при нажатии одноименной кнопки")
    public void accessToAccountTest() {
        //Нажимаем на кнопку Личный кабинет
        AbstractPage abstractPage = new AbstractPage(driver);
        abstractPage.pressAccountButton();
        //Авторизуем пользователя
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith(LOGIN, PASSWORD);

        //Для проверки авторизации, проверяем появление кнопки Оформить заказ
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.observeMakeOrderButton();

        //Переходим в личный кабинет
        constructorPage.pressAccountButton();

        // Проверяем, что попали в личный кабинет
        AccountPage accountPage = new AccountPage(driver);
        accountPage.observeNotificationText();
        Assert.assertEquals("Имя должно совпадать с имененм при регистрации пользователя", "Юрий", accountPage.getValueFromField("Имя"));
        Assert.assertEquals("Имя должно совпадать с имененм при регистрации пользователя", "pankrushinyuri@mail.ru", accountPage.getValueFromField("Логин"));
        Assert.assertEquals("Имя должно совпадать с имененм при регистрации пользователя", "*****", accountPage.getValueFromField("Пароль"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
