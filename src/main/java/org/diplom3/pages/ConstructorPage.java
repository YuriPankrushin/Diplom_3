package org.diplom3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorPage extends BasePage {
    public final WebDriver driver;

    public ConstructorPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Кнопка Войти в аккаунт
    private final By loginToAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    //Кнопка Оформить заказ
    private final By makeOrder = By.xpath(".//button[text()='Оформить заказ']");

    //Заголовок Соберите бургер
    private final By mainHeader = By.xpath(".//h1[text()='Соберите бургер']");

    //Корзина для ингридиентов
    private final By burgerConstructorBasket = By.xpath(".//ul[contains(@class, 'basket')]");

    //Нажать кнопку Войти в аккаунт
    public void pressLoginToAccountButton() {
        driver.findElement(loginToAccountButton).click();
    }

    //Проверить наличие кнопки Оформить заказ
    public void observeMakeOrderButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(makeOrder));
    }

    //Проверить наличие заголовка
    public void observeMainHeader() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(mainHeader));
    }

    //Проверить наличие корзины для ингридиентов
    public void observeBurgerConstructorBasket() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(burgerConstructorBasket));
    }

    //Нажать на вкладку ингридиентов
    public void clickOnIngredientTab(String ingredientTabName) {
        driver.findElement(By.xpath(String.format(".//div[./span[text()='%s']]", ingredientTabName))).click();
    }

    //Вернуть класс вкладки ингридиентов, для проверки активности
    public String returnIsCurrentFlag(String ingredientTabName) {
        return driver.findElement(By.xpath(String.format(".//div[./span[text()='%s']]", ingredientTabName))).getAttribute("class");
    }
}
