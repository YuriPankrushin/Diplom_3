package org.diplom3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Основное лого
    private final By stellarBurgerLogo = By.xpath(".//div[contains(@class, 'AppHeader')]");

    //Кнопка Конструктор
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    //Кнопка Личный Кабинет
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");

    public void pressTabButton(By tab) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(tab));
        driver.findElement(tab).click();
    }

    public By getStellarBurgerLogo() {
        return stellarBurgerLogo;
    }

    public By getConstructorButton() {
        return constructorButton;
    }

    public By getAccountButton() {
        return accountButton;
    }
}