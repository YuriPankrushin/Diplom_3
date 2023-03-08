package org.diplom3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.diplom3.api.UserApi;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.diplom3.utils.Constants.BASE_URL;

public class BaseTest {

    static UserApi userApi = new UserApi();

    static protected WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Открываем веб сайт
        driver.get(BASE_URL);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}