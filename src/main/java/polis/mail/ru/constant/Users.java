package polis.mail.ru.constant;

public enum Users {
    prohladenn("Valery Kovshov"),
    suhova("Darya Suhova");

    private String name;

    Users(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
