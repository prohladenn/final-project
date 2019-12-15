package polis.mail.ru.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface SelectList extends AtlasWebElement<SelectList> {

    @FindBy(".//label[@class='SelectMenu-item']")
    ElementsCollection<AtlasWebElement> itemList();

    @FindBy(".//label[@class='SelectMenu-item']//span[contains(text(),'{{ name }}')]")
    AtlasWebElement itemWithName(@Param("name") String name);
}
