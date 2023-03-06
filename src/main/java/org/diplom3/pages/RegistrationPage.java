package org.diplom3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends AbstractPage {
    public final WebDriver driver;

    public RegistrationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Заголовок Регистрация
    private final By registrationHeader = By.xpath(".//h2[text()='Регистрация']");

    //Кнопка Зарегистрироваться
    private final By registrationButton = By.xpath(".//h2[text()='Вход']");

    public void observeRegistrationHeader(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(registrationHeader));
    }

    //Нажать кнопку Зарегистрироваться
    public void pressLoginButton() {
        driver.findElement(registrationButton).click();
    }
}
