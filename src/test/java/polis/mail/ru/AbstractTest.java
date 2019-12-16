package polis.mail.ru;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import polis.mail.ru.steps.NavigationSteps;

public abstract class AbstractTest {

    NavigationSteps navigationSteps;
    private WebDriver driver;

    @Before
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Atlas atlas = new Atlas(new WebDriverConfiguration(driver));
        navigationSteps = new NavigationSteps(atlas, driver);
    }

    @After
    public void stopDriver() {
        this.driver.quit();
    }
}
