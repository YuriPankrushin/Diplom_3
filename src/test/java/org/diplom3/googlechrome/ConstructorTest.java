package org.diplom3.googlechrome;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.diplom3.pages.BasePage;
import org.diplom3.pages.ConstructorPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ConstructorTest extends BaseTest {

    private final String ingredientTabName;

    public ConstructorTest(String ingredientTabName) {
        this.ingredientTabName = ingredientTabName;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        BasePage basePage = new BasePage(driver);
        return new Object[][]{
                {"Булки"},
                {"Соусы"},
                {"Начинки"},
        };
    }

    @Test
    @DisplayName("Проверка перехода по вкладкам ингридиентов")
    @Description("Проверить переход по вкладкам ингридиентов: возможе клик по неактивной табе; выбранная вкладка становится активной ")
    public void checkThatClickOnTabNamePlacesFocusOnIt() {
        //Проверить страницу конструктора
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.checkMainHeader();
        constructorPage.checkBurgerConstructorBasket();

        if (constructorPage.returnClassNameOfTheIngredientTabElement(ingredientTabName).contains("current")) {
            //Проверить, что выбранная вкладка является активной
            Assert.assertTrue(constructorPage.returnClassNameOfTheIngredientTabElement(ingredientTabName).contains("current"));
        }
        else {
            //Нажать на неактивную вкладку
            constructorPage.clickOnIngredientTab(ingredientTabName);
            //Проверить, что выбранная вкладка является активной
            Assert.assertTrue(constructorPage.returnClassNameOfTheIngredientTabElement(ingredientTabName).contains("current"));
        }
    }
}
