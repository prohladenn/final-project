package polis.mail.ru;

import io.qameta.atlas.webdriver.AtlasWebElement;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static polis.mail.ru.constant.NavigationItem.Followers;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class FollowersTest extends AbstractTest {

    @Test
    public void checkFollowers() {
        onMainPage().userProfileNavigation(Followers).waitUntil(displayed()).click();
        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() -> {
            List<AtlasWebElement> repositories = onFollowersPage().listUsers();
            assertThat(repositories, hasSize(1));
            assertThat(repositories.get(0).getText(), containsString("Darya Suhova"));
        });
    }
}
