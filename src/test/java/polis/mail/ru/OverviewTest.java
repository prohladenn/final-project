package polis.mail.ru;

import org.junit.Test;
import polis.mail.ru.constant.Users;

public class OverviewTest extends AbstractTest {

    @Test
    public void checkUserInfo() {
        navigationSteps
                .openOverviewPage()
                .waitPageIsLoaded()
                .checkUserName(Users.prohladenn.getName())
                .checkUserNickname(Users.prohladenn.toString());
    }
}
