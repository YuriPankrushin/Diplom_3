package org.diplom3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.diplom3.pages.ConstructorPage;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода по вкладкам ингридиентов")
    @Description("Проверить переход по вкладкам ингридиентов: возможе клик по неактивной табе; выбранная вкладка становится активной ")
    public void checkThatClickOnTabNamePlacesFocusOnIt() {
        //Проверить страницу конструктора
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.checkMainHeader();
        constructorPage.checkBurgerConstructorBasket();

        //Проверить, что текущая вкладка является активной
        Assert.assertTrue(constructorPage.returnClassNameOfTheIngredientTabElement("Булки").contains("current"));
        //Нажать на вкладку ингридиентов: Соусы
        constructorPage.clickOnIngredientTab("Соусы");
        //Проверить, что выбранная вкладка является активной
        Assert.assertTrue(constructorPage.returnClassNameOfTheIngredientTabElement("Соусы").contains("current"));
        //Нажать на вкладку ингридиентов: Начинки
        constructorPage.clickOnIngredientTab("Начинки");
        //Проверить, что выбранная вкладка является активной
        Assert.assertTrue(constructorPage.returnClassNameOfTheIngredientTabElement("Начинки").contains("current"));
    }
}
