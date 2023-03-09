package org.diplom3.pages;

import org.diplom3.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage {

    private final WebDriver driver;

    public AccountPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Кнопка Войти в аккаунт
    private final By notificationText = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    //Кнопка Выход
    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    //Проверить видимость информационного текста
    public void checkNotificationText() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(notificationText));
    }

    public String getValueFromField(String fieldName) {
        By accountInputField = By.xpath(String.format(".//div[.//label[text()='%s']]/input", fieldName));
        return driver.findElement(accountInputField).getAttribute("value");
    }

    public void openAccountPage(User user) {
        BasePage basePage = new BasePage(driver);
        pressTabButton(basePage.getAccountButton());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith(user);
        pressTabButton(basePage.getAccountButton());
        checkNotificationText();
    }

    public void pressLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}