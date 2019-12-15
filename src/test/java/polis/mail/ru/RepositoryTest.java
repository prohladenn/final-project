package polis.mail.ru;

import io.qameta.atlas.webdriver.AtlasWebElement;
import org.junit.Test;
import org.openqa.selenium.Keys;
import polis.mail.ru.constant.Language;
import polis.mail.ru.constant.Type;
import polis.mail.ru.element.RepositoryCard;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static polis.mail.ru.constant.NavigationItem.Repositories;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class RepositoryTest extends AbstractTest {

    @Test
    public void checkTypesOfFilter() {
        onMainPage().userProfileNavigation(Repositories).waitUntil(displayed()).click();
        onRepositoryPage().selectListType().itemList()
                .should(hasSize(5));
        onRepositoryPage().selectListType()
                .waitUntil(displayed())
                .click();
        List<AtlasWebElement> listItems = onRepositoryPage().selectListType().itemList();
        for (AtlasWebElement item : listItems) {
            item.should(displayed());
            String itemName = item.getText();
            String reason = "Item  `" + itemName + "` not contains in " + Type.types();
            assertThat(reason, Type.types().contains(itemName));
        }
    }

    @Test
    public void checkLanguagesOfFilter() {
        onMainPage().userProfileNavigation(Repositories).waitUntil(displayed()).click();
        onRepositoryPage().selectListLanguage().itemList()
                .should(hasSize(8));
        onRepositoryPage().selectListLanguage()
                .waitUntil(displayed())
                .click();
        List<AtlasWebElement> listItems = onRepositoryPage().selectListLanguage().itemList();
        for (AtlasWebElement item : listItems) {
            item.should(displayed());
            String itemName = item.getText();
            String reason = "Item  `" + itemName + "` not contains in " + Type.types();
            assertThat(reason, Language.languages().contains(itemName));
        }
    }

    @Test
    public void checkFindRepositoryByName() {
        String expectedTitle = "2019-highload-dht";
        String expectedLanguage = Language.JAVA.getName();
        onMainPage().userProfileNavigation(Repositories).waitUntil(displayed()).click();
        onRepositoryPage().inputSearch()
                .waitUntil(displayed())
                .sendKeys(expectedTitle + Keys.ENTER);
        onRepositoryPage().resultsText().waitUntil(displayed());
        List<RepositoryCard> repositories = onRepositoryPage().listRepositories();
        assertThat(repositories, hasSize(1));
        assertThat(repositories.get(0).title().getText(), equalTo(expectedTitle));
        assertThat(repositories.get(0).language().getText(), equalTo(expectedLanguage));
    }

    @Test
    public void checkClearFilter() {
        final int defaultRepoCount = 29;
        final int forkRepoCount = 18;
        onMainPage().userProfileNavigation(Repositories).waitUntil(displayed()).click();
        onRepositoryPage().inputSearch().waitUntil(displayed());
        checkRepoCount(defaultRepoCount);
        onRepositoryPage().selectListType().click();
        onRepositoryPage().selectListType().itemWithName(Type.Forks.name()).click();
        onRepositoryPage().resultsText().waitUntil(displayed());
        checkRepoCount(forkRepoCount);
        onRepositoryPage().buttonClearFilter().click();
        onRepositoryPage().resultsText().waitUntil(not(displayed()));
        checkRepoCount(defaultRepoCount);
    }

    @Test
    public void checkDoesNotHaveAnyRepositoriesThatMatch() {
        final String emptyListText = "doesn’t have any repositories that match";
        onMainPage().userProfileNavigation(Repositories).waitUntil(displayed()).click();
        onRepositoryPage().inputSearch()
                .waitUntil(displayed())
                .sendKeys("Polis Mail Ru Forever" + Keys.ENTER);
        onRepositoryPage().resultsText().waitUntil(displayed());
        checkRepoCount(0);
        assertThat(onRepositoryPage().blankslateText().should(displayed()).getText(), containsString(emptyListText));
    }

    private void checkRepoCount(int repoCount) {
        List<RepositoryCard> repositories = onRepositoryPage().listRepositories();
        assertThat(repositories, hasSize(repoCount));
    }
}
