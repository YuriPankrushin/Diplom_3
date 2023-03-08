package org.diplom3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

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

    public void setNewUserCorrectData(){
        //Проверить правильный заголовок страницы
        checkRegistrationHeader();
        //Ввести данные для регистрации: имя, email, пароль (с использованием случайных чисел)
        Random random = new Random();
        setName("user" + random.nextInt(10000000));
        setEmail("box" + random.nextInt(10000000) + "@yandex.ru");
        setPassword("password");
    }

    public void setNewUserDataWithShortPassword(){
        //Проверить правильный заголовок страницы
        checkRegistrationHeader();
        //Ввести данные для регистрации: имя, email, пароль (с использованием случайных чисел)
        Random random = new Random();
        setName("user" + random.nextInt(10000000));
        setEmail("box" + random.nextInt(10000000) + "@yandex.ru");
        setPassword("short");
    }
}
