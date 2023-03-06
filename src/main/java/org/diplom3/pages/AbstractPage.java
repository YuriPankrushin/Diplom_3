package org.diplom3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    private final WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    //Основное лого
    private final By stellarBurgerLogo = By.xpath(".//div[contains(@class, 'AppHeader')]");

    //Кнопка Конструктор
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    //Кнопка Личный Кабинет
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");

    //Ссылка Войти (располагается на страницах регистрации и сброса пароля)
    private final By loginLink = By.xpath(".//a[text()='Войти']");

    //Поле Имя
    private final By nameField = By.xpath(".//div[.//label[text()='Имя']][contains(@class, 'text')]/input");

    //Поле Email
    private final By emailField = By.xpath(".//div[.//label[text()='Email']][contains(@class, 'text')]/input");

    //Поле Пароль
    private final By passwordField = By.xpath(".//div[contains(@class, 'password')]/input");

    public void pressAccountButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(accountButton));
        driver.findElement(accountButton).click();
    }

    public void pressConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void pressLogoButton() {
        driver.findElement(stellarBurgerLogo).click();
    }

    public void pressLoginLink() {
        driver.findElement(loginLink).click();
    }

    //Проверить видимость поля Имя
    public void observeNameField() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(nameField));
    }

    //Проверить видимость поля Email
    public void observeEmailField() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(emailField));
    }

    //Проверить видимость поля Пароль
    public void observePasswordField() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(passwordField));
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
    public void setPassword(String password) {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }
}