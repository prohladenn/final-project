package polis.mail.ru;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> toListString(ElementsCollection<AtlasWebElement> collection) {
        List<String> ans = new ArrayList<>();
        for (AtlasWebElement element : collection) {
            ans.add(element.getText());
        }
        return ans;
    }

}
