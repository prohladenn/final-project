package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import polis.mail.ru.page.FollowersPage;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static polis.mail.ru.constant.NavigationItem.Followers;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class FollowersSteps2 extends AbstractSteps {

    public FollowersSteps2(Atlas atlas, WebDriver driver) {
        this.driver = driver;
        this.atlas = atlas;
    }

    @Override
    protected FollowersPage onPage() {
        return atlas.create(driver, FollowersPage.class);
    }

    @Step("Wait page is loaded")
    public FollowersSteps2 waitPageIsLoaded() {
        onPage().footer().waitUntil(displayed());
        onPage().userProfileNavigation(Followers).waitUntil(displayed());
        onPage().header().waitUntil(displayed());
        return this;
    }

    @Step("Check folder list is equal to `{users}`")
    public FollowersSteps2 checkFollowersList(List<String> users) {
        onPage().listUsers()
                .waitUntil(allOf(iterableWithSize(users.size()), everyItem(displayed())))
                .extract(WebElement::getText)
                .should(equalTo(users));
        return this;
    }

}
