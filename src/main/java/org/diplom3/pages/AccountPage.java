package org.diplom3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends AbstractPage {

    public final WebDriver driver;

    public AccountPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Кнопка Войти в аккаунт
    private final By notificationText = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    //Кнопка Выход
    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    //Проверить видимость информационного текста
    public void observeNotificationText() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(notificationText));
    }

    public String getValueFromField(String fieldName) {
        By accountInputField = By.xpath(String.format(".//div[.//label[text()='%s']]/input", fieldName));
        return driver.findElement(accountInputField).getAttribute("value");
    }

    public void openAccountPage(String login, String password) {
        pressTabButton(accountButton);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith(login, password);
        pressTabButton(accountButton);
        observeNotificationText();
    }

    public void pressLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
