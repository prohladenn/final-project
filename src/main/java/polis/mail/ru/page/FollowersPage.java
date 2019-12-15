package polis.mail.ru.page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface FollowersPage extends WebPage {

    @FindBy("//div[contains(@class,'py-4')]")
    ElementsCollection<AtlasWebElement> listUsers();
}
