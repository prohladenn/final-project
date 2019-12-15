package polis.mail.ru;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class OverviewTest extends AbstractTest {

    @Test
    public void checkUserInfo() {
        final String expectedName = "Valery Kovshov";
        final String expectedNickname = "prohladenn";
        assertThat(onMainPage().name().waitUntil(displayed()).getText(), equalTo(expectedName));
        assertThat(onMainPage().nickname().waitUntil(displayed()).getText(), equalTo(expectedNickname));
    }
}
