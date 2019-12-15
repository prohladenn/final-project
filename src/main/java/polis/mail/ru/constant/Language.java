package polis.mail.ru.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Language {
    ALL("All"),
    JAVA("Java"),
    SCALA("Scala"),
    KOTLIN("Kotlin"),
    JS("JavaScript"),
    CPP("C++"),
    CSS("CSS"),
    C_SHARP("C#");

    private String name;

    Language(String name) {
        this.name = name;
    }

    public static List<String> languages() {
        return Arrays.stream(Language.values()).map(Language::getName).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
