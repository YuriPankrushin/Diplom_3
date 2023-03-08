package org.diplom3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.diplom3.pages.ConstructorPage;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверить выход по кнопке «Выйти» в личном кабинете")
    public void logoutButtonClickShouldRemoveUserAuthorization() {
        //Проверить страницу конструктора
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.checkMainHeader();
        constructorPage.checkBurgerConstructorBasket();

        //Проверить, что текущая вкладка является активной
        Assert.assertTrue(constructorPage.returnIsCurrentFlag("Булки").contains("current"));
        //Нажать на вкладку ингридиентов: Соусы
        constructorPage.clickOnIngredientTab("Соусы");
        //Проверить, что выбранная вкладка является активной
        Assert.assertTrue(constructorPage.returnIsCurrentFlag("Соусы").contains("current"));
        //Нажать на вкладку ингридиентов: Начинки
        constructorPage.clickOnIngredientTab("Начинки");
        //Проверить, что выбранная вкладка является активной
        Assert.assertTrue(constructorPage.returnIsCurrentFlag("Начинки").contains("current"));
    }
}
