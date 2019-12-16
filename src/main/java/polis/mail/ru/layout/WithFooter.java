package polis.mail.ru.layout;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithFooter {

    @FindBy("//div[contains(@class,'footer') and @role='contentinfo']")
    public AtlasWebElement footer();
}
