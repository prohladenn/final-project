package polis.mail.ru.page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import polis.mail.ru.layout.WithFooter;
import polis.mail.ru.layout.WithHeader;
import polis.mail.ru.layout.WithProfileNavigation;

public interface FollowersPage extends WebPage, WithHeader, WithProfileNavigation, WithFooter {

    @FindBy("//div[contains(@class,'py-4')]//div[contains(@class,'pr-3')]//span[contains(@class,'f4')]")
    ElementsCollection<AtlasWebElement> listUsers();
}
