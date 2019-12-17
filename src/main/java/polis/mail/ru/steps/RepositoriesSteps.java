package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import polis.mail.ru.constant.Language;
import polis.mail.ru.constant.Type;
import polis.mail.ru.page.RepositoriesPage;
import ru.yandex.qatools.matchers.webdriver.TextMatcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static polis.mail.ru.Utils.toListString;
import static polis.mail.ru.constant.NavigationItem.Repositories;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class RepositoriesSteps extends AbstractSteps {

    private static final String EMPTY_RESULT = "prohladenn doesn’t have any repositories that match.";

    private RepositoriesPage page;

    public RepositoriesSteps(Atlas atlas, WebDriver driver) {
        this.driver = driver;
        this.atlas = atlas;
        this.page = atlas.create(driver, RepositoriesPage.class);
    }

    @Step("Wait page is loaded")
    public RepositoriesSteps waitPageIsLoaded() {
        page.footer().waitUntil(displayed());
        page.userProfileNavigation(Repositories).waitUntil(displayed());
        page.header().waitUntil(displayed());
        return this;
    }

    @Step("Wait search result is loaded")
    public RepositoriesSteps waitSearchResult() {
        page.resultsText().waitUntil(displayed());
        return this;
    }

    @Step("Check select list `Type` equals to `{Type.values}`")
    public RepositoriesSteps checkSelectListType() {
        assertThat(toListString(page.selectListType().itemList()), equalTo(Type.types()));
        return this;
    }

    @Step("Check select list `Language` equals to `{Language.languages}`")
    public RepositoriesSteps checkSelectListLanguage() {
        assertThat(toListString(page.selectListLanguage().itemList()), equalTo(Language.languages()));
        return this;
    }

    @Step("Click button `Type`")
    public RepositoriesSteps clickButtonType() {
        page.selectListType().waitUntil(displayed()).click();
        return this;
    }

    @Step("Click button `Language`")
    public RepositoriesSteps clickButtonLanguage() {
        page.selectListLanguage().waitUntil(displayed()).click();
        return this;
    }

    @Step("Click button `Clear filter`")
    public RepositoriesSteps clickButtonClearFilter() {
        page.buttonClearFilter().waitUntil(displayed()).click();
        return this;
    }

    @Step("Input text `{text}` in search")
    public RepositoriesSteps searchByText(String text) {
        page.inputSearch().waitUntil(displayed()).sendKeys(text + Keys.ENTER);
        return this;
    }

    @Step("Check repository list has size")
    public RepositoriesSteps checkRepositorySize(int size) {
        assertThat(page.listRepositories(), hasSize(size));
        return this;
    }

    @Step("Check repository is empty and text `{EMPTY_RESULT}` is displayed")
    public RepositoriesSteps checkRepositoryIsEmpty() {
        assertThat(page.listRepositories(), hasSize(0));
        page.blankslateText().should(TextMatcher.text(EMPTY_RESULT));
        return this;
    }
}
