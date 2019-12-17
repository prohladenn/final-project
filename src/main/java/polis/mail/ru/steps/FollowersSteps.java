package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;
import polis.mail.ru.page.FollowersPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static polis.mail.ru.Utils.toListString;
import static polis.mail.ru.constant.NavigationItem.Followers;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class FollowersSteps extends AbstractSteps {

    private FollowersPage page;

    public FollowersSteps(Atlas atlas, WebDriver driver) {
        this.driver = driver;
        this.atlas = atlas;
        this.page = atlas.create(driver, FollowersPage.class);
    }

    @Step("Wait page is loaded")
    public FollowersSteps waitPageIsLoaded() {
        page.footer().waitUntil(displayed());
        page.userProfileNavigation(Followers).waitUntil(displayed());
        page.header().waitUntil(displayed());
        return this;
    }

    @Step("Check folder list is equal to `{users}`")
    public FollowersSteps checkFollowersList(List<String> users) {
        assertThat(toListString(page.listUsers()), equalTo(users));
        return this;
    }

}
