package polis.mail.ru.page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import polis.mail.ru.element.RepositoryCard;
import polis.mail.ru.element.SelectList;
import polis.mail.ru.layout.WithFooter;
import polis.mail.ru.layout.WithHeader;
import polis.mail.ru.layout.WithProfileNavigation;

public interface RepositoriesPage extends WebPage, WithHeader, WithProfileNavigation, WithFooter {

    @FindBy("//input[@type='search']")
    AtlasWebElement inputSearch();

    @FindBy("//details[@id='type-options']")
    SelectList selectListType();

    @FindBy("//details[@id='language-options']")
    SelectList selectListLanguage();

    @FindBy("//ul[@data-filterable-for='your-repos-filter']//li")
    ElementsCollection<RepositoryCard> listRepositories();

    @FindBy("//div[contains(@class,'results')]")
    AtlasWebElement resultsText();

    @FindBy("//a[contains(.,'Clear filter')]")
    AtlasWebElement buttonClearFilter();

    @FindBy("//div[contains(@class,'blankslate')]")
    AtlasWebElement blankslateText();
}
