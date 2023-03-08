package org.diplom3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.diplom3.model.User;
import org.diplom3.pages.BasePage;
import org.diplom3.pages.AccountPage;
import org.diplom3.pages.ConstructorPage;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import java.util.Random;


@RunWith(Parameterized.class)
public class HeaderTabsTest extends BaseTest {

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

    private final By headerButton;

    public HeaderTabsTest(By headerButton) {
        this.headerButton = headerButton;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        BasePage basePage = new BasePage(driver);
        return new Object[][]{
                {basePage.getConstructorButton()},
                {basePage.getStellarBurgerLogo()},
        };
    }

    @Test
    @DisplayName("Переход из личного кабинета по табам хедера страницы")
    @Description("Проверить переход по клику на «Конструктор» и на логотип Stellar Burgers")
    public void clickConstructorButtonFromAccountPage() {
        //Открываем личный кабинет авторизованного пользователя
        AccountPage accountPage = new AccountPage(driver);
        accountPage.openAccountPage(user);

        //Нажимаем необходимую кнопку
        BasePage basePage = new BasePage(driver);
        basePage.pressTabButton(headerButton);

        //Попадаем на главный экран
        ConstructorPage constructorPage = new ConstructorPage(driver);
        //Проверяем наличие заголовка, корзины конструктора и кнопки Оформить заказ
        constructorPage.checkMainHeader();
        constructorPage.checkBurgerConstructorBasket();
        constructorPage.checkMakeOrderButton();
    }
}