package polis.mail.ru;

import org.junit.Test;
import polis.mail.ru.constant.Language;
import polis.mail.ru.constant.Type;

public class RepositoryTest extends AbstractTest {

    @Test
    public void checkTypesOfFilter() {
        navigationSteps
                .openRepositoryPage()
                .waitPageIsLoaded()
                .clickButtonType()
                .checkSelectListType();
    }

    @Test
    public void checkLanguagesOfFilter() {
        navigationSteps
                .openRepositoryPage()
                .waitPageIsLoaded()
                .clickButtonLanguage()
                .checkSelectListLanguage();
    }

    @Test
    public void checkFindRepositoryByName() {
        final String expectedTitle = "2019-highload-dht";

        navigationSteps
                .openRepositoryPage()
                .waitPageIsLoaded()
                .searchByText(expectedTitle)
                .waitSearchResult()
                .checkRepositorySize(1);
    }

    @Test
    public void checkClearFilter() {
        final int defaultRepoCount = 29;
        final int forkJavaRepoCount = 12;

        navigationSteps
                .openRepositoryPage("", Type.Forks, Language.JAVA)
                .waitPageIsLoaded()
                .checkRepositorySize(forkJavaRepoCount)
                .clickButtonClearFilter()
                .waitPageIsLoaded()
                .checkRepositorySize(defaultRepoCount);
    }

    @Test
    public void checkDoesNotHaveAnyRepositoriesThatMatch() {
        final String textForSearch = "Polis Mail Ru Forever";

        navigationSteps
                .openRepositoryPage(textForSearch, Type.All, Language.ALL)
                .waitPageIsLoaded()
                .checkRepositoryIsEmpty();
    }
}
