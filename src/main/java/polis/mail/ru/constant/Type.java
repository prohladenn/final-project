package polis.mail.ru.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Type {
    All("all"),
    Sources("source"),
    Forks("fork"),
    Archived("archived"),
    Mirrors("mirror");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public static List<String> types() {
        return Arrays.stream(Type.values()).map(Enum::toString).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
