package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;
import polis.mail.ru.page.OverviewPage;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static polis.mail.ru.constant.NavigationItem.Overview;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class OverviewSteps extends AbstractSteps {

    public OverviewSteps(Atlas atlas, WebDriver driver) {
        this.driver = driver;
        this.atlas = atlas;
    }

    @Override
    protected OverviewPage onPage() {
        return atlas.create(driver, OverviewPage.class);
    }

    @Step("Wait page is loaded")
    public OverviewSteps waitPageIsLoaded() {
        onPage().footer().waitUntil(displayed());
        onPage().userProfileNavigation(Overview).waitUntil(displayed());
        onPage().header().waitUntil(displayed());
        return this;
    }

    @Step("Check user name `{name}`")
    public OverviewSteps checkUserName(String name) {
        onPage().name().should(allOf(displayed(), containsString(name)));
        return this;
    }

    @Step("Check user nickname `{nickname}`")
    public OverviewSteps checkUserNickname(String nickname) {
        onPage().name().should(allOf(displayed(), containsString(nickname)));
        return this;
    }
}
