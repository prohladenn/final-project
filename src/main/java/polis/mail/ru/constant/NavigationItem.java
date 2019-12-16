package polis.mail.ru.constant;

public enum NavigationItem {
    Overview("overview"),
    Repositories("repositories"),
    Projects("projects"),
    Stars("stars"),
    Followers("followers"),
    Following("following");

    private String itemName;

    NavigationItem(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
