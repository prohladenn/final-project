package polis.mail.ru.layout;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import polis.mail.ru.constant.NavigationItem;

public interface WithProfileNavigation {

    @FindBy("//div[contains(@class,'user-profile-nav')]//a[contains(text(),'{{ navigationItem }}')]")
    public AtlasWebElement userProfileNavigation(@Param("navigationItem") NavigationItem navigationItem);
}
