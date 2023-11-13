package christmas.Global;

public enum MenuType {
    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료");

    public final String name;

    private MenuType(String name) {
        this.name = name;
    }
}
