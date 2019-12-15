package polis.mail.ru.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface RepositoryCard extends AtlasWebElement<RepositoryCard> {

    @FindBy(".//*[@itemprop='name codeRepository']")
    AtlasWebElement title();

    @FindBy(".//*[@itemprop='programmingLanguage']")
    AtlasWebElement language();
}
