package org.diplom3.pages;

import org.diplom3.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Заголовок Регистрация
    private final By registrationHeader = By.xpath(".//h2[text()='Регистрация']");

    //Кнопка Зарегистрироваться
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");

    //Валидация пароля
    private final By passwordValidationError = By.xpath(".//p[text()='Некорректный пароль']");

    //Поле Имя
    private final By nameField = By.xpath(".//div[.//label[text()='Имя']][contains(@class, 'text')]/input");

    //Поле Email
    private final By emailField = By.xpath(".//div[.//label[text()='Email']][contains(@class, 'text')]/input");

    //Поле Пароль
    private final By passwordField = By.xpath(".//div[contains(@class, 'password')]/input");

    //Ссылка Войти
    private final By loginLink = By.xpath(".//a[text()='Войти']");

    public void checkRegistrationHeader(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(registrationHeader));
    }

    //Нажать кнопку Зарегистрироваться
    public void pressRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void checkPasswordValidationAppeared(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(passwordValidationError));
    }

    public void pressLoginLink() {
        driver.findElement(loginLink).click();
    }

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

    public void setNewUserData(User user){
        //Проверить правильный заголовок страницы
        checkRegistrationHeader();
        //Ввести данные для регистрации: имя, email, пароль (с использованием случайных чисел)
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
    }
}
