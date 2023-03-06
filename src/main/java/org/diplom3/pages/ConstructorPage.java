package org.diplom3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage extends AbstractPage {
    public final WebDriver driver;

    public ConstructorPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Кнопка Войти в аккаунт
    private final By loginToAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    //Нажать кнопку Войти в аккаунт
    public void pressLoginButton() {
        driver.findElement(loginToAccountButton).click();
    }
}
