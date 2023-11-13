package christmas.Global;

public enum Badge {
    별(5000),
    트리(10000),
    산타(20000);

    public int price;

    private Badge(int price) {
        this.price = price;
    }
}
