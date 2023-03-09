package org.diplom3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage extends BasePage {
    private final WebDriver driver;

    public ResetPasswordPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Ссылка Войти
    private final By loginLink = By.xpath(".//a[text()='Войти']");

    public void pressLoginLink() {
        driver.findElement(loginLink).click();
    }
}
