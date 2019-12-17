package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;
import polis.mail.ru.page.OverviewPage;

import static polis.mail.ru.constant.NavigationItem.Overview;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;
import static ru.yandex.qatools.matchers.webdriver.TextMatcher.text;

public class OverviewSteps extends AbstractSteps {

    private OverviewPage page;

    public OverviewSteps(Atlas atlas, WebDriver driver) {
        this.driver = driver;
        this.atlas = atlas;
        this.page = atlas.create(driver, OverviewPage.class);
    }

    @Step("Wait page is loaded")
    public OverviewSteps waitPageIsLoaded() {
        page.footer().waitUntil(displayed());
        page.userProfileNavigation(Overview).waitUntil(displayed());
        page.header().waitUntil(displayed());
        return this;
    }

    @Step("Check user name `{name}`")
    public OverviewSteps checkUserName(String name) {
        page.name().should(text(name));
        return this;
    }

    @Step("Check user nickname `{nickname}`")
    public OverviewSteps checkUserNickname(String nickname) {
        page.nickname().should(text(nickname));
        return this;
    }
}
