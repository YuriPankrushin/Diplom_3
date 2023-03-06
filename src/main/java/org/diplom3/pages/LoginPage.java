package org.diplom3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    public final WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Заголовок Вход
    private final By loginHeader = By.xpath(".//h2[text()='Вход']");

    //Кнопка Войти
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    //Ссылка на регистрацию
    private final By registrationLink = By.xpath(".//a[text()='Зарегистрироваться']");

    //Ссылка на восстановление пароля
    private final By resetPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public void observeLoginHeader(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginHeader));
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
        pressAccountButton();
        observeLoginHeader();
        pressRegistrationLink();
    }

    public void goToResetPasswordPage() {
        pressAccountButton();
        observeLoginHeader();
        pressPasswordResetLink();
    }

    public void verifyLoginPageFields() {
        observeLoginHeader();
        observeEmailField();
        observePasswordField();
    }

    public void loginWith(String email, String password) {
        setEmail(email);
        setPassword(password);
        pressLoginButton();
    }
}