package org.diplom3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.diplom3.pages.BasePage;
import org.diplom3.pages.AccountPage;
import org.diplom3.pages.ConstructorPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static org.diplom3.pages.BasePage.constructorButton;
import static org.diplom3.pages.BasePage.stellarBurgerLogo;
import static org.diplom3.utils.Constants.LOGIN;
import static org.diplom3.utils.Constants.PASSWORD;

@RunWith(Parameterized.class)
public class HeaderTabsTest extends BaseTest {

    private final By headerButton;

    public HeaderTabsTest(By headerButton) {
        this.headerButton = headerButton;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {constructorButton},
                {stellarBurgerLogo},
        };
    }

    @Test
    @DisplayName("Переход из личного кабинета по табам хедера страницы")
    @Description("Проверить переход по клику на «Конструктор» и на логотип Stellar Burgers")
    public void clickConstructorButtonFromAccountPage() {
        //Открываем личный кабинет авторизованного пользователя
        AccountPage accountPage = new AccountPage(driver);
        accountPage.openAccountPage(LOGIN, PASSWORD);

        //Нажимаем необходимую кнопку
        BasePage abstractPage = new BasePage(driver);
        abstractPage.pressTabButton(headerButton);

        //Попадаем на главный экран
        ConstructorPage constructorPage = new ConstructorPage(driver);
        //Проверяем наличие заголовка, корзины конструктора и кнопки Оформить заказ
        constructorPage.observeMainHeader();
        constructorPage.observeBurgerConstructorBasket();
        constructorPage.observeMakeOrderButton();
    }
}