package org.diplom3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbstractPage {

    private final WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    //Основное лого
    private final By stellarBurgerLogo = By.xpath(".//div[contains(@class, 'AppHeader')]");

    //Кнопка Конструктор
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    //Кнопка Лента Заказов
    private final By lentaButton = By.xpath(".//p[text()='Лента Заказов']");

    //Кнопка Личный Кабинет
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");

    private final By loginLink = By.xpath(".//a[text()='Войти']");

    //Поле Имя
    private final By nameField = By.xpath(".//div[.//label[text()='Имя']][contains(@class, 'text')]/input");

    //Поле Email
    private final By emailField = By.xpath(".//div[.//label[text()='Email']][contains(@class, 'text')]/input");

    //Поле Пароль
    private final By passwordField = By.xpath(".//div[contains(@class, 'password')]/input");

    //Кнопка Войти
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    public void pressAccountButton() {
        driver.findElement(accountButton).click();
    }

    public void pressLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void pressConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void pressLentaButton() {
        driver.findElement(lentaButton).click();
    }

    public void pressLogoButton() {
        driver.findElement(stellarBurgerLogo).click();
    }

    //Ввести Имя
    public void setName(String name) {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }

    //Ввести Email
    public void setEmail(String email) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
    }

    //Ввести Пароль
    public void pressLogoButton(String password) {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }
}