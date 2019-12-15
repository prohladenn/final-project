package polis.mail.ru.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Type {
    All,
    Sources,
    Forks,
    Archived,
    Mirrors;

    public static List<String> types() {
        return Arrays.stream(Type.values()).map(Enum::toString).collect(Collectors.toList());
    }
}
