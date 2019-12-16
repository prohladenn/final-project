package polis.mail.ru;

import org.junit.Test;

import java.util.List;

import static polis.mail.ru.constant.Users.suhova;

public class FollowersTest extends AbstractTest {

    @Test
    public void checkFollowers() {
        navigationSteps
                .openFollowersPage()
                .waitPageIsLoaded()
                .checkFollowersList(List.of(suhova.getName()));
    }
}
