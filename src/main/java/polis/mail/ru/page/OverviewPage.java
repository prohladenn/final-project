package polis.mail.ru.page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import polis.mail.ru.layout.WithFooter;
import polis.mail.ru.layout.WithHeader;
import polis.mail.ru.layout.WithProfileNavigation;

public interface OverviewPage extends WebPage, WithHeader, WithProfileNavigation, WithFooter {

    @FindBy("//span[contains(@class,'p-name')]")
    public AtlasWebElement name();

    @FindBy("//span[contains(@class,'p-nickname')]")
    public AtlasWebElement nickname();
}
