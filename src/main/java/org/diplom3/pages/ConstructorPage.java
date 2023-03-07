package org.diplom3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorPage extends AbstractPage {
    public final WebDriver driver;

    public ConstructorPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Кнопка Войти в аккаунт
    private final By loginToAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By makeOrder = By.xpath(".//button[text()='Оформить заказ']");

    //Нажать кнопку Войти в аккаунт
    public void pressLoginToAccountButton() {
        driver.findElement(loginToAccountButton).click();
    }

    public void observeMakeOrderButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(makeOrder));
    }
}
