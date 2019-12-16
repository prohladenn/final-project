package polis.mail.ru.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import polis.mail.ru.constant.Language;
import polis.mail.ru.constant.Type;
import polis.mail.ru.page.RepositoriesPage;

import static org.hamcrest.Matchers.*;
import static polis.mail.ru.constant.NavigationItem.Repositories;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class RepositoriesSteps extends AbstractSteps {

    private static final String EMPTY_RESULT = "doesn’t have any repositories that match";

    public RepositoriesSteps(Atlas atlas, WebDriver driver) {
        this.driver = driver;
        this.atlas = atlas;
    }

    @Override
    protected RepositoriesPage onPage() {
        return atlas.create(driver, RepositoriesPage.class);
    }

    @Step("Wait page is loaded")
    public RepositoriesSteps waitPageIsLoaded() {
        onPage().footer().waitUntil(displayed());
        onPage().userProfileNavigation(Repositories).waitUntil(displayed());
        onPage().header().waitUntil(displayed());
        return this;
    }

    @Step("Wait search result is loaded")
    public RepositoriesSteps waitSearchResult() {
        onPage().resultsText().waitUntil(displayed());
        return this;
    }

    @Step("Check select list `Type` equals to `{Type.values}`")
    public RepositoriesSteps checkSelectListType() {
        onPage().selectListType().itemList()
                .waitUntil(allOf(iterableWithSize(Type.values().length), everyItem(displayed())))
                .extract(WebElement::getText)
                .should(equalTo(Type.types()));
        return this;
    }

    @Step("Check select list `Language` equals to `{Language.languages}`")
    public RepositoriesSteps checkSelectListLanguage() {
        onPage().selectListLanguage().itemList()
                .waitUntil(allOf(iterableWithSize(Language.languages().size()), everyItem(displayed())))
                .extract(WebElement::getText)
                .should(equalTo(Language.languages()));
        return this;
    }

    @Step("Click button `Type`")
    public RepositoriesSteps clickButtonType() {
        onPage().selectListType().waitUntil(displayed()).click();
        return this;
    }

    @Step("Click button `Language`")
    public RepositoriesSteps clickButtonLanguage() {
        onPage().selectListLanguage().waitUntil(displayed()).click();
        return this;
    }

    @Step("Click button `Clear filter`")
    public RepositoriesSteps clickButtonClearFilter() {
        onPage().buttonClearFilter().waitUntil(displayed()).click();
        return this;
    }

    @Step("Input text `{text}` in search")
    public RepositoriesSteps searchByText(String text) {
        onPage().inputSearch().waitUntil(displayed()).sendKeys(text + Keys.ENTER);
        return this;
    }

    @Step("Check repository list has size")
    public RepositoriesSteps checkRepositorySize(int size) {
        onPage().listRepositories().waitUntil(displayed()).should(hasSize(size));
        return this;
    }

    @Step("Check repository is empty and text `{EMPTY_RESULT}` is displayed")
    public RepositoriesSteps checkRepositoryIsEmpty() {
        onPage().listRepositories().waitUntil(displayed()).should(hasSize(0));
        onPage().blankslateText().should(allOf(displayed(), containsString(EMPTY_RESULT)));
        return this;
    }
}
