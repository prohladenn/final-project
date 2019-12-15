package polis.mail.ru;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import polis.mail.ru.page.FollowersPage;
import polis.mail.ru.page.OverviewPage;
import polis.mail.ru.page.RepositoriesPage;

public abstract class AbstractTest {

    private WebDriver driver;
    private Atlas atlas;

    @Before
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        atlas = new Atlas(new WebDriverConfiguration(driver));
        driver.get("https://github.com/prohladenn");
    }

    @After
    public void stopDriver() {
        this.driver.quit();
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

    OverviewPage onMainPage() {
        return onPage(OverviewPage.class);
    }

    RepositoriesPage onRepositoryPage() {
        return onPage(RepositoriesPage.class);
    }

    FollowersPage onFollowersPage() {
        return onPage(FollowersPage.class);
    }
}
