package org.diplom3.pages;

import org.diplom3.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Заголовок Вход
    private final By loginHeader = By.xpath(".//h2[text()='Вход']");

    //Поле Email
    private final By emailField = By.xpath(".//div[.//label[text()='Email']][contains(@class, 'text')]/input");

    //Поле Пароль
    private final By passwordField = By.xpath(".//div[contains(@class, 'password')]/input");

    //Кнопка Войти
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    //Ссылка на регистрацию
    private final By registrationLink = By.xpath(".//a[text()='Зарегистрироваться']");

    //Ссылка на восстановление пароля
    private final By resetPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public void checkLoginHeader(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginHeader));
    }

    //Проверить видимость поля Email
    public void checkEmailField() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(emailField));
    }

    //Проверить видимость поля Пароль
    public void checkPasswordField() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(passwordField));
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

    //Нажать кнопку Войти
    public void pressLoginButton() {
        driver.findElement(loginButton).click();
    }

    //Нажать по ссылке на регистрацию
    public void pressRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    //Нажать по ссылке на восстановление паролья
    public void pressPasswordResetLink() {
        driver.findElement(resetPasswordLink).click();
    }


    public void goToRegistrationPage() {
        BasePage basePage = new BasePage(driver);
        pressTabButton(basePage.getAccountButton());
        checkLoginHeader();
        pressRegistrationLink();
    }

    public void goToResetPasswordPage() {
        BasePage basePage = new BasePage(driver);
        pressTabButton(basePage.getAccountButton());
        checkLoginHeader();
        pressPasswordResetLink();
    }

    public void verifyLoginPageFields() {
        checkLoginHeader();
        checkEmailField();
        checkPasswordField();
    }

    public void loginWith(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        pressLoginButton();
    }
}