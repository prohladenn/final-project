package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;
import polis.mail.ru.constant.Language;
import polis.mail.ru.constant.Type;

import static java.lang.String.format;
import static polis.mail.ru.constant.NavigationItem.*;

public class NavigationSteps {

    private final static String BASE_URL = "https://github.com/prohladenn?tab=%s";
    private final static String REPOSITORY_SEARCH_URL = "&q=%s&type=%s&language=%s";

    private Atlas atlas;
    private WebDriver driver;

    public NavigationSteps(Atlas atlas, WebDriver driver) {
        this.atlas = atlas;
        this.driver = driver;
    }

    @Step("Open `Followers` page")
    public FollowersSteps openFollowersPage() {
        driver.get(format(BASE_URL, Followers.getItemName()));
        return new FollowersSteps(atlas, driver);
    }

    @Step("Open `Overview` page")
    public OverviewSteps openOverviewPage() {
        driver.get(format(BASE_URL, Overview.getItemName()));
        return new OverviewSteps(atlas, driver);
    }

    @Step("Open `Repositories` page")
    public RepositoriesSteps openRepositoryPage() {
        driver.get(format(BASE_URL, Repositories.getItemName()));
        return new RepositoriesSteps(atlas, driver);
    }

    @Step("Open `Repositories` page with param text `{text}`, type `{type}`, language `{language.name}`")
    public RepositoriesSteps openRepositoryPage(String text, Type type, Language language) {
        driver.get(format(BASE_URL + REPOSITORY_SEARCH_URL, Repositories.getItemName(), text, type.getName(), language));
        return new RepositoriesSteps(atlas, driver);
    }
}
